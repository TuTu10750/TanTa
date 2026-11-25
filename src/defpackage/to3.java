package defpackage;

import androidx.room.RoomDatabase;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /tmp/classes2.dex */
public abstract class to3 {
    public final AtomicBoolean a = new AtomicBoolean(false);
    public final RoomDatabase b;
    public volatile gy3 c;

    public to3(RoomDatabase roomDatabase) {
        this.b = roomDatabase;
    }

    public gy3 a() {
        b();
        return e(this.a.compareAndSet(false, true));
    }

    public void b() {
        this.b.c();
    }

    public final gy3 c() {
        return this.b.f(d());
    }

    public abstract String d();

    public final gy3 e(boolean z) {
        if (!z) {
            return c();
        }
        if (this.c == null) {
            this.c = c();
        }
        return this.c;
    }

    public void f(gy3 gy3Var) {
        if (gy3Var == this.c) {
            this.a.set(false);
        }
    }
}
