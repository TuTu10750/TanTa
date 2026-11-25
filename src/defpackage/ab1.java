package defpackage;

import com.alibaba.fastjson.JSONObject;
import com.umeng.ccg.a;
import com.yunbao.game.bean.GameParam;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ab1 {
    public GameParam a;
    public List b;
    public m0 c;
    public bb1 d;
    public boolean e;
    public ua1 f;

    public ab1() {
        this.d = new bb1();
    }

    public ab1(GameParam gameParam) {
        this();
        i(gameParam);
    }

    public void a() {
        m0 m0Var = this.c;
        if (m0Var != null) {
            m0Var.f0();
            this.c.release();
        }
        this.c = null;
        ua1 ua1Var = this.f;
        if (ua1Var != null) {
            ua1Var.e(false);
        }
    }

    public void b() {
        m0 m0Var = this.c;
        if (m0Var != null) {
            m0Var.a0();
        }
    }

    public final void c(int i) {
        m0 fb1Var = i != 1 ? i != 3 ? null : new fb1(this.a, this.d) : new db1(this.a, this.d);
        if (fb1Var != null) {
            this.c = fb1Var;
            ua1 ua1Var = this.f;
            if (ua1Var != null) {
                ua1Var.e(true);
            }
        }
    }

    public List d() {
        return this.b;
    }

    public void e(JSONObject jSONObject) {
        if (this.e) {
            return;
        }
        int intValue = jSONObject.getIntValue(a.z);
        if (intValue == 1) {
            m0 m0Var = this.c;
            if (m0Var != null) {
                m0Var.removeFromParent();
                this.c.release();
                this.c = null;
            }
            c(1);
        } else if (intValue == 2) {
            m0 m0Var2 = this.c;
            if (m0Var2 == null) {
                c(1);
            } else if (!(m0Var2 instanceof db1)) {
                m0Var2.removeFromParent();
                this.c.release();
                this.c = null;
                c(1);
            }
        }
        m0 m0Var3 = this.c;
        if (m0Var3 != null && (m0Var3 instanceof db1)) {
            m0Var3.e0(intValue, jSONObject);
        }
        if (intValue == 3) {
            this.c = null;
            ua1 ua1Var = this.f;
            if (ua1Var != null) {
                ua1Var.e(false);
            }
        }
    }

    public void f(JSONObject jSONObject) {
        if (this.e) {
            return;
        }
        int intValue = jSONObject.getIntValue(a.z);
        if (intValue == 1) {
            m0 m0Var = this.c;
            if (m0Var != null) {
                m0Var.removeFromParent();
                this.c.release();
                this.c = null;
            }
            c(3);
        } else if (intValue == 4) {
            m0 m0Var2 = this.c;
            if (m0Var2 == null) {
                c(3);
            } else if (!(m0Var2 instanceof fb1)) {
                m0Var2.removeFromParent();
                this.c.release();
                this.c = null;
                c(3);
            }
        }
        m0 m0Var3 = this.c;
        if (m0Var3 != null && (m0Var3 instanceof fb1)) {
            m0Var3.e0(intValue, jSONObject);
        }
        if (intValue == 3) {
            this.c = null;
            ua1 ua1Var = this.f;
            if (ua1Var != null) {
                ua1Var.e(false);
            }
        }
    }

    public void g() {
        this.e = true;
        bb1 bb1Var = this.d;
        if (bb1Var != null) {
            bb1Var.b();
        }
        ua1 ua1Var = this.f;
        if (ua1Var != null) {
            ua1Var.e(false);
            this.f.release();
        }
        this.f = null;
        this.b = null;
        m0 m0Var = this.c;
        if (m0Var != null) {
            m0Var.release();
        }
        this.c = null;
    }

    public void h(List list) {
        this.b = list;
    }

    public void i(GameParam gameParam) {
        this.a = gameParam;
        this.f = gameParam.getGameActionListener();
        boolean isAnchor = gameParam.isAnchor();
        JSONObject obj = gameParam.getObj();
        if (isAnchor) {
            return;
        }
        int intValue = obj.getIntValue("gameaction");
        int intValue2 = obj.getIntValue("gametime");
        int[] iArr = (int[]) obj.getObject("game", int[].class);
        int[] iArr2 = (int[]) obj.getObject("gamebet", int[].class);
        if (intValue == 0 || intValue2 <= 0 || iArr.length <= 0 || iArr2.length <= 0) {
            return;
        }
        c(intValue);
        m0 m0Var = this.c;
        if (m0Var != null) {
            m0Var.j0(obj.getString("gameid"));
            this.c.i0(intValue2);
            this.c.m0(iArr);
            this.c.l0(iArr2);
            this.c.b0();
        }
    }

    public void j(String str) {
        m0 m0Var = this.c;
        if (m0Var != null) {
            m0Var.k0(str);
        }
    }

    public void k(int i) {
        ua1 ua1Var = this.f;
        if (ua1Var == null) {
            return;
        }
        if (ua1Var.h()) {
            t54.a(m93.U3);
            return;
        }
        m0 m0Var = this.c;
        if (m0Var == null || !m0Var.g0()) {
            this.f.j(i);
        } else {
            t54.a(c93.e);
        }
    }
}
