package defpackage;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/* loaded from: /tmp/classes2.dex */
public final class zk {
    public final InputStream a(String str) {
        str.getClass();
        ClassLoader classLoader = zk.class.getClassLoader();
        if (classLoader == null) {
            return ClassLoader.getSystemResourceAsStream(str);
        }
        URL resource = classLoader.getResource(str);
        if (resource == null) {
            return null;
        }
        URLConnection openConnection = resource.openConnection();
        openConnection.setUseCaches(false);
        return openConnection.getInputStream();
    }
}
