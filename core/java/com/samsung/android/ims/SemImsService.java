/*
 * Exact SM-M115F CWK3 legacy Binder ABI compatibility surface.
 * Generated from the stock DEX contract; hidden framework API.
 */
package com.samsung.android.ims;

import android.content.ContentValues;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.samsung.android.ims.cmc.ISemCmcRecordingListener;
import com.samsung.android.ims.cmc.SemCmcRecordingInfo;
import com.samsung.android.ims.ft.SemImsFtListener;
import com.samsung.android.ims.settings.SemImsProfile;

/** @hide */
public interface SemImsService extends IInterface {
    String DESCRIPTOR = "com.samsung.android.ims.SemImsService";

    String registerImsRegistrationListenerForSlot(SemImsRegiListener listener, int phoneId) throws RemoteException;
    void unregisterImsRegistrationListenerForSlot(String token, int phoneId) throws RemoteException;
    String registerSimMobilityStatusListener(SemSimMobStatusListener listener, int phoneId) throws RemoteException;
    void unregisterSimMobilityStatusListener(String token, int phoneId) throws RemoteException;
    void registerDmValueListener(SemImsDmConfigListener listener) throws RemoteException;
    void unregisterDmValueListener(SemImsDmConfigListener listener) throws RemoteException;
    String registerAutoConfigurationListener(SemAutoConfigListener listener, int phoneId) throws RemoteException;
    void unregisterAutoConfigurationListener(String token, int phoneId) throws RemoteException;
    String registerImsOngoingFtEventListener(SemImsFtListener listener) throws RemoteException;
    void unregisterImsOngoingFtEventListener(String token) throws RemoteException;
    SemImsRegistration getRegistrationInfoByServiceType(String serviceType, int phoneId) throws RemoteException;
    SemImsRegistration[] getRegistrationInfoByPhoneId(int phoneId) throws RemoteException;
    boolean isServiceAvailable(String service, int rat, int phoneId) throws RemoteException;
    String getRcsProfileType(int phoneId) throws RemoteException;
    boolean isVoLteAvailable(int phoneId) throws RemoteException;
    boolean isSimMobilityActivated(int phoneId) throws RemoteException;
    void setRttMode(int phoneId, int mode) throws RemoteException;
    void sendTryRegisterByPhoneId(int phoneId) throws RemoteException;
    void enableRcsByPhoneId(boolean enable, int phoneId) throws RemoteException;
    boolean isRcsEnabled(boolean needAutoConfigCheck, int phoneId) throws RemoteException;
    SemImsProfile[] getCurrentProfileForSlot(int phoneId) throws RemoteException;
    boolean isForbiddenByPhoneId(int phoneId) throws RemoteException;
    void sendVerificationCode(String value, int phoneId) throws RemoteException;
    void sendMsisdnNumber(String value, int phoneId) throws RemoteException;
    void sendIidToken(String value, int phoneId) throws RemoteException;
    ContentValues getConfigValues(String[] fields, int phoneId) throws RemoteException;
    boolean getBooleanConfig(String field, int phoneId) throws RemoteException;
    void sendSemCmcRecordingEvent(SemCmcRecordingInfo recordingInfo, int event, int phoneId) throws RemoteException;
    void registerSemCmcRecordingListener(ISemCmcRecordingListener listener, int phoneId) throws RemoteException;
    String registerEpdgListener(ISemEpdgListener listener) throws RemoteException;
    void unRegisterEpdgListener(String token) throws RemoteException;
    boolean isCmcEmergencyCallSupported() throws RemoteException;
    boolean isCmcEmergencyNumber(String number) throws RemoteException;
    boolean isCmcPotentialEmergencyNumber(String number) throws RemoteException;
    boolean isCrossSimCallingRegistered(int phoneId) throws RemoteException;
    boolean hasCrossSimCallingSupport(int phoneId) throws RemoteException;

