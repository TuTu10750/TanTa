package defpackage;

import android.app.Dialog;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.im.bean.VideoImMsgBean;
import com.yunbao.video.activity.VideoPlayActivity;
import com.yunbao.video.bean.VideoBean;

/* loaded from: /tmp/classes2.dex */
public class gk1 extends ce3 {
    public String i;
    public String j;
    public int k;
    public View.OnClickListener l;
    public View.OnClickListener m;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag(a73.c);
            if (tag != null) {
                pi3.q(gk1.this.d, ((VideoImMsgBean) tag).getFromUid());
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements View.OnClickListener {

        /* loaded from: /tmp/classes2.dex */
        public class a extends HttpCallback {
            public a() {
            }

            @Override // com.yunbao.common.http.HttpCallback
            public Dialog createLoadingDialog() {
                return com.yunbao.common.utils.a.c(gk1.this.d);
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i != 0 || strArr.length <= 0) {
                    return;
                }
                VideoPlayActivity.B1(gk1.this.d, (VideoBean) JSON.parseObject(strArr[0], VideoBean.class));
            }

            @Override // com.yunbao.common.http.HttpCallback
            public boolean showLoadingDialog() {
                return true;
            }
        }

        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null) {
                zh4.j(((VideoImMsgBean) tag).getVideoId(), new a());
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends RecyclerView.e0 {
        public TextView u;
        public TextView v;
        public ImageView w;
        public ImageView x;

        public c(View view) {
            super(view);
            this.u = (TextView) view.findViewById(a73.o0);
            this.v = (TextView) view.findViewById(a73.a);
            this.w = (ImageView) view.findViewById(a73.c);
            this.x = (ImageView) view.findViewById(a73.l0);
            this.w.setOnClickListener(gk1.this.l);
            view.setOnClickListener(gk1.this.m);
        }

        public void O(VideoImMsgBean videoImMsgBean) {
            this.w.setTag(a73.c, videoImMsgBean);
            ((RecyclerView.e0) this).a.setTag(videoImMsgBean);
            String userName = videoImMsgBean.getUserName();
            int type = videoImMsgBean.getType();
            gk1 gk1Var = gk1.this;
            SpannableString spannableString = new SpannableString(String.format(type == 1 ? gk1Var.i : gk1Var.j, userName));
            spannableString.setSpan(new ForegroundColorSpan(gk1.this.k), 0, userName.length(), 33);
            this.u.setText(spannableString);
            this.v.setText(videoImMsgBean.getAddTime());
            kn1.g(gk1.this.d, videoImMsgBean.getAvatar(), this.w);
            kn1.f(gk1.this.d, videoImMsgBean.getThumb(), this.x);
        }
    }

    public gk1(Context context) {
        super(context);
        this.i = aq4.a(m93.W);
        this.j = aq4.a(m93.a0);
        this.k = o60.b(context, p53.l);
        this.l = new a();
        this.m = new b();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new c(this.f.inflate(w73.u, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((c) e0Var).O((VideoImMsgBean) this.e.get(i));
    }
}
