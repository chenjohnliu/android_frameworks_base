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
public interface SemImsDmConfigListener extends IInterface {
    String DESCRIPTOR = "com.samsung.android.ims.SemImsDmConfigListener";

    void onChangeDmValue(String uri, boolean state) throws RemoteException;

    class Default implements SemImsDmConfigListener {
        @Override
        public void onChangeDmValue(String uri, boolean state) throws RemoteException {
        }

        @Override
        public IBinder asBinder() {
            return null;
        }
    }

    abstract class Stub extends Binder implements SemImsDmConfigListener {
        static final int TRANSACTION_onChangeDmValue = 1;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static SemImsDmConfigListener asInterface(IBinder obj) {
            if (obj == null) return null;
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin instanceof SemImsDmConfigListener) return (SemImsDmConfigListener) iin;
            return new Proxy(obj);
        }

        @Override
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch (transactionCode) {
                case TRANSACTION_onChangeDmValue: return "onChangeDmValue";
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
                case TRANSACTION_onChangeDmValue: {
                    data.enforceInterface(DESCRIPTOR);
                    String _arg0 = data.readString();
                    boolean _arg1 = data.readInt() != 0;
                    onChangeDmValue(_arg0, _arg1);
                    return true;
                }
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        public static boolean setDefaultImpl(SemImsDmConfigListener impl) {
            if (Proxy.sDefaultImpl != null || impl == null) return false;
            Proxy.sDefaultImpl = impl;
            return true;
        }

        public static SemImsDmConfigListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        private static class Proxy implements SemImsDmConfigListener {
            private final IBinder mRemote;
            static SemImsDmConfigListener sDefaultImpl;

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
            public void onChangeDmValue(String uri, boolean state) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeString(uri);
                    _data.writeInt(state ? 1 : 0);
                    boolean _status = mRemote.transact(TRANSACTION_onChangeDmValue, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onChangeDmValue(uri, state);
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
