package defpackage;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.activity.LiveActivity;
import com.yunbao.live.bean.LiveUserGiftBean;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B\u0007¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\t\u001a\u00020\u0006H\u0014¢\u0006\u0004\b\t\u0010\bJ\u000f\u0010\u000b\u001a\u00020\nH\u0014¢\u0006\u0004\b\u000b\u0010\fJ\u0019\u0010\u0010\u001a\u00020\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0014¢\u0006\u0004\b\u0010\u0010\u0011J\u0019\u0010\u0014\u001a\u00020\u000f2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0012H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0018\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\r\u0010\u001a\u001a\u00020\u000f¢\u0006\u0004\b\u001a\u0010\u0005J!\u0010\u001d\u001a\u00020\u000f2\b\u0010\u001b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u001c\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u001d\u0010\u001eR\u0018\u0010\"\u001a\u0004\u0018\u00010\u001f8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b \u0010!R\u0018\u0010&\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b$\u0010%R\u0018\u0010(\u001a\u0004\u0018\u00010#8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b'\u0010%R\u0016\u0010+\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b)\u0010*R\u0018\u0010/\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b-\u0010.R\u0018\u00103\u001a\u0004\u0018\u0001008\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b1\u00102R\u0018\u00107\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b5\u00106R\u0018\u00109\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b8\u00106R$\u0010A\u001a\u0004\u0018\u00010:8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b;\u0010<\u001a\u0004\b=\u0010>\"\u0004\b?\u0010@¨\u0006B"}, d2 = {"Lc62;", "Ll0;", "Let2;", "Lcom/yunbao/live/bean/LiveUserGiftBean;", "<init>", "()V", "", "m2", "()I", "l2", "", "f2", "()Z", "Landroid/view/Window;", "window", "Lqc4;", "p2", "(Landroid/view/Window;)V", "Landroid/os/Bundle;", "savedInstanceState", "r0", "(Landroid/os/Bundle;)V", "Landroid/content/DialogInterface;", "dialog", "onDismiss", "(Landroid/content/DialogInterface;)V", "B2", "bean", "position", "A2", "(Lcom/yunbao/live/bean/LiveUserGiftBean;I)V", "Lz52;", "z0", "Lz52;", "mAdapter", "", "A0", "Ljava/lang/String;", "mLiveUid", "B0", "mStream", "C0", "I", "mUserType", "Lcom/yunbao/common/custom/CommonRefreshView;", "D0", "Lcom/yunbao/common/custom/CommonRefreshView;", "mCommonRefreshView", "Landroid/widget/ImageView;", "E0", "Landroid/widget/ImageView;", "btnRefresh", "Landroid/widget/TextView;", "F0", "Landroid/widget/TextView;", "mTvTip100", "G0", "mTvNum", "Landroid/animation/ObjectAnimator;", "H0", "Landroid/animation/ObjectAnimator;", "getAnimator", "()Landroid/animation/ObjectAnimator;", "setAnimator", "(Landroid/animation/ObjectAnimator;)V", "animator", "live_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: /tmp/classes2.dex */
public final class c62 extends l0 implements et2 {

    /* renamed from: A0, reason: from kotlin metadata */
    public String mLiveUid;

    /* renamed from: B0, reason: from kotlin metadata */
    public String mStream;

    /* renamed from: C0, reason: from kotlin metadata */
    public int mUserType = 30;

    /* renamed from: D0, reason: from kotlin metadata */
    public CommonRefreshView mCommonRefreshView;

    /* renamed from: E0, reason: from kotlin metadata */
    public ImageView btnRefresh;

    /* renamed from: F0, reason: from kotlin metadata */
    public TextView mTvTip100;

    /* renamed from: G0, reason: from kotlin metadata */
    public TextView mTvNum;

    /* renamed from: H0, reason: from kotlin metadata */
    public ObjectAnimator animator;

    /* renamed from: z0, reason: from kotlin metadata */
    public z52 mAdapter;

    /* loaded from: /tmp/classes2.dex */
    public static final class a implements CommonRefreshView.e {
        public a() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            z52 z52Var = c62.this.mAdapter;
            if (z52Var != null) {
                return z52Var;
            }
            Context context = c62.this.x0;
            context.getClass();
            z52 z52Var2 = new z52(context, c62.this.mUserType, c62.this.mLiveUid);
            c62 c62Var = c62.this;
            c62Var.mAdapter = z52Var2;
            z52Var2.R(c62Var);
            return z52Var2;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
            httpCallback.getClass();
            e32.W(c62.this.mLiveUid, c62.this.mStream, httpCallback);
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onLoadMoreFailure() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onLoadMoreSuccess(List list, int i) {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onRefreshFailure() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onRefreshSuccess(List list, int i) {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public List processData(String[] strArr) {
            strArr.getClass();
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            TextView textView = c62.this.mTvNum;
            if (textView != null) {
                textView.setText("（" + parseObject.getString("nums") + " 人）");
            }
            List parseArray = JSON.parseArray(parseObject.getString("list"), LiveUserGiftBean.class);
            parseArray.getClass();
            return parseArray;
        }
    }

    public static void r2(c62 c62Var, View view) {
        c62Var.S1();
    }

    public static void s2(c62 c62Var, View view) {
        c62Var.B2();
        CommonRefreshView commonRefreshView = c62Var.mCommonRefreshView;
        if (commonRefreshView != null) {
            commonRefreshView.k();
        }
    }

    @Override // defpackage.et2
    /* renamed from: A2, reason: merged with bridge method [inline-methods] */
    public void onItemClick(LiveUserGiftBean bean, int position) {
        Object obj = this.x0;
        LiveActivity liveActivity = obj instanceof LiveActivity ? (LiveActivity) obj : null;
        if (liveActivity != null) {
            liveActivity.B2(bean != null ? bean.getId() : null);
        }
    }

    public final void B2() {
        ImageView imageView;
        if (this.animator == null && (imageView = this.btnRefresh) != null) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "rotation", imageView.getRotation(), imageView.getRotation() + 360.0f);
            this.animator = ofFloat;
            if (ofFloat != null) {
                ofFloat.setDuration(800L);
            }
            ObjectAnimator objectAnimator = this.animator;
            if (objectAnimator != null) {
                objectAnimator.setInterpolator(new LinearInterpolator());
            }
        }
        ObjectAnimator objectAnimator2 = this.animator;
        if (objectAnimator2 != null) {
            objectAnimator2.start();
        }
    }

    @Override // defpackage.l0
    public boolean f2() {
        return true;
    }

    @Override // defpackage.l0
    public int l2() {
        return s93.c;
    }

    @Override // defpackage.l0
    public int m2() {
        return x73.c0;
    }

    public void onDismiss(DialogInterface dialog) {
        dialog.getClass();
        super.onDismiss(dialog);
        ObjectAnimator objectAnimator = this.animator;
        if (objectAnimator != null) {
            objectAnimator.cancel();
        }
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        if (window != null) {
            window.setWindowAnimations(s93.b);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = -1;
            attributes.height = (int) (gk3.a().b() * 0.6f);
            attributes.gravity = 80;
        }
    }

    public void r0(Bundle savedInstanceState) {
        TextView textView;
        super.r0(savedInstanceState);
        Bundle z = z();
        if (z != null) {
            this.mLiveUid = z.getString("liveUid");
            this.mStream = z.getString("stream");
            this.mUserType = z.getInt("userType");
        }
        k2(b73.H).setOnClickListener(new View.OnClickListener() { // from class: a62
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                c62.r2(c62.this, view);
            }
        });
        this.mTvTip100 = (TextView) k2(b73.F5);
        this.mTvNum = (TextView) k2(b73.E5);
        ImageView imageView = (ImageView) k2(b73.O0);
        this.btnRefresh = imageView;
        if (imageView != null) {
            imageView.setVisibility(this.mUserType > 30 ? 0 : 8);
        }
        if (this.mUserType <= 30 && (textView = this.mTvTip100) != null) {
            textView.setVisibility(0);
        }
        ImageView imageView2 = this.btnRefresh;
        if (imageView2 != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: b62
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    c62.s2(c62.this, view);
                }
            });
        }
        CommonRefreshView commonRefreshView = (CommonRefreshView) k2(b73.E4);
        this.mCommonRefreshView = commonRefreshView;
        if (commonRefreshView != null) {
            commonRefreshView.setLayoutManager(new LinearLayoutManager(this.x0, 1, false));
            commonRefreshView.setDataHelper(new a());
            commonRefreshView.k();
        }
    }
}
