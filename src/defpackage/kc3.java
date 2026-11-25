package defpackage;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.live.bean.RedPackBean;
import com.yunbao.live.custom.MyImageView;
import java.lang.ref.WeakReference;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class kc3 extends RecyclerView.Adapter {
    public Context d;
    public List e;
    public LayoutInflater f;
    public et2 j;
    public lc3 l;
    public String g = aq4.a(m93.y9);
    public String h = aq4.a(m93.z9);
    public View.OnClickListener i = new a();
    public b k = new b(this);
    public final StringBuilder m = new StringBuilder();

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag == null) {
                return;
            }
            int intValue = ((Integer) tag).intValue();
            if (kc3.this.j != null) {
                kc3.this.j.onItemClick((RedPackBean) kc3.this.e.get(intValue), intValue);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class b extends Handler {
        public kc3 a;

        public b(kc3 kc3Var) {
            this.a = (kc3) new WeakReference(kc3Var).get();
        }

        public void a() {
            this.a = null;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            kc3 kc3Var = this.a;
            if (kc3Var != null) {
                kc3Var.d0(message.what);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends RecyclerView.e0 {
        public RedPackBean A;
        public ImageView u;
        public TextView v;
        public TextView w;
        public MyImageView x;
        public TextView y;
        public View z;

        public c(View view) {
            super(view);
            this.u = (ImageView) view.findViewById(b73.d);
            this.v = (TextView) view.findViewById(b73.X3);
            this.w = (TextView) view.findViewById(b73.d6);
            this.x = (MyImageView) view.findViewById(b73.R2);
            this.y = (TextView) view.findViewById(b73.e5);
            View findViewById = view.findViewById(b73.R0);
            this.z = findViewById;
            findViewById.setOnClickListener(kc3.this.i);
        }

        public void O() {
            MyImageView myImageView;
            RedPackBean redPackBean = this.A;
            if (redPackBean == null || redPackBean.getIsRob() != 1 || this.A.getRobTime() != 0 || (myImageView = this.x) == null) {
                return;
            }
            myImageView.c();
        }

        public void P(RedPackBean redPackBean, int i, Object obj) {
            this.A = redPackBean;
            if (obj == null) {
                this.z.setTag(Integer.valueOf(i));
                kn1.g(kc3.this.d, redPackBean.getAvatar(), this.u);
                this.v.setText(redPackBean.getUserNiceName());
                int sendType = redPackBean.getSendType();
                TextView textView = this.w;
                if (sendType == 1) {
                    textView.setText(kc3.this.h);
                } else {
                    textView.setText(kc3.this.g);
                }
            }
            int robTime = redPackBean.getRobTime();
            TextView textView2 = this.y;
            if (robTime != 0) {
                textView2.setTextColor(-13487566);
                this.y.setText(rv3.e(redPackBean.getRobTime(), kc3.this.m));
                this.x.d();
                return;
            }
            textView2.setTextColor(-65536);
            this.y.setText(m93.x9);
            int isRob = redPackBean.getIsRob();
            MyImageView myImageView = this.x;
            if (isRob == 1) {
                myImageView.c();
            } else {
                myImageView.d();
            }
        }

        public void Q() {
            MyImageView myImageView = this.x;
            if (myImageView != null) {
                myImageView.d();
            }
        }
    }

    public kc3(Context context, List list) {
        this.d = context;
        this.e = list;
        this.f = LayoutInflater.from(context);
        for (int i = 0; i < this.e.size(); i++) {
            RedPackBean redPackBean = (RedPackBean) this.e.get(i);
            if (redPackBean != null && redPackBean.getRobTime() != 0) {
                this.k.sendEmptyMessageDelayed(i, 1000L);
            }
        }
    }

    /* renamed from: T, reason: merged with bridge method [inline-methods] */
    public void z(c cVar, int i) {
    }

    /* renamed from: U, reason: merged with bridge method [inline-methods] */
    public void A(c cVar, int i, List list) {
        cVar.P((RedPackBean) this.e.get(i), i, list.size() > 0 ? list.get(0) : null);
    }

    /* renamed from: V, reason: merged with bridge method [inline-methods] */
    public c B(ViewGroup viewGroup, int i) {
        return new c(this.f.inflate(x73.n1, viewGroup, false));
    }

    public void W(int i) {
        int size = this.e.size();
        for (int i2 = 0; i2 < size; i2++) {
            RedPackBean redPackBean = (RedPackBean) this.e.get(i2);
            if (redPackBean.getId() == i) {
                redPackBean.setIsRob(0);
                r(i2, "payload");
                return;
            }
        }
    }

    /* renamed from: X, reason: merged with bridge method [inline-methods] */
    public void E(c cVar) {
        cVar.O();
    }

    /* renamed from: Y, reason: merged with bridge method [inline-methods] */
    public void F(c cVar) {
        cVar.Q();
    }

    public void Z(Runnable runnable, long j) {
        b bVar = this.k;
        if (bVar != null) {
            bVar.postDelayed(runnable, j);
        }
    }

    public void a0() {
        List list = this.e;
        if (list != null) {
            list.clear();
        }
        b bVar = this.k;
        if (bVar != null) {
            bVar.removeCallbacksAndMessages(null);
            this.k.a();
        }
        this.k = null;
        this.l = null;
    }

    public void b0(et2 et2Var) {
        this.j = et2Var;
    }

    public void c0(lc3 lc3Var) {
        this.l = lc3Var;
    }

    public final void d0(int i) {
        RedPackBean redPackBean;
        b bVar;
        if (i < 0 || i >= this.e.size() || (redPackBean = (RedPackBean) this.e.get(i)) == null) {
            return;
        }
        int robTime = redPackBean.getRobTime() - 1;
        redPackBean.setRobTime(robTime);
        r(i, "payload");
        if (robTime > 0 && (bVar = this.k) != null) {
            bVar.sendEmptyMessageDelayed(i, 1000L);
        }
        if (this.l == null || redPackBean.getId() != this.l.i()) {
            return;
        }
        this.l.h(robTime);
    }

    public int j() {
        return this.e.size();
    }
}
