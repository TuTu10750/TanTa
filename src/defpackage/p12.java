package defpackage;

import android.content.Context;
import android.view.ViewGroup;
import com.yunbao.live.bean.LiveDanMuBean;
import defpackage.b90;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: /tmp/classes2.dex */
public class p12 implements b90.c {
    public Context a;
    public ViewGroup b;
    public boolean[] c = {true, true, true};
    public List d = new LinkedList();
    public ConcurrentLinkedQueue e = new ConcurrentLinkedQueue();

    public p12(Context context, ViewGroup viewGroup) {
        this.a = context;
        this.b = viewGroup;
    }

    @Override // b90.c
    public void a(b90 b90Var) {
        if (this.e.size() != 0 || b90Var == null) {
            return;
        }
        b90Var.release();
        List list = this.d;
        if (list != null) {
            list.remove(b90Var);
        }
    }

    @Override // b90.c
    public void b(int i) {
        this.c[i] = true;
        c();
    }

    public final void c() {
        LiveDanMuBean liveDanMuBean = (LiveDanMuBean) this.e.poll();
        if (liveDanMuBean != null) {
            f(liveDanMuBean);
        }
    }

    public void d() {
        List list = this.d;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((b90) it.next()).release();
            }
            this.d.clear();
        }
        ConcurrentLinkedQueue concurrentLinkedQueue = this.e;
        if (concurrentLinkedQueue != null) {
            concurrentLinkedQueue.clear();
        }
    }

    public void e() {
        boolean[] zArr = this.c;
        if (zArr != null) {
            for (boolean z : zArr) {
            }
        }
    }

    public void f(LiveDanMuBean liveDanMuBean) {
        b90 b90Var;
        int i = 0;
        while (true) {
            boolean[] zArr = this.c;
            if (i >= zArr.length) {
                i = -1;
                break;
            } else {
                if (zArr[i]) {
                    zArr[i] = false;
                    break;
                }
                i++;
            }
        }
        if (i == -1) {
            this.e.offer(liveDanMuBean);
            return;
        }
        Iterator it = this.d.iterator();
        while (true) {
            if (!it.hasNext()) {
                b90Var = null;
                break;
            }
            b90Var = (b90) it.next();
            if (b90Var.k0()) {
                b90Var.m0(false);
                break;
            }
        }
        if (b90Var == null) {
            b90Var = new b90(this.a, this.b);
            b90Var.l0(this);
            this.d.add(b90Var);
        }
        b90Var.n0(liveDanMuBean, i);
    }
}
