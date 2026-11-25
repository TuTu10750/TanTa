package defpackage;

import android.view.View;
import android.widget.MediaController;

/* loaded from: /tmp/classes2.dex */
public interface wh1 {
    void hide();

    boolean isShowing();

    void setAnchorView(View view);

    void setEnabled(boolean z);

    void setMediaPlayer(MediaController.MediaPlayerControl mediaPlayerControl);

    void show();

    void show(int i);
}
