package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.l;
import com.yunbao.common.utils.a;
import com.yunbao.im.bean.ImMessageBean;
import com.yunbao.im.custom.MyImageView2;
import java.io.File;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class qy extends RecyclerView.Adapter {
    public Context d;
    public List e;
    public LayoutInflater f;
    public View.OnClickListener g = new a();
    public View.OnLongClickListener h = new b();
    public c i;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j10.a() && qy.this.i != null) {
                qy.this.i.a();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnLongClickListener {

        /* loaded from: /tmp/classes2.dex */
        public class a extends k30 {

            /* renamed from: qy$b$a$a, reason: collision with other inner class name */
            /* loaded from: /tmp/classes2.dex */
            public class C0151a implements a.n {
                public final /* synthetic */ File a;

                public C0151a(File file) {
                    this.a = file;
                }

                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Removed duplicated region for block: B:37:0x00c5 A[Catch: IOException -> 0x00c1, TRY_LEAVE, TryCatch #3 {IOException -> 0x00c1, blocks: (B:44:0x00bd, B:37:0x00c5), top: B:43:0x00bd }] */
                /* JADX WARN: Removed duplicated region for block: B:43:0x00bd A[EXC_TOP_SPLITTER, SYNTHETIC] */
                /* JADX WARN: Type inference failed for: r1v3 */
                /* JADX WARN: Type inference failed for: r1v5, types: [java.io.FileInputStream] */
                /* JADX WARN: Type inference failed for: r1v8 */
                @Override // com.yunbao.common.utils.a.n
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void a(java.lang.String r5, int r6) {
                    /*
                        r4 = this;
                        long r5 = android.os.SystemClock.uptimeMillis()
                        java.lang.StringBuilder r0 = new java.lang.StringBuilder
                        r0.<init>()
                        java.lang.String r1 = defpackage.rv3.b()
                        r0.append(r1)
                        java.lang.String r1 = ".png"
                        r0.append(r1)
                        java.lang.String r0 = r0.toString()
                        android.content.ContentValues r1 = new android.content.ContentValues
                        r1.<init>()
                        java.lang.String r2 = "_display_name"
                        r1.put(r2, r0)
                        java.lang.String r2 = "mime_type"
                        java.lang.String r3 = "image/png"
                        r1.put(r2, r3)
                        java.lang.String r2 = "title"
                        r1.put(r2, r0)
                        java.lang.String r2 = "date_modified"
                        java.lang.Long r3 = java.lang.Long.valueOf(r5)
                        r1.put(r2, r3)
                        java.lang.String r2 = "date_added"
                        java.lang.Long r5 = java.lang.Long.valueOf(r5)
                        r1.put(r2, r5)
                        int r5 = android.os.Build.VERSION.SDK_INT
                        r6 = 29
                        if (r5 < r6) goto L4f
                        java.lang.String r5 = "relative_path"
                        java.lang.String r6 = android.os.Environment.DIRECTORY_DCIM
                        r1.put(r5, r6)
                        goto L65
                    L4f:
                        java.lang.StringBuilder r5 = new java.lang.StringBuilder
                        r5.<init>()
                        java.lang.String r6 = defpackage.j30.N
                        r5.append(r6)
                        r5.append(r0)
                        java.lang.String r5 = r5.toString()
                        java.lang.String r6 = "_data"
                        r1.put(r6, r5)
                    L65:
                        com.yunbao.common.CommonAppContext r5 = com.yunbao.common.CommonAppContext.n()
                        android.content.ContentResolver r5 = r5.getContentResolver()
                        android.net.Uri r6 = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI
                        android.net.Uri r6 = r5.insert(r6, r1)
                        if (r6 != 0) goto L76
                        goto Lba
                    L76:
                        r0 = 0
                        java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> La8 java.lang.Exception -> Lab
                        java.io.File r4 = r4.a     // Catch: java.lang.Throwable -> La8 java.lang.Exception -> Lab
                        r1.<init>(r4)     // Catch: java.lang.Throwable -> La8 java.lang.Exception -> Lab
                        java.io.OutputStream r0 = r5.openOutputStream(r6)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
                        r4 = 4096(0x1000, float:5.74E-42)
                        byte[] r4 = new byte[r4]     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
                    L86:
                        int r5 = r1.read(r4)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
                        if (r5 <= 0) goto L95
                        r6 = 0
                        r0.write(r4, r6, r5)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
                        goto L86
                    L91:
                        r4 = move-exception
                        goto Lbb
                    L93:
                        r4 = move-exception
                        goto Lad
                    L95:
                        int r4 = defpackage.m93.U9     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
                        defpackage.t54.a(r4)     // Catch: java.lang.Throwable -> L91 java.lang.Exception -> L93
                        if (r0 == 0) goto L9f
                        r0.close()     // Catch: java.io.IOException -> La3
                    L9f:
                        r1.close()     // Catch: java.io.IOException -> La3
                        return
                    La3:
                        r4 = move-exception
                        r4.printStackTrace()
                        goto Lba
                    La8:
                        r4 = move-exception
                        r1 = r0
                        goto Lbb
                    Lab:
                        r4 = move-exception
                        r1 = r0
                    Lad:
                        r4.printStackTrace()     // Catch: java.lang.Throwable -> L91
                        if (r0 == 0) goto Lb5
                        r0.close()     // Catch: java.io.IOException -> La3
                    Lb5:
                        if (r1 == 0) goto Lba
                        r1.close()     // Catch: java.io.IOException -> La3
                    Lba:
                        return
                    Lbb:
                        if (r0 == 0) goto Lc3
                        r0.close()     // Catch: java.io.IOException -> Lc1
                        goto Lc3
                    Lc1:
                        r5 = move-exception
                        goto Lc9
                    Lc3:
                        if (r1 == 0) goto Lcc
                        r1.close()     // Catch: java.io.IOException -> Lc1
                        goto Lcc
                    Lc9:
                        r5.printStackTrace()
                    Lcc:
                        throw r4
                    */
                    throw new UnsupportedOperationException("Method not decompiled: qy.b.a.C0151a.a(java.lang.String, int):void");
                }
            }

            public a() {
            }

            @Override // defpackage.k30
            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public void a(File file) {
                com.yunbao.common.utils.a.r(qy.this.d, new Integer[]{Integer.valueOf(m93.T9)}, new C0151a(file));
            }
        }

        public b() {
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            ck1.e().d((ImMessageBean) view.getTag(m93.d), false, new a());
            return true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface c {
        void a();
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends RecyclerView.e0 {
        public MyImageView2 u;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v1, types: [com.yunbao.im.custom.MyImageView2, android.view.View] */
        public d(View view) {
            super(view);
            ?? r3 = (MyImageView2) view;
            this.u = r3;
            r3.setOnClickListener(qy.this.g);
            this.u.setOnLongClickListener(qy.this.h);
        }

        public void O(ImMessageBean imMessageBean) {
            this.u.setTag(m93.d, imMessageBean);
            ImMessageBean.ImageMsgBean imageBean = imMessageBean.getImageBean();
            if (imageBean != null) {
                String localPath = imageBean.getLocalPath();
                boolean isEmpty = TextUtils.isEmpty(localPath);
                qy qyVar = qy.this;
                if (isEmpty) {
                    kn1.f(qyVar.d, imageBean.getOriginImageUrl(), this.u);
                } else {
                    kn1.e(qyVar.d, new File(localPath), this.u);
                }
            }
        }
    }

    public qy(Context context, List list) {
        this.d = context;
        this.e = list;
        this.f = LayoutInflater.from(context);
    }

    /* renamed from: P, reason: merged with bridge method [inline-methods] */
    public void z(d dVar, int i) {
        dVar.O((ImMessageBean) this.e.get(i));
    }

    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public d B(ViewGroup viewGroup, int i) {
        return new d(this.f.inflate(w73.q, viewGroup, false));
    }

    public void R(c cVar) {
        this.i = cVar;
    }

    public int j() {
        return this.e.size();
    }

    public void y(RecyclerView recyclerView) {
        new l().b(recyclerView);
    }
}
