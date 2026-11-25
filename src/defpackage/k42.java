package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.yunbao.common.bean.UserBean;
import com.yunbao.live.bean.LiveConfigBean;
import io.anyrtc.live.ArLiveDef;
import io.anyrtc.live.ArLiveEngine;
import io.anyrtc.live.ArLivePusher;
import io.anyrtc.live.ArLivePusherObserver;

/* loaded from: /tmp/classes2.dex */
public class k42 extends s0 implements n94 {
    public ArLiveEngine p;
    public ArLivePusher q;
    public boolean r;
    public boolean s;
    public boolean t;
    public boolean u;

    /* loaded from: /tmp/classes2.dex */
    public class a extends ArLivePusherObserver {
        public a() {
        }

        @Override // io.anyrtc.live.ArLivePusherObserver
        public void onCaptureFirstAudioFrame() {
            lx1.c(k42.this.a, "--onCaptureFirstAudioFrame: 获得首帧音频");
        }

        @Override // io.anyrtc.live.ArLivePusherObserver
        public void onCaptureFirstVideoFrame() {
            lx1.c(k42.this.a, "--onCaptureFirstVideoFrame: 获得首帧视频");
        }

        @Override // io.anyrtc.live.ArLivePusherObserver
        public void onError(int i, String str, Bundle bundle) {
            lx1.c(k42.this.a, "--onError: code=" + i + ", msg= " + str);
        }

        @Override // io.anyrtc.live.ArLivePusherObserver
        public void onPushStatusUpdate(ArLiveDef.ArLivePushStatus arLivePushStatus, String str, Bundle bundle) {
            lx1.c(k42.this.a, "--onPushStatusUpdate: msg=" + str);
            lx1.c(k42.this.a, "--onPushStatusUpdate: status=" + arLivePushStatus);
            if (arLivePushStatus != ArLiveDef.ArLivePushStatus.ArLivePushStatusConnectSuccess || k42.this.t) {
                return;
            }
            k42.this.t = true;
            j42 j42Var = k42.this.b;
            if (j42Var != null) {
                j42Var.b();
            }
            lx1.c(k42.this.a, "onPushStatusUpdate--->推流成功");
        }

        @Override // io.anyrtc.live.ArLivePusherObserver
        public void onWarning(int i, String str, Bundle bundle) {
            lx1.c(k42.this.a, "--onWarning: code=" + i + ", msg= " + str);
        }
    }

    public k42(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // defpackage.oh1
    public void C(String str, int i) {
        if (this.u) {
            return;
        }
        this.e = true;
        ArLivePusher arLivePusher = this.q;
        if (arLivePusher != null) {
            arLivePusher.startScreenCapture();
            this.q.startPush(str);
        }
        l0();
    }

    @Override // defpackage.oh1
    public void F() {
    }

    @Override // defpackage.oh1
    public void M(String str) {
    }

    @Override // defpackage.n94
    public void R(int i, String str, String str2) {
        if (i == 0) {
            r0(str, str2);
        } else {
            q0(str, str2);
        }
    }

    @Override // defpackage.oh1
    public void S() {
    }

    @Override // defpackage.nh1
    public void U() {
        View view = this.k;
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.width = gk3.a().c() / 2;
            layoutParams.height = zn0.a(250);
            layoutParams.topMargin = zn0.a(130);
            layoutParams.gravity = 48;
            this.k.setLayoutParams(layoutParams);
            j0(540);
        }
    }

    @Override // defpackage.s0
    public float b0() {
        return 0.0f;
    }

    @Override // defpackage.s0
    public void e0() {
        ArLivePusher arLivePusher = this.q;
        if (arLivePusher == null || this.k == null) {
            return;
        }
        arLivePusher.resumeVideo();
    }

    @Override // defpackage.s0
    public void g0(float f) {
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return x73.h2;
    }

    @Override // defpackage.s0, defpackage.b1
    public void init() {
        super.init();
        ImageView imageView = (ImageView) findViewById(b73.E3);
        UserBean D = j30.q().D();
        if (D != null) {
            kn1.h(this.mContext, D.getAvatar(), imageView);
        }
        this.u = false;
        ArLiveEngine a2 = ra.a(this.mContext);
        this.p = a2;
        if (a2 == null) {
            return;
        }
        this.q = a2.createArLivePusher();
        j0(0);
        this.q.setAudioQuality(ArLiveDef.ArLiveAudioQuality.ArLiveAudioQualityDefault);
        this.q.setObserver(new a());
        this.k = imageView;
        this.q.startMicrophone();
    }

    @Override // defpackage.s0
    public void j0(int i) {
        if (this.u || this.q == null) {
            return;
        }
        LiveConfigBean a2 = n12.a();
        if (i == 0) {
            i = a2.getTargetResolution();
        }
        this.q.setVideoQuality(i == 540 ? new ArLiveDef.ArLiveVideoEncoderParam(ArLiveDef.ArLiveVideoResolution.ArLiveVideoResolution960x540) : i == 720 ? new ArLiveDef.ArLiveVideoEncoderParam(ArLiveDef.ArLiveVideoResolution.ArLiveVideoResolution1280x720) : i == 1080 ? new ArLiveDef.ArLiveVideoEncoderParam(ArLiveDef.ArLiveVideoResolution.ArLiveVideoResolution1920x1080) : new ArLiveDef.ArLiveVideoEncoderParam(ArLiveDef.ArLiveVideoResolution.ArLiveVideoResolution960x540));
    }

    @Override // defpackage.nh1
    public void n() {
        View view = this.k;
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -1;
            layoutParams.topMargin = 0;
            this.k.setLayoutParams(layoutParams);
            j0(0);
        }
    }

    @Override // defpackage.s0
    public void n0() {
        if (this.q != null) {
            boolean z = this.r;
            this.r = !z;
            if (z) {
                t54.a(m93.g4);
            } else {
                t54.a(m93.f4);
            }
        }
    }

    @Override // defpackage.s0, defpackage.b1, defpackage.uy1
    public void onDestroy() {
        this.u = true;
        s0();
        super.onDestroy();
    }

    @Override // defpackage.oh1
    public void q() {
    }

    public final void q0(String str, String str2) {
    }

    public final void r0(String str, String str2) {
    }

    @Override // defpackage.s0, defpackage.b1
    public void release() {
        super.release();
        this.u = true;
        s0();
    }

    public final void s0() {
        ArLivePusher arLivePusher = this.q;
        if (arLivePusher != null) {
            if (arLivePusher.isPushing() == 1) {
                this.q.stopPush();
            }
            this.q.stopMicrophone();
            this.q.stopScreenCapture();
            this.q.setObserver(null);
            this.q.releasePusher();
        }
        this.q = null;
        ra.b(this.p);
        this.p = null;
    }

    @Override // defpackage.oh1
    public void v() {
        this.s = false;
    }

    @Override // defpackage.oh1
    public void y() {
    }
}
