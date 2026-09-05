/*
 * Copyright (C) 2026 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.samsung.android.feature;

import android.os.SystemProperties;
import android.util.Base64;
import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Hashtable;
import java.util.zip.GZIPInputStream;

/** @hide */
public final class SemCscFeature {
    private static final String TAG = "SemCscFeature";
    private static final String FEATURE_FILE = "/system/csc/cscfeature.xml";
    private static final boolean LOG_ENABLED =
            !SystemProperties.getBoolean("ro.product_ship", false);

    /* Exact CWK3 classes5.dex constructor fill-array-data payloads. */
    private static final String SALTS_BASE64 =
            "QcUh3msclTdOEa8GsIfd6Uh6wdVEd7KRxB88OVyonLuWW0VdbhddNdTNQLAuAvwM01DU3ZHkvownAuXTzH0nQqY/l71Ux/z8ZaZRCt8BQ8e5ErZmYKdA7zairL4Od3kCsrFZP11tss1C3CBWA8bxXDoCp7Dz/3r8MD/UO2TW0zv578oiykfA5qmw79TakEYKll/o/Iotq/NVGZqJDdt0Lrs7Kqbal2WJ3GH9wqWfgxEOariJY28UEuVxQOhKxJwaONS6DM2c4PUaMItiozPnseFhV5fAB/ObIYYFmFnUiz+w+rmS45d0a6Nb1/MUjbIrT4YGZuA0is1ImCnafEiC3Q==";
    private static final String SHIFTS_BASE64 =
            "AQEAAgIEBQAEBwEGBQMDAQIFAAYCAgQCAgMAAgECBAMEAAAAAwUDAQYFBgEBAQAAAwIHBwUGBwMFAQAHBgMGBQQFAwUBAwMBBQQBAAACBgYGBgQAAQEABQUEAgQGAQcBAgEBBgUEBwYFAQYHAAIGAwEHAQEHBAAEAgUDAQEFBgADBQMGBQcCBQYGAgIDBgAEAwIAAgIDBQMDAgUFBQEDAQEBBAUBBgIEBwEEBgAGBAMCBgEGAwIBBgcDAgEBBQYHAgICBwQGBwUDAQQCBwEGAgQBBQYFBAUAAQEGAwcCAAIFAAEDAwIGBwcCBQYABAECBQMHBgUCBQIAAQMBBAMEAg==";
    private static final byte[] SALTS = Base64.decode(SALTS_BASE64, Base64.DEFAULT);
    private static final byte[] SHIFTS = Base64.decode(SHIFTS_BASE64, Base64.DEFAULT);
    private static final SemCscFeature INSTANCE = new SemCscFeature();

    private final Hashtable<String, String> mFeatureList = new Hashtable<>();

    private SemCscFeature() {
        loadFeatureFile();
    }

    public static SemCscFeature getInstance() {
        return INSTANCE;
    }

    private void loadFeatureFile() {
        try (FileInputStream input = new FileInputStream(FEATURE_FILE)) {
            byte[] file = readAll(input);
            byte[] xml = isPlainXml(file) ? file : decompress(decode(file));
            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(new ByteArrayInputStream(xml), StandardCharsets.UTF_8.name());
            int event = parser.getEventType();
            while (event != XmlPullParser.END_DOCUMENT) {
                if (event == XmlPullParser.START_TAG && parser.getDepth() > 1) {
                    String name = parser.getName();
                    event = parser.next();
                    if (event == XmlPullParser.TEXT) {
                        String value = parser.getText();
                        if (value != null && !value.trim().isEmpty()) {
                            mFeatureList.put(name, value.trim());
                        }
                    }
                }
                event = parser.next();
            }
        } catch (IOException | XmlPullParserException | RuntimeException e) {
            mFeatureList.clear();
            logw(e);
        }
    }

    private static byte[] readAll(FileInputStream input) throws IOException {
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int count;
        while ((count = input.read(buffer)) != -1) {
            output.write(buffer, 0, count);
        }
        return output.toByteArray();
    }

    private static boolean isPlainXml(byte[] file) {
        int length = Math.min(file.length, 128);
        String header = new String(file, 0, length, StandardCharsets.UTF_8);
        return header.contains("<?xml");
    }

    private static byte[] decode(byte[] input) {
        if (SALTS.length != 256 || SHIFTS.length != 256) {
            throw new IllegalStateException("Invalid SemCscFeature decode tables");
        }
        byte[] output = new byte[input.length];
        for (int i = 0; i < input.length; i++) {
            int value = input[i] & 0xff;
            int shift = SHIFTS[i & 0xff] & 0xff;
            int rotated = (value << shift) | (value >>> (8 - shift));
            output[i] = (byte) (rotated ^ (SALTS[i & 0xff] & 0xff));
        }
        return output;
    }

    private static byte[] decompress(byte[] input) throws IOException {
        try (GZIPInputStream gzip = new GZIPInputStream(new ByteArrayInputStream(input))) {
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buffer = new byte[4096];
            int count;
            while ((count = gzip.read(buffer)) != -1) {
                output.write(buffer, 0, count);
            }
            return output.toByteArray();
        }
    }

    private String getFeature(String key) {
        return key == null ? null : mFeatureList.get(key);
    }

    public boolean getBoolean(int slot, String key) {
        return getBoolean(key);
    }

    public boolean getBoolean(int slot, String key, boolean def) {
        return getBoolean(key, def);
    }

    public boolean getBoolean(String key) {
        String value = getFeature(key);
        return value != null && Boolean.parseBoolean(value);
    }

    public boolean getBoolean(String key, boolean def) {
        String value = getFeature(key);
        return value == null ? def : Boolean.parseBoolean(value);
    }

    public int getInt(int slot, String key) {
        return getInt(key);
    }

    public int getInt(int slot, String key, int def) {
        return getInt(key, def);
    }

    public int getInt(String key) {
        return parseInt(getFeature(key), -1);
    }

    public int getInt(String key, int def) {
        return parseInt(getFeature(key), def);
    }

    public int getInteger(int slot, String key) {
        return getInt(key);
    }

    public int getInteger(int slot, String key, int def) {
        return getInt(key, def);
    }

    public int getInteger(String key) {
        return getInt(key);
    }

    public int getInteger(String key, int def) {
        return getInt(key, def);
    }

    public String getString(int slot, String key) {
        return getString(key);
    }

    public String getString(int slot, String key, String def) {
        return getString(key, def);
    }

    public String getString(String key) {
        String value = getFeature(key);
        return value == null ? "" : value;
    }

    public String getString(String key, String def) {
        String value = getFeature(key);
        return value == null ? def : value;
    }

    private static int parseInt(String value, int def) {
        if (value == null) {
            return def;
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            logw(e);
            return def;
        }
    }

    private static void logw(Object message) {
        if (LOG_ENABLED) {
            Log.w(TAG, String.valueOf(message));
        }
    }
}
