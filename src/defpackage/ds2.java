package defpackage;

/* loaded from: /tmp/classes2.dex */
public abstract class ds2 implements nb3 {
    public Object a;

    public ds2(Object obj) {
        this.a = obj;
    }

    public void a(iw1 iw1Var, Object obj, Object obj2) {
        iw1Var.getClass();
    }

    public abstract boolean b(iw1 iw1Var, Object obj, Object obj2);

    @Override // defpackage.nb3, defpackage.lb3
    public Object getValue(Object obj, iw1 iw1Var) {
        iw1Var.getClass();
        return this.a;
    }

    @Override // defpackage.nb3
    public void setValue(Object obj, iw1 iw1Var, Object obj2) {
        iw1Var.getClass();
        Object obj3 = this.a;
        if (b(iw1Var, obj3, obj2)) {
            this.a = obj2;
            a(iw1Var, obj3, obj2);
        }
    }

    public String toString() {
        return "ObservableProperty(value=" + this.a + ')';
    }
}
