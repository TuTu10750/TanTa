package com.yunbao.mall.bean;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import defpackage.kn1;

/* loaded from: /tmp/classes2.dex */
public class MainMallGoodsBean extends GoodsSimpleBean {
    private int mDisplayHeight;
    private Drawable mDrawable;
    private ImageView mImageView;

    /* JADX INFO: Access modifiers changed from: private */
    public void showDrawable(int i, int i2) {
        if (this.mDrawable != null) {
            if (this.mDisplayHeight == 0) {
                int intrinsicHeight = (int) ((this.mDrawable.getIntrinsicHeight() / r0.getIntrinsicWidth()) * i);
                if (intrinsicHeight <= i2) {
                    i2 = intrinsicHeight;
                }
                this.mDisplayHeight = i2;
            }
            ImageView imageView = this.mImageView;
            if (imageView != null) {
                ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
                int i3 = layoutParams.height;
                int i4 = this.mDisplayHeight;
                if (i3 != i4) {
                    layoutParams.height = i4;
                    this.mImageView.requestLayout();
                }
                this.mImageView.setImageDrawable(this.mDrawable);
            }
        }
    }

    public void display(Context context, ImageView imageView, final int i, final int i2) {
        imageView.setImageDrawable(null);
        this.mImageView = imageView;
        if (this.mDrawable == null) {
            kn1.j(context, this.mThumb, new kn1.a() { // from class: com.yunbao.mall.bean.MainMallGoodsBean.1
                @Override // kn1.a
                public void onLoadFailed() {
                    if (MainMallGoodsBean.this.mImageView != null) {
                        ViewGroup.LayoutParams layoutParams = MainMallGoodsBean.this.mImageView.getLayoutParams();
                        int i3 = layoutParams.height;
                        int i4 = i;
                        if (i3 != i4) {
                            layoutParams.height = i4;
                            MainMallGoodsBean.this.mImageView.requestLayout();
                        }
                        MainMallGoodsBean.this.mImageView.setImageDrawable(null);
                    }
                }

                @Override // kn1.a
                public void onLoadSuccess(Drawable drawable) {
                    MainMallGoodsBean.this.mDrawable = drawable;
                    MainMallGoodsBean.this.showDrawable(i, i2);
                }
            });
        } else {
            showDrawable(i, i2);
        }
    }
}
