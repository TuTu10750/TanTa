package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.LiveGiftBean;
import com.yunbao.common.custom.MyRadioButton;
import com.yunbao.live.bean.BackPackGiftBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class j22 extends RecyclerView.Adapter {
    public Context d;
    public List e;
    public LayoutInflater f;
    public String g;
    public b i;
    public ScaleAnimation k;
    public View l;
    public String m;
    public int n;
    public Drawable o;
    public Drawable p;
    public Drawable q;
    public Drawable r;
    public Drawable s;
    public Drawable t;
    public int j = -1;
    public View.OnClickListener h = new a();

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null) {
                int intValue = ((Integer) tag).intValue();
                LiveGiftBean liveGiftBean = (LiveGiftBean) j22.this.e.get(intValue);
                if (liveGiftBean.isChecked()) {
                    return;
                }
                if (!j22.this.b0() && j22.this.i != null) {
                    j22.this.i.onCancel();
                }
                liveGiftBean.setChecked(true);
                j22.this.r(intValue, "payload");
                View view2 = liveGiftBean.getView();
                if (view2 != null) {
                    view2.startAnimation(j22.this.k);
                    j22.this.l = view2;
                }
                j22.this.j = intValue;
                if (j22.this.i != null) {
                    j22.this.i.c(liveGiftBean);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface b {
        void c(LiveGiftBean liveGiftBean);

        void onCancel();
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends RecyclerView.e0 {
        public ImageView u;
        public TextView v;
        public TextView w;
        public MyRadioButton x;
        public ImageView y;
        public ImageView z;

        public c(View view) {
            super(view);
            this.y = (ImageView) view.findViewById(b73.R3);
            this.z = (ImageView) view.findViewById(b73.S3);
            this.u = (ImageView) view.findViewById(b73.M2);
            this.v = (TextView) view.findViewById(b73.X3);
            this.w = (TextView) view.findViewById(b73.t4);
            MyRadioButton myRadioButton = (MyRadioButton) view.findViewById(b73.x4);
            this.x = myRadioButton;
            myRadioButton.setOnClickListener(j22.this.h);
        }

        public void O(LiveGiftBean liveGiftBean, int i, Object obj) {
            if (obj == null) {
                kn1.f(j22.this.d, liveGiftBean.getIcon(), this.u);
                liveGiftBean.setView(this.u);
                this.v.setText(liveGiftBean.getNameTrans());
                int mark = liveGiftBean.getMark();
                if (liveGiftBean.isGlobal()) {
                    if (mark == 1) {
                        this.y.setImageDrawable(j22.this.o);
                        this.z.setImageDrawable(j22.this.r);
                    } else if (mark == 2) {
                        this.y.setImageDrawable(j22.this.p);
                        this.z.setImageDrawable(j22.this.r);
                    } else {
                        ImageView imageView = this.y;
                        if (mark == 3) {
                            imageView.setImageDrawable(j22.this.q);
                            this.z.setImageDrawable(j22.this.r);
                        } else {
                            imageView.setImageDrawable(null);
                            this.z.setImageDrawable(j22.this.r);
                        }
                    }
                } else if (liveGiftBean.getType() == 3) {
                    if (mark == 1) {
                        this.y.setImageDrawable(j22.this.o);
                        this.z.setImageDrawable(j22.this.s);
                    } else if (mark == 2) {
                        this.y.setImageDrawable(j22.this.p);
                        this.z.setImageDrawable(j22.this.s);
                    } else {
                        ImageView imageView2 = this.y;
                        if (mark == 3) {
                            imageView2.setImageDrawable(j22.this.q);
                            this.z.setImageDrawable(j22.this.s);
                        } else {
                            imageView2.setImageDrawable(null);
                            this.z.setImageDrawable(j22.this.s);
                        }
                    }
                } else if (liveGiftBean.getType() == 1) {
                    if (mark == 1) {
                        this.y.setImageDrawable(j22.this.o);
                        this.z.setImageDrawable(j22.this.t);
                    } else if (mark == 2) {
                        this.y.setImageDrawable(j22.this.p);
                        this.z.setImageDrawable(j22.this.t);
                    } else {
                        ImageView imageView3 = this.y;
                        if (mark == 3) {
                            imageView3.setImageDrawable(j22.this.q);
                            this.z.setImageDrawable(j22.this.t);
                        } else {
                            imageView3.setImageDrawable(null);
                            this.z.setImageDrawable(j22.this.t);
                        }
                    }
                } else if (mark == 1) {
                    this.y.setImageDrawable(j22.this.o);
                    this.z.setImageDrawable(null);
                } else if (mark == 2) {
                    this.y.setImageDrawable(j22.this.p);
                    this.z.setImageDrawable(null);
                } else {
                    ImageView imageView4 = this.y;
                    if (mark == 3) {
                        imageView4.setImageDrawable(j22.this.q);
                        this.z.setImageDrawable(null);
                    } else {
                        imageView4.setImageDrawable(null);
                        this.z.setImageDrawable(null);
                    }
                }
                if (j22.this.n == 0 || j22.this.n == 1) {
                    this.w.setText(rv3.a(liveGiftBean.getPrice(), j22.this.g));
                }
            }
            this.x.setTag(Integer.valueOf(i));
            this.x.a(liveGiftBean.isChecked());
            if (j22.this.n == 2 && (liveGiftBean instanceof BackPackGiftBean)) {
                this.w.setText(rv3.a(String.valueOf(((BackPackGiftBean) liveGiftBean).getNums()), j22.this.m));
            }
        }
    }

    public j22(Context context, LayoutInflater layoutInflater, List list, String str, int i) {
        this.d = context;
        this.n = i;
        this.f = layoutInflater;
        this.e = list;
        this.g = str;
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.9f, 1.1f, 0.9f, 1.1f, 1, 0.5f, 1, 0.5f);
        this.k = scaleAnimation;
        scaleAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
        this.k.setDuration(400L);
        this.k.setRepeatMode(2);
        this.k.setRepeatCount(-1);
        this.m = aq4.a(m93.P1);
        this.o = o60.d(this.d, t83.e0);
        this.p = o60.d(this.d, t83.c0);
        this.q = o60.d(this.d, t83.f0);
        this.r = o60.d(this.d, t83.b0);
        this.s = o60.d(this.d, t83.g0);
        this.t = o60.d(this.d, t83.d0);
    }

    public boolean b0() {
        int i = this.j;
        if (i < 0 || i >= this.e.size()) {
            return false;
        }
        LiveGiftBean liveGiftBean = (LiveGiftBean) this.e.get(this.j);
        if (liveGiftBean.isChecked()) {
            View view = liveGiftBean.getView();
            View view2 = this.l;
            if (view2 == view) {
                view2.clearAnimation();
            } else if (view != null) {
                view.clearAnimation();
            }
            this.l = null;
            liveGiftBean.setChecked(false);
            r(this.j, "payload");
        }
        this.j = -1;
        return true;
    }

    /* renamed from: c0, reason: merged with bridge method [inline-methods] */
    public void z(c cVar, int i) {
    }

    /* renamed from: d0, reason: merged with bridge method [inline-methods] */
    public void A(c cVar, int i, List list) {
        super.A(cVar, i, list);
        cVar.O((LiveGiftBean) this.e.get(i), i, list.size() > 0 ? list.get(0) : null);
    }

    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public c B(ViewGroup viewGroup, int i) {
        return new c(this.f.inflate(x73.L0, viewGroup, false));
    }

    public boolean f0(int i, int i2) {
        int size = this.e.size();
        for (int i3 = 0; i3 < size; i3++) {
            LiveGiftBean liveGiftBean = (LiveGiftBean) this.e.get(i3);
            if (liveGiftBean.getId() == i && (liveGiftBean instanceof BackPackGiftBean)) {
                BackPackGiftBean backPackGiftBean = (BackPackGiftBean) liveGiftBean;
                int nums = backPackGiftBean.getNums() - i2;
                backPackGiftBean.setNums(nums >= 0 ? nums : 0);
                r(i3, "payload");
                return true;
            }
        }
        return false;
    }

    public void g0(b bVar) {
        this.i = bVar;
    }

    public int j() {
        return this.e.size();
    }
}
