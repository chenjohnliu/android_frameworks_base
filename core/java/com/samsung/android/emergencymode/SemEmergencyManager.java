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

package com.samsung.android.emergencymode;

import android.content.Context;
import android.os.UserHandle;
import android.provider.Settings;

/**
 * Minimal compatibility surface for the Samsung IMS client.
 *
 * <p>Cherish does not provide Samsung's {@code IEmergencyManager} binder
 * service.  Consequently, {@link #checkModeType(int)} deliberately reports
 * that no Samsung emergency mode is active instead of fabricating a service
 * or attempting an unverified mode transition.</p>
 *
 * @hide
 */
public class SemEmergencyManager {
    private static final String EMERGENCY_MODE = "emergency_mode";

    private static volatile SemEmergencyManager sInstance;

    private final Context mContext;

    private SemEmergencyManager(Context context) {
        mContext = context == null ? null : context.getApplicationContext();
    }

    /**
     * Returns the process singleton used by the IMS client.
     *
     * @hide
     */
    public static SemEmergencyManager getInstance(Context context) {
        SemEmergencyManager instance = sInstance;
        if (instance == null) {
            synchronized (SemEmergencyManager.class) {
                instance = sInstance;
                if (instance == null) {
                    instance = new SemEmergencyManager(context);
                    sInstance = instance;
                }
            }
        }
        return instance;
    }

    /**
     * Reads the current user's emergency-mode setting.
     *
     * <p>A missing setting, denied access, or unavailable resolver is treated
     * as inactive, matching the conservative behavior required by IMS
     * startup.</p>
     *
     * @hide
     */
    public static boolean isEmergencyMode(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return Settings.System.getIntForUser(context.getContentResolver(),
                    EMERGENCY_MODE, UserHandle.USER_CURRENT) == 1;
        } catch (Settings.SettingNotFoundException e) {
            return false;
        } catch (RuntimeException e) {
            // Includes SecurityException and resolver/runtime failures.
            return false;
        }
    }

    /**
     * Conservative fallback because the Samsung emergency-mode binder is not
     * available on this target.  No binder service is registered or called.
     *
     * @hide
     */
    public boolean checkModeType(int modeType) {
        return false;
    }
}
