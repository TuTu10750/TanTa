package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.umeng.commonsdk.statistics.UMErrorCode;
import com.yunbao.common.http.CommonHttpConsts;
import com.yunbao.common.http.CommonHttpUtil;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.activity.LiveAnchorActivity;
import com.yunbao.live.bean.LiveConfigBean;
import defpackage.d12;
import io.anyrtc.live.ArLiveDef;
import io.anyrtc.live.ArLiveEngine;
import io.anyrtc.live.ArLivePusher;
import io.anyrtc.live.ArLivePusherObserver;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

/* loaded from: /tmp/classes2.dex */
public class o42 extends s0 implements n94 {
    public TextView A;
    public String B;
    public boolean C;
    public boolean D;
    public int E;
    public final Handler F;
    public int G;
    public int H;
    public int I;
    public ArLiveEngine p;
    public ArLivePusher q;
    public boolean r;
    public LiveConfigBean s;
    public boolean t;
    public d12 u;
    public final ArLiveDef.ArLiveVideoFrame v;
    public byte[] w;
    public int x;
    public int y;
    public LinearLayout z;

    /* loaded from: /tmp/classes2.dex */
    public class a extends ArLivePusherObserver {
        public a() {
        }

        @Override // io.anyrtc.live.ArLivePusherObserver
        public void onCaptureFirstAudioFrame() {
            lx1.c("9090", "ArLivePusherObserver--onCaptureFirstAudioFrame: 获得首帧音频");
        }

        @Override // io.anyrtc.live.ArLivePusherObserver
        public void onCaptureFirstVideoFrame() {
            lx1.c("9090", "ArLivePusherObserver--onCaptureFirstVideoFrame: 获得首帧视频");
            j42 j42Var = o42.this.b;
            if (j42Var != null) {
                j42Var.c();
            }
        }

        @Override // io.anyrtc.live.ArLivePusherObserver
        public void onError(int i, String str, Bundle bundle) {
            lx1.c("9090", "ArLivePusherObserver--onError: code=" + i + ", msg= " + str);
            if (str == null || !str.contains("Expired")) {
                lx1.c("9090", "推流失败，准备重试");
                o42.this.H0();
            } else {
                lx1.c("9090", "推流 URL 过期，请求新地址");
                o42.this.G0();
            }
        }

        @Override // io.anyrtc.live.ArLivePusherObserver
        public int onProcessVideoFrame(ArLiveDef.ArLiveVideoFrame arLiveVideoFrame, ArLiveDef.ArLiveVideoFrame arLiveVideoFrame2) {
            return 0;
        }

        @Override // io.anyrtc.live.ArLivePusherObserver
        public void onPushStatusUpdate(ArLiveDef.ArLivePushStatus arLivePushStatus, String str, Bundle bundle) {
            super.onPushStatusUpdate(arLivePushStatus, str, bundle);
            lx1.c("9090", "ArLivePusherObserver--onPushStatusUpdate: msg=" + str + ", status=" + arLivePushStatus);
            if (arLivePushStatus == ArLiveDef.ArLivePushStatus.ArLivePushStatusConnectSuccess) {
                lx1.c("9090", "onPushStatusUpdate---> 推流成功");
                if (!o42.this.t) {
                    o42.this.t = true;
                    j42 j42Var = o42.this.b;
                    if (j42Var != null) {
                        j42Var.b();
                    }
                }
                o42.this.E = 0;
                return;
            }
            if (arLivePushStatus == ArLiveDef.ArLivePushStatus.ArLivePushStatusDisconnected) {
                lx1.c("9090", "连接断开，获取新地址重新推流");
                o42.this.G0();
            } else if (arLivePushStatus == ArLiveDef.ArLivePushStatus.ArLivePushStatusReconnecting) {
                lx1.c("9090", "重连中。。。");
            } else if (arLivePushStatus == ArLiveDef.ArLivePushStatus.ArLivePushStatusConnecting) {
                lx1.c("9090", "正在连接推流服务器");
            }
        }

