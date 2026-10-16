/*
 * Copyright (C) 2026 The Android Open Source Project
 * Licensed under the Apache License, Version 2.0.
 */

package com.samsung.android.ims.options;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/** @hide */
public class SemCapabilities implements Parcelable {
    private long mAvailableFeatures;
    private String mBotServiceId;
    private List<String> mExtFeatures;
    private long mFeatures;
    private boolean mIsAvailable;
    private boolean mIsExpired;
    private boolean mIsLegacyLatching;
    private Date mTimestamp;

    public static final Parcelable.Creator<SemCapabilities> CREATOR =
            new Parcelable.Creator<SemCapabilities>() {
                @Override
                public SemCapabilities createFromParcel(Parcel source) {
                    return new SemCapabilities(source);
                }

                @Override
                public SemCapabilities[] newArray(int size) {
                    return new SemCapabilities[size];
                }
            };

    private SemCapabilities(Parcel source) {
        mIsAvailable = source.readInt() != 0;
        mFeatures = source.readLong();
        mAvailableFeatures = source.readLong();
        mIsExpired = source.readInt() != 0;
        mIsLegacyLatching = source.readInt() != 0;
        mTimestamp = source.readInt() != 0 ? new Date(source.readLong()) : null;
        mBotServiceId = source.readString();
        mExtFeatures = new ArrayList<>();
        source.readStringList(mExtFeatures);
    }

    private SemCapabilities(Builder builder) {
        mAvailableFeatures = builder.mAvailableFeatures;
        mBotServiceId = builder.mBotServiceId;
        mExtFeatures = builder.mExtFeatures == null
                ? new ArrayList<>() : new ArrayList<>(builder.mExtFeatures);
        mFeatures = builder.mFeatures;
        mIsAvailable = builder.mIsAvailable;
        mIsExpired = builder.mIsExpired;
        mIsLegacyLatching = builder.mIsLegacyLatching;
        mTimestamp = builder.mTimestamp;
    }

    public Builder getBuilder() {
        return new Builder()
                .setAvailableFeatures(mAvailableFeatures)
                .setBotServiceId(mBotServiceId)
                .setExtFeature(mExtFeatures)
                .setFeature(mFeatures)
                .setIsAvailable(mIsAvailable)
                .setIsExpired(mIsExpired)
                .setLegacyLatching(mIsLegacyLatching)
                .setTimestamp(mTimestamp);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mIsAvailable ? 1 : 0);
        dest.writeLong(mFeatures);
        dest.writeLong(mAvailableFeatures);
        dest.writeInt(mIsExpired ? 1 : 0);
        dest.writeInt(mIsLegacyLatching ? 1 : 0);
        if (mTimestamp != null) {
            dest.writeInt(1);
            dest.writeLong(mTimestamp.getTime());
        } else {
            dest.writeInt(0);
        }
        dest.writeString(mBotServiceId);
        dest.writeStringList(mExtFeatures);
    }

    /** @hide */
    public static class Builder {
        private long mAvailableFeatures;
        private String mBotServiceId;
        private List<String> mExtFeatures;
        private long mFeatures;
        private boolean mIsAvailable;
        private boolean mIsExpired;
        private boolean mIsLegacyLatching;
        private Date mTimestamp;

        public Builder setAvailableFeatures(long availableFeatures) {
            mAvailableFeatures = availableFeatures;
            return this;
        }

        public Builder setBotServiceId(String botServiceId) {
            mBotServiceId = botServiceId;
            return this;
        }

        public Builder setExtFeature(List<String> extFeatures) {
            mExtFeatures = extFeatures;
            return this;
        }

        public Builder setFeature(long features) {
            mFeatures = features;
            return this;
        }

        public Builder setIsAvailable(boolean isAvailable) {
            mIsAvailable = isAvailable;
            return this;
        }

        public Builder setIsExpired(boolean isExpired) {
            mIsExpired = isExpired;
            return this;
        }

        public Builder setLegacyLatching(boolean legacyLatching) {
            mIsLegacyLatching = legacyLatching;
            return this;
        }

        public Builder setTimestamp(Date timestamp) {
            mTimestamp = timestamp;
            return this;
        }

        public SemCapabilities build() {
            return new SemCapabilities(this);
        }
    }
}
