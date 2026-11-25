package com.yunbao.main;

import android.content.Context;
import android.provider.Settings;
import com.linkforty.sdk.LinkForty;
import com.linkforty.sdk.models.LinkFortyConfig;
import com.netshield.Netshield;
import com.yunbao.common.CommonAppContext;
import defpackage.b91;
import defpackage.eq1;
import defpackage.fl3;
import defpackage.in0;
import defpackage.j30;
import defpackage.ka0;
import defpackage.n81;
import defpackage.ps3;
import defpackage.qc4;
import defpackage.s70;
import defpackage.u60;
import defpackage.uk;
import kotlin.Metadata;
import kotlin.b;
import kotlin.coroutines.jvm.internal.SuspendLambda;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Ls70;", "Lqc4;", "<anonymous>", "(Ls70;)V"}, k = 3, mv = {2, 3, 0})
@ka0(c = "com.yunbao.main.LinkFortyWrapper$initialize$1", f = "LinkFortyWrapper.kt", l = {89}, m = "invokeSuspend", v = 2)
/* loaded from: /tmp/classes2.dex */
public final class LinkFortyWrapper$initialize$1 extends SuspendLambda implements b91 {
    public Object a;
    public Object b;
    public int c;
    public int d;
    public /* synthetic */ Object e;
    public final /* synthetic */ LinkFortyWrapper f;
    public final /* synthetic */ Context g;
    public final /* synthetic */ n81 h;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Ls70;", "Lqc4;", "<anonymous>", "(Ls70;)V"}, k = 3, mv = {2, 3, 0})
    @ka0(c = "com.yunbao.main.LinkFortyWrapper$initialize$1$1", f = "LinkFortyWrapper.kt", l = {}, m = "invokeSuspend", v = 2)
    /* renamed from: com.yunbao.main.LinkFortyWrapper$initialize$1$1, reason: invalid class name */
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
            n81 n81Var = this.b;
            if (n81Var != null) {
                n81Var.invoke(ek.a(true));
            }
            return qc4.a;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Ls70;", "Lqc4;", "<anonymous>", "(Ls70;)V"}, k = 3, mv = {2, 3, 0})
    @ka0(c = "com.yunbao.main.LinkFortyWrapper$initialize$1$2", f = "LinkFortyWrapper.kt", l = {}, m = "invokeSuspend", v = 2)
    /* renamed from: com.yunbao.main.LinkFortyWrapper$initialize$1$2, reason: invalid class name */
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
            n81 n81Var = this.b;
            if (n81Var != null) {
                n81Var.invoke(ek.a(false));
            }
            return qc4.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public LinkFortyWrapper$initialize$1(LinkFortyWrapper linkFortyWrapper, Context context, n81 n81Var, u60 u60Var) {
        super(2, u60Var);
        this.f = linkFortyWrapper;
        this.g = context;
        this.h = n81Var;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final u60 create(Object obj, u60 u60Var) {
        LinkFortyWrapper$initialize$1 linkFortyWrapper$initialize$1 = new LinkFortyWrapper$initialize$1(this.f, this.g, this.h, u60Var);
        linkFortyWrapper$initialize$1.e = obj;
        return linkFortyWrapper$initialize$1;
    }

    @Override // defpackage.b91
    public final Object invoke(s70 s70Var, u60 u60Var) {
        return ((LinkFortyWrapper$initialize$1) create(s70Var, u60Var)).invokeSuspend(qc4.a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        s70 s70Var;
        s70 s70Var2 = (s70) this.e;
        Object e = eq1.e();
        int i = this.d;
        try {
            if (i == 0) {
                b.b(obj);
                this.f.incrementInstallCount(this.g);
                int localhostPort = Netshield.getLocalhostPort(j30.J());
                String str = "http://127.0.0.1:" + localhostPort;
                LinkFortyConfig linkFortyConfig = new LinkFortyConfig(str, (String) null, false, 168);
                LinkForty.Companion companion = LinkForty.Companion;
                Context context = this.g;
                String string = Settings.Secure.getString(CommonAppContext.n().getContentResolver(), "android_id");
                this.e = s70Var2;
                this.a = ps3.a(str);
                this.b = ps3.a(linkFortyConfig);
                this.c = localhostPort;
                this.d = 1;
                if (companion.initialize(context, linkFortyConfig, 168, string, this) == e) {
                    return e;
                }
            } else {
                if (i != 1) {
                    fl3.a("call to 'resume' before 'invoke' with coroutine");
                    return null;
                }
                b.b(obj);
            }
            this.f.setInit(true);
            s70Var = s70Var2;
        } catch (Exception e2) {
            e = e2;
            s70Var = s70Var2;
        }
        try {
            uk.d(s70Var, in0.c(), null, new AnonymousClass1(this.h, null), 2, null);
        } catch (Exception e3) {
            e = e3;
            e.printStackTrace();
            this.f.setInit(false);
            uk.d(s70Var, in0.c(), null, new AnonymousClass2(this.h, null), 2, null);
            return qc4.a;
        }
        return qc4.a;
    }
}
