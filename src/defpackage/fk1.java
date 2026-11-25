package defpackage;

import android.content.Context;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.bean.UserBean;
import com.yunbao.common.custom.MyRadioButton;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.im.bean.VideoImConcatBean;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class fk1 extends ce3 {
    public String i;
    public int j;
    public View.OnClickListener k;
    public View.OnClickListener l;
    public String m;
    public String n;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag;
            if (fk1.this.L() && (tag = view.getTag()) != null) {
                CommonHttpUtil.setAttention(((VideoImConcatBean) tag).getFromUid(), null);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag;
            if (fk1.this.L() && (tag = view.getTag()) != null) {
                pi3.q(fk1.this.d, ((VideoImConcatBean) tag).getFromUid());
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends RecyclerView.e0 {
        public TextView u;
        public TextView v;
        public ImageView w;
        public MyRadioButton x;

        public c(View view) {
            super(view);
            this.u = (TextView) view.findViewById(a73.o0);
            this.v = (TextView) view.findViewById(a73.a);
            this.w = (ImageView) view.findViewById(a73.c);
            MyRadioButton myRadioButton = (MyRadioButton) view.findViewById(a73.q);
            this.x = myRadioButton;
            myRadioButton.setOnClickListener(fk1.this.k);
            view.setOnClickListener(fk1.this.l);
        }

        public void O(VideoImConcatBean videoImConcatBean, Object obj) {
            if (obj == null) {
                this.x.setTag(videoImConcatBean);
                ((RecyclerView.e0) this).a.setTag(videoImConcatBean);
                this.v.setText(videoImConcatBean.getAddTime());
                UserBean userBean = videoImConcatBean.getUserBean();
                if (userBean != null) {
                    kn1.g(fk1.this.d, userBean.getAvatar(), this.w);
                    String userNiceName = userBean.getUserNiceName();
                    if (userNiceName == null) {
                        userNiceName = "";
                    }
                    SpannableString spannableString = new SpannableString(String.format(fk1.this.i, userNiceName));
                    spannableString.setSpan(new ForegroundColorSpan(fk1.this.j), 0, userNiceName.length(), 33);
                    this.u.setText(spannableString);
                }
            }
            int isAttent = videoImConcatBean.getIsAttent();
            MyRadioButton myRadioButton = this.x;
            if (isAttent == 1) {
                myRadioButton.a(true);
                this.x.setText(fk1.this.n);
            } else {
                myRadioButton.a(false);
                this.x.setText(fk1.this.m);
            }
        }
    }

    public fk1(Context context) {
        super(context);
        this.m = aq4.a(m93.M1);
        this.n = aq4.a(m93.N1);
        this.i = aq4.a(m93.Z);
        this.j = o60.b(context, p53.l);
        this.k = new a();
        this.l = new b();
    }

    public void A(RecyclerView.e0 e0Var, int i, List list) {
        ((c) e0Var).O((VideoImConcatBean) this.e.get(i), list.size() > 0 ? list.get(0) : null);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new c(this.f.inflate(w73.w, viewGroup, false));
    }

    public void c0(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int size = this.e.size();
        for (int i2 = 0; i2 < size; i2++) {
            VideoImConcatBean videoImConcatBean = (VideoImConcatBean) this.e.get(i2);
            if (videoImConcatBean != null && str.equals(videoImConcatBean.getFromUid())) {
                videoImConcatBean.setIsAttent(i);
                r(i2, "payload");
                return;
            }
        }
    }

    public void z(RecyclerView.e0 e0Var, int i) {
    }
}
