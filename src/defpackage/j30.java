package defpackage;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.text.TextUtils;
import android.util.SparseArray;
import com.alibaba.fastjson.JSON;
import com.netshield.Netshield;
import com.yunbao.common.CommonAppContext;
import com.yunbao.common.bean.ConfigBean;
import com.yunbao.common.bean.LevelBean;
import com.yunbao.common.bean.LiveClassBean;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.bean.VersionBean;
import com.yunbao.common.http.CommonHttpUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /tmp/classes2.dex */
public class j30 {
    public static final String F;
    public static final String G;
    public static final String H;
    public static final String I;
    public static final String J;
    public static final String K;
    public static final String L;
    public static final String M;
    public static final String N;
    public static final String O;
    public static final String P;
    public static final String Q;
    public static final String R;
    public static final String S;
    public static final int T;
    public static j30 U = null;
    public static String y = "com.tanta.livenew";
    public VersionBean a;
    public String b;
    public String c;
    public ConfigBean d;
    public double e;
    public double f;
    public String g;
    public String h;
    public String i;
    public UserBean j;
    public UserBean k;
    public boolean l;
    public SparseArray m;
    public SparseArray n;
    public String o;
    public String p;
    public boolean q;
    public int r;
    public String s;
    public String t;
    public Boolean u;
    public int v;
    public boolean w;
    public int x = 0;
    public static final Map z = new HashMap();
    public static String A = "t_11000;11000";
    public static String B = "t_12000;12000";
    public static String C = "t_13000;13000";
    public static String D = "t_14000;14000";
    public static String E = "";

