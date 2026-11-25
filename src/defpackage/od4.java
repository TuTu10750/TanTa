package defpackage;

import android.content.res.AssetFileDescriptor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import com.alibaba.sdk.android.oss.ClientConfiguration;
import com.alibaba.sdk.android.oss.ClientException;
import com.alibaba.sdk.android.oss.OSSClient;
import com.alibaba.sdk.android.oss.ServiceException;
import com.alibaba.sdk.android.oss.callback.OSSCompletedCallback;
import com.alibaba.sdk.android.oss.callback.OSSProgressCallback;
import com.alibaba.sdk.android.oss.common.auth.OSSStsTokenCredentialProvider;
import com.alibaba.sdk.android.oss.model.PutObjectRequest;
import com.alibaba.sdk.android.oss.model.PutObjectResult;
import com.alibaba.sdk.android.oss.signer.SignVersion;
import com.yunbao.common.CommonAppContext;
import com.yunbao.common.upload.UploadBean;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import top.zibin.luban.api.Luban;

/* loaded from: /tmp/classes2.dex */
public class od4 implements qd4 {
    public List a;
    public int b;
    public boolean c;
    public pd4 d;
    public boolean e;
    public final OSSClient f;
    public final OSSCompletedCallback g;
    public final String h;
    public final String i;
    public final String j;
    public final String k;

