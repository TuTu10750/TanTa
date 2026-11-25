package com.yunbao.beauty.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager$m;
import com.google.android.material.tabs.TabLayout;
import com.yunbao.beauty.bean.LiveFilterBean;
import com.yunbao.beauty.views.LiveBeautyPopupViewHolder;
import defpackage.b1;
import defpackage.c22;
import defpackage.gh1;
import defpackage.l93;
import defpackage.n83;
import defpackage.q02;
import defpackage.rp3;
import defpackage.t5;
import defpackage.th;
import defpackage.uh;
import defpackage.x63;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/classes2.dex */
public class LiveBeautyPopupViewHolder extends b1 implements gh1 {
    public static final Map i = new HashMap<String, String>() { // from class: com.yunbao.beauty.views.LiveBeautyPopupViewHolder.1
        {
            put("pink", "粉嫩");
            put("ruddy", "红润");
            put("ruddy2", "红润2");
            put("nature", "自然");
            put("freshy", "清新");
            put("beauty", "美肌");
            put("sweety", "甜美");
            put("sepia", "复古");
            put("blue", "蓝调");
            put("nostalgia", "怀旧");
            put("sakura", "樱花");
            put("sakura_night", "夜樱");
        }
    };
    public ViewGroup a;
    public View b;
    public SeekBar c;
    public TextView d;
    public q02 e;
    public c22 f;
    public boolean g;
    public gh1.a h;

    /* loaded from: /tmp/classes2.dex */
    public class a extends ViewPager$m {
        public a() {
        }

        public void c(int i) {
            LiveBeautyPopupViewHolder.this.b.setVisibility(i == 0 ? 0 : 8);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements SeekBar.OnSeekBarChangeListener {
        public b() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                LiveBeautyPopupViewHolder.this.j0(LiveBeautyPopupViewHolder.this.e.M(), i);
                LiveBeautyPopupViewHolder.this.d.setText(String.valueOf(i));
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    public LiveBeautyPopupViewHolder(Context context, ViewGroup viewGroup, boolean z) {
        super(context, viewGroup, Boolean.valueOf(z));
    }

    public static /* synthetic */ void a0(LiveBeautyPopupViewHolder liveBeautyPopupViewHolder, View view) {
        liveBeautyPopupViewHolder.getClass();
        rp3.e().n();
        rp3.e().m();
        liveBeautyPopupViewHolder.p0();
        q02 q02Var = liveBeautyPopupViewHolder.e;
        if (q02Var != null) {
            q02Var.p();
        }
    }

    public static /* synthetic */ void b0(LiveBeautyPopupViewHolder liveBeautyPopupViewHolder, int i2, LiveFilterBean liveFilterBean) {
        liveBeautyPopupViewHolder.getClass();
        String str = liveFilterBean.assetPath;
        rp3.e().s(str == null ? null : liveBeautyPopupViewHolder.m0(str));
    }

    public static int k0(int i2) {
        float f;
        float f2;
        float f3;
        rp3 e = rp3.e();
        uh c = e.c();
        t5 b2 = e.b();
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 == 2) {
                    f3 = b2.e;
                } else if (i2 == 3) {
                    f2 = b2.a;
                } else if (i2 != 4) {
                    f = i2 != 5 ? 0.0f : b2.f / 2.0f;
                } else {
                    f3 = b2.b;
                }
                f = f3 - 1.0f;
            } else {
                f2 = c.b;
            }
            f = f2 / 0.5f;
        } else {
            f = c.a;
        }
        float f4 = f >= 0.0f ? f : 0.0f;
        return Math.round((f4 <= 1.0f ? f4 : 1.0f) * 100.0f);
    }

    public static String q0(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        boolean z = false;
        if (lastIndexOf > 0) {
            str = str.substring(0, lastIndexOf);
        }
        int indexOf = str.indexOf(95);
        if (indexOf > 0) {
            String substring = str.substring(0, indexOf);
            boolean z2 = !substring.isEmpty();
            int i2 = 0;
            while (true) {
                if (i2 >= substring.length()) {
                    z = z2;
                    break;
                }
                if (!Character.isDigit(substring.charAt(i2))) {
                    break;
                }
                i2++;
            }
            if (z) {
                str = str.substring(indexOf + 1);
            }
        }
        String str2 = (String) i.get(str);
        return str2 != null ? str2 : str;
    }

    @Override // defpackage.gh1
    public void N(gh1.a aVar) {
        this.h = aVar;
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return n83.e;
    }

    @Override // defpackage.gh1
    public void hide() {
        removeFromParent();
        gh1.a aVar = this.h;
        if (aVar != null) {
            aVar.a(false);
        }
        this.g = false;
        rp3.e().q();
    }

