package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.custom.ActiveVoiceLayout;
import com.yunbao.common.custom.NineGridLayout;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.common.http.FileDownloadCallback;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.utils.a;
import com.yunbao.main.activity.ActiveDetailActivity;
import com.yunbao.main.activity.ActiveReportActivity;
import com.yunbao.main.activity.ActiveTopicActivity;
import com.yunbao.main.bean.ActiveBean;
import com.yunbao.main.bean.ActiveUserBean;
import com.yunbao.main.custom.ActiveLikeImage;
import com.yunbao.mall.bean.GoodsChooseSpecBean;
import defpackage.cm4;
import defpackage.pm1;
import java.io.File;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class z3 extends ce3 {
    public yn0 A;
    public Drawable B;
    public Drawable C;
    public int D;
    public int E;
    public String F;
    public View.OnClickListener i;
    public View.OnClickListener j;
    public View.OnClickListener k;
    public View.OnClickListener l;
    public View.OnClickListener m;
    public View.OnClickListener n;
    public NineGridLayout.b o;
    public ActiveVoiceLayout.b p;
    public View.OnClickListener q;
    public Drawable[] r;
    public String s;
    public String t;
    public String u;
    public String v;
    public int w;
    public int x;
    public ActiveVoiceLayout y;
    public cm4 z;

    /* loaded from: /tmp/classes2.dex */
    public class a implements cm4.d {
        public a() {
        }

        @Override // cm4.d
        public void a() {
            if (z3.this.y != null) {
                z3.this.y.j();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag;
            if (!j10.a() || (tag = view.getTag()) == null || (z3.this.d instanceof ActiveDetailActivity)) {
                return;
            }
            ActiveDetailActivity.G1(z3.this.d, (ActiveBean) tag);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag;
            if (j10.a() && (tag = view.getTag()) != null) {
                pi3.q(z3.this.d, ((ActiveBean) tag).getUid());
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag;
            ActiveUserBean userBean;
            if (((AbsActivity) z3.this.d).e1() && j10.a() && (tag = view.getTag()) != null && (userBean = ((ActiveBean) tag).getUserBean()) != null) {
                CommonHttpUtil.setAttention(userBean.getId(), null);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements View.OnClickListener {

        /* loaded from: /tmp/classes2.dex */
        public class a extends HttpCallback {
            public final /* synthetic */ m a;
            public final /* synthetic */ String b;

            public a(m mVar, String str) {
                this.a = mVar;
                this.b = str;
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i != 0) {
                    t54.b(str);
                    return;
                }
                if (strArr.length > 0) {
                    JSONObject parseObject = JSON.parseObject(strArr[0]);
                    int intValue = parseObject.getIntValue("islike");
                    int intValue2 = parseObject.getIntValue("likes");
                    this.a.O(intValue, intValue2);
                    zu0.c().j(new i4(z3.this.hashCode(), this.b, intValue, intValue2));
                }
            }
        }

        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag;
            m mVar;
            ActiveBean activeBean;
            if (((AbsActivity) z3.this.d).e1() && j10.a() && (tag = view.getTag()) != null && (activeBean = (mVar = (m) tag).K) != null) {
                String id = activeBean.getId();
                db2.c(id, new a(mVar, id));
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f implements View.OnClickListener {

        /* loaded from: /tmp/classes2.dex */
        public class a implements a.n {
            public final /* synthetic */ ActiveBean a;

            /* renamed from: z3$f$a$a, reason: collision with other inner class name */
            /* loaded from: /tmp/classes2.dex */
            public class C0168a extends HttpCallback {
                public C0168a() {
                }

                @Override // com.yunbao.common.http.HttpCallback
                public void onSuccess(int i, String str, String[] strArr) {
                    if (i == 0) {
                        zu0.c().j(new e4(a.this.a.getId()));
                    }
                    t54.b(str);
                }
            }

            public a(ActiveBean activeBean) {
                this.a = activeBean;
            }

            @Override // com.yunbao.common.utils.a.n
            public void a(String str, int i) {
                db2.e(this.a.getId(), new C0168a());
            }
        }

        /* loaded from: /tmp/classes2.dex */
        public class b implements a.n {
            public final /* synthetic */ ActiveBean a;

            public b(ActiveBean activeBean) {
                this.a = activeBean;
            }

            @Override // com.yunbao.common.utils.a.n
            public void a(String str, int i) {
                ActiveReportActivity.A1(z3.this.d, this.a.getId());
            }
        }

        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag;
            if (((AbsActivity) z3.this.d).e1() && j10.a() && (tag = view.getTag()) != null) {
                ActiveBean activeBean = (ActiveBean) tag;
                boolean isSelf = activeBean.isSelf();
                z3 z3Var = z3.this;
                if (isSelf) {
                    com.yunbao.common.utils.a.r(z3Var.d, new Integer[]{Integer.valueOf(m93.z1)}, new a(activeBean));
                } else {
                    com.yunbao.common.utils.a.r(z3Var.d, new Integer[]{Integer.valueOf(m93.S9)}, new b(activeBean));
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g implements NineGridLayout.b {

        /* loaded from: /tmp/classes2.dex */
        public class a implements pm1.c {
            public final /* synthetic */ List a;

            public a(List list) {
                this.a = list;
            }

            @Override // pm1.c
            public void a(ImageView imageView, int i) {
                kn1.f(z3.this.d, (String) this.a.get(i), imageView);
            }

            @Override // pm1.c
            public void b(int i) {
            }

            @Override // pm1.c
            public String c(int i) {
                return (String) this.a.get(i);
            }
        }

        public g() {
        }

        @Override // com.yunbao.common.custom.NineGridLayout.b
        public void a(Object obj, ImageView imageView) {
            kn1.f(z3.this.d, (String) obj, imageView);
        }

        @Override // com.yunbao.common.custom.NineGridLayout.b
        public void b(List list, int i) {
            pm1 pm1Var = new pm1();
            pm1Var.z2(list.size(), i, false, new a(list));
            pm1Var.d2(((AbsActivity) z3.this.d).getSupportFragmentManager(), "ImagePreviewDialog");
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class h implements ActiveVoiceLayout.b {

        /* loaded from: /tmp/classes2.dex */
        public class a extends vx2 {
            public final /* synthetic */ File a;
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;
            public final /* synthetic */ ActiveVoiceLayout d;

            /* renamed from: z3$h$a$a, reason: collision with other inner class name */
            /* loaded from: /tmp/classes2.dex */
            public class C0169a extends FileDownloadCallback {
                public C0169a() {
                }

                @Override // com.yunbao.common.http.FileDownloadCallback
                public void onSuccess(File file) {
                    a.this.d.i();
                }
            }

            public a(File file, String str, String str2, ActiveVoiceLayout activeVoiceLayout) {
                this.a = file;
                this.b = str;
                this.c = str2;
                this.d = activeVoiceLayout;
            }

            @Override // defpackage.vx2
            public void a() {
                if (z3.this.A == null) {
                    z3.this.A = new yn0("downloadMusic");
                }
                z3.this.A.c(this.a, this.b, this.c, new C0169a());
            }
        }

        public h() {
        }

        @Override // com.yunbao.common.custom.ActiveVoiceLayout.b
        public File a() {
            return null;
        }

        @Override // com.yunbao.common.custom.ActiveVoiceLayout.b
        public void b() {
            z3.this.y = null;
            z3.this.V0();
        }

        @Override // com.yunbao.common.custom.ActiveVoiceLayout.b
        public void c(ActiveVoiceLayout activeVoiceLayout, File file) {
            if (z3.this.y != null && z3.this.y != activeVoiceLayout) {
                z3.this.y.j();
            }
            z3.this.y = activeVoiceLayout;
            z3.this.S0(file);
        }

        @Override // com.yunbao.common.custom.ActiveVoiceLayout.b
        public void d(ActiveVoiceLayout activeVoiceLayout, String str) {
            if (z3.this.y != null) {
                z3.this.y.j();
            }
            z3.this.y = null;
            File file = new File(j30.L);
            if (!file.exists()) {
                file.mkdirs();
            }
            String a2 = fa2.a(str);
            if (new File(file, a2).exists()) {
                activeVoiceLayout.i();
            } else {
                yx2.a((AbsActivity) z3.this.d, new a(file, a2, str, activeVoiceLayout), zj2.u());
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class i implements View.OnClickListener {
        public i() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null) {
                return;
            }
            ActiveBean activeBean = (ActiveBean) tag;
            pi3.s(z3.this.d, activeBean.getVideoUrl(), activeBean.getVideoImage());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class j implements View.OnClickListener {
        public j() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = (String) view.getTag(m93.d);
            int h = rv3.h((String) view.getTag(m93.e), 0);
            String str2 = (String) view.getTag(m93.f);
            z3 z3Var = z3.this;
            if (h == 1) {
                pi3.g(z3Var.d, str, false);
            } else {
                pi3.e(z3Var.d, str, false, "0", str2);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class k extends m {
        public View M;
        public ImageView N;
        public TextView O;
        public TextView P;
        public TextView Q;
        public TextView R;

        public k(View view) {
            super(view);
            this.M = view.findViewById(c73.s0);
            this.N = (ImageView) view.findViewById(c73.q2);
            this.O = (TextView) view.findViewById(c73.o2);
            this.P = (TextView) view.findViewById(c73.r2);
            this.Q = (TextView) view.findViewById(c73.p2);
            this.R = (TextView) view.findViewById(c73.s2);
            this.M.setOnClickListener(z3.this.n);
        }

        @Override // z3.m
        public void P(ActiveBean activeBean, int i, Object obj) {
            super.P(activeBean, i, obj);
            if (obj == null) {
                String goodsInfo = activeBean.getGoodsInfo();
                if (TextUtils.isEmpty(goodsInfo) || "{}".equals(goodsInfo)) {
                    return;
                }
                try {
                    JSONObject parseObject = JSON.parseObject(goodsInfo);
                    this.M.setTag(m93.d, parseObject.getString("id"));
                    this.M.setTag(m93.e, parseObject.getString("type"));
                    this.M.setTag(m93.f, activeBean.getUid());
                    List parseArray = JSON.parseArray(parseObject.getString("thumbs_format"), String.class);
                    if (parseArray != null && parseArray.size() > 0 && this.N != null) {
                        kn1.f(z3.this.d, (String) parseArray.get(0), this.N);
                    }
                    TextView textView = this.P;
                    if (textView != null) {
                        textView.setText(parseObject.getString("name"));
                    }
                    int intValue = parseObject.getIntValue("type");
                    if (intValue == 1) {
                        TextView textView2 = this.O;
                        if (textView2 != null) {
                            textView2.setText(parseObject.getString("present_price"));
                        }
                    } else {
                        List parseArray2 = JSON.parseArray(parseObject.getString("specs_format"), GoodsChooseSpecBean.class);
                        if (parseArray2 != null && parseArray2.size() > 0) {
                            GoodsChooseSpecBean goodsChooseSpecBean = (GoodsChooseSpecBean) parseArray2.get(0);
                            TextView textView3 = this.O;
                            if (textView3 != null) {
                                textView3.setText(goodsChooseSpecBean.getPrice());
                            }
                        }
                    }
                    TextView textView4 = this.Q;
                    if (textView4 != null) {
                        textView4.setText(aq4.b(m93.f6, parseObject.getString("sale_nums")));
                    }
                    if (intValue == 1 || !j30.q().N() || !j30.q().C().equals(activeBean.getUid())) {
                        TextView textView5 = this.R;
                        if (textView5 == null || textView5.getVisibility() == 4) {
                            return;
                        }
                        this.R.setVisibility(4);
                        return;
                    }
                    TextView textView6 = this.R;
                    if (textView6 != null) {
                        if (textView6.getVisibility() != 0) {
                            this.R.setVisibility(0);
                        }
                        this.R.setText(String.format(z3.this.F, parseObject.getString("share_income")));
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class l extends m {
        public NineGridLayout M;

        public l(View view) {
            super(view);
            NineGridLayout nineGridLayout = (NineGridLayout) view.findViewById(c73.P3);
            this.M = nineGridLayout;
            nineGridLayout.setActionListener(z3.this.o);
        }

        @Override // z3.m
        public void P(ActiveBean activeBean, int i, Object obj) {
            super.P(activeBean, i, obj);
            if (obj == null) {
                this.M.setData(activeBean.getImageList());
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class m extends RecyclerView.e0 {
        public TextView A;
        public View B;
        public TextView C;
        public TextView D;
        public View E;
        public TextView F;
        public View G;
        public TextView H;
        public ActiveLikeImage I;
        public View J;
        public ActiveBean K;
        public ImageView u;
        public View v;
        public TextView w;
        public ImageView x;
        public TextView y;
        public TextView z;

        /* loaded from: /tmp/classes2.dex */
        public class a extends ClickableSpan {
            public final /* synthetic */ String a;
            public final /* synthetic */ String b;

            public a(String str, String str2) {
                this.a = str;
                this.b = str2;
            }

            @Override // android.text.style.ClickableSpan
            public void onClick(View view) {
                ActiveTopicActivity.A1(z3.this.d, this.a, this.b);
            }

            @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
            public void updateDrawState(TextPaint textPaint) {
                super.updateDrawState(textPaint);
                textPaint.setColor(z3.this.E);
                textPaint.setUnderlineText(false);
            }
        }

        public m(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(c73.l);
            this.v = view.findViewById(c73.J);
            this.w = (TextView) view.findViewById(c73.L3);
            this.x = (ImageView) view.findViewById(c73.x4);
            this.y = (TextView) view.findViewById(c73.m0);
            this.z = (TextView) view.findViewById(c73.A4);
            TextView textView = (TextView) view.findViewById(c73.C4);
            this.A = textView;
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            this.A.setHighlightColor(0);
            this.B = view.findViewById(c73.e);
            this.C = (TextView) view.findViewById(c73.d);
            this.D = (TextView) view.findViewById(c73.B1);
            this.E = view.findViewById(c73.y3);
            this.F = (TextView) view.findViewById(c73.G1);
            this.G = view.findViewById(c73.z0);
            this.H = (TextView) view.findViewById(c73.x3);
            this.I = (ActiveLikeImage) view.findViewById(c73.w3);
            this.J = view.findViewById(c73.I0);
            view.setOnClickListener(z3.this.i);
            this.v.setOnClickListener(z3.this.j);
            this.y.setOnClickListener(z3.this.k);
            this.G.setOnClickListener(z3.this.l);
            this.J.setOnClickListener(z3.this.m);
            this.I.setDrawables(z3.this.r);
        }

        public void O(int i, int i2) {
            ActiveBean activeBean = this.K;
            if (activeBean != null) {
                activeBean.setIsLike(i);
                this.K.setLikeNum(i2);
                TextView textView = this.H;
                if (textView != null) {
                    textView.setText(this.K.getLikeNumString());
                }
                ActiveLikeImage activeLikeImage = this.I;
                if (activeLikeImage != null) {
                    activeLikeImage.g(i == 1, true);
                }
            }
        }

        public void P(ActiveBean activeBean, int i, Object obj) {
            if (obj == null) {
                this.K = activeBean;
                this.v.setTag(activeBean);
                ((RecyclerView.e0) this).a.setTag(activeBean);
                this.G.setTag(this);
                this.y.setTag(activeBean);
                this.J.setTag(activeBean);
                ActiveUserBean userBean = activeBean.getUserBean();
                if (userBean != null) {
                    kn1.g(z3.this.d, userBean.getAvatar(), this.u);
                    this.w.setText(userBean.getUserNiceName());
                    this.x.setImageResource(l30.b(userBean.getSex()));
                }
                if (!TextUtils.isEmpty(activeBean.getText()) || !TextUtils.isEmpty(activeBean.getTopicName())) {
                    if (this.A.getVisibility() != 0) {
                        this.A.setVisibility(0);
                    }
                    if (TextUtils.isEmpty(activeBean.getTopicName())) {
                        this.A.setText(activeBean.getText());
                    } else {
                        String topicId = activeBean.getTopicId();
                        String topicName = activeBean.getTopicName();
                        SpannableString spannableString = new SpannableString(rv3.a(topicName, " ", activeBean.getText()));
                        spannableString.setSpan(new a(topicId, topicName), 0, topicName.length(), 33);
                        this.A.setText(spannableString);
                    }
                } else if (this.A.getVisibility() != 8) {
                    this.A.setVisibility(8);
                }
                boolean isEmpty = TextUtils.isEmpty(activeBean.getAddress());
                View view = this.B;
                if (!isEmpty) {
                    if (view.getVisibility() != 0) {
                        this.B.setVisibility(0);
                    }
                    this.C.setText(activeBean.getAddress());
                } else if (view.getVisibility() != 8) {
                    this.B.setVisibility(8);
                }
                this.D.setText(activeBean.getDateTime());
                boolean isSelf = activeBean.isSelf();
                TextView textView = this.y;
                if (isSelf) {
                    if (textView.getVisibility() == 0) {
                        this.y.setVisibility(4);
                    }
                    int status = activeBean.getStatus();
                    TextView textView2 = this.z;
                    if (status != 1) {
                        if (textView2.getVisibility() != 0) {
                            this.z.setVisibility(0);
                        }
                        int status2 = activeBean.getStatus();
                        TextView textView3 = this.z;
                        if (status2 == 0) {
                            textView3.setText(z3.this.u);
                            this.z.setTextColor(z3.this.w);
                        } else {
                            textView3.setText(z3.this.v);
                            this.z.setTextColor(z3.this.x);
                        }
                    } else if (textView2.getVisibility() == 0) {
                        this.z.setVisibility(4);
                    }
                } else if (textView.getVisibility() != 0) {
                    this.y.setVisibility(0);
                }
            }
            this.F.setText(activeBean.getCommentNumString());
            this.I.g(activeBean.isLike(), false);
            this.H.setText(activeBean.getLikeNumString());
            if (this.y.getVisibility() == 0) {
                boolean isFollow = activeBean.isFollow();
                TextView textView4 = this.y;
                if (isFollow) {
                    textView4.setText(z3.this.s);
                    this.y.setTextColor(z3.this.D);
                    this.y.setBackground(z3.this.B);
                } else {
                    textView4.setText(z3.this.t);
                    this.y.setTextColor(z3.this.E);
                    this.y.setBackground(z3.this.C);
                }
            }
            View view2 = this.E;
            if (i == 0) {
                if (view2.getVisibility() != 8) {
                    this.E.setVisibility(8);
                }
            } else if (view2.getVisibility() != 0) {
                this.E.setVisibility(0);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class n extends m {
        public View M;
        public ImageView N;

        public n(View view) {
            super(view);
            this.M = view.findViewById(c73.q1);
            this.N = (ImageView) view.findViewById(c73.v5);
            this.M.setOnClickListener(z3.this.q);
        }

        @Override // z3.m
        public void P(ActiveBean activeBean, int i, Object obj) {
            super.P(activeBean, i, obj);
            if (obj == null) {
                this.M.setTag(activeBean);
                kn1.f(z3.this.d, activeBean.getVideoImage(), this.N);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class o extends m {
        public ActiveVoiceLayout M;

        public o(View view) {
            super(view);
            ActiveVoiceLayout activeVoiceLayout = (ActiveVoiceLayout) view.findViewById(c73.F5);
            this.M = activeVoiceLayout;
            activeVoiceLayout.setActionListener(z3.this.p);
        }

        @Override // z3.m
        public void P(ActiveBean activeBean, int i, Object obj) {
            super.P(activeBean, i, obj);
            if (obj == null) {
                this.M.setSecondsMax(activeBean.getVoiceDuration());
                this.M.setVoiceUrl(activeBean.getVoiceUrl());
            }
        }

        public boolean Q() {
            ActiveVoiceLayout activeVoiceLayout = this.M;
            return activeVoiceLayout != null && activeVoiceLayout.g();
        }

        public void R() {
            ActiveVoiceLayout activeVoiceLayout = this.M;
            if (activeVoiceLayout != null) {
                activeVoiceLayout.j();
            }
        }
    }

    public z3(Context context) {
        super(context);
        N0(context);
    }

    public z3(Context context, List list) {
        super(context, list);
        N0(context);
    }

    public void A(RecyclerView.e0 e0Var, int i2, List list) {
        ((m) e0Var).P((ActiveBean) this.e.get(i2), i2, list.size() > 0 ? list.get(0) : null);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i2) {
        return i2 == 1 ? new l(this.f.inflate(y73.p0, viewGroup, false)) : i2 == 3 ? new o(this.f.inflate(y73.s0, viewGroup, false)) : i2 == 2 ? new n(this.f.inflate(y73.r0, viewGroup, false)) : i2 == 4 ? new k(this.f.inflate(y73.o0, viewGroup, false)) : new m(this.f.inflate(y73.q0, viewGroup, false));
    }

    public void F(RecyclerView.e0 e0Var) {
        if (e0Var instanceof o) {
            o oVar = (o) e0Var;
            if (oVar.Q()) {
                oVar.R();
            }
        }
    }

    @Override // defpackage.ce3
    public void M() {
        ActiveVoiceLayout activeVoiceLayout = this.y;
        if (activeVoiceLayout != null) {
            activeVoiceLayout.j();
        }
        super.M();
    }

    public final void N0(Context context) {
        Drawable[] drawableArr = new Drawable[6];
        this.r = drawableArr;
        drawableArr[0] = o60.d(context, u83.c);
        this.r[1] = o60.d(context, u83.d);
        this.r[2] = o60.d(context, u83.e);
        this.r[3] = o60.d(context, u83.f);
        this.r[4] = o60.d(context, u83.g);
        this.r[5] = o60.d(context, u83.h);
        this.B = o60.d(context, i63.i);
        this.C = o60.d(context, i63.h);
        this.D = o60.b(context, p53.j);
        this.E = o60.b(context, p53.g);
        this.s = aq4.a(m93.N1);
        this.t = aq4.a(m93.M1);
        this.u = aq4.a(m93.B0);
        this.v = aq4.a(m93.C0);
        this.F = aq4.a(m93.O);
        this.w = o60.b(this.d, p53.h);
        this.x = o60.b(this.d, p53.g);
        this.i = new b();
        this.j = new c();
        this.k = new d();
        this.l = new e();
        this.m = new f();
        this.o = new g();
        this.p = new h();
        this.q = new i();
        this.n = new j();
    }

    public void O0(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        for (ActiveBean activeBean : this.e) {
            if (str.equals(activeBean.getId())) {
                this.e.remove(activeBean);
                p();
                return;
            }
        }
    }

    @Override // defpackage.ce3
    public void P(List list) {
        ActiveVoiceLayout activeVoiceLayout = this.y;
        if (activeVoiceLayout != null) {
            activeVoiceLayout.j();
        }
        super.P(list);
    }

    public void P0(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int size = this.e.size();
        for (int i3 = 0; i3 < size; i3++) {
            ActiveBean activeBean = (ActiveBean) this.e.get(i3);
            if (str.equals(activeBean.getId())) {
                activeBean.setCommentNum(i2);
                r(i3, "payload");
                return;
            }
        }
    }

    public void Q0(String str, int i2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean z = false;
        for (ActiveBean activeBean : this.e) {
            if (str.equals(activeBean.getUid())) {
                ActiveUserBean userBean = activeBean.getUserBean();
                if (userBean != null) {
                    userBean.setIsAttention(i2);
                }
                z = true;
            }
        }
        if (z) {
            p();
        }
    }

    public void R0(int i2, String str, int i3, int i4) {
        if (i2 == hashCode() || TextUtils.isEmpty(str)) {
            return;
        }
        int size = this.e.size();
        for (int i5 = 0; i5 < size; i5++) {
            ActiveBean activeBean = (ActiveBean) this.e.get(i5);
            if (str.equals(activeBean.getId())) {
                activeBean.setLikeNum(i3);
                activeBean.setIsLike(i4);
                r(i5, "payload");
                return;
            }
        }
    }

    public final void S0(File file) {
        if (file == null) {
            return;
        }
        if (this.z == null) {
            cm4 cm4Var = new cm4(this.d);
            this.z = cm4Var;
            cm4Var.i(new a());
        }
        this.z.j(file.getAbsolutePath());
    }

    public void T0() {
        ActiveVoiceLayout activeVoiceLayout = this.y;
        if (activeVoiceLayout != null) {
            activeVoiceLayout.j();
        }
        cm4 cm4Var = this.z;
        if (cm4Var != null) {
            cm4Var.f();
        }
        this.z = null;
        db2.i("activeAddLike");
        db2.i("activeDelete");
        db2.i("downloadMusic");
    }

    public void U0() {
        ActiveVoiceLayout activeVoiceLayout = this.y;
        if (activeVoiceLayout != null) {
            activeVoiceLayout.j();
        }
    }

    public final void V0() {
        cm4 cm4Var = this.z;
        if (cm4Var != null) {
            cm4Var.k();
        }
    }

    public int l(int i2) {
        return ((ActiveBean) this.e.get(i2)).getActiveType();
    }

    public void z(RecyclerView.e0 e0Var, int i2) {
    }
}
