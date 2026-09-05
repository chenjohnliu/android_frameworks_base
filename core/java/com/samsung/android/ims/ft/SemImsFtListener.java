/*
 * Exact SM-M115F CWK3 legacy Binder ABI compatibility surface.
 * Generated from the stock DEX contract; hidden framework API.
 */
package com.samsung.android.ims.ft;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/** @hide */
public interface SemImsFtListener extends IInterface {
    String DESCRIPTOR = "com.samsung.android.ims.ft.SemImsFtListener";

    void onFtStateChanged(boolean ongoing) throws RemoteException;

    class Default implements SemImsFtListener {
        @Override
        public void onFtStateChanged(boolean ongoing) throws RemoteException {
        }

        @Override
        public IBinder asBinder() {
            return null;
        }
    }

    abstract class Stub extends Binder implements SemImsFtListener {
        static final int TRANSACTION_onFtStateChanged = 1;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static SemImsFtListener asInterface(IBinder obj) {
            if (obj == null) return null;
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin instanceof SemImsFtListener) return (SemImsFtListener) iin;
            return new Proxy(obj);
        }

        @Override
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch (transactionCode) {
                case TRANSACTION_onFtStateChanged: return "onFtStateChanged";
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
                case TRANSACTION_onFtStateChanged: {
                    data.enforceInterface(DESCRIPTOR);
                    boolean _arg0 = data.readInt() != 0;
                    onFtStateChanged(_arg0);
                    return true;
                }
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        public static boolean setDefaultImpl(SemImsFtListener impl) {
            if (Proxy.sDefaultImpl != null || impl == null) return false;
            Proxy.sDefaultImpl = impl;
            return true;
        }

        public static SemImsFtListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        private static class Proxy implements SemImsFtListener {
            private final IBinder mRemote;
            static SemImsFtListener sDefaultImpl;

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
            public void onFtStateChanged(boolean ongoing) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(ongoing ? 1 : 0);
                    boolean _status = mRemote.transact(TRANSACTION_onFtStateChanged, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onFtStateChanged(ongoing);
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
