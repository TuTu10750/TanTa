package defpackage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import android.view.TextureView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.Collections;
import java.util.Objects;
import org.webrtc.VideoFrame;
import org.webrtc.YuvConverter;

/* loaded from: /tmp/classes2.dex */
public class d12 extends HandlerThread implements TextureView.SurfaceTextureListener, SurfaceTexture.OnFrameAvailableListener {
    public fa1 A;
    public aa1 B;
    public z91 C;
    public la1 D;
    public YuvConverter E;
    public la1 F;
    public int G;
    public int H;
    public ByteBuffer I;
    public FloatBuffer J;
    public FloatBuffer K;
    public FloatBuffer L;
    public FloatBuffer M;
    public volatile FloatBuffer N;
    public volatile Bitmap O;
    public volatile boolean P;
    public volatile boolean Q;
    public volatile boolean R;
    public volatile uh S;
    public volatile t5 T;
    public SurfaceTexture U;
    public int V;
    public int W;
    public boolean X;
    public volatile boolean Y;
    public int Z;
    public final Context a;
    public final TextureView b;
    public final int c;
    public final int d;
    public final c e;
    public Handler f;
    public long f0;
    public cs0 g;
    public byte[] g0;
    public xp4 h;
    public CameraDevice i;
    public CameraCaptureSession j;
    public SurfaceTexture k;
    public Surface l;
    public int m;
    public final float[] n;
    public HandlerThread o;
    public Handler p;
    public boolean q;
    public volatile boolean r;
    public int s;
    public int t;
    public CaptureRequest.Builder u;
    public volatile float v;
    public volatile boolean w;
    public float x;
    public int y;
    public ra1 z;

