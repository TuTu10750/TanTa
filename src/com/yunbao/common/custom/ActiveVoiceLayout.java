package com.yunbao.common.custom;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.umeng.analytics.pro.bv;
import com.umeng.commonsdk.statistics.UMErrorCode;
import defpackage.fa2;
import defpackage.j30;
import defpackage.q83;
import defpackage.rv3;
import java.io.File;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* loaded from: /tmp/classes2.dex */
public class ActiveVoiceLayout extends FrameLayout implements View.OnClickListener {
    public Context a;
    public float b;
    public ImageView c;
    public TextView d;
    public Drawable[] e;
    public boolean f;
    public Handler g;
    public int h;
    public int i;
    public int j;
    public String k;
    public b l;

    /* loaded from: /tmp/classes2.dex */
    public class a extends Handler {
        public a() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                ActiveVoiceLayout.this.c();
            } else {
                if (i != 1) {
                    return;
                }
                ActiveVoiceLayout.this.d();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface b {
        File a();

        void b();

        void c(ActiveVoiceLayout activeVoiceLayout, File file);

        void d(ActiveVoiceLayout activeVoiceLayout, String str);
    }

    public ActiveVoiceLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActiveVoiceLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
        this.b = context.getResources().getDisplayMetrics().density;
        Drawable[] drawableArr = new Drawable[3];
        this.e = drawableArr;
        drawableArr[0] = o60.d(context, q83.b1);
        this.e[1] = o60.d(context, q83.c1);
        this.e[2] = o60.d(context, q83.d1);
        setOnClickListener(this);
    }

    public final void c() {
        int i = this.j + 1;
        this.j = i;
        if (i >= 3) {
            this.j = 0;
        }
        ImageView imageView = this.c;
        if (imageView != null) {
            imageView.setImageDrawable(this.e[this.j]);
        }
        Handler handler = this.g;
        if (handler != null) {
            handler.sendEmptyMessageAtTime(0, f(200));
        }
    }

    public final void d() {
        Handler handler;
        this.h--;
        TextView textView = this.d;
        if (textView != null) {
            textView.setText(this.h + bv.aB);
        }
        if (this.h <= 0 || (handler = this.g) == null) {
            return;
        }
        handler.sendEmptyMessageAtTime(1, f(IjkMediaCodecInfo.RANK_MAX));
    }

    public final int e(int i) {
        return (int) ((this.b * i) + 0.5f);
    }

    public final long f(int i) {
        long uptimeMillis = SystemClock.uptimeMillis();
        return i < 1000 ? uptimeMillis + i : i + uptimeMillis + ((-uptimeMillis) % 1000);
    }

    public boolean g() {
        return this.f;
    }

    public String getVoiceUrl() {
        return this.k;
    }

    public void h() {
        Handler handler = this.g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        ImageView imageView = this.c;
        if (imageView != null) {
            imageView.setImageDrawable(null);
        }
        this.l = null;
    }

    public void i() {
        File file;
        if (TextUtils.isEmpty(this.k)) {
            b bVar = this.l;
            file = bVar != null ? bVar.a() : null;
            if (file == null || !file.exists()) {
                return;
            }
        } else {
            file = new File(rv3.a(j30.L, fa2.a(this.k)));
            if (!file.exists()) {
                b bVar2 = this.l;
                if (bVar2 != null) {
                    bVar2.d(this, this.k);
                    return;
                }
                return;
            }
        }
        this.f = true;
        if (this.g == null) {
            this.g = new a();
        }
        this.h = this.i;
        this.g.sendEmptyMessageAtTime(0, f(200));
        this.g.sendEmptyMessageAtTime(1, f(IjkMediaCodecInfo.RANK_MAX));
        b bVar3 = this.l;
        if (bVar3 != null) {
            bVar3.c(this, file);
        }
    }

    public void j() {
        this.f = false;
        this.j = 0;
        this.h = this.i;
        Handler handler = this.g;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        TextView textView = this.d;
        if (textView != null) {
            textView.setText(this.i + bv.aB);
        }
        ImageView imageView = this.c;
        if (imageView != null) {
            imageView.setImageDrawable(this.e[this.j]);
        }
        b bVar = this.l;
        if (bVar != null) {
            bVar.b();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.f) {
            j();
        } else {
            i();
        }
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        this.c = new ImageView(this.a);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(e(UMErrorCode.E_UM_BE_NOT_MAINPROCESS), e(22));
        layoutParams.gravity = 16;
        layoutParams.leftMargin = e(15);
        this.c.setLayoutParams(layoutParams);
        this.c.setImageDrawable(this.e[0]);
        addView(this.c);
        this.d = new TextView(this.a);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 21;
        layoutParams2.rightMargin = e(13);
        this.d.setLayoutParams(layoutParams2);
        this.d.setTextColor(-1);
        this.d.setTextSize(12.0f);
        addView(this.d);
    }

    public void setActionListener(b bVar) {
        this.l = bVar;
    }

    public void setSecondsMax(int i) {
        this.i = i;
        TextView textView = this.d;
        if (textView != null) {
            textView.setText(this.i + bv.aB);
        }
    }

    public void setVoiceUrl(String str) {
        this.k = str;
    }
}
