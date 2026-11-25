package com.yunbao.main;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.linkforty.sdk.LinkForty;
import com.linkforty.sdk.models.CreateLinkOptions;
import com.linkforty.sdk.models.DeepLinkData;
import com.umeng.analytics.pro.bv;
import com.umeng.analytics.pro.g;
import com.yunbao.main.LinkFortyWrapper;
import defpackage.ad1;
import defpackage.b91;
import defpackage.in0;
import defpackage.n81;
import defpackage.qc4;
import defpackage.tk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 &2\u00020\u0001:\u0001'B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0015\u0010\f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\f\u0010\u000bJ+\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\r¢\u0006\u0004\b\u000f\u0010\u0010J9\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\u00112\"\u0010\u000e\u001a\u001e\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\f\u0012\n\u0018\u00010\u0015j\u0004\u0018\u0001`\u0016\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\u0004\b\u0017\u0010\u0018J+\u0010\u001a\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0014\u0010\u000e\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\t0\r¢\u0006\u0004\b\u001a\u0010\u0010J\u001d\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001b¢\u0006\u0004\b\u001d\u0010\u001eJ1\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u00042\u001a\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u001b\u0012\u0006\u0012\u0004\u0018\u00010\u0019\u0012\u0004\u0012\u00020\t0\u0013¢\u0006\u0004\b\u001f\u0010 R\"\u0010!\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b!\u0010\"\u001a\u0004\b!\u0010#\"\u0004\b$\u0010%¨\u0006("}, d2 = {"Lcom/yunbao/main/LinkFortyWrapper;", "", "<init>", "()V", "Landroid/content/Context;", g.X, "", "shouldReportInstall", "(Landroid/content/Context;)Z", "Lqc4;", "incrementInstallCount", "(Landroid/content/Context;)V", "markInstallBound", "Lkotlin/Function1;", "callback", "initialize", "(Landroid/content/Context;Ln81;)V", "Lcom/linkforty/sdk/models/CreateLinkOptions;", "options", "Lkotlin/Function2;", "Lcom/linkforty/sdk/models/CreateLinkResult;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "createLink", "(Lcom/linkforty/sdk/models/CreateLinkOptions;Lb91;)V", "Lcom/linkforty/sdk/models/DeepLinkData;", "setDeferredDeepLinkCallback", "Landroid/net/Uri;", "uri", "handleDeepLink", "(Landroid/content/Context;Landroid/net/Uri;)V", "setDeepLinkCallback", "(Landroid/content/Context;Lb91;)V", "isInit", "Z", "()Z", "setInit", "(Z)V", "Companion", bv.av, "main_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: /tmp/classes2.dex */
public final class LinkFortyWrapper {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String KEY_INSTALL_BOUND = "install_bound";
    private static final String KEY_INSTALL_COUNT = "install_count";
    private static final int MAX_INSTALL_ATTEMPTS = 10;
    private static final String SP_NAME = "linkforty_wrapper";
    private static LinkFortyWrapper instance;
    private boolean isInit;

