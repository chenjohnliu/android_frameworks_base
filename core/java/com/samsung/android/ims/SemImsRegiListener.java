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
public interface SemImsRegiListener extends IInterface {
    String DESCRIPTOR = "com.samsung.android.ims.SemImsRegiListener";

    void onRegistered(SemImsRegistration registration) throws RemoteException;
    void onDeregistered(SemImsRegistration registration, SemImsRegistrationError error) throws RemoteException;

    class Default implements SemImsRegiListener {
        @Override
        public void onRegistered(SemImsRegistration registration) throws RemoteException {
        }
        @Override
        public void onDeregistered(SemImsRegistration registration, SemImsRegistrationError error) throws RemoteException {
        }

        @Override
        public IBinder asBinder() {
            return null;
        }
    }

    abstract class Stub extends Binder implements SemImsRegiListener {
        static final int TRANSACTION_onRegistered = 1;
        static final int TRANSACTION_onDeregistered = 2;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static SemImsRegiListener asInterface(IBinder obj) {
            if (obj == null) return null;
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin instanceof SemImsRegiListener) return (SemImsRegiListener) iin;
            return new Proxy(obj);
        }

        @Override
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch (transactionCode) {
                case TRANSACTION_onRegistered: return "onRegistered";
                case TRANSACTION_onDeregistered: return "onDeregistered";
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
                case TRANSACTION_onRegistered: {
                    data.enforceInterface(DESCRIPTOR);
                    SemImsRegistration _arg0 = data.readInt() != 0 ? SemImsRegistration.CREATOR.createFromParcel(data) : null;
                    onRegistered(_arg0);
                    return true;
                }
                case TRANSACTION_onDeregistered: {
                    data.enforceInterface(DESCRIPTOR);
                    SemImsRegistration _arg0 = data.readInt() != 0 ? SemImsRegistration.CREATOR.createFromParcel(data) : null;
                    SemImsRegistrationError _arg1 = data.readInt() != 0 ? SemImsRegistrationError.CREATOR.createFromParcel(data) : null;
                    onDeregistered(_arg0, _arg1);
                    return true;
                }
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        public static boolean setDefaultImpl(SemImsRegiListener impl) {
            if (Proxy.sDefaultImpl != null || impl == null) return false;
            Proxy.sDefaultImpl = impl;
            return true;
        }

        public static SemImsRegiListener getDefaultImpl() {
            return Proxy.sDefaultImpl;
        }

        private static class Proxy implements SemImsRegiListener {
            private final IBinder mRemote;
            static SemImsRegiListener sDefaultImpl;

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
            public void onRegistered(SemImsRegistration registration) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if (registration != null) {
                        _data.writeInt(1);
                        registration.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    boolean _status = mRemote.transact(TRANSACTION_onRegistered, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onRegistered(registration);
                        return;
                    }
                    return;
                } finally {
                    _data.recycle();
                }
            }

            @Override
            public void onDeregistered(SemImsRegistration registration, SemImsRegistrationError error) throws RemoteException {
                Parcel _data = Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if (registration != null) {
                        _data.writeInt(1);
                        registration.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    if (error != null) {
                        _data.writeInt(1);
                        error.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    boolean _status = mRemote.transact(TRANSACTION_onDeregistered, _data, null, IBinder.FLAG_ONEWAY);
                    if (!_status && getDefaultImpl() != null) {
                        getDefaultImpl().onDeregistered(registration, error);
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
