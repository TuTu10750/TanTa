package defpackage;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import java.io.IOException;
import java.util.LinkedHashMap;

/* loaded from: /tmp/classes2.dex */
public class i23 extends Fragment {
    public Context h0;
    public vx2 i0;
    public s4 j0;
    public LinkedHashMap k0;

    /* loaded from: /tmp/classes2.dex */
    public class a implements Runnable {
        public final /* synthetic */ String a;

        public a(String str) {
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            t54.b(this.a);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:61:0x009b, code lost:
    
        if (r2.equals("android.permission.READ_EXTERNAL_STORAGE") == false) goto L14;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void Q1() {
        /*
            Method dump skipped, instructions count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.i23.Q1():void");
    }

    public void P1(vx2 vx2Var, String... strArr) {
        if (vx2Var == null || strArr == null || strArr.length == 0) {
            return;
        }
        LinkedHashMap linkedHashMap = this.k0;
        if (linkedHashMap == null) {
            this.k0 = new LinkedHashMap();
        } else {
            linkedHashMap.clear();
        }
        boolean z = true;
        for (String str : strArr) {
            boolean z2 = o60.a(this.h0, str) == 0;
            this.k0.put(str, Boolean.valueOf(z2));
            if (!z2) {
                z = false;
            }
        }
        if (!z) {
            this.i0 = vx2Var;
            x1(strArr, 0);
        } else {
            vx2Var.a();
            vx2Var.b(this.k0);
            this.i0 = null;
        }
    }

    public void R0(int i, String[] strArr, int[] iArr) {
        LinkedHashMap linkedHashMap = this.k0;
        if (linkedHashMap == null) {
            this.k0 = new LinkedHashMap();
        } else {
            linkedHashMap.clear();
        }
        int length = iArr.length;
        boolean z = true;
        for (int i2 = 0; i2 < length; i2++) {
            boolean z2 = iArr[i2] == 0;
            this.k0.put(strArr[i2], Boolean.valueOf(z2));
            if (!z2) {
                z = false;
            }
        }
        if (z) {
            vx2 vx2Var = this.i0;
            if (vx2Var != null) {
                vx2Var.a();
            }
        } else {
            Q1();
        }
        vx2 vx2Var2 = this.i0;
        if (vx2Var2 != null) {
            vx2Var2.b(this.k0);
        }
        this.i0 = null;
    }

    public void R1(Intent intent, s4 s4Var) {
        this.j0 = s4Var;
        super.L1(intent, 0);
    }

    public void s0(int i, int i2, Intent intent) {
        s4 s4Var = this.j0;
        if (s4Var != null) {
            s4Var.b(i2, intent);
            s4 s4Var2 = this.j0;
            if (i2 != -1) {
                s4Var2.a();
                return;
            }
            try {
                s4Var2.c(intent);
            } catch (IOException e) {
                ah1.a(e);
            }
        }
    }

    public void x0(Bundle bundle) {
        super.x0(bundle);
        this.h0 = v();
    }
}
