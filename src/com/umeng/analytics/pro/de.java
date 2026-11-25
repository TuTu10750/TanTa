package com.umeng.analytics.pro;

import com.umeng.analytics.pro.de;
import com.umeng.analytics.pro.dl;
import java.io.Serializable;

/* loaded from: /tmp/classes2.dex */
public interface de<T extends de<?, ?>, F extends dl> extends Serializable {
    void clear();

    de<T, F> deepCopy();

    F fieldForId(int i);

    void read(ed edVar);

    void write(ed edVar);
}
