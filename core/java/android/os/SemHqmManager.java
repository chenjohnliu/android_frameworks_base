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

/**
 * Minimal compatibility surface for Samsung HQM telemetry.
 *
 * <p>HQM telemetry is unavailable on AOSP, so submissions are ignored.</p>
 *
 * @hide
 */
public class SemHqmManager {
    /**
     * Accepts an HQM hardware parameter submission without sending telemetry.
     *
     * @hide
     */
    public boolean sendHWParamToHQM(int type, String id, String feature, String hitType,
            String version, String manufacturer, String devCustomDataSet,
            String customDataSet, String privateDataSet) {
        return false;
    }
}
