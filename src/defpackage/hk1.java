package defpackage;

import android.animation.ValueAnimator;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.umeng.analytics.pro.bv;
import com.umeng.commonsdk.statistics.UMErrorCode;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.utils.a;
import com.yunbao.im.bean.ImChatImageBean;
import com.yunbao.im.bean.ImMessageBean;
import com.yunbao.im.custom.ChatVoiceLayout;
import com.yunbao.im.custom.MyImageView;
import com.yunbao.im.dao.IMMessageBean;
import com.zzhoujay.richtext.RichText;
import defpackage.kn1;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class hk1 extends RecyclerView.Adapter {
    public Context d;
    public RecyclerView e;
    public LinearLayoutManager f;
    public UserBean g;
    public UserBean h;
    public String i;
    public List j = new ArrayList();
    public LayoutInflater k;
    public String l;
    public String m;
    public g n;
    public View.OnClickListener o;
    public int[] p;
    public ValueAnimator q;
    public ChatVoiceLayout r;
    public View.OnClickListener s;
    public View.OnLongClickListener t;
    public PopupWindow u;
    public View.OnClickListener v;
    public View.OnClickListener w;
    public int x;
    public long y;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v1, types: [com.yunbao.im.custom.MyImageView, android.view.View] */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j10.a()) {
                ?? r4 = (MyImageView) view;
                r4.getLocationOnScreen(hk1.this.p);
                if (hk1.this.n != null) {
                    hk1.this.n.W(r4, hk1.this.p[0], hk1.this.p[1]);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnClickListener {

        /* loaded from: /tmp/classes2.dex */
        public class a extends k30 {
            public final /* synthetic */ int a;

            public a(int i) {
                this.a = i;
            }

            @Override // defpackage.k30
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(File file) {
                hk1.this.r(this.a, "payload");
                if (hk1.this.q != null) {
                    hk1.this.q.start();
                }
                if (hk1.this.n != null) {
                    hk1.this.n.w(file);
                }
            }
        }

        /* renamed from: hk1$b$b, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0071b extends k30 {
            public final /* synthetic */ int a;

            public C0071b(int i) {
                this.a = i;
            }

            @Override // defpackage.k30
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(File file) {
                hk1.this.r(this.a, "payload");
                if (hk1.this.e != null) {
                    hk1.this.e.setLayoutFrozen(true);
                }
                if (hk1.this.q != null) {
                    hk1.this.q.start();
                }
                if (hk1.this.n != null) {
                    hk1.this.n.w(file);
                }
            }
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag;
            if (j10.a() && (tag = view.getTag()) != null) {
                int intValue = ((Integer) tag).intValue();
                IMMessageBean iMMessageBean = (IMMessageBean) hk1.this.j.get(intValue);
                ChatVoiceLayout chatVoiceLayout = hk1.this.r;
                hk1 hk1Var = hk1.this;
                if (chatVoiceLayout == null) {
                    hk1Var.r = (ChatVoiceLayout) view;
                    ck1.e().g(iMMessageBean, new C0071b(intValue));
                    return;
                }
                hk1Var.r.b();
                IMMessageBean iMMessageBean2 = hk1.this.r.getIMMessageBean();
                hk1 hk1Var2 = hk1.this;
                if (iMMessageBean2 != iMMessageBean) {
                    hk1Var2.r = (ChatVoiceLayout) view;
                    ck1.e().g(iMMessageBean, new a(intValue));
                    return;
                }
                if (hk1Var2.e != null) {
                    hk1.this.e.setLayoutFrozen(false);
                }
                hk1.this.r = null;
                if (hk1.this.n != null) {
                    hk1.this.n.u();
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements ValueAnimator.AnimatorUpdateListener {
        public c() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (hk1.this.r != null) {
                hk1.this.r.a((int) (floatValue / 300.0f));
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements View.OnLongClickListener {

        /* loaded from: /tmp/classes2.dex */
        public class a implements View.OnClickListener {
            public final /* synthetic */ IMMessageBean a;

            public a(IMMessageBean iMMessageBean) {
                this.a = iMMessageBean;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ((ClipboardManager) hk1.this.d.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("text", this.a.getText()));
                t54.a(m93.u1);
                if (hk1.this.u != null) {
                    hk1.this.u.dismiss();
                }
            }
        }

        /* loaded from: /tmp/classes2.dex */
        public class b implements View.OnClickListener {
            public final /* synthetic */ IMMessageBean a;

            public b(IMMessageBean iMMessageBean) {
                this.a = iMMessageBean;
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                hk1.this.i0(this.a);
                ck1.e().n(hk1.this.h.getId(), this.a.getMsgId());
                if (hk1.this.u != null) {
                    hk1.this.u.dismiss();
                }
            }
        }

        public d() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            View inflate;
            IMMessageBean iMMessageBean = (IMMessageBean) view.getTag(a73.o);
            int type = iMMessageBean.getType();
            hk1 hk1Var = hk1.this;
            if (type == 1) {
                inflate = LayoutInflater.from(hk1Var.d).inflate(w73.B, (ViewGroup) null);
                inflate.findViewById(a73.o).setOnClickListener(new a(iMMessageBean));
            } else {
                inflate = LayoutInflater.from(hk1Var.d).inflate(w73.C, (ViewGroup) null);
            }
            if (inflate == null) {
                return false;
            }
            inflate.findViewById(a73.i).setOnClickListener(new b(iMMessageBean));
            view.getLocationInWindow(hk1.this.p);
            PopupWindow popupWindow = new PopupWindow(inflate, -2, zn0.a(30), true);
            popupWindow.setBackgroundDrawable(new ColorDrawable());
            popupWindow.setOutsideTouchable(true);
            popupWindow.showAtLocation(hk1.this.e, 51, hk1.this.p[0], hk1.this.p[1] - zn0.a(30));
            hk1.this.u = popupWindow;
            return true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str = (String) view.getTag(m93.d);
            int h = rv3.h((String) view.getTag(m93.e), 0);
            hk1 hk1Var = hk1.this;
            if (h == 1) {
                pi3.g(hk1Var.d, str, false);
            } else {
                pi3.e(hk1Var.d, str, false, "0", hk1.this.i);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f implements View.OnClickListener {

        /* loaded from: /tmp/classes2.dex */
        public class a implements a.n {
            public final /* synthetic */ String a;
            public final /* synthetic */ String b;
            public final /* synthetic */ String c;

            public a(String str, String str2, String str3) {
                this.a = str;
                this.b = str2;
                this.c = str3;
            }

            @Override // com.yunbao.common.utils.a.n
            public void a(String str, int i) {
                if (i == m93.G8) {
                    String a = rv3.a("amapuri://route/plan?sname=我的位置&slat=", String.valueOf(j30.q().r()), "&slon=", String.valueOf(j30.q().v()), "&dlat=", this.a, "&dlon=", this.b, "&dname=", this.c, "&dev=0");
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setPackage("com.autonavi.minimap");
                    intent.setData(Uri.parse(a));
                    hk1.this.d.startActivity(intent);
                    return;
                }
                if (i == m93.F8) {
                    String a2 = rv3.a("baidumap://map/direction?origin=name:我的位置|latlng:", String.valueOf(j30.q().r()), ",", String.valueOf(j30.q().v()), "&destination=name:", this.c, "|latlng:", this.a, ",", this.b, "&mode=driving&coord_type=wgs84&src=", j30.y);
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    intent2.setPackage("com.baidu.BaiduMap");
                    intent2.setData(Uri.parse(a2));
                    hk1.this.d.startActivity(intent2);
                    return;
                }
                if (i == m93.H8) {
                    String a3 = rv3.a("qqmap://map/routeplan?type=drive&policy=0&from=我的位置&fromcoord=", String.valueOf(j30.q().r()), ",", String.valueOf(j30.q().v()), "&to=", this.c, "&tocoord=", this.a, ",", this.b, "&referer=");
                    Intent intent3 = new Intent("android.intent.action.VIEW");
                    intent3.setPackage("com.tencent.map");
                    intent3.setData(Uri.parse(a3));
                    hk1.this.d.startActivity(intent3);
                }
            }
        }

        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            String str;
            ImMessageBean.LocationMsgBean locationMsgBean = (ImMessageBean.LocationMsgBean) view.getTag(a73.v);
            if (locationMsgBean == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            if (j30.K("com.autonavi.minimap")) {
                arrayList.add(Integer.valueOf(m93.G8));
            }
            if (j30.K("com.baidu.BaiduMap")) {
                arrayList.add(Integer.valueOf(m93.F8));
            }
            if (j30.K("com.tencent.map")) {
                arrayList.add(Integer.valueOf(m93.H8));
            }
            if (arrayList.size() == 0) {
                t54.a(m93.v0);
                return;
            }
            String valueOf = String.valueOf(locationMsgBean.getLat());
            String valueOf2 = String.valueOf(locationMsgBean.getLng());
            try {
                str = JSON.parseObject(locationMsgBean.getAddress()).getString("name");
            } catch (Exception e) {
                e.printStackTrace();
                str = "";
            }
            com.yunbao.common.utils.a.r(hk1.this.d, (Integer[]) arrayList.toArray(new Integer[arrayList.size()]), new a(valueOf, valueOf2, str));
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface g {
        void W(MyImageView myImageView, int i, int i2);

        void u();

        void w(File file);
    }

    /* loaded from: /tmp/classes2.dex */
    public class h extends n {
        public MyImageView x;

        /* loaded from: /tmp/classes2.dex */
        public class a implements kn1.a {
            public a() {
            }

            @Override // kn1.a
            public void onLoadFailed() {
            }

            @Override // kn1.a
            public void onLoadSuccess(Drawable drawable) {
                if (h.this.x != null) {
                    int intrinsicHeight = (int) ((drawable.getIntrinsicHeight() / drawable.getIntrinsicWidth()) * hk1.this.x);
                    ViewGroup.LayoutParams layoutParams = h.this.x.getLayoutParams();
                    if (layoutParams.height != intrinsicHeight) {
                        layoutParams.height = intrinsicHeight;
                        h.this.x.requestLayout();
                    }
                    h.this.x.setImageDrawable(drawable);
                }
            }
        }

        /* JADX WARN: Type inference failed for: r3v2, types: [com.yunbao.im.custom.MyImageView, android.view.View] */
        public h(View view) {
            super(view);
            ?? r3 = (MyImageView) view.findViewById(a73.O);
            this.x = r3;
            r3.setOnClickListener(hk1.this.o);
        }

        @Override // hk1.n
        public void O(IMMessageBean iMMessageBean, int i, Object obj) {
            super.O(iMMessageBean, i, obj);
            if (obj == null) {
                this.x.setImageDrawable((Drawable) null);
                this.x.setIMMessageBean(iMMessageBean);
                if (iMMessageBean.getLocalPath().isEmpty() && iMMessageBean.getThumbImageUrl().isEmpty()) {
                    return;
                }
                a aVar = new a();
                String localPath = iMMessageBean.getLocalPath();
                boolean isEmpty = TextUtils.isEmpty(localPath);
                hk1 hk1Var = hk1.this;
                if (isEmpty) {
                    kn1.j(hk1Var.d, iMMessageBean.getThumbImageUrl(), aVar);
                } else {
                    kn1.i(hk1Var.d, new File(localPath), aVar);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class i extends RecyclerView.e0 {
        public TextView u;

        public i(View view) {
            super(view);
            this.u = (TextView) view;
        }

        public void O(IMMessageBean iMMessageBean) {
            if (iMMessageBean.getMsgId().startsWith("-110") && iMMessageBean.getSelf()) {
                RichText.from(iMMessageBean.getText()).into(this.u);
            } else {
                this.u.setText(iMMessageBean.getSelf() ? m93.k1 : m93.l1);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class j extends h {
        public View A;
        public View z;

        public j(View view) {
            super(view);
            this.z = view.findViewById(a73.N);
            this.A = view.findViewById(a73.S);
            this.x.setOnLongClickListener(hk1.this.t);
        }

        @Override // hk1.h, hk1.n
        public void O(IMMessageBean iMMessageBean, int i, Object obj) {
            super.O(iMMessageBean, i, obj);
            this.x.setTag(a73.o, iMMessageBean);
            int status = iMMessageBean.getStatus();
            View view = this.A;
            if (status == 1) {
                if (view.getVisibility() != 0) {
                    this.A.setVisibility(0);
                }
            } else if (view.getVisibility() == 0) {
                this.A.setVisibility(4);
            }
            int status2 = iMMessageBean.getStatus();
            View view2 = this.z;
            if (status2 == 3) {
                if (view2.getVisibility() != 0) {
                    this.z.setVisibility(0);
                }
            } else if (view2.getVisibility() == 0) {
                this.z.setVisibility(4);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class k extends m {
        public View A;
        public View B;
        public View z;

        public k(View view) {
            super(view);
            this.z = view.findViewById(a73.N);
            this.A = view.findViewById(a73.S);
            View findViewById = view.findViewById(a73.D);
            this.B = findViewById;
            findViewById.setOnLongClickListener(hk1.this.t);
        }

        @Override // hk1.m, hk1.n
        public void O(IMMessageBean iMMessageBean, int i, Object obj) {
            super.O(iMMessageBean, i, obj);
            this.B.setTag(a73.o, iMMessageBean);
            int status = iMMessageBean.getStatus();
            View view = this.A;
            if (status == 1) {
                if (view.getVisibility() != 0) {
                    this.A.setVisibility(0);
                }
            } else if (view.getVisibility() == 0) {
                this.A.setVisibility(4);
            }
            int status2 = iMMessageBean.getStatus();
            View view2 = this.z;
            if (status2 == 3) {
                if (view2.getVisibility() != 0) {
                    this.z.setVisibility(0);
                }
            } else if (view2.getVisibility() == 0) {
                this.z.setVisibility(4);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class l extends n {
        public View A;
        public View B;
        public TextView x;
        public ChatVoiceLayout y;
        public View z;

        public l(View view) {
            super(view);
            this.x = (TextView) view.findViewById(a73.I);
            ChatVoiceLayout chatVoiceLayout = (ChatVoiceLayout) view.findViewById(a73.r0);
            this.y = chatVoiceLayout;
            chatVoiceLayout.setOnClickListener(hk1.this.s);
            this.z = view.findViewById(a73.N);
            this.A = view.findViewById(a73.S);
            View findViewById = view.findViewById(a73.E);
            this.B = findViewById;
            findViewById.setOnLongClickListener(hk1.this.t);
            this.y.setOnLongClickListener(hk1.this.t);
        }

        @Override // hk1.n
        public void O(IMMessageBean iMMessageBean, int i, Object obj) {
            super.O(iMMessageBean, i, obj);
            if (iMMessageBean.getDuration() == 0) {
                return;
            }
            if (obj == null) {
                this.B.setTag(a73.o, iMMessageBean);
                this.x.setText(iMMessageBean.getDuration() + bv.aB);
                this.y.setTag(Integer.valueOf(i));
                this.y.setTag(a73.o, iMMessageBean);
                this.y.setIMMessageBean(iMMessageBean);
                this.y.setDuration(iMMessageBean.getDuration());
            }
            int status = iMMessageBean.getStatus();
            View view = this.A;
            if (status == 1) {
                if (view.getVisibility() != 0) {
                    this.A.setVisibility(0);
                }
            } else if (view.getVisibility() == 0) {
                this.A.setVisibility(4);
            }
            int status2 = iMMessageBean.getStatus();
            View view2 = this.z;
            if (status2 == 3) {
                if (view2.getVisibility() != 0) {
                    this.z.setVisibility(0);
                }
            } else if (view2.getVisibility() == 0) {
                this.z.setVisibility(4);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class m extends n {
        public TextView x;

        public m(View view) {
            super(view);
            this.x = (TextView) view.findViewById(a73.k0);
        }

        @Override // hk1.n
        public void O(IMMessageBean iMMessageBean, int i, Object obj) {
            super.O(iMMessageBean, i, obj);
            if (obj == null) {
                String text = iMMessageBean.getText();
                if (TextUtils.isEmpty(text)) {
                    return;
                }
                this.x.setText(iz0.b(text));
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class n extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;

        public n(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(a73.c);
            this.v = (TextView) view.findViewById(a73.m0);
        }

        public void O(IMMessageBean iMMessageBean, int i, Object obj) {
            if (obj == null) {
                boolean self = iMMessageBean.getSelf();
                hk1 hk1Var = hk1.this;
                if (self) {
                    kn1.g(hk1Var.d, hk1.this.l, this.u);
                } else {
                    kn1.g(hk1Var.d, hk1.this.m, this.u);
                }
                String showTimeString = iMMessageBean.getShowTimeString();
                boolean isEmpty = TextUtils.isEmpty(showTimeString);
                TextView textView = this.v;
                if (isEmpty) {
                    if (textView.getVisibility() != 8) {
                        this.v.setVisibility(8);
                    }
                } else {
                    if (textView.getVisibility() != 0) {
                        this.v.setVisibility(0);
                    }
                    this.v.setText(showTimeString);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class o extends n {
        public TextView x;
        public View y;
        public ChatVoiceLayout z;

        public o(View view) {
            super(view);
            this.y = view.findViewById(a73.Z);
            this.x = (TextView) view.findViewById(a73.I);
            ChatVoiceLayout chatVoiceLayout = (ChatVoiceLayout) view.findViewById(a73.r0);
            this.z = chatVoiceLayout;
            chatVoiceLayout.setOnClickListener(hk1.this.s);
        }

        @Override // hk1.n
        public void O(IMMessageBean iMMessageBean, int i, Object obj) {
            super.O(iMMessageBean, i, obj);
            if (iMMessageBean.getDuration() == 0) {
                return;
            }
            if (obj == null) {
                this.x.setText(iMMessageBean.getDuration() + bv.aB);
                this.z.setTag(Integer.valueOf(i));
                this.z.setIMMessageBean(iMMessageBean);
                this.z.setDuration(iMMessageBean.getDuration());
            }
            boolean isRead = iMMessageBean.isRead();
            View view = this.y;
            if (isRead) {
                if (view.getVisibility() == 0) {
                    this.y.setVisibility(4);
                }
            } else if (view.getVisibility() != 0) {
                this.y.setVisibility(0);
            }
        }
    }

    public hk1(Context context, String str, UserBean userBean) {
        this.d = context;
        this.k = LayoutInflater.from(context);
        UserBean D = j30.q().D();
        this.g = D;
        this.h = userBean;
        this.i = str;
        this.l = D.getAvatar();
        this.m = this.h.getAvatar();
        this.p = new int[2];
        this.x = zn0.a(UMErrorCode.E_UM_BE_NOT_MAINPROCESS);
        this.o = new a();
        this.s = new b();
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 900.0f);
        this.q = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.q.setDuration(700L);
        this.q.setRepeatCount(-1);
        this.q.setRepeatMode(1);
        this.q.addUpdateListener(new c());
        this.t = new d();
        this.v = new e();
        this.w = new f();
    }

    public void A(RecyclerView.e0 e0Var, int i2, List list) {
        if (e0Var instanceof n) {
            ((n) e0Var).O((IMMessageBean) this.j.get(i2), i2, list.size() > 0 ? list.get(0) : null);
        } else if (e0Var instanceof i) {
            ((i) e0Var).O((IMMessageBean) this.j.get(i2));
        }
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i2) {
        if (i2 == 9) {
            return new i(this.k.inflate(w73.l, viewGroup, false));
        }
        switch (i2) {
            case 1:
                return new m(this.k.inflate(w73.m, viewGroup, false));
            case 2:
                return new k(this.k.inflate(w73.n, viewGroup, false));
            case 3:
                return new h(this.k.inflate(w73.j, viewGroup, false));
            case 4:
                return new j(this.k.inflate(w73.k, viewGroup, false));
            case 5:
                return new o(this.k.inflate(w73.o, viewGroup, false));
            case 6:
                return new l(this.k.inflate(w73.p, viewGroup, false));
            default:
                return null;
        }
    }

    public ImChatImageBean e0(ImMessageBean imMessageBean) {
        ArrayList arrayList = new ArrayList();
        int size = this.j.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            ImMessageBean imMessageBean2 = ((IMMessageBean) this.j.get(i3)).getImMessageBean();
            if (imMessageBean2.getType() == 2) {
                arrayList.add(imMessageBean2);
                if (imMessageBean2.getMsgId().equals(imMessageBean.getMsgId())) {
                    i2 = arrayList.size() - 1;
                }
            }
        }
        return new ImChatImageBean(arrayList, i2);
    }

    public long f0() {
        return this.y;
    }

    public void g0(IMMessageBean iMMessageBean) {
        if (this.j == null || iMMessageBean == null) {
            return;
        }
        long timestamp = iMMessageBean.getTimestamp();
        if (!wj1.b(timestamp, this.y)) {
            iMMessageBean.setShowTimeString(wj1.a(timestamp));
            this.y = timestamp;
        }
        int size = this.j.size();
        this.j.add(iMMessageBean);
        s(size);
        int m2 = this.f.m2();
        int i2 = size - 1;
        RecyclerView recyclerView = this.e;
        if (m2 != i2) {
            recyclerView.E1(size);
        } else {
            recyclerView.v1(size);
        }
    }

    public void h0(String str) {
        List list = this.j;
        if (list == null || list.size() == 0) {
            return;
        }
        int size = this.j.size();
        for (int i2 = 0; i2 < size; i2++) {
            IMMessageBean iMMessageBean = (IMMessageBean) this.j.get(i2);
            if (iMMessageBean.getMsgId().equals(str)) {
                i0(iMMessageBean);
                iMMessageBean.setRevoked(true);
                q(i2);
                return;
            }
        }
    }

    public final void i0(IMMessageBean iMMessageBean) {
        ChatVoiceLayout chatVoiceLayout;
        if (iMMessageBean.getType() == 3 && (chatVoiceLayout = this.r) != null && chatVoiceLayout.getIMMessageBean() == iMMessageBean) {
            this.r.b();
            RecyclerView recyclerView = this.e;
            if (recyclerView != null) {
                recyclerView.setLayoutFrozen(false);
            }
            this.r = null;
            g gVar = this.n;
            if (gVar != null) {
                gVar.u();
            }
        }
    }

    public int j() {
        return this.j.size();
    }

    public void j0() {
        ValueAnimator valueAnimator = this.q;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.n = null;
        this.o = null;
        this.s = null;
    }

    public void k0() {
        LinearLayoutManager linearLayoutManager;
        if (this.j.size() <= 0 || (linearLayoutManager = this.f) == null) {
            return;
        }
        linearLayoutManager.M2(this.j.size() - 1, -zn0.a(20));
    }

    public int l(int i2) {
        IMMessageBean iMMessageBean = (IMMessageBean) this.j.get(i2);
        if (iMMessageBean.getRevoked()) {
            return 9;
        }
        int type = iMMessageBean.getType();
        if (type == 1) {
            return iMMessageBean.getSelf() ? 2 : 1;
        }
        if (type == 2) {
            return iMMessageBean.getSelf() ? 4 : 3;
        }
        if (type != 3) {
            return 0;
        }
        return iMMessageBean.getSelf() ? 6 : 5;
    }

    public void l0(g gVar) {
        this.n = gVar;
    }

    public void m0(long j2) {
        this.y = j2;
    }

    public void n0(List list) {
        if (this.j == null || list == null || list.size() <= 0) {
            return;
        }
        this.j.clear();
        this.j.addAll(list);
        p();
    }

    public void o0() {
        ChatVoiceLayout chatVoiceLayout = this.r;
        if (chatVoiceLayout != null) {
            chatVoiceLayout.b();
        }
        this.r = null;
        RecyclerView recyclerView = this.e;
        if (recyclerView != null) {
            recyclerView.setLayoutFrozen(false);
        }
    }

    public void p0(IMMessageBean iMMessageBean, int i2) {
        int size = this.j.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.j.get(i3) == iMMessageBean) {
                ((IMMessageBean) this.j.get(i3)).setStatus(i2);
                r(i3, "payload");
                return;
            }
        }
    }

    public void y(RecyclerView recyclerView) {
        this.e = recyclerView;
        this.f = recyclerView.getLayoutManager();
    }

    public void z(RecyclerView.e0 e0Var, int i2) {
    }
}