        @Override // io.anyrtc.live.ArLivePusherObserver
        public void onStatisticsUpdate(ArLiveDef.ArLivePusherStatistics arLivePusherStatistics) {
            lx1.c("9090", "[stats] " + arLivePusherStatistics.width + "x" + arLivePusherStatistics.height + " fps=" + arLivePusherStatistics.fps + " videoKbps=" + arLivePusherStatistics.videoBitrate + " audioKbps=" + arLivePusherStatistics.audioBitrate + " cpu=" + arLivePusherStatistics.appCpu + "/" + arLivePusherStatistics.systemCpu);
            o42.this.A0(arLivePusherStatistics);
        }

        @Override // io.anyrtc.live.ArLivePusherObserver
        public void onWarning(int i, String str, Bundle bundle) {
            lx1.c("9090", "ArLivePusherObserver--onWarning: code=" + i + ", msg= " + str);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends HttpCallback {
        public b() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (!o42.this.D && i == 0 && strArr.length > 0) {
                String string = JSON.parseObject(strArr[0]).getString("push");
                if (o42.this.q != null) {
                    o42.this.q.stopPush();
                }
                o42.this.E = 0;
                o42.this.C(string, 1);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends HttpCallback {
        public c() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            rp3.e().r(parseObject.getIntValue("skin_whiting"), parseObject.getIntValue("skin_smooth"), parseObject.getIntValue("skin_tenderness"));
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements fh1 {
        public d() {
        }

        @Override // defpackage.fh1
        public void a(int i, boolean z, int i2, boolean z2, int i3, boolean z3) {
        }

        @Override // defpackage.fh1
        public void b(Bitmap bitmap) {
            if (o42.this.u != null) {
                o42.this.u.M(bitmap);
            }
        }

        @Override // defpackage.fh1
        public void c(uh uhVar) {
            if (o42.this.u == null || uhVar == null) {
                return;
            }
            o42.this.u.V(uhVar);
        }

        @Override // defpackage.fh1
        public void d(t5 t5Var) {
            if (o42.this.u == null || t5Var == null) {
                return;
            }
            o42.this.u.U(t5Var);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends HttpCallback {
        public e() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
        }
    }

    public o42(Context context, ViewGroup viewGroup, LiveConfigBean liveConfigBean) {
        super(context, viewGroup, liveConfigBean);
        this.v = new ArLiveDef.ArLiveVideoFrame();
        this.x = 0;
        this.y = 0;
        this.F = new Handler(Looper.getMainLooper());
        this.G = 1;
        this.H = 0;
        this.I = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0() {
        this.F.removeCallbacksAndMessages(null);
        K0();
        ArLivePusher arLivePusher = this.q;
        if (arLivePusher != null) {
            if (arLivePusher.isPushing() == 1) {
                this.q.stopPush();
            }
            v();
            this.q.stopMicrophone();
            this.q.enableCustomVideoCapture(false);
            this.q.setObserver(null);
            this.q.releasePusher();
            rp3.e().l();
        }
        this.q = null;
        ra.b(this.p);
        this.p = null;
        ArLiveDef.ArLiveVideoFrame arLiveVideoFrame = this.v;
        arLiveVideoFrame.data = null;
        arLiveVideoFrame.buffer = null;
        this.w = null;
    }

    public static /* synthetic */ void o0(o42 o42Var) {
        ArLivePusher arLivePusher;
        if (o42Var.D || (arLivePusher = o42Var.q) == null) {
            return;
        }
        arLivePusher.stopPush();
        o42Var.q.startPush(o42Var.B);
    }

    public static /* synthetic */ void q0(o42 o42Var, ByteBuffer byteBuffer, int i, int i2, int i3) {
        if (o42Var.q == null) {
            return;
        }
        int i4 = ((i * i2) * 3) / 2;
        if (byteBuffer == null || byteBuffer.capacity() < i4) {
            StringBuilder sb = new StringBuilder("[sendCustomVideoFrame] invalid buffer, frameSize=");
            sb.append(i4);
            sb.append(", bufferCap=");
            sb.append(byteBuffer == null ? -1 : byteBuffer.capacity());
            lx1.c("9090", sb.toString());
            return;
        }
        byte[] bArr = o42Var.w;
        if (bArr == null || bArr.length != i4) {
            o42Var.w = new byte[i4];
        }
        ByteBuffer duplicate = byteBuffer.duplicate();
        duplicate.position(0);
        duplicate.limit(i4);
        duplicate.get(o42Var.w, 0, i4);
        ArLiveDef.ArLiveVideoFrame arLiveVideoFrame = o42Var.v;
        arLiveVideoFrame.pixelFormat = ArLiveDef.ArLivePixelFormat.ArLivePixelFormatI420;
        arLiveVideoFrame.bufferType = ArLiveDef.ArLiveBufferType.ArLiveBufferTypeByteArray;
        arLiveVideoFrame.data = o42Var.w;
        arLiveVideoFrame.buffer = byteBuffer;
        arLiveVideoFrame.width = i;
        arLiveVideoFrame.height = i2;
        arLiveVideoFrame.rotation = i3;
        arLiveVideoFrame.stride = i;
        int sendCustomVideoFrame = o42Var.q.sendCustomVideoFrame(arLiveVideoFrame);
        int i5 = o42Var.x + 1;
        o42Var.x = i5;
        if (i5 == 1) {
            StringBuilder sb2 = new StringBuilder("[sendCustomVideoFrame#1] ret=");
            sb2.append(sendCustomVideoFrame);
            sb2.append(" w=");
            sb2.append(i);
            sb2.append("x");
            sb2.append(i2);
            sb2.append(" dataLen=");
            sb2.append(o42Var.w.length);
            sb2.append(" bufCap=");
            sb2.append(byteBuffer.capacity());
            sb2.append(" isPushing=");
            sb2.append(o42Var.q.isPushing() == 1);
            lx1.c("9090", sb2.toString());
        } else if (sendCustomVideoFrame != 0 && sendCustomVideoFrame != o42Var.y) {
            lx1.c("9090", "[sendCustomVideoFrame] ret=" + sendCustomVideoFrame + " (changed from " + o42Var.y + ") count=" + o42Var.x);
        } else if (i5 % 60 == 0) {
            StringBuilder sb3 = new StringBuilder("[sendCustomVideoFrame] count=");
            sb3.append(o42Var.x);
            sb3.append(" ret=");
            sb3.append(sendCustomVideoFrame);
            sb3.append(" isPushing=");
            sb3.append(o42Var.q.isPushing() == 1);
            lx1.c("9090", sb3.toString());
        }
        o42Var.y = sendCustomVideoFrame;
    }

    public final void A0(ArLiveDef.ArLivePusherStatistics arLivePusherStatistics) {
        LiveConfigBean liveConfigBean;
        int i;
        int i2;
        if (this.q == null || (liveConfigBean = this.s) == null) {
            return;
        }
        int videoKBitrateMin = liveConfigBean.getVideoKBitrateMin();
        int videoKBitrateMax = this.s.getVideoKBitrateMax();
        int i3 = arLivePusherStatistics.videoBitrate;
        if (i3 <= 0) {
            return;
        }
        double d2 = i3;
        if (d2 < videoKBitrateMin * 0.8d) {
            this.I = 0;
            int i4 = this.H + 1;
            this.H = i4;
            if (i4 < 3 || (i2 = this.G) <= 0) {
                return;
            }
            this.G = i2 - 1;
            this.H = 0;
            B0(videoKBitrateMin, videoKBitrateMax);
            lx1.c("9090", "自适应码率：降档 → level=" + this.G);
            return;
        }
        if (d2 <= videoKBitrateMax * 0.9d) {
            this.H = 0;
            this.I = 0;
            return;
        }
        this.H = 0;
        int i5 = this.I + 1;
        this.I = i5;
        if (i5 < 5 || (i = this.G) >= 2) {
            return;
        }
        this.G = i + 1;
        this.I = 0;
        B0(videoKBitrateMin, videoKBitrateMax);
        lx1.c("9090", "自适应码率：升档 → level=" + this.G);
    }

    public final void B0(int i, int i2) {
        ArLiveDef.ArLiveVideoEncoderParam arLiveVideoEncoderParam = new ArLiveDef.ArLiveVideoEncoderParam(ArLiveDef.ArLiveVideoResolution.ArLiveVideoResolution960x540);
        arLiveVideoEncoderParam.videoFps = this.s.getTargetFps();
        int i3 = this.G;
        if (i3 == 0) {
            arLiveVideoEncoderParam.videoBitrate = i;
            arLiveVideoEncoderParam.minVideoBitrate = i / 2;
        } else if (i3 == 1) {
            arLiveVideoEncoderParam.videoBitrate = i2;
            arLiveVideoEncoderParam.minVideoBitrate = i;
        } else if (i3 == 2) {
            arLiveVideoEncoderParam.videoBitrate = Math.min((int) (i2 * 1.3d), 3000);
            arLiveVideoEncoderParam.minVideoBitrate = i2;
        }
        this.q.setVideoQuality(arLiveVideoEncoderParam);
    }

    @Override // defpackage.oh1
    public void C(String str, int i) {
        if (this.D) {
            return;
        }
        lx1.c("9090", "推流地址：" + str);
        this.e = true;
        this.B = str;
        ArLivePusher arLivePusher = this.q;
        if (arLivePusher != null) {
            int startPush = arLivePusher.startPush(str);
            lx1.c("9090", "推流启动结果：" + startPush);
            if (startPush == 0) {
                this.z.setVisibility(8);
                this.C = true;
                this.E = 0;
                if (i == 1) {
                    e32.a0(new e());
                }
            }
        }
        l0();
    }

    public final void C0() {
        d12 d12Var = this.u;
        if (d12Var == null || d12Var.D()) {
            return;
        }
        rp3 e2 = rp3.e();
        uh c2 = e2.c();
        if (c2 != null) {
            this.u.V(c2);
        }
        t5 b2 = e2.b();
        if (b2 != null) {
            this.u.U(b2);
        }
    }

    public final void D0() {
        if (this.D || this.q == null) {
            return;
        }
        J0();
        d12 d12Var = this.u;
        if (d12Var != null) {
            d12Var.J();
        }
    }

    public final void E0() {
        rp3.e().a().v(F0());
        rp3.e().k();
        rp3.e().j();
        CommonHttpUtil.getBeautyValue(new c());
    }

    @Override // defpackage.oh1
    public void F() {
        ArLivePusher arLivePusher = this.q;
        if (arLivePusher != null) {
            arLivePusher.muteAudio(true);
        }
    }

    public fh1 F0() {
        return new d();
    }

    public void G0() {
        if (this.D) {
            return;
        }
        this.z.setVisibility(0);
        this.A.setText("重连中...");
        e32.b0(new b());
    }

    public final void H0() {
        if (this.D || !this.C) {
            return;
        }
        int i = this.E;
        if (i >= 5) {
            lx1.c("9090", "重连已达上限 5 次，结束直播");
            Object obj = this.mContext;
            if (obj == null || !(obj instanceof LiveAnchorActivity)) {
                return;
            }
            ((LiveAnchorActivity) obj).q3(2);
            return;
        }
        this.E = i + 1;
        int min = (int) Math.min(Math.pow(2.0d, i) * 1000.0d, 30000.0d);
        lx1.c("9090", "推流重连中，第 " + this.E + " 次尝试，" + min + "ms 后重连");
        this.F.postDelayed(new Runnable() { // from class: n42
            @Override // java.lang.Runnable
            public final void run() {
                o42.o0(o42.this);
            }
        }, (long) min);
    }

    public final void J0() {
        int i;
        int i2;
        int i3;
        if (this.D || !(this.k instanceof TextureView)) {
            return;
        }
        d12 d12Var = this.u;
        if (d12Var != null) {
            if (!d12Var.D()) {
                return;
            } else {
                this.u = null;
            }
        }
        LiveConfigBean liveConfigBean = this.s;
        int targetResolution = liveConfigBean != null ? liveConfigBean.getTargetResolution() : 720;
        int i4 = 540;
        if (targetResolution == 540) {
            i3 = 960;
        } else {
            i4 = 1080;
            if (targetResolution != 1080) {
                i = 1280;
                i2 = 720;
                d12 d12Var2 = new d12(this.mContext, (TextureView) this.k, i2, i, new d12.c() { // from class: m42
                    @Override // d12.c
                    public final void a(ByteBuffer byteBuffer, int i5, int i6, int i7) {
                        o42.q0(o42.this, byteBuffer, i5, i6, i7);
                    }
                });
                this.u = d12Var2;
                d12Var2.Q(this.c);
                C0();
            }
            i3 = 1920;
        }
        i = i3;
        i2 = i4;
        d12 d12Var22 = new d12(this.mContext, (TextureView) this.k, i2, i, new d12.c() { // from class: m42
            @Override // d12.c
            public final void a(ByteBuffer byteBuffer, int i5, int i6, int i7) {
                o42.q0(o42.this, byteBuffer, i5, i6, i7);
            }
        });
        this.u = d12Var22;
        d12Var22.Q(this.c);
        C0();
    }

    public final void K0() {
        d12 d12Var = this.u;
        if (d12Var != null) {
            d12Var.I();
            this.u = null;
        }
    }

    @Override // defpackage.oh1
    public void M(String str) {
    }

    @Override // defpackage.n94
    public void R(int i, String str, String str2) {
    }

    @Override // defpackage.oh1
    public void S() {
        ArLivePusher arLivePusher = this.q;
        if (arLivePusher != null) {
            arLivePusher.muteAudio(false);
        }
    }

    @Override // defpackage.nh1
    public void U() {
        View view = this.k;
        if (view != null) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            int c2 = gk3.a().c() / 2;
            layoutParams.width = c2;
            layoutParams.height = ((int) ((c2 / 540.0f) * 960.0f)) - zn0.a(20);
            layoutParams.topMargin = zn0.a(UMErrorCode.E_UM_BE_FILE_OVERSIZE);
            this.k.setLayoutParams(layoutParams);
            j0(540);
        }
    }

    @Override // defpackage.s0
    public float b0() {
        d12 d12Var = this.u;
        if (d12Var != null) {
            return d12Var.y();
        }
        return 1.0f;
    }

    @Override // defpackage.s0
    public void e0() {
    }

    @Override // defpackage.s0
    public void f0(String str) {
        lx1.c(this.a, "sendSeiMessage: " + str);
        if (this.q != null) {
            try {
                byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
                if (bytes.length > 0) {
                    this.q.sendSeiMessage(242, bytes);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Override // defpackage.s0
    public void g0(float f) {
        d12 d12Var = this.u;
        if (d12Var != null) {
            float y = d12Var.y();
            if (f > y) {
                f = y;
            }
            this.u.O(f);
        }
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return x73.g2;
    }

    @Override // defpackage.s0, defpackage.b1
    public void init() {
        super.init();
        this.D = false;
        ArLiveEngine a2 = ra.a(this.mContext);
        this.p = a2;
        if (a2 == null) {
            return;
        }
        this.q = a2.createArLivePusher();
        this.z = (LinearLayout) findViewById(b73.I3);
        this.A = (TextView) findViewById(b73.z5);
        this.k = findViewById(b73.o1);
        j0(0);
        this.r = true;
        this.q.setObserver(new a());
        lx1.c("9090", "[enableCustomVideoCapture] ret=" + this.q.enableCustomVideoCapture(true));
        this.q.startMicrophone();
        J0();
        j42 j42Var = this.b;
        if (j42Var != null) {
            j42Var.c();
        }
        E0();
    }

    @Override // defpackage.s0
    public void j0(int i) {
        if (this.D) {
            return;
        }
        if (this.q == null) {
            ArLiveEngine a2 = ra.a(this.mContext);
            this.p = a2;
            if (a2 == null) {
                return;
            } else {
                this.q = a2.createArLivePusher();
            }
        }
        if (i == 0) {
            i = this.s.getTargetResolution();
        }
        lx1.c("9888", "mResolution:" + i);
        ArLiveDef.ArLiveVideoEncoderParam arLiveVideoEncoderParam = i == 540 ? new ArLiveDef.ArLiveVideoEncoderParam(ArLiveDef.ArLiveVideoResolution.ArLiveVideoResolution960x540) : i == 720 ? new ArLiveDef.ArLiveVideoEncoderParam(ArLiveDef.ArLiveVideoResolution.ArLiveVideoResolution1280x720) : i == 1080 ? new ArLiveDef.ArLiveVideoEncoderParam(ArLiveDef.ArLiveVideoResolution.ArLiveVideoResolution1920x1080) : new ArLiveDef.ArLiveVideoEncoderParam(ArLiveDef.ArLiveVideoResolution.ArLiveVideoResolution960x540);
        arLiveVideoEncoderParam.videoFps = this.s.getTargetFps();
        arLiveVideoEncoderParam.minVideoBitrate = this.s.getVideoKBitrateMin();
        arLiveVideoEncoderParam.videoBitrate = this.s.getVideoKBitrateMax();
        this.q.setAudioQuality(ArLiveDef.ArLiveAudioQuality.ArLiveAudioQualityMusic);
        this.q.setVideoQuality(arLiveVideoEncoderParam);
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
        boolean z = this.r;
        this.r = !z;
        d12 d12Var = this.u;
        if (d12Var != null) {
            d12Var.N(!z && this.c, this.c);
        }
        t54.a(!this.r ? m93.g4 : m93.f4);
    }

    @Override // defpackage.s0, defpackage.b1, defpackage.uy1
    public void onDestroy() {
        this.D = true;
        this.C = false;
        I0();
        super.onDestroy();
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onResume() {
        super.onResume();
        D0();
    }

    @Override // defpackage.b1
    public void processArguments(Object... objArr) {
        if (objArr.length > 0) {
            this.s = (LiveConfigBean) objArr[0];
        }
    }

    @Override // defpackage.oh1
    public void q() {
        if (this.c) {
            t54.a(m93.k4);
            return;
        }
        d12 d12Var = this.u;
        if (d12Var != null) {
            boolean z = !this.d;
            this.d = z;
            d12Var.w(z);
        }
    }

    @Override // defpackage.s0, defpackage.b1
    public void release() {
        super.release();
        CommonHttpUtil.cancel(CommonHttpConsts.GET_BEAUTY_VALUE);
        e32.f("linkMicTxMixStream");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("method", "endlive");
        f0(jSONObject.toJSONString());
        this.D = true;
        this.C = false;
        this.e = false;
        K0();
        this.F.removeCallbacksAndMessages(null);
        this.F.postDelayed(new Runnable() { // from class: l42
            @Override // java.lang.Runnable
            public final void run() {
                o42.this.I0();
            }
        }, 500L);
    }

    @Override // defpackage.oh1
    public void v() {
    }

    @Override // defpackage.oh1
    public void y() {
        d12 d12Var = this.u;
        if (d12Var == null) {
            return;
        }
        if (this.d) {
            d12Var.w(false);
            this.d = false;
        }
        this.c = !this.c;
        this.u.S();
    }
}
