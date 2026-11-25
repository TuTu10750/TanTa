package defpackage;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.NotImplementedError;
import kotlin.reflect.TypesJVMKt;

/* loaded from: /tmp/classes2.dex */
public final class fb4 implements TypeVariable, Type {
    public final nw1 a;

    public fb4(nw1 nw1Var) {
        nw1Var.getClass();
        this.a = nw1Var;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof TypeVariable)) {
            return false;
        }
        TypeVariable typeVariable = (TypeVariable) obj;
        return dq1.a(getName(), typeVariable.getName()) && dq1.a(getGenericDeclaration(), typeVariable.getGenericDeclaration());
    }

    @Override // java.lang.reflect.TypeVariable
    public Type[] getBounds() {
        Type c;
        List upperBounds = this.a.getUpperBounds();
        ArrayList arrayList = new ArrayList(t20.v(upperBounds, 10));
        Iterator it = upperBounds.iterator();
        while (it.hasNext()) {
            c = TypesJVMKt.c((lw1) it.next(), true);
            arrayList.add(c);
        }
        return (Type[]) arrayList.toArray(new Type[0]);
    }

    @Override // java.lang.reflect.TypeVariable
    public GenericDeclaration getGenericDeclaration() {
        throw new NotImplementedError("An operation is not implemented: ".concat("getGenericDeclaration() is not yet supported for type variables created from KType: " + this.a));
    }

    @Override // java.lang.reflect.TypeVariable
    public String getName() {
        return this.a.getName();
    }

    @Override // java.lang.reflect.Type
    public String getTypeName() {
        return getName();
    }

    public int hashCode() {
        return getGenericDeclaration().hashCode() ^ getName().hashCode();
    }

    public String toString() {
        return getTypeName();
    }
}
