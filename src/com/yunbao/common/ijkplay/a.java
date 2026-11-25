package com.yunbao.common.ijkplay;

import android.view.View;
import tv.danmaku.ijk.media.player.IMediaPlayer;

/* loaded from: /tmp/classes2.dex */
public interface a {

    /* renamed from: com.yunbao.common.ijkplay.a$a, reason: collision with other inner class name */
    /* loaded from: /tmp/classes2.dex */
    public interface InterfaceC0030a {
        void a(b bVar, int i, int i2);

        void b(b bVar);

        void c(b bVar, int i, int i2, int i3);
    }

    /* loaded from: /tmp/classes2.dex */
    public interface b {
        a a();

        void b(IMediaPlayer iMediaPlayer);
    }

    void a(int i, int i2);

    void b(InterfaceC0030a interfaceC0030a);

    void c(int i, int i2);

    boolean d();

    void e(InterfaceC0030a interfaceC0030a);

    View getView();

    void setAspectRatio(int i);

    void setVideoRotation(int i);
}
