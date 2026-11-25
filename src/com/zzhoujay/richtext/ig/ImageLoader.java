package com.zzhoujay.richtext.ig;

import com.zzhoujay.richtext.callback.Recyclable;

/* loaded from: /tmp/classes2.dex */
interface ImageLoader extends Recyclable {
    void onFailure(Exception exc);

    void onLoading();

    void onResourceReady(ImageWrapper imageWrapper);

    int onSizeReady(int i, int i2);
}
