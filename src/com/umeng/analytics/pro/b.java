package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: /tmp/classes2.dex */
public interface b extends IInterface {

    /* loaded from: /tmp/classes2.dex */
    public static class a implements b {
        @Override // com.umeng.analytics.pro.b
        public String a(String str) {
            return null;
        }

        @Override // com.umeng.analytics.pro.b
        public boolean a() {
            return false;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.umeng.analytics.pro.b
        public String b() {
            return null;
        }

        @Override // com.umeng.analytics.pro.b
        public String b(String str) {
            return null;
        }

        @Override // com.umeng.analytics.pro.b
        public String c(String str) {
            return null;
        }

        @Override // com.umeng.analytics.pro.b
        public String d(String str) {
            return null;
        }

        @Override // com.umeng.analytics.pro.b
        public String e(String str) {
            return null;
        }
    }

    /* renamed from: com.umeng.analytics.pro.b$b, reason: collision with other inner class name */
    /* loaded from: /tmp/classes2.dex */
    public static abstract class AbstractBinderC0012b extends Binder implements b {
        static final int a = 1;
        static final int b = 2;
        static final int c = 3;
        static final int d = 4;
        static final int e = 5;
        static final int f = 6;
        static final int g = 7;
        private static final String h = "com.coolpad.deviceidsupport.IDeviceIdManager";

        /* renamed from: com.umeng.analytics.pro.b$b$a */
        /* loaded from: /tmp/classes2.dex */
        public static class a implements b {
            public static b a;
            private IBinder b;

            public a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.umeng.analytics.pro.b
            public String a(String str) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0012b.h);
                    obtain.writeString(str);
                    if (this.b.transact(1, obtain, obtain2, 0) || AbstractBinderC0012b.c() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = AbstractBinderC0012b.c().a(str);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.b
            public boolean a() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0012b.h);
                    if (!this.b.transact(6, obtain, obtain2, 0) && AbstractBinderC0012b.c() != null) {
                        return AbstractBinderC0012b.c().a();
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

            @Override // com.umeng.analytics.pro.b
            public String b() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0012b.h);
                    if (this.b.transact(7, obtain, obtain2, 0) || AbstractBinderC0012b.c() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = AbstractBinderC0012b.c().b();
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.b
            public String b(String str) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0012b.h);
                    obtain.writeString(str);
                    if (this.b.transact(2, obtain, obtain2, 0) || AbstractBinderC0012b.c() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = AbstractBinderC0012b.c().b(str);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public String c() {
                return AbstractBinderC0012b.h;
            }

            @Override // com.umeng.analytics.pro.b
            public String c(String str) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0012b.h);
                    obtain.writeString(str);
                    if (this.b.transact(3, obtain, obtain2, 0) || AbstractBinderC0012b.c() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = AbstractBinderC0012b.c().c(str);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.b
            public String d(String str) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0012b.h);
                    obtain.writeString(str);
                    if (this.b.transact(4, obtain, obtain2, 0) || AbstractBinderC0012b.c() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = AbstractBinderC0012b.c().d(str);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            @Override // com.umeng.analytics.pro.b
            public String e(String str) {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(AbstractBinderC0012b.h);
                    obtain.writeString(str);
                    if (this.b.transact(5, obtain, obtain2, 0) || AbstractBinderC0012b.c() == null) {
                        obtain2.readException();
                        readString = obtain2.readString();
                    } else {
                        readString = AbstractBinderC0012b.c().e(str);
                    }
                    return readString;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public AbstractBinderC0012b() {
            attachInterface(this, h);
        }

        public static b a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(h);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof b)) ? new a(iBinder) : (b) queryLocalInterface;
        }

        public static boolean a(b bVar) {
            if (a.a != null || bVar == null) {
                return false;
            }
            a.a = bVar;
            return true;
        }

        public static b c() {
            return a.a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1598968902) {
                parcel2.writeString(h);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(h);
                    String a2 = a(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(a2);
                    return true;
                case 2:
                    parcel.enforceInterface(h);
                    String b2 = b(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(b2);
                    return true;
                case 3:
                    parcel.enforceInterface(h);
                    String c2 = c(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(c2);
                    return true;
                case 4:
                    parcel.enforceInterface(h);
                    String d2 = d(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(d2);
                    return true;
                case 5:
                    parcel.enforceInterface(h);
                    String e2 = e(parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeString(e2);
                    return true;
                case 6:
                    parcel.enforceInterface(h);
                    boolean a3 = a();
                    parcel2.writeNoException();
                    parcel2.writeInt(a3 ? 1 : 0);
                    return true;
                case 7:
                    parcel.enforceInterface(h);
                    String b3 = b();
                    parcel2.writeNoException();
                    parcel2.writeString(b3);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    String a(String str);

    boolean a();

    String b();

    String b(String str);

    String c(String str);

    String d(String str);

    String e(String str);
}
