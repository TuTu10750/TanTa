package defpackage;

import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.a;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;
import kotlin.reflect.jvm.internal.impl.load.java.typeEnhancement.NullabilityQualifier;

/* loaded from: /tmp/classes2.dex */
public abstract class g8 {
    public static final r51 a = new r51("javax.annotation.meta.TypeQualifierNickname");
    public static final r51 b = new r51("javax.annotation.meta.TypeQualifier");
    public static final r51 c = new r51("javax.annotation.meta.TypeQualifierDefault");
    public static final r51 d = new r51("kotlin.annotations.jvm.UnderMigration");
    public static final List e;
    public static final Map f;
    public static final Map g;
    public static final Set h;

    static {
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType = AnnotationQualifierApplicabilityType.FIELD;
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType2 = AnnotationQualifierApplicabilityType.METHOD_RETURN_TYPE;
        AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType3 = AnnotationQualifierApplicabilityType.VALUE_PARAMETER;
        List n = s20.n(annotationQualifierApplicabilityType, annotationQualifierApplicabilityType2, annotationQualifierApplicabilityType3, AnnotationQualifierApplicabilityType.TYPE_PARAMETER_BOUNDS, AnnotationQualifierApplicabilityType.TYPE_USE);
        e = n;
        r51 l = ru1.l();
        NullabilityQualifier nullabilityQualifier = NullabilityQualifier.NOT_NULL;
        Map l2 = a.l(g94.a(l, new wr1(new pr2(nullabilityQualifier, false, 2, null), n, false)), g94.a(ru1.i(), new wr1(new pr2(nullabilityQualifier, false, 2, null), n, false)));
        f = l2;
        g = a.o(a.l(g94.a(new r51("javax.annotation.ParametersAreNullableByDefault"), new wr1(new pr2(NullabilityQualifier.NULLABLE, false, 2, null), r20.e(annotationQualifierApplicabilityType3), false, 4, null)), g94.a(new r51("javax.annotation.ParametersAreNonnullByDefault"), new wr1(new pr2(nullabilityQualifier, false, 2, null), r20.e(annotationQualifierApplicabilityType3), false, 4, null))), l2);
        h = eo3.h(ru1.f(), ru1.e());
    }

    public static final Map a() {
        return g;
    }

    public static final Set b() {
        return h;
    }

    public static final Map c() {
        return f;
    }

    public static final r51 d() {
        return d;
    }

    public static final r51 e() {
        return c;
    }

    public static final r51 f() {
        return b;
    }

    public static final r51 g() {
        return a;
    }
}
