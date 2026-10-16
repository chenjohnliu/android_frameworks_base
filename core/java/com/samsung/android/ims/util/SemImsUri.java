/*
 * Copyright (C) 2026 The Android Open Source Project
 * Licensed under the Apache License, Version 2.0.
 */

package com.samsung.android.ims.util;

import android.os.Parcel;
import android.os.Parcelable;

/** @hide */
public class SemImsUri implements Parcelable {
    private String mMsisdn;
    private String mScheme;
    private String mUriToString;
    private UriType mUriType;
    private String mUser;

    public static final Parcelable.Creator<SemImsUri> CREATOR =
            new Parcelable.Creator<SemImsUri>() {
                @Override
                public SemImsUri createFromParcel(Parcel source) {
                    return new SemImsUri(source);
                }

                @Override
                public SemImsUri[] newArray(int size) {
                    return new SemImsUri[size];
                }
            };

    public SemImsUri() {
    }

    private SemImsUri(Parcel source) {
        readFromParcel(source);
    }

    private void readFromParcel(Parcel source) {
        mUser = source.readString();
        mMsisdn = source.readString();
        String uriType = source.readString();
        mUriType = uriType == null ? null : UriType.valueOf(uriType);
        mScheme = source.readString();
        mUriToString = source.readString();
    }

    public String getMsisdn() {
        return mMsisdn;
    }

    public String getScheme() {
        return mScheme;
    }

    public UriType getUriType() {
        return mUriType;
    }

    public String getUser() {
        return mUser;
    }

    public void setMsisdn(String msisdn) {
        mMsisdn = msisdn;
    }

    public void setScheme(String scheme) {
        mScheme = scheme;
    }

    public void setString(String string) {
        mUriToString = string;
    }

    public void setUriType(String uriType) {
        mUriType = uriType == null ? null : UriType.valueOf(uriType);
    }

    public void setUser(String user) {
        mUser = user;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mUser);
        dest.writeString(mMsisdn);
        dest.writeString(mUriType == null ? null : mUriType.name());
        dest.writeString(mScheme);
        dest.writeString(mUriToString);
    }

    public enum UriType {
        SIP_URI,
        TEL_URI,
        URN
    }
}
