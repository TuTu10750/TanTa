package com.zzhoujay.richtext.drawable;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Movie;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.widget.TextView;
import tv.danmaku.ijk.media.player.IjkMediaCodecInfo;

/* loaded from: /tmp/classes2.dex */
public class GifDrawable extends Drawable {
    private static final int what = 855;
    private Handler handler;
    private int height;
    private Movie movie;
    private Paint paint;
    private boolean running;
    private float scaleX;
    private float scaleY;
    private long start;
    private TextView textView;
    private int width;

    public GifDrawable(Movie movie, int i, int i2) {
        this.movie = movie;
        this.height = i;
        this.width = i2;
        setBounds(0, 0, i2, i);
        this.scaleY = 1.0f;
        this.scaleX = 1.0f;
        this.paint = new Paint();
        this.handler = new Handler(Looper.getMainLooper()) { // from class: com.zzhoujay.richtext.drawable.GifDrawable.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what == GifDrawable.what && GifDrawable.this.running && GifDrawable.this.textView != null) {
                    GifDrawable.this.textView.invalidate();
                    sendEmptyMessageDelayed(GifDrawable.what, 33L);
                }
            }
        };
    }

    private void calculateScale() {
        this.scaleX = getBounds().width() / this.width;
        this.scaleY = getBounds().height() / this.height;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.start == 0) {
            this.start = uptimeMillis;
        }
        Movie movie = this.movie;
        if (movie != null) {
            int duration = movie.duration();
            if (duration == 0) {
                duration = IjkMediaCodecInfo.RANK_MAX;
            }
            this.movie.setTime((int) ((uptimeMillis - this.start) % duration));
            Rect bounds = getBounds();
            canvas.scale(this.scaleX, this.scaleY);
            this.movie.draw(canvas, bounds.left, bounds.top);
        }
    }

    public int getHeight() {
        return this.height;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.height;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.width;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    public int getWidth() {
        return this.width;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.paint.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        calculateScale();
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(Rect rect) {
        super.setBounds(rect);
        calculateScale();
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.paint.setColorFilter(colorFilter);
    }

    public void start(TextView textView) {
        this.running = true;
        this.textView = textView;
        this.handler.sendEmptyMessage(what);
    }

    public void stop() {
        this.running = false;
        this.textView = null;
        this.movie = null;
    }
}
