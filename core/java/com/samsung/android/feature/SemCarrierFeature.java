package com.samsung.android.feature;

import android.os.SystemProperties;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Minimal SM-M115F CWK3 carrier-feature compatibility surface.
 *
 * @hide
 */
public class SemCarrierFeature {
    private static final String LOG_TAG = SemCarrierFeature.class.getSimpleName();
    private static final String FEATURE_PATH =
            "/system/etc/m11q/customer_carrier_feature.json";
    private static final String FEATURE_GROUP = "BRI";
    private static final int UNKNOWN_CARRIER_ID = -1;

    private static SemCarrierFeature sInstance;

    private final Map<Integer, Map<String, String>> mDefaultFeatureList =
            new LinkedHashMap<>();
    private final Map<Integer, Map<String, String>> mLastFeatureList =
            new LinkedHashMap<>();
    private final Map<Integer, Integer> mSimTargetCanonicalIds =
            new LinkedHashMap<>();
    private final Map<Integer, Map<String, String>> mSpecificFeatureList =
            new LinkedHashMap<>();

    private SemCarrierFeature() {
        final Map<String, String> defaults = new LinkedHashMap<>();
        try {
            loadFeatureFile(defaults, mSpecificFeatureList);
        } catch (IOException | JSONException e) {
            Log.e(LOG_TAG, "Unable to load the M115F carrier feature table", e);
        }

        for (int phoneId = 0; phoneId < 2; phoneId++) {
            mDefaultFeatureList.put(phoneId,
                    Collections.unmodifiableMap(new LinkedHashMap<>(defaults)));
            reloadLastFeatures(phoneId);
        }
    }

    public static SemCarrierFeature createInstance() {
        sInstance = new SemCarrierFeature();
        return sInstance;
    }

    public static SemCarrierFeature getInstance() {
        if (sInstance == null) {
            sInstance = new SemCarrierFeature();
        }
        return sInstance;
    }

