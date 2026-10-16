package com.samsung.android.ims.cmc;

import android.os.Parcel;
import android.os.Parcelable;

public class SemCmcRecordingInfo implements Parcelable {
    public static final Parcelable.Creator<SemCmcRecordingInfo> CREATOR =
            new Parcelable.Creator<SemCmcRecordingInfo>() {
                @Override
                public SemCmcRecordingInfo createFromParcel(Parcel source) {
                    return new SemCmcRecordingInfo(source);
                }

                @Override
                public SemCmcRecordingInfo[] newArray(int size) {
                    return new SemCmcRecordingInfo[size];
                }
            };

    int mAudioChannels;
    int mAudioEncoder;
    int mAudioEncodingBitRate;
    int mAudioSamplingRate;
    int mAudioSource;
    String mAuthor;
    int mDurationInterval;
    long mFileSizeInterval;
    int mMaxDuration;
    long mMaxFileSize;
    int mOutputFormat;
    String mOutputPath;

    public SemCmcRecordingInfo() {}

    public SemCmcRecordingInfo(Parcel source) {
        readFromParcel(source);
    }

    private void readFromParcel(Parcel source) {
        mAudioSource = source.readInt();
        mOutputFormat = source.readInt();
        mMaxFileSize = source.readLong();
        mMaxDuration = source.readInt();
        mOutputPath = source.readString();
        mAudioEncodingBitRate = source.readInt();
        mAudioChannels = source.readInt();
        mAudioSamplingRate = source.readInt();
        mAudioEncoder = source.readInt();
        mDurationInterval = source.readInt();
        mFileSizeInterval = source.readLong();
        mAuthor = source.readString();
    }

    public int getAudioChannels() { return mAudioChannels; }
    public int getAudioEncoder() { return mAudioEncoder; }
    public int getAudioEncodingBitRate() { return mAudioEncodingBitRate; }
    public int getAudioSamplingRate() { return mAudioSamplingRate; }
    public int getAudioSource() { return mAudioSource; }
    public String getAuthor() { return mAuthor; }
    public int getDurationInterval() { return mDurationInterval; }
    public long getFileSizeInterval() { return mFileSizeInterval; }
    public int getMaxDuration() { return mMaxDuration; }
    public long getMaxFileSize() { return mMaxFileSize; }
    public int getOutputFormat() { return mOutputFormat; }
    public String getOutputPath() { return mOutputPath; }

    public void setAudioChannels(int value) { mAudioChannels = value; }
    public void setAudioEncoder(int value) { mAudioEncoder = value; }
    public void setAudioEncodingBitRate(int value) { mAudioEncodingBitRate = value; }
    public void setAudioSamplingRate(int value) { mAudioSamplingRate = value; }
    public void setAudioSource(int value) { mAudioSource = value; }
    public void setAuthor(String value) { mAuthor = value; }
    public void setDurationInterval(int value) { mDurationInterval = value; }
    public void setFileSizeInterval(long value) { mFileSizeInterval = value; }
    public void setMaxDuration(int value) { mMaxDuration = value; }
    public void setMaxFileSize(long value) { mMaxFileSize = value; }
    public void setOutputFormat(int value) { mOutputFormat = value; }
    public void setOutputPath(String value) { mOutputPath = value; }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mAudioSource);
        dest.writeInt(mOutputFormat);
        dest.writeLong(mMaxFileSize);
        dest.writeInt(mMaxDuration);
        dest.writeString(mOutputPath);
        dest.writeInt(mAudioEncodingBitRate);
        dest.writeInt(mAudioChannels);
        dest.writeInt(mAudioSamplingRate);
        dest.writeInt(mAudioEncoder);
        dest.writeInt(mDurationInterval);
        dest.writeLong(mFileSizeInterval);
        dest.writeString(mAuthor);
    }

    @Override
    public String toString() {
        return "SemCmcRecordingInfo = {mAudioSource : " + mAudioSource
                + ", mOutputFormat : " + mOutputFormat
                + ", mMaxFileSize : " + mMaxFileSize
                + ", mMaxDuration : " + mMaxDuration
                + ", mOutputPath : " + mOutputPath
                + ", mAudioEncodingBitRate : " + mAudioEncodingBitRate
                + ", mAudioChannels : " + mAudioChannels
                + ", mAudioSamplingRate : " + mAudioSamplingRate
                + ", mAudioEncoder : " + mAudioEncoder
                + ", mDurationInterval : " + mDurationInterval
                + ", mFileSizeInterval : " + mFileSizeInterval
                + ", mAuthor : " + mAuthor + "}";
    }
}
