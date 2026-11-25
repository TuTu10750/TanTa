package defpackage;

import java.io.IOException;

/* loaded from: /tmp/classes2.dex */
public final /* synthetic */ class iv1 {
    public static /* synthetic */ void a(Object obj, Object obj2) {
        StringBuilder sb = new StringBuilder();
        sb.append(obj);
        sb.append(obj2);
        throw new IOException(sb.toString());
    }
}
