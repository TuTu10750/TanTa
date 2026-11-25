package defpackage;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.yunbao.common.activity.AbsActivity;

/* loaded from: /tmp/classes2.dex */
public abstract class b1 implements uy1 {
    protected View mContentView;
    protected Context mContext;
    protected ViewGroup mParentView;
    protected String mTag = getClass().getSimpleName();

    public b1(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.mParentView = viewGroup;
        this.mContentView = LayoutInflater.from(context).inflate(getLayoutId(), this.mParentView, false);
        init();
    }

    public b1(Context context, ViewGroup viewGroup, Object... objArr) {
        processArguments(objArr);
        this.mContext = context;
        this.mParentView = viewGroup;
        this.mContentView = LayoutInflater.from(context).inflate(getLayoutId(), this.mParentView, false);
        init();
    }

    public void addToParent() {
        View view;
        if (this.mParentView == null || (view = this.mContentView) == null) {
            return;
        }
        ViewParent parent = view.getParent();
        ViewGroup viewGroup = this.mParentView;
        if (parent == null) {
            viewGroup.addView(this.mContentView);
        } else if (parent != viewGroup) {
            ((ViewGroup) parent).removeView(this.mContentView);
            this.mParentView.addView(this.mContentView);
        }
    }

    public boolean canClick() {
        return j10.a();
    }

    public <T extends View> T findViewById(int i) {
        return (T) this.mContentView.findViewById(i);
    }

    public void finishAcitivty() {
        Context context = this.mContext;
        if (context == null || !(context instanceof Activity)) {
            return;
        }
        ((Activity) context).finish();
    }

    public View getContentView() {
        return this.mContentView;
    }

    public abstract int getLayoutId();

    public abstract void init();

    @Override // defpackage.uy1
    public void onCreate() {
        lx1.c(this.mTag, "lifeCycle-----onCreate----->");
    }

    @Override // defpackage.uy1
    public void onDestroy() {
        lx1.c(this.mTag, "lifeCycle-----onDestroy----->");
    }

    @Override // defpackage.uy1
    public void onPause() {
        lx1.c(this.mTag, "lifeCycle-----onPause----->");
    }

    @Override // defpackage.uy1
    public void onReStart() {
        lx1.c(this.mTag, "lifeCycle-----onReStart----->");
    }

    @Override // defpackage.uy1
    public void onResume() {
        lx1.c(this.mTag, "lifeCycle-----onResume----->");
    }

    @Override // defpackage.uy1
    public void onStart() {
        lx1.c(this.mTag, "lifeCycle-----onStart----->");
    }

    @Override // defpackage.uy1
    public void onStop() {
        lx1.c(this.mTag, "lifeCycle-----onStop----->");
    }

    public void processArguments(Object... objArr) {
    }

    public void release() {
        lx1.c(this.mTag, "release-------->");
    }

    public void removeFromParent() {
        ViewParent parent;
        View view = this.mContentView;
        if (view == null || (parent = view.getParent()) == null) {
            return;
        }
        ((ViewGroup) parent).removeView(this.mContentView);
    }

    public void setStatusHeight() {
        View findViewById = findViewById(y63.F);
        if (findViewById != null) {
            findViewById.setPadding(0, gk3.a().d(), 0, 0);
        }
    }

    public void subscribeActivityLifeCycle() {
        Object obj = this.mContext;
        if (obj instanceof AbsActivity) {
            ((AbsActivity) obj).b1(this);
        }
    }

    public void unSubscribeActivityLifeCycle() {
        Object obj = this.mContext;
        if (obj instanceof AbsActivity) {
            ((AbsActivity) obj).o1(this);
        }
    }
}
