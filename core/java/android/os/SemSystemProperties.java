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

package android.os;

/** @hide */
public class SemSystemProperties {
    private SemSystemProperties() {
    }

    public static String get(String key) {
        return SystemProperties.get(key);
    }

    public static String get(String key, String def) {
        return SystemProperties.get(key, def);
    }

    public static int getInt(String key, int def) {
        return SystemProperties.getInt(key, def);
    }

    public static long getLong(String key, long def) {
        return SystemProperties.getLong(key, def);
    }

    public static boolean getBoolean(String key, boolean def) {
        return SystemProperties.getBoolean(key, def);
    }

    public static void set(String key, String value) {
        SystemProperties.set(key, value);
    }

    @Deprecated
    public static String getDeviceSerialNumber() {
        return SystemProperties.get("ril.serialnumber", "00000000000");
    }

    public static String getSalesCode() {
        return SystemProperties.get("ro.csc.sales_code", "");
    }

    public static String getCountryCode() {
        return SystemProperties.get("ro.csc.country_code", "");
    }

    public static String getCountryIso() {
        return SystemProperties.get("ro.csc.countryiso_code", "");
    }
}
