/*
 * Copyright (C) 2026 The Android Open Source Project
 * Licensed under the Apache License, Version 2.0.
 */

package com.samsung.android.ims.options;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

import com.samsung.android.ims.util.SemImsUri;

import java.util.List;

/** @hide */
public interface SemCapabilityServiceEventListener extends IInterface {
    String DESCRIPTOR = "com.samsung.android.ims.options.SemCapabilityServiceEventListener";

    void onCapabilitiesChanged(SemImsUri uri, SemCapabilities capabilities)
            throws RemoteException;

    void onCapabilityAndAvailabilityPublished(int phoneId) throws RemoteException;

    void onMultipleCapabilitiesChanged(List<SemCapabilities> capabilities,
            List<SemCapabilities> availableCapabilities) throws RemoteException;

    void onOwnCapabilitiesChanged() throws RemoteException;

    /** @hide */
    class Default implements SemCapabilityServiceEventListener {
        @Override
        public IBinder asBinder() {
            return null;
        }

        @Override
        public void onCapabilitiesChanged(SemImsUri uri, SemCapabilities capabilities) {
        }

        @Override
        public void onCapabilityAndAvailabilityPublished(int phoneId) {
        }

        @Override
        public void onMultipleCapabilitiesChanged(List<SemCapabilities> capabilities,
                List<SemCapabilities> availableCapabilities) {
        }

        @Override
        public void onOwnCapabilitiesChanged() {
        }
    }

    /** @hide */
    abstract class Stub extends Binder implements SemCapabilityServiceEventListener {
        public static final int TRANSACTION_onCapabilitiesChanged = 2;
        public static final int TRANSACTION_onCapabilityAndAvailabilityPublished = 4;
        public static final int TRANSACTION_onMultipleCapabilitiesChanged = 3;
        public static final int TRANSACTION_onOwnCapabilitiesChanged = 1;

        private static SemCapabilityServiceEventListener sDefaultImpl;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static SemCapabilityServiceEventListener asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin instanceof SemCapabilityServiceEventListener) {
                return (SemCapabilityServiceEventListener) iin;
            }
            return new Proxy(obj);
        }

        @Override
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch (transactionCode) {
                case TRANSACTION_onCapabilitiesChanged:
                    return "onCapabilitiesChanged";
                case TRANSACTION_onCapabilityAndAvailabilityPublished:
                    return "onCapabilityAndAvailabilityPublished";
                case TRANSACTION_onMultipleCapabilitiesChanged:
                    return "onMultipleCapabilitiesChanged";
                case TRANSACTION_onOwnCapabilitiesChanged:
                    return "onOwnCapabilitiesChanged";
                default:
                    return null;
            }
        }

        public String getTransactionName(int transactionCode) {
            return getDefaultTransactionName(transactionCode);
        }

        public static boolean setDefaultImpl(SemCapabilityServiceEventListener impl) {
            if (sDefaultImpl != null || impl == null) {
                return false;
            }
            sDefaultImpl = impl;
            return true;
        }

        public static SemCapabilityServiceEventListener getDefaultImpl() {
            return sDefaultImpl;
        }

        @Override
        public boolean onTransact(int code, Parcel data, Parcel reply, int flags)
                throws RemoteException {
            if (code == INTERFACE_TRANSACTION) {
                reply.writeString(DESCRIPTOR);
                return true;
            }
            switch (code) {
                case TRANSACTION_onOwnCapabilitiesChanged:
                    data.enforceInterface(DESCRIPTOR);
                    onOwnCapabilitiesChanged();
                    reply.writeNoException();
                    return true;
                case TRANSACTION_onCapabilitiesChanged: {
                    data.enforceInterface(DESCRIPTOR);
                    SemImsUri uri = data.readInt() != 0
                            ? SemImsUri.CREATOR.createFromParcel(data) : null;
                    SemCapabilities capabilities = data.readInt() != 0
                            ? SemCapabilities.CREATOR.createFromParcel(data) : null;
                    onCapabilitiesChanged(uri, capabilities);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_onMultipleCapabilitiesChanged: {
                    data.enforceInterface(DESCRIPTOR);
                    List<SemCapabilities> capabilities = data.createTypedArrayList(
                            SemCapabilities.CREATOR);
                    List<SemCapabilities> availableCapabilities = data.createTypedArrayList(
                            SemCapabilities.CREATOR);
                    onMultipleCapabilitiesChanged(capabilities, availableCapabilities);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_onCapabilityAndAvailabilityPublished:
                    data.enforceInterface(DESCRIPTOR);
                    onCapabilityAndAvailabilityPublished(data.readInt());
                    reply.writeNoException();
                    return true;
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static final class Proxy implements SemCapabilityServiceEventListener {
            private final IBinder mRemote;

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
            public void onCapabilitiesChanged(SemImsUri uri, SemCapabilities capabilities)
                    throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    if (uri != null) {
                        data.writeInt(1);
                        uri.writeToParcel(data, 0);
                    } else {
                        data.writeInt(0);
                    }
                    if (capabilities != null) {
                        data.writeInt(1);
                        capabilities.writeToParcel(data, 0);
                    } else {
                        data.writeInt(0);
                    }
                    if (!mRemote.transact(TRANSACTION_onCapabilitiesChanged, data, reply, 0)
                            && getDefaultImpl() != null) {
                        getDefaultImpl().onCapabilitiesChanged(uri, capabilities);
                        return;
                    }
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }

            @Override
            public void onCapabilityAndAvailabilityPublished(int phoneId) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(phoneId);
                    if (!mRemote.transact(TRANSACTION_onCapabilityAndAvailabilityPublished, data,
                            reply, 0) && getDefaultImpl() != null) {
                        getDefaultImpl().onCapabilityAndAvailabilityPublished(phoneId);
                        return;
                    }
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }

            @Override
            public void onMultipleCapabilitiesChanged(List<SemCapabilities> capabilities,
                    List<SemCapabilities> availableCapabilities) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeTypedList(capabilities);
                    data.writeTypedList(availableCapabilities);
                    if (!mRemote.transact(TRANSACTION_onMultipleCapabilitiesChanged, data, reply,
                            0) && getDefaultImpl() != null) {
                        getDefaultImpl().onMultipleCapabilitiesChanged(capabilities,
                                availableCapabilities);
                        return;
                    }
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }

            @Override
            public void onOwnCapabilitiesChanged() throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    if (!mRemote.transact(TRANSACTION_onOwnCapabilitiesChanged, data, reply, 0)
                            && getDefaultImpl() != null) {
                        getDefaultImpl().onOwnCapabilitiesChanged();
                        return;
                    }
                    reply.readException();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }
        }
    }
}
