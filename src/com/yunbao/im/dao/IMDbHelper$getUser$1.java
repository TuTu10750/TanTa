package com.yunbao.im.dao;

import defpackage.b91;
import defpackage.eq1;
import defpackage.fl3;
import defpackage.in0;
import defpackage.ka0;
import defpackage.n81;
import defpackage.ps3;
import defpackage.qc4;
import defpackage.ra2;
import defpackage.s70;
import defpackage.th1;
import defpackage.tk;
import defpackage.u60;
import java.util.List;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Ls70;", "Lqc4;", "<anonymous>", "(Ls70;)V"}, k = 3, mv = {2, 3, 0})
@ka0(c = "com.yunbao.im.dao.IMDbHelper$getUser$1", f = "IMDbHelper.kt", l = {69}, m = "invokeSuspend", v = 2)
/* loaded from: /tmp/classes2.dex */
public final class IMDbHelper$getUser$1 extends SuspendLambda implements b91 {
    public Object a;
    public int b;
    public final /* synthetic */ IMDbHelper c;
    public final /* synthetic */ n81 d;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Ls70;", "Lqc4;", "<anonymous>", "(Ls70;)V"}, k = 3, mv = {2, 3, 0})
    @ka0(c = "com.yunbao.im.dao.IMDbHelper$getUser$1$1", f = "IMDbHelper.kt", l = {}, m = "invokeSuspend", v = 2)
    /* renamed from: com.yunbao.im.dao.IMDbHelper$getUser$1$1, reason: invalid class name */
    /* loaded from: /tmp/classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements b91 {
        public int a;
        public final /* synthetic */ n81 b;
        public final /* synthetic */ List c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(n81 n81Var, List list, u60 u60Var) {
            super(2, u60Var);
            this.b = n81Var;
            this.c = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final u60 create(Object obj, u60 u60Var) {
            return new AnonymousClass1(this.b, this.c, u60Var);
        }

        @Override // defpackage.b91
        public final Object invoke(s70 s70Var, u60 u60Var) {
            return ((AnonymousClass1) create(s70Var, u60Var)).invokeSuspend(qc4.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            eq1.e();
            if (this.a != 0) {
                fl3.a("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            b.b(obj);
            this.b.invoke(this.c);
            return qc4.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMDbHelper$getUser$1(IMDbHelper iMDbHelper, n81 n81Var, u60 u60Var) {
        super(2, u60Var);
        this.c = iMDbHelper;
        this.d = n81Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final u60 create(Object obj, u60 u60Var) {
        return new IMDbHelper$getUser$1(this.c, this.d, u60Var);
    }

    @Override // defpackage.b91
    public final Object invoke(s70 s70Var, u60 u60Var) {
        return ((IMDbHelper$getUser$1) create(s70Var, u60Var)).invokeSuspend(qc4.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        th1 th1Var;
        Object e = eq1.e();
        int i = this.b;
        if (i == 0) {
            b.b(obj);
            th1Var = this.c.b;
            List all = th1Var.getAll();
            ra2 c = in0.c();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.d, all, null);
            this.a = ps3.a(all);
            this.b = 1;
            if (tk.e(c, anonymousClass1, this) == e) {
                return e;
            }
        } else {
            if (i != 1) {
                fl3.a("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            b.b(obj);
        }
        return qc4.a;
    }
}
