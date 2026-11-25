package defpackage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.live.bean.LiveVoiceGiftBean;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class s62 extends RecyclerView.Adapter {
    public Context d;
    public LayoutInflater e;
    public List f;
    public Drawable g;
    public Drawable h;
    public Drawable i;
    public int j;
    public int k;
    public View.OnClickListener l;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            LiveVoiceGiftBean liveVoiceGiftBean = (LiveVoiceGiftBean) s62.this.f.get(intValue);
            boolean z = true;
            int i = 1;
            liveVoiceGiftBean.setChecked(!liveVoiceGiftBean.isChecked());
            int type = liveVoiceGiftBean.getType();
            s62 s62Var = s62.this;
            if (type != -2) {
                s62Var.r(intValue, "payload");
                int size = s62.this.f.size();
                int i2 = 1;
                while (true) {
                    if (i2 >= size) {
                        break;
                    }
                    if (!((LiveVoiceGiftBean) s62.this.f.get(i2)).isChecked()) {
                        z = false;
                        break;
                    }
                    i2++;
                }
                LiveVoiceGiftBean liveVoiceGiftBean2 = (LiveVoiceGiftBean) s62.this.f.get(0);
                if (liveVoiceGiftBean2.isChecked() != z) {
                    liveVoiceGiftBean2.setChecked(z);
                    s62.this.r(0, "payload");
                    return;
                }
                return;
            }
            int size2 = s62Var.f.size();
            while (true) {
                s62 s62Var2 = s62.this;
                if (i >= size2) {
                    s62Var2.p();
                    return;
                } else {
                    ((LiveVoiceGiftBean) s62Var2.f.get(i)).setChecked(liveVoiceGiftBean.isChecked());
                    i++;
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends RecyclerView.e0 {
        public ImageView u;
        public ImageView v;
        public TextView w;

        public b(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(b73.j);
            this.v = (ImageView) view.findViewById(b73.d);
            this.w = (TextView) view.findViewById(b73.a3);
            view.setOnClickListener(s62.this.l);
        }

        public void O(LiveVoiceGiftBean liveVoiceGiftBean, int i, Object obj) {
            ((RecyclerView.e0) this).a.setTag(Integer.valueOf(i));
            if (obj == null) {
                if (liveVoiceGiftBean.getType() == -2) {
                    this.v.setImageDrawable(null);
                } else {
                    kn1.g(s62.this.d, liveVoiceGiftBean.getAvatar(), this.v);
                }
                this.w.setText(liveVoiceGiftBean.getTextRes());
            }
            if (liveVoiceGiftBean.isChecked()) {
                int type = liveVoiceGiftBean.getType();
                ImageView imageView = this.u;
                if (type == -2) {
                    imageView.setImageDrawable(s62.this.h);
                } else {
                    imageView.setImageDrawable(s62.this.g);
                }
                this.w.setBackground(liveVoiceGiftBean.getCheckedDrawable());
                this.w.setTextColor(s62.this.j);
                return;
            }
            int type2 = liveVoiceGiftBean.getType();
            ImageView imageView2 = this.u;
            if (type2 == -2) {
                imageView2.setImageDrawable(s62.this.i);
            } else {
                imageView2.setImageDrawable(null);
            }
            this.w.setBackground(liveVoiceGiftBean.getUnCheckedDrawable());
            this.w.setTextColor(s62.this.k);
        }
    }

    public s62(Context context, List list) {
        this.d = context;
        this.e = LayoutInflater.from(context);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            LiveVoiceGiftBean liveVoiceGiftBean = (LiveVoiceGiftBean) it.next();
            int type = liveVoiceGiftBean.getType();
            if (type == -2) {
                liveVoiceGiftBean.setDrawable(context, h63.p, h63.o);
                liveVoiceGiftBean.setTextRes(m93.Ma);
            } else if (type == -1) {
                liveVoiceGiftBean.setDrawable(context, h63.p, h63.o);
                liveVoiceGiftBean.setTextRes(m93.Ja);
            } else if (type == 0) {
                liveVoiceGiftBean.setDrawable(context, h63.p, h63.o);
                liveVoiceGiftBean.setTextRes(m93.Ga);
            } else if (type == 1) {
                liveVoiceGiftBean.setDrawable(context, h63.p, h63.o);
                liveVoiceGiftBean.setTextRes(m93.Ka);
            } else if (type == 2) {
                liveVoiceGiftBean.setDrawable(context, h63.p, h63.o);
                liveVoiceGiftBean.setTextRes(m93.Ia);
            } else if (type == 3) {
                liveVoiceGiftBean.setDrawable(context, h63.p, h63.o);
                liveVoiceGiftBean.setTextRes(m93.Pa);
            } else if (type == 4) {
                liveVoiceGiftBean.setDrawable(context, h63.p, h63.o);
                liveVoiceGiftBean.setTextRes(m93.La);
            } else if (type == 5) {
                liveVoiceGiftBean.setDrawable(context, h63.p, h63.o);
                liveVoiceGiftBean.setTextRes(m93.Oa);
            } else if (type == 6) {
                liveVoiceGiftBean.setDrawable(context, h63.p, h63.o);
                liveVoiceGiftBean.setTextRes(m93.Ha);
            } else if (type == 7) {
                liveVoiceGiftBean.setDrawable(context, h63.p, h63.o);
                liveVoiceGiftBean.setTextRes(m93.Na);
            }
        }
        this.f = list;
        this.g = o60.d(context, h63.n);
        this.h = o60.d(context, t83.v);
        this.i = o60.d(context, t83.u);
        this.j = o60.b(context, p53.n);
        this.k = o60.b(context, p53.l);
        this.l = new a();
    }

    public void A(RecyclerView.e0 e0Var, int i, List list) {
        ((b) e0Var).O((LiveVoiceGiftBean) this.f.get(i), i, list.size() > 0 ? list.get(0) : null);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new b(this.e.inflate(x73.j1, viewGroup, false));
    }

    public Object[] T() {
        String str;
        int size = this.f.size();
        StringBuilder sb = null;
        int i = 0;
        for (int i2 = 1; i2 < size; i2++) {
            LiveVoiceGiftBean liveVoiceGiftBean = (LiveVoiceGiftBean) this.f.get(i2);
            if (liveVoiceGiftBean.isChecked()) {
                String uid = liveVoiceGiftBean.getUid();
                if (!TextUtils.isEmpty(uid)) {
                    if (sb == null) {
                        sb = new StringBuilder();
                    }
                    sb.append(uid);
                    sb.append(",");
                    i++;
                }
            }
        }
        if (sb != null) {
            String sb2 = sb.toString();
            str = sb2.substring(0, sb2.length() - 1);
        } else {
            str = "";
        }
        return new Object[]{str, Integer.valueOf(i)};
    }

    public int j() {
        return this.f.size();
    }

    public void z(RecyclerView.e0 e0Var, int i) {
    }
}
