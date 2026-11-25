package defpackage;

import defpackage.uw2;
import java.io.FileNotFoundException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

/* loaded from: /tmp/classes2.dex */
public class hq2 extends jv1 {
    @Override // defpackage.jv1, defpackage.n11
    public void c(uw2 uw2Var, uw2 uw2Var2) {
        uw2Var.getClass();
        uw2Var2.getClass();
        try {
            Files.move(uw2Var.o(), uw2Var2.o(), StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
        } catch (UnsupportedOperationException unused) {
            fe1.a("atomic move not supported");
        } catch (NoSuchFileException e) {
            throw new FileNotFoundException(e.getMessage());
        }
    }

    @Override // defpackage.jv1, defpackage.n11
    public k11 m(uw2 uw2Var) {
        uw2Var.getClass();
        return u(uw2Var.o());
    }

    @Override // defpackage.jv1
    public String toString() {
        return "NioSystemFileSystem";
    }

    public final k11 u(Path path) {
        path.getClass();
        try {
            BasicFileAttributes readAttributes = Files.readAttributes(path, (Class<BasicFileAttributes>) BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
            Path readSymbolicLink = readAttributes.isSymbolicLink() ? Files.readSymbolicLink(path) : null;
            boolean isRegularFile = readAttributes.isRegularFile();
            boolean isDirectory = readAttributes.isDirectory();
            uw2 f = readSymbolicLink != null ? uw2.a.f(uw2.b, readSymbolicLink, false, 1, null) : null;
            Long valueOf = Long.valueOf(readAttributes.size());
            FileTime creationTime = readAttributes.creationTime();
            Long v = creationTime != null ? v(creationTime) : null;
            FileTime lastModifiedTime = readAttributes.lastModifiedTime();
            Long v2 = lastModifiedTime != null ? v(lastModifiedTime) : null;
            FileTime lastAccessTime = readAttributes.lastAccessTime();
            return new k11(isRegularFile, isDirectory, f, valueOf, v, v2, lastAccessTime != null ? v(lastAccessTime) : null, null, 128, null);
        } catch (NoSuchFileException | FileSystemException unused) {
            return null;
        }
    }

    public final Long v(FileTime fileTime) {
        Long valueOf = Long.valueOf(fileTime.toMillis());
        if (valueOf.longValue() != 0) {
            return valueOf;
        }
        return null;
    }
}
