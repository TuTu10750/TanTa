package defpackage;

import android.content.Context;
import android.os.Bundle;
import android.view.ViewGroup;
import io.anyrtc.live.ArLiveDef;
import io.anyrtc.live.ArLiveEngine;
import io.anyrtc.live.ArLivePusher;
import io.anyrtc.live.ArLivePusherObserver;
import io.anyrtc.live.internal.ArDeviceManagerImpl;
import org.webrtc.TextureViewRenderer;

/* loaded from: /tmp/classes2.dex */
public class u32 extends q0 {
    public ArLiveEngine b;
    public ArLivePusher c;
    public boolean d;
    public boolean e;

    /* loaded from: /tmp/classes2.dex */
    public class a extends ArLivePusherObserver {
        public a() {
        }

        @Override // io.anyrtc.live.ArLivePusherObserver
        public void onCaptureFirstAudioFrame() {
            lx1.c("LiveLinkMicPushTxViewHolder", "--onCaptureFirstAudioFrame: 获得首帧音频");
        }

        @Override // io.anyrtc.live.ArLivePusherObserver
        public void onCaptureFirstVideoFrame() {
            lx1.c("LiveLinkMicPushTxViewHolder", "--onCaptureFirstVideoFrame: 获得首帧视频");
            j42 j42Var = u32.this.a;
            if (j42Var != null) {
                j42Var.c();
            }
        }

        @Override // io.anyrtc.live.ArLivePusherObserver
        public void onError(int i, String str, Bundle bundle) {
            lx1.c("LiveLinkMicPushTxViewHolder", "--onError: code=" + i + ", msg= " + str);
        }

        @Override // io.anyrtc.live.ArLivePusherObserver
        public void onPushStatusUpdate(ArLiveDef.ArLivePushStatus arLivePushStatus, String str, Bundle bundle) {
            lx1.c("LiveLinkMicPushTxViewHolder", "--onPushStatusUpdate: msg=" + str);
            if (arLivePushStatus == ArLiveDef.ArLivePushStatus.ArLivePushStatusConnectSuccess) {
                if (u32.this.d) {
                    return;
                }
                u32.this.d = true;
                j42 j42Var = u32.this.a;
                if (j42Var != null) {
                    j42Var.b();
                }
                lx1.c("LiveLinkMicPushTxViewHolder", "onPushStatusUpdate--->推流成功");
                return;
            }
            if (arLivePushStatus == ArLiveDef.ArLivePushStatus.ArLivePushStatusDisconnected) {
                lx1.c("LiveLinkMicPushTxViewHolder", "onPushStatusUpdate--->网络断开，推流失败");
                j42 j42Var2 = u32.this.a;
                if (j42Var2 != null) {
                    j42Var2.a();
                }
            }
        }

        @Override // io.anyrtc.live.ArLivePusherObserver
        public void onWarning(int i, String str, Bundle bundle) {
            lx1.c("LiveLinkMicPushTxViewHolder", "--onWarning: code=" + i + ", msg= " + str);
        }
    }

    public u32(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
    }

    @Override // defpackage.q0
    public void F() {
        ArLivePusher arLivePusher = this.c;
        if (arLivePusher != null) {
            arLivePusher.stopMicrophone();
        }
    }

    @Override // defpackage.q0
    public void a0() {
    }

    @Override // defpackage.q0
    public void b0() {
    }

    @Override // defpackage.q0
    public void e0() {
        ArLivePusher arLivePusher = this.c;
        if (arLivePusher != null) {
            arLivePusher.startMicrophone();
        }
    }

    @Override // defpackage.q0
    public void f0(String str) {
        ArLivePusher arLivePusher = this.c;
        if (arLivePusher != null) {
            arLivePusher.startPush(str);
        }
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return x73.M1;
    }

    @Override // defpackage.b1
    public void init() {
        ArLiveEngine a2 = ra.a(this.mContext);
        this.b = a2;
        if (a2 == null) {
            return;
        }
        this.c = a2.createArLivePusher();
        ArLiveDef.ArLiveVideoEncoderParam arLiveVideoEncoderParam = new ArLiveDef.ArLiveVideoEncoderParam(ArLiveDef.ArLiveVideoResolution.ArLiveVideoResolution480x360);
        arLiveVideoEncoderParam.videoResolutionMode = ArLiveDef.ArLiveVideoResolutionMode.ArLiveVideoResolutionModePortrait;
        arLiveVideoEncoderParam.videoFps = 15;
        arLiveVideoEncoderParam.minVideoBitrate = 800;
        arLiveVideoEncoderParam.videoBitrate = 1500;
        this.c.setVideoQuality(arLiveVideoEncoderParam);
        this.c.setEncoderMirror(true);
        this.c.setObserver(new a());
        this.c.setRenderView((TextureViewRenderer) findViewById(b73.o1));
        this.c.startCamera(true);
        this.c.startMicrophone();
        this.e = true;
    }

    @Override // defpackage.q0, defpackage.b1
    public void release() {
        this.a = null;
        ArLivePusher arLivePusher = this.c;
        if (arLivePusher != null) {
            arLivePusher.stopPush();
            this.c.stopMicrophone();
            this.c.stopCamera();
            this.c.setObserver(null);
            this.c.releasePusher();
        }
        this.c = null;
        ra.b(this.b);
        this.b = null;
    }

    @Override // defpackage.q0
    public void y() {
        ArDeviceManagerImpl deviceManager;
        ArLivePusher arLivePusher = this.c;
        if (arLivePusher == null || (deviceManager = arLivePusher.getDeviceManager()) == null) {
            return;
        }
        this.e = !this.e;
        deviceManager.switchCamera();
        boolean z = this.e;
        ArLivePusher arLivePusher2 = this.c;
        if (z) {
            arLivePusher2.setEncoderMirror(true);
        } else {
            arLivePusher2.setEncoderMirror(false);
        }
    }
}
