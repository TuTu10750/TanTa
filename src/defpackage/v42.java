package defpackage;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.activity.LiveActivity;
import com.yunbao.live.bean.RedPackBean;
import defpackage.x42;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class v42 extends l0 implements et2, x42.b {
    public RecyclerView A0;
    public String B0;
    public kc3 C0;
    public String D0;
    public TextView z0;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0) {
                t54.b(str);
                return;
            }
            List parseArray = JSON.parseArray(Arrays.toString(strArr), RedPackBean.class);
            v42 v42Var = v42.this;
            v42Var.C0 = new kc3(v42Var.x0, parseArray);
            v42.this.C0.b0(v42.this);
            v42.this.A0.setAdapter(v42.this.C0);
            v42.this.z0.setText(aq4.b(m93.H9, String.valueOf(parseArray.size())));
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (v42.this.y0 == null || v42.this.y0.getVisibility() == 0) {
                return;
            }
            v42.this.y0.setVisibility(0);
        }
    }

    public void A2(String str) {
        this.D0 = str;
    }

    public void B2(String str) {
        this.B0 = str;
    }

    @Override // defpackage.l0
    public void C0() {
        kc3 kc3Var = this.C0;
        if (kc3Var != null) {
            kc3Var.a0();
        }
        this.C0 = null;
        super.C0();
    }

    @Override // x42.b
    public void a(boolean z) {
        kc3 kc3Var;
        if (z && (kc3Var = this.C0) != null) {
            kc3Var.Z(new b(), 300L);
            return;
        }
        View view = this.y0;
        if (view == null || view.getVisibility() == 0) {
            return;
        }
        this.y0.setVisibility(0);
    }

    @Override // defpackage.l0
    public boolean f2() {
        return true;
    }

    @Override // x42.b
    public void hide() {
        View view = this.y0;
        if (view == null || view.getVisibility() != 0) {
            return;
        }
        this.y0.setVisibility(4);
    }

    @Override // defpackage.l0
    public int l2() {
        return s93.d;
    }

    @Override // defpackage.l0
    public int m2() {
        return x73.T;
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = zn0.a(280);
        attributes.height = zn0.a(360);
        attributes.gravity = 17;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        if (TextUtils.isEmpty(this.B0)) {
            return;
        }
        this.z0 = (TextView) this.y0.findViewById(b73.D1);
        RecyclerView findViewById = this.y0.findViewById(b73.B4);
        this.A0 = findViewById;
        findViewById.setHasFixedSize(true);
        this.A0.setLayoutManager(new LinearLayoutManager(this.x0, 1, false));
        e32.c0(this.B0, new a());
    }

    @Override // defpackage.et2
    /* renamed from: z2, reason: merged with bridge method [inline-methods] */
    public void onItemClick(RedPackBean redPackBean, int i) {
        if (redPackBean.getIsRob() != 1) {
            w42 w42Var = new w42();
            w42Var.E2(this.B0);
            w42Var.D2(redPackBean);
            w42Var.C2(this.D0);
            w42Var.d2(((LiveActivity) this.x0).getSupportFragmentManager(), "LiveRedPackResultDialogFragment");
            return;
        }
        x42 x42Var = new x42();
        x42Var.y2(this);
        x42Var.B2(redPackBean);
        x42Var.C2(this.B0);
        x42Var.z2(this.D0);
        x42Var.A2(this.C0);
        x42Var.d2(((LiveActivity) this.x0).getSupportFragmentManager(), "LiveRedPackRobDialogFragment");
    }
}
