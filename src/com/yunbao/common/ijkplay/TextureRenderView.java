package com.yunbao.common.ijkplay;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.yunbao.common.ijkplay.a;
import defpackage.te2;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.ISurfaceTextureHolder;
import tv.danmaku.ijk.media.player.ISurfaceTextureHost;

/* loaded from: /tmp/classes2.dex */
public class TextureRenderView extends TextureView implements com.yunbao.common.ijkplay.a {
    public te2 a;
    public b b;

    /* loaded from: /tmp/classes2.dex */
    public static final class a implements a.b {
        public TextureRenderView a;
        public SurfaceTexture b;
        public ISurfaceTextureHost c;

        public a(TextureRenderView textureRenderView, SurfaceTexture surfaceTexture, ISurfaceTextureHost iSurfaceTextureHost) {
            this.a = textureRenderView;
            this.b = surfaceTexture;
            this.c = iSurfaceTextureHost;
        }

        @Override // com.yunbao.common.ijkplay.a.b
        public com.yunbao.common.ijkplay.a a() {
            return this.a;
        }

        @Override // com.yunbao.common.ijkplay.a.b
        public void b(IMediaPlayer iMediaPlayer) {
            if (iMediaPlayer == null) {
                return;
            }
            if (!(iMediaPlayer instanceof ISurfaceTextureHolder)) {
                iMediaPlayer.setSurface(c());
                return;
            }
            ISurfaceTextureHolder iSurfaceTextureHolder = (ISurfaceTextureHolder) iMediaPlayer;
            this.a.b.e(false);
            SurfaceTexture surfaceTexture = iSurfaceTextureHolder.getSurfaceTexture();
            if (surfaceTexture != null) {
                this.a.setSurfaceTexture(surfaceTexture);
            } else {
                iSurfaceTextureHolder.setSurfaceTexture(this.b);
                iSurfaceTextureHolder.setSurfaceTextureHost(this.a.b);
            }
        }

