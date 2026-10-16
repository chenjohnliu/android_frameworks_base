/*
 * Exact SM-M115F CWK3 legacy Binder ABI compatibility surface.
 * Generated from the stock DEX contract; hidden framework API.
 */
package com.samsung.android.ims;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/** @hide */
public interface ISemEpdgListener extends IInterface {
    String DESCRIPTOR = "com.samsung.android.ims.ISemEpdgListener";

    void onEpdgAvailable(int phoneId, boolean available, int wifiState) throws RemoteException;
    void onHandoverResult(int phoneId, int isL2WHandover, int result, String apnType) throws RemoteException;
    void onIpsecConnection(int phoneId, String apnType, int ikeError, int throttleCount) throws RemoteException;
    void onIpsecDisconnection(int phoneId, String apnType) throws RemoteException;
    void onEpdgShowPopup(int phoneId, int popupType) throws RemoteException;

    class Default implements ISemEpdgListener {
        @Override
        public void onEpdgAvailable(int phoneId, boolean available, int wifiState) throws RemoteException {
        }
        @Override
        public void onHandoverResult(int phoneId, int isL2WHandover, int result, String apnType) throws RemoteException {
        }
        @Override
        public void onIpsecConnection(int phoneId, String apnType, int ikeError, int throttleCount) throws RemoteException {
        }
        @Override
        public void onIpsecDisconnection(int phoneId, String apnType) throws RemoteException {
        }
        @Override
        public void onEpdgShowPopup(int phoneId, int popupType) throws RemoteException {
        }

        @Override
        public IBinder asBinder() {
            return null;
        }
    }

    abstract class Stub extends Binder implements ISemEpdgListener {
        static final int TRANSACTION_onEpdgAvailable = 1;
        static final int TRANSACTION_onHandoverResult = 2;
        static final int TRANSACTION_onIpsecConnection = 3;
        static final int TRANSACTION_onIpsecDisconnection = 4;
        static final int TRANSACTION_onEpdgShowPopup = 5;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ISemEpdgListener asInterface(IBinder obj) {
            if (obj == null) return null;
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin instanceof ISemEpdgListener) return (ISemEpdgListener) iin;
            return new Proxy(obj);
        }

        @Override
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch (transactionCode) {
                case TRANSACTION_onEpdgAvailable: return "onEpdgAvailable";
                case TRANSACTION_onHandoverResult: return "onHandoverResult";
                case TRANSACTION_onIpsecConnection: return "onIpsecConnection";
                case TRANSACTION_onIpsecDisconnection: return "onIpsecDisconnection";
                case TRANSACTION_onEpdgShowPopup: return "onEpdgShowPopup";
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
                case TRANSACTION_onEpdgAvailable: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0 = data.readInt();
                    boolean _arg1 = data.readInt() != 0;
                    int _arg2 = data.readInt();
                    onEpdgAvailable(_arg0, _arg1, _arg2);
                    return true;
                }
                case TRANSACTION_onHandoverResult: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0 = data.readInt();
                    int _arg1 = data.readInt();
                    int _arg2 = data.readInt();
                    String _arg3 = data.readString();
                    onHandoverResult(_arg0, _arg1, _arg2, _arg3);
                    return true;
                }
                case TRANSACTION_onIpsecConnection: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0 = data.readInt();
                    String _arg1 = data.readString();
                    int _arg2 = data.readInt();
                    int _arg3 = data.readInt();
                    onIpsecConnection(_arg0, _arg1, _arg2, _arg3);
                    return true;
                }
                case TRANSACTION_onIpsecDisconnection: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0 = data.readInt();
                    String _arg1 = data.readString();
                    onIpsecDisconnection(_arg0, _arg1);
                    return true;
                }
                case TRANSACTION_onEpdgShowPopup: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0 = data.readInt();
                    int _arg1 = data.readInt();
                    onEpdgShowPopup(_arg0, _arg1);
                    return true;
                }
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        public static boolean setDefaultImpl(ISemEpdgListener impl) {
            if (Proxy.sDefaultImpl != null || impl == null) return false;
            Proxy.sDefaultImpl = impl;
            return true;
        }

        public static ISemEpdgListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        private static class Proxy implements ISemEpdgListener {
            private final IBinder mRemote;
            static ISemEpdgListener sDefaultImpl;

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
            public void onEpdgAvailable(int phoneId, boolean available, int wifiState) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(phoneId);
                    _data.writeInt(available ? 1 : 0);
                    _data.writeInt(wifiState);
                    boolean _status = mRemote.transact(TRANSACTION_onEpdgAvailable, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onEpdgAvailable(phoneId, available, wifiState);
                        return;
                    }
                    return;
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void onHandoverResult(int phoneId, int isL2WHandover, int result, String apnType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(phoneId);
                    _data.writeInt(isL2WHandover);
                    _data.writeInt(result);
                    _data.writeString(apnType);
                    boolean _status = mRemote.transact(TRANSACTION_onHandoverResult, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onHandoverResult(phoneId, isL2WHandover, result, apnType);
                        return;
                    }
                    return;
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void onIpsecConnection(int phoneId, String apnType, int ikeError, int throttleCount) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(phoneId);
                    _data.writeString(apnType);
                    _data.writeInt(ikeError);
                    _data.writeInt(throttleCount);
                    boolean _status = mRemote.transact(TRANSACTION_onIpsecConnection, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onIpsecConnection(phoneId, apnType, ikeError, throttleCount);
                        return;
                    }
                    return;
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void onIpsecDisconnection(int phoneId, String apnType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(phoneId);
                    _data.writeString(apnType);
                    boolean _status = mRemote.transact(TRANSACTION_onIpsecDisconnection, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onIpsecDisconnection(phoneId, apnType);
                        return;
                    }
                    return;
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void onEpdgShowPopup(int phoneId, int popupType) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(phoneId);
                    _data.writeInt(popupType);
                    boolean _status = mRemote.transact(TRANSACTION_onEpdgShowPopup, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onEpdgShowPopup(phoneId, popupType);
                        return;
                    }
                    return;
                } finally {
                    _data.recycle();
                }
            }
        }
    }
}
