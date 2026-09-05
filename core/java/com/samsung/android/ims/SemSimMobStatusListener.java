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
public interface SemSimMobStatusListener extends IInterface {
    String DESCRIPTOR = "com.samsung.android.ims.SemSimMobStatusListener";

    void onSimMobilityStateChanged(boolean activated) throws RemoteException;

    class Default implements SemSimMobStatusListener {
        @Override
        public void onSimMobilityStateChanged(boolean activated) throws RemoteException {
        }

        @Override
        public IBinder asBinder() {
            return null;
        }
    }

    abstract class Stub extends Binder implements SemSimMobStatusListener {
        static final int TRANSACTION_onSimMobilityStateChanged = 1;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static SemSimMobStatusListener asInterface(IBinder obj) {
            if (obj == null) return null;
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin instanceof SemSimMobStatusListener) return (SemSimMobStatusListener) iin;
            return new Proxy(obj);
        }

        @Override
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch (transactionCode) {
                case TRANSACTION_onSimMobilityStateChanged: return "onSimMobilityStateChanged";
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
                case TRANSACTION_onSimMobilityStateChanged: {
                    data.enforceInterface(DESCRIPTOR);
                    boolean _arg0 = data.readInt() != 0;
                    onSimMobilityStateChanged(_arg0);
                    return true;
                }
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        public static boolean setDefaultImpl(SemSimMobStatusListener impl) {
            if (Proxy.sDefaultImpl != null || impl == null) return false;
            Proxy.sDefaultImpl = impl;
            return true;
        }

        public static SemSimMobStatusListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        private static class Proxy implements SemSimMobStatusListener {
            private final IBinder mRemote;
            static SemSimMobStatusListener sDefaultImpl;

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
            public void onSimMobilityStateChanged(boolean activated) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(activated ? 1 : 0);
                    boolean _status = mRemote.transact(TRANSACTION_onSimMobilityStateChanged, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onSimMobilityStateChanged(activated);
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
