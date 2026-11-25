package defpackage;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.appcompat.app.AppCompatActivity;
import com.yunbao.common.CommonAppContext;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.bean.VersionBean;
import defpackage.nd4;

/* loaded from: /tmp/classes2.dex */
public abstract class ig4 {
    public static int a = 0;
    public static String b = "";

    /* loaded from: /tmp/classes2.dex */
    public class a implements nd4.b {
        public final /* synthetic */ String a;
        public final /* synthetic */ int b;
        public final /* synthetic */ VersionBean c;

        public a(String str, int i, VersionBean versionBean) {
            this.a = str;
            this.b = i;
            this.c = versionBean;
        }

        @Override // nd4.b
        public void a(Context context, jm0 jm0Var) {
            if (TextUtils.isEmpty(this.a)) {
                t54.a(m93.ia);
                return;
            }
            try {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(this.a));
                context.startActivity(intent);
            } catch (Exception unused) {
                t54.a(m93.ia);
            }
        }

        @Override // nd4.b
        public void b(Context context, jm0 jm0Var) {
            if (this.b == 1) {
                jm0Var.S1();
            }
            if (this.c.isForceUp() == 1) {
                System.exit(0);
            } else {
                jm0Var.S1();
            }
        }
    }

    public static int a() {
        if (a == 0) {
            try {
                a = CommonAppContext.n().getPackageManager().getPackageInfo(j30.y, 0).versionCode;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return a;
    }

    public static String b() {
        if (b.isEmpty()) {
            try {
                b = CommonAppContext.n().getPackageManager().getPackageInfo(j30.y, 0).versionName;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return b;
    }

    public static boolean c(String str) {
        int a2;
        return TextUtils.isEmpty(str) || (a2 = a()) == 0 || a2 >= rv3.h(str, 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void d(Context context, VersionBean versionBean, int i, String str) {
        nd4 nd4Var = new nd4();
        nd4Var.u2(versionBean.getApkDescribe());
        nd4Var.t2(new a(str, i, versionBean));
        if (context instanceof AbsActivity) {
            AppCompatActivity appCompatActivity = (AbsActivity) context;
            if (appCompatActivity.isFinishing() || appCompatActivity.isDestroyed()) {
                return;
            }
            k61 supportFragmentManager = appCompatActivity.getSupportFragmentManager();
            try {
                if (!supportFragmentManager.G0() && supportFragmentManager.i0("VersionUpdateDialog") == null) {
                    nd4Var.q2(supportFragmentManager, "VersionUpdateDialog");
                }
            } catch (IllegalStateException e) {
                lx1.c("VersionUtil", "show update dialog failed: " + e.getMessage());
            }
        }
    }
}
