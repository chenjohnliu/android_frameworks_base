package com.samsung.android.ims;

import android.net.Network;
import android.os.Parcel;
import android.os.Parcelable;

import com.samsung.android.ims.settings.SemImsProfile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SemImsRegistration implements Parcelable {
    private static final String LOG_TAG = "SemImsRegistration";
    private static final int NETWORK_TYPE_UNKNOWN = 0;
    private static final int NETWORK_TYPE_MOBILE = 1;
    private static final int NETWORK_TYPE_WIFI = 2;

    public static final Parcelable.Creator<SemImsRegistration> CREATOR =
            new Parcelable.Creator<SemImsRegistration>() {
                @Override
                public SemImsRegistration createFromParcel(Parcel source) {
                    return new SemImsRegistration(source);
                }

                @Override
                public SemImsRegistration[] newArray(int size) {
                    return new SemImsRegistration[size];
                }
            };

    private int mDeregiReason = 14;
    private final List<String> mDeviceList;
    private final String mDomain;
    private final int mEcmpStatus;
    private boolean mEpdgOverCellularData;
    private boolean mEpdgStatus;
    private final int mHandle;
    private final String mInstanceId;
    private final Network mNetwork;
    private final String mOwnNumber;
    private String mPAssociatedUri2nd = "";
    private final String mPcscf;
    private final int mPdnType;
    private final int mPhoneId;
    private final String mPreferredPublicUserId;
    private final String mPrivateUserId;
    private boolean mProhibited;
    private final List<String> mPublicUserId;
    private int mRat;
    private final int mRegExpiryStatus;
    private final String mRegisterSipResponse;
    private final String mRegisteredPublicUserId;
    private final Set<String> mServices;
    private final int mSubscriptionId;

    private SemImsRegistration(Parcel source) {
        mHandle = source.readInt();
        mServices = new HashSet<>();
        readServices(source);
        mRat = source.readInt();
        mSubscriptionId = source.readInt();
        mPhoneId = source.readInt();
        mPrivateUserId = source.readString();
        mRegisteredPublicUserId = source.readInt() == 1 ? source.readString() : null;
        mPreferredPublicUserId = source.readString();
        mPublicUserId = new ArrayList<>();
        source.readStringList(mPublicUserId);
        mDeviceList = new ArrayList<>();
        source.readStringList(mDeviceList);
        mDomain = source.readString();
        mPcscf = source.readString();
        mInstanceId = source.readString();
        mPdnType = source.readInt();
        mEcmpStatus = source.readInt();
        mRegExpiryStatus = source.readInt();
        mEpdgStatus = source.readInt() == 1;
        mEpdgOverCellularData = source.readInt() == 1;
        mRegisterSipResponse = source.readInt() == 1 ? source.readString() : null;
        mNetwork = (Network) source.readParcelable(Network.class.getClassLoader());
        mPAssociatedUri2nd = source.readString();
        mOwnNumber = source.readString();
    }

    public SemImsRegistration(Builder builder) {
        mHandle = builder.mHandle;
        mServices = builder.mServices;
        mRat = builder.mRat;
        mDomain = builder.mDomain;
        mPrivateUserId = builder.mPrivateUserId;
        mRegisteredPublicUserId = builder.mRegisteredPublicUserId;
        mPreferredPublicUserId = builder.mPreferredPublicUserId;
        mPublicUserId = builder.mPublicUserId;
        mDeviceList = builder.mDeviceList;
        mSubscriptionId = builder.mSubscriptionId;
        mPhoneId = builder.mPhoneId;
        mInstanceId = builder.mInstanceId;
        mPdnType = builder.mPdnType;
        mPcscf = builder.mPcscf;
        mEcmpStatus = builder.mEcmpStatus;
        mRegExpiryStatus = builder.mRegExpiryStatus;
        mEpdgStatus = builder.mEpdgStatus;
        mEpdgOverCellularData = builder.mEpdgOverCellularData;
        mProhibited = builder.mProhibited;
        mRegisterSipResponse = builder.mRegisterSipResponse;
        mNetwork = builder.mNetwork;
        mDeregiReason = builder.mDeregiReason;
        mPAssociatedUri2nd = builder.mPAssociatedUri2nd;
        mOwnNumber = builder.mOwnNumber;
    }

    public SemImsRegistration(SemImsRegistration source) {
        this(source, new HashSet<>(source.mServices));
    }

    public SemImsRegistration(SemImsRegistration source, Set<String> services) {
        mHandle = source.mHandle;
        mServices = services;
        mRat = source.mRat;
        mDomain = source.mDomain;
        mPrivateUserId = source.mPrivateUserId;
        mRegisteredPublicUserId = source.mRegisteredPublicUserId;
        mPreferredPublicUserId = source.mPreferredPublicUserId;
        mPublicUserId = new ArrayList<>(source.mPublicUserId);
        mDeviceList = new ArrayList<>(source.mDeviceList);
        mSubscriptionId = source.mSubscriptionId;
        mPhoneId = source.mPhoneId;
        mInstanceId = source.mInstanceId;
        mPdnType = source.mPdnType;
        mPcscf = source.mPcscf;
        mEcmpStatus = source.mEcmpStatus;
        mRegExpiryStatus = source.mRegExpiryStatus;
        mEpdgStatus = source.mEpdgStatus;
        mEpdgOverCellularData = source.mEpdgOverCellularData;
        mProhibited = source.mProhibited;
        mRegisterSipResponse = source.mRegisterSipResponse;
        mNetwork = source.mNetwork;
        mDeregiReason = source.mDeregiReason;
        mPAssociatedUri2nd = source.mPAssociatedUri2nd;
        mOwnNumber = source.mOwnNumber;
    }

    public static Builder getBuilder() { return new Builder(); }

    private void readServices(Parcel source) {
        List<String> services = new ArrayList<>();
        source.readStringList(services);
        mServices.addAll(services);
    }

    private void writeServices(Parcel dest) {
        dest.writeStringList(new ArrayList<>(mServices));
    }

    public int getDeregiReason() { return mDeregiReason; }
    public List<String> getDeviceList() { return new ArrayList<>(mDeviceList); }
    public String getDomain() { return mDomain; }
    public int getEcmpStatus() { return mEcmpStatus; }
    public boolean getEpdgStatus() { return mEpdgStatus; }
    public int getHandle() { return mHandle; }
    public String getImpi() { return mPrivateUserId; }
    public List<String> getImpuList() { return new ArrayList<>(mPublicUserId); }
    public String getInstanceId() { return mInstanceId; }
    public Network getNetwork() { return mNetwork; }
    public int getNetworkType() { return mPdnType; }
    public String getOwnNumber() { return mOwnNumber; }
    public String getPcscf() { return mPcscf; }
    public int getPhoneId() { return mPhoneId; }
    public String getPreferredImpu() { return mPreferredPublicUserId; }
    public String getRegisterSipResponse() { return mRegisterSipResponse; }
    public Set<String> getRegisteredFeatures() { return new HashSet<>(mServices); }
    public String getRegisteredImpu() { return mRegisteredPublicUserId; }
    public int getRegisteredRat() { return mRat; }
    public String getSecondPAssociatedUri() { return mPAssociatedUri2nd; }
    public Set<String> getServices() { return new HashSet<>(mServices); }
    public int getSubscriptionId() { return mSubscriptionId; }

    public boolean hasRcsService() {
        Set<String> rcsServices = new HashSet<>(
                Arrays.asList(SemImsProfile.ImsFeature.getRcsServiceList()));
        return rcsServices.removeAll(mServices);
    }

    public boolean hasService(String service) { return mServices.contains(service); }
    public boolean isEpdgOverCellularData() { return mEpdgOverCellularData; }
    public boolean isImsiBased(String imsi) { return mRegisteredPublicUserId.toString().contains(imsi); }
    public boolean isProhibited() { return mProhibited; }

    public void setDeregiReason(int reason) { mDeregiReason = reason; }
    public void setEpdgOverCellularData(boolean value) { mEpdgOverCellularData = value; }
    public void setEpdgStatus(boolean value) { mEpdgStatus = value; }
    public void setProhibited(boolean value) { mProhibited = value; }
    public void setRegiRat(int rat) { mRat = rat; }
    public void setSecondPAssociatedUri(String uri) { mPAssociatedUri2nd = uri; }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mHandle);
        writeServices(dest);
        dest.writeInt(mRat);
        dest.writeInt(mSubscriptionId);
        dest.writeInt(mPhoneId);
        dest.writeString(mPrivateUserId);
        if (mRegisteredPublicUserId == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeString(mRegisteredPublicUserId.toString());
        }
        dest.writeString(mPreferredPublicUserId);
        dest.writeStringList(mPublicUserId);
        dest.writeStringList(mDeviceList);
        dest.writeString(mDomain);
        dest.writeString(mPcscf);
        dest.writeString(mInstanceId);
        dest.writeInt(mPdnType);
        dest.writeInt(mEcmpStatus);
        dest.writeInt(mRegExpiryStatus);
        dest.writeInt(mEpdgStatus ? 1 : 0);
        dest.writeInt(mEpdgOverCellularData ? 1 : 0);
        if (mRegisterSipResponse == null) {
            dest.writeInt(0);
        } else {
            dest.writeInt(1);
            dest.writeString(mRegisterSipResponse);
        }
        dest.writeParcelable(mNetwork, flags);
        dest.writeString(mPAssociatedUri2nd);
        dest.writeString(mOwnNumber);
    }

    public static class Builder {
        private int mDeregiReason = 14;
        protected List<String> mDeviceList = new ArrayList<>();
        protected String mDomain;
        private int mEcmpStatus;
        private boolean mEpdgOverCellularData;
        private boolean mEpdgStatus;
        protected int mHandle;
        protected String mInstanceId;
        private Network mNetwork;
        protected String mOwnNumber;
        private String mPAssociatedUri2nd;
        protected String mPcscf;
        protected int mPdnType;
        protected int mPhoneId;
        protected String mPreferredPublicUserId;
        protected String mPrivateUserId;
        private boolean mProhibited;
        protected List<String> mPublicUserId = new ArrayList<>();
        protected int mRat;
        private int mRegExpiryStatus;
        private String mRegisterSipResponse;
        protected String mRegisteredPublicUserId;
        Set<String> mServices = new HashSet<>();
        protected int mSubscriptionId;

        public Builder() {}

        public Builder addService(String service) { mServices.add(service); return this; }
        public SemImsRegistration build() { return new SemImsRegistration(this); }
        public Builder setDeregiReason(int value) { mDeregiReason = value; return this; }
        public Builder setDeviceList(List<String> value) { mDeviceList = value; return this; }
        public Builder setDomain(String value) { mDomain = value; return this; }
        public Builder setEcmpStatus(int value) { mEcmpStatus = value; return this; }
        public Builder setEpdgOverCellularData(boolean value) { mEpdgOverCellularData = value; return this; }
        public Builder setEpdgStatus(boolean value) { mEpdgStatus = value; return this; }
        public Builder setHandle(int value) { mHandle = value; return this; }
        public Builder setInstanceId(String value) { mInstanceId = value; return this; }
        public Builder setNetwork(Network value) { mNetwork = value; return this; }
        public Builder setOwnNumber(String value) { mOwnNumber = value; return this; }
        public Builder setPAssociatedUri2nd(String value) { mPAssociatedUri2nd = value; return this; }
        public Builder setPcscf(String value) { mPcscf = value; return this; }
        public Builder setPdnType(int value) { mPdnType = value; return this; }
        public Builder setPhoneId(int value) { mPhoneId = value; return this; }
        public Builder setPreferredPublicUserId(String value) { mPreferredPublicUserId = value; return this; }
        public Builder setPrivateUserId(String value) { mPrivateUserId = value; return this; }
        public Builder setProhibited(boolean value) { mProhibited = value; return this; }
        public Builder setPublicUserId(List<String> value) { mPublicUserId = value; return this; }
        public Builder setRegExpiryStatus(int value) { mRegExpiryStatus = value; return this; }
        public Builder setRegiRat(int value) { mRat = value; return this; }
        public Builder setRegisterSipResponse(String value) { mRegisterSipResponse = value; return this; }
        public Builder setRegisteredPublicUserId(String value) { mRegisteredPublicUserId = value; return this; }
        public Builder setServices(Set<String> value) { mServices = value; return this; }
        public Builder setSubscriptionId(int value) { mSubscriptionId = value; return this; }
    }
}