    static {
        String m = m();
        F = m;
        String absolutePath = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).getAbsolutePath();
        G = absolutePath;
        String str = m + "/video/";
        H = str;
        String str2 = str + "/record/";
        I = str2;
        J = str2 + "/parts/";
        K = absolutePath + "/video/";
        L = m + "/music/";
        M = m + "/image/";
        N = absolutePath + "/image/";
        O = m + "/log/";
        P = m + "/gif/";
        Q = m + "/water/";
        R = m + "/im_sound/";
        S = m + "/im_image/";
        T = x("TxIMAppId");
    }

    public static String G() {
        return "n_11000;11000";
    }

    public static String H() {
        return "n_12000;12000";
    }

    public static String I() {
        return "n_13000;13000";
    }

    public static String J() {
        return "n_14000;14000";
    }

    public static boolean K(String str) {
        if (!TextUtils.isEmpty(str)) {
            Iterator<PackageInfo> it = CommonAppContext.n().getPackageManager().getInstalledPackages(0).iterator();
            while (it.hasNext()) {
                if (str.equalsIgnoreCase(it.next().packageName)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String m() {
        String str = null;
        try {
            File externalFilesDir = CommonAppContext.n().getExternalFilesDir("yunbao");
            if (externalFilesDir != null) {
                if (!externalFilesDir.exists()) {
                    externalFilesDir.mkdirs();
                }
                str = externalFilesDir.getAbsolutePath();
            }
        } catch (Exception unused) {
        }
        return TextUtils.isEmpty(str) ? CommonAppContext.n().getFilesDir().getAbsolutePath() : str;
    }

    public static String o() {
        lx1.c("9090", "89898999898899989889");
        int localhostPort = Netshield.getLocalhostPort(G());
        z.put("referer", "http://127.0.0.1:" + localhostPort);
        return "http://127.0.0.1:" + localhostPort;
    }

    public static String p(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith(o())) {
            return str;
        }
        if (!str.contains("?")) {
            str = rv3.a(str, "?");
        }
        return rv3.a(str, "&uid=", q().C(), "&token=", q().B(), "&", "language", "=", rx1.c().d());
    }

    public static j30 q() {
        if (U == null) {
            synchronized (j30.class) {
                try {
                    if (U == null) {
                        U = new j30();
                    }
                } finally {
                }
            }
        }
        return U;
    }

    public static int x(String str) {
        try {
            return CommonAppContext.n().getPackageManager().getApplicationInfo(CommonAppContext.n().getPackageName(), 128).metaData.getInt(str, 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String y(String str) {
        try {
            return CommonAppContext.n().getPackageManager().getApplicationInfo(CommonAppContext.n().getPackageName(), 128).metaData.getString(str);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String A() {
        ConfigBean h = h();
        return h != null ? h.getScoreName() : "积分";
    }

    public String B() {
        return this.c;
    }

    public String C() {
        if (TextUtils.isEmpty(this.b)) {
            String[] f = bs3.d().f("uid", "token");
            if (f == null) {
                this.b = "-9999";
                this.c = "-9999";
            } else if (TextUtils.isEmpty(f[0]) || TextUtils.isEmpty(f[1])) {
                this.b = "-9999";
                this.c = "-9999";
            } else {
                this.b = f[0];
                this.c = f[1];
            }
        }
        return this.b;
    }

    public UserBean D() {
        if (this.j == null) {
            String g = bs3.d().g("userInfo");
            if (!TextUtils.isEmpty(g)) {
                this.j = (UserBean) JSON.parseObject(g, UserBean.class);
            }
        }
        if (this.j == null) {
            this.j = l();
        }
        return this.j;
    }

    public void E(k30 k30Var) {
        if (k30Var == null) {
            return;
        }
        VersionBean versionBean = this.a;
        if (versionBean != null) {
            k30Var.a(versionBean);
        } else {
            CommonHttpUtil.checkUpgrade(k30Var);
        }
    }

    public String F() {
        ConfigBean h = h();
        return h != null ? h.getVotesName() : "映票";
    }

    public boolean L() {
        return bs3.d().b("baseFunctionMode", true);
    }

    public boolean M() {
        return this.l;
    }

    public boolean N() {
        return !"-9999".equals(C());
    }

    public boolean O() {
        return true;
    }

    public boolean P() {
        return this.w;
    }

    public boolean Q() {
        if (this.u == null) {
            this.u = Boolean.valueOf(bs3.d().a("teenager"));
        }
        return this.u.booleanValue();
    }

    public void R(String str) {
        List<LevelBean> parseArray;
        if (TextUtils.isEmpty(str) || (parseArray = JSON.parseArray(str, LevelBean.class)) == null || parseArray.size() == 0) {
            return;
        }
        if (this.n == null) {
            this.n = new SparseArray();
        }
        this.n.clear();
        for (LevelBean levelBean : parseArray) {
            this.n.put(levelBean.getLevel(), levelBean);
        }
    }

    public void S(boolean z2) {
        bs3.d().k("baseFunctionMode", z2);
    }

    public void T(ConfigBean configBean) {
        this.d = configBean;
    }

    public void U(boolean z2) {
        this.q = z2;
    }

    public void V(String str) {
        this.p = str;
    }

    public void W(String str) {
        this.o = str;
    }

    public void X(boolean z2) {
        this.l = z2;
    }

    public void Y(String str) {
        List<LevelBean> parseArray;
        if (TextUtils.isEmpty(str) || (parseArray = JSON.parseArray(str, LevelBean.class)) == null || parseArray.size() == 0) {
            return;
        }
        if (this.m == null) {
            this.m = new SparseArray();
        }
        this.m.clear();
        for (LevelBean levelBean : parseArray) {
            this.m.put(levelBean.getLevel(), levelBean);
        }
    }

    public void Z(String str, String str2, boolean z2) {
        lx1.c("登录成功", "uid------>" + str);
        lx1.c("登录成功", "token------>" + str2);
        this.b = str;
        this.c = str2;
        if (z2) {
            bs3.d().k("teenagerShow", false);
        }
        HashMap hashMap = new HashMap();
        hashMap.put("uid", str);
        hashMap.put("token", str2);
        bs3.d().o(hashMap);
    }

    public void a() {
        this.e = 0.0d;
        this.f = 0.0d;
        this.g = null;
        this.h = null;
        this.i = null;
        bs3.d().j("locationLng", "locationLat", "locationProvince", "locationCity", "locationDistrict");
    }

    public void a0(int i) {
        this.x = i;
    }

    public void b() {
        this.b = null;
        this.c = null;
        bs3.d().j("uid", "token", "userInfo", "txImUserSign", "cashAccountID", "cashAccount", "cashAccountType", "teenager", "teenagerShow");
        q().e0(l());
        this.w = false;
        zu0.c().j(new n10());
    }

    public void b0(boolean z2) {
        this.w = z2;
    }

    public LevelBean c(int i) {
        if (this.n == null) {
            String g = bs3.d().g("config");
            if (!TextUtils.isEmpty(g)) {
                R(JSON.parseObject(g).getString("levelanchor"));
            }
        }
        SparseArray sparseArray = this.n;
        if (sparseArray == null || sparseArray.size() == 0) {
            return null;
        }
        return (LevelBean) this.n.get(i);
    }

    public void c0(boolean z2) {
        this.u = Boolean.valueOf(z2);
        bs3.d().k("teenager", z2);
    }

    public int d() {
        if (this.r == 0) {
            this.r = CommonAppContext.n().getResources().getIdentifier("ic_laun", "mipmap", CommonAppContext.n().getPackageName());
        }
        return this.r;
    }

    public void d0(int i) {
        this.v = i;
    }

    public String e() {
        if (TextUtils.isEmpty(this.s)) {
            this.s = aq4.a(CommonAppContext.n().getResources().getIdentifier("app_name", "string", CommonAppContext.n().getPackageName()));
        }
        return this.s;
    }

    public void e0(UserBean userBean) {
        this.j = userBean;
    }

    public String f() {
        if (TextUtils.isEmpty(this.h)) {
            this.h = bs3.d().g("locationCity");
        }
        String str = this.h;
        return str == null ? "" : str;
    }

    public void f0(VersionBean versionBean) {
        this.a = versionBean;
    }

    public String g() {
        ConfigBean h = h();
        return h != null ? h.getCoinName() : "钻石";
    }

    public ConfigBean h() {
        if (this.d == null) {
            String g = bs3.d().g("config");
            if (!TextUtils.isEmpty(g)) {
                this.d = (ConfigBean) JSON.parseObject(g, ConfigBean.class);
            }
        }
        return this.d;
    }

    public void i(k30 k30Var) {
        if (k30Var == null) {
            return;
        }
        ConfigBean h = h();
        if (h != null) {
            k30Var.a(h);
        } else {
            CommonHttpUtil.getConfig(k30Var);
        }
    }

    public String j() {
        if (TextUtils.isEmpty(this.t)) {
            String g = bs3.d().g("deviceId");
            if (TextUtils.isEmpty(g)) {
                g = hm0.a();
                bs3.d().p("deviceId", g);
            }
            this.t = g;
        }
        lx1.b("getDeviceId---mDeviceId-----> " + this.t);
        return this.t;
    }

    public String k() {
        if (TextUtils.isEmpty(this.i)) {
            this.i = bs3.d().g("locationDistrict");
        }
        String str = this.i;
        return str == null ? "" : str;
    }

    public final UserBean l() {
        if (this.k == null) {
            UserBean userBean = new UserBean();
            userBean.setId("-9999");
            userBean.setUserNiceName("游客");
            userBean.setLevel(1);
            userBean.setLevelAnchor(1);
            String str = o() + "/default.jpg";
            userBean.setAvatar(str);
            userBean.setAvatarThumb(str);
            userBean.setSignature("");
            userBean.setCoin("");
            userBean.setVotes("");
            userBean.setConsumption("");
            userBean.setVotestotal(0);
            userBean.setProvince("");
            userBean.setCity("");
            userBean.setLocation("");
            userBean.setBirthday("");
            userBean.setVip(new UserBean.Vip());
            userBean.setLiang(new UserBean.Liang());
            userBean.setCar(new UserBean.Car());
            this.k = userBean;
        }
        return this.k;
    }

    public String n() {
        return this.p;
    }

    public double r() {
        if (this.f == 0.0d) {
            String g = bs3.d().g("locationLat");
            if (!TextUtils.isEmpty(g)) {
                try {
                    this.f = Double.parseDouble(g);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return this.f;
    }

    public LevelBean s(int i) {
        if (this.m == null) {
            String g = bs3.d().g("config");
            if (!TextUtils.isEmpty(g)) {
                Y(JSON.parseObject(g).getString("level"));
            }
        }
        SparseArray sparseArray = this.m;
        if (sparseArray == null || sparseArray.size() == 0) {
            return null;
        }
        return (LevelBean) this.m.get(i);
    }

    public List t() {
        new ArrayList();
        ConfigBean h = h();
        List<LiveClassBean> liveClass = h != null ? h.getLiveClass() : null;
        return liveClass == null ? new ArrayList() : liveClass;
    }

    public String[] u() {
        List t = t();
        String[] strArr = new String[t.size() + 1];
        int i = 0;
        strArr[0] = "关注";
        while (i < t.size()) {
            int i2 = i + 1;
            strArr[i2] = ((LiveClassBean) t.get(i)).getName();
            i = i2;
        }
        return strArr;
    }

    public double v() {
        if (this.e == 0.0d) {
            String g = bs3.d().g("locationLng");
            if (!TextUtils.isEmpty(g)) {
                try {
                    this.e = Double.parseDouble(g);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return this.e;
    }

    public int w() {
        return this.x;
    }

    public String z() {
        if (TextUtils.isEmpty(this.g)) {
            this.g = bs3.d().g("locationProvince");
        }
        String str = this.g;
        return str == null ? "" : str;
    }
}
