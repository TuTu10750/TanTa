package defpackage;

import android.content.Context;
import android.os.Build;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/* loaded from: /tmp/classes2.dex */
public abstract class kb3 {
    public static final String a = System.mapLibraryName("pl_droidsonroids_gif");

    /* loaded from: /tmp/classes2.dex */
    public static class a implements FilenameFilter {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // java.io.FilenameFilter
        public boolean accept(File file, String str) {
            return str.startsWith(kb3.a) || str.startsWith(this.a);
        }
    }

    public static void b(File file, FilenameFilter filenameFilter) {
        File[] listFiles = file.getParentFile().listFiles(filenameFilter);
        if (listFiles != null) {
            for (File file2 : listFiles) {
                file2.delete();
            }
        }
    }

    public static void c(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException unused) {
            }
        }
    }

    public static void d(InputStream inputStream, OutputStream outputStream) {
        byte[] bArr = new byte[8192];
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return;
            } else {
                outputStream.write(bArr, 0, read);
            }
        }
    }

    public static ZipEntry e(ZipFile zipFile) {
        for (String str : g()) {
            ZipEntry f = f(zipFile, str);
            if (f != null) {
                return f;
            }
        }
        return null;
    }

    public static ZipEntry f(ZipFile zipFile, String str) {
        return zipFile.getEntry("lib/" + str + "/" + a);
    }

    public static String[] g() {
        return Build.SUPPORTED_ABIS;
    }

    public static void h(Context context) {
        synchronized (kb3.class) {
            System.load(k(context).getAbsolutePath());
        }
    }

    public static ZipFile i(File file) {
        ZipFile zipFile;
        int i = 0;
        while (true) {
            int i2 = i + 1;
            if (i >= 5) {
                zipFile = null;
                break;
            }
            try {
                zipFile = new ZipFile(file, 1);
                break;
            } catch (IOException unused) {
                i = i2;
            }
        }
        if (zipFile != null) {
            return zipFile;
        }
        di3.a("Could not open APK file: ", file.getAbsolutePath());
        return null;
    }

    public static void j(File file) {
        file.setReadable(true, false);
        file.setExecutable(true, false);
        file.setWritable(true);
    }

    public static File k(Context context) {
        ZipFile zipFile;
        Throwable th;
        InputStream inputStream;
        FileOutputStream fileOutputStream;
        Throwable th2;
        String str = a + "1.2.15";
        int i = 0;
        File file = new File(context.getDir("lib", 0), str);
        if (file.isFile()) {
            return file;
        }
        File file2 = new File(context.getCacheDir(), str);
        if (file2.isFile()) {
            return file2;
        }
        a aVar = new a(System.mapLibraryName("pl_droidsonroids_gif_surface"));
        b(file, aVar);
        b(file2, aVar);
        try {
            zipFile = i(new File(context.getApplicationInfo().sourceDir));
            while (true) {
                int i2 = i + 1;
                if (i >= 5) {
                    break;
                }
                try {
                    ZipEntry e = e(zipFile);
                    if (e == null) {
                        throw new IllegalStateException("Library " + a + " for supported ABIs not found in APK file");
                    }
                    try {
                        inputStream = zipFile.getInputStream(e);
                    } catch (IOException unused) {
                        inputStream = null;
                        fileOutputStream = null;
                    } catch (Throwable th3) {
                        th = th3;
                        inputStream = null;
                        fileOutputStream = null;
                    }
                    try {
                        fileOutputStream = new FileOutputStream(file);
                        try {
                            d(inputStream, fileOutputStream);
                            c(inputStream);
                            c(fileOutputStream);
                            j(file);
                            break;
                        } catch (IOException unused2) {
                            if (i2 > 2) {
                                file = file2;
                            }
                            c(inputStream);
                            c(fileOutputStream);
                            i = i2;
                        } catch (Throwable th4) {
                            th2 = th4;
                            c(inputStream);
                            c(fileOutputStream);
                            throw th2;
                        }
                    } catch (IOException unused3) {
                        fileOutputStream = null;
                    } catch (Throwable th5) {
                        th = th5;
                        fileOutputStream = null;
                        th2 = th;
                        c(inputStream);
                        c(fileOutputStream);
                        throw th2;
                    }
                } catch (Throwable th6) {
                    th = th6;
                    if (zipFile == null) {
                        throw th;
                    }
                    try {
                        zipFile.close();
                        throw th;
                    } catch (IOException unused4) {
                        throw th;
                    }
                }
                c(inputStream);
                c(fileOutputStream);
                i = i2;
            }
            if (zipFile != null) {
                try {
                    zipFile.close();
                } catch (IOException unused5) {
                }
            }
            return file;
        } catch (Throwable th7) {
            zipFile = null;
            th = th7;
        }
    }
}
