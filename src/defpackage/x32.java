package defpackage;

import android.animation.ValueAnimator;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.animation.LinearInterpolator;
import com.yunbao.live.music.LrcBean;
import java.io.IOException;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class x32 implements MediaPlayer.OnPreparedListener, ValueAnimator.AnimatorUpdateListener, MediaPlayer.OnCompletionListener {
    public MediaPlayer a;
    public List b;
    public a c;
    public int d;
    public ValueAnimator e;
    public String f;

    /* loaded from: /tmp/classes2.dex */
    public interface a {
        void a(String str);

        void b(boolean z);

        void c(String str);

        void d(float f);

        void e(String str);
    }

    public x32() {
        MediaPlayer mediaPlayer = new MediaPlayer();
        this.a = mediaPlayer;
        mediaPlayer.setOnPreparedListener(this);
        this.a.setOnCompletionListener(this);
        this.a.setVolume(0.0f, 0.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[0]);
        this.e = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.e.addUpdateListener(this);
    }

    public final LrcBean a(long j) {
        List list = this.b;
        if (list != null && list.size() != 0) {
            int i = this.d;
            if (i >= 0 && i < this.b.size()) {
                LrcBean lrcBean = (LrcBean) this.b.get(this.d);
                if (j >= lrcBean.getStartTime() && j <= lrcBean.getEndTime()) {
                    float startTime = ((float) (j - lrcBean.getStartTime())) / lrcBean.getDuration();
                    lrcBean.setProgress(startTime >= 0.01f ? startTime : 0.0f);
                    return lrcBean;
                }
            }
            for (LrcBean lrcBean2 : this.b) {
                if (j >= lrcBean2.getStartTime() && j <= lrcBean2.getEndTime()) {
                    float startTime2 = ((float) (j - lrcBean2.getStartTime())) / lrcBean2.getDuration();
                    lrcBean2.setProgress(startTime2 >= 0.01f ? startTime2 : 0.0f);
                    return lrcBean2;
                }
            }
        }
        return null;
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.b = f92.b(str);
        try {
            this.f = j30.L + str + ".mp3";
            if (this.a.isPlaying()) {
                this.a.stop();
            }
            this.a.reset();
            this.a.setDataSource(this.f);
            this.a.prepareAsync();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void c() {
        this.f = null;
        this.c = null;
        MediaPlayer mediaPlayer = this.a;
        if (mediaPlayer != null) {
            if (mediaPlayer.isPlaying()) {
                this.a.stop();
            }
            this.a.release();
        }
        this.a = null;
        ValueAnimator valueAnimator = this.e;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.e.removeAllUpdateListeners();
            this.e.removeAllListeners();
        }
        this.e = null;
    }

    public void d(a aVar) {
        this.c = aVar;
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        LrcBean a2;
        if (this.c == null || (a2 = a(((Float) valueAnimator.getAnimatedValue()).floatValue())) == null) {
            return;
        }
        if (this.d != a2.getIndex()) {
            this.d = a2.getIndex();
            this.c.c(a2.getLrc());
        }
        this.c.d(a2.getProgress());
    }

    @Override // android.media.MediaPlayer.OnCompletionListener
    public void onCompletion(MediaPlayer mediaPlayer) {
        a aVar = this.c;
        if (aVar != null) {
            aVar.e(this.f);
        }
    }

    @Override // android.media.MediaPlayer.OnPreparedListener
    public void onPrepared(MediaPlayer mediaPlayer) {
        mediaPlayer.start();
        a aVar = this.c;
        if (aVar != null) {
            aVar.a(this.f);
        }
        long duration = mediaPlayer.getDuration();
        List list = this.b;
        boolean z = list != null && list.size() > 0;
        a aVar2 = this.c;
        if (aVar2 != null) {
            aVar2.b(z);
        }
        this.d = -1;
        ValueAnimator valueAnimator = this.e;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        if (z) {
            int size = this.b.size();
            for (int i = 0; i < size; i++) {
                LrcBean lrcBean = (LrcBean) this.b.get(i);
                lrcBean.setIndex(i);
                if (i == size - 1) {
                    lrcBean.setEndTime(duration);
                } else {
                    lrcBean.setEndTime(((LrcBean) this.b.get(i + 1)).getStartTime());
                }
            }
            ValueAnimator valueAnimator2 = this.e;
            if (valueAnimator2 != null) {
                valueAnimator2.setFloatValues(0.0f, (float) duration);
                this.e.setDuration(duration);
                this.e.start();
            }
        }
    }
}
