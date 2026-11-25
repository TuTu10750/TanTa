package defpackage;

import android.opengl.EGL14;
import android.opengl.EGLSurface;
import android.util.Log;

/* loaded from: /tmp/classes2.dex */
public abstract class ms0 {
    public cs0 a;
    public EGLSurface b = EGL14.EGL_NO_SURFACE;
    public int c = -1;
    public int d = -1;

    public ms0(cs0 cs0Var) {
        this.a = cs0Var;
    }

    public void a(Object obj) {
        if (this.b == EGL14.EGL_NO_SURFACE) {
            this.b = this.a.b(obj);
        } else {
            fl3.a("surface already created");
        }
    }

    public void b() {
        this.a.d(this.b);
    }

    public void c() {
        this.a.f(this.b);
        this.b = EGL14.EGL_NO_SURFACE;
        this.d = -1;
        this.c = -1;
    }

    public boolean d() {
        boolean g = this.a.g(this.b);
        if (!g) {
            Log.d("EglSurfaceBase", "WARNING: swapBuffers() failed");
        }
        return g;
    }
}