    class Default implements SemImsService {
        @Override
        public String registerImsRegistrationListenerForSlot(SemImsRegiListener listener, int phoneId) throws RemoteException {
            return null;
        }
        @Override
        public void unregisterImsRegistrationListenerForSlot(String token, int phoneId) throws RemoteException {
        }
        @Override
        public String registerSimMobilityStatusListener(SemSimMobStatusListener listener, int phoneId) throws RemoteException {
            return null;
        }
        @Override
        public void unregisterSimMobilityStatusListener(String token, int phoneId) throws RemoteException {
        }
        @Override
        public void registerDmValueListener(SemImsDmConfigListener listener) throws RemoteException {
        }
        @Override
        public void unregisterDmValueListener(SemImsDmConfigListener listener) throws RemoteException {
        }
        @Override
        public String registerAutoConfigurationListener(SemAutoConfigListener listener, int phoneId) throws RemoteException {
            return null;
        }
        @Override
        public void unregisterAutoConfigurationListener(String token, int phoneId) throws RemoteException {
        }
        @Override
        public String registerImsOngoingFtEventListener(SemImsFtListener listener) throws RemoteException {
            return null;
        }
        @Override
        public void unregisterImsOngoingFtEventListener(String token) throws RemoteException {
        }
        @Override
        public SemImsRegistration getRegistrationInfoByServiceType(String serviceType, int phoneId) throws RemoteException {
            return null;
        }
        @Override
        public SemImsRegistration[] getRegistrationInfoByPhoneId(int phoneId) throws RemoteException {
            return null;
        }
        @Override
        public boolean isServiceAvailable(String service, int rat, int phoneId) throws RemoteException {
            return false;
        }
        @Override
        public String getRcsProfileType(int phoneId) throws RemoteException {
            return null;
        }
        @Override
        public boolean isVoLteAvailable(int phoneId) throws RemoteException {
            return false;
        }
        @Override
        public boolean isSimMobilityActivated(int phoneId) throws RemoteException {
            return false;
        }
        @Override
        public void setRttMode(int phoneId, int mode) throws RemoteException {
        }
        @Override
        public void sendTryRegisterByPhoneId(int phoneId) throws RemoteException {
        }
        @Override
        public void enableRcsByPhoneId(boolean enable, int phoneId) throws RemoteException {
        }
        @Override
        public boolean isRcsEnabled(boolean needAutoConfigCheck, int phoneId) throws RemoteException {
            return false;
        }
        @Override
        public SemImsProfile[] getCurrentProfileForSlot(int phoneId) throws RemoteException {
            return null;
        }
        @Override
        public boolean isForbiddenByPhoneId(int phoneId) throws RemoteException {
            return false;
        }
        @Override
        public void sendVerificationCode(String value, int phoneId) throws RemoteException {
        }
        @Override
        public void sendMsisdnNumber(String value, int phoneId) throws RemoteException {
        }
        @Override
        public void sendIidToken(String value, int phoneId) throws RemoteException {
        }
        @Override
        public ContentValues getConfigValues(String[] fields, int phoneId) throws RemoteException {
            return null;
        }
        @Override
        public boolean getBooleanConfig(String field, int phoneId) throws RemoteException {
            return false;
        }
        @Override
        public void sendSemCmcRecordingEvent(SemCmcRecordingInfo recordingInfo, int event, int phoneId) throws RemoteException {
        }
        @Override
        public void registerSemCmcRecordingListener(ISemCmcRecordingListener listener, int phoneId) throws RemoteException {
        }
        @Override
        public String registerEpdgListener(ISemEpdgListener listener) throws RemoteException {
            return null;
        }
        @Override
        public void unRegisterEpdgListener(String token) throws RemoteException {
        }
        @Override
        public boolean isCmcEmergencyCallSupported() throws RemoteException {
            return false;
        }
        @Override
        public boolean isCmcEmergencyNumber(String number) throws RemoteException {
            return false;
        }
        @Override
        public boolean isCmcPotentialEmergencyNumber(String number) throws RemoteException {
            return false;
        }
        @Override
        public boolean isCrossSimCallingRegistered(int phoneId) throws RemoteException {
            return false;
        }
        @Override
        public boolean hasCrossSimCallingSupport(int phoneId) throws RemoteException {
            return false;
        }

        @Override
        public IBinder asBinder() {
            return null;
        }
    }

