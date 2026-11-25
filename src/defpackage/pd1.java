package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.yunbao.mall.activity.GoodsDetailActivity;
import com.yunbao.mall.bean.GoodsChooseSpecBean;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class pd1 extends l0 implements et2, View.OnClickListener {
    public ImageView A0;
    public TextView B0;
    public TextView C0;
    public TextView D0;
    public TextView E0;
    public View F0;
    public View G0;
    public int H0;
    public String I0;
    public String J0;
    public String K0;
    public List z0;

    private void r2() {
        int i = this.H0 + 1;
        this.H0 = i;
        this.E0.setText(String.valueOf(i));
        if (this.H0 > 1) {
            this.F0.setEnabled(true);
        }
    }

    private void u2() {
        int i = this.H0;
        if (i > 1) {
            int i2 = i - 1;
            this.H0 = i2;
            this.E0.setText(String.valueOf(i2));
            if (this.H0 == 1) {
                this.F0.setEnabled(false);
            }
        }
    }

    @Override // defpackage.l0
    public void C0() {
        this.x0 = null;
        this.z0 = null;
        super.C0();
    }

    @Override // defpackage.l0
    public boolean f2() {
        return true;
    }

    @Override // defpackage.l0
    public int l2() {
        return s93.c;
    }

    @Override // defpackage.l0
    public int m2() {
        return z73.d0;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == d73.U0) {
            u2();
            return;
        }
        if (id == d73.q) {
            r2();
        } else if (id == d73.I) {
            s2();
        } else if (id == d73.W) {
            S1();
        }
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
        GoodsChooseSpecBean goodsChooseSpecBean;
        super.r0(bundle);
        this.A0 = (ImageView) k2(d73.j4);
        this.B0 = (TextView) k2(d73.Z1);
        this.C0 = (TextView) k2(d73.X1);
        this.D0 = (TextView) k2(d73.W1);
        this.E0 = (TextView) k2(d73.F1);
        this.F0 = k2(d73.U0);
        this.G0 = k2(d73.q);
        this.I0 = aq4.a(m93.z6);
        this.J0 = aq4.a(m93.A6);
        this.K0 = aq4.a(m93.O8);
        k2(d73.W).setOnClickListener(this);
        k2(d73.I).setOnClickListener(this);
        this.F0.setOnClickListener(this);
        this.G0.setOnClickListener(this);
        List list = this.z0;
        if (list == null || list.size() <= 0) {
            return;
        }
        Iterator it = this.z0.iterator();
        while (true) {
            if (!it.hasNext()) {
                goodsChooseSpecBean = null;
                break;
            } else {
                goodsChooseSpecBean = (GoodsChooseSpecBean) it.next();
                if (goodsChooseSpecBean.isChecked()) {
                    break;
                }
            }
        }
        if (goodsChooseSpecBean != null) {
            w2(goodsChooseSpecBean);
        }
        RecyclerView k2 = k2(d73.u3);
        k2.setLayoutManager(new FlexboxLayoutManager(this.x0));
        cd1 cd1Var = new cd1(this.x0, this.z0);
        cd1Var.R(this);
        k2.setAdapter(cd1Var);
    }

    public final void s2() {
        if (this.x0 != null) {
            S1();
            ((GoodsDetailActivity) this.x0).x2(this.H0);
        }
    }

    @Override // defpackage.et2
    /* renamed from: t2, reason: merged with bridge method [inline-methods] */
    public void onItemClick(GoodsChooseSpecBean goodsChooseSpecBean, int i) {
        w2(goodsChooseSpecBean);
    }

    public void v2(List list) {
        this.z0 = list;
    }

    public final void w2(GoodsChooseSpecBean goodsChooseSpecBean) {
        kn1.f(this.x0, goodsChooseSpecBean.getThumb(), this.A0);
        this.B0.setText(rv3.a(this.K0, goodsChooseSpecBean.getPrice()));
        this.C0.setText(String.format(this.I0, goodsChooseSpecBean.getNum()));
        this.D0.setText(String.format(this.J0, goodsChooseSpecBean.getName()));
        this.H0 = 1;
        this.E0.setText(String.valueOf(1));
        this.F0.setEnabled(false);
    }
}
