package defpackage;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.game.bean.GameParam;

/* loaded from: /tmp/classes2.dex */
public abstract class m0 extends b1 implements View.OnClickListener {
    public Context a;
    public String b;
    public String c;
    public String d;
    public int e;
    public String f;
    public String g;
    public View h;
    public int i;
    public boolean j;
    public boolean k;
    public ua1 l;
    public bb1 m;
    public boolean n;
    public String o;
    public String p;
    public int q;
    public int[] r;
    public int[] s;
    public boolean t;

    public m0(GameParam gameParam, bb1 bb1Var) {
        super(gameParam.getContext(), gameParam.getParentView());
        this.a = gameParam.getContext();
        this.h = gameParam.getTopView();
        this.l = gameParam.getGameActionListener();
        this.f = gameParam.getLiveUid();
        this.g = gameParam.getStream();
        this.j = gameParam.isAnchor();
        this.c = gameParam.getCoinName();
        this.m = bb1Var;
        this.b = getClass().getSimpleName();
        this.d = aq4.a(c93.a);
    }

    public abstract void a0();

    @Override // defpackage.b1
    public void addToParent() {
        super.addToParent();
        this.k = true;
    }

    public abstract void b0();

    public void d0() {
        zu0.c().j(new zt2());
    }

    public abstract void e0(int i, JSONObject jSONObject);

    public void f0() {
        if (this.k) {
            removeFromParent();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.h.getLayoutParams();
            layoutParams.setMargins(0, 0, 0, 0);
            this.h.setLayoutParams(layoutParams);
            zu0.c().j(new cb1(false, 0));
        }
    }

    public boolean g0() {
        return this.t;
    }

    public void h0(int i) {
        bb1 bb1Var = this.m;
        if (bb1Var != null) {
            bb1Var.a(i);
        }
    }

    public void i0(int i) {
        this.q = i;
    }

    public void j0(String str) {
        this.o = str;
    }

    public abstract void k0(String str);

    public void l0(int[] iArr) {
        this.s = iArr;
    }

    public void m0(int[] iArr) {
        this.r = iArr;
    }

    public void n0() {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.h.getLayoutParams();
        layoutParams.setMargins(0, 0, 0, this.i);
        this.h.setLayoutParams(layoutParams);
        addToParent();
        zu0.c().j(new cb1(true, this.i));
    }

    @Override // defpackage.b1
    public void release() {
        this.m = null;
        this.a = null;
        this.mParentView = null;
        this.h = null;
        this.l = null;
        this.f = null;
        this.g = null;
    }

    @Override // defpackage.b1
    public void removeFromParent() {
        super.removeFromParent();
        this.k = false;
    }
}
