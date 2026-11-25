package com.yunbao.common.ijkplay;

import android.content.Context;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
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

/* loaded from: /tmp/classes2.dex */
public class SurfaceRenderView extends SurfaceView implements com.yunbao.common.ijkplay.a {
    public te2 a;
    public b b;

    /* loaded from: /tmp/classes2.dex */
    public static final class a implements a.b {
        public SurfaceRenderView a;
        public SurfaceHolder b;

        public a(SurfaceRenderView surfaceRenderView, SurfaceHolder surfaceHolder) {
            this.a = surfaceRenderView;
            this.b = surfaceHolder;
        }

        @Override // com.yunbao.common.ijkplay.a.b
        public com.yunbao.common.ijkplay.a a() {
            return this.a;
        }

        @Override // com.yunbao.common.ijkplay.a.b
        public void b(IMediaPlayer iMediaPlayer) {
            if (iMediaPlayer != null) {
                if (iMediaPlayer instanceof ISurfaceTextureHolder) {
                    ((ISurfaceTextureHolder) iMediaPlayer).setSurfaceTexture(null);
                }
                iMediaPlayer.setDisplay(this.b);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static final class b implements SurfaceHolder.Callback {
        public SurfaceHolder a;
        public boolean b;
        public int c;
        public int d;
        public int e;
        public WeakReference f;
        public Map g = new ConcurrentHashMap();

        public b(SurfaceRenderView surfaceRenderView) {
            this.f = new WeakReference(surfaceRenderView);
        }

        public void a(a.InterfaceC0030a interfaceC0030a) {
            a aVar;
            this.g.put(interfaceC0030a, interfaceC0030a);
            if (this.a != null) {
                aVar = new a((SurfaceRenderView) this.f.get(), this.a);
                interfaceC0030a.a(aVar, this.d, this.e);
            } else {
                aVar = null;
            }
            if (this.b) {
                if (aVar == null) {
                    aVar = new a((SurfaceRenderView) this.f.get(), this.a);
                }
                interfaceC0030a.c(aVar, this.c, this.d, this.e);
            }
        }

        public void b(a.InterfaceC0030a interfaceC0030a) {
            this.g.remove(interfaceC0030a);
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            this.a = surfaceHolder;
            this.b = true;
            this.c = i;
            this.d = i2;
            this.e = i3;
            a aVar = new a((SurfaceRenderView) this.f.get(), this.a);
            Iterator it = this.g.keySet().iterator();
            while (it.hasNext()) {
                ((a.InterfaceC0030a) it.next()).c(aVar, i, i2, i3);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            this.a = surfaceHolder;
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            a aVar = new a((SurfaceRenderView) this.f.get(), this.a);
            Iterator it = this.g.keySet().iterator();
            while (it.hasNext()) {
                ((a.InterfaceC0030a) it.next()).a(aVar, 0, 0);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            this.a = null;
            this.b = false;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            a aVar = new a((SurfaceRenderView) this.f.get(), this.a);
            Iterator it = this.g.keySet().iterator();
            while (it.hasNext()) {
                ((a.InterfaceC0030a) it.next()).b(aVar);
            }
        }
    }

    public SurfaceRenderView(Context context) {
        super(context);
        f(context);
    }

    @Override // com.yunbao.common.ijkplay.a
    public void a(int i, int i2) {
        if (i <= 0 || i2 <= 0) {
            return;
        }
        this.a.g(i, i2);
        getHolder().setFixedSize(i, i2);
        requestLayout();
    }

    @Override // com.yunbao.common.ijkplay.a
    public void b(a.InterfaceC0030a interfaceC0030a) {
        this.b.b(interfaceC0030a);
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
        return true;
    }

    @Override // com.yunbao.common.ijkplay.a
    public void e(a.InterfaceC0030a interfaceC0030a) {
        this.b.a(interfaceC0030a);
    }

    public final void f(Context context) {
        this.a = new te2(this);
        this.b = new b(this);
        getHolder().addCallback(this.b);
        getHolder().setType(0);
    }

    @Override // com.yunbao.common.ijkplay.a
    public View getView() {
        return this;
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(SurfaceRenderView.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(SurfaceRenderView.class.getName());
    }

    @Override // android.view.SurfaceView, android.view.View
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
        Log.e("", "SurfaceView doesn't support rotation (" + i + ")!\n");
    }
}
