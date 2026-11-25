package defpackage;

import java.util.EnumMap;
import kotlin.reflect.jvm.internal.impl.load.java.AnnotationQualifierApplicabilityType;

/* loaded from: /tmp/classes2.dex */
public final class it1 {
    public final EnumMap a;

    public it1(EnumMap enumMap) {
        enumMap.getClass();
        this.a = enumMap;
    }

    public final wr1 a(AnnotationQualifierApplicabilityType annotationQualifierApplicabilityType) {
        return (wr1) this.a.get(annotationQualifierApplicabilityType);
    }

    public final EnumMap b() {
        return this.a;
    }
}
