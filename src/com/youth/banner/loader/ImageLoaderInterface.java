package com.youth.banner.loader;

import android.content.Context;
import android.view.View;
import java.io.Serializable;

/* loaded from: /tmp/classes2.dex */
public interface ImageLoaderInterface<T extends View> extends Serializable {
    View createImageView(Context context);

    void displayImage(Context context, Object obj, View view);
}
