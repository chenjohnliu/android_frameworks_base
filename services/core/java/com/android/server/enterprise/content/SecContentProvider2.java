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

package com.android.server.enterprise.content;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;

/**
 * Minimal compatibility provider for IMS's MDM RCS status query.
 *
 * <p>Cherish does not carry Samsung's Knox enterprise policy backend. The
 * provider deliberately implements only the exact query used by the stock
 * M115F IMS service and treats the absent enterprise restriction as allowed.
 * This is an accepted compatibility deviation from the full Knox provider;
 * it does not claim to implement any other Knox policy.</p>
 *
 * @hide
 */
public final class SecContentProvider2 extends ContentProvider {

    private static final String AUTHORITY = "com.sec.knox.provider2";
    private static final String PHONE_RESTRICTION_POLICY = "PhoneRestrictionPolicy";
    private static final String RCS_ENABLED = "isRCSEnabled";
    private static final int PHONE_RESTRICTION = 0x12;

    private static final UriMatcher URI_MATCHER = new UriMatcher(UriMatcher.NO_MATCH);

    static {
        URI_MATCHER.addURI(AUTHORITY, PHONE_RESTRICTION_POLICY, PHONE_RESTRICTION);
    }

    @Override
    public boolean onCreate() {
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
            String[] selectionArgs, String sortOrder) {
        if (uri == null || URI_MATCHER.match(uri) != PHONE_RESTRICTION
                || !RCS_ENABLED.equals(selection)
                || selectionArgs == null || selectionArgs.length < 3
                || selectionArgs[1] == null
                || !("true".equalsIgnoreCase(selectionArgs[1])
                        || "false".equalsIgnoreCase(selectionArgs[1]))) {
            return null;
        }

        try {
            Integer.parseInt(selectionArgs[0]);
            Boolean.parseBoolean(selectionArgs[1]);
            Integer.parseInt(selectionArgs[2]);
        } catch (RuntimeException e) {
            return null;
        }

        final MatrixCursor cursor = new MatrixCursor(new String[] {RCS_ENABLED});
        cursor.addRow(new Object[] {Boolean.TRUE});
        return cursor;
    }

    @Override
    public String getType(Uri uri) {
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        return null;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
            String[] selectionArgs) {
        return 0;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        return 0;
    }
}
