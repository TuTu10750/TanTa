package defpackage;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.custom.NineGridLayout2;
import com.yunbao.common.custom.StarCountView;
import com.yunbao.mall.bean.GoodsCommentBean;
import defpackage.pm1;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class gd1 extends ce3 {
    public boolean i;
    public NineGridLayout2.b j;

    /* loaded from: /tmp/classes2.dex */
    public class a implements NineGridLayout2.b {

        /* renamed from: gd1$a$a, reason: collision with other inner class name */
        /* loaded from: /tmp/classes2.dex */
        public class C0069a implements pm1.c {
            public final /* synthetic */ List a;

            public C0069a(List list) {
                this.a = list;
            }

            @Override // pm1.c
            public void a(ImageView imageView, int i) {
                kn1.f(gd1.this.d, (String) this.a.get(i), imageView);
            }

            @Override // pm1.c
            public void b(int i) {
            }

            @Override // pm1.c
            public String c(int i) {
                return (String) this.a.get(i);
            }
        }

        /* loaded from: /tmp/classes2.dex */
        public class b implements pm1.c {
            public final /* synthetic */ List a;

            public b(List list) {
                this.a = list;
            }

            @Override // pm1.c
            public void a(ImageView imageView, int i) {
                kn1.f(gd1.this.d, (String) this.a.get(i + 1), imageView);
            }

            @Override // pm1.c
            public void b(int i) {
            }

            @Override // pm1.c
            public String c(int i) {
                return (String) this.a.get(i + 1);
            }
        }

        public a() {
        }

        @Override // com.yunbao.common.custom.NineGridLayout2.b
        public void a(Object obj, ImageView imageView) {
            kn1.f(gd1.this.d, (String) obj, imageView);
        }

        @Override // com.yunbao.common.custom.NineGridLayout2.b
        public void b(NineGridLayout2 nineGridLayout2, List list, int i) {
            String videoUrl = nineGridLayout2.getVideoUrl();
            if (TextUtils.isEmpty(videoUrl)) {
                pm1 pm1Var = new pm1();
                pm1Var.z2(list.size(), i, false, new C0069a(list));
                pm1Var.d2(((AbsActivity) gd1.this.d).getSupportFragmentManager(), "ImagePreviewDialog");
            } else {
                if (i == 0) {
                    pi3.s(gd1.this.d, videoUrl, (String) list.get(0));
                    return;
                }
                pm1 pm1Var2 = new pm1();
                pm1Var2.z2(list.size() - 1, i - 1, false, new b(list));
                pm1Var2.d2(((AbsActivity) gd1.this.d).getSupportFragmentManager(), "ImagePreviewDialog");
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends g {
        public TextView B;
        public TextView C;

        public b(View view) {
            super(view);
            this.B = (TextView) view.findViewById(d73.h);
            this.C = (TextView) view.findViewById(d73.g);
        }

        @Override // gd1.g
        public void O(GoodsCommentBean goodsCommentBean) {
            super.O(goodsCommentBean);
            GoodsCommentBean appendCommentBean = goodsCommentBean.getAppendCommentBean();
            if (appendCommentBean != null) {
                this.B.setText(appendCommentBean.getDateTip());
                this.C.setText(appendCommentBean.getContent());
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends b {
        public NineGridLayout2 E;

        public c(View view) {
            super(view);
            NineGridLayout2 nineGridLayout2 = (NineGridLayout2) view.findViewById(d73.T2);
            this.E = nineGridLayout2;
            nineGridLayout2.setActionListener(gd1.this.j);
        }

        @Override // gd1.b, gd1.g
        public void O(GoodsCommentBean goodsCommentBean) {
            List<String> imageList;
            super.O(goodsCommentBean);
            GoodsCommentBean appendCommentBean = goodsCommentBean.getAppendCommentBean();
            if (appendCommentBean == null || (imageList = appendCommentBean.getImageList()) == null || gd1.this.e.size() <= 0) {
                return;
            }
            this.E.g(imageList, appendCommentBean.getVideoUrl());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends g {
        public NineGridLayout2 B;

        public d(View view) {
            super(view);
            NineGridLayout2 nineGridLayout2 = (NineGridLayout2) view.findViewById(d73.S2);
            this.B = nineGridLayout2;
            nineGridLayout2.setActionListener(gd1.this.j);
        }

        @Override // gd1.g
        public void O(GoodsCommentBean goodsCommentBean) {
            super.O(goodsCommentBean);
            List<String> imageList = goodsCommentBean.getImageList();
            if (imageList == null || gd1.this.e.size() <= 0) {
                return;
            }
            this.B.g(imageList, goodsCommentBean.getVideoUrl());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends d {
        public TextView D;
        public TextView E;

        public e(View view) {
            super(view);
            this.D = (TextView) view.findViewById(d73.h);
            this.E = (TextView) view.findViewById(d73.g);
        }

        @Override // gd1.d, gd1.g
        public void O(GoodsCommentBean goodsCommentBean) {
            super.O(goodsCommentBean);
            GoodsCommentBean appendCommentBean = goodsCommentBean.getAppendCommentBean();
            if (appendCommentBean != null) {
                this.D.setText(appendCommentBean.getDateTip());
                this.E.setText(appendCommentBean.getContent());
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends e {
        public NineGridLayout2 G;

        public f(View view) {
            super(view);
            NineGridLayout2 nineGridLayout2 = (NineGridLayout2) view.findViewById(d73.T2);
            this.G = nineGridLayout2;
            nineGridLayout2.setActionListener(gd1.this.j);
        }

        @Override // gd1.e, gd1.d, gd1.g
        public void O(GoodsCommentBean goodsCommentBean) {
            List<String> imageList;
            super.O(goodsCommentBean);
            GoodsCommentBean appendCommentBean = goodsCommentBean.getAppendCommentBean();
            if (appendCommentBean == null || (imageList = appendCommentBean.getImageList()) == null || gd1.this.e.size() <= 0) {
                return;
            }
            this.G.g(imageList, appendCommentBean.getVideoUrl());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;
        public StarCountView w;
        public TextView x;
        public TextView y;
        public TextView z;

        public g(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(d73.l);
            this.v = (TextView) view.findViewById(d73.R2);
            this.w = (StarCountView) view.findViewById(d73.Z3);
            this.x = (TextView) view.findViewById(d73.B1);
            this.y = (TextView) view.findViewById(d73.N1);
            this.z = (TextView) view.findViewById(d73.d2);
        }

        public void O(GoodsCommentBean goodsCommentBean) {
            kn1.g(gd1.this.d, goodsCommentBean.getAvatar(), this.u);
            this.v.setText(goodsCommentBean.getBuyerName());
            this.w.setFillCount(goodsCommentBean.getStarCount());
            this.x.setText(goodsCommentBean.getContent());
            this.y.setText(goodsCommentBean.getDateTime());
            this.z.setText(goodsCommentBean.getGoodsSpecName());
        }
    }

    public gd1(Context context, List list, boolean z) {
        super(context, list);
        this.i = z;
        d0();
    }

    public gd1(Context context, boolean z) {
        super(context);
        this.i = z;
        d0();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return i == 2 ? new b(this.f.inflate(z73.F0, viewGroup, false)) : i == 3 ? new c(this.f.inflate(z73.G0, viewGroup, false)) : i == 4 ? new d(this.f.inflate(z73.H0, viewGroup, false)) : i == 5 ? new e(this.f.inflate(z73.I0, viewGroup, false)) : i == 6 ? new f(this.f.inflate(z73.J0, viewGroup, false)) : new g(this.f.inflate(z73.E0, viewGroup, false));
    }

    public final void d0() {
        this.j = new a();
    }

    public int l(int i) {
        GoodsCommentBean goodsCommentBean = (GoodsCommentBean) this.e.get(i);
        if (!this.i) {
            return goodsCommentBean.hasImgOrVideo() ? 4 : 0;
        }
        if (goodsCommentBean.getHasAppend() != 1) {
            return goodsCommentBean.hasImgOrVideo() ? 4 : 0;
        }
        GoodsCommentBean appendCommentBean = goodsCommentBean.getAppendCommentBean();
        return appendCommentBean != null ? goodsCommentBean.hasImgOrVideo() ? appendCommentBean.hasImgOrVideo() ? 6 : 5 : appendCommentBean.hasImgOrVideo() ? 3 : 2 : goodsCommentBean.hasImgOrVideo() ? 4 : 0;
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((g) e0Var).O((GoodsCommentBean) this.e.get(i));
    }
}
