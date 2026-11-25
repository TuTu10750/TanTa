package defpackage;

import android.graphics.drawable.Drawable;
import defpackage.kn1;

/* loaded from: /tmp/classes2.dex */
public final class i20$a implements d24 {
    public final /* synthetic */ kn1.a a;
    public final /* synthetic */ kn1.a b;

    public i20$a(kn1.a aVar, kn1.a aVar2) {
        this.a = aVar;
        this.b = aVar2;
    }

    public void a(Drawable drawable) {
        kn1.a aVar = this.b;
        if (aVar != null) {
            aVar.onLoadSuccess(drawable);
        }
    }

    public void b(Drawable drawable) {
        kn1.a aVar = this.a;
        if (aVar != null) {
            aVar.onLoadFailed();
        }
    }

    public void c(Drawable drawable) {
    }
}
