package defpackage;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.greenrobot.eventbus.ThreadMode;

@Retention(RetentionPolicy.RUNTIME)
/* loaded from: /tmp/classes2.dex */
public @interface pw3 {
    int priority() default 0;

    boolean sticky() default false;

    ThreadMode threadMode() default ThreadMode.POSTING;
}
