package com.samsung.android.ims;

import android.os.Parcel;
import android.os.Parcelable;

public class SemImsRegistrationError implements Parcelable {
    public static final Parcelable.Creator<SemImsRegistrationError> CREATOR =
            new Parcelable.Creator<SemImsRegistrationError>() {
                @Override
                public SemImsRegistrationError createFromParcel(Parcel source) {
                    return new SemImsRegistrationError(source);
                }

                @Override
                public SemImsRegistrationError[] newArray(int size) {
                    return new SemImsRegistrationError[size];
                }
            };

    private int mDeregistrationReason;
    private int mDetailedDeregiReason;
    private int mSipErrorCode;
    private String mSipErrorReason;

    public SemImsRegistrationError() {
        mSipErrorCode = 0;
        mSipErrorReason = "";
        mDetailedDeregiReason = 0;
        mDeregistrationReason = 0;
    }

    public SemImsRegistrationError(int sipErrorCode) {
        mSipErrorCode = 0;
    }

    public SemImsRegistrationError(int sipErrorCode, String sipErrorReason,
            int detailedDeregiReason, int deregistrationReason) {
        mSipErrorCode = sipErrorCode;
        mSipErrorReason = sipErrorReason;
        mDetailedDeregiReason = detailedDeregiReason;
        mDeregistrationReason = deregistrationReason;
    }

    private SemImsRegistrationError(Parcel source) {
        mSipErrorCode = source.readInt();
        mSipErrorReason = source.readString();
        mDetailedDeregiReason = source.readInt();
        mDeregistrationReason = source.readInt();
    }

    public int getDeregistrationReason() { return mDeregistrationReason; }
    public int getDetailedDeregiReason() { return mDetailedDeregiReason; }
    public int getSipErrorCode() { return mSipErrorCode; }
    public String getSipErrorReason() { return mSipErrorReason; }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mSipErrorCode);
        dest.writeString(mSipErrorReason);
        dest.writeInt(mDetailedDeregiReason);
        dest.writeInt(mDeregistrationReason);
    }
}
