package defpackage;

import android.media.SoundPool;
import android.util.SparseIntArray;
import com.yunbao.common.CommonAppContext;

/* loaded from: /tmp/classes2.dex */
public class bb1 {
    public final SoundPool a;
    public final SparseIntArray b;

    public bb1() {
        SparseIntArray sparseIntArray = new SparseIntArray();
        this.b = sparseIntArray;
        SoundPool soundPool = new SoundPool(4, 3, 0);
        this.a = soundPool;
        sparseIntArray.put(0, soundPool.load(CommonAppContext.n(), a93.b, 1));
        sparseIntArray.put(1, soundPool.load(CommonAppContext.n(), a93.a, 1));
        sparseIntArray.put(2, soundPool.load(CommonAppContext.n(), a93.c, 1));
        sparseIntArray.put(3, soundPool.load(CommonAppContext.n(), a93.d, 1));
    }

    public void a(int i) {
        this.a.play(this.b.get(i), 1.0f, 1.0f, 0, 0, 1.0f);
    }

    public void b() {
        this.a.release();
    }
}
