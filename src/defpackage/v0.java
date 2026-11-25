package defpackage;

import android.content.Context;
import android.view.ViewGroup;
import com.yunbao.live.bean.LiveBean;
import com.yunbao.main.activity.MainActivity;

/* loaded from: /tmp/classes2.dex */
public abstract class v0 extends y0 {
    public v0(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    public void getData() {
    }

    public void watchLive(LiveBean liveBean, String str, int i) {
        ((MainActivity) this.mContext).d3(liveBean, str, i);
    }
}