    /* loaded from: /tmp/classes2.dex */
    public class a extends CameraDevice.StateCallback {
        public a() {
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onDisconnected(CameraDevice cameraDevice) {
            cameraDevice.close();
            d12.this.i = null;
            d12.this.r = true;
            lx1.c("LiveBeautyGL", "camera disconnected");
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onError(CameraDevice cameraDevice, int i) {
            cameraDevice.close();
            d12.this.i = null;
            d12.this.r = true;
            lx1.c("LiveBeautyGL", "camera error=" + i);
        }

        @Override // android.hardware.camera2.CameraDevice.StateCallback
        public void onOpened(CameraDevice cameraDevice) {
            if (d12.this.Y) {
                cameraDevice.close();
                return;
            }
            d12.this.r = false;
            d12.this.i = cameraDevice;
            d12.this.n();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends CameraCaptureSession.StateCallback {
        public b() {
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
            d12.this.r = true;
            lx1.c("LiveBeautyGL", "createCaptureSession failed");
        }

        @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
            d12.this.j = cameraCaptureSession;
            d12.this.R();
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface c {
        void a(ByteBuffer byteBuffer, int i, int i2, int i3);
    }

    public d12(Context context, TextureView textureView, int i, int i2, c cVar) {
        super("LiveBeautyGL");
        this.m = -1;
        this.n = new float[16];
        this.r = false;
        this.v = 1.0f;
        this.w = false;
        this.x = 1.0f;
        this.y = 90;
        this.G = -1;
        this.H = -1;
        this.P = false;
        this.Q = false;
        this.R = false;
        this.X = false;
        this.Y = false;
        this.Z = 0;
        this.f0 = 0L;
        this.a = context;
        this.b = textureView;
        this.c = i;
        this.d = i2;
        this.e = cVar;
    }

    public static void E(String str) {
        Runtime runtime = Runtime.getRuntime();
        lx1.c("MEM_LOG", "[" + str + "] used=" + (((runtime.totalMemory() - runtime.freeMemory()) / 1024) / 1024) + "MB total=" + ((runtime.totalMemory() / 1024) / 1024) + "MB max=" + ((runtime.maxMemory() / 1024) / 1024) + "MB");
    }

    public static void K(Runnable runnable) {
        try {
            runnable.run();
        } catch (Throwable unused) {
        }
    }

    public static FloatBuffer T(float[] fArr) {
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        asFloatBuffer.put(fArr).position(0);
        return asFloatBuffer;
    }

    public static float[] z(int i, boolean z) {
        return i != 90 ? i != 180 ? i != 270 ? p34.f : z ? p34.b : p34.e : p34.d : z ? p34.e : p34.b;
    }

    public final void A(String str, RuntimeException runtimeException) {
        lx1.c("LiveBeautyGL", str + ": GL runtime failed, release render thread: " + runtimeException.getMessage());
        this.Y = true;
        this.X = false;
        Handler handler = this.f;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        s();
    }

    public final boolean B(Message message) {
        if (message.what == 5) {
            s();
            return true;
        }
        if (this.Y) {
            return true;
        }
        try {
            int i = message.what;
            if (i == 1) {
                F();
            } else if (i != 2) {
                if (i == 3) {
                    k();
                } else if (i != 4) {
                    switch (i) {
                        case 8:
                            r();
                            break;
                        case 9:
                            t();
                            break;
                        case 10:
                            j();
                            break;
                    }
                } else {
                    u();
                }
            } else if (this.X) {
                v();
            }
        } catch (RuntimeException e) {
            A("msg=" + message.what, e);
        }
        return true;
    }

    public final boolean C() {
        if (this.k == null || this.h == null || this.z == null || this.A == null || this.D == null) {
            return false;
        }
        if (this.e != null) {
            return (this.F == null || this.E == null || this.H == -1 || this.G == -1 || this.I == null) ? false : true;
        }
        return true;
    }

    public boolean D() {
        return this.Y;
    }

    public final void F() {
        if (this.Y || this.U == null) {
            return;
        }
        cs0 cs0Var = new cs0(null, 3);
        this.g = cs0Var;
        xp4 xp4Var = new xp4(cs0Var, this.U);
        this.h = xp4Var;
        xp4Var.b();
        this.m = yt2.f(36197);
        this.k = new SurfaceTexture(this.m);
        W();
        this.k.setOnFrameAvailableListener(this, this.f);
        this.l = new Surface(this.k);
        this.J = T(p34.a);
        this.y = p(this.q);
        this.x = H(this.q);
        this.K = T(z(this.y, this.q));
        this.L = T(p34.b);
        this.M = T(p34.c);
        lx1.c("LiveBeautyGL", "[init] fbo=" + this.c + "x" + this.d + " cam=" + this.s + "x" + this.t + " preview=" + this.V + "x" + this.W + " sensor=" + this.y + "° front=" + this.q);
        ra1 ra1Var = new ra1(this.a);
        this.z = ra1Var;
        ra1Var.q(this.c, this.d);
        this.z.i(this.c, this.d);
        fa1 fa1Var = new fa1(this.a);
        this.A = fa1Var;
        fa1Var.q(this.c, this.d);
        this.A.i(this.c, this.d);
        this.A.z(new uh());
        aa1 aa1Var = new aa1(this.a);
        this.B = aa1Var;
        aa1Var.q(this.c, this.d);
        this.B.i(this.c, this.d);
        z91 z91Var = new z91(this.a);
        this.C = z91Var;
        z91Var.q(this.c, this.d);
        this.C.i(this.c, this.d);
        la1 la1Var = new la1(this.a);
        this.D = la1Var;
        la1Var.q(this.c, this.d);
        this.D.l(this.V, this.W);
        m();
        la1 la1Var2 = new la1(this.a);
        this.F = la1Var2;
        la1Var2.q(this.c, this.d);
        this.F.l(this.c, this.d);
        o(this.c, this.d);
        this.E = new YuvConverter();
        this.I = ByteBuffer.allocateDirect(((this.c * this.d) * 3) / 2).order(ByteOrder.nativeOrder());
        k();
        j();
        r();
        P(this.q);
        this.X = true;
        E("renderThread.init");
    }

    public final void G(VideoFrame.I420Buffer i420Buffer) {
        int width = i420Buffer.getWidth();
        int height = i420Buffer.getHeight();
        int i = (width + 1) / 2;
        int i2 = (height + 1) / 2;
        ByteBuffer dataY = i420Buffer.getDataY();
        ByteBuffer dataU = i420Buffer.getDataU();
        ByteBuffer dataV = i420Buffer.getDataV();
        int strideY = i420Buffer.getStrideY();
        int strideU = i420Buffer.getStrideU();
        int strideV = i420Buffer.getStrideV();
        byte[] bArr = this.g0;
        if (bArr == null || bArr.length < width) {
            this.g0 = new byte[width];
        }
        this.I.clear();
        for (int i3 = 0; i3 < height; i3++) {
            dataY.position(i3 * strideY);
            dataY.get(this.g0, 0, width);
            this.I.put(this.g0, 0, width);
        }
        for (int i4 = 0; i4 < i2; i4++) {
            dataU.position(i4 * strideU);
            dataU.get(this.g0, 0, i);
            this.I.put(this.g0, 0, i);
        }
        for (int i5 = 0; i5 < i2; i5++) {
            dataV.position(i5 * strideV);
            dataV.get(this.g0, 0, i);
            this.I.put(this.g0, 0, i);
        }
        this.I.position(0);
        this.I.limit(((width * height) * 3) / 2);
    }

    public final float H(boolean z) {
        CameraCharacteristics cameraCharacteristics;
        Range range;
        try {
            CameraManager cameraManager = (CameraManager) this.a.getSystemService("camera");
            cameraCharacteristics = cameraManager.getCameraCharacteristics(x(cameraManager, z));
        } catch (Exception unused) {
        }
        if (Build.VERSION.SDK_INT >= 30 && (range = (Range) cameraCharacteristics.get(c7.a())) != null) {
            return ((Float) range.getUpper()).floatValue();
        }
        Float f = (Float) cameraCharacteristics.get(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM);
        if (f != null) {
            return f.floatValue();
        }
        return 1.0f;
    }

    public void I() {
        this.Y = true;
        this.X = false;
        Handler handler = this.f;
        if (handler == null) {
            quitSafely();
        } else {
            handler.removeCallbacksAndMessages(null);
            handler.sendMessageAtFrontOfQueue(handler.obtainMessage(5));
        }
    }

    public void J() {
        if (this.Y || !this.r) {
            return;
        }
        L(9);
    }

    public final void L(int i) {
        Handler handler = this.f;
        if (this.Y || handler == null) {
            return;
        }
        handler.sendEmptyMessage(i);
    }

    public void M(Bitmap bitmap) {
        if (this.Y) {
            return;
        }
        this.O = bitmap;
        this.P = true;
        L(8);
    }

    public void N(boolean z, boolean z2) {
        this.Q = z;
        this.R = z2;
    }

    public void O(float f) {
        if (this.Y) {
            return;
        }
        this.v = f;
        Handler handler = this.p;
        if (handler != null) {
            handler.post(new v02(this));
        }
    }

    public final void P(boolean z) {
        if (this.Y || this.l == null) {
            return;
        }
        this.q = z;
        HandlerThread handlerThread = new HandlerThread("CameraThread");
        this.o = handlerThread;
        handlerThread.start();
        this.p = new Handler(this.o.getLooper());
        try {
            CameraManager cameraManager = (CameraManager) this.a.getSystemService("camera");
            cameraManager.openCamera(x(cameraManager, z), new a(), this.p);
        } catch (Exception e) {
            this.r = true;
            lx1.c("LiveBeautyGL", "openCamera: " + e.getMessage());
        }
    }

    public void Q(boolean z) {
        this.Y = false;
        this.q = z;
        start();
        this.f = new Handler(getLooper(), new Handler.Callback() { // from class: w02
            @Override // android.os.Handler.Callback
            public final boolean handleMessage(Message message) {
                boolean B;
                B = d12.this.B(message);
                return B;
            }
        });
        this.b.setSurfaceTextureListener(this);
        if (this.b.isAvailable()) {
            onSurfaceTextureAvailable(this.b.getSurfaceTexture(), this.b.getWidth(), this.b.getHeight());
        }
    }

    public final void R() {
        try {
            CaptureRequest.Builder createCaptureRequest = this.i.createCaptureRequest(3);
            this.u = createCaptureRequest;
            createCaptureRequest.addTarget(this.l);
            this.u.set(CaptureRequest.CONTROL_AF_MODE, 3);
            q();
        } catch (Exception e) {
            this.r = true;
            lx1.c("LiveBeautyGL", "startRepeating: " + e.getMessage());
        }
    }

    public void S() {
        L(4);
    }

    public void U(t5 t5Var) {
        if (this.Y) {
            return;
        }
        this.T = t5Var;
        L(10);
    }

    public void V(uh uhVar) {
        if (this.Y) {
            return;
        }
        this.S = uhVar;
        L(3);
    }

    public final void W() {
        Size[] outputSizes;
        if (this.k == null) {
            return;
        }
        try {
            CameraManager cameraManager = (CameraManager) this.a.getSystemService("camera");
            String x = x(cameraManager, this.q);
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) cameraManager.getCameraCharacteristics(x).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            int i = this.d;
            int i2 = this.c;
            float f = i / i2;
            long j = i2 * i;
            Size size = null;
            float f2 = Float.MAX_VALUE;
            if (streamConfigurationMap != null && (outputSizes = streamConfigurationMap.getOutputSizes(SurfaceTexture.class)) != null) {
                int length = outputSizes.length;
                long j2 = Long.MAX_VALUE;
                int i3 = 0;
                while (i3 < length) {
                    Size size2 = outputSizes[i3];
                    float abs = Math.abs((size2.getWidth() / size2.getHeight()) - f);
                    Size size3 = size;
                    float f3 = f;
                    long abs2 = Math.abs((size2.getHeight() * size2.getWidth()) - j);
                    if (abs + 0.02f >= f2 && (Math.abs(abs - f2) >= 0.02f || abs2 >= j2)) {
                        size = size3;
                        i3++;
                        f = f3;
                    }
                    j2 = abs2;
                    size = size2;
                    f2 = abs;
                    i3++;
                    f = f3;
                }
            }
            if (size == null) {
                size = new Size(this.d, this.c);
            }
            this.s = size.getWidth();
            int height = size.getHeight();
            this.t = height;
            this.k.setDefaultBufferSize(this.s, height);
            lx1.c("LiveBeautyGL", "[bufferSize] id=" + x + " chosen=" + this.s + "x" + this.t + " ratioDiff=" + String.format("%.3f", Float.valueOf(f2)));
        } catch (Exception e) {
            int i4 = this.d;
            this.s = i4;
            int i5 = this.c;
            this.t = i5;
            this.k.setDefaultBufferSize(i4, i5);
            lx1.c("LiveBeautyGL", "updateCameraBufferSize fallback: " + e.getMessage());
        }
    }

    public final void i() {
        try {
            CameraManager cameraManager = (CameraManager) this.a.getSystemService("camera");
            Rect rect = (Rect) cameraManager.getCameraCharacteristics(x(cameraManager, this.q)).get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
            if (rect == null) {
                return;
            }
            int width = (int) (rect.width() / this.v);
            int height = (int) (rect.height() / this.v);
            int width2 = (rect.width() - width) / 2;
            int height2 = (rect.height() - height) / 2;
            this.u.set(CaptureRequest.SCALER_CROP_REGION, new Rect(width2, height2, width + width2, height + height2));
        } catch (Exception e) {
            lx1.c("LiveBeautyGL", "applyCropZoom: " + e.getMessage());
        }
    }

    public final void j() {
        if (this.B == null || this.T == null) {
            return;
        }
        this.B.z(this.T);
    }

    public final void k() {
        if (this.A == null || this.S == null) {
            return;
        }
        this.A.z(this.S);
    }

    public final void l() {
        CameraCaptureSession cameraCaptureSession = this.j;
        if (cameraCaptureSession != null) {
            cameraCaptureSession.close();
            this.j = null;
        }
        CameraDevice cameraDevice = this.i;
        if (cameraDevice != null) {
            cameraDevice.close();
            this.i = null;
        }
        this.u = null;
        HandlerThread handlerThread = this.o;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            try {
                this.o.join(500L);
            } catch (InterruptedException unused) {
            }
            this.o = null;
            this.p = null;
        }
    }

    public final void m() {
        int i;
        int i2 = this.V;
        if (i2 <= 0 || (i = this.W) <= 0) {
            return;
        }
        float max = Math.max(i2 / this.c, i / this.d);
        float f = (this.c * max) / this.V;
        float f2 = (this.d * max) / this.W;
        float f3 = -f;
        float f4 = -f2;
        this.N = T(new float[]{f3, f4, f, f4, f3, f2, f, f2});
    }

    public final void n() {
        try {
            this.i.createCaptureSession(Collections.singletonList(this.l), new b(), this.p);
        } catch (Exception e) {
            this.r = true;
            lx1.c("LiveBeautyGL", "createCaptureSession: " + e.getMessage());
        }
    }

    public final void o(int i, int i2) {
        int[] iArr = new int[1];
        int[] iArr2 = new int[1];
        GLES20.glGenTextures(1, iArr, 0);
        int i3 = iArr[0];
        this.G = i3;
        GLES20.glBindTexture(3553, i3);
        GLES20.glTexImage2D(3553, 0, 6408, i, i2, 0, 6408, 5121, null);
        GLES20.glTexParameteri(3553, 10241, 9729);
        GLES20.glTexParameteri(3553, 10240, 9729);
        GLES20.glTexParameteri(3553, 10242, 33071);
        GLES20.glTexParameteri(3553, 10243, 33071);
        GLES20.glGenFramebuffers(1, iArr2, 0);
        int i4 = iArr2[0];
        this.H = i4;
        GLES20.glBindFramebuffer(36160, i4);
        GLES20.glFramebufferTexture2D(36160, 36064, 3553, this.G, 0);
        GLES20.glBindFramebuffer(36160, 0);
        GLES20.glBindTexture(3553, 0);
    }

    @Override // android.graphics.SurfaceTexture.OnFrameAvailableListener
    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
        if (this.Y || !this.X) {
            return;
        }
        L(2);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.Y) {
            return;
        }
        lx1.c("LiveBeautyGL", "[previewAvailable] " + i + "x" + i2);
        this.U = surfaceTexture;
        this.V = i;
        this.W = i2;
        L(1);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        I();
        return true;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        if (this.Y) {
            return;
        }
        lx1.c("LiveBeautyGL", "[previewResize] " + this.V + "x" + this.W + " -> " + i + "x" + i2);
        this.V = i;
        this.W = i2;
        la1 la1Var = this.D;
        if (la1Var != null) {
            la1Var.l(i, i2);
        }
        m();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public final int p(boolean z) {
        try {
            CameraManager cameraManager = (CameraManager) this.a.getSystemService("camera");
            Integer num = (Integer) cameraManager.getCameraCharacteristics(x(cameraManager, z)).get(CameraCharacteristics.SENSOR_ORIENTATION);
            if (num != null) {
                return num.intValue();
            }
        } catch (Exception unused) {
        }
        return 90;
    }

    public final void q() {
        CaptureRequest.Builder builder = this.u;
        if (builder == null || this.j == null || this.i == null) {
            return;
        }
        try {
            builder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(this.w ? 2 : 0));
            if (Build.VERSION.SDK_INT >= 30) {
                this.u.set(b7.a(), Float.valueOf(this.v));
            } else {
                i();
            }
            this.j.setRepeatingRequest(this.u.build(), null, this.p);
        } catch (Exception e) {
            this.r = true;
            lx1.c("LiveBeautyGL", "doApplyCameraSettings: " + e.getMessage());
        }
    }

