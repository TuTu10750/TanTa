package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* loaded from: /tmp/classes2.dex */
public class gj extends AsyncTask {
    public final WeakReference a;
    public Uri b;
    public Uri c;
    public final int d;
    public final int e;
    public final fj f;

    /* loaded from: /tmp/classes2.dex */
    public static class a {
        public Bitmap a;
        public aw0 b;
        public Exception c;

        public a(Bitmap bitmap, aw0 aw0Var) {
            this.a = bitmap;
            this.b = aw0Var;
        }

        public a(Exception exc) {
            this.c = exc;
        }
    }

    public gj(Context context, Uri uri, Uri uri2, int i, int i2, fj fjVar) {
        this.a = new WeakReference(context);
        this.b = uri;
        this.c = uri2;
        this.d = i;
        this.e = i2;
        this.f = fjVar;
    }

    public final boolean a(Bitmap bitmap, BitmapFactory.Options options) {
        if ((bitmap != null ? bitmap.getByteCount() : 0) <= 104857600) {
            return false;
        }
        options.inSampleSize *= 2;
        return true;
    }

    @Override // android.os.AsyncTask
    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public a doInBackground(Void... voidArr) {
        InputStream openInputStream;
        Context context = (Context) this.a.get();
        if (context == null) {
            return new a(new NullPointerException("context is null"));
        }
        if (this.b == null) {
            return new a(new NullPointerException("Input Uri cannot be null"));
        }
        try {
            e();
            BitmapFactory.Options options = new BitmapFactory.Options();
            options.inJustDecodeBounds = true;
            options.inSampleSize = hj.a(options, this.d, this.e);
            boolean z = false;
            options.inJustDecodeBounds = false;
            Bitmap bitmap = null;
            while (!z) {
                try {
                    openInputStream = context.getContentResolver().openInputStream(this.b);
                    try {
                        bitmap = BitmapFactory.decodeStream(openInputStream, null, options);
                    } finally {
                        hj.c(openInputStream);
                    }
                } catch (IOException e) {
                    Log.e("BitmapWorkerTask", "doInBackground: ImageDecoder.createSource: ", e);
                    return new a(new IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + this.b + "]", e));
                } catch (OutOfMemoryError e2) {
                    Log.e("BitmapWorkerTask", "doInBackground: BitmapFactory.decodeFileDescriptor: ", e2);
                    options.inSampleSize *= 2;
                }
                if (options.outWidth == -1 || options.outHeight == -1) {
                    return new a(new IllegalArgumentException("Bounds for bitmap could not be retrieved from the Uri: [" + this.b + "]"));
                }
                hj.c(openInputStream);
                if (!a(bitmap, options)) {
                    z = true;
                }
            }
            Uri uri = this.b;
            if (bitmap == null) {
                return new a(new IllegalArgumentException("Bitmap could not be decoded from the Uri: [" + uri + "]"));
            }
            int g = hj.g(context, uri);
            int e3 = hj.e(g);
            int f = hj.f(g);
            aw0 aw0Var = new aw0(g, e3, f);
            Matrix matrix = new Matrix();
            if (e3 != 0) {
                matrix.preRotate(e3);
            }
            if (f != 1) {
                matrix.postScale(f, 1.0f);
            }
            return !matrix.isIdentity() ? new a(hj.i(bitmap, matrix), aw0Var) : new a(bitmap, aw0Var);
        } catch (IOException | NullPointerException e4) {
            return new a(e4);
        }
    }

    public final void c(Uri uri, Uri uri2) {
        Closeable closeable;
        Response response;
        sk source;
        Log.d("BitmapWorkerTask", "downloadFile");
        if (uri2 == null) {
            z60.a("Output Uri is null - cannot download image");
            return;
        }
        Context context = (Context) this.a.get();
        if (context == null) {
            z60.a("Context is null");
            return;
        }
        OkHttpClient a2 = ps2.b.a();
        sk skVar = null;
        try {
            Response execute = a2.newCall(new Request.Builder().url(uri.toString()).build()).execute();
            try {
                source = execute.body().getSource();
            } catch (Throwable th) {
                th = th;
                response = execute;
                closeable = null;
            }
            try {
                OutputStream openOutputStream = context.getContentResolver().openOutputStream(uri2);
                if (openOutputStream == null) {
                    throw new NullPointerException("OutputStream for given output Uri is null");
                }
                kq3 g = qs2.g(openOutputStream);
                source.P(g);
                hj.c(source);
                hj.c(g);
                hj.c(execute.body());
                a2.dispatcher().cancelAll();
                this.b = this.c;
            } catch (Throwable th2) {
                th = th2;
                response = execute;
                closeable = null;
                skVar = source;
                hj.c(skVar);
                hj.c(closeable);
                if (response != null) {
                    hj.c(response.body());
                }
                a2.dispatcher().cancelAll();
                this.b = this.c;
                throw th;
            }
        } catch (Throwable th3) {
            th = th3;
            closeable = null;
            response = null;
        }
    }

    @Override // android.os.AsyncTask
    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public void onPostExecute(a aVar) {
        Exception exc = aVar.c;
        fj fjVar = this.f;
        if (exc == null) {
            fjVar.a(aVar.a, aVar.b, this.b, this.c);
        } else {
            fjVar.onFailure(exc);
        }
    }

    public final void e() {
        String scheme = this.b.getScheme();
        Log.d("BitmapWorkerTask", "Uri scheme: " + scheme);
        if ("http".equals(scheme) || "https".equals(scheme)) {
            try {
                c(this.b, this.c);
                return;
            } catch (IOException | NullPointerException e) {
                Log.e("BitmapWorkerTask", "Downloading failed", e);
                throw e;
            }
        }
        if ("file".equals(scheme) || "content".equals(scheme)) {
            return;
        }
        Log.e("BitmapWorkerTask", "Invalid Uri scheme " + scheme);
        n.a("Invalid Uri scheme", scheme);
    }
}
