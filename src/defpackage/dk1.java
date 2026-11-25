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
public class dk1 extends ce3 {
    public String i;
    public int j;
    public View.OnClickListener k;
    public View.OnClickListener l;

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag(a73.c);
            if (tag != null) {
                pi3.q(dk1.this.d, ((VideoImMsgBean) tag).getFromUid());
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
                return com.yunbao.common.utils.a.c(dk1.this.d);
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                if (i != 0 || strArr.length <= 0) {
                    return;
                }
                VideoPlayActivity.B1(dk1.this.d, (VideoBean) JSON.parseObject(strArr[0], VideoBean.class));
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
            this.w.setOnClickListener(dk1.this.k);
            view.setOnClickListener(dk1.this.l);
        }

        public void O(VideoImMsgBean videoImMsgBean) {
            this.w.setTag(a73.c, videoImMsgBean);
            ((RecyclerView.e0) this).a.setTag(videoImMsgBean);
            String userName = videoImMsgBean.getUserName();
            SpannableString spannableString = new SpannableString(String.format(dk1.this.i, userName, videoImMsgBean.getVideoTitle()));
            spannableString.setSpan(new ForegroundColorSpan(dk1.this.j), 0, userName.length(), 33);
            this.u.setText(spannableString);
            this.v.setText(videoImMsgBean.getAddTime());
            kn1.g(dk1.this.d, videoImMsgBean.getAvatar(), this.w);
            kn1.f(dk1.this.d, videoImMsgBean.getThumb(), this.x);
        }
    }

    public dk1(Context context) {
        super(context);
        this.i = aq4.a(m93.Y);
        this.j = o60.b(context, p53.l);
        this.k = new a();
        this.l = new b();
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return new c(this.f.inflate(w73.u, viewGroup, false));
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        ((c) e0Var).O((VideoImMsgBean) this.e.get(i));
    }
}
