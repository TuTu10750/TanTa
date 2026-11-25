package com.yunbao.phonelive.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Process;
import androidx.appcompat.app.AppCompatActivity;

/* loaded from: /tmp/classes2.dex */
public class RebootActivity extends AppCompatActivity {
    /* JADX WARN: Multi-variable type inference failed */
    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.FragmentActivity*/.onCreate(bundle);
        startActivity(new Intent((Context) this, (Class<?>) LauncherActivity.class));
        finishAffinity();
        Process.killProcess(Process.myPid());
    }
}
