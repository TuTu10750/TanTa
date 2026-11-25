package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.bean.LiveGiftBean;
import com.yunbao.common.http.HttpCallback;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class p22 extends o0 {
    public TextView r;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onFinish() {
            View view = p22.this.d;
            if (view != null) {
                view.setVisibility(4);
            }
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            String string = parseObject.getString("proplist");
            List parseArray = JSON.parseArray(string, LiveGiftBean.class);
            j30.q().W(parseObject.getString("giftlist"));
            j30.q().V(string);
            p22.this.i0(parseArray);
            p22.this.r.setText(parseObject.getString("coin"));
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
            p22.this.r.setText(JSON.parseObject(strArr[0]).getString("coin"));
        }
    }

    public p22(Context context, ViewGroup viewGroup, String str, String str2) {
        super(context, viewGroup, str, str2);
    }

    @Override // defpackage.o0
    public int b0() {
        return 1;
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return x73.W1;
    }

    @Override // defpackage.o0, defpackage.b1
    public void init() {
        super.init();
        this.r = (TextView) findViewById(b73.s1);
        findViewById(b73.D).setOnClickListener(this);
    }

    public void k0(String str) {
        TextView textView = this.r;
        if (textView != null) {
            textView.setText(str);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    @Override // defpackage.o0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void loadData() {
        /*
            r4 = this;
            o0$b r0 = r4.p
            if (r0 == 0) goto L9
            java.lang.String r1 = r4.m
            r0.d(r1)
        L9:
            boolean r0 = r4.isFirstLoadData()
            if (r0 != 0) goto L10
            goto L5b
        L10:
            j30 r0 = defpackage.j30.q()
            java.lang.String r0 = r0.n()
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 != 0) goto L29
            java.lang.Class<com.yunbao.common.bean.LiveGiftBean> r1 = com.yunbao.common.bean.LiveGiftBean.class
            java.util.List r0 = com.alibaba.fastjson.JSON.parseArray(r0, r1)     // Catch: java.lang.Exception -> L25
            goto L2a
        L25:
            r0 = move-exception
            r0.printStackTrace()
        L29:
            r0 = 0
        L2a:
            r1 = 0
            if (r0 != 0) goto L36
            p22$a r0 = new p22$a
            r0.<init>()
            defpackage.e32.I(r1, r0)
            goto L5b
        L36:
            java.util.Iterator r2 = r0.iterator()
        L3a:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L4a
            java.lang.Object r3 = r2.next()
            com.yunbao.common.bean.LiveGiftBean r3 = (com.yunbao.common.bean.LiveGiftBean) r3
            r3.setChecked(r1)
            goto L3a
        L4a:
            android.view.View r1 = r4.d
            r2 = 4
            r1.setVisibility(r2)
            r4.i0(r0)
            p22$b r0 = new p22$b
            r0.<init>()
            defpackage.e32.F(r0)
        L5b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.p22.loadData():void");
    }

    @Override // defpackage.b1
    public void processArguments(Object... objArr) {
        this.n = (String) objArr[0];
        this.o = (String) objArr[1];
    }
}
