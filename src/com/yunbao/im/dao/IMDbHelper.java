package com.yunbao.im.dao;

import android.content.Context;
import defpackage.in0;
import defpackage.n81;
import defpackage.px3;
import defpackage.qh1;
import defpackage.s70;
import defpackage.t30;
import defpackage.th1;
import defpackage.uk;
import java.util.List;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.d;

/* loaded from: /tmp/classes2.dex */
public final class IMDbHelper {
    public static final a f = new a(null);
    public static volatile IMDbHelper g;
    public final AppDatabase a;
    public final th1 b;
    public final qh1 c;
    public final t30 d;
    public final s70 e;

    /* loaded from: /tmp/classes2.dex */
    public static final class a {
        public a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final IMDbHelper a(Context context) {
            IMDbHelper iMDbHelper;
            context.getClass();
            IMDbHelper iMDbHelper2 = IMDbHelper.g;
            if (iMDbHelper2 != null) {
                return iMDbHelper2;
            }
            synchronized (this) {
                Context applicationContext = context.getApplicationContext();
                applicationContext.getClass();
                iMDbHelper = new IMDbHelper(applicationContext, null);
                IMDbHelper.g = iMDbHelper;
            }
            return iMDbHelper;
        }
    }

    public IMDbHelper(Context context) {
        AppDatabase a2 = AppDatabase.INSTANCE.a(context);
        this.a = a2;
        this.b = a2.D();
        this.c = a2.C();
        t30 b = px3.b(null, 1, null);
        this.d = b;
        this.e = d.a(in0.b().plus(b));
    }

    public /* synthetic */ IMDbHelper(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    public final void e(String str, n81 n81Var) {
        str.getClass();
        n81Var.getClass();
        uk.d(this.e, null, null, new IMDbHelper$deleteUser$1(this, str, n81Var, null), 3, null);
    }

    public final void f(String str, n81 n81Var) {
        str.getClass();
        n81Var.getClass();
        uk.d(this.e, null, null, new IMDbHelper$deleteUserAllMsg$1(this, str, n81Var, null), 3, null);
    }

    public final void g(String str, n81 n81Var) {
        str.getClass();
        n81Var.getClass();
        uk.d(this.e, null, null, new IMDbHelper$getMsgByUser$1(this, str, n81Var, null), 3, null);
    }

    public final void h(String str, n81 n81Var) {
        str.getClass();
        n81Var.getClass();
        uk.d(this.e, null, null, new IMDbHelper$getSingleMsgByUser$1(this, str, n81Var, null), 3, null);
    }

    public final void i(n81 n81Var) {
        n81Var.getClass();
        uk.d(this.e, null, null, new IMDbHelper$getUser$1(this, n81Var, null), 3, null);
    }

    public final void j(IMMessageBean iMMessageBean, n81 n81Var) {
        iMMessageBean.getClass();
        n81Var.getClass();
        uk.d(this.e, null, null, new IMDbHelper$insertMsg$1(this, iMMessageBean, n81Var, null), 3, null);
    }

    public final void k(List list, n81 n81Var) {
        list.getClass();
        n81Var.getClass();
        uk.d(this.e, null, null, new IMDbHelper$insertMsgs$1(this, list, n81Var, null), 3, null);
    }

    public final void l(IMUserBean iMUserBean, n81 n81Var) {
        iMUserBean.getClass();
        n81Var.getClass();
        uk.d(this.e, null, null, new IMDbHelper$insertUser$1(this, iMUserBean, n81Var, null), 3, null);
    }

    public final void m(IMUserBean iMUserBean, n81 n81Var) {
        iMUserBean.getClass();
        n81Var.getClass();
        uk.d(this.e, null, null, new IMDbHelper$insertUserRepace$1(this, iMUserBean, n81Var, null), 3, null);
    }

    public final void n(List list, n81 n81Var) {
        list.getClass();
        n81Var.getClass();
        uk.d(this.e, null, null, new IMDbHelper$insertUsers$1(this, list, n81Var, null), 3, null);
    }

    public final void o(IMMessageBean iMMessageBean, n81 n81Var) {
        iMMessageBean.getClass();
        n81Var.getClass();
        uk.d(this.e, null, null, new IMDbHelper$updateMsg$1(this, iMMessageBean, n81Var, null), 3, null);
    }
}
