package defpackage;

import java.io.DataInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /tmp/classes2.dex */
public final class wk extends gi {
    public static final a g = new a(null);
    public static final wk h = new wk(1, 0, 7);
    public static final wk i = new wk(new int[0]);

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final wk a(InputStream inputStream) {
            inputStream.getClass();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            pp1 pp1Var = new pp1(1, dataInputStream.readInt());
            ArrayList arrayList = new ArrayList(t20.v(pp1Var, 10));
            Iterator it = pp1Var.iterator();
            while (it.hasNext()) {
                ((lp1) it).nextInt();
                arrayList.add(Integer.valueOf(dataInputStream.readInt()));
            }
            int[] H0 = b30.H0(arrayList);
            return new wk(Arrays.copyOf(H0, H0.length));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public wk(int... iArr) {
        super(Arrays.copyOf(iArr, iArr.length));
        iArr.getClass();
    }

    public boolean h() {
        return f(h);
    }
}
