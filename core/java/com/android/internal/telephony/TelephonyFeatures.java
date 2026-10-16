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

package com.android.internal.telephony;

import android.os.SystemProperties;

import com.samsung.android.feature.SemCarrierFeature;

/** Minimal Samsung IMS compatibility surface for SM-M115F CWK3. @hide */
public class TelephonyFeatures {
    private static final String NETWORK_TYPE_CAPABILITY =
            "CarrierFeature_RIL_ConfigNetworkTypeCapability";
    private static final int MAIN_OPERATOR_INDEX = 0;
    private static final int OPERATOR_TYPE_INDEX = 2;
    private static final int COUNTRY_INDEX = 3;

    public static final boolean SHIP_BUILD =
            SystemProperties.getBoolean("ro.product_ship", true);

    public TelephonyFeatures() {}

    public static String getMainOperatorName(int phoneId) {
        return getCapabilityPart(phoneId, MAIN_OPERATOR_INDEX);
    }

    public static boolean isChnGlobalModel(int phoneId) {
        if (!"GLB".equals(getCapabilityPart(phoneId, OPERATOR_TYPE_INDEX))) {
            return false;
        }
        final String country = getCapabilityPart(phoneId, COUNTRY_INDEX);
        return "CHN".equals(country) || "HKG".equals(country) || "TPE".equals(country);
    }

    private static String getCapabilityPart(int phoneId, int index) {
        final String capability = SemCarrierFeature.getInstance().getString(
                phoneId, NETWORK_TYPE_CAPABILITY, "", true);
        if (capability == null || capability.length() != 15 || index < 0 || index > 3) {
            return "---";
        }
        final String[] parts = capability.split("-");
        if (parts.length != 4) {
            return "---";
        }
        return parts[index];
    }
}