        public Surface c() {
            if (this.b == null) {
                return null;
            }
            return new Surface(this.b);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class b implements TextureView.SurfaceTextureListener, ISurfaceTextureHost {
        public SurfaceTexture a;
        public boolean b;
        public int c;
        public int d;
        public WeakReference h;
        public boolean e = true;
        public boolean f = false;
        public boolean g = false;
        public Map i = new ConcurrentHashMap();

        public b(TextureRenderView textureRenderView) {
            this.h = new WeakReference(textureRenderView);
        }

        public void b(a.InterfaceC0030a interfaceC0030a) {
            a aVar;
            this.i.put(interfaceC0030a, interfaceC0030a);
            if (this.a != null) {
                aVar = new a((TextureRenderView) this.h.get(), this.a, this);
                interfaceC0030a.a(aVar, this.c, this.d);
            } else {
                aVar = null;
            }
            if (this.b) {
                if (aVar == null) {
                    aVar = new a((TextureRenderView) this.h.get(), this.a, this);
                }
                interfaceC0030a.c(aVar, 0, this.c, this.d);
            }
        }

        public void c() {
            Log.d("TextureRenderView", "didDetachFromWindow()");
            this.g = true;
        }

        public void d(a.InterfaceC0030a interfaceC0030a) {
            this.i.remove(interfaceC0030a);
        }

        public void e(boolean z) {
            this.e = z;
        }

        public void f() {
            Log.d("TextureRenderView", "willDetachFromWindow()");
            this.f = true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            this.a = surfaceTexture;
            this.b = false;
            this.c = 0;
            this.d = 0;
            a aVar = new a((TextureRenderView) this.h.get(), surfaceTexture, this);
            Iterator it = this.i.keySet().iterator();
            while (it.hasNext()) {
                ((a.InterfaceC0030a) it.next()).a(aVar, 0, 0);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            this.a = surfaceTexture;
            this.b = false;
            this.c = 0;
            this.d = 0;
            a aVar = new a((TextureRenderView) this.h.get(), surfaceTexture, this);
            Iterator it = this.i.keySet().iterator();
            while (it.hasNext()) {
                ((a.InterfaceC0030a) it.next()).b(aVar);
            }
            Log.d("TextureRenderView", "onSurfaceTextureDestroyed: destroy: " + this.e);
            return this.e;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            this.a = surfaceTexture;
            this.b = true;
            this.c = i;
            this.d = i2;
            a aVar = new a((TextureRenderView) this.h.get(), surfaceTexture, this);
            Iterator it = this.i.keySet().iterator();
            while (it.hasNext()) {
                ((a.InterfaceC0030a) it.next()).c(aVar, 0, i, i2);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }

        @Override // tv.danmaku.ijk.media.player.ISurfaceTextureHost
        public void releaseSurfaceTexture(SurfaceTexture surfaceTexture) {
            if (surfaceTexture == null) {
                Log.d("TextureRenderView", "releaseSurfaceTexture: null");
                return;
            }
            if (this.g) {
                if (surfaceTexture != this.a) {
                    Log.d("TextureRenderView", "releaseSurfaceTexture: didDetachFromWindow(): release different SurfaceTexture");
                    surfaceTexture.release();
                    return;
                } else if (this.e) {
                    Log.d("TextureRenderView", "releaseSurfaceTexture: didDetachFromWindow(): already released by TextureView");
                    return;
                } else {
                    Log.d("TextureRenderView", "releaseSurfaceTexture: didDetachFromWindow(): release detached SurfaceTexture");
                    surfaceTexture.release();
                    return;
                }
            }
            boolean z = this.f;
            SurfaceTexture surfaceTexture2 = this.a;
            if (z) {
                if (surfaceTexture != surfaceTexture2) {
                    Log.d("TextureRenderView", "releaseSurfaceTexture: willDetachFromWindow(): release different SurfaceTexture");
                    surfaceTexture.release();
                    return;
                } else if (this.e) {
                    Log.d("TextureRenderView", "releaseSurfaceTexture: willDetachFromWindow(): will released by TextureView");
                    return;
                } else {
                    Log.d("TextureRenderView", "releaseSurfaceTexture: willDetachFromWindow(): re-attach SurfaceTexture to TextureView");
                    e(true);
                    return;
                }
            }
            if (surfaceTexture != surfaceTexture2) {
                Log.d("TextureRenderView", "releaseSurfaceTexture: alive: release different SurfaceTexture");
                surfaceTexture.release();
            } else if (this.e) {
                Log.d("TextureRenderView", "releaseSurfaceTexture: alive: will released by TextureView");
            } else {
                Log.d("TextureRenderView", "releaseSurfaceTexture: alive: re-attach SurfaceTexture to TextureView");
                e(true);
            }
        }
    }

    public TextureRenderView(Context context) {
        super(context);
        g(context);
    }

    private void g(Context context) {
        this.a = new te2(this);
        b bVar = new b(this);
        this.b = bVar;
        setSurfaceTextureListener(bVar);
    }

    @Override // com.yunbao.common.ijkplay.a
    public void a(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.a.g(i, i2);
        requestLayout();
    }

    @Override // com.yunbao.common.ijkplay.a
    public void b(a.InterfaceC0030a interfaceC0030a) {
        this.b.d(interfaceC0030a);
    }

    @Override // com.yunbao.common.ijkplay.a
    public void c(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.a.f(i, i2);
        requestLayout();
    }

    @Override // com.yunbao.common.ijkplay.a
    public boolean d() {
        return false;
    }

    @Override // com.yunbao.common.ijkplay.a
    public void e(a.InterfaceC0030a interfaceC0030a) {
        this.b.b(interfaceC0030a);
    }

    public a.b getSurfaceHolder() {
        return new a(this, this.b.a, this.b);
    }

    @Override // com.yunbao.common.ijkplay.a
    public View getView() {
        return this;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        this.b.f();
        super.onDetachedFromWindow();
        this.b.c();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(TextureRenderView.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(TextureRenderView.class.getName());
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        this.a.a(i, i2);
        setMeasuredDimension(this.a.c(), this.a.b());
    }

    @Override // com.yunbao.common.ijkplay.a
    public void setAspectRatio(int i) {
        this.a.d(i);
        requestLayout();
    }

    @Override // com.yunbao.common.ijkplay.a
    public void setVideoRotation(int i) {
        this.a.e(i);
        setRotation(i);
    }
}
