package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.LevelBean;
import com.yunbao.common.bean.UserBean;
import com.yunbao.live.bean.LiveUserGiftBean;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class w52 extends RecyclerView.Adapter {
    public Context d;
    public LayoutInflater f;
    public et2 h;
    public Drawable i;
    public Drawable j;
    public List e = new ArrayList();
    public View.OnClickListener g = new a();

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null) {
                int intValue = ((Integer) tag).intValue();
                if (w52.this.h != null) {
                    w52.this.h.onItemClick((UserBean) w52.this.e.get(intValue), intValue);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView u;
        public ImageView v;
        public ImageView w;
        public ImageView x;

        public b(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(b73.r6);
            this.v = (ImageView) view.findViewById(b73.d);
            this.w = (ImageView) view.findViewById(b73.M2);
            this.x = (ImageView) view.findViewById(b73.K2);
            view.setOnClickListener(w52.this.g);
        }

        public void O(LiveUserGiftBean liveUserGiftBean, int i, Object obj) {
            ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
            if (obj == null) {
                kn1.g(w52.this.d, liveUserGiftBean.getAvatar(), this.v);
                LevelBean s = j30.q().s(liveUserGiftBean.getLevel());
                if (s != null) {
                    kn1.f(w52.this.d, s.getThumbIcon(), this.w);
                }
            }
            int guardType = liveUserGiftBean.getGuardType();
            ImageView imageView = this.w;
            if (guardType == 0) {
                if (imageView.getVisibility() != 0) {
                    this.w.setVisibility(0);
                }
                if (this.x.getVisibility() == 0) {
                    this.x.setVisibility(4);
                }
            } else {
                if (imageView.getVisibility() == 0) {
                    this.w.setVisibility(4);
                }
                if (this.x.getVisibility() != 0) {
                    this.x.setVisibility(0);
                }
                if (guardType == 1) {
                    this.x.setImageDrawable(w52.this.i);
                } else if (guardType == 2) {
                    this.x.setImageDrawable(w52.this.j);
                }
            }
            if (i == 0) {
                boolean hasContribution = liveUserGiftBean.hasContribution();
                ImageView imageView2 = this.u;
                if (hasContribution) {
                    imageView2.setImageResource(t83.K0);
                    return;
                } else {
                    imageView2.setImageDrawable(null);
                    return;
                }
            }
            if (i == 1) {
                boolean hasContribution2 = liveUserGiftBean.hasContribution();
                ImageView imageView3 = this.u;
                if (hasContribution2) {
                    imageView3.setImageResource(t83.L0);
                    return;
                } else {
                    imageView3.setImageDrawable(null);
                    return;
                }
            }
            if (i != 2) {
                this.u.setImageDrawable(null);
                return;
            }
            boolean hasContribution3 = liveUserGiftBean.hasContribution();
            ImageView imageView4 = this.u;
            if (hasContribution3) {
                imageView4.setImageResource(t83.M0);
            } else {
                imageView4.setImageDrawable(null);
            }
        }
    }

    public w52(Context context) {
        this.d = context;
        this.f = LayoutInflater.from(context);
        this.i = o60.d(context, t83.A);
        this.j = o60.d(context, t83.B);
    }

    public void R() {
        List list = this.e;
        if (list != null) {
            list.clear();
        }
        p();
    }

    /* renamed from: S, reason: merged with bridge method [inline-methods] */
    public void z(b bVar, int i) {
    }

    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public void A(b bVar, int i, List list) {
        bVar.O((LiveUserGiftBean) this.e.get(i), i, list.size() > 0 ? list.get(0) : null);
    }

    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public b B(ViewGroup viewGroup, int i) {
        return new b(this.f.inflate(x73.d1, viewGroup, false));
    }

    public void V(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int size = this.e.size();
        for (int i2 = 0; i2 < size; i2++) {
            LiveUserGiftBean liveUserGiftBean = (LiveUserGiftBean) this.e.get(i2);
            if (str.equals(liveUserGiftBean.getId())) {
                if (liveUserGiftBean.getGuardType() != i) {
                    liveUserGiftBean.setGuardType(i);
                    r(i2, "payload");
                    return;
                }
                return;
            }
        }
    }

    public void W(List list) {
        if (this.e == null || list == null || list.size() <= 0) {
            return;
        }
        this.e.clear();
        this.e.addAll(list);
        p();
    }

    public void X(et2 et2Var) {
        this.h = et2Var;
    }

    public int j() {
        return this.e.size();
    }
}
