package defpackage;

import java.util.List;
import java.util.Map;
import kotlin.reflect.KVisibility;

/* loaded from: /tmp/classes2.dex */
public interface ov1 extends nv1 {
    Object call(Object... objArr);

    Object callBy(Map map);

    String getName();

    List getParameters();

    lw1 getReturnType();

    List getTypeParameters();

    KVisibility getVisibility();

    boolean isAbstract();

    boolean isFinal();

    boolean isOpen();

    boolean isSuspend();
}
