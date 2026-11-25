package defpackage;

import android.content.Context;
import android.view.ViewGroup;

/* loaded from: /tmp/classes2.dex */
public abstract class y0 extends b1 {
    protected boolean mFirstLoadData;
    protected boolean mShowed;

    public y0(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.mFirstLoadData = true;
    }

    public y0(Context context, ViewGroup viewGroup, Object... objArr) {
        super(context, viewGroup, objArr);
        this.mFirstLoadData = true;
    }

    public boolean isFirstLoadData() {
        if (!this.mFirstLoadData) {
            return false;
        }
        this.mFirstLoadData = false;
        return true;
    }

    public boolean isShowed() {
        return this.mShowed;
    }

    public void loadData() {
    }

    public void setShowed(boolean z) {
        this.mShowed = z;
    }
}
