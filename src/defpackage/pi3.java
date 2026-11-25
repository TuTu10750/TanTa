package defpackage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import com.yunbao.common.CommonAppContext;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.common.http.HttpCallback;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public abstract class pi3 {
    public static List a = Arrays.asList("livettm://invite.activity", "livettm://promotion.activity", "livettm://vip.activity", "livettm://coin.activity");

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;
        public final /* synthetic */ String c;
        public final /* synthetic */ String d;
        public final /* synthetic */ boolean e;
        public final /* synthetic */ Parcelable f;

        public a(Context context, String str, String str2, String str3, boolean z, Parcelable parcelable) {
            this.a = context;
            this.b = str;
            this.c = str2;
            this.d = str3;
            this.e = z;
            this.f = parcelable;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0) {
                t54.b(str);
                return;
            }
            Intent intent = new Intent();
            intent.setClassName(this.a.getPackageName(), "com.yunbao.mall.activity.GoodsDetailActivity");
            intent.putExtra("mallGoodsId", this.b);
            intent.putExtra("liveUid", this.c);
            intent.putExtra("shareUid", this.d);
            intent.putExtra("mallGoodsFromShop", this.e);
            Parcelable parcelable = this.f;
            if (parcelable != null) {
                intent.putExtra("liveBean", parcelable);
            }
            this.a.startActivity(intent);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ Parcelable d;

        public b(Context context, String str, boolean z, Parcelable parcelable) {
            this.a = context;
            this.b = str;
            this.c = z;
            this.d = parcelable;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0) {
                t54.b(str);
                return;
            }
            Intent intent = new Intent();
            intent.setClassName(this.a.getPackageName(), "com.yunbao.mall.activity.GoodsOutSideDetailActivity");
            intent.putExtra("mallGoodsId", this.b);
            intent.putExtra("liveUid", "0");
            intent.putExtra("mallGoodsFromShop", this.c);
            Parcelable parcelable = this.d;
            if (parcelable != null) {
                intent.putExtra("liveBean", parcelable);
            }
            this.a.startActivity(intent);
        }
    }

    public static void a(String str) {
        if (str == null || str.isEmpty()) {
            return;
        }
        Iterator it = a.iterator();
        while (it.hasNext()) {
            if (((String) it.next()).equals(str)) {
                try {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(str));
                    CommonAppContext.n().startActivity(intent);
                    return;
                } catch (Exception unused) {
                    return;
                }
            }
        }
        if (str.equals("route_invite")) {
            u();
            return;
        }
        if (str.equals("route_promotion")) {
            v();
        } else if (str.equals("route_vip")) {
            w("");
        } else if (str.equals("route_coin")) {
            t();
        }
    }

    public static void b(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName(context.getPackageName(), str);
        context.startActivity(intent);
    }

    public static void c(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName(context.getPackageName(), "com.yunbao.main.activity.ActivePubActivity");
        intent.putExtra("mallGoodsId", str);
        context.startActivity(intent);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void d(AbsActivity absActivity, int i) {
        Intent intent = new Intent();
        intent.setClassName(absActivity.getPackageName(), "com.yunbao.main.activity.AuthActivity");
        absActivity.startActivityForResult(intent, i);
    }

    public static void e(Context context, String str, boolean z, String str2, String str3) {
        f(context, str, z, str2, str3, null);
    }

    public static void f(Context context, String str, boolean z, String str2, String str3, Parcelable parcelable) {
        if (j30.q().Q()) {
            t54.a(m93.t0);
        } else {
            CommonHttpUtil.checkGoodsExist(str, new a(context, str, str2, str3, z, parcelable));
        }
    }

    public static void g(Context context, String str, boolean z) {
        h(context, str, z, null);
    }

    public static void h(Context context, String str, boolean z, Parcelable parcelable) {
        if (j30.q().Q()) {
            t54.a(m93.t0);
        } else {
            CommonHttpUtil.checkGoodsExist(str, new b(context, str, z, parcelable));
        }
    }

    public static void i() {
        Intent intent = new Intent();
        intent.setClassName(CommonAppContext.n().getPackageName(), "com.yunbao.phonelive.activity.LauncherActivity");
        intent.setFlags(268468224);
        CommonAppContext.n().startActivity(intent);
    }

    public static void j(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context.getPackageName(), "com.yunbao.live.activity.LiveAudienceActivity");
        context.startActivity(intent);
    }

    public static void k(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context.getPackageName(), "com.yunbao.main.activity.MyBindPhoneActivity");
        context.startActivity(intent);
    }

    public static void l(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName(context.getPackageName(), "com.yunbao.main.activity.LoginActivity");
        intent.putExtra("tip", str);
        context.startActivity(intent);
    }

    public static void m(String str) {
        Intent intent = new Intent();
        intent.setClassName(CommonAppContext.n().getPackageName(), "com.yunbao.main.activity.MyBindPhoneActivity");
        intent.putExtra("tip", str);
        intent.setFlags(268435456);
        CommonAppContext.n().startActivity(intent);
    }

    public static void n(Context context) {
        Intent intent = new Intent();
        intent.setClassName(context.getPackageName(), "com.yunbao.main.activity.MyCoinActivity");
        context.startActivity(intent);
    }

    public static void o(Context context, String str) {
        if (j30.q().Q()) {
            t54.a(m93.t0);
            return;
        }
        Intent intent = new Intent();
        intent.setClassName(context.getPackageName(), "com.yunbao.mall.activity.PayContentDetailActivity");
        intent.putExtra("mallGoodsId", str);
        context.startActivity(intent);
    }

    public static void p(Context context, String str) {
        Intent intent = new Intent();
        intent.setClassName(context.getPackageName(), "com.yunbao.main.activity.GoodsShareFriendActivity");
        intent.putExtra("mallGoodsId", str);
        context.startActivity(intent);
    }

    public static void q(Context context, String str) {
        r(context, str, false, null);
    }

    public static void r(Context context, String str, boolean z, String str2) {
        Intent intent = new Intent();
        intent.setClassName(context.getPackageName(), "com.yunbao.main.activity.UserHomeActivity");
        intent.putExtra("toUid", str);
        intent.putExtra("fromLiveRoom", z);
        intent.putExtra("liveUid", str2);
        context.startActivity(intent);
    }

    public static void s(Context context, String str, String str2) {
    }

    public static void t() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse("livettm://coin.activity"));
        intent.setFlags(268435456);
        CommonAppContext.n().startActivity(intent);
    }

    public static void u() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse("livettm://invite.activity"));
        intent.setFlags(268435456);
        CommonAppContext.n().startActivity(intent);
    }

    public static void v() {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse("livettm://promotion.activity"));
        intent.setFlags(268435456);
        CommonAppContext.n().startActivity(intent);
    }

    public static void w(String str) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setData(Uri.parse("livettm://vip.activity"));
        intent.putExtra("source", str);
        intent.setFlags(268435456);
        CommonAppContext.n().startActivity(intent);
    }

    public static void x(String str) {
        Intent intent = new Intent();
        intent.setClassName(CommonAppContext.n().getPackageName(), "com.yunbao.main.activity.TeenagerTipActivity");
        intent.putExtra("tip", str);
        intent.setFlags(268435456);
        CommonAppContext.n().startActivity(intent);
    }
}
