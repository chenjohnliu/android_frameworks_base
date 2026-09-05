/*
 * Exact SM-M115F CWK3 legacy Binder ABI compatibility surface.
 * Generated from the stock DEX contract; hidden framework API.
 */
package com.samsung.android.ims.cmc;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/** @hide */
public interface ISemCmcRecordingListener extends IInterface {
    String DESCRIPTOR = "com.samsung.android.ims.cmc.ISemCmcRecordingListener";

    void onInfo(int what, int extra) throws RemoteException;
    void onError(int what, int extra) throws RemoteException;

    class Default implements ISemCmcRecordingListener {
        @Override
        public void onInfo(int what, int extra) throws RemoteException {
        }
        @Override
        public void onError(int what, int extra) throws RemoteException {
        }

        @Override
        public IBinder asBinder() {
            return null;
        }
    }

    abstract class Stub extends Binder implements ISemCmcRecordingListener {
        static final int TRANSACTION_onInfo = 1;
        static final int TRANSACTION_onError = 2;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static ISemCmcRecordingListener asInterface(IBinder obj) {
            if (obj == null) return null;
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin instanceof ISemCmcRecordingListener) return (ISemCmcRecordingListener) iin;
            return new Proxy(obj);
        }

        @Override
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch (transactionCode) {
                case TRANSACTION_onInfo: return "onInfo";
                case TRANSACTION_onError: return "onError";
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
                case TRANSACTION_onInfo: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0 = data.readInt();
                    int _arg1 = data.readInt();
                    onInfo(_arg0, _arg1);
                    return true;
                }
                case TRANSACTION_onError: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0 = data.readInt();
                    int _arg1 = data.readInt();
                    onError(_arg0, _arg1);
                    return true;
                }
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        public static boolean setDefaultImpl(ISemCmcRecordingListener impl) {
            if (Proxy.sDefaultImpl != null || impl == null) return false;
            Proxy.sDefaultImpl = impl;
            return true;
        }

        public static ISemCmcRecordingListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        private static class Proxy implements ISemCmcRecordingListener {
            private final IBinder mRemote;
            static ISemCmcRecordingListener sDefaultImpl;

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
            public void onInfo(int what, int extra) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(extra);
                    boolean _status = mRemote.transact(TRANSACTION_onInfo, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onInfo(what, extra);
                        return;
                    }
                    return;
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void onError(int what, int extra) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(what);
                    _data.writeInt(extra);
                    boolean _status = mRemote.transact(TRANSACTION_onError, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onError(what, extra);
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
