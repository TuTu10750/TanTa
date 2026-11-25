package defpackage;

import android.app.Dialog;
import android.content.Context;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.bean.LiveBean;

/* loaded from: /tmp/classes2.dex */
public class c52 {
    public Context a;
    public int b;
    public int c;
    public LiveBean d;
    public c e;
    public int f;
    public HttpCallback g = new a();
    public HttpCallback h = new b();

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public Dialog createLoadingDialog() {
            return com.yunbao.common.utils.a.c(c52.this.a);
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                c52.this.d();
                return;
            }
            if (i != 40018) {
                t54.b(str);
                return;
            }
            if (strArr.length > 0) {
                JSONObject parseObject = JSON.parseObject(strArr[0]);
                String string = parseObject.getString("sharelink");
                String string2 = parseObject.getString("fail_msg");
                j62 j62Var = new j62();
                j62Var.u2(string2, string);
                j62Var.w2(c52.this.a.getSupportFragmentManager(), "LiveVipDialog");
            }
        }

        @Override // com.yunbao.common.http.HttpCallback
        public boolean showLoadingDialog() {
            return true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public b() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public Dialog createLoadingDialog() {
            return com.yunbao.common.utils.a.c(c52.this.a);
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                c52.this.d();
            } else {
                t54.b(str);
            }
        }

        @Override // com.yunbao.common.http.HttpCallback
        public boolean showLoadingDialog() {
            return true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface c {
        void a(LiveBean liveBean, int i, int i2, int i3);
    }

    public c52(Context context, c cVar) {
        this.a = context;
        this.e = cVar;
    }

    public void c(LiveBean liveBean) {
        this.d = liveBean;
        e32.k(liveBean.getUid(), liveBean.getStream(), this.g);
    }

    public final void d() {
        c cVar = this.e;
        if (cVar != null) {
            cVar.a(this.d, this.b, this.c, this.f);
        }
    }
}
