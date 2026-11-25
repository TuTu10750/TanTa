package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: /tmp/classes2.dex */
public interface eu extends IInterface {

    /* loaded from: /tmp/classes2.dex */
    public static class a implements eu {
        @Override // com.umeng.analytics.pro.eu
        public String a() {
            return null;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static abstract class b extends Binder implements eu {
        static final int a = 1;
        private static final String b = "com.zui.deviceidservice.IDeviceidInterface";

        /* loaded from: /tmp/classes2.dex */
        public static class a implements eu {
            public static eu a;
            private IBinder b;

            public a(IBinder iBinder) {
                this.b = iBinder;
            }

            @Override // com.umeng.analytics.pro.eu
            public String a() {
                String readString;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.b);
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

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }

            public String b() {
                return b.b;
            }
        }

        public b() {
            attachInterface(this, b);
        }

        public static eu a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(b);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof eu)) ? new a(iBinder) : (eu) queryLocalInterface;
        }

        public static boolean a(eu euVar) {
            if (a.a != null || euVar == null) {
                return false;
            }
            a.a = euVar;
            return true;
        }

        public static eu b() {
            return a.a;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i != 1) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(b);
                return true;
            }
            parcel.enforceInterface(b);
            String a2 = a();
            parcel2.writeNoException();
            parcel2.writeString(a2);
            return true;
        }
    }

    String a();
}
