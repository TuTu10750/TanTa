package defpackage;

import com.yunbao.live.activity.LiveActivity;
import com.yunbao.live.socket.SocketClient;

/* loaded from: /tmp/classes2.dex */
public class va1 implements ua1 {
    public LiveActivity a;
    public SocketClient b;

    public va1(LiveActivity liveActivity, SocketClient socketClient) {
        this.a = liveActivity;
        this.b = socketClient;
    }

    @Override // defpackage.ua1
    public void a(String str, String str2, String str3, int i) {
        kr3.c(this.b, str, str2, str3, i);
    }

    @Override // defpackage.ua1
    public void b(String str, String str2, String str3, int i) {
        kr3.g(this.b, str, str2, str3, i);
    }

    @Override // defpackage.ua1
    public void c() {
        kr3.f(this.b);
    }

    @Override // defpackage.ua1
    public void d(int i, int i2) {
        kr3.d(this.b, i, i2);
    }

    @Override // defpackage.ua1
    public void e(boolean z) {
        LiveActivity liveActivity = this.a;
        if (liveActivity != null) {
            liveActivity.w2(z);
        }
    }

    @Override // defpackage.ua1
    public void f(String str) {
        kr3.b(this.b, str);
    }

    @Override // defpackage.ua1
    public void g(int i, int i2) {
        kr3.h(this.b, i, i2);
    }

    @Override // defpackage.ua1
    public boolean h() {
        LiveActivity liveActivity = this.a;
        if (liveActivity != null) {
            return liveActivity.O1() || this.a.P1();
        }
        return false;
    }

    @Override // defpackage.ua1
    public void i() {
        kr3.a(this.b);
    }

    @Override // defpackage.ua1
    public void j(int i) {
        if (i == 1) {
            kr3.e(this.b);
        } else {
            if (i != 3) {
                return;
            }
            kr3.i(this.b);
        }
    }

    @Override // defpackage.ua1
    public void release() {
        this.b = null;
        this.a = null;
    }
}
