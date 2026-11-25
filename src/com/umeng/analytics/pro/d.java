package com.umeng.analytics.pro;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.umeng.analytics.pro.c;

/* loaded from: /tmp/classes2.dex */
public interface d extends IInterface {

    /* loaded from: /tmp/classes2.dex */
    public static class a implements d {
        @Override // com.umeng.analytics.pro.d
        public void a(int i, long j, boolean z, float f, double d, String str) {
        }

        @Override // com.umeng.analytics.pro.d
        public void a(c cVar) {
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        @Override // com.umeng.analytics.pro.d
        public void b(c cVar) {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static abstract class b extends Binder implements d {
        static final int a = 1;
        static final int b = 2;
        static final int c = 3;
        private static final String d = "com.hihonor.cloudservice.oaid.IOAIDService";

        /* loaded from: /tmp/classes2.dex */
        public static class a implements d {
            public static d a;
            private IBinder b;

            public a(IBinder iBinder) {
                this.b = iBinder;
            }

            public String a() {
                return b.d;
            }

            @Override // com.umeng.analytics.pro.d
            public void a(int i, long j, boolean z, float f, double d, String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.d);
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

            @Override // com.umeng.analytics.pro.d
            public void a(c cVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.d);
                    obtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    if (this.b.transact(2, obtain, obtain2, 0) || b.a() == null) {
                        obtain2.readException();
                    } else {
                        b.a().a(cVar);
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

            @Override // com.umeng.analytics.pro.d
            public void b(c cVar) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(b.d);
                    obtain.writeStrongBinder(cVar != null ? cVar.asBinder() : null);
                    if (this.b.transact(3, obtain, obtain2, 0) || b.a() == null) {
                        obtain2.readException();
                    } else {
                        b.a().b(cVar);
                    }
                    obtain2.recycle();
                    obtain.recycle();
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                    throw th;
                }
            }
        }

        public b() {
            attachInterface(this, d);
        }

        public static d a() {
            return a.a;
        }

        public static d a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(d);
            return (queryLocalInterface == null || !(queryLocalInterface instanceof d)) ? new a(iBinder) : (d) queryLocalInterface;
        }

        public static boolean a(d dVar) {
            if (a.a != null || dVar == null) {
                return false;
            }
            a.a = dVar;
            return true;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            if (i == 1) {
                parcel.enforceInterface(d);
                a(parcel.readInt(), parcel.readLong(), parcel.readInt() != 0, parcel.readFloat(), parcel.readDouble(), parcel.readString());
                parcel2.writeNoException();
                return true;
            }
            if (i == 2) {
                parcel.enforceInterface(d);
                a(c.b.a(parcel.readStrongBinder()));
                parcel2.writeNoException();
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
            b(c.b.a(parcel.readStrongBinder()));
            parcel2.writeNoException();
            return true;
        }
    }

    void a(int i, long j, boolean z, float f, double d, String str);

    void a(c cVar);

    void b(c cVar);
}
