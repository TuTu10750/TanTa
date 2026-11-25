package defpackage;

import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.music.LiveMusicBean;

/* loaded from: /tmp/classes2.dex */
public abstract class io2 extends HttpCallback {
    public LiveMusicBean a;

    public LiveMusicBean a() {
        return this.a;
    }

    public void b(LiveMusicBean liveMusicBean) {
        this.a = liveMusicBean;
    }
}
