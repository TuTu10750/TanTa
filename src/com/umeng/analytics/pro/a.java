package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: /tmp/classes2.dex */
public interface a extends IInterface {

    /* renamed from: com.umeng.analytics.pro.a$a, reason: collision with other inner class name */
    /* loaded from: /tmp/classes2.dex */
    public static class C0010a implements a {
        @Override // com.umeng.analytics.pro.a
        public String a(String str) {
            return null;
        }

        @Override // com.umeng.analytics.pro.a
        public boolean a() {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.umeng.analytics.pro.a
        public String b() {
            return null;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static abstract class b extends Binder implements a {
        static final int a = 1;
        static final int b = 2;
        static final int c = 3;
        private static final String d = "com.android.creator.IdsSupplier";

        /* renamed from: com.umeng.analytics.pro.a$b$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public static class C0011a implements a {
            public static a a;
            private IBinder b;

            public C0011a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.umeng.analytics.pro.a
            public String a(String str) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.d);
                    obtain.writeString(str);
                    if (this.b.transact(2, obtain, obtain2, 0) || b.c() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = b.c().a(str);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.a
            public boolean a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.d);
                    if (!this.b.transact(1, obtain, obtain2, 0) && b.c() != null) {
                        return b.c().a();
                    }
                    obtain2.readException();
                    return obtain2.readInt() != 0;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            @Override // com.umeng.analytics.pro.a
            public String b() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.d);
                    if (this.b.transact(3, obtain, obtain2, 0) || b.c() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = b.c().b();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String c() {
                return b.d;
            }
        }

        public b() {
            attachInterface(this, d);
        }

        public static a a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(d);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof a)) ? new C0011a(iBinder) : (a) queryLocalInterface;
        }

        public static boolean a(a aVar) {
            if (C0011a.a != null || aVar == null) {
                return false;
            }
            C0011a.a = aVar;
            return true;
        }

        public static a c() {
            return C0011a.a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(d);
                boolean a2 = a();
                parcel2.writeNoException();
                parcel2.writeInt(a2 ? 1 : 0);
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
            String b2 = b();
            parcel2.writeNoException();
            parcel2.writeString(b2);
            return true;
        }
    }

    String a(String str);

    boolean a();

    String b();
}
