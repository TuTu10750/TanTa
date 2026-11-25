package defpackage;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.yunbao.common.CommonAppContext;
import java.util.Map;

/* loaded from: /tmp/classes2.dex */
public class bs3 {
    public static bs3 b;
    public SharedPreferences a = CommonAppContext.n().getSharedPreferences("SharedPreferences", 0);

    public static bs3 d() {
        if (b == null) {
            synchronized (bs3.class) {
                try {
                    if (b == null) {
                        b = new bs3();
                    }
                } finally {
                }
            }
        }
        return b;
    }

    public boolean a(String str) {
        return this.a.getBoolean(str, false);
    }

    public boolean b(String str, boolean z) {
        return this.a.getBoolean(str, z);
    }

    public float c() {
        return this.a.getFloat("brightness", -1.0f);
    }

    public int e(String str, int i) {
        return this.a.getInt(str, i);
    }

    public String[] f(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return null;
        }
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i = 0; i < length; i++) {
            String str = "";
            if (!TextUtils.isEmpty(strArr[i])) {
                str = this.a.getString(strArr[i], "");
            }
            strArr2[i] = str;
        }
        return strArr2;
    }

    public String g(String str) {
        return this.a.getString(str, "");
    }

    public String h(String str, String str2) {
        return this.a.getString(str, str2);
    }

    public boolean i() {
        return this.a.getBoolean("imMsgRing", true);
    }

    public void j(String... strArr) {
        SharedPreferences.Editor edit = this.a.edit();
        for (String str : strArr) {
            edit.remove(str);
        }
        edit.apply();
    }

    public void k(String str, boolean z) {
        SharedPreferences.Editor edit = this.a.edit();
        edit.putBoolean(str, z);
        edit.apply();
    }

    public void l(float f) {
        SharedPreferences.Editor edit = this.a.edit();
        edit.putFloat("brightness", f);
        edit.apply();
    }

    public void m(boolean z) {
        SharedPreferences.Editor edit = this.a.edit();
        edit.putBoolean("imMsgRing", z);
        edit.apply();
    }

    public void n(String str, int i) {
        SharedPreferences.Editor edit = this.a.edit();
        edit.putInt(str, i);
        edit.apply();
    }

    public void o(Map map) {
        if (map == null || map.size() == 0) {
            return;
        }
        SharedPreferences.Editor edit = this.a.edit();
        for (Map.Entry entry : map.entrySet()) {
            String str = (String) entry.getKey();
            String str2 = (String) entry.getValue();
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                edit.putString(str, str2);
            }
        }
        edit.apply();
    }

    public void p(String str, String str2) {
        SharedPreferences.Editor edit = this.a.edit();
        edit.putString(str, str2);
        edit.apply();
    }
}