    public final void r() {
        if (!this.P || this.C == null) {
            return;
        }
        this.P = false;
        this.C.z(this.O);
    }

    public final void s() {
        this.Y = true;
        E("renderThread.release.before");
        this.X = false;
        Handler handler = this.f;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        l();
        Surface surface = this.l;
        if (surface != null) {
            surface.release();
            this.l = null;
        }
        SurfaceTexture surfaceTexture = this.k;
        if (surfaceTexture != null) {
            surfaceTexture.release();
            this.k = null;
        }
        xp4 xp4Var = this.h;
        if (xp4Var != null) {
            try {
                xp4Var.b();
                final ra1 ra1Var = this.z;
                if (ra1Var != null) {
                    Objects.requireNonNull(ra1Var);
                    K(new Runnable() { // from class: x02
                        @Override // java.lang.Runnable
                        public final void run() {
                            ra1Var.r();
                        }
                    });
                }
                final fa1 fa1Var = this.A;
                if (fa1Var != null) {
                    Objects.requireNonNull(fa1Var);
                    K(new Runnable() { // from class: y02
                        @Override // java.lang.Runnable
                        public final void run() {
                            fa1Var.r();
                        }
                    });
                }
                final aa1 aa1Var = this.B;
                if (aa1Var != null) {
                    Objects.requireNonNull(aa1Var);
                    K(new Runnable() { // from class: z02
                        @Override // java.lang.Runnable
                        public final void run() {
                            aa1Var.r();
                        }
                    });
                }
                final z91 z91Var = this.C;
                if (z91Var != null) {
                    Objects.requireNonNull(z91Var);
                    K(new Runnable() { // from class: a12
                        @Override // java.lang.Runnable
                        public final void run() {
                            z91Var.r();
                        }
                    });
                }
                final la1 la1Var = this.D;
                if (la1Var != null) {
                    Objects.requireNonNull(la1Var);
                    K(new Runnable() { // from class: b12
                        @Override // java.lang.Runnable
                        public final void run() {
                            la1Var.r();
                        }
                    });
                }
                final la1 la1Var2 = this.F;
                if (la1Var2 != null) {
                    Objects.requireNonNull(la1Var2);
                    K(new Runnable() { // from class: b12
                        @Override // java.lang.Runnable
                        public final void run() {
                            la1Var2.r();
                        }
                    });
                }
                final YuvConverter yuvConverter = this.E;
                if (yuvConverter != null) {
                    Objects.requireNonNull(yuvConverter);
                    K(new Runnable() { // from class: c12
                        @Override // java.lang.Runnable
                        public final void run() {
                            YuvConverter.this.release();
                        }
                    });
                }
                int i = this.H;
                if (i != -1) {
                    try {
                        GLES20.glDeleteFramebuffers(1, new int[]{i}, 0);
                    } catch (Throwable unused) {
                    }
                }
                int i2 = this.G;
                if (i2 != -1) {
                    try {
                        GLES20.glDeleteTextures(1, new int[]{i2}, 0);
                    } catch (Throwable unused2) {
                    }
                }
                int i3 = this.m;
                if (i3 > 0) {
                    try {
                        GLES20.glDeleteTextures(1, new int[]{i3}, 0);
                    } catch (Throwable unused3) {
                    }
                }
            } catch (Throwable th) {
                lx1.c("LiveBeautyGL", "release: makeCurrent failed, skip GL deletes: " + th.getMessage());
            }
        }
        this.z = null;
        this.A = null;
        this.B = null;
        this.C = null;
        this.D = null;
        this.F = null;
        this.E = null;
        this.H = -1;
        this.G = -1;
        this.m = -1;
        xp4 xp4Var2 = this.h;
        if (xp4Var2 != null) {
            try {
                xp4Var2.e();
            } catch (Throwable unused4) {
            }
            this.h = null;
        }
        cs0 cs0Var = this.g;
        if (cs0Var != null) {
            try {
                cs0Var.e();
            } catch (Throwable unused5) {
            }
            this.g = null;
        }
        E("renderThread.release.after");
        quitSafely();
    }