    public boolean getBoolean(int phoneId, String key, boolean defaultValue,
            boolean checkLastSim) {
        try {
            final String value = get(phoneId, key, checkLastSim);
            return value != null ? Boolean.parseBoolean(value) : defaultValue;
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public boolean[] getBooleanArray(int phoneId, String key, boolean checkLastSim) {
        try {
            final String value = get(phoneId, key, checkLastSim);
            if (value == null) return null;
            final String[] values = value.split(",");
            final boolean[] result = new boolean[values.length];
            for (int i = 0; i < values.length; i++) {
                result[i] = Boolean.parseBoolean(values[i].trim());
            }
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    public int getCarrierId(int phoneId, boolean checkLastSim) {
        final String suffix = phoneId == 0 ? "" : Integer.toString(phoneId + 1);
        final String key = (checkLastSim ? "persist.sys.sec_pcid" : "mdc.sys.sec_pcid")
                + suffix;
        return SystemProperties.getInt(key, UNKNOWN_CARRIER_ID);
    }

    public double getDouble(int phoneId, String key, double defaultValue,
            boolean checkLastSim) {
        try {
            final String value = get(phoneId, key, checkLastSim);
            return value != null ? Double.parseDouble(value) : defaultValue;
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public double[] getDoubleArray(int phoneId, String key, boolean checkLastSim) {
        try {
            final String value = get(phoneId, key, checkLastSim);
            if (value == null) return null;
            final String[] values = value.split(",");
            final double[] result = new double[values.length];
            for (int i = 0; i < values.length; i++) {
                result[i] = Double.parseDouble(values[i].trim());
            }
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    public int getInt(int phoneId, String key, int defaultValue, boolean checkLastSim) {
        try {
            final String value = get(phoneId, key, checkLastSim);
            return value != null ? Integer.parseInt(value) : defaultValue;
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public int[] getIntArray(int phoneId, String key, boolean checkLastSim) {
        try {
            final String value = get(phoneId, key, checkLastSim);
            if (value == null) return null;
            final String[] values = value.split(",");
            final int[] result = new int[values.length];
            for (int i = 0; i < values.length; i++) {
                result[i] = Integer.parseInt(values[i].trim());
            }
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    public long getLong(int phoneId, String key, long defaultValue, boolean checkLastSim) {
        try {
            final String value = get(phoneId, key, checkLastSim);
            return value != null ? Long.parseLong(value) : defaultValue;
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public long[] getLongArray(int phoneId, String key, boolean checkLastSim) {
        try {
            final String value = get(phoneId, key, checkLastSim);
            if (value == null) return null;
            final String[] values = value.split(",");
            final long[] result = new long[values.length];
            for (int i = 0; i < values.length; i++) {
                result[i] = Long.parseLong(values[i].trim());
            }
            return result;
        } catch (Exception e) {
            return null;
        }
    }

    public String getString(int phoneId, String key, String defaultValue,
            boolean checkLastSim) {
        try {
            final String value = get(phoneId, key, checkLastSim);
            return value != null ? value : defaultValue;
        } catch (Exception e) {
            return defaultValue;
        }
    }

    public String[] getStringArray(int phoneId, String key, boolean checkLastSim) {
        try {
            final String value = get(phoneId, key, checkLastSim);
            return value != null ? value.split(",") : null;
        } catch (Exception e) {
            return null;
        }
    }

    public Map<String, String> tracer(int tableNumber) {
        switch (tableNumber) {
            case 0:
                return mLastFeatureList.get(0);
            case 1:
                return mLastFeatureList.get(1);
            case 2:
                return mDefaultFeatureList.get(0);
            case 3:
                return mDefaultFeatureList.get(1);
            default:
                return null;
        }
    }

    private String get(int phoneId, String key, boolean checkLastSim) {
        if (phoneId != 0 && phoneId != 1) return null;

        final int lastCarrierId = getCarrierId(phoneId, true);
        final Integer loadedCarrierId = mSimTargetCanonicalIds.get(phoneId);
        if (loadedCarrierId == null || loadedCarrierId != lastCarrierId) {
            reloadLastFeatures(phoneId);
        }

        if (lastCarrierId > UNKNOWN_CARRIER_ID && checkLastSim) {
            return mLastFeatureList.get(phoneId).get(key);
        }
        if (lastCarrierId != UNKNOWN_CARRIER_ID
                && lastCarrierId != getCarrierId(phoneId, false)) {
            return mLastFeatureList.get(phoneId).get(key);
        }
        return mDefaultFeatureList.get(phoneId).get(key);
    }

    private void reloadLastFeatures(int phoneId) {
        final int carrierId = getCarrierId(phoneId, true);
        final Map<String, String> merged = new LinkedHashMap<>();
        final Map<String, String> defaults = mDefaultFeatureList.get(phoneId);
        if (defaults != null) merged.putAll(defaults);
        final Map<String, String> specific = mSpecificFeatureList.get(carrierId);
        if (specific != null) merged.putAll(specific);
        mSimTargetCanonicalIds.put(phoneId, carrierId);
        mLastFeatureList.put(phoneId, Collections.unmodifiableMap(merged));
    }

    private static void loadFeatureFile(Map<String, String> defaults,
            Map<Integer, Map<String, String>> specifics) throws IOException, JSONException {
        final JSONObject root = new JSONObject(readUtf8(FEATURE_PATH));
        final JSONArray customers = root.getJSONArray("customer");
        for (int i = 0; i < customers.length(); i++) {
            final JSONObject customer = customers.getJSONObject(i);
            if (FEATURE_GROUP.equals(customer.getString("carrier_group"))) {
                putFeatures(defaults, customer.getJSONObject("feature"));
                break;
            }
        }

        final JSONArray entries = root.optJSONArray("specific");
        if (entries == null) return;
        for (int i = 0; i < entries.length(); i++) {
            final JSONObject entry = entries.getJSONObject(i);
            final Map<String, String> values = new LinkedHashMap<>();
            putFeatures(values, entry.getJSONObject("feature"));
            specifics.put(entry.getInt("canonical_id"), Collections.unmodifiableMap(values));
        }
    }

    private static void putFeatures(Map<String, String> target, JSONObject source)
            throws JSONException {
        final Iterator<String> keys = source.keys();
        while (keys.hasNext()) {
            final String key = keys.next();
            target.put(key, source.getString(key));
        }
    }

    private static String readUtf8(String path) throws IOException {
        try (FileInputStream input = new FileInputStream(path);
                ByteArrayOutputStream output = new ByteArrayOutputStream()) {
            final byte[] buffer = new byte[4096];
            int count;
            while ((count = input.read(buffer)) != -1) {
                output.write(buffer, 0, count);
            }
            return new String(output.toByteArray(), StandardCharsets.UTF_8);
        }
    }
}
