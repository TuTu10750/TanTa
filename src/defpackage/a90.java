package defpackage;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.bean.DailyTaskBean;

/* loaded from: /tmp/classes2.dex */
public class a90 extends l0 {
    public String z0;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a90.this.S1();
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
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            ((TextView) a90.this.k2(b73.f5)).setText(parseObject.getString("tip_m"));
            RecyclerView k2 = a90.this.k2(b73.B4);
            k2.setLayoutManager(new LinearLayoutManager(a90.this.x0, 1, false));
            k2.setAdapter(new z80(a90.this.x0, JSON.parseArray(parseObject.getString("list"), DailyTaskBean.class)));
        }
    }

    @Override // defpackage.l0
    public void C0() {
        e32.f("getDailyTask");
        e32.f("dailyTaskReward");
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
        return x73.q;
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        attributes.horizontalMargin = 0.1f;
        attributes.verticalMargin = 0.1f;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        k2(b73.H).setOnClickListener(new a());
        e32.G(this.z0, 1, new b());
    }

    public void v2(String str) {
        this.z0 = str;
    }
}
