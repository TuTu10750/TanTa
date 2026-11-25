package defpackage;

import android.os.Looper;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public final class w6 implements ta2 {
    @Override // defpackage.ta2
    public String a() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    @Override // defpackage.ta2
    public ra2 b(List list) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new re1(te1.a(mainLooper, true), null, 2, null);
        }
        fl3.a("The main looper is not available");
        return null;
    }

    @Override // defpackage.ta2
    public int c() {
        return 1073741823;
    }
}
