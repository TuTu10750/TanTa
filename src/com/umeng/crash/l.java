package com.umeng.crash;

import android.content.Context;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.umcrash.custom_exception.UMCustomLogInfoBuilder;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.zip.GZIPOutputStream;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* loaded from: /tmp/classes2.dex */
final class l {
    public static File a(File file) {
        FileInputStream fileInputStream;
        Throwable th;
        GZIPOutputStream gZIPOutputStream;
        k.a(file.getPath());
        File file2 = new File(file.getParent(), file.getName() + ".gz");
        try {
            fileInputStream = new FileInputStream(file);
            try {
                gZIPOutputStream = new GZIPOutputStream(new FileOutputStream(file2, false));
                try {
                    byte[] bArr = new byte[8192];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        gZIPOutputStream.write(bArr, 0, read);
                    }
                    gZIPOutputStream.finish();
                    UCrash.a().b("UCrash.Upload", "zip success, file: " + file2.getName());
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        UCrash.a().a("UCrash.Upload", "zip failed, file: " + file2.getName(), th);
                        return file2;
                    } finally {
                        k.a((Closeable) gZIPOutputStream);
                        k.a(fileInputStream);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                gZIPOutputStream = null;
            }
        } catch (Throwable th4) {
            fileInputStream = null;
            th = th4;
            gZIPOutputStream = null;
        }
        return file2;
    }

    public static void a(Context context, String str) {
        for (File file : k.b()) {
            a(context, str, file, false);
        }
    }

    public static void a(Context context, String str, File file, boolean z) {
        try {
            if (!j.a(context, file)) {
                UCrash.a().b("UCrash.Upload", "not send. limit skipped!");
                return;
            }
            if (z && !UMFrUtils.isOnline(context)) {
                UCrash.a().b("UCrash.Upload", "not send. no network!");
                return;
            }
            UCrash.a().a("UCrash.Upload", "send file: " + file.getName());
            if (a(str, file, z)) {
                j.b(context, file);
                file.delete();
            }
        } catch (Throwable th) {
            UCrash.a().a("UCrash.Upload", "upload failed", th);
        }
    }

    private static boolean a(String str, File file, boolean z) {
        int i;
        int i2;
        FileInputStream fileInputStream;
        DataOutputStream dataOutputStream;
        long currentTimeMillis = System.currentTimeMillis();
        UCrash.a().b("UCrash.Upload", "upload to " + str + UMCustomLogInfoBuilder.LINE_SEP + file.getName() + ", file size: " + file.length());
        if (file.length() < 256) {
            UCrash.a().d("UCrash.Upload", "file length < 256B, ignored");
            file.delete();
            return false;
        }
        if (file.length() > 819200) {
            UCrash.a().d("UCrash.Upload", "file length > 800K, ignored");
            file.delete();
            return false;
        }
        String str2 = c.a().b;
        HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
        try {
            httpURLConnection.setDoInput(false);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setUseCaches(false);
            if (z) {
                i = IjkMediaCodecInfo.RANK_MAX;
                i2 = 3000;
            } else {
                i = 10000;
                i2 = 30000;
            }
            int i3 = i2;
            httpURLConnection.setConnectTimeout(i);
            httpURLConnection.setReadTimeout(i3);
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setRequestProperty("Connection", "close");
            httpURLConnection.setRequestProperty("ak", str2);
            httpURLConnection.setRequestProperty("ts", String.valueOf(currentTimeMillis));
            httpURLConnection.setRequestProperty("sign", UMUtils.MD5(str2 + "7EC2papS9acZxgIb" + currentTimeMillis));
            httpURLConnection.setRequestProperty("Content-Type", "multipart/form-data;boundary=".concat("----WebKitFormBoundaryP0Rfzlf32iRoMhmb"));
            DataOutputStream dataOutputStream2 = null;
            try {
                dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
                try {
                    dataOutputStream.writeBytes("------WebKitFormBoundaryP0Rfzlf32iRoMhmb\r\n");
                    dataOutputStream.writeBytes("Content-Disposition: form-data; name=\"file\";filename=\"" + file.getName() + "\"\r\n");
                    dataOutputStream.writeBytes("\r\n");
                    fileInputStream = new FileInputStream(file);
                } catch (Throwable th) {
                    th = th;
                    fileInputStream = null;
                }
            } catch (Throwable th2) {
                th = th2;
                fileInputStream = null;
            }
            try {
                byte[] bArr = new byte[8192];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    dataOutputStream.write(bArr, 0, read);
                }
                dataOutputStream.writeBytes("\r\n");
                dataOutputStream.writeBytes("------WebKitFormBoundaryP0Rfzlf32iRoMhmb--\r\n");
                dataOutputStream.flush();
                k.a((Closeable) dataOutputStream);
                k.a(fileInputStream);
                int responseCode = httpURLConnection.getResponseCode();
                UCrash.a().b("UCrash.Upload", "resp code: ".concat(String.valueOf(responseCode)));
                return responseCode == 200;
            } catch (Throwable th3) {
                th = th3;
                dataOutputStream2 = dataOutputStream;
                k.a((Closeable) dataOutputStream2);
                k.a(fileInputStream);
                throw th;
            }
        } finally {
            try {
                httpURLConnection.disconnect();
            } catch (Throwable th4) {
                UCrash.a().a("UCrash.Upload", "disconnect failed", th4);
            }
            UCrash.a().a("UCrash.Upload", "upload cost: " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
        }
    }
}
