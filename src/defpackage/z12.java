package defpackage;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.activity.LiveAnchorActivity;
import com.yunbao.live.activity.LiveAudienceActivity;
import com.yunbao.live.bean.LiveBean;

/* loaded from: /tmp/classes2.dex */
public class z12 extends b1 implements View.OnClickListener {
    public ImageView a;
    public ImageView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;

    /* loaded from: /tmp/classes2.dex */
    public class a implements Runnable {
        public final /* synthetic */ String a;

        /* renamed from: z12$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0166a extends HttpCallback {
            public C0166a() {
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i != 0 || strArr.length <= 0) {
                    return;
                }
                JSONObject parseObject = JSON.parseObject(strArr[0]);
                z12.this.e.setText(parseObject.getString("votes"));
                z12.this.d.setText(parseObject.getString("length"));
                z12.this.f.setText(rv3.i(parseObject.getLongValue("nums")));
            }
        }

        public a(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            e32.O(this.a, new C0166a());
        }
    }

    public z12(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    public void e0(LiveBean liveBean, String str) {
        if (liveBean != null) {
            this.c.setText(liveBean.getUserNiceName());
            try {
                kn1.h(this.mContext, liveBean.getAvatar(), this.a);
                kn1.g(this.mContext, liveBean.getAvatar(), this.b);
            } catch (Exception unused) {
            }
        }
        this.mParentView.postDelayed(new a(str), 500L);
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return x73.U1;
    }

    @Override // defpackage.b1
    public void init() {
        this.a = (ImageView) findViewById(b73.e);
        this.b = (ImageView) findViewById(b73.f);
        this.c = (TextView) findViewById(b73.X3);
        this.d = (TextView) findViewById(b73.M1);
        this.e = (TextView) findViewById(b73.i6);
        this.f = (TextView) findViewById(b73.m6);
        findViewById(b73.x).setOnClickListener(this);
        TextView textView = (TextView) findViewById(b73.j6);
        if (!rx1.h()) {
            textView.setText(aq4.a(m93.W4));
            return;
        }
        textView.setText(aq4.a(m93.W4) + j30.q().F());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object obj = this.mContext;
        if (obj instanceof LiveAnchorActivity) {
            ((LiveAnchorActivity) obj).S3();
        } else if (obj instanceof LiveAudienceActivity) {
            ((LiveAudienceActivity) obj).E3();
        }
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onDestroy() {
        e32.f("getLiveEndInfo");
    }
}
