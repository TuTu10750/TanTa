package com.zzhoujay.richtext.cache;

import com.zzhoujay.richtext.drawable.DrawableSizeHolder;
import com.zzhoujay.richtext.ext.Debug;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* loaded from: /tmp/classes2.dex */
interface CacheIOHelper<INPUT, OUTPUT> {
    public static final int BUFFER_SIZE = 1024;
    public static final CacheIOHelper<DrawableSizeHolder, DrawableSizeHolder> SIZE_CACHE_IO_HELPER = new CacheIOHelper<DrawableSizeHolder, DrawableSizeHolder>() { // from class: com.zzhoujay.richtext.cache.CacheIOHelper.1
        @Override // com.zzhoujay.richtext.cache.CacheIOHelper
        public boolean hasCache(String str, bn0 bn0Var) {
            if (bn0Var != null) {
                try {
                    return bn0Var.B0(str) != null;
                } catch (IOException e) {
                    Debug.e(e);
                }
            }
            return false;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.zzhoujay.richtext.cache.CacheIOHelper
        public DrawableSizeHolder readFromCache(String str, bn0 bn0Var) {
            if (bn0Var != null) {
                try {
                    e B0 = bn0Var.B0(str);
                    if (B0 == null) {
                        return null;
                    }
                    InputStream a = B0.a(0);
                    DrawableSizeHolder read = DrawableSizeHolder.read(a, str);
                    a.close();
                    return read;
                } catch (IOException e) {
                    Debug.e(e);
                }
            }
            return null;
        }

        @Override // com.zzhoujay.richtext.cache.CacheIOHelper
        public void writeToCache(String str, DrawableSizeHolder drawableSizeHolder, bn0 bn0Var) {
            if (bn0Var != null) {
                try {
                    c z0 = bn0Var.z0(str);
                    if (z0 == null) {
                        return;
                    }
                    OutputStream f = z0.f(0);
                    drawableSizeHolder.save(f);
                    f.flush();
                    f.close();
                    z0.e();
                } catch (IOException e) {
                    Debug.e(e);
                }
            }
        }
    };
    public static final CacheIOHelper<InputStream, InputStream> REMOTE_IMAGE_CACHE_IO_HELPER = new CacheIOHelper<InputStream, InputStream>() { // from class: com.zzhoujay.richtext.cache.CacheIOHelper.2
        @Override // com.zzhoujay.richtext.cache.CacheIOHelper
        public boolean hasCache(String str, bn0 bn0Var) {
            if (bn0Var != null) {
                try {
                    return bn0Var.B0(str) != null;
                } catch (IOException e) {
                    Debug.e(e);
                }
            }
            return false;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.zzhoujay.richtext.cache.CacheIOHelper
        public InputStream readFromCache(String str, bn0 bn0Var) {
            e eVar;
            if (bn0Var == null) {
                return null;
            }
            try {
                eVar = bn0Var.B0(str);
            } catch (IOException e) {
                Debug.e(e);
                eVar = null;
            }
            if (eVar == null) {
                return null;
            }
            return eVar.a(0);
        }

        @Override // com.zzhoujay.richtext.cache.CacheIOHelper
        public void writeToCache(String str, InputStream inputStream, bn0 bn0Var) {
            if (bn0Var == null) {
                return;
            }
            try {
                c z0 = bn0Var.z0(str);
                if (z0 == null) {
                    return;
                }
                OutputStream f = z0.f(0);
                byte[] bArr = new byte[CacheIOHelper.BUFFER_SIZE];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        f.flush();
                        f.close();
                        inputStream.close();
                        z0.e();
                        return;
                    }
                    f.write(bArr, 0, read);
                }
            } catch (IOException e) {
                Debug.e(e);
            }
        }
    };

    boolean hasCache(String str, bn0 bn0Var);

    OUTPUT readFromCache(String str, bn0 bn0Var);

    void writeToCache(String str, INPUT input, bn0 bn0Var);
}
