package defpackage;

import java.util.List;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.TypeDeserializer;

/* loaded from: /tmp/classes2.dex */
public final class vk0 {
    public final rk0 a;
    public final ap2 b;
    public final ra0 c;
    public final cb4 d;
    public final fg4 e;
    public final gi f;
    public final bl0 g;
    public final TypeDeserializer h;
    public final MemberDeserializer i;

    public vk0(rk0 rk0Var, ap2 ap2Var, ra0 ra0Var, cb4 cb4Var, fg4 fg4Var, gi giVar, bl0 bl0Var, TypeDeserializer typeDeserializer, List list) {
        String c;
        rk0Var.getClass();
        ap2Var.getClass();
        ra0Var.getClass();
        cb4Var.getClass();
        fg4Var.getClass();
        giVar.getClass();
        list.getClass();
        this.a = rk0Var;
        this.b = ap2Var;
        this.c = ra0Var;
        this.d = cb4Var;
        this.e = fg4Var;
        this.f = giVar;
        this.g = bl0Var;
        this.h = new TypeDeserializer(this, typeDeserializer, list, "Deserializer for \"" + ra0Var.getName() + '\"', (bl0Var == null || (c = bl0Var.c()) == null) ? "[container not found]" : c);
        this.i = new MemberDeserializer(this);
    }

    public static /* synthetic */ vk0 b(vk0 vk0Var, ra0 ra0Var, List list, ap2 ap2Var, cb4 cb4Var, fg4 fg4Var, gi giVar, int i, Object obj) {
        if ((i & 4) != 0) {
            ap2Var = vk0Var.b;
        }
        ap2 ap2Var2 = ap2Var;
        if ((i & 8) != 0) {
            cb4Var = vk0Var.d;
        }
        cb4 cb4Var2 = cb4Var;
        if ((i & 16) != 0) {
            fg4Var = vk0Var.e;
        }
        fg4 fg4Var2 = fg4Var;
        if ((i & 32) != 0) {
            giVar = vk0Var.f;
        }
        return vk0Var.a(ra0Var, list, ap2Var2, cb4Var2, fg4Var2, giVar);
    }

    public final vk0 a(ra0 ra0Var, List list, ap2 ap2Var, cb4 cb4Var, fg4 fg4Var, gi giVar) {
        ra0Var.getClass();
        list.getClass();
        ap2Var.getClass();
        cb4Var.getClass();
        fg4Var.getClass();
        giVar.getClass();
        rk0 rk0Var = this.a;
        if (!gg4.b(giVar)) {
            fg4Var = this.e;
        }
        return new vk0(rk0Var, ap2Var, ra0Var, cb4Var, fg4Var, giVar, this.g, this.h, list);
    }

    public final rk0 c() {
        return this.a;
    }

    public final bl0 d() {
        return this.g;
    }

    public final ra0 e() {
        return this.c;
    }

    public final MemberDeserializer f() {
        return this.i;
    }

    public final ap2 g() {
        return this.b;
    }

    public final lu3 h() {
        return this.a.u();
    }

    public final TypeDeserializer i() {
        return this.h;
    }

    public final cb4 j() {
        return this.d;
    }

    public final fg4 k() {
        return this.e;
    }
}
