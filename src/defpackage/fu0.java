package defpackage;

import androidx.room.RoomDatabase;
import java.util.Iterator;

/* loaded from: /tmp/classes2.dex */
public abstract class fu0 extends to3 {
    public fu0(RoomDatabase roomDatabase) {
        super(roomDatabase);
    }

    public abstract void g(gy3 gy3Var, Object obj);

    public final void h(Iterable iterable) {
        gy3 a = a();
        try {
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                g(a, it.next());
                a.u0();
            }
        } finally {
            f(a);
        }
    }

    public final void i(Object obj) {
        gy3 a = a();
        try {
            g(a, obj);
            a.u0();
        } finally {
            f(a);
        }
    }
}
