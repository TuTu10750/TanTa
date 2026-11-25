package defpackage;

import defpackage.vv0;
import java.io.Closeable;
import kotlin.coroutines.b;
import kotlin.coroutines.d;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /tmp/classes2.dex */
public abstract class vv0 extends n70 implements Closeable, AutoCloseable {
    public static final a b = new a(null);

    /* loaded from: /tmp/classes2.dex */
    public static final class a extends b {
        public a() {
            super(n70.a, new n81() { // from class: uv0
                @Override // defpackage.n81
                public final Object invoke(Object obj) {
                    return vv0.a.c((d.b) obj);
                }
            });
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static vv0 c(d.b bVar) {
            if (bVar instanceof vv0) {
                return (vv0) bVar;
            }
            return null;
        }
    }
}
