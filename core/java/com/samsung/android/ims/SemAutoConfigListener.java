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
public interface SemAutoConfigListener extends IInterface {
    String DESCRIPTOR = "com.samsung.android.ims.SemAutoConfigListener";

    void onVerificationCodeNeeded() throws RemoteException;
    void onMsisdnNumberNeeded() throws RemoteException;
    void onIidTokenNeeded() throws RemoteException;
    void onAutoConfigurationCompleted(boolean completed) throws RemoteException;

    class Default implements SemAutoConfigListener {
        @Override
        public void onVerificationCodeNeeded() throws RemoteException {
        }
        @Override
        public void onMsisdnNumberNeeded() throws RemoteException {
        }
        @Override
        public void onIidTokenNeeded() throws RemoteException {
        }
        @Override
        public void onAutoConfigurationCompleted(boolean completed) throws RemoteException {
        }

        @Override
        public IBinder asBinder() {
            return null;
        }
    }

    abstract class Stub extends Binder implements SemAutoConfigListener {
        static final int TRANSACTION_onVerificationCodeNeeded = 1;
        static final int TRANSACTION_onMsisdnNumberNeeded = 2;
        static final int TRANSACTION_onIidTokenNeeded = 3;
        static final int TRANSACTION_onAutoConfigurationCompleted = 4;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static SemAutoConfigListener asInterface(IBinder obj) {
            if (obj == null) return null;
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin instanceof SemAutoConfigListener) return (SemAutoConfigListener) iin;
            return new Proxy(obj);
        }

        @Override
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch (transactionCode) {
                case TRANSACTION_onVerificationCodeNeeded: return "onVerificationCodeNeeded";
                case TRANSACTION_onMsisdnNumberNeeded: return "onMsisdnNumberNeeded";
                case TRANSACTION_onIidTokenNeeded: return "onIidTokenNeeded";
                case TRANSACTION_onAutoConfigurationCompleted: return "onAutoConfigurationCompleted";
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
                case TRANSACTION_onVerificationCodeNeeded: {
                    data.enforceInterface(DESCRIPTOR);
                    onVerificationCodeNeeded();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_onMsisdnNumberNeeded: {
                    data.enforceInterface(DESCRIPTOR);
                    onMsisdnNumberNeeded();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_onIidTokenNeeded: {
                    data.enforceInterface(DESCRIPTOR);
                    onIidTokenNeeded();
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_onAutoConfigurationCompleted: {
                    data.enforceInterface(DESCRIPTOR);
                    boolean _arg0 = data.readInt() != 0;
                    onAutoConfigurationCompleted(_arg0);
                    reply.writeNoException();
                    return true;
                }
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        public static boolean setDefaultImpl(SemAutoConfigListener impl) {
            if (Proxy.sDefaultImpl != null || impl == null) return false;
            Proxy.sDefaultImpl = impl;
            return true;
        }

        public static SemAutoConfigListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        private static class Proxy implements SemAutoConfigListener {
            private final IBinder mRemote;
            static SemAutoConfigListener sDefaultImpl;

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
            public void onVerificationCodeNeeded() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(TRANSACTION_onVerificationCodeNeeded, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onVerificationCodeNeeded();
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
            public void onMsisdnNumberNeeded() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(TRANSACTION_onMsisdnNumberNeeded, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onMsisdnNumberNeeded();
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
            public void onIidTokenNeeded() throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    boolean _status = mRemote.transact(TRANSACTION_onIidTokenNeeded, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onIidTokenNeeded();
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
            public void onAutoConfigurationCompleted(boolean completed) throws RemoteException {
                Parcel _data = Parcel.obtain();
                Parcel _reply = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(completed ? 1 : 0);
                    boolean _status = mRemote.transact(TRANSACTION_onAutoConfigurationCompleted, _data, _reply, 0);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onAutoConfigurationCompleted(completed);
                        return;
                    }
                    _reply.readException();
                    return;
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }
    }
}
