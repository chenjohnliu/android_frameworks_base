/*
 * Copyright (C) 2026 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.samsung.android.ims.options;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;

/** @hide */
public interface SemImsCapabilityService extends IInterface {
    String DESCRIPTOR = "com.samsung.android.ims.options.SemImsCapabilityService";

    SemCapabilities getCapabilities(String contactId, int phoneId, int refreshType)
            throws RemoteException;

    SemCapabilities[] getCapabilitiesByContactId(String contactId, int phoneId, int refreshType)
            throws RemoteException;

    SemCapabilities getCapabilitiesByNumber(String number, int phoneId, boolean refresh,
            int refreshType) throws RemoteException;

    SemCapabilities getOwnCapabilities(int phoneId) throws RemoteException;

    String registerListener(SemCapabilityServiceEventListener listener, int phoneId)
            throws RemoteException;

    void unregisterListener(String token, int phoneId) throws RemoteException;

    /** @hide */
    class Default implements SemImsCapabilityService {
        @Override
        public IBinder asBinder() {
            return null;
        }

        @Override
        public SemCapabilities getCapabilities(String contactId, int phoneId, int refreshType) {
            return null;
        }

        @Override
        public SemCapabilities[] getCapabilitiesByContactId(String contactId, int phoneId,
                int refreshType) {
            return null;
        }

        @Override
        public SemCapabilities getCapabilitiesByNumber(String number, int phoneId,
                boolean refresh, int refreshType) {
            return null;
        }

        @Override
        public SemCapabilities getOwnCapabilities(int phoneId) {
            return null;
        }

        @Override
        public String registerListener(SemCapabilityServiceEventListener listener, int phoneId) {
            return null;
        }

        @Override
        public void unregisterListener(String token, int phoneId) {
        }
    }

    /** @hide */
    abstract class Stub extends Binder implements SemImsCapabilityService {
        public static final int TRANSACTION_getCapabilities = 2;
        public static final int TRANSACTION_getCapabilitiesByContactId = 4;
        public static final int TRANSACTION_getCapabilitiesByNumber = 3;
        public static final int TRANSACTION_getOwnCapabilities = 1;
        public static final int TRANSACTION_registerListener = 5;
        public static final int TRANSACTION_unregisterListener = 6;

        private static SemImsCapabilityService sDefaultImpl;

        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        public static SemImsCapabilityService asInterface(IBinder obj) {
            if (obj == null) {
                return null;
            }
            IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (iin instanceof SemImsCapabilityService) {
                return (SemImsCapabilityService) iin;
            }
            return new Proxy(obj);
        }

        @Override
        public IBinder asBinder() {
            return this;
        }

        public static String getDefaultTransactionName(int transactionCode) {
            switch (transactionCode) {
                case TRANSACTION_getCapabilities:
                    return "getCapabilities";
                case TRANSACTION_getCapabilitiesByContactId:
                    return "getCapabilitiesByContactId";
                case TRANSACTION_getCapabilitiesByNumber:
                    return "getCapabilitiesByNumber";
                case TRANSACTION_getOwnCapabilities:
                    return "getOwnCapabilities";
                case TRANSACTION_registerListener:
                    return "registerListener";
                case TRANSACTION_unregisterListener:
                    return "unregisterListener";
                default:
                    return null;
            }
        }

        public String getTransactionName(int transactionCode) {
            return getDefaultTransactionName(transactionCode);
        }

        public static boolean setDefaultImpl(SemImsCapabilityService impl) {
            if (sDefaultImpl != null || impl == null) {
                return false;
            }
            sDefaultImpl = impl;
            return true;
        }

