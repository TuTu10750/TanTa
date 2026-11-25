package defpackage;

import android.content.Context;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /tmp/classes2.dex */
public final class h20 implements q74 {
    public static final a e = new a(null);
    public final Context a;
    public final float b;
    public final float c;
    public final String d;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public h20(Context context, float f, float f2) {
        context.getClass();
        this.a = context;
        this.b = f;
        this.c = f2;
        double d = f;
        if (0.0d > d || d > 25.0d) {
            ik.a("radius must be in [0, 25].");
            throw null;
        }
        if (f2 <= 0.0f) {
            ik.a("sampling must be > 0.");
            throw null;
        }
        this.d = h20.class.getName() + '-' + f + '-' + f2;
    }

    public /* synthetic */ h20(Context context, float f, float f2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? 20.0f : f, (i & 4) != 0 ? 1.0f : f2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0098  */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v6, types: [android.renderscript.BaseObj, android.renderscript.ScriptIntrinsicBlur] */
    /* JADX WARN: Type inference failed for: r6v7 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object a(android.graphics.Bitmap r6, lq3 r7, defpackage.u60 r8) {
        /*
            r5 = this;
            android.graphics.Paint r7 = new android.graphics.Paint
            r8 = 3
            r7.<init>(r8)
            int r8 = r6.getWidth()
            float r8 = (float) r8
            float r0 = r5.c
            float r8 = r8 / r0
            int r8 = (int) r8
            int r0 = r6.getHeight()
            float r0 = (float) r0
            float r1 = r5.c
            float r0 = r0 / r1
            int r0 = (int) r0
            android.graphics.Bitmap$Config r1 = r6.getConfig()
            if (r1 != 0) goto L20
            android.graphics.Bitmap$Config r1 = android.graphics.Bitmap.Config.ARGB_8888
        L20:
            android.graphics.Bitmap r8 = android.graphics.Bitmap.createBitmap(r8, r0, r1)
            r8.getClass()
            android.graphics.Canvas r0 = new android.graphics.Canvas
            r0.<init>(r8)
            float r1 = r5.c
            r2 = 1065353216(0x3f800000, float:1.0)
            float r3 = r2 / r1
            float r2 = r2 / r1
            r0.scale(r3, r2)
            r1 = 0
            r0.drawBitmap(r6, r1, r1, r7)
            r6 = 0
            android.content.Context r7 = r5.a     // Catch: java.lang.Throwable -> L83
            android.renderscript.RenderScript r7 = android.renderscript.RenderScript.create(r7)     // Catch: java.lang.Throwable -> L83
            android.renderscript.Allocation$MipmapControl r0 = android.renderscript.Allocation.MipmapControl.MIPMAP_NONE     // Catch: java.lang.Throwable -> L7f
            r1 = 1
            android.renderscript.Allocation r0 = android.renderscript.Allocation.createFromBitmap(r7, r8, r0, r1)     // Catch: java.lang.Throwable -> L7f
            android.renderscript.Type r1 = r0.getType()     // Catch: java.lang.Throwable -> L7a
            android.renderscript.Allocation r1 = android.renderscript.Allocation.createTyped(r7, r1)     // Catch: java.lang.Throwable -> L7a
            android.renderscript.Element r2 = android.renderscript.Element.U8_4(r7)     // Catch: java.lang.Throwable -> L75
            android.renderscript.ScriptIntrinsicBlur r6 = android.renderscript.ScriptIntrinsicBlur.create(r7, r2)     // Catch: java.lang.Throwable -> L75
            float r5 = r5.b     // Catch: java.lang.Throwable -> L75
            r6.setRadius(r5)     // Catch: java.lang.Throwable -> L75
            r6.setInput(r0)     // Catch: java.lang.Throwable -> L75
            r6.forEach(r1)     // Catch: java.lang.Throwable -> L75
            r1.copyTo(r8)     // Catch: java.lang.Throwable -> L75
            if (r7 == 0) goto L6b
            r7.destroy()
        L6b:
            r0.destroy()
            r1.destroy()
            r6.destroy()
            return r8
        L75:
            r5 = move-exception
            r4 = r7
            r7 = r6
            r6 = r4
            goto L87
        L7a:
            r5 = move-exception
            r1 = r6
        L7c:
            r6 = r7
            r7 = r1
            goto L87
        L7f:
            r5 = move-exception
            r0 = r6
            r1 = r0
            goto L7c
        L83:
            r5 = move-exception
            r7 = r6
            r0 = r7
            r1 = r0
        L87:
            if (r6 == 0) goto L8c
            r6.destroy()
        L8c:
            if (r0 == 0) goto L91
            r0.destroy()
        L91:
            if (r1 == 0) goto L96
            r1.destroy()
        L96:
            if (r7 == 0) goto L9b
            r7.destroy()
        L9b:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.h20.a(android.graphics.Bitmap, lq3, u60):java.lang.Object");
    }

    public String b() {
        return this.d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h20)) {
            return false;
        }
        h20 h20Var = (h20) obj;
        return dq1.a(this.a, h20Var.a) && this.b == h20Var.b && this.c == h20Var.c;
    }

    public int hashCode() {
        return (((this.a.hashCode() * 31) + Float.hashCode(this.b)) * 31) + Float.hashCode(this.c);
    }

    public String toString() {
        return "CoilBlurTransformation(context=" + this.a + ", radius=" + this.b + ", sampling=" + this.c + ')';
    }
}
