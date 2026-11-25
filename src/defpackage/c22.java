package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.LruCache;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.beauty.bean.LiveFilterBean;
import java.io.InputStream;
import java.util.List;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: /tmp/classes2.dex */
public class c22 extends RecyclerView.Adapter {
    public final Context d;
    public final List e;
    public Bitmap g;
    public b i;
    public final LruCache f = new LruCache(32);
    public int h = 0;

    /* loaded from: /tmp/classes2.dex */
    public static class a extends RecyclerView.e0 {
        public LinearLayout u;
        public FrameLayout v;
        public ImageView w;
        public TextView x;

        public a(View view) {
            super(view);
            this.u = (LinearLayout) view.findViewById(x63.n);
            this.v = (FrameLayout) view.findViewById(x63.m);
            this.w = (ImageView) view.findViewById(x63.k);
            this.x = (TextView) view.findViewById(x63.l);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface b {
        void a(int i, LiveFilterBean liveFilterBean);
    }

    public c22(Context context, List list) {
        this.d = context;
        this.e = list;
    }

    public static /* synthetic */ void L(c22 c22Var, int i, LiveFilterBean liveFilterBean, View view) {
        int i2 = c22Var.h;
        if (i2 == i) {
            return;
        }
        c22Var.h = i;
        c22Var.q(i2);
        c22Var.q(c22Var.h);
        b bVar = c22Var.i;
        if (bVar != null) {
            bVar.a(i, liveFilterBean);
        }
    }

    public static Bitmap M(Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap2.getWidth() != 512 || bitmap2.getHeight() != 512) {
            return bitmap;
        }
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        int i = width * height;
        int[] iArr = new int[i];
        int[] iArr2 = new int[262144];
        bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
        bitmap2.getPixels(iArr2, 0, IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED, 0, 0, IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED, IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED);
        int[] iArr3 = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = iArr[i2];
            int i4 = (i3 >>> 24) & 255;
            int i5 = (i3 >>> 16) & 255;
            int i6 = (i3 >>> 8) & 255;
            int i7 = (((i3 & 255) * 63) + 127) / 255;
            int i8 = i7 & 7;
            iArr3[i2] = (iArr2[((((i7 >> 3) * 64) + (((i6 * 63) + 127) / 255)) * IjkMediaMeta.FF_PROFILE_H264_CONSTRAINED) + (i8 * 64) + (((i5 * 63) + 127) / 255)] & 16777215) | (i4 << 24);
        }
        return Bitmap.createBitmap(iArr3, width, height, Bitmap.Config.ARGB_8888);
    }

    public final Bitmap N(String str) {
        try {
            InputStream open = this.d.getAssets().open(str);
            try {
                Bitmap decodeStream = BitmapFactory.decodeStream(open);
                if (open != null) {
                    open.close();
                }
                return decodeStream;
            } finally {
            }
        } catch (Exception unused) {
            return null;
        }
    }

    public final Bitmap O() {
        Bitmap bitmap = this.g;
        if (bitmap == null || bitmap.isRecycled()) {
            this.g = N("filter_reference.png");
        }
        return this.g;
    }

    public final Bitmap P(LiveFilterBean liveFilterBean) {
        String str = liveFilterBean.assetPath;
        if (str == null) {
            return O();
        }
        Bitmap bitmap = (Bitmap) this.f.get(str);
        if (bitmap != null) {
            return bitmap;
        }
        Bitmap O = O();
        Bitmap N = N(liveFilterBean.assetPath);
        if (O != null && N != null) {
            O = M(O, N);
            N.recycle();
            if (O != null) {
                this.f.put(liveFilterBean.assetPath, O);
            }
        }
        return O;
    }

    /* renamed from: Q, reason: merged with bridge method [inline-methods] */
    public void z(a aVar, final int i) {
        final LiveFilterBean liveFilterBean = (LiveFilterBean) this.e.get(i);
        aVar.x.setText(liveFilterBean.name);
        aVar.v.setBackgroundResource(i == this.h ? f63.a : 0);
        aVar.w.setImageBitmap(P(liveFilterBean));
        aVar.u.setOnClickListener(new View.OnClickListener() { // from class: b22
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c22.L(c22.this, i, liveFilterBean, view);
            }
        });
    }

    /* renamed from: R, reason: merged with bridge method [inline-methods] */
    public a B(ViewGroup viewGroup, int i) {
        return new a(LayoutInflater.from(this.d).inflate(n83.c, viewGroup, false));
    }

    public void S(b bVar) {
        this.i = bVar;
    }

    public int j() {
        List list = this.e;
        if (list == null) {
            return 0;
        }
        return list.size();
    }
}
