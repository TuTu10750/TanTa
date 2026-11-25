package defpackage;

import android.content.Context;
import android.net.Uri;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

/* loaded from: /tmp/classes2.dex */
public abstract class t11 {
    public static void a(Context context, Uri uri, Uri uri2) {
        Throwable th;
        OutputStream outputStream;
        InputStream openInputStream;
        if (uri.equals(uri2)) {
            return;
        }
        InputStream inputStream = null;
        try {
            openInputStream = context.getContentResolver().openInputStream(uri);
        } catch (Throwable th2) {
            th = th2;
            outputStream = null;
        }
        try {
            OutputStream openOutputStream = context.getContentResolver().openOutputStream(uri2);
            if (!(openInputStream instanceof FileInputStream) || !(openOutputStream instanceof FileOutputStream)) {
                throw new IllegalArgumentException("The input or output URI don't represent a file. uCrop requires then to represent files in order to work properly.");
            }
            FileChannel channel = ((FileInputStream) openInputStream).getChannel();
            channel.transferTo(0L, channel.size(), ((FileOutputStream) openOutputStream).getChannel());
            openInputStream.close();
            openOutputStream.close();
        } catch (Throwable th3) {
            th = th3;
            inputStream = openInputStream;
            outputStream = null;
            if (inputStream != null) {
                inputStream.close();
            }
            if (outputStream == null) {
                throw th;
            }
            outputStream.close();
            throw th;
        }
    }
}
