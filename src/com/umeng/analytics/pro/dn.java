package com.umeng.analytics.pro;

import com.umeng.analytics.pro.dx;
import java.io.ByteArrayOutputStream;
import java.io.UnsupportedEncodingException;

/* loaded from: /tmp/classes2.dex */
public class dn {
    private final ByteArrayOutputStream a;
    private final ep b;
    private ed c;

    public dn() {
        this(new dx.a());
    }

    public dn(ef efVar) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        this.a = byteArrayOutputStream;
        ep epVar = new ep(byteArrayOutputStream);
        this.b = epVar;
        this.c = efVar.a(epVar);
    }

    public String a(de deVar, String str) {
        try {
            return new String(a(deVar), str);
        } catch (UnsupportedEncodingException unused) {
            throw new dk("JVM DOES NOT SUPPORT ENCODING: " + str);
        }
    }

    public byte[] a(de deVar) {
        this.a.reset();
        deVar.write(this.c);
        return this.a.toByteArray();
    }

    public String b(de deVar) {
        return new String(a(deVar));
    }
}
