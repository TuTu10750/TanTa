package defpackage;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.bean.PromotionBannerBean;
import com.zhpan.bannerview.BannerViewPager;
import com.zhpan.indicator.IndicatorView;
import java.util.HashMap;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class rb2 extends v0 {
    public BannerViewPager a;
    public IndicatorView b;
    public TextView c;
    public d d;
    public int e;
    public List f;
    public String g;

    /* loaded from: /tmp/classes2.dex */
    public class a extends ViewPager2.i {
        public a() {
        }

        public void a(int i) {
            super.a(i);
        }

        public void b(int i, float f, int i2) {
            super.b(i, f, i2);
        }

        public void c(int i) {
            rb2.this.e = i;
            super.c(i);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends vx2 {
        public b() {
        }

        @Override // defpackage.vx2
        public void a() {
            if (rb2.this.f == null || rb2.this.f.get(rb2.this.e) == null) {
                rb2.this.loadData();
            } else {
                pj3.b().d(rb2.this.mContext, (View) rb2.this.d.X().get(((PromotionBannerBean) rb2.this.f.get(rb2.this.e)).getPic()));
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends HttpCallback {
        public c() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onFinish() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            rb2.this.g = parseObject.getString("agent_url");
            rb2.this.c.setText(parseObject.getString("agent_desc"));
            List parseArray = JSON.parseArray(parseObject.getString("slide"), PromotionBannerBean.class);
            rb2.this.f = parseArray;
            if (rb2.this.f == null || rb2.this.f.isEmpty()) {
                return;
            }
            rb2.this.a.B(parseArray);
            if (rb2.this.f.size() > 1) {
                rb2.this.a.setCurrentItem(1);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends rg {
        public HashMap f = new HashMap();

        public d() {
        }

        @Override // defpackage.rg
        public int P(int i) {
            return y73.H0;
        }

        @Override // defpackage.rg
        /* renamed from: W, reason: merged with bridge method [inline-methods] */
        public void M(oh ohVar, PromotionBannerBean promotionBannerBean, int i, int i2) {
            kn1.f(rb2.this.mContext, promotionBannerBean.getPic(), (ImageView) ohVar.O(c73.w));
            ((ImageView) ohVar.O(c73.p3)).setImageBitmap(b20.b(rb2.this.g, zn0.a(150)));
            this.f.put(promotionBannerBean.getPic(), ((RecyclerView.e0) ohVar).a);
        }

        public HashMap X() {
            return this.f;
        }
    }

    public rb2(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.e = 0;
    }

    public static /* synthetic */ void a0(rb2 rb2Var, View view) {
        ((ClipboardManager) rb2Var.mContext.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", rb2Var.g));
        t54.a(m93.u1);
    }

    public static /* synthetic */ void b0(rb2 rb2Var, View view) {
        if (rb2Var.canClick()) {
            yx2.a(rb2Var.mContext, new b(), zj2.u());
        }
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return y73.q1;
    }

    @Override // defpackage.b1
    public void init() {
        this.a = (BannerViewPager) findViewById(c73.v);
        this.b = (IndicatorView) findViewById(c73.V2);
        this.c = (TextView) findViewById(c73.R4);
        d dVar = new d();
        this.d = dVar;
        this.a.F(dVar).N(4).M(8).I(2).L(this.b).J(-2302756, -10387220).K(zn0.a(4), zn0.a(5)).G(false).P(zn0.a(20)).g();
        this.a.D(new a());
        findViewById(c73.P4).setOnClickListener(new View.OnClickListener() { // from class: pb2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                rb2.a0(rb2.this, view);
            }
        });
        findViewById(c73.b5).setOnClickListener(new View.OnClickListener() { // from class: qb2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                rb2.b0(rb2.this, view);
            }
        });
        loadData();
    }

    @Override // defpackage.y0
    public void loadData() {
        CommonHttpUtil.getUserPromotion(new c());
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onResume() {
        super.onResume();
    }
}
