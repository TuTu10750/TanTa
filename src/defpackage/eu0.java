package defpackage;

import androidx.room.RoomDatabase;

/* loaded from: /tmp/classes2.dex */
public abstract class eu0 extends to3 {
    public eu0(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    public abstract void g(gy3 gy3Var, Object obj);

    public final int h(Object obj) {
        gy3 a = a();
        try {
            g(a, obj);
            return a.u();
        } finally {
            f(a);
        }
    }
}