        public static SemImsCapabilityService getDefaultImpl() {
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
                case TRANSACTION_getOwnCapabilities: {
                    data.enforceInterface(DESCRIPTOR);
                    SemCapabilities result = getOwnCapabilities(data.readInt());
                    reply.writeNoException();
                    if (result != null) {
                        reply.writeInt(1);
                        result.writeToParcel(reply, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_getCapabilities: {
                    data.enforceInterface(DESCRIPTOR);
                    SemCapabilities result = getCapabilities(data.readString(), data.readInt(),
                            data.readInt());
                    reply.writeNoException();
                    if (result != null) {
                        reply.writeInt(1);
                        result.writeToParcel(reply, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_getCapabilitiesByNumber: {
                    data.enforceInterface(DESCRIPTOR);
                    SemCapabilities result = getCapabilitiesByNumber(data.readString(),
                            data.readInt(), data.readInt() != 0, data.readInt());
                    reply.writeNoException();
                    if (result != null) {
                        reply.writeInt(1);
                        result.writeToParcel(reply, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
                case TRANSACTION_getCapabilitiesByContactId: {
                    data.enforceInterface(DESCRIPTOR);
                    SemCapabilities[] result = getCapabilitiesByContactId(data.readString(),
                            data.readInt(), data.readInt());
                    reply.writeNoException();
                    reply.writeTypedArray(result, Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    return true;
                }
                case TRANSACTION_registerListener: {
                    data.enforceInterface(DESCRIPTOR);
                    String result = registerListener(
                            SemCapabilityServiceEventListener.Stub.asInterface(
                                    data.readStrongBinder()), data.readInt());
                    reply.writeNoException();
                    reply.writeString(result);
                    return true;
                }
                case TRANSACTION_unregisterListener: {
                    data.enforceInterface(DESCRIPTOR);
                    unregisterListener(data.readString(), data.readInt());
                    reply.writeNoException();
                    return true;
                }
                default:
                    return super.onTransact(code, data, reply, flags);
            }
        }

        private static final class Proxy implements SemImsCapabilityService {
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
            public SemCapabilities getCapabilities(String contactId, int phoneId, int refreshType)
                    throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeString(contactId);
                    data.writeInt(phoneId);
                    data.writeInt(refreshType);
                    if (!mRemote.transact(TRANSACTION_getCapabilities, data, reply, 0)
                            && getDefaultImpl() != null) {
                        return getDefaultImpl().getCapabilities(contactId, phoneId, refreshType);
                    }
                    reply.readException();
                    return reply.readInt() != 0 ? SemCapabilities.CREATOR.createFromParcel(reply)
                            : null;
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }

            @Override
            public SemCapabilities[] getCapabilitiesByContactId(String contactId, int phoneId,
                    int refreshType) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeString(contactId);
                    data.writeInt(phoneId);
                    data.writeInt(refreshType);
                    if (!mRemote.transact(TRANSACTION_getCapabilitiesByContactId, data, reply, 0)
                            && getDefaultImpl() != null) {
                        return getDefaultImpl().getCapabilitiesByContactId(contactId, phoneId,
                                refreshType);
                    }
                    reply.readException();
                    return reply.createTypedArray(SemCapabilities.CREATOR);
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }

            @Override
            public SemCapabilities getCapabilitiesByNumber(String number, int phoneId,
                    boolean refresh, int refreshType) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeString(number);
                    data.writeInt(phoneId);
                    data.writeInt(refresh ? 1 : 0);
                    data.writeInt(refreshType);
                    if (!mRemote.transact(TRANSACTION_getCapabilitiesByNumber, data, reply, 0)
                            && getDefaultImpl() != null) {
                        return getDefaultImpl().getCapabilitiesByNumber(number, phoneId, refresh,
                                refreshType);
                    }
                    reply.readException();
                    return reply.readInt() != 0 ? SemCapabilities.CREATOR.createFromParcel(reply)
                            : null;
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }

            @Override
            public SemCapabilities getOwnCapabilities(int phoneId) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeInt(phoneId);
                    if (!mRemote.transact(TRANSACTION_getOwnCapabilities, data, reply, 0)
                            && getDefaultImpl() != null) {
                        return getDefaultImpl().getOwnCapabilities(phoneId);
                    }
                    reply.readException();
                    return reply.readInt() != 0 ? SemCapabilities.CREATOR.createFromParcel(reply)
                            : null;
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }

            @Override
            public String registerListener(SemCapabilityServiceEventListener listener, int phoneId)
                    throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeStrongBinder(listener == null ? null : listener.asBinder());
                    data.writeInt(phoneId);
                    if (!mRemote.transact(TRANSACTION_registerListener, data, reply, 0)
                            && getDefaultImpl() != null) {
                        return getDefaultImpl().registerListener(listener, phoneId);
                    }
                    reply.readException();
                    return reply.readString();
                } finally {
                    reply.recycle();
                    data.recycle();
                }
            }

            @Override
            public void unregisterListener(String token, int phoneId) throws RemoteException {
                Parcel data = Parcel.obtain();
                Parcel reply = Parcel.obtain();
                try {
                    data.writeInterfaceToken(DESCRIPTOR);
                    data.writeString(token);
                    data.writeInt(phoneId);
                    if (!mRemote.transact(TRANSACTION_unregisterListener, data, reply, 0)
                            && getDefaultImpl() != null) {
                        getDefaultImpl().unregisterListener(token, phoneId);
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