    /* renamed from: com.yunbao.main.LinkFortyWrapper$a, reason: from kotlin metadata */
    /* loaded from: /tmp/classes2.dex */
    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final LinkFortyWrapper a() {
            if (LinkFortyWrapper.instance == null) {
                LinkFortyWrapper.instance = new LinkFortyWrapper(null);
            }
            LinkFortyWrapper linkFortyWrapper = LinkFortyWrapper.instance;
            linkFortyWrapper.getClass();
            return linkFortyWrapper;
        }
    }

    private LinkFortyWrapper() {
    }

    public /* synthetic */ LinkFortyWrapper(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static qc4 b(n81 n81Var, DeepLinkData deepLinkData) {
        n81Var.invoke(deepLinkData);
        return qc4.a;
    }

    public static qc4 c(b91 b91Var, Uri uri, DeepLinkData deepLinkData) {
        uri.getClass();
        b91Var.invoke(uri, deepLinkData);
        return qc4.a;
    }

    public static qc4 d(final n81 n81Var, boolean z) {
        if (z) {
            LinkForty.Companion.getShared().onDeferredDeepLink(new n81() { // from class: jz1
                @Override // defpackage.n81
                public final Object invoke(Object obj) {
                    qc4 deferredDeepLinkCallback$lambda$1$0;
                    deferredDeepLinkCallback$lambda$1$0 = LinkFortyWrapper.setDeferredDeepLinkCallback$lambda$1$0(n81.this, (DeepLinkData) obj);
                    return deferredDeepLinkCallback$lambda$1$0;
                }
            });
        }
        return qc4.a;
    }

    public static qc4 e(Uri uri, boolean z) {
        if (z) {
            LinkForty.Companion.getShared().handleDeepLink(uri);
        }
        return qc4.a;
    }

    public static qc4 g(final b91 b91Var, boolean z) {
        if (z) {
            LinkForty.Companion.getShared().onDeepLink(new b91() { // from class: kz1
                @Override // defpackage.b91
                public final Object invoke(Object obj, Object obj2) {
                    qc4 deepLinkCallback$lambda$1$0;
                    deepLinkCallback$lambda$1$0 = LinkFortyWrapper.setDeepLinkCallback$lambda$1$0(b91.this, (Uri) obj, (DeepLinkData) obj2);
                    return deepLinkCallback$lambda$1$0;
                }
            });
        }
        return qc4.a;
    }

    public static final LinkFortyWrapper getInstance() {
        return INSTANCE.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void incrementInstallCount(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(SP_NAME, 0);
        sharedPreferences.edit().putInt(KEY_INSTALL_COUNT, sharedPreferences.getInt(KEY_INSTALL_COUNT, 0) + 1).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qc4 setDeepLinkCallback$lambda$1$0(b91 b91Var, Uri uri, DeepLinkData deepLinkData) {
        uri.getClass();
        b91Var.invoke(uri, deepLinkData);
        return qc4.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final qc4 setDeferredDeepLinkCallback$lambda$1$0(n81 n81Var, DeepLinkData deepLinkData) {
        n81Var.invoke(deepLinkData);
        return qc4.a;
    }

    private final boolean shouldReportInstall(Context context) {
        SharedPreferences sharedPreferences = context.getApplicationContext().getSharedPreferences(SP_NAME, 0);
        return !sharedPreferences.getBoolean(KEY_INSTALL_BOUND, false) && sharedPreferences.getInt(KEY_INSTALL_COUNT, 0) < 10;
    }

    public final void createLink(CreateLinkOptions options, b91 callback) {
        options.getClass();
        callback.getClass();
        tk.d(ad1.a, in0.b(), null, new LinkFortyWrapper$createLink$1(callback, null), 2, null);
    }

    public final void handleDeepLink(Context context, final Uri uri) {
        context.getClass();
        uri.getClass();
        if (this.isInit) {
            LinkForty.Companion.getShared().handleDeepLink(uri);
        } else {
            initialize(context, new n81() { // from class: pz1
                @Override // defpackage.n81
                public final Object invoke(Object obj) {
                    return LinkFortyWrapper.e(uri, ((Boolean) obj).booleanValue());
                }
            });
        }
    }

    public final void initialize(Context context, n81 callback) {
        context.getClass();
        if (this.isInit) {
            if (callback != null) {
                callback.invoke(Boolean.TRUE);
            }
        } else if (shouldReportInstall(context)) {
            tk.d(ad1.a, in0.b(), null, new LinkFortyWrapper$initialize$1(this, context, callback, null), 2, null);
        } else if (callback != null) {
            callback.invoke(Boolean.FALSE);
        }
    }

    /* renamed from: isInit, reason: from getter */
    public final boolean getIsInit() {
        return this.isInit;
    }

    public final void markInstallBound(Context context) {
        context.getClass();
        context.getApplicationContext().getSharedPreferences(SP_NAME, 0).edit().putBoolean(KEY_INSTALL_BOUND, true).apply();
    }

    public final void setDeepLinkCallback(Context context, final b91 callback) {
        context.getClass();
        callback.getClass();
        if (this.isInit) {
            LinkForty.Companion.getShared().onDeepLink(new b91() { // from class: nz1
                @Override // defpackage.b91
                public final Object invoke(Object obj, Object obj2) {
                    return LinkFortyWrapper.c(b91.this, (Uri) obj, (DeepLinkData) obj2);
                }
            });
        } else {
            initialize(context, new n81() { // from class: oz1
                @Override // defpackage.n81
                public final Object invoke(Object obj) {
                    return LinkFortyWrapper.g(b91.this, ((Boolean) obj).booleanValue());
                }
            });
        }
    }

    public final void setDeferredDeepLinkCallback(Context context, final n81 callback) {
        context.getClass();
        callback.getClass();
        if (this.isInit) {
            LinkForty.Companion.getShared().onDeferredDeepLink(new n81() { // from class: lz1
                @Override // defpackage.n81
                public final Object invoke(Object obj) {
                    return LinkFortyWrapper.b(n81.this, (DeepLinkData) obj);
                }
            });
        } else {
            initialize(context, new n81() { // from class: mz1
                @Override // defpackage.n81
                public final Object invoke(Object obj) {
                    return LinkFortyWrapper.d(n81.this, ((Boolean) obj).booleanValue());
                }
            });
        }
    }

    public final void setInit(boolean z) {
        this.isInit = z;
    }
}
