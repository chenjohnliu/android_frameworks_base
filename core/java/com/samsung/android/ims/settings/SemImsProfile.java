package com.samsung.android.ims.settings;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class SemImsProfile implements Parcelable {
    private static final String LOG_TAG = "SemImsProfile";

    public static final Parcelable.Creator<SemImsProfile> CREATOR =
            new Parcelable.Creator<SemImsProfile>() {
                @Override
                public SemImsProfile createFromParcel(Parcel source) {
                    return new SemImsProfile(source);
                }

                @Override
                public SemImsProfile[] newArray(int size) {
                    return new SemImsProfile[size];
                }
            };

    private JSONObject mBody;

    public SemImsProfile(ContentValues values) {
        mBody = new JSONObject();
        update(values);
    }

    private SemImsProfile(Parcel source) {
        fromJson(source.readString());
    }

    public SemImsProfile(SemImsProfile profile) {
        if (profile != null) {
            fromJson(profile.toJson());
        }
    }

    public SemImsProfile(String json) {
        fromJson(json);
    }

    private void fromJson(String json) {
        if (json == null) {
            return;
        }
        try {
            mBody = new JSONObject(json);
            splitNetwork();
        } catch (Exception e) {
            mBody = new JSONObject();
            e.printStackTrace();
        }
    }

    private Boolean getAsBoolean(String key) {
        return Boolean.valueOf(mBody.optBoolean(key));
    }

    private static int getNetworkType(String type) {
        return NETWORK_TYPE.from(type).mType;
    }

    private Map<Integer, Set<String>> getAllServiceSet() {
        Map<Integer, Set<String>> result = new ArrayMap<>();
        JSONArray networks = mBody.optJSONArray("network");
        if (networks == null) {
            return result;
        }
        for (int i = 0; i < networks.length(); i++) {
            JSONObject network = networks.optJSONObject(i);
            JSONArray services = network.optJSONArray("services");
            if (services == null) {
                Log.e(LOG_TAG, "getAllServiceSet: No services array in " + network.toString());
                continue;
            }
            Set<String> serviceSet = new ArraySet<>();
            for (int j = 0; j < services.length(); j++) {
                serviceSet.add(services.optString(j));
            }
            result.put(Integer.valueOf(getNetworkType(network.optString("type"))), serviceSet);
        }
        return result;
    }

    private void put(String key, Boolean value) {
        try {
            mBody.put(key, value);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String toJson() {
        return mBody.toString();
    }

    private void update(ContentValues values) {
        if (values == null) {
            return;
        }
        try {
            for (String key : values.keySet()) {
                String stringValue = values.getAsString(key);
                if (stringValue == null) {
                    continue;
                }
                if (stringValue.matches("\\[\\{.*\\}\\]")) {
                    mBody.put(key, new JSONArray(stringValue));
                } else {
                    mBody.put(key, values.get(key));
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public boolean hasEmergencySupport() {
        return getAsBoolean("emergency_support").booleanValue();
    }

    public boolean hasService(String service) {
        for (Set<String> services : getAllServiceSet().values()) {
            if (services.contains(service)) {
                return true;
            }
        }
        return false;
    }

    protected void splitNetwork() throws JSONException {
        JSONArray split = new JSONArray();
        JSONArray networks = mBody.getJSONArray("network");
        if (networks != null) {
            for (int i = 0; i < networks.length(); i++) {
                JSONObject network = networks.optJSONObject(i);
                String[] types = TextUtils.split(network.optString("type"), ",");
                for (String type : types) {
                    JSONObject item = new JSONObject(network,
                            new String[] {"services", "enabled", "dereg_timeout"});
                    item.put("type", type);
                    split.put(item);
                }
            }
            mBody.put("network", split);
        }
    }

    @Override
    public int describeContents() { return 0; }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(toJson());
    }

    public static class ImsCategory {
        public static final String RCS_SERVICE = "rcs";
        public static final String VOLTE_SERVICE = "volte";

        public ImsCategory() {}
    }

    public static class ImsFeature {
        public static final String CDPN = "cdpn";
        public static final String CHATBOT_COMMUNICATION = "chatbot-communication";
        public static final String EC = "ec";
        public static final String EUC = "euc";
        public static final String FT = "ft";
        public static final String FT_HTTP = "ft_http";
        public static final String GLS = "gls";
        public static final String IM = "im";
        public static final String IS = "is";
        public static final String LASTSEEN = "lastseen";
        public static final String MMTEL_CALL_COMPOSER = "mmtel-call-composer";
        public static final String MMTEL_VOICE = "mmtel";
        public static final String MMTEL_VOICE_VIDEO = "mmtel-video";
        public static final String OPTIONS = "options";
        public static final String PLUG_IN = "plug-in";
        public static final String PRESENCE = "presence";
        public static final String PROFILE = "profile";
        public static final String SLM = "slm";
        public static final String SMSIP = "smsip";
        public static final String SS = "ss";
        public static final String VS = "vs";
        public static final String XDM = "xdm";

        protected static final String[] volteServices = {
                MMTEL_VOICE, MMTEL_VOICE_VIDEO, MMTEL_CALL_COMPOSER, SMSIP, SS, CDPN
        };
        protected static final String[] rcsServices = {
                OPTIONS, PRESENCE, IM, FT, FT_HTTP, SLM, IS, VS, EUC, GLS, PROFILE,
                EC, CHATBOT_COMMUNICATION, PLUG_IN, LASTSEEN
        };
        private static final String[] mImsFeatureList = {
                MMTEL_VOICE_VIDEO, MMTEL_VOICE, SMSIP, SLM, IM, FT, FT_HTTP, IS,
                VS, OPTIONS, PRESENCE, XDM, EUC
        };

        public ImsFeature() {}

        public static String[] getRcsServiceList() { return rcsServices; }
        public static String[] getVoLteServiceList() { return volteServices; }

        public static boolean isValidImsFeature(String feature) {
            for (String candidate : mImsFeatureList) {
                if (candidate.equals(feature)) {
                    return true;
                }
            }
            return false;
        }
    }

    public enum NETWORK_TYPE {
        UNKNOWN(0),
        GPRS(1),
        EDGE(2),
        UMTS(3),
        CDMA(4),
        EVDO_0(5),
        EVDO_A(6),
        _1XRTT(7),
        HSDPA(8),
        HSUPA(9),
        HSPA(10),
        EVDO_B(12),
        LTE(13),
        EHRPD(14),
        HSPAP(15),
        GSM(16),
        TDSCDMA(17),
        WIFI(18),
        NR(20),
        ALL(100);

        private int mType;

        NETWORK_TYPE(int type) { mType = type; }

        public static NETWORK_TYPE from(int type) {
            for (NETWORK_TYPE value : values()) {
                if (value.mType == type) {
                    return value;
                }
            }
            return UNKNOWN;
        }

        public static NETWORK_TYPE from(String type) {
            for (NETWORK_TYPE value : values()) {
                if (value.toString().equalsIgnoreCase(type)) {
                    return value;
                }
            }
            return UNKNOWN;
        }

        public boolean isOneOf(NETWORK_TYPE... types) {
            if (types != null) {
                for (NETWORK_TYPE type : types) {
                    if (this == type) {
                        return true;
                    }
                }
            }
            return false;
        }

        @Override
        public String toString() {
            if (this == HSPAP) {
                return "hspa+";
            }
            if (this == _1XRTT) {
                return "1xrtt";
            }
            return super.toString().toLowerCase(Locale.US);
        }
    }

    public static class RcsProfileType {
        public static final String RCS_PROFILE_NONE = "";
        public static final String RCS_PROFILE_TYPE_JOYN_BLACKBIRD = "joyn_blackbird";
        public static final String RCS_PROFILE_TYPE_JOYN_CPR = "joyn_cpr";
        public static final String RCS_PROFILE_TYPE_NAGUIDELINES = "NAGuidelines";
        public static final String RCS_PROFILE_TYPE_UP10 = "UP_1.0";
        public static final String RCS_PROFILE_TYPE_UP20 = "UP_2.0";
        public static final String RCS_PROFILE_TYPE_UP21 = "UP_2.1";
        public static final String RCS_PROFILE_TYPE_UP22 = "UP_2.2";
        public static final String RCS_PROFILE_TYPE_UP23 = "UP_2.3";
        public static final String RCS_PROFILE_TYPE_UP30 = "UP_3.0";
        public static final String RCS_PROFILE_TYPE_UPT = "UP_T";

        public RcsProfileType() {}
    }
}
