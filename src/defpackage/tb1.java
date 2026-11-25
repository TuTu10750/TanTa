package defpackage;

import com.yunbao.common.http.CommonHttpConsts;
import com.yunbao.common.http.FileDownloadCallback;
import java.io.File;

/* loaded from: /tmp/classes2.dex */
public abstract class tb1 {

    /* loaded from: /tmp/classes2.dex */
    public class a extends FileDownloadCallback {
        public final /* synthetic */ k30 a;

        public a(k30 k30Var) {
            this.a = k30Var;
        }

        @Override // com.yunbao.common.http.FileDownloadCallback
        public void onError(Throwable th) {
            this.a.a(null);
        }

        @Override // com.yunbao.common.http.FileDownloadCallback
        public void onSuccess(File file) {
            this.a.a(file);
        }
    }

    public static void a(String str, String str2, k30 k30Var) {
        if (k30Var == null) {
            return;
        }
        File file = new File(j30.P);
        if (!file.exists()) {
            file.mkdirs();
        }
        File file2 = new File(file, str);
        if (file2.exists()) {
            k30Var.a(file2);
        } else {
            new yn0(CommonHttpConsts.DOWNLOAD_GIF).c(file, str, str2, new a(k30Var));
        }
    }
}
