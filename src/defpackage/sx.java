package defpackage;

import com.zzhoujay.richtext.ImageHolder;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.channels.b;

/* loaded from: /tmp/classes2.dex */
public abstract class sx {
    public static final qx a(int i, BufferOverflow bufferOverflow, n81 n81Var) {
        if (i == -2) {
            return bufferOverflow == BufferOverflow.a ? new BufferedChannel(qx.a.a(), n81Var) : new b(1, bufferOverflow, n81Var);
        }
        if (i != -1) {
            return i != 0 ? i != Integer.MAX_VALUE ? bufferOverflow == BufferOverflow.a ? new BufferedChannel(i, n81Var) : new b(i, bufferOverflow, n81Var) : new BufferedChannel(ImageHolder.MATCH_PARENT, n81Var) : bufferOverflow == BufferOverflow.a ? new BufferedChannel(0, n81Var) : new b(1, bufferOverflow, n81Var);
        }
        if (bufferOverflow == BufferOverflow.a) {
            return new b(1, BufferOverflow.b, n81Var);
        }
        ik.a("CONFLATED capacity cannot be used with non-default onBufferOverflow");
        return null;
    }

    public static /* synthetic */ qx b(int i, BufferOverflow bufferOverflow, n81 n81Var, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        if ((i2 & 2) != 0) {
            bufferOverflow = BufferOverflow.a;
        }
        if ((i2 & 4) != 0) {
            n81Var = null;
        }
        return a(i, bufferOverflow, n81Var);
    }
}
