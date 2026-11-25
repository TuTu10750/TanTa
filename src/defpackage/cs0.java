package defpackage;

import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import android.util.Log;
import android.view.Surface;

/* loaded from: /tmp/classes2.dex */
public final class cs0 {
    public EGLDisplay a;
    public EGLContext b;
    public EGLConfig c;
    public int d;

    public cs0(EGLContext eGLContext, int i) {
        EGLConfig c;
        EGLDisplay eGLDisplay = EGL14.EGL_NO_DISPLAY;
        this.a = eGLDisplay;
        this.b = EGL14.EGL_NO_CONTEXT;
        this.c = null;
        this.d = -1;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            kc1.a("EGL already set up");
            throw null;
        }
        eGLContext = eGLContext == null ? EGL14.EGL_NO_CONTEXT : eGLContext;
        EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
        this.a = eglGetDisplay;
        if (eglGetDisplay == EGL14.EGL_NO_DISPLAY) {
            kc1.a("unable to get EGL14 display");
            throw null;
        }
        int[] iArr = new int[2];
        if (!EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
            this.a = null;
            kc1.a("unable to initialize EGL14");
            throw null;
        }
        if ((i & 2) != 0 && (c = c(i, 3)) != null) {
            EGLContext eglCreateContext = EGL14.eglCreateContext(this.a, c, eGLContext, new int[]{12440, 3, 12344}, 0);
            if (EGL14.eglGetError() == 12288) {
                this.c = c;
                this.b = eglCreateContext;
                this.d = 3;
            }
        }
        if (this.b == EGL14.EGL_NO_CONTEXT) {
            EGLConfig c2 = c(i, 2);
            if (c2 == null) {
                kc1.a("Unable to find a suitable EGLConfig");
                throw null;
            }
            EGLContext eglCreateContext2 = EGL14.eglCreateContext(this.a, c2, eGLContext, new int[]{12440, 2, 12344}, 0);
            a("eglCreateContext");
            this.c = c2;
            this.b = eglCreateContext2;
            this.d = 2;
        }
        int[] iArr2 = new int[1];
        EGL14.eglQueryContext(this.a, this.b, 12440, iArr2, 0);
        Log.d("EGLCore", "EGLContext created, client version " + iArr2[0]);
    }

    public final void a(String str) {
        int eglGetError = EGL14.eglGetError();
        if (eglGetError == 12288) {
            return;
        }
        throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
    }

    public EGLSurface b(Object obj) {
        if (!(obj instanceof Surface) && !(obj instanceof SurfaceTexture)) {
            bs0.a("invalid surface: ", obj);
            return null;
        }
        EGLSurface eglCreateWindowSurface = EGL14.eglCreateWindowSurface(this.a, this.c, obj, new int[]{12344}, 0);
        a("eglCreateWindowSurface");
        if (eglCreateWindowSurface != null) {
            return eglCreateWindowSurface;
        }
        kc1.a("surface was null");
        return null;
    }

    public final EGLConfig c(int i, int i2) {
        int[] iArr = {12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, i2 >= 3 ? 68 : 4, 12344, 0, 12344};
        if ((i & 1) != 0) {
            iArr[10] = 12610;
            iArr[11] = 1;
        }
        EGLConfig[] eGLConfigArr = new EGLConfig[1];
        if (EGL14.eglChooseConfig(this.a, iArr, 0, eGLConfigArr, 0, 1, new int[1], 0)) {
            return eGLConfigArr[0];
        }
        Log.w("EGLCore", "unable to find RGB8888 / " + i2 + " EGLConfig");
        return null;
    }

    public void d(EGLSurface eGLSurface) {
        if (this.a == EGL14.EGL_NO_DISPLAY) {
            Log.d("EGLCore", "NOTE: makeCurrent w/o display");
        }
        if (EGL14.eglMakeCurrent(this.a, eGLSurface, eGLSurface, this.b)) {
            return;
        }
        kc1.a("eglMakeCurrent failed");
    }

    public void e() {
        EGLDisplay eGLDisplay = this.a;
        if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
            EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
            EGL14.eglDestroyContext(this.a, this.b);
            EGL14.eglReleaseThread();
            EGL14.eglTerminate(this.a);
        }
        this.a = EGL14.EGL_NO_DISPLAY;
        this.b = EGL14.EGL_NO_CONTEXT;
        this.c = null;
    }

    public void f(EGLSurface eGLSurface) {
        EGL14.eglDestroySurface(this.a, eGLSurface);
    }

    public void finalize() {
        try {
            if (this.a != EGL14.EGL_NO_DISPLAY) {
                Log.w("EGLCore", "WARNING: EglCore was not explicitly released -- state may be leaked");
                e();
            }
        } finally {
            super.finalize();
        }
    }

    public boolean g(EGLSurface eGLSurface) {
        return EGL14.eglSwapBuffers(this.a, eGLSurface);
    }
}
