package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* loaded from: /tmp/classes2.dex */
public interface c extends IInterface {

    /* loaded from: /tmp/classes2.dex */
    public static class a implements c {
        @Override // com.umeng.analytics.pro.c
        public void a(int i, long j, boolean z, float f, double d, String str) {
        }

        @Override // com.umeng.analytics.pro.c
        public void a(int i, Bundle bundle) {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static abstract class b extends Binder implements c {
        static final int a = 1;
        static final int b = 2;
        private static final String c = "com.hihonor.cloudservice.oaid.IOAIDCallBack";

        /* loaded from: /tmp/classes2.dex */
        public static class a implements c {
            public static c a;
            private IBinder b;

            public a(IBinder iBinder) {
                this.b = iBinder;
            }

            public String a() {
                return b.c;
            }

            @Override // com.umeng.analytics.pro.c
            public void a(int i, long j, boolean z, float f, double d, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.c);
                    obtain.writeInt(i);
                    obtain.writeLong(j);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeFloat(f);
                    obtain.writeDouble(d);
                    obtain.writeString(str);
                    if (this.b.transact(1, obtain, obtain2, 0) || b.a() == null) {
                        obtain2.readException();
                    } else {
                        b.a().a(i, j, z, f, d, str);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // com.umeng.analytics.pro.c
            public void a(int i, Bundle bundle) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.c);
                    obtain.writeInt(i);
                    if (bundle != null) {
                        obtain.writeInt(1);
                        bundle.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    if (this.b.transact(2, obtain, obtain2, 0) || b.a() == null) {
                        obtain2.readException();
                    } else {
                        b.a().a(i, bundle);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.b;
            }
        }

        public b() {
            attachInterface(this, c);
        }

        public static c a() {
            return a.a;
        }

        public static c a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(c);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof c)) ? new a(iBinder) : (c) queryLocalInterface;
        }

        public static boolean a(c cVar) {
            if (a.a != null || cVar == null) {
                return false;
            }
            a.a = cVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(c);
                a(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i != 2) {
                if (i != 1598968902) {
                    return super.onTransact(i, parcel, parcel2, i2);
                }
                parcel2.writeString(c);
                return true;
            }
            parcel.enforceInterface(c);
            a(parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
            parcel2.writeNoException();
            return true;
        }
    }

    void a(int i, long j, boolean z, float f, double d, String str);

    void a(int i, Bundle bundle);
}
