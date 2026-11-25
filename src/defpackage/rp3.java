package defpackage;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.CommonAppContext;
import com.yunbao.common.http.CommonHttpUtil;

/* loaded from: /tmp/classes2.dex */
public class rp3 {
    public static rp3 g;
    public int a;
    public int b;
    public int c;
    public uh d = new uh();
    public t5 e = new t5();
    public fh1 f;

    public static rp3 e() {
        if (g == null) {
            synchronized (rp3.class) {
                try {
                    if (g == null) {
                        g = new rp3();
                    }
                } finally {
                }
            }
        }
        return g;
    }

    public rp3 a() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        i();
        h();
        return this;
    }

    public t5 b() {
        return this.e;
    }

    public uh c() {
        return this.d;
    }

    public int d() {
        return this.c;
    }

    public int f() {
        return this.a;
    }

    public int g() {
        return this.b;
    }

    public final void h() {
        SharedPreferences x = x();
        t5 t5Var = this.e;
        t5Var.a = x.getFloat("adj_brightness", 0.0f);
        t5Var.b = x.getFloat("adj_contrast", 1.0f);
        t5Var.c = x.getFloat("adj_exposure", 0.0f);
        t5Var.d = x.getFloat("adj_hue", 0.0f);
        t5Var.e = x.getFloat("adj_saturation", 1.0f);
        t5Var.f = x.getFloat("adj_sharpness", 0.0f);
    }

    public final void i() {
        SharedPreferences x = x();
        boolean isEmpty = x.getAll().isEmpty();
        uh uhVar = this.d;
        if (isEmpty) {
            uhVar.a();
            return;
        }
        uhVar.a = x.getFloat("beautyIntensity", 0.5f);
        uhVar.b = x.getFloat("complexionIntensity", 0.5f);
        uhVar.c = x.getFloat("faceLift", 0.0f);
        uhVar.d = x.getFloat("faceShave", 0.0f);
        uhVar.e = x.getFloat("faceNarrow", 0.0f);
        uhVar.f = x.getFloat("chinIntensity", 0.0f);
        uhVar.g = x.getFloat("nasolabialFoldsIntensity", 0.0f);
        uhVar.h = x.getFloat("foreheadIntensity", 0.0f);
        uhVar.i = x.getFloat("eyeEnlargeIntensity", 0.0f);
        uhVar.j = x.getFloat("eyeDistanceIntensity", 0.0f);
        uhVar.k = x.getFloat("eyeCornerIntensity", 0.0f);
        uhVar.l = x.getFloat("eyeFurrowsIntensity", 0.0f);
        uhVar.m = x.getFloat("eyeBagsIntensity", 0.0f);
        uhVar.n = x.getFloat("eyeBrightIntensity", 0.0f);
        uhVar.o = x.getFloat("noseThinIntensity", 0.0f);
        uhVar.p = x.getFloat("alaeIntensity", 0.0f);
        uhVar.q = x.getFloat("proboscisIntensity", 0.0f);
        uhVar.r = x.getFloat("mouthEnlargeIntensity", 0.0f);
        uhVar.s = x.getFloat("teethBeautyIntensity", 0.0f);
    }

    public void j() {
        fh1 fh1Var = this.f;
        if (fh1Var != null) {
            fh1Var.d(this.e);
        }
        o();
    }

    public void k() {
        fh1 fh1Var = this.f;
        if (fh1Var != null) {
            fh1Var.c(this.d);
        }
        p();
    }

    public void l() {
        this.a = 0;
        this.b = 0;
        this.c = 0;
        this.d = new uh();
        this.e = new t5();
        this.f = null;
    }

    public void m() {
        this.e = new t5();
        j();
    }

    public void n() {
        this.d.a();
        k();
    }

    public final void o() {
        t5 t5Var = this.e;
        x().edit().putFloat("adj_brightness", t5Var.a).putFloat("adj_contrast", t5Var.b).putFloat("adj_exposure", t5Var.c).putFloat("adj_hue", t5Var.d).putFloat("adj_saturation", t5Var.e).putFloat("adj_sharpness", t5Var.f).apply();
    }

    public final void p() {
        uh uhVar = this.d;
        x().edit().putFloat("beautyIntensity", uhVar.a).putFloat("complexionIntensity", uhVar.b).putFloat("faceLift", uhVar.c).putFloat("faceShave", uhVar.d).putFloat("faceNarrow", uhVar.e).putFloat("chinIntensity", uhVar.f).putFloat("nasolabialFoldsIntensity", uhVar.g).putFloat("foreheadIntensity", uhVar.h).putFloat("eyeEnlargeIntensity", uhVar.i).putFloat("eyeDistanceIntensity", uhVar.j).putFloat("eyeCornerIntensity", uhVar.k).putFloat("eyeFurrowsIntensity", uhVar.l).putFloat("eyeBagsIntensity", uhVar.m).putFloat("eyeBrightIntensity", uhVar.n).putFloat("noseThinIntensity", uhVar.o).putFloat("alaeIntensity", uhVar.p).putFloat("proboscisIntensity", uhVar.q).putFloat("mouthEnlargeIntensity", uhVar.r).putFloat("teethBeautyIntensity", uhVar.s).apply();
    }

    public void q() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("skin_whiting", Integer.valueOf(this.a));
        jSONObject.put("skin_smooth", Integer.valueOf(this.b));
        jSONObject.put("skin_tenderness", Integer.valueOf(this.c));
        CommonHttpUtil.setBeautyValue(jSONObject.toJSONString());
    }

    public void r(int i, int i2, int i3) {
        this.a = i;
        this.b = i2;
        this.c = i3;
        fh1 fh1Var = this.f;
        if (fh1Var != null) {
            fh1Var.a(i, true, i2, true, i3, true);
        }
    }

    public void s(Bitmap bitmap) {
        fh1 fh1Var = this.f;
        if (fh1Var != null) {
            fh1Var.b(bitmap);
        }
    }

    public void t(int i) {
        if (this.c != i) {
            this.c = i;
            fh1 fh1Var = this.f;
            if (fh1Var != null) {
                fh1Var.a(this.a, false, this.b, false, i, true);
            }
        }
    }

    public void u(int i) {
        if (this.a != i) {
            this.a = i;
            fh1 fh1Var = this.f;
            if (fh1Var != null) {
                fh1Var.a(i, true, this.b, false, this.c, false);
            }
        }
    }

    public void v(fh1 fh1Var) {
        this.f = fh1Var;
    }

    public void w(int i) {
        if (this.b != i) {
            this.b = i;
            fh1 fh1Var = this.f;
            if (fh1Var != null) {
                fh1Var.a(this.a, false, i, true, this.c, false);
            }
        }
    }

    public final SharedPreferences x() {
        return CommonAppContext.n().getSharedPreferences("live_beauty_full", 0);
    }
}
