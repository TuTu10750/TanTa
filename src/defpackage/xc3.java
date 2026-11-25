package defpackage;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.List;
import kotlin.reflect.jvm.internal.impl.descriptors.runtime.structure.ReflectClassUtilKt;

/* loaded from: /tmp/classes2.dex */
public abstract class xc3 {
    public static final tc3 a(Annotation[] annotationArr, r51 r51Var) {
        Annotation annotation;
        annotationArr.getClass();
        r51Var.getClass();
        int length = annotationArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                annotation = null;
                break;
            }
            annotation = annotationArr[i];
            if (dq1.a(ReflectClassUtilKt.a(wu1.b(wu1.a(annotation))).b(), r51Var)) {
                break;
            }
            i++;
        }
        if (annotation != null) {
            return new tc3(annotation);
        }
        return null;
    }

    public static final List b(Annotation[] annotationArr) {
        annotationArr.getClass();
        ArrayList arrayList = new ArrayList(annotationArr.length);
        for (Annotation annotation : annotationArr) {
            arrayList.add(new tc3(annotation));
        }
        return arrayList;
    }
}
