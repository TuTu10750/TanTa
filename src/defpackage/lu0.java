package defpackage;

import java.util.Set;
import kotlin.reflect.jvm.internal.impl.types.TypeUsage;

/* loaded from: /tmp/classes2.dex */
public abstract class lu0 {
    public final TypeUsage a;
    public final Set b;
    public final zp3 c;

    public lu0(TypeUsage typeUsage, Set set, zp3 zp3Var) {
        typeUsage.getClass();
        this.a = typeUsage;
        this.b = set;
        this.c = zp3Var;
    }

    public abstract zp3 a();

    public abstract TypeUsage b();

    public abstract Set c();

    public abstract lu0 d(oa4 oa4Var);

    public abstract int hashCode();
}
