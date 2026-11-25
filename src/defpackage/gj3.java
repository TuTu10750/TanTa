package defpackage;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.Result;
import kotlin.coroutines.d;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* loaded from: /tmp/classes2.dex */
public final class gj3 implements u60, t70 {
    public static final a b = new a(null);
    public static final AtomicReferenceFieldUpdater c = AtomicReferenceFieldUpdater.newUpdater(gj3.class, Object.class, "result");
    public final u60 a;
    private volatile Object result;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public gj3(u60 u60Var) {
        this(u60Var, CoroutineSingletons.b);
        u60Var.getClass();
    }

    public gj3(u60 u60Var, Object obj) {
        u60Var.getClass();
        this.a = u60Var;
        this.result = obj;
    }

    public final Object a() {
        Object obj = this.result;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.b;
        if (obj == coroutineSingletons) {
            if (a2.a(c, this, coroutineSingletons, eq1.e())) {
                return eq1.e();
            }
            obj = this.result;
        }
        if (obj == CoroutineSingletons.c) {
            return eq1.e();
        }
        if (obj instanceof Result.Failure) {
            throw ((Result.Failure) obj).exception;
        }
        return obj;
    }

    @Override // defpackage.t70
    public t70 getCallerFrame() {
        u60 u60Var = this.a;
        if (u60Var instanceof t70) {
            return (t70) u60Var;
        }
        return null;
    }

    @Override // defpackage.u60
    public d getContext() {
        return this.a.getContext();
    }

    @Override // defpackage.u60
    public void resumeWith(Object obj) {
        while (true) {
            Object obj2 = this.result;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.b;
            if (obj2 == coroutineSingletons) {
                if (a2.a(c, this, coroutineSingletons, obj)) {
                    return;
                }
            } else if (obj2 != eq1.e()) {
                fl3.a("Already resumed");
                return;
            } else if (a2.a(c, this, eq1.e(), CoroutineSingletons.c)) {
                this.a.resumeWith(obj);
                return;
            }
        }
    }

    public String toString() {
        return "SafeContinuation for " + this.a;
    }
}
