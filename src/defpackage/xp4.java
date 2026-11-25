package defpackage;

import android.graphics.SurfaceTexture;
import android.view.Surface;

/* loaded from: /tmp/classes2.dex */
public class xp4 extends ms0 {
    public Surface e;
    public boolean f;

    public xp4(cs0 cs0Var, SurfaceTexture surfaceTexture) {
        super(cs0Var);
        a(surfaceTexture);
    }

    public void e() {
        c();
        Surface surface = this.e;
        if (surface != null) {
            if (this.f) {
                surface.release();
            }
            this.e = null;
        }
    }
}
