package defpackage;

import java.util.Random;

/* loaded from: /tmp/classes2.dex */
public final class qz0 extends w1 {
    public final a c = new a();

    /* loaded from: /tmp/classes2.dex */
    public static final class a extends ThreadLocal {
        @Override // java.lang.ThreadLocal
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Random initialValue() {
            return new Random();
        }
    }

    @Override // defpackage.w1
    public Random c() {
        Object obj = this.c.get();
        obj.getClass();
        return (Random) obj;
    }
}
