package defpackage;

import android.text.TextUtils;
import com.tencent.imsdk.v2.V2TIMCallback;
import com.tencent.imsdk.v2.V2TIMManager;
import com.tencent.imsdk.v2.V2TIMUserFullInfo;

/* loaded from: /tmp/classes2.dex */
public abstract class ph1 {

    /* loaded from: /tmp/classes2.dex */
    public class a implements V2TIMCallback {
        public final /* synthetic */ hh1 a;

        public a(hh1 hh1Var) {
            this.a = hh1Var;
        }

        @Override // com.tencent.imsdk.v2.V2TIMCallback
        public void onError(int i, String str) {
            hh1 hh1Var = this.a;
            if (hh1Var != null) {
                hh1Var.onError(i, str);
            }
        }

        @Override // com.tencent.imsdk.v2.V2TIMCallback
        public void onSuccess() {
            hh1 hh1Var = this.a;
            if (hh1Var != null) {
                hh1Var.onSuccess();
            }
        }
    }

    public static void a(String str, String str2, hh1 hh1Var) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        V2TIMUserFullInfo v2TIMUserFullInfo = new V2TIMUserFullInfo();
        v2TIMUserFullInfo.setNickname(str2);
        v2TIMUserFullInfo.setFaceUrl(str);
        V2TIMManager.getInstance().setSelfInfo(v2TIMUserFullInfo, new a(hh1Var));
    }
}
