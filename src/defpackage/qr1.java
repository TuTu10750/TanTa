package defpackage;

import java.util.Arrays;
import java.util.Set;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /tmp/classes2.dex */
public interface qr1 {

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public final q00 a;
        public final byte[] b;
        public final lr1 c;

        public a(q00 q00Var, byte[] bArr, lr1 lr1Var) {
            q00Var.getClass();
            this.a = q00Var;
            this.b = bArr;
            this.c = lr1Var;
        }

        public /* synthetic */ a(q00 q00Var, byte[] bArr, lr1 lr1Var, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(q00Var, (i & 2) != 0 ? null : bArr, (i & 4) != 0 ? null : lr1Var);
        }

        public final q00 a() {
            return this.a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return dq1.a(this.a, aVar.a) && dq1.a(this.b, aVar.b) && dq1.a(this.c, aVar.c);
        }

        public int hashCode() {
            int hashCode = this.a.hashCode() * 31;
            byte[] bArr = this.b;
            int hashCode2 = (hashCode + (bArr == null ? 0 : Arrays.hashCode(bArr))) * 31;
            lr1 lr1Var = this.c;
            return hashCode2 + (lr1Var != null ? lr1Var.hashCode() : 0);
        }

        public String toString() {
            return "Request(classId=" + this.a + ", previouslyFoundClassFileContent=" + Arrays.toString(this.b) + ", outerClass=" + this.c + ')';
        }
    }

    Set a(r51 r51Var);

    qs1 b(r51 r51Var, boolean z);

    lr1 c(a aVar);
}
