package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.bean.LiveGiftBean;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.activity.LiveActivity;
import defpackage.o0;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class s22 extends o0 {
    public TextView r;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onFinish() {
            View view = s22.this.d;
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
            List parseArray = JSON.parseArray(parseObject.getString("giftlist"), LiveGiftBean.class);
            j30.q().V(parseObject.getString("proplist"));
            s22.this.i0(parseArray);
            s22.this.r.setText(parseObject.getString("coin"));
        }
    }

    public s22(Context context, ViewGroup viewGroup, String str, String str2) {
        super(context, viewGroup, str, str2);
    }

    @Override // defpackage.o0
    public int b0() {
        return 0;
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return x73.Y1;
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

    /* JADX WARN: Multi-variable type inference failed */
    @Override // defpackage.o0
    public void loadData() {
        o0.b bVar = this.p;
        if (bVar != null) {
            bVar.d(this.m);
        }
        if (isFirstLoadData()) {
            boolean L1 = ((LiveActivity) this.mContext).L1();
            e32.I(L1 ? 1 : 0, new a());
        }
    }

    @Override // defpackage.b1
    public void processArguments(Object... objArr) {
        this.n = (String) objArr[0];
        this.o = (String) objArr[1];
    }
}
