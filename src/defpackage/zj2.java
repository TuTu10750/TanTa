package defpackage;

import android.content.ActivityNotFoundException;
import android.content.ClipData;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import androidx.core.content.FileProvider;
import androidx.fragment.app.FragmentActivity;
import com.tencent.imsdk.v2.V2TIMGroupMemberFullInfo;
import com.yalantis.ucrop.a;
import java.io.File;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public abstract class zj2 {

    /* loaded from: /tmp/classes2.dex */
    public class a extends vx2 {
        public final /* synthetic */ FragmentActivity a;
        public final /* synthetic */ an1 b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ int d;
        public final /* synthetic */ int e;

        /* renamed from: zj2$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0172a extends s4 {
            public final /* synthetic */ Uri a;
            public final /* synthetic */ File b;

            public C0172a(Uri uri, File file) {
                this.a = uri;
                this.b = file;
            }

            @Override // defpackage.s4
            public void a() {
                t54.a(m93.N2);
                an1 an1Var = a.this.b;
                if (an1Var != null) {
                    an1Var.b();
                }
            }

            @Override // defpackage.s4
            public void c(Intent intent) {
                a aVar = a.this;
                if (aVar.c) {
                    zj2.g(aVar.a, this.a, aVar.d, aVar.e, aVar.b);
                    return;
                }
                an1 an1Var = aVar.b;
                if (an1Var != null) {
                    an1Var.a(this.b);
                }
            }
        }

        public a(FragmentActivity fragmentActivity, an1 an1Var, boolean z, int i, int i2) {
            this.a = fragmentActivity;
            this.b = an1Var;
            this.c = z;
            this.d = i;
            this.e = i2;
        }

        @Override // defpackage.vx2
        public void a() {
            FragmentActivity fragmentActivity = this.a;
            if (fragmentActivity == null || fragmentActivity.isFinishing()) {
                zj2.w(this.b);
                return;
            }
            if (o60.a(this.a, "android.permission.CAMERA") != 0) {
                t54.b(aq4.b(m93.a9, aq4.a(m93.V8)));
                zj2.w(this.b);
                return;
            }
            an1 an1Var = this.b;
            if (an1Var != null) {
                an1Var.c();
            }
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            File b = zj2.b();
            Uri h = FileProvider.h(this.a, zj2.c(), b);
            intent.putExtra("output", h);
            intent.addFlags(3);
            intent.setClipData(ClipData.newUri(this.a.getContentResolver(), "camera_output", h));
            zj2.v(this.a, intent, h);
            try {
                b5.a(this.a, intent, new C0172a(h, b));
            } catch (ActivityNotFoundException | SecurityException unused) {
                t54.a(m93.za);
                zj2.w(this.b);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends vx2 {
        public final /* synthetic */ FragmentActivity a;
        public final /* synthetic */ boolean b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ an1 e;

        /* loaded from: /tmp/classes2.dex */
        public class a extends s4 {
            public a() {
            }

            @Override // defpackage.s4
            public void a() {
                t54.a(m93.M2);
                an1 an1Var = b.this.e;
                if (an1Var != null) {
                    an1Var.b();
                }
            }

            /* JADX WARN: Code restructure failed: missing block: B:48:0x008c, code lost:
            
                if (r9 != 0) goto L25;
             */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v19 */
            /* JADX WARN: Type inference failed for: r0v5 */
            /* JADX WARN: Type inference failed for: r0v7 */
            /* JADX WARN: Type inference failed for: r0v8, types: [java.io.FileOutputStream] */
            /* JADX WARN: Type inference failed for: r1v5, types: [android.content.ContentResolver] */
            /* JADX WARN: Type inference failed for: r9v1, types: [android.net.Uri] */
            /* JADX WARN: Type inference failed for: r9v10, types: [java.io.InputStream] */
            /* JADX WARN: Type inference failed for: r9v3 */
            /* JADX WARN: Type inference failed for: r9v5 */
            /* JADX WARN: Type inference failed for: r9v6, types: [java.io.InputStream] */
            /* JADX WARN: Type inference failed for: r9v8 */
            /* JADX WARN: Type inference failed for: r9v9, types: [java.io.InputStream] */
            @Override // defpackage.s4
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void c(android.content.Intent r9) {
                /*
                    r8 = this;
                    android.net.Uri r9 = r9.getData()
                    if (r9 == 0) goto Lcf
                    java.lang.String r0 = r9.toString()
                    java.io.File r1 = new java.io.File
                    java.lang.String r2 = defpackage.j30.M
                    r1.<init>(r2)
                    boolean r2 = r1.exists()
                    if (r2 != 0) goto L1a
                    r1.mkdirs()
                L1a:
                    java.io.File r2 = new java.io.File
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r0 = defpackage.fa2.a(r0)
                    r3.append(r0)
                    java.lang.String r0 = ".png"
                    r3.append(r0)
                    java.lang.String r0 = r3.toString()
                    r2.<init>(r1, r0)
                    boolean r0 = r2.exists()
                    r3 = 0
                    if (r0 == 0) goto L44
                    long r0 = r2.length()
                    int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
                    if (r0 > 0) goto L8f
                L44:
                    r0 = 0
                    zj2$b r1 = zj2.b.this     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L80
                    androidx.fragment.app.FragmentActivity r1 = r1.a     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L80
                    android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L80
                    java.io.InputStream r9 = r1.openInputStream(r9)     // Catch: java.lang.Throwable -> L7d java.lang.Exception -> L80
                    java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
                    r1.<init>(r2)     // Catch: java.lang.Throwable -> L76 java.lang.Exception -> L78
                    r0 = 4096(0x1000, float:5.74E-42)
                    byte[] r0 = new byte[r0]     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L68
                L5a:
                    int r5 = r9.read(r0)     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L68
                    if (r5 <= 0) goto L6a
                    r6 = 0
                    r1.write(r0, r6, r5)     // Catch: java.lang.Throwable -> L65 java.lang.Exception -> L68
                    goto L5a
                L65:
                    r8 = move-exception
                    r0 = r1
                    goto Lbd
                L68:
                    r0 = move-exception
                    goto L84
                L6a:
                    r1.close()     // Catch: java.io.IOException -> L71
                L6d:
                    r9.close()     // Catch: java.io.IOException -> L71
                    goto L8f
                L71:
                    r9 = move-exception
                    r9.printStackTrace()
                    goto L8f
                L76:
                    r8 = move-exception
                    goto Lbd
                L78:
                    r1 = move-exception
                    r7 = r1
                    r1 = r0
                    r0 = r7
                    goto L84
                L7d:
                    r8 = move-exception
                    r9 = r0
                    goto Lbd
                L80:
                    r9 = move-exception
                    r1 = r0
                    r0 = r9
                    r9 = r1
                L84:
                    r0.printStackTrace()     // Catch: java.lang.Throwable -> L65
                    if (r1 == 0) goto L8c
                    r1.close()     // Catch: java.io.IOException -> L71
                L8c:
                    if (r9 == 0) goto L8f
                    goto L6d
                L8f:
                    boolean r9 = r2.exists()
                    if (r9 == 0) goto Lcf
                    long r0 = r2.length()
                    int r9 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
                    if (r9 <= 0) goto Lcf
                    zj2$b r9 = zj2.b.this
                    boolean r0 = r9.b
                    if (r0 == 0) goto Lb5
                    androidx.fragment.app.FragmentActivity r9 = r9.a
                    android.net.Uri r0 = android.net.Uri.fromFile(r2)
                    zj2$b r8 = zj2.b.this
                    int r1 = r8.c
                    int r2 = r8.d
                    an1 r8 = r8.e
                    defpackage.zj2.e(r9, r0, r1, r2, r8)
                    goto Lcf
                Lb5:
                    an1 r8 = r9.e
                    if (r8 == 0) goto Lcf
                    r8.a(r2)
                    goto Lcf
                Lbd:
                    if (r0 == 0) goto Lc5
                    r0.close()     // Catch: java.io.IOException -> Lc3
                    goto Lc5
                Lc3:
                    r9 = move-exception
                    goto Lcb
                Lc5:
                    if (r9 == 0) goto Lce
                    r9.close()     // Catch: java.io.IOException -> Lc3
                    goto Lce
                Lcb:
                    r9.printStackTrace()
                Lce:
                    throw r8
                Lcf:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: zj2.b.a.c(android.content.Intent):void");
            }
        }

        public b(FragmentActivity fragmentActivity, boolean z, int i, int i2, an1 an1Var) {
            this.a = fragmentActivity;
            this.b = z;
            this.c = i;
            this.d = i2;
            this.e = an1Var;
        }

        @Override // defpackage.vx2
        public void a() {
            Intent intent = new Intent();
            intent.addCategory("android.intent.category.OPENABLE");
            intent.setType("image/*");
            intent.setAction("android.intent.action.OPEN_DOCUMENT");
            b5.a(this.a, intent, new a());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends vx2 {
        public final /* synthetic */ FragmentActivity a;
        public final /* synthetic */ wi4 b;

        /* loaded from: /tmp/classes2.dex */
        public class a extends s4 {
            public final /* synthetic */ File a;

            public a(File file) {
                this.a = file;
            }

            @Override // defpackage.s4
            public void a() {
                t54.a(m93.w9);
            }

            /* JADX WARN: Code restructure failed: missing block: B:28:0x005c, code lost:
            
                if (r1 == null) goto L33;
             */
            /* JADX WARN: Removed duplicated region for block: B:33:0x0072  */
            @Override // defpackage.s4
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public void c(android.content.Intent r7) {
                /*
                    r6 = this;
                    if (r7 == 0) goto L76
                    android.net.Uri r7 = r7.getData()
                    if (r7 == 0) goto L76
                    zj2$c r7 = zj2.c.this
                    wi4 r7 = r7.b
                    if (r7 == 0) goto L76
                    java.io.File r7 = r6.a
                    if (r7 == 0) goto L76
                    boolean r7 = r7.exists()
                    if (r7 == 0) goto L76
                    java.io.File r7 = r6.a
                    long r0 = r7.length()
                    r2 = 0
                    int r7 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                    if (r7 <= 0) goto L76
                    java.io.File r7 = r6.a
                    java.lang.String r7 = r7.getAbsolutePath()
                    r0 = 0
                    android.media.MediaMetadataRetriever r1 = new android.media.MediaMetadataRetriever     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
                    r1.<init>()     // Catch: java.lang.Throwable -> L53 java.lang.Exception -> L55
                    r1.setDataSource(r7)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4d
                    r0 = 9
                    java.lang.String r0 = r1.extractMetadata(r0)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4d
                    boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4d
                    if (r4 != 0) goto L4f
                    boolean r4 = defpackage.rv3.g(r0)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4d
                    if (r4 == 0) goto L4f
                    long r2 = java.lang.Long.parseLong(r0)     // Catch: java.lang.Throwable -> L4a java.lang.Exception -> L4d
                    goto L4f
                L4a:
                    r6 = move-exception
                    r0 = r1
                    goto L70
                L4d:
                    r0 = move-exception
                    goto L59
                L4f:
                    r1.release()
                    goto L5f
                L53:
                    r6 = move-exception
                    goto L70
                L55:
                    r1 = move-exception
                    r5 = r1
                    r1 = r0
                    r0 = r5
                L59:
                    r0.printStackTrace()     // Catch: java.lang.Throwable -> L4a
                    if (r1 == 0) goto L5f
                    goto L4f
                L5f:
                    zj2$c r0 = zj2.c.this
                    androidx.fragment.app.FragmentActivity r0 = r0.a
                    defpackage.zj2.x(r0, r7, r2)
                    zj2$c r7 = zj2.c.this
                    wi4 r7 = r7.b
                    java.io.File r6 = r6.a
                    r7.a(r6, r2)
                    return
                L70:
                    if (r0 == 0) goto L75
                    r0.release()
                L75:
                    throw r6
                L76:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: zj2.c.a.c(android.content.Intent):void");
            }
        }

        public c(FragmentActivity fragmentActivity, wi4 wi4Var) {
            this.a = fragmentActivity;
            this.b = wi4Var;
        }

        @Override // defpackage.vx2
        public void a() {
            Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
            File f = zj2.f();
            intent.putExtra("output", FileProvider.h(this.a, zj2.c(), f));
            intent.putExtra("android.intent.extra.durationLimit", 15);
            b5.a(this.a, intent, new a(f));
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends s4 {
        public final /* synthetic */ an1 a;
        public final /* synthetic */ File b;

        public d(an1 an1Var, File file) {
            this.a = an1Var;
            this.b = file;
        }

        @Override // defpackage.s4
        public void a() {
            t54.a(m93.O2);
            an1 an1Var = this.a;
            if (an1Var != null) {
                an1Var.b();
            }
        }

        @Override // defpackage.s4
        public void c(Intent intent) {
            an1 an1Var = this.a;
            if (an1Var != null) {
                an1Var.a(this.b);
            }
        }
    }

    public static /* synthetic */ File b() {
        return o();
    }

    public static /* synthetic */ String c() {
        return h();
    }

    public static /* synthetic */ File f() {
        return p();
    }

    public static void g(FragmentActivity fragmentActivity, Uri uri, int i, int i2, an1 an1Var) {
        File o = o();
        try {
            int b2 = o60.b(fragmentActivity, p53.f);
            a.C0029a c0029a = new a.C0029a();
            c0029a.e(b2);
            c0029a.f(-1);
            c0029a.d(b2);
            c0029a.c(100);
            c0029a.b(b2);
            b5.a(fragmentActivity, com.yalantis.ucrop.a.b(uri, Uri.fromFile(o)).c(i, i2).d(V2TIMGroupMemberFullInfo.V2TIM_GROUP_MEMBER_ROLE_OWNER, V2TIMGroupMemberFullInfo.V2TIM_GROUP_MEMBER_ROLE_OWNER).e(c0029a).a(fragmentActivity), new d(an1Var, o));
        } catch (Exception e) {
            e.printStackTrace();
            if (an1Var != null) {
                an1Var.b();
            }
            t54.a(m93.P2);
        }
    }

    public static String h() {
        return j30.y + ".fileprovider";
    }

    public static void i(FragmentActivity fragmentActivity, an1 an1Var) {
        k(fragmentActivity, true, an1Var);
    }

    public static void j(FragmentActivity fragmentActivity, boolean z, int i, int i2, an1 an1Var) {
        yx2.a(fragmentActivity, new b(fragmentActivity, z, i, i2, an1Var), t());
    }

    public static void k(FragmentActivity fragmentActivity, boolean z, an1 an1Var) {
        j(fragmentActivity, z, V2TIMGroupMemberFullInfo.V2TIM_GROUP_MEMBER_ROLE_OWNER, V2TIMGroupMemberFullInfo.V2TIM_GROUP_MEMBER_ROLE_OWNER, an1Var);
    }

    public static void l(FragmentActivity fragmentActivity, an1 an1Var) {
        n(fragmentActivity, true, an1Var);
    }

    public static void m(FragmentActivity fragmentActivity, boolean z, int i, int i2, an1 an1Var) {
        yx2.a(fragmentActivity, new a(fragmentActivity, an1Var, z, i, i2), q());
    }

    public static void n(FragmentActivity fragmentActivity, boolean z, an1 an1Var) {
        m(fragmentActivity, z, 1, 1, an1Var);
    }

    public static File o() {
        File file = new File(j30.M);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, da0.a() + ".png");
    }

    public static File p() {
        File file = new File(j30.I);
        if (!file.exists()) {
            file.mkdirs();
        }
        return new File(file, da0.a() + ".mp4");
    }

    public static String[] q() {
        String[] t = t();
        String[] strArr = new String[t.length + 1];
        System.arraycopy(t, 0, strArr, 0, t.length);
        strArr[t.length] = "android.permission.CAMERA";
        return strArr;
    }

    public static String[] r() {
        return q();
    }

    public static String[] s() {
        String[] t = t();
        String[] strArr = new String[t.length + 2];
        System.arraycopy(t, 0, strArr, 0, t.length);
        strArr[t.length] = "android.permission.CAMERA";
        strArr[t.length + 1] = "android.permission.RECORD_AUDIO";
        return strArr;
    }

    public static String[] t() {
        return Build.VERSION.SDK_INT >= 33 ? new String[]{"android.permission.READ_MEDIA_IMAGES", "android.permission.READ_MEDIA_VIDEO"} : new String[]{"android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
    }

    public static String[] u() {
        return t();
    }

    public static void v(FragmentActivity fragmentActivity, Intent intent, Uri uri) {
        List<ResolveInfo> queryIntentActivities;
        ActivityInfo activityInfo;
        String str;
        if (fragmentActivity == null || intent == null || uri == null || (queryIntentActivities = fragmentActivity.getPackageManager().queryIntentActivities(intent, 65536)) == null) {
            return;
        }
        for (ResolveInfo resolveInfo : queryIntentActivities) {
            if (resolveInfo != null && (activityInfo = resolveInfo.activityInfo) != null && (str = activityInfo.packageName) != null) {
                fragmentActivity.grantUriPermission(str, uri, 3);
            }
        }
    }

    public static void w(an1 an1Var) {
        if (an1Var != null) {
            an1Var.b();
        }
    }

    public static void x(Context context, String str, long j) {
        if (Build.VERSION.SDK_INT < 29) {
            try {
                File file = new File(str);
                String name = file.getName();
                long currentTimeMillis = System.currentTimeMillis();
                ContentValues contentValues = new ContentValues();
                contentValues.put("title", name);
                contentValues.put("_display_name", name);
                contentValues.put("date_modified", Long.valueOf(currentTimeMillis));
                contentValues.put("date_added", Long.valueOf(currentTimeMillis));
                contentValues.put("_data", str);
                contentValues.put("_size", Long.valueOf(file.length()));
                contentValues.put("datetaken", Long.valueOf(currentTimeMillis));
                contentValues.put("mime_type", "video/mp4");
                contentValues.put("duration", Long.valueOf(j));
                context.getContentResolver().insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void y(FragmentActivity fragmentActivity, wi4 wi4Var) {
        c cVar = new c(fragmentActivity, wi4Var);
        String[] t = t();
        String[] strArr = new String[t.length + 2];
        System.arraycopy(t, 0, strArr, 0, t.length);
        strArr[t.length] = "android.permission.CAMERA";
        strArr[t.length + 1] = "android.permission.RECORD_AUDIO";
        yx2.a(fragmentActivity, cVar, strArr);
    }
}