    abstract class Stub extends Binder implements SemImsService {
        static final int TRANSACTION_registerImsRegistrationListenerForSlot = 1;
        static final int TRANSACTION_unregisterImsRegistrationListenerForSlot = 2;
        static final int TRANSACTION_registerSimMobilityStatusListener = 3;
        static final int TRANSACTION_unregisterSimMobilityStatusListener = 4;
        static final int TRANSACTION_registerDmValueListener = 5;
        static final int TRANSACTION_unregisterDmValueListener = 6;
        static final int TRANSACTION_registerAutoConfigurationListener = 7;
        static final int TRANSACTION_unregisterAutoConfigurationListener = 8;
        static final int TRANSACTION_registerImsOngoingFtEventListener = 9;
        static final int TRANSACTION_unregisterImsOngoingFtEventListener = 10;
        static final int TRANSACTION_getRegistrationInfoByServiceType = 11;
        static final int TRANSACTION_getRegistrationInfoByPhoneId = 12;
        static final int TRANSACTION_isServiceAvailable = 13;
        static final int TRANSACTION_getRcsProfileType = 14;
        static final int TRANSACTION_isVoLteAvailable = 15;
        static final int TRANSACTION_isSimMobilityActivated = 16;
        static final int TRANSACTION_setRttMode = 17;
        static final int TRANSACTION_sendTryRegisterByPhoneId = 18;
        static final int TRANSACTION_enableRcsByPhoneId = 19;
        static final int TRANSACTION_isRcsEnabled = 20;
        static final int TRANSACTION_getCurrentProfileForSlot = 21;
        static final int TRANSACTION_isForbiddenByPhoneId = 22;
        static final int TRANSACTION_sendVerificationCode = 23;
        static final int TRANSACTION_sendMsisdnNumber = 24;
        static final int TRANSACTION_sendIidToken = 25;
        static final int TRANSACTION_getConfigValues = 26;
        static final int TRANSACTION_getBooleanConfig = 27;
        static final int TRANSACTION_sendSemCmcRecordingEvent = 28;
        static final int TRANSACTION_registerSemCmcRecordingListener = 29;
        static final int TRANSACTION_registerEpdgListener = 30;
        static final int TRANSACTION_unRegisterEpdgListener = 31;
        static final int TRANSACTION_isCmcEmergencyCallSupported = 32;
        static final int TRANSACTION_isCmcEmergencyNumber = 33;
        static final int TRANSACTION_isCmcPotentialEmergencyNumber = 34;
        static final int TRANSACTION_isCrossSimCallingRegistered = 35;
        static final int TRANSACTION_hasCrossSimCallingSupport = 36;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static SemImsService asInterface(IBinder obj) {
            if (obj == null) return null;
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin instanceof SemImsService) return (SemImsService) iin;
            return new Proxy(obj);
        }