    /* loaded from: /tmp/classes2.dex */
    public class a implements OSSCompletedCallback {
        public a() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onFailure(PutObjectRequest putObjectRequest, ClientException clientException, ServiceException serviceException) {
            if (clientException != null) {
                clientException.printStackTrace();
            }
            if (serviceException != null) {
                Log.e("ErrorCode", serviceException.getErrorCode());
                Log.e("RequestId", serviceException.getRequestId());
                Log.e("HostId", serviceException.getHostId());
                Log.e("RawMessage", serviceException.getRawMessage());
            }
            if (od4.this.v(putObjectRequest, od4.this.t())) {
                od4.this.s(false);
            }
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSuccess(PutObjectRequest putObjectRequest, PutObjectResult putObjectResult) {
            File compressFile;
            File originFile;
            Log.d("PutObject", "UploadSuccess");
            Log.d("ETag", putObjectResult.getETag());
            Log.d("RequestId", putObjectResult.getRequestId());
            UploadBean t = od4.this.t();
            od4 od4Var = od4.this;
            if (t == null) {
                od4Var.s(false);
                return;
            }
            if (od4Var.v(putObjectRequest, t)) {
                lx1.c("UploadAliImpl", "onStateChanged-----上传ok---->");
                t.setRemoteFileName(rv3.a(od4.this.h, t.getRemoteFileName()));
                if (t.getType() == 0 && (compressFile = t.getCompressFile()) != null && compressFile.exists() && (originFile = t.getOriginFile()) != null && !compressFile.getAbsolutePath().equals(originFile.getAbsolutePath())) {
                    compressFile.delete();
                }
                od4.i(od4.this);
                int i = od4.this.b;
                int size = od4.this.a.size();
                od4 od4Var2 = od4.this;
                if (i < size) {
                    od4Var2.y();
                } else {
                    od4Var2.s(true);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements zs2 {
        public final /* synthetic */ UploadBean a;
        public final /* synthetic */ int b;

        public b(UploadBean uploadBean, int i) {
            this.a = uploadBean;
            this.b = i;
        }

        @Override // defpackage.zs2
        public void a(File file) {
            boolean u = od4.this.u(this.a, this.b);
            od4 od4Var = od4.this;
            if (!u) {
                od4Var.q(file, this.a);
                return;
            }
            File r = od4Var.r(file, 75);
            if (r != null) {
                this.a.setCompressFile(r);
                od4.this.q(file, this.a);
            } else if (file != null && file.exists()) {
                this.a.setCompressFile(file);
            }
            od4.this.x(this.a);
        }

        @Override // defpackage.zs2
        public void onError(Throwable th) {
            if (od4.this.u(this.a, this.b)) {
                StringBuilder sb = new StringBuilder("Luban compress failed--->");
                sb.append(th == null ? "unknown" : th.getMessage());
                lx1.c("UploadAliImpl", sb.toString());
                File r = od4.this.r(this.a.getOriginFile(), 90);
                if (r != null) {
                    this.a.setCompressFile(r);
                }
                od4.this.x(this.a);
            }
        }

        @Override // defpackage.zs2
        public void onStart() {
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements OSSProgressCallback {
        public c() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onProgress(PutObjectRequest putObjectRequest, long j, long j2) {
            Log.d("PutObject", "currentSize: " + j + " totalSize: " + j2);
        }
    }

    public od4(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        this.h = str9 + "_";
        this.i = str7;
        this.k = str8;
        this.j = str;
        OSSStsTokenCredentialProvider oSSStsTokenCredentialProvider = new OSSStsTokenCredentialProvider(str4, str5, str6);
        ClientConfiguration clientConfiguration = new ClientConfiguration();
        clientConfiguration.setSignVersion(SignVersion.V4);
        OSSClient oSSClient = new OSSClient(CommonAppContext.n(), str2, oSSStsTokenCredentialProvider, clientConfiguration);
        this.f = oSSClient;
        oSSClient.setRegion(str3);
        this.g = new a();
    }

    public static /* synthetic */ int i(od4 od4Var) {
        int i = od4Var.b;
        od4Var.b = i + 1;
        return i;
    }

    @Override // defpackage.qd4
    public void a(List list, boolean z, pd4 pd4Var) {
        if (pd4Var == null) {
            return;
        }
        if (list == null || list.size() == 0) {
            pd4Var.a(list, false);
            return;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            if (((UploadBean) it.next()).getOriginFile() != null) {
                this.a = list;
                this.c = z;
                this.d = pd4Var;
                this.e = false;
                this.b = 0;
                y();
                return;
            }
        }
        pd4Var.a(list, true);
    }

    @Override // defpackage.qd4
    public void b() {
        this.e = true;
        List list = this.a;
        if (list != null) {
            list.clear();
        }
        this.d = null;
    }

    public final int o(int i, int i2, int i3) {
        int i4 = 1;
        while (true) {
            if (i / i4 <= i3 && i2 / i4 <= i3) {
                return i4;
            }
            i4 *= 2;
        }
    }

    public final void p(UploadBean uploadBean, int i) {
        try {
            Luban.n(CommonAppContext.n()).i(j30.M).h(new b(uploadBean, i)).g(uploadBean.getOriginFile()).f();
        } catch (Throwable th) {
            if (u(uploadBean, i)) {
                lx1.c("UploadAliImpl", "Luban launch failed--->" + th.getMessage());
                File r = r(uploadBean.getOriginFile(), 90);
                if (r != null) {
                    uploadBean.setCompressFile(r);
                }
                x(uploadBean);
            }
        }
    }

    public final void q(File file, UploadBean uploadBean) {
        if (file == null || !file.exists() || uploadBean == null || uploadBean.getOriginFile() == null || file.getAbsolutePath().equals(uploadBean.getOriginFile().getAbsolutePath())) {
            return;
        }
        file.delete();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v12, types: [android.graphics.Bitmap] */
    /* JADX WARN: Type inference failed for: r10v2, types: [android.graphics.Bitmap$Config] */
    /* JADX WARN: Type inference failed for: r10v3 */
    public final File r(File file, int i) {
        FileOutputStream fileOutputStream;
        AssetFileDescriptor.AutoCloseOutputStream autoCloseOutputStream = 0;
        autoCloseOutputStream = 0;
        if (file != null && file.exists()) {
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(file.getAbsolutePath(), options);
            if (options.outWidth > 0 && options.outHeight > 0) {
                BitmapFactory.Options options2 = new BitmapFactory.Options();
                options2.inSampleSize = o(options.outWidth, options.outHeight, 4096);
                Bitmap bitmap = Bitmap.Config.ARGB_8888;
                options2.inPreferredConfig = bitmap;
                try {
                    try {
                        bitmap = BitmapFactory.decodeFile(file.getAbsolutePath(), options2);
                        if (bitmap == 0) {
                            if (bitmap != 0 && !bitmap.isRecycled()) {
                                bitmap.recycle();
                            }
                            return null;
                        }
                        try {
                            File parentFile = file.getParentFile();
                            if (parentFile == null) {
                                if (!bitmap.isRecycled()) {
                                    bitmap.recycle();
                                }
                                return null;
                            }
                            File file2 = new File(parentFile, "u_" + System.nanoTime() + ".webp");
                            fileOutputStream = new FileOutputStream(file2);
                            try {
                                bitmap.compress(Bitmap.CompressFormat.WEBP, i, fileOutputStream);
                                fileOutputStream.flush();
                                try {
                                    fileOutputStream.close();
                                } catch (IOException unused) {
                                }
                                if (!bitmap.isRecycled()) {
                                    bitmap.recycle();
                                }
                                return file2;
                            } catch (IOException e) {
                                e = e;
                                e.printStackTrace();
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException unused2) {
                                    }
                                }
                                if (bitmap != 0 && !bitmap.isRecycled()) {
                                    bitmap.recycle();
                                }
                                return null;
                            } catch (OutOfMemoryError unused3) {
                                lx1.c("UploadAliImpl", "encode webp oom--->" + file.getAbsolutePath());
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException unused4) {
                                    }
                                }
                                if (bitmap != 0 && !bitmap.isRecycled()) {
                                    bitmap.recycle();
                                }
                                return null;
                            } catch (RuntimeException e2) {
                                e = e2;
                                lx1.c("UploadAliImpl", "encode webp failed--->" + e.getMessage());
                                if (fileOutputStream != null) {
                                    try {
                                        fileOutputStream.close();
                                    } catch (IOException unused5) {
                                    }
                                }
                                if (bitmap != 0 && !bitmap.isRecycled()) {
                                    bitmap.recycle();
                                }
                                return null;
                            }
                        } catch (IOException e3) {
                            e = e3;
                            fileOutputStream = null;
                        } catch (OutOfMemoryError unused6) {
                            fileOutputStream = null;
                        } catch (RuntimeException e4) {
                            e = e4;
                            fileOutputStream = null;
                        } catch (Throwable th) {
                            th = th;
                            if (autoCloseOutputStream != 0) {
                                try {
                                    autoCloseOutputStream.close();
                                } catch (IOException unused7) {
                                }
                            }
                            if (bitmap == 0) {
                                throw th;
                            }
                            if (bitmap.isRecycled()) {
                                throw th;
                            }
                            bitmap.recycle();
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        autoCloseOutputStream = "u_";
                    }
                } catch (IOException e5) {
                    e = e5;
                    bitmap = 0;
                    fileOutputStream = null;
                } catch (OutOfMemoryError unused8) {
                    bitmap = 0;
                    fileOutputStream = null;
                } catch (RuntimeException e6) {
                    e = e6;
                    bitmap = 0;
                    fileOutputStream = null;
                } catch (Throwable th3) {
                    th = th3;
                    bitmap = 0;
                }
            }
        }
        return null;
    }

    public final void s(boolean z) {
        pd4 pd4Var = this.d;
        if (pd4Var != null) {
            pd4Var.a(this.a, z);
        }
    }

    public final UploadBean t() {
        int i;
        if (!w() || (i = this.b) < 0 || i >= this.a.size()) {
            return null;
        }
        return (UploadBean) this.a.get(this.b);
    }

    public final boolean u(UploadBean uploadBean, int i) {
        return w() && uploadBean != null && i >= 0 && i < this.a.size() && this.b == i && this.a.get(i) == uploadBean;
    }

    public final boolean v(PutObjectRequest putObjectRequest, UploadBean uploadBean) {
        if (putObjectRequest == null || uploadBean == null || uploadBean.getRemoteFileName() == null) {
            return false;
        }
        return uploadBean.getRemoteFileName().equals(putObjectRequest.getObjectKey());
    }

    public final boolean w() {
        return (this.e || this.a == null || this.d == null) ? false : true;
    }

    public final void x(UploadBean uploadBean) {
        File compressFile;
        if (uploadBean == null || this.g == null || this.f == null) {
            s(false);
            return;
        }
        File originFile = uploadBean.getOriginFile();
        if (uploadBean.getType() == 0 && (compressFile = uploadBean.getCompressFile()) != null && compressFile.exists()) {
            originFile = compressFile;
        }
        if (originFile == null || !originFile.exists() || uploadBean.getRemoteFileName() == null) {
            s(false);
            return;
        }
        try {
            PutObjectRequest putObjectRequest = new PutObjectRequest(this.i, uploadBean.getRemoteFileName(), originFile.getAbsolutePath());
            putObjectRequest.setProgressCallback(new c());
            this.f.asyncPutObject(putObjectRequest, this.g);
        } catch (Exception e) {
            e.printStackTrace();
            s(false);
        }
    }

    public final void y() {
        if (w()) {
            UploadBean uploadBean = null;
            while (this.b < this.a.size() && ((uploadBean = (UploadBean) this.a.get(this.b)) == null || uploadBean.getOriginFile() == null)) {
                this.b++;
            }
            if (this.b >= this.a.size()) {
                s(true);
                return;
            }
            String str = this.k;
            if (str != null && !str.isEmpty()) {
                uploadBean.setBucket_url(this.k);
            }
            String str2 = this.j;
            String str3 = (str2 == null || str2.isEmpty()) ? "other/" : this.j;
            if (uploadBean.getType() == 0) {
                uploadBean.setRemoteFileName(rv3.a(str3, rv3.c(), ".webp"));
            } else if (uploadBean.getType() == 1) {
                uploadBean.setRemoteFileName(rv3.a(str3, rv3.c(), ".mp4"));
            } else if (uploadBean.getType() == 2) {
                uploadBean.setRemoteFileName(rv3.a(str3, rv3.c(), ".m4a"));
            }
            if (uploadBean.getType() != 0) {
                x(uploadBean);
                return;
            }
            if (this.c) {
                p(uploadBean, this.b);
                return;
            }
            File r = r(uploadBean.getOriginFile(), 90);
            if (r != null) {
                uploadBean.setCompressFile(r);
            }
            x(uploadBean);
        }
    }
}
