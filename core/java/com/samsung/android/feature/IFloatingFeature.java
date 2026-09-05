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

/** @hide */
public interface IFloatingFeature {
    boolean getBoolean(String key);

    /** @deprecated Use {@link #getBoolean(String)} when no default is needed. */
    @Deprecated
    boolean getBoolean(String key, boolean def);

    int getInt(String key);

    /** @deprecated Use {@link #getInt(String)} when no default is needed. */
    @Deprecated
    int getInt(String key, int def);

    String getString(String key);

    /** @deprecated Use {@link #getString(String)} when no default is needed. */
    @Deprecated
    String getString(String key, String def);
}
