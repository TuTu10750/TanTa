package com.yunbao.main;

import com.linkforty.sdk.LinkForty;
import com.linkforty.sdk.models.CreateLinkOptions;
import com.linkforty.sdk.models.CreateLinkResult;
import com.linkforty.sdk.models.UTMParameters;
import com.umeng.commonsdk.statistics.UMErrorCode;
import defpackage.b91;
import defpackage.eq1;
import defpackage.fl3;
import defpackage.g94;
import defpackage.in0;
import defpackage.ka0;
import defpackage.qc4;
import defpackage.s70;
import defpackage.sc2;
import defpackage.u60;
import defpackage.uk;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Ls70;", "Lqc4;", "<anonymous>", "(Ls70;)V"}, k = 3, mv = {2, 3, 0})
@ka0(c = "com.yunbao.main.LinkFortyWrapper$createLink$1", f = "LinkFortyWrapper.kt", l = {UMErrorCode.E_UM_BE_EMPTY_URL_PATH}, m = "invokeSuspend", v = 2)
/* loaded from: /tmp/classes2.dex */
public final class LinkFortyWrapper$createLink$1 extends SuspendLambda implements b91 {
    public int a;
    public /* synthetic */ Object b;
    public final /* synthetic */ b91 c;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Ls70;", "Lqc4;", "<anonymous>", "(Ls70;)V"}, k = 3, mv = {2, 3, 0})
    @ka0(c = "com.yunbao.main.LinkFortyWrapper$createLink$1$1", f = "LinkFortyWrapper.kt", l = {}, m = "invokeSuspend", v = 2)
    /* renamed from: com.yunbao.main.LinkFortyWrapper$createLink$1$1, reason: invalid class name */
    /* loaded from: /tmp/classes2.dex */
    public static final class AnonymousClass1 extends SuspendLambda implements b91 {
        public int a;
        public final /* synthetic */ b91 b;
        public final /* synthetic */ CreateLinkResult c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(b91 b91Var, CreateLinkResult createLinkResult, u60 u60Var) {
            super(2, u60Var);
            this.b = b91Var;
            this.c = createLinkResult;
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
            this.b.invoke(this.c, null);
            return qc4.a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Ls70;", "Lqc4;", "<anonymous>", "(Ls70;)V"}, k = 3, mv = {2, 3, 0})
    @ka0(c = "com.yunbao.main.LinkFortyWrapper$createLink$1$2", f = "LinkFortyWrapper.kt", l = {}, m = "invokeSuspend", v = 2)
    /* renamed from: com.yunbao.main.LinkFortyWrapper$createLink$1$2, reason: invalid class name */
    /* loaded from: /tmp/classes2.dex */
    public static final class AnonymousClass2 extends SuspendLambda implements b91 {
        public int a;
        public final /* synthetic */ b91 b;
        public final /* synthetic */ Exception c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(b91 b91Var, Exception exc, u60 u60Var) {
            super(2, u60Var);
            this.b = b91Var;
            this.c = exc;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final u60 create(Object obj, u60 u60Var) {
            return new AnonymousClass2(this.b, this.c, u60Var);
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
            this.b.invoke(null, this.c);
            return qc4.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkFortyWrapper$createLink$1(b91 b91Var, u60 u60Var) {
        super(2, u60Var);
        this.c = b91Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final u60 create(Object obj, u60 u60Var) {
        LinkFortyWrapper$createLink$1 linkFortyWrapper$createLink$1 = new LinkFortyWrapper$createLink$1(this.c, u60Var);
        linkFortyWrapper$createLink$1.b = obj;
        return linkFortyWrapper$createLink$1;
    }

    @Override // defpackage.b91
    public final Object invoke(s70 s70Var, u60 u60Var) {
        return ((LinkFortyWrapper$createLink$1) create(s70Var, u60Var)).invokeSuspend(qc4.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object createLink;
        s70 s70Var = (s70) this.b;
        Object e = eq1.e();
        int i = this.a;
        try {
            if (i == 0) {
                b.b(obj);
                LinkForty shared = LinkForty.Companion.getShared();
                CreateLinkOptions createLinkOptions = new CreateLinkOptions((String) null, (String) null, sc2.f(g94.a("share_code", "990334")), "hello!", (String) null, (String) null, new UTMParameters("app", (String) null, "share", (String) null, (String) null, 26, (DefaultConstructorMarker) null), (String) null, 179, (DefaultConstructorMarker) null);
                this.b = s70Var;
                this.a = 1;
                createLink = shared.createLink(createLinkOptions, this);
                if (createLink == e) {
                    return e;
                }
            } else {
                if (i != 1) {
                    fl3.a("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                b.b(obj);
                createLink = obj;
            }
            uk.d(s70Var, in0.c(), null, new AnonymousClass1(this.c, (CreateLinkResult) createLink, null), 2, null);
        } catch (Exception e2) {
            e2.printStackTrace();
            uk.d(s70Var, in0.c(), null, new AnonymousClass2(this.c, e2, null), 2, null);
        }
        return qc4.a;
    }
}