        @Override
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch (transactionCode) {
                case TRANSACTION_registerImsRegistrationListenerForSlot: return "registerImsRegistrationListenerForSlot";
                case TRANSACTION_unregisterImsRegistrationListenerForSlot: return "unregisterImsRegistrationListenerForSlot";
                case TRANSACTION_registerSimMobilityStatusListener: return "registerSimMobilityStatusListener";
                case TRANSACTION_unregisterSimMobilityStatusListener: return "unregisterSimMobilityStatusListener";
                case TRANSACTION_registerDmValueListener: return "registerDmValueListener";
                case TRANSACTION_unregisterDmValueListener: return "unregisterDmValueListener";
                case TRANSACTION_registerAutoConfigurationListener: return "registerAutoConfigurationListener";
                case TRANSACTION_unregisterAutoConfigurationListener: return "unregisterAutoConfigurationListener";
                case TRANSACTION_registerImsOngoingFtEventListener: return "registerImsOngoingFtEventListener";
                case TRANSACTION_unregisterImsOngoingFtEventListener: return "unregisterImsOngoingFtEventListener";
                case TRANSACTION_getRegistrationInfoByServiceType: return "getRegistrationInfoByServiceType";
                case TRANSACTION_getRegistrationInfoByPhoneId: return "getRegistrationInfoByPhoneId";
                case TRANSACTION_isServiceAvailable: return "isServiceAvailable";
                case TRANSACTION_getRcsProfileType: return "getRcsProfileType";
                case TRANSACTION_isVoLteAvailable: return "isVoLteAvailable";
                case TRANSACTION_isSimMobilityActivated: return "isSimMobilityActivated";
                case TRANSACTION_setRttMode: return "setRttMode";
                case TRANSACTION_sendTryRegisterByPhoneId: return "sendTryRegisterByPhoneId";
                case TRANSACTION_enableRcsByPhoneId: return "enableRcsByPhoneId";
                case TRANSACTION_isRcsEnabled: return "isRcsEnabled";
                case TRANSACTION_getCurrentProfileForSlot: return "getCurrentProfileForSlot";
                case TRANSACTION_isForbiddenByPhoneId: return "isForbiddenByPhoneId";
                case TRANSACTION_sendVerificationCode: return "sendVerificationCode";
                case TRANSACTION_sendMsisdnNumber: return "sendMsisdnNumber";
                case TRANSACTION_sendIidToken: return "sendIidToken";
                case TRANSACTION_getConfigValues: return "getConfigValues";
                case TRANSACTION_getBooleanConfig: return "getBooleanConfig";
                case TRANSACTION_sendSemCmcRecordingEvent: return "sendSemCmcRecordingEvent";
                case TRANSACTION_registerSemCmcRecordingListener: return "registerSemCmcRecordingListener";
                case TRANSACTION_registerEpdgListener: return "registerEpdgListener";
                case TRANSACTION_unRegisterEpdgListener: return "unRegisterEpdgListener";
                case TRANSACTION_isCmcEmergencyCallSupported: return "isCmcEmergencyCallSupported";
                case TRANSACTION_isCmcEmergencyNumber: return "isCmcEmergencyNumber";
                case TRANSACTION_isCmcPotentialEmergencyNumber: return "isCmcPotentialEmergencyNumber";
                case TRANSACTION_isCrossSimCallingRegistered: return "isCrossSimCallingRegistered";
                case TRANSACTION_hasCrossSimCallingSupport: return "hasCrossSimCallingSupport";
                default: return null;
            }
        }

        @Override
        public String getTransactionName(int transactionCode) {
            return getDefaultTransactionName(transactionCode);
        }

        @Override
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags)
                throws RemoteException {
            if (code == INTERFACE_TRANSACTION) {
                reply.writeString(DESCRIPTOR);
                return true;
            }
            switch (code) {
                case TRANSACTION_registerImsRegistrationListenerForSlot: {
                    data.enforceInterface(DESCRIPTOR);
                    SemImsRegiListener _arg0 = SemImsRegiListener.Stub.asInterface(data.readStrongBinder());
                    int _arg1 = data.readInt();
                    String _result = registerImsRegistrationListenerForSlot(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeString(_result);
                    return true;
                }
                case TRANSACTION_unregisterImsRegistrationListenerForSlot: {
                    data.enforceInterface(DESCRIPTOR);
                    String _arg0 = data.readString();
                    int _arg1 = data.readInt();
                    unregisterImsRegistrationListenerForSlot(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_registerSimMobilityStatusListener: {
                    data.enforceInterface(DESCRIPTOR);
                    SemSimMobStatusListener _arg0 = SemSimMobStatusListener.Stub.asInterface(data.readStrongBinder());
                    int _arg1 = data.readInt();
                    String _result = registerSimMobilityStatusListener(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeString(_result);
                    return true;
                }
                case TRANSACTION_unregisterSimMobilityStatusListener: {
                    data.enforceInterface(DESCRIPTOR);
                    String _arg0 = data.readString();
                    int _arg1 = data.readInt();
                    unregisterSimMobilityStatusListener(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_registerDmValueListener: {
                    data.enforceInterface(DESCRIPTOR);
                    SemImsDmConfigListener _arg0 = SemImsDmConfigListener.Stub.asInterface(data.readStrongBinder());
                    registerDmValueListener(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_unregisterDmValueListener: {
                    data.enforceInterface(DESCRIPTOR);
                    SemImsDmConfigListener _arg0 = SemImsDmConfigListener.Stub.asInterface(data.readStrongBinder());
                    unregisterDmValueListener(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_registerAutoConfigurationListener: {
                    data.enforceInterface(DESCRIPTOR);
                    SemAutoConfigListener _arg0 = SemAutoConfigListener.Stub.asInterface(data.readStrongBinder());
                    int _arg1 = data.readInt();
                    String _result = registerAutoConfigurationListener(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeString(_result);
                    return true;
                }
                case TRANSACTION_unregisterAutoConfigurationListener: {
                    data.enforceInterface(DESCRIPTOR);
                    String _arg0 = data.readString();
                    int _arg1 = data.readInt();
                    unregisterAutoConfigurationListener(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_registerImsOngoingFtEventListener: {
                    data.enforceInterface(DESCRIPTOR);
                    SemImsFtListener _arg0 = SemImsFtListener.Stub.asInterface(data.readStrongBinder());
                    String _result = registerImsOngoingFtEventListener(_arg0);
                    reply.writeNoException();
                    reply.writeString(_result);
                    return true;
                }
                case TRANSACTION_unregisterImsOngoingFtEventListener: {
                    data.enforceInterface(DESCRIPTOR);
                    String _arg0 = data.readString();
                    unregisterImsOngoingFtEventListener(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getRegistrationInfoByServiceType: {
                    data.enforceInterface(DESCRIPTOR);
                    String _arg0 = data.readString();
                    int _arg1 = data.readInt();
                    SemImsRegistration _result = getRegistrationInfoByServiceType(_arg0, _arg1);
                    reply.writeNoException();
                    if (_result != null) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_getRegistrationInfoByPhoneId: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0 = data.readInt();
                    SemImsRegistration[] _result = getRegistrationInfoByPhoneId(_arg0);
                    reply.writeNoException();
                    reply.writeTypedArray(_result, 1);
                    return true;
                }
                case TRANSACTION_isServiceAvailable: {
                    data.enforceInterface(DESCRIPTOR);
                    String _arg0 = data.readString();
                    int _arg1 = data.readInt();
                    int _arg2 = data.readInt();
                    boolean _result = isServiceAvailable(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    reply.writeInt(_result ? 1 : 0);
                    return true;
                }
                case TRANSACTION_getRcsProfileType: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0 = data.readInt();
                    String _result = getRcsProfileType(_arg0);
                    reply.writeNoException();
                    reply.writeString(_result);
                    return true;
                }
                case TRANSACTION_isVoLteAvailable: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0 = data.readInt();
                    boolean _result = isVoLteAvailable(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result ? 1 : 0);
                    return true;
                }
                case TRANSACTION_isSimMobilityActivated: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0 = data.readInt();
                    boolean _result = isSimMobilityActivated(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result ? 1 : 0);
                    return true;
                }
                case TRANSACTION_setRttMode: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0 = data.readInt();
                    int _arg1 = data.readInt();
                    setRttMode(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_sendTryRegisterByPhoneId: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0 = data.readInt();
                    sendTryRegisterByPhoneId(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_enableRcsByPhoneId: {
                    data.enforceInterface(DESCRIPTOR);
                    boolean _arg0 = data.readInt() != 0;
                    int _arg1 = data.readInt();
                    enableRcsByPhoneId(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_isRcsEnabled: {
                    data.enforceInterface(DESCRIPTOR);
                    boolean _arg0 = data.readInt() != 0;
                    int _arg1 = data.readInt();
                    boolean _result = isRcsEnabled(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeInt(_result ? 1 : 0);
                    return true;
                }
                case TRANSACTION_getCurrentProfileForSlot: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0 = data.readInt();
                    SemImsProfile[] _result = getCurrentProfileForSlot(_arg0);
                    reply.writeNoException();
                    reply.writeTypedArray(_result, 1);
                    return true;
                }
                case TRANSACTION_isForbiddenByPhoneId: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0 = data.readInt();
                    boolean _result = isForbiddenByPhoneId(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result ? 1 : 0);
                    return true;
                }
                case TRANSACTION_sendVerificationCode: {
                    data.enforceInterface(DESCRIPTOR);
                    String _arg0 = data.readString();
                    int _arg1 = data.readInt();
                    sendVerificationCode(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_sendMsisdnNumber: {
                    data.enforceInterface(DESCRIPTOR);
                    String _arg0 = data.readString();
                    int _arg1 = data.readInt();
                    sendMsisdnNumber(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_sendIidToken: {
                    data.enforceInterface(DESCRIPTOR);
                    String _arg0 = data.readString();
                    int _arg1 = data.readInt();
                    sendIidToken(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_getConfigValues: {
                    data.enforceInterface(DESCRIPTOR);
                    String[] _arg0 = data.createStringArray();
                    int _arg1 = data.readInt();
                    ContentValues _result = getConfigValues(_arg0, _arg1);
                    reply.writeNoException();
                    if (_result != null) {
                        reply.writeInt(1);
                        _result.writeToParcel(reply, 1);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_getBooleanConfig: {
                    data.enforceInterface(DESCRIPTOR);
                    String _arg0 = data.readString();
                    int _arg1 = data.readInt();
                    boolean _result = getBooleanConfig(_arg0, _arg1);
                    reply.writeNoException();
                    reply.writeInt(_result ? 1 : 0);
                    return true;
                }
                case TRANSACTION_sendSemCmcRecordingEvent: {
                    data.enforceInterface(DESCRIPTOR);
                    SemCmcRecordingInfo _arg0 = data.readInt() != 0 ? SemCmcRecordingInfo.CREATOR.createFromParcel(data) : null;
                    int _arg1 = data.readInt();
                    int _arg2 = data.readInt();
                    sendSemCmcRecordingEvent(_arg0, _arg1, _arg2);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_registerSemCmcRecordingListener: {
                    data.enforceInterface(DESCRIPTOR);
                    ISemCmcRecordingListener _arg0 = ISemCmcRecordingListener.Stub.asInterface(data.readStrongBinder());
                    int _arg1 = data.readInt();
                    registerSemCmcRecordingListener(_arg0, _arg1);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_registerEpdgListener: {
                    data.enforceInterface(DESCRIPTOR);
                    ISemEpdgListener _arg0 = ISemEpdgListener.Stub.asInterface(data.readStrongBinder());
                    String _result = registerEpdgListener(_arg0);
                    reply.writeNoException();
                    reply.writeString(_result);
                    return true;
                }
                case TRANSACTION_unRegisterEpdgListener: {
                    data.enforceInterface(DESCRIPTOR);
                    String _arg0 = data.readString();
                    unRegisterEpdgListener(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_isCmcEmergencyCallSupported: {
                    data.enforceInterface(DESCRIPTOR);
                    boolean _result = isCmcEmergencyCallSupported();
                    reply.writeNoException();
                    reply.writeInt(_result ? 1 : 0);
                    return true;
                }
                case TRANSACTION_isCmcEmergencyNumber: {
                    data.enforceInterface(DESCRIPTOR);
                    String _arg0 = data.readString();
                    boolean _result = isCmcEmergencyNumber(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result ? 1 : 0);
                    return true;
                }
                case TRANSACTION_isCmcPotentialEmergencyNumber: {
                    data.enforceInterface(DESCRIPTOR);
                    String _arg0 = data.readString();
                    boolean _result = isCmcPotentialEmergencyNumber(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result ? 1 : 0);
                    return true;
                }
                case TRANSACTION_isCrossSimCallingRegistered: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0 = data.readInt();
                    boolean _result = isCrossSimCallingRegistered(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result ? 1 : 0);
                    return true;
                }
                case TRANSACTION_hasCrossSimCallingSupport: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0 = data.readInt();
                    boolean _result = hasCrossSimCallingSupport(_arg0);
                    reply.writeNoException();
                    reply.writeInt(_result ? 1 : 0);
                    return true;
                }
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        public static boolean setDefaultImpl(SemImsService impl) {
            if (Proxy.sDefaultImpl != null || impl == null) return false;
            Proxy.sDefaultImpl = impl;
            return true;
        }

        public static SemImsService getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        private static class Proxy implements SemImsService {
            private final IBinder mRemote;
            static SemImsService sDefaultImpl;

            Proxy(IBinder remote) {
                mRemote = remote;
            }

            @Override
            public IBinder asBinder() {
                return mRemote;
            }

            public String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            @Override
            public String registerImsRegistrationListenerForSlot(SemImsRegiListener listener, int phoneId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    _data.writeInt(phoneId);
                    boolean _status = mRemote.transact(TRANSACTION_registerImsRegistrationListenerForSlot, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        return getDefaultImpl().registerImsRegistrationListenerForSlot(listener, phoneId);
                    }
                    _reply.readException();
                    return _reply.readString();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void unregisterImsRegistrationListenerForSlot(String token, int phoneId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(token);
                    _data.writeInt(phoneId);
                    boolean _status = mRemote.transact(TRANSACTION_unregisterImsRegistrationListenerForSlot, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().unregisterImsRegistrationListenerForSlot(token, phoneId);
                        return;
                    }
                    _reply.readException();
                    return;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public String registerSimMobilityStatusListener(SemSimMobStatusListener listener, int phoneId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    _data.writeInt(phoneId);
                    boolean _status = mRemote.transact(TRANSACTION_registerSimMobilityStatusListener, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        return getDefaultImpl().registerSimMobilityStatusListener(listener, phoneId);
                    }
                    _reply.readException();
                    return _reply.readString();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void unregisterSimMobilityStatusListener(String token, int phoneId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(token);
                    _data.writeInt(phoneId);
                    boolean _status = mRemote.transact(TRANSACTION_unregisterSimMobilityStatusListener, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().unregisterSimMobilityStatusListener(token, phoneId);
                        return;
                    }
                    _reply.readException();
                    return;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void registerDmValueListener(SemImsDmConfigListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = mRemote.transact(TRANSACTION_registerDmValueListener, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().registerDmValueListener(listener);
                        return;
                    }
                    _reply.readException();
                    return;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void unregisterDmValueListener(SemImsDmConfigListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = mRemote.transact(TRANSACTION_unregisterDmValueListener, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().unregisterDmValueListener(listener);
                        return;
                    }
                    _reply.readException();
                    return;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public String registerAutoConfigurationListener(SemAutoConfigListener listener, int phoneId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    _data.writeInt(phoneId);
                    boolean _status = mRemote.transact(TRANSACTION_registerAutoConfigurationListener, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        return getDefaultImpl().registerAutoConfigurationListener(listener, phoneId);
                    }
                    _reply.readException();
                    return _reply.readString();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void unregisterAutoConfigurationListener(String token, int phoneId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(token);
                    _data.writeInt(phoneId);
                    boolean _status = mRemote.transact(TRANSACTION_unregisterAutoConfigurationListener, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().unregisterAutoConfigurationListener(token, phoneId);
                        return;
                    }
                    _reply.readException();
                    return;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public String registerImsOngoingFtEventListener(SemImsFtListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = mRemote.transact(TRANSACTION_registerImsOngoingFtEventListener, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        return getDefaultImpl().registerImsOngoingFtEventListener(listener);
                    }
                    _reply.readException();
                    return _reply.readString();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void unregisterImsOngoingFtEventListener(String token) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(token);
                    boolean _status = mRemote.transact(TRANSACTION_unregisterImsOngoingFtEventListener, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().unregisterImsOngoingFtEventListener(token);
                        return;
                    }
                    _reply.readException();
                    return;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public SemImsRegistration getRegistrationInfoByServiceType(String serviceType, int phoneId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(serviceType);
                    _data.writeInt(phoneId);
                    boolean _status = mRemote.transact(TRANSACTION_getRegistrationInfoByServiceType, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        return getDefaultImpl().getRegistrationInfoByServiceType(serviceType, phoneId);
                    }
                    _reply.readException();
                    return _reply.readInt() != 0 ? SemImsRegistration.CREATOR.createFromParcel(_reply) : null;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public SemImsRegistration[] getRegistrationInfoByPhoneId(int phoneId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(phoneId);
                    boolean _status = mRemote.transact(TRANSACTION_getRegistrationInfoByPhoneId, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        return getDefaultImpl().getRegistrationInfoByPhoneId(phoneId);
                    }
                    _reply.readException();
                    return _reply.createTypedArray(SemImsRegistration.CREATOR);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean isServiceAvailable(String service, int rat, int phoneId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(service);
                    _data.writeInt(rat);
                    _data.writeInt(phoneId);
                    boolean _status = mRemote.transact(TRANSACTION_isServiceAvailable, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        return getDefaultImpl().isServiceAvailable(service, rat, phoneId);
                    }
                    _reply.readException();
                    return _reply.readInt() != 0;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public String getRcsProfileType(int phoneId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(phoneId);
                    boolean _status = mRemote.transact(TRANSACTION_getRcsProfileType, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        return getDefaultImpl().getRcsProfileType(phoneId);
                    }
                    _reply.readException();
                    return _reply.readString();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean isVoLteAvailable(int phoneId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(phoneId);
                    boolean _status = mRemote.transact(TRANSACTION_isVoLteAvailable, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        return getDefaultImpl().isVoLteAvailable(phoneId);
                    }
                    _reply.readException();
                    return _reply.readInt() != 0;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean isSimMobilityActivated(int phoneId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(phoneId);
                    boolean _status = mRemote.transact(TRANSACTION_isSimMobilityActivated, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        return getDefaultImpl().isSimMobilityActivated(phoneId);
                    }
                    _reply.readException();
                    return _reply.readInt() != 0;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void setRttMode(int phoneId, int mode) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(phoneId);
                    _data.writeInt(mode);
                    boolean _status = mRemote.transact(TRANSACTION_setRttMode, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().setRttMode(phoneId, mode);
                        return;
                    }
                    _reply.readException();
                    return;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void sendTryRegisterByPhoneId(int phoneId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(phoneId);
                    boolean _status = mRemote.transact(TRANSACTION_sendTryRegisterByPhoneId, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().sendTryRegisterByPhoneId(phoneId);
                        return;
                    }
                    _reply.readException();
                    return;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void enableRcsByPhoneId(boolean enable, int phoneId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(enable ? 1 : 0);
                    _data.writeInt(phoneId);
                    boolean _status = mRemote.transact(TRANSACTION_enableRcsByPhoneId, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().enableRcsByPhoneId(enable, phoneId);
                        return;
                    }
                    _reply.readException();
                    return;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean isRcsEnabled(boolean needAutoConfigCheck, int phoneId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(needAutoConfigCheck ? 1 : 0);
                    _data.writeInt(phoneId);
                    boolean _status = mRemote.transact(TRANSACTION_isRcsEnabled, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        return getDefaultImpl().isRcsEnabled(needAutoConfigCheck, phoneId);
                    }
                    _reply.readException();
                    return _reply.readInt() != 0;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public SemImsProfile[] getCurrentProfileForSlot(int phoneId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(phoneId);
                    boolean _status = mRemote.transact(TRANSACTION_getCurrentProfileForSlot, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        return getDefaultImpl().getCurrentProfileForSlot(phoneId);
                    }
                    _reply.readException();
                    return _reply.createTypedArray(SemImsProfile.CREATOR);
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean isForbiddenByPhoneId(int phoneId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(phoneId);
                    boolean _status = mRemote.transact(TRANSACTION_isForbiddenByPhoneId, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        return getDefaultImpl().isForbiddenByPhoneId(phoneId);
                    }
                    _reply.readException();
                    return _reply.readInt() != 0;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void sendVerificationCode(String value, int phoneId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(value);
                    _data.writeInt(phoneId);
                    boolean _status = mRemote.transact(TRANSACTION_sendVerificationCode, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().sendVerificationCode(value, phoneId);
                        return;
                    }
                    _reply.readException();
                    return;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void sendMsisdnNumber(String value, int phoneId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(value);
                    _data.writeInt(phoneId);
                    boolean _status = mRemote.transact(TRANSACTION_sendMsisdnNumber, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().sendMsisdnNumber(value, phoneId);
                        return;
                    }
                    _reply.readException();
                    return;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void sendIidToken(String value, int phoneId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(value);
                    _data.writeInt(phoneId);
                    boolean _status = mRemote.transact(TRANSACTION_sendIidToken, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().sendIidToken(value, phoneId);
                        return;
                    }
                    _reply.readException();
                    return;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public ContentValues getConfigValues(String[] fields, int phoneId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStringArray(fields);
                    _data.writeInt(phoneId);
                    boolean _status = mRemote.transact(TRANSACTION_getConfigValues, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        return getDefaultImpl().getConfigValues(fields, phoneId);
                    }
                    _reply.readException();
                    return _reply.readInt() != 0 ? ContentValues.CREATOR.createFromParcel(_reply) : null;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean getBooleanConfig(String field, int phoneId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(field);
                    _data.writeInt(phoneId);
                    boolean _status = mRemote.transact(TRANSACTION_getBooleanConfig, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        return getDefaultImpl().getBooleanConfig(field, phoneId);
                    }
                    _reply.readException();
                    return _reply.readInt() != 0;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void sendSemCmcRecordingEvent(SemCmcRecordingInfo recordingInfo, int event, int phoneId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if (recordingInfo != null) {
                        _data.writeInt(1);
                        recordingInfo.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    _data.writeInt(event);
                    _data.writeInt(phoneId);
                    boolean _status = mRemote.transact(TRANSACTION_sendSemCmcRecordingEvent, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().sendSemCmcRecordingEvent(recordingInfo, event, phoneId);
                        return;
                    }
                    _reply.readException();
                    return;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void registerSemCmcRecordingListener(ISemCmcRecordingListener listener, int phoneId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    _data.writeInt(phoneId);
                    boolean _status = mRemote.transact(TRANSACTION_registerSemCmcRecordingListener, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().registerSemCmcRecordingListener(listener, phoneId);
                        return;
                    }
                    _reply.readException();
                    return;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public String registerEpdgListener(ISemEpdgListener listener) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder(listener != null ? listener.asBinder() : null);
                    boolean _status = mRemote.transact(TRANSACTION_registerEpdgListener, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        return getDefaultImpl().registerEpdgListener(listener);
                    }
                    _reply.readException();
                    return _reply.readString();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void unRegisterEpdgListener(String token) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(token);
                    boolean _status = mRemote.transact(TRANSACTION_unRegisterEpdgListener, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().unRegisterEpdgListener(token);
                        return;
                    }
                    _reply.readException();
                    return;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean isCmcEmergencyCallSupported() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(TRANSACTION_isCmcEmergencyCallSupported, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        return getDefaultImpl().isCmcEmergencyCallSupported();
                    }
                    _reply.readException();
                    return _reply.readInt() != 0;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean isCmcEmergencyNumber(String number) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(number);
                    boolean _status = mRemote.transact(TRANSACTION_isCmcEmergencyNumber, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        return getDefaultImpl().isCmcEmergencyNumber(number);
                    }
                    _reply.readException();
                    return _reply.readInt() != 0;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean isCmcPotentialEmergencyNumber(String number) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(number);
                    boolean _status = mRemote.transact(TRANSACTION_isCmcPotentialEmergencyNumber, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        return getDefaultImpl().isCmcPotentialEmergencyNumber(number);
                    }
                    _reply.readException();
                    return _reply.readInt() != 0;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean isCrossSimCallingRegistered(int phoneId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(phoneId);
                    boolean _status = mRemote.transact(TRANSACTION_isCrossSimCallingRegistered, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        return getDefaultImpl().isCrossSimCallingRegistered(phoneId);
                    }
                    _reply.readException();
                    return _reply.readInt() != 0;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public boolean hasCrossSimCallingSupport(int phoneId) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(phoneId);
                    boolean _status = mRemote.transact(TRANSACTION_hasCrossSimCallingSupport, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        return getDefaultImpl().hasCrossSimCallingSupport(phoneId);
                    }
                    _reply.readException();
                    return _reply.readInt() != 0;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}
