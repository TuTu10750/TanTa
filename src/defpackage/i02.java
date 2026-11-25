package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.utils.a;
import com.yunbao.live.activity.LiveActivity;
import com.yunbao.live.activity.LiveAdminListActivity;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class i02 extends r0 implements et2 {
    public String f;
    public TextView g;
    public RecyclerView h;
    public h02 i;
    public HttpCallback j;
    public String k;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            List parseArray = JSON.parseArray(parseObject.getString("list"), UserBean.class);
            h02 h02Var = i02.this.i;
            i02 i02Var = i02.this;
            if (h02Var == null) {
                i02Var.i = new h02(i02Var.mContext, parseArray);
                i02.this.i.W(i02.this);
                i02.this.h.setAdapter(i02.this.i);
            } else {
                i02Var.i.V(parseArray);
            }
            i02.this.k = parseObject.getString("total");
            i02.this.n0();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements a.m {
        public final /* synthetic */ UserBean a;

        /* loaded from: /tmp/classes2.dex */
        public class a extends HttpCallback {
            public a() {
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i == 0 && strArr.length > 0 && JSON.parseObject(strArr[0]).getIntValue("isadmin") == 0) {
                    if (i02.this.i != null) {
                        i02.this.i.U(b.this.a.getId());
                        i02.this.n0();
                    }
                    if (i02.this.mContext instanceof LiveActivity) {
                        ((LiveActivity) i02.this.mContext).t2(0, b.this.a.getId(), b.this.a.getUserNiceName());
                    }
                }
            }
        }

        public b(UserBean userBean) {
            this.a = userBean;
        }

        @Override // com.yunbao.common.utils.a.m
        public void b(Dialog dialog, String str) {
            e32.B0(i02.this.f, this.a.getId(), new a());
        }
    }

    public i02(Context context, ViewGroup viewGroup, String str) {
        super(context, viewGroup);
        this.f = str;
    }

    @Override // defpackage.r0
    public void a0() {
        h02 h02Var = this.i;
        if (h02Var != null) {
            h02Var.P();
        }
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return x73.N1;
    }

    @Override // defpackage.r0
    public void hide() {
        Object obj = this.mContext;
        if (obj instanceof LiveAdminListActivity) {
            ((LiveAdminListActivity) obj).onBackPressed();
        } else {
            super.hide();
        }
    }

    @Override // defpackage.r0, defpackage.b1
    public void init() {
        super.init();
        RecyclerView findViewById = findViewById(b73.B4);
        this.h = findViewById;
        findViewById.setHasFixedSize(true);
        this.h.setLayoutManager(new LinearLayoutManager(this.mContext, 1, false));
        this.g = (TextView) findViewById(b73.c5);
        this.j = new a();
    }

    @Override // defpackage.r0
    public void loadData() {
        e32.B(this.f, this.j);
    }

    @Override // defpackage.et2
    /* renamed from: m0, reason: merged with bridge method [inline-methods] */
    public void onItemClick(UserBean userBean, int i) {
        com.yunbao.common.utils.a.l(this.mContext, aq4.b(m93.O4, userBean.getUserNiceName()), new b(userBean));
    }

    public final void n0() {
        this.g.setText(aq4.a(m93.o3) + "(" + this.i.j() + "/" + this.k + ")");
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onDestroy() {
        super.onDestroy();
        e32.f("getAdminList");
        e32.f("setAdmin");
    }

    @Override // defpackage.r0, defpackage.b1
    public void release() {
        h02 h02Var = this.i;
        if (h02Var != null) {
            h02Var.T();
        }
        this.i = null;
        super.release();
    }
}
