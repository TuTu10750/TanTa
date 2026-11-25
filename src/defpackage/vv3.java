package defpackage;

/* loaded from: /tmp/classes2.dex */
public abstract class vv3 {
    public static void a(Appendable appendable, Object obj, n81 n81Var) {
        appendable.getClass();
        if (n81Var != null) {
            appendable.append((CharSequence) n81Var.invoke(obj));
            return;
        }
        if (obj == null ? true : obj instanceof CharSequence) {
            appendable.append((CharSequence) obj);
        } else if (obj instanceof Character) {
            appendable.append(((Character) obj).charValue());
        } else {
            appendable.append(obj.toString());
        }
    }
}
