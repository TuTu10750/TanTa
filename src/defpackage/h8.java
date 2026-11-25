package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver;
import kotlin.reflect.jvm.internal.impl.load.java.JavaTypeEnhancementState;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;

/* loaded from: /tmp/classes2.dex */
public final class h8 extends AbstractAnnotationTypeQualifierResolver {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h8(JavaTypeEnhancementState javaTypeEnhancementState) {
        super(javaTypeEnhancementState);
        javaTypeEnhancementState.getClass();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public Iterable b(d8 d8Var, boolean z) {
        d8Var.getClass();
        Map k = d8Var.k();
        ArrayList arrayList = new ArrayList();
        for (Map.Entry entry : k.entrySet()) {
            x20.A(arrayList, (!z || dq1.a((zo2) entry.getKey(), qu1.c)) ? y((k50) entry.getValue()) : s20.k());
        }
        return arrayList;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public r51 i(d8 d8Var) {
        d8Var.getClass();
        return d8Var.d();
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver
    /* renamed from: w, reason: merged with bridge method [inline-methods] */
    public Object j(d8 d8Var) {
        d8Var.getClass();
        m00 i = DescriptorUtilsKt.i(d8Var);
        i.getClass();
        return i;
    }

    @Override // kotlin.reflect.jvm.internal.impl.load.java.AbstractAnnotationTypeQualifierResolver
    /* renamed from: x, reason: merged with bridge method [inline-methods] */
    public Iterable k(d8 d8Var) {
        j8 annotations;
        d8Var.getClass();
        m00 i = DescriptorUtilsKt.i(d8Var);
        return (i == null || (annotations = i.getAnnotations()) == null) ? s20.k() : annotations;
    }

    public final List y(k50 k50Var) {
        if (!(k50Var instanceof mb)) {
            return k50Var instanceof iu0 ? r20.e(((iu0) k50Var).c().d()) : s20.k();
        }
        Iterable iterable = (Iterable) ((mb) k50Var).b();
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            x20.A(arrayList, y((k50) it.next()));
        }
        return arrayList;
    }
}
