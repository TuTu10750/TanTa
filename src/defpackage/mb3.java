package defpackage;

import java.io.InputStream;
import kotlin.Pair;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf$PackageFragment;
import kotlin.reflect.jvm.internal.impl.protobuf.d;

/* loaded from: /tmp/classes2.dex */
public abstract class mb3 {
    public static final Pair a(InputStream inputStream) {
        ProtoBuf$PackageFragment protoBuf$PackageFragment;
        inputStream.getClass();
        try {
            wk a = wk.g.a(inputStream);
            if (a.h()) {
                d d = d.d();
                yk.a(d);
                protoBuf$PackageFragment = ProtoBuf$PackageFragment.W(inputStream, d);
            } else {
                protoBuf$PackageFragment = null;
            }
            Pair a2 = g94.a(protoBuf$PackageFragment, a);
            o10.a(inputStream, null);
            return a2;
        } finally {
        }
    }
}
