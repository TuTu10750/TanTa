package defpackage;

import android.widget.MediaController;

/* loaded from: /tmp/classes2.dex */
public class yy2 implements MediaController.MediaPlayerControl {
    public final ww0 a;

    public yy2(ww0 ww0Var) {
        this.a = ww0Var;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canPause() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekBackward() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean canSeekForward() {
        return true;
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getAudioSessionId() {
        throw new UnsupportedOperationException();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getBufferPercentage() {
        return this.a.h();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getCurrentPosition() {
        if (this.a.getDuration() == -1) {
            return 0;
        }
        return (int) this.a.getCurrentPosition();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public int getDuration() {
        if (this.a.getDuration() == -1) {
            return 0;
        }
        return (int) this.a.getDuration();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public boolean isPlaying() {
        return this.a.c();
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void pause() {
        this.a.d(false);
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void seekTo(int i) {
        this.a.seekTo(this.a.getDuration() == -1 ? 0L : Math.min(Math.max(0, i), getDuration()));
    }

    @Override // android.widget.MediaController.MediaPlayerControl
    public void start() {
        this.a.d(true);
    }
}
