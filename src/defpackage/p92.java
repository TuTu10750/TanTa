package defpackage;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.activity.LiveActivity;
import com.yunbao.live.bean.TurntableConfigBean;
import com.yunbao.live.bean.TurntableGiftBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class p92 extends l0 implements View.OnClickListener {
    public TextView[] A0;
    public TextView[] B0;
    public TextView[] C0;
    public View D0;
    public View E0;
    public ObjectAnimator F0;
    public List G0;
    public TurntableConfigBean H0;
    public List I0;
    public List J0;
    public ImageView[] z0;

    /* loaded from: /tmp/classes2.dex */
    public class a extends AnimatorListenerAdapter {
        public a() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (p92.this.x0 != null) {
                ((LiveActivity) p92.this.x0).g2(p92.this.J0);
                if (p92.this.E0 != null) {
                    p92.this.E0.setEnabled(true);
                }
                p92.this.V1().setCancelable(true);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public b() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            String str2 = strArr[0];
            p92.this.G0 = mu1.a(mu1.b(str2, "config"), TurntableConfigBean.class);
            p92.this.I0 = mu1.a(mu1.b(str2, "list"), TurntableGiftBean.class);
            p92 p92Var = p92.this;
            p92Var.C2(p92Var.G0, p92.this.I0);
            p92.this.F2(0);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends HttpCallback {
        public c() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onError() {
            if (p92.this.E0 != null) {
                p92.this.E0.setEnabled(true);
            }
            p92.this.V1().setCancelable(true);
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                if (p92.this.E0 != null) {
                    p92.this.E0.setEnabled(true);
                }
                p92.this.V1().setCancelable(true);
                t54.b(str);
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            UserBean D = j30.q().D();
            if (D != null) {
                D.setLevel(parseObject.getIntValue("level"));
                D.setLevelAnchor(parseObject.getIntValue("level_anchor"));
            }
            p92.this.G2(JSON.parseArray(parseObject.getString("list"), TurntableGiftBean.class));
        }
    }

    @Override // defpackage.l0
    public void C0() {
        ObjectAnimator objectAnimator = this.F0;
        if (objectAnimator != null) {
            objectAnimator.cancel();
            this.F0.removeAllListeners();
            this.F0.removeAllUpdateListeners();
        }
        e32.f("GetTurntable");
        e32.f("Turn");
        this.F0 = null;
        super.C0();
    }

    public final void C2(List list, List list2) {
        if (list != null) {
            String g = j30.q().g();
            int length = this.B0.length;
            int size = list.size();
            for (int i = 0; i < length && size != i; i++) {
                TurntableConfigBean turntableConfigBean = (TurntableConfigBean) list.get(i);
                this.B0[i].setText(aq4.b(m93.T8, turntableConfigBean.getTimes()));
                this.C0[i].setText(turntableConfigBean.getCoin() + g);
            }
        }
        if (list2 != null) {
            int length2 = this.z0.length;
            int size2 = list2.size();
            for (int i2 = 0; i2 < length2 && size2 != i2; i2++) {
                ImageView imageView = this.z0[i2];
                TextView textView = this.A0[i2];
                TurntableGiftBean turntableGiftBean = (TurntableGiftBean) list2.get(i2);
                if (turntableGiftBean.getType() != 2) {
                    textView.setText(turntableGiftBean.getType_val());
                }
                kn1.f(this.x0, turntableGiftBean.getThumb(), imageView);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void D2() {
        boolean L1 = ((LiveActivity) this.x0).L1();
        e32.g0(L1 ? 1 : 0, new b());
    }

    public final void E2(int i) {
        if (i < 0 || i > 7) {
            lx1.b("index is outBound");
            return;
        }
        lx1.b("rotate-----index------> " + i);
        this.F0.setFloatValues(this.D0.getRotation() % 360.0f, 3960.0f - (((float) (i * 45)) + 22.5f));
        this.F0.start();
    }

    public final void F2(int i) {
        List list = this.G0;
        if (list == null || list.size() <= i) {
            return;
        }
        this.H0 = (TurntableConfigBean) this.G0.get(i);
    }

    public final void G2(List list) {
        this.J0 = list;
        if (list != null && list.size() > 0) {
            E2(this.I0.indexOf((TurntableGiftBean) list.get(list.size() - 1)));
            return;
        }
        int size = this.I0.size();
        for (int i = 0; i < size; i++) {
            if (((TurntableGiftBean) this.I0.get(i)).getType() == 0) {
                E2(i);
                return;
            }
        }
    }

    public final void H2() {
        Object obj = this.x0;
        if (obj instanceof LiveActivity) {
            LiveActivity liveActivity = (LiveActivity) obj;
            String F1 = liveActivity.F1();
            String G1 = liveActivity.G1();
            if (this.H0 == null || this.I0 == null) {
                return;
            }
            View view = this.E0;
            if (view != null) {
                view.setEnabled(false);
            }
            V1().setCancelable(false);
            e32.N0(this.H0.getId(), F1, G1, new c());
        }
    }

    @Override // defpackage.l0
    public boolean f2() {
        return true;
    }

    @Override // defpackage.l0
    public int l2() {
        return s93.d;
    }

    @Override // defpackage.l0
    public int m2() {
        return x73.h0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object obj;
        int id = view.getId();
        if (id == b73.e1) {
            H2();
            return;
        }
        if (id == b73.F0) {
            F2(0);
            return;
        }
        if (id == b73.i1) {
            F2(1);
            return;
        }
        if (id == b73.n0) {
            F2(2);
            return;
        }
        if (id == b73.e0) {
            Object obj2 = this.x0;
            if (obj2 != null) {
                ((LiveActivity) obj2).f2();
                return;
            }
            return;
        }
        if (id != b73.n1 || (obj = this.x0) == null) {
            return;
        }
        ((LiveActivity) obj).e2();
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        window.setWindowAnimations(s93.b);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        this.D0 = k2(b73.n4);
        ImageView[] imageViewArr = new ImageView[8];
        this.z0 = imageViewArr;
        this.A0 = new TextView[8];
        imageViewArr[0] = (ImageView) k2(b73.S2);
        this.z0[1] = (ImageView) k2(b73.T2);
        this.z0[2] = (ImageView) k2(b73.U2);
        this.z0[3] = (ImageView) k2(b73.V2);
        this.z0[4] = (ImageView) k2(b73.W2);
        this.z0[5] = (ImageView) k2(b73.X2);
        this.z0[6] = (ImageView) k2(b73.Y2);
        this.z0[7] = (ImageView) k2(b73.Z2);
        this.A0[0] = (TextView) k2(b73.Y3);
        this.A0[1] = (TextView) k2(b73.Z3);
        this.A0[2] = (TextView) k2(b73.a4);
        this.A0[3] = (TextView) k2(b73.b4);
        this.A0[4] = (TextView) k2(b73.c4);
        this.A0[5] = (TextView) k2(b73.d4);
        this.A0[6] = (TextView) k2(b73.e4);
        this.A0[7] = (TextView) k2(b73.f4);
        TextView[] textViewArr = new TextView[3];
        this.B0 = textViewArr;
        this.C0 = new TextView[3];
        textViewArr[0] = (TextView) k2(b73.U5);
        this.B0[1] = (TextView) k2(b73.V5);
        this.B0[2] = (TextView) k2(b73.W5);
        this.C0[0] = (TextView) k2(b73.R5);
        this.C0[1] = (TextView) k2(b73.S5);
        this.C0[2] = (TextView) k2(b73.T5);
        View k2 = k2(b73.e1);
        this.E0 = k2;
        k2.setOnClickListener(this);
        k2(b73.F0).setOnClickListener(this);
        k2(b73.i1).setOnClickListener(this);
        k2(b73.n0).setOnClickListener(this);
        k2(b73.e0).setOnClickListener(this);
        k2(b73.n1).setOnClickListener(this);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.D0, "rotation", 0.0f);
        this.F0 = ofFloat;
        ofFloat.setDuration(3000L);
        this.F0.setInterpolator(new AccelerateDecelerateInterpolator());
        this.F0.addListener(new a());
        D2();
    }
}