    public final void t() {
        if (this.Y || !this.X || !this.r || this.l == null) {
            return;
        }
        lx1.c("LiveBeautyGL", "restart camera after background failure");
        l();
        this.Z = 0;
        P(this.q);
    }

    public final void u() {
        l();
        this.q = !this.q;
        W();
        int p = p(this.q);
        this.y = p;
        this.K = T(z(p, this.q));
        this.x = H(this.q);
        if (this.q) {
            this.w = false;
        }
        this.v = 1.0f;
        this.Z = 0;
        P(this.q);
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x00fe, code lost:
    
        if (r3 == null) goto L102;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void v() {
        /*
            Method dump skipped, instructions count: 380
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.d12.v():void");
    }

    public void w(boolean z) {
        if (this.Y) {
            return;
        }
        this.w = z;
        Handler handler = this.p;
        if (handler != null) {
            handler.post(new v02(this));
        }
    }

    public final String x(CameraManager cameraManager, boolean z) {
        int i;
        boolean z2;
        boolean z3;
        boolean z4 = !z;
        String str = null;
        int i2 = -1;
        String str2 = null;
        for (String str3 : cameraManager.getCameraIdList()) {
            CameraCharacteristics cameraCharacteristics = cameraManager.getCameraCharacteristics(str3);
            Integer num = (Integer) cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
            if (num != null && num.intValue() == z4) {
                int[] iArr = (int[]) cameraCharacteristics.get(CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES);
                Size size = (Size) cameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE);
                if (iArr != null) {
                    z2 = false;
                    z3 = false;
                    for (int i3 : iArr) {
                        if (i3 == 0) {
                            z2 = true;
                        }
                        if (i3 == 12) {
                            z3 = true;
                        }
                    }
                    i = 0;
                } else {
                    i = 0;
                    z2 = false;
                    z3 = false;
                }
                int width = size != null ? size.getWidth() * size.getHeight() : i;
                if (str2 == null) {
                    str2 = str3;
                }
                if (z2 && !z3 && width > i2) {
                    i2 = width;
                    str = str3;
                }
            }
        }
        return str != null ? str : str2 != null ? str2 : cameraManager.getCameraIdList()[0];
    }

    public float y() {
        return this.x;
    }
}
