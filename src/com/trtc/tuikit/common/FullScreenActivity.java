package com.trtc.tuikit.common;

import android.os.Bundle;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.zzhoujay.richtext.ImageHolder;

/* loaded from: /tmp/classes2.dex */
public class FullScreenActivity extends AppCompatActivity {
    /* JADX WARN: Multi-variable type inference failed */
    private void initStatusBar() {
        Window window = getWindow();
        window.clearFlags(67108864);
        window.getDecorView().setSystemUiVisibility(9216);
        window.addFlags(ImageHolder.WRAP_CONTENT);
        window.setStatusBarColor(0);
    }

    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(bundle);
        initStatusBar();
    }
}
