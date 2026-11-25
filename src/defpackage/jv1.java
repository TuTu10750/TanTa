package defpackage;

import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class jv1 extends n11 {
    @Override // defpackage.n11
    public kq3 b(uw2 uw2Var, boolean z) {
        uw2Var.getClass();
        if (z) {
            t(uw2Var);
        }
        return qs2.f(uw2Var.toFile(), true);
    }

    @Override // defpackage.n11
    public void c(uw2 uw2Var, uw2 uw2Var2) {
        uw2Var.getClass();
        uw2Var2.getClass();
        if (uw2Var.toFile().renameTo(uw2Var2.toFile())) {
            return;
        }
        throw new IOException("failed to move " + uw2Var + " to " + uw2Var2);
    }

    @Override // defpackage.n11
    public void g(uw2 uw2Var, boolean z) {
        uw2Var.getClass();
        if (uw2Var.toFile().mkdir()) {
            return;
        }
        k11 m = m(uw2Var);
        if (m == null || !m.f()) {
            nq4.a("failed to create directory: ", uw2Var);
        } else if (z) {
            iv1.a(uw2Var, " already exists.");
        }
    }

    @Override // defpackage.n11
    public void i(uw2 uw2Var, boolean z) {
        uw2Var.getClass();
        if (Thread.interrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        File file = uw2Var.toFile();
        if (file.delete()) {
            return;
        }
        if (file.exists()) {
            nq4.a("failed to delete ", uw2Var);
        } else if (z) {
            oq4.a("no such file: ", uw2Var);
        }
    }

    @Override // defpackage.n11
    public List k(uw2 uw2Var) {
        uw2Var.getClass();
        List r = r(uw2Var, true);
        r.getClass();
        return r;
    }

    @Override // defpackage.n11
    public k11 m(uw2 uw2Var) {
        uw2Var.getClass();
        File file = uw2Var.toFile();
        boolean isFile = file.isFile();
        boolean isDirectory = file.isDirectory();
        long lastModified = file.lastModified();
        long length = file.length();
        if (isFile || isDirectory || lastModified != 0 || length != 0 || file.exists()) {
            return new k11(isFile, isDirectory, null, Long.valueOf(length), null, Long.valueOf(lastModified), null, null, 128, null);
        }
        return null;
    }

    @Override // defpackage.n11
    public e11 n(uw2 uw2Var) {
        uw2Var.getClass();
        return new zu1(false, new RandomAccessFile(uw2Var.toFile(), "r"));
    }

    @Override // defpackage.n11
    public kq3 p(uw2 uw2Var, boolean z) {
        kq3 g;
        uw2Var.getClass();
        if (z) {
            s(uw2Var);
        }
        g = rs2.g(uw2Var.toFile(), false, 1, null);
        return g;
    }

    @Override // defpackage.n11
    public wr3 q(uw2 uw2Var) {
        uw2Var.getClass();
        return qs2.j(uw2Var.toFile());
    }

    public final List r(uw2 uw2Var, boolean z) {
        File file = uw2Var.toFile();
        String[] list = file.list();
        if (list == null) {
            if (z) {
                if (!file.exists()) {
                    oq4.a("no such file: ", uw2Var);
                    return null;
                }
                nq4.a("failed to list ", uw2Var);
            }
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str : list) {
            str.getClass();
            arrayList.add(uw2Var.m(str));
        }
        w20.y(arrayList);
        return arrayList;
    }

    public final void s(uw2 uw2Var) {
        if (j(uw2Var)) {
            iv1.a(uw2Var, " already exists.");
        }
    }

    public final void t(uw2 uw2Var) {
        if (j(uw2Var)) {
            return;
        }
        iv1.a(uw2Var, " doesn't exist.");
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }
}
