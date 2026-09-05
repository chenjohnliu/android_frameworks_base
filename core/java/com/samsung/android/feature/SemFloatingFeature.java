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
import android.util.Log;
import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;

/** @hide */
public final class SemFloatingFeature implements IFloatingFeature {
    private static final String TAG = "SemFloatingFeature";
    private static final String FEATURE_FILE = "/system/etc/floating_feature.xml";
    private static final boolean LOG_ENABLED =
            !SystemProperties.getBoolean("ro.product_ship", false);
    private static final SemFloatingFeature INSTANCE = new SemFloatingFeature();

    private final Hashtable<String, String> mFeatureList = new Hashtable<>();

    private SemFloatingFeature() {
        loadFeatureFile();
    }

    public static SemFloatingFeature getInstance() {
        return INSTANCE;
    }

    private void loadFeatureFile() {
        try (FileInputStream input = new FileInputStream(FEATURE_FILE)) {
            XmlPullParser parser = Xml.newPullParser();
            parser.setInput(input, "UTF-8");
            int event = parser.getEventType();
            while (event != XmlPullParser.END_DOCUMENT) {
                if (event == XmlPullParser.START_TAG && parser.getDepth() > 1) {
                    String key = parser.getName();
                    event = parser.next();
                    if (event == XmlPullParser.TEXT) {
                        mFeatureList.put(key, parser.getText().trim());
                    }
                }
                event = parser.next();
            }
        } catch (IOException | XmlPullParserException e) {
            mFeatureList.clear();
            loge(e);
        }
    }

    private static void loge(Object message) {
        if (LOG_ENABLED) {
            Log.e(TAG, String.valueOf(message));
        }
    }

    private static void logw(Object message) {
        if (LOG_ENABLED) {
            Log.w(TAG, String.valueOf(message));
        }
    }

    private String getFeature(String key) {
        if (key == null) {
            return null;
        }
        return mFeatureList.get(key);
    }

    @Override
    public boolean getBoolean(String key) {
        String value = getFeature(key);
        return value != null && !value.isEmpty() && Boolean.parseBoolean(value);
    }

    @Override
    @Deprecated
    public boolean getBoolean(String key, boolean def) {
        if (key == null) {
            return false;
        }
        String value = getFeature(key);
        return value == null || value.isEmpty() ? def : Boolean.parseBoolean(value);
    }

    @Override
    public int getInt(String key) {
        String value = getFeature(key);
        if (value == null || value.isEmpty()) {
            return -1;
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            logw(e);
            return -1;
        }
    }

    @Override
    @Deprecated
    public int getInt(String key, int def) {
        if (key == null) {
            return def;
        }
        String value = getFeature(key);
        if (value == null || value.isEmpty()) {
            return def;
        }
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            logw(e);
            return def;
        }
    }

    public int getInteger(String key) {
        return getInt(key);
    }

    @Deprecated
    public int getInteger(String key, int def) {
        return getInt(key, def);
    }

    @Override
    public String getString(String key) {
        String value = getFeature(key);
        return value == null || value.isEmpty() ? "" : value;
    }

    @Override
    @Deprecated
    public String getString(String key, String def) {
        if (key == null) {
            return "";
        }
        String value = getFeature(key);
        return value == null || value.isEmpty() ? def : value;
    }
}
