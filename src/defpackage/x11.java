package defpackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import kotlin.io.FileAlreadyExistsException;
import kotlin.io.FileSystemException;
import kotlin.io.NoSuchFileException;

/* loaded from: /tmp/classes2.dex */
public abstract class x11 extends w11 {
    public static final File c(File file, File file2, boolean z, int i) {
        file.getClass();
        file2.getClass();
        if (!file.exists()) {
            throw new NoSuchFileException(file, null, "The source file doesn't exist.", 2, null);
        }
        if (file2.exists()) {
            if (!z) {
                throw new FileAlreadyExistsException(file, file2, "The destination file already exists.");
            }
            if (!file2.delete()) {
                throw new FileAlreadyExistsException(file, file2, "Tried to overwrite the destination, but failed to delete it.");
            }
        }
        if (file.isDirectory()) {
            if (file2.mkdirs()) {
                return file2;
            }
            throw new FileSystemException(file, file2, "Failed to create target directory.");
        }
        File parentFile = file2.getParentFile();
        if (parentFile != null) {
            parentFile.mkdirs();
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file2);
            try {
                pm.a(fileInputStream, fileOutputStream, i);
                qc4 qc4Var = qc4.a;
                o10.a(fileOutputStream, null);
                o10.a(fileInputStream, null);
                return file2;
            } finally {
            }
        } finally {
        }
    }

    public static /* synthetic */ File d(File file, File file2, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 8192;
        }
        return c(file, file2, z, i);
    }

    public static String e(File file) {
        file.getClass();
        String name = file.getName();
        name.getClass();
        return hw3.F0(name, '.', "");
    }

    public static String f(File file) {
        file.getClass();
        String name = file.getName();
        name.getClass();
        return hw3.O0(name, ".", null, 2, null);
    }

    public static final File g(File file, File file2) {
        file.getClass();
        file2.getClass();
        if (u11.b(file2)) {
            return file2;
        }
        String file3 = file.toString();
        file3.getClass();
        if (file3.length() != 0) {
            char c = File.separatorChar;
            if (!hw3.R(file3, c, false, 2, null)) {
                return new File(file3 + c + file2);
            }
        }
        return new File(file3 + file2);
    }

    public static File h(File file, String str) {
        file.getClass();
        str.getClass();
        return g(file, new File(str));
    }
}
