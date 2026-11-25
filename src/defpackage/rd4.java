package defpackage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.http.CommonHttpConsts;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.common.http.HttpCallback;

/* loaded from: /tmp/classes2.dex */
public abstract class rd4 {
    public static qd4 a;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public final /* synthetic */ String a;
        public final /* synthetic */ k30 b;

        public a(String str, k30 k30Var) {
            this.a = str;
            this.b = k30Var;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length == 0) {
                t54.b(str);
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            String string = parseObject.getString("cloudtype");
            if ("qiniu".equals(string) || "aws".equals(string)) {
                t54.b("不可用");
                return;
            }
            if ("ali".equals(string)) {
                JSONObject jSONObject = parseObject.getJSONObject("aliInfo");
                qd4 unused = rd4.a = new od4(this.a, jSONObject.getString("alioss_endpoint"), jSONObject.getString("alioss_region"), jSONObject.getString("alioss_access_key_id"), jSONObject.getString("alioss_access_key_secret"), jSONObject.getString("alioss_security_token"), jSONObject.getString("alioss_bucket_name"), jSONObject.getString("alioss_bucket_url"), string);
                k30 k30Var = this.b;
                if (k30Var != null) {
                    k30Var.a(rd4.a);
                }
            }
        }
    }

    public static void c() {
        CommonHttpUtil.cancel(CommonHttpConsts.GET_UPLOAD_INFO);
        qd4 qd4Var = a;
        if (qd4Var != null) {
            qd4Var.b();
        }
    }

    public static void d(k30 k30Var) {
        e("", k30Var);
    }

    public static void e(String str, k30 k30Var) {
        CommonHttpUtil.getUploadInfo(new a(str, k30Var));
    }
}
