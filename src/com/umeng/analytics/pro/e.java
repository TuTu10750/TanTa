package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: /tmp/classes2.dex */
public interface e extends IInterface {

    /* loaded from: /tmp/classes2.dex */
    public static class a implements e {
        @Override // com.umeng.analytics.pro.e
        public String a() {
            return null;
        }

        @Override // com.umeng.analytics.pro.e
        public String a(String str) {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.umeng.analytics.pro.e
        public String b(String str) {
            return null;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static abstract class b extends Binder implements e {
        static final int a = 1;
        static final int b = 2;
        static final int c = 3;
        private static final String d = "com.samsung.android.deviceidservice.IDeviceIdService";

        /* loaded from: /tmp/classes2.dex */
        public static class a implements e {
            public static e a;
            private IBinder b;

            public a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.umeng.analytics.pro.e
            public String a() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.d);
                    if (this.b.transact(1, obtain, obtain2, 0) || b.b() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = b.b().a();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.e
            public String a(String str) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.d);
                    obtain.writeString(str);
                    if (this.b.transact(2, obtain, obtain2, 0) || b.b() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = b.b().a(str);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            public String b() {
                return b.d;
            }

            @Override // com.umeng.analytics.pro.e
            public String b(String str) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.d);
                    obtain.writeString(str);
                    if (this.b.transact(3, obtain, obtain2, 0) || b.b() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = b.b().b(str);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public b() {
            attachInterface(this, d);
        }

        public static e a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(d);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof e)) ? new a(iBinder) : (e) queryLocalInterface;
        }

        public static boolean a(e eVar) {
            if (a.a != null || eVar == null) {
                return false;
            }
            a.a = eVar;
            return true;
        }

        public static e b() {
            return a.a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(d);
                String a2 = a();
                parcel2.writeNoException();
                parcel2.writeString(a2);
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(d);
                String a3 = a(parcel.readString());
                parcel2.writeNoException();
                parcel2.writeString(a3);
                return true;
            }
            if (i != 3) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(d);
                return true;
            }
            parcel.enforceInterface(d);
            String b2 = b(parcel.readString());
            parcel2.writeNoException();
            parcel2.writeString(b2);
            return true;
        }
    }

    String a();

    String a(String str);

    String b(String str);
}
