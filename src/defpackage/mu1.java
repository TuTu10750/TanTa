package defpackage;

import com.alibaba.fastjson.JSON;
import java.util.List;
import org.json.JSONObject;

/* loaded from: /tmp/classes2.dex */
public abstract class mu1 {
    public static List a(String str, Class cls) {
        if (str == null) {
            return null;
        }
        try {
            return JSON.parseArray(str, cls);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String b(String str, String str2) {
        try {
            return new JSONObject(str).getString(str2);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
