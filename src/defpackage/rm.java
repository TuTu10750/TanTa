package defpackage;

/* loaded from: /tmp/classes2.dex */
public final /* synthetic */ class rm {
    public static /* synthetic */ void a(int i, Object obj, int i2) {
        StringBuilder sb = new StringBuilder(i);
        sb.append(obj);
        sb.append(i2);
        throw new IndexOutOfBoundsException(sb.toString());
    }
}
