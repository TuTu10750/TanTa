package defpackage;

import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public abstract class b5 {
    public static void a(FragmentActivity fragmentActivity, Intent intent, s4 s4Var) {
        i23 i23Var;
        k61 supportFragmentManager = fragmentActivity.getSupportFragmentManager();
        List<Fragment> t0 = supportFragmentManager.t0();
        if (t0 != null && t0.size() > 0) {
            for (Fragment fragment : t0) {
                if (fragment != null && (fragment instanceof i23)) {
                    i23Var = (i23) fragment;
                    break;
                }
            }
        }
        i23Var = null;
        if (i23Var == null) {
            i23Var = new i23();
            supportFragmentManager.o().d(i23Var, "ProcessFragment").h();
        }
        i23Var.R1(intent, s4Var);
    }
}
