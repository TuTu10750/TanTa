package defpackage;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.activity.LiveActivity;
import com.yunbao.live.activity.LiveAnchorActivity;
import com.yunbao.live.bean.LiveVoiceControlBean;
import defpackage.o62;
import java.util.Arrays;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: /tmp/classes2.dex */
public class p62 extends l0 implements o62.c {
    public o62 A0;
    public String z0;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public a() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                List parseArray = JSON.parseArray(Arrays.toString(strArr), LiveVoiceControlBean.class);
                RecyclerView k2 = p62.this.k2(b73.B4);
                if (k2 != null) {
                    k2.setLayoutManager(new LinearLayoutManager(p62.this.x0, 1, false));
                    p62 p62Var = p62.this;
                    p62Var.A0 = new o62(p62Var.x0, parseArray);
                    p62.this.A0.e0(p62.this);
                    k2.setAdapter(p62.this.A0);
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public final /* synthetic */ LiveVoiceControlBean a;

        public b(LiveVoiceControlBean liveVoiceControlBean) {
            this.a = liveVoiceControlBean;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0 && p62.this.x0 != null) {
                ((LiveAnchorActivity) p62.this.x0).z1(this.a.getUid(), this.a.getPosition(), 2);
            }
            t54.b(str);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends HttpCallback {
        public final /* synthetic */ LiveVoiceControlBean a;

        public c(LiveVoiceControlBean liveVoiceControlBean) {
            this.a = liveVoiceControlBean;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0 && p62.this.x0 != null) {
                ((LiveAnchorActivity) p62.this.x0).z1(this.a.getUid(), this.a.getPosition(), 0);
            }
            t54.b(str);
        }
    }

    @Override // defpackage.l0
    public void C0() {
        zu0.c().p(this);
        this.x0 = null;
        e32.f("getVoiceControlList");
        e32.f("banEmptyMicPosition");
        super.C0();
    }

    @Override // o62.c
    public void c(LiveVoiceControlBean liveVoiceControlBean) {
        Object obj;
        if (liveVoiceControlBean.getStatus() == 0) {
            e32.d(this.z0, liveVoiceControlBean.getPosition(), 0, new b(liveVoiceControlBean));
            return;
        }
        if (liveVoiceControlBean.getStatus() == 2) {
            e32.d(this.z0, liveVoiceControlBean.getPosition(), 1, new c(liveVoiceControlBean));
        } else if ((liveVoiceControlBean.getStatus() == 1 || liveVoiceControlBean.getStatus() == -1) && (obj = this.x0) != null) {
            ((LiveActivity) obj).x1(liveVoiceControlBean.getUid());
        }
    }

    @Override // o62.c
    public void e(LiveVoiceControlBean liveVoiceControlBean) {
        Object obj = this.x0;
        if (obj != null) {
            ((LiveActivity) obj).y1(liveVoiceControlBean.getUid(), 1);
        }
    }

    @Override // defpackage.l0
    public boolean f2() {
        return true;
    }

    @Override // defpackage.l0
    public int l2() {
        return s93.d;
    }

    @Override // defpackage.l0
    public int m2() {
        return x73.f0;
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onLiveVoiceMicStatusEvent(u62 u62Var) {
        o62 o62Var = this.A0;
        if (o62Var != null) {
            o62Var.d0(u62Var.a(), u62Var.b());
        }
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        window.setWindowAnimations(s93.b);
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = -1;
        attributes.height = -2;
        attributes.gravity = 80;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        zu0.c().n(this);
        Bundle z = z();
        if (z == null) {
            return;
        }
        String string = z.getString("liveStream");
        this.z0 = string;
        e32.j0(string, new a());
    }
}