    @Override // defpackage.b1
    public void init() {
        this.a = (ViewGroup) this.mContentView;
        this.b = findViewById(x63.o);
        this.c = (SeekBar) findViewById(x63.s);
        this.d = (TextView) findViewById(x63.A);
        View findViewById = findViewById(x63.e);
        View findViewById2 = findViewById(x63.d);
        if (findViewById2 != null) {
            findViewById2.setOnClickListener(new View.OnClickListener() { // from class: r02
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    LiveBeautyPopupViewHolder.this.hide();
                }
            });
        }
        ViewPager findViewById3 = findViewById(x63.p);
        TabLayout findViewById4 = findViewById(x63.w);
        View inflate = LayoutInflater.from(this.mContext).inflate(n83.f, (ViewGroup) findViewById3, false);
        View inflate2 = LayoutInflater.from(this.mContext).inflate(n83.g, (ViewGroup) findViewById3, false);
        n0(inflate);
        o0(inflate2);
        findViewById3.setAdapter(new th(Arrays.asList(inflate, inflate2), Arrays.asList(this.mContext.getString(l93.b), this.mContext.getString(l93.c))));
        findViewById4.setupWithViewPager(findViewById3);
        findViewById3.c(new a());
        findViewById.setOnClickListener(new View.OnClickListener() { // from class: s02
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                LiveBeautyPopupViewHolder.a0(LiveBeautyPopupViewHolder.this, view);
            }
        });
        this.c.setOnSeekBarChangeListener(new b());
    }

    @Override // defpackage.gh1
    public boolean isShowed() {
        return this.g;
    }

    public final void j0(int i2, int i3) {
        float f = i3 / 100.0f;
        rp3 e = rp3.e();
        if (i2 == 0) {
            e.c().a = f;
            e.k();
            return;
        }
        if (i2 == 1) {
            e.c().b = f * 0.5f;
            e.k();
            return;
        }
        if (i2 == 2) {
            e.b().e = f + 1.0f;
            e.j();
            return;
        }
        if (i2 == 3) {
            e.b().a = f * 0.5f;
            e.j();
        } else if (i2 == 4) {
            e.b().b = f + 1.0f;
            e.j();
        } else {
            if (i2 != 5) {
                return;
            }
            e.b().f = f * 2.0f;
            e.j();
        }
    }

    public final List l0() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new LiveFilterBean(this.mContext.getString(l93.a), null));
        try {
            String[] list = this.mContext.getAssets().list("KSYResource");
            if (list != null) {
                Arrays.sort(list);
                for (String str : list) {
                    if (str.toLowerCase().endsWith(".png") || str.toLowerCase().endsWith(".jpg")) {
                        arrayList.add(new LiveFilterBean(q0(str), "KSYResource/" + str));
                    }
                }
            }
        } catch (IOException unused) {
        }
        return arrayList;
    }

    public final Bitmap m0(String str) {
        try {
            InputStream open = this.mContext.getAssets().open(str);
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(open);
                if (open != null) {
                    open.close();
                }
                return decodeStream;
            } finally {
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public final void n0(View view) {
        RecyclerView findViewById = view.findViewById(x63.q);
        findViewById.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
        q02 q02Var = new q02(this.mContext);
        this.e = q02Var;
        q02Var.P(new q02.b() { // from class: u02
            @Override // q02.b
            public final void a(int i2, String str) {
                LiveBeautyPopupViewHolder.this.p0();
            }
        });
        findViewById.setAdapter(this.e);
        p0();
    }

    public final void o0(View view) {
        RecyclerView findViewById = view.findViewById(x63.r);
        findViewById.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
        c22 c22Var = new c22(this.mContext, l0());
        this.f = c22Var;
        c22Var.S(new c22.b() { // from class: t02
            @Override // c22.b
            public final void a(int i2, LiveFilterBean liveFilterBean) {
                LiveBeautyPopupViewHolder.b0(LiveBeautyPopupViewHolder.this, i2, liveFilterBean);
            }
        });
        findViewById.setAdapter(this.f);
    }

    public final void p0() {
        q02 q02Var = this.e;
        int k0 = k0(q02Var == null ? 0 : q02Var.M());
        this.c.setProgress(k0);
        this.d.setText(String.valueOf(k0));
    }

    @Override // defpackage.b1
    public void processArguments(Object... objArr) {
    }

    @Override // defpackage.gh1
    public void show() {
        View view;
        gh1.a aVar = this.h;
        if (aVar != null) {
            aVar.a(true);
        }
        if (this.mParentView != null && (view = this.mContentView) != null) {
            ViewParent parent = view.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(this.mContentView);
            }
            this.mParentView.addView(this.mContentView);
        }
        this.g = true;
    }
}
