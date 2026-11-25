package com.yunbao.im.dao;

import defpackage.b91;
import defpackage.eq1;
import defpackage.fl3;
import defpackage.ka0;
import defpackage.n81;
import defpackage.qc4;
import defpackage.s70;
import defpackage.u60;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Ls70;", "Lqc4;", "<anonymous>", "(Ls70;)V"}, k = 3, mv = {2, 3, 0})
@ka0(c = "com.yunbao.im.dao.IMDbHelper$updateMsg$1", f = "IMDbHelper.kt", l = {152, 154}, m = "invokeSuspend", v = 2)
/* loaded from: /tmp/classes2.dex */
public final class IMDbHelper$updateMsg$1 extends SuspendLambda implements b91 {
    public Object a;
    public int b;
    public final /* synthetic */ IMDbHelper c;
    public final /* synthetic */ IMMessageBean d;
    public final /* synthetic */ n81 e;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Ls70;", "Lqc4;", "<anonymous>", "(Ls70;)V"}, k = 3, mv = {2, 3, 0})
    @ka0(c = "com.yunbao.im.dao.IMDbHelper$updateMsg$1$1", f = "IMDbHelper.kt", l = {}, m = "invokeSuspend", v = 2)
    /* renamed from: com.yunbao.im.dao.IMDbHelper$updateMsg$1$1, reason: invalid class name */
    /* loaded from: /tmp/classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements b91 {
        public int a;
        public final /* synthetic */ n81 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(n81 n81Var, u60 u60Var) {
            super(2, u60Var);
            this.b = n81Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final u60 create(Object obj, u60 u60Var) {
            return new AnonymousClass1(this.b, u60Var);
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
            this.b.invoke(ek.a(true));
            return qc4.a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Ls70;", "Lqc4;", "<anonymous>", "(Ls70;)V"}, k = 3, mv = {2, 3, 0})
    @ka0(c = "com.yunbao.im.dao.IMDbHelper$updateMsg$1$2", f = "IMDbHelper.kt", l = {}, m = "invokeSuspend", v = 2)
    /* renamed from: com.yunbao.im.dao.IMDbHelper$updateMsg$1$2, reason: invalid class name */
    /* loaded from: /tmp/classes2.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements b91 {
        public int a;
        public final /* synthetic */ n81 b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(n81 n81Var, u60 u60Var) {
            super(2, u60Var);
            this.b = n81Var;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final u60 create(Object obj, u60 u60Var) {
            return new AnonymousClass2(this.b, u60Var);
        }

        @Override // defpackage.b91
        public final Object invoke(s70 s70Var, u60 u60Var) {
            return ((AnonymousClass2) create(s70Var, u60Var)).invokeSuspend(qc4.a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            eq1.e();
            if (this.a != 0) {
                fl3.a("call to 'resume' before 'invoke' with coroutine");
                return null;
            }
            b.b(obj);
            this.b.invoke(ek.a(false));
            return qc4.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public IMDbHelper$updateMsg$1(IMDbHelper iMDbHelper, IMMessageBean iMMessageBean, n81 n81Var, u60 u60Var) {
        super(2, u60Var);
        this.c = iMDbHelper;
        this.d = iMMessageBean;
        this.e = n81Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final u60 create(Object obj, u60 u60Var) {
        return new IMDbHelper$updateMsg$1(this.c, this.d, this.e, u60Var);
    }

    @Override // defpackage.b91
    public final Object invoke(s70 s70Var, u60 u60Var) {
        return ((IMDbHelper$updateMsg$1) create(s70Var, u60Var)).invokeSuspend(qc4.a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0043, code lost:
    
        if (r6 == r0) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x005f, code lost:
    
        return r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x005d, code lost:
    
        if (defpackage.tk.e(r1, r4, r6) != r0) goto L20;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v11 */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            java.lang.Object r0 = defpackage.eq1.e()
            int r1 = r6.b
            r2 = 0
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L24
            if (r1 == r4) goto L1e
            if (r1 != r3) goto L17
            java.lang.Object r6 = r6.a
            java.lang.Exception r6 = (java.lang.Exception) r6
            kotlin.b.b(r7)
            goto L60
        L17:
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            defpackage.fl3.a(r6)
            r6 = 0
            return r6
        L1e:
            kotlin.b.b(r7)     // Catch: java.lang.Exception -> L22
            goto L60
        L22:
            r7 = move-exception
            goto L46
        L24:
            kotlin.b.b(r7)
            com.yunbao.im.dao.IMDbHelper r7 = r6.c     // Catch: java.lang.Exception -> L22
            qh1 r7 = com.yunbao.im.dao.IMDbHelper.b(r7)     // Catch: java.lang.Exception -> L22
            com.yunbao.im.dao.IMMessageBean r1 = r6.d     // Catch: java.lang.Exception -> L22
            r7.a(r1)     // Catch: java.lang.Exception -> L22
            ra2 r7 = defpackage.in0.c()     // Catch: java.lang.Exception -> L22
            com.yunbao.im.dao.IMDbHelper$updateMsg$1$1 r1 = new com.yunbao.im.dao.IMDbHelper$updateMsg$1$1     // Catch: java.lang.Exception -> L22
            n81 r5 = r6.e     // Catch: java.lang.Exception -> L22
            r1.<init>(r5, r2)     // Catch: java.lang.Exception -> L22
            r6.b = r4     // Catch: java.lang.Exception -> L22
            java.lang.Object r6 = defpackage.tk.e(r7, r1, r6)     // Catch: java.lang.Exception -> L22
            if (r6 != r0) goto L60
            goto L5f
        L46:
            ra2 r1 = defpackage.in0.c()
            com.yunbao.im.dao.IMDbHelper$updateMsg$1$2 r4 = new com.yunbao.im.dao.IMDbHelper$updateMsg$1$2
            n81 r5 = r6.e
            r4.<init>(r5, r2)
            java.lang.Object r7 = defpackage.ps3.a(r7)
            r6.a = r7
            r6.b = r3
            java.lang.Object r6 = defpackage.tk.e(r1, r4, r6)
            if (r6 != r0) goto L60
        L5f:
            return r0
        L60:
            qc4 r6 = defpackage.qc4.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yunbao.im.dao.IMDbHelper$updateMsg$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
