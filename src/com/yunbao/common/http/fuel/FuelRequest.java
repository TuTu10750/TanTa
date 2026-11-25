package com.yunbao.common.http.fuel;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.kittinunf.fuel.Fuel;
import com.github.kittinunf.fuel.core.FuelError;
import com.github.kittinunf.fuel.core.Request;
import com.github.kittinunf.fuel.core.RequestFactory;
import com.github.kittinunf.fuel.core.Response;
import com.github.kittinunf.fuel.core.ResponseHandler;
import com.github.kittinunf.fuel.core.extensions.FormattingKt;
import com.github.kittinunf.fuel.core.requests.CancellableRequest;
import com.umeng.analytics.pro.cl;
import com.umeng.umcrash.UMCrash;
import com.yunbao.common.http.Data;
import com.yunbao.common.http.FileDownloadCallback;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.http.IHttpRequest;
import com.yunbao.common.http.StringHttpCallback;
import com.yunbao.common.http.UriDownloadCallback;
import com.yunbao.common.http.fuel.FuelRequest;
import com.yunbao.common.utils.MemoryPressureUtil;
import defpackage.b30;
import defpackage.dq1;
import defpackage.fw3;
import defpackage.gu0;
import defpackage.hw3;
import defpackage.l81;
import defpackage.lx1;
import defpackage.n81;
import defpackage.qc4;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.enums.a;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

@Metadata(d1 = {"\u0000²\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010%\n\u0002\b\f\u0018\u00002\u00020\u0001:\u0001nB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\u000e\u001a\u00020\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0013\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0011\u001a\u00020\u0010H\u0002¢\u0006\u0004\b\u0013\u0010\u0014J\u0017\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0016\u0010\u000bJ'\u0010\u001b\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ+\u0010\u001f\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0015\u001a\u00020\u00022\n\u0010\u001a\u001a\u00060\u001dj\u0002`\u001eH\u0002¢\u0006\u0004\b\u001f\u0010 J'\u0010\"\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020!2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\"\u0010#J\u0013\u0010$\u001a\u00020\u0012*\u00020\u0010H\u0002¢\u0006\u0004\b$\u0010\u0014J\u0019\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020%*\u00020\u0010H\u0002¢\u0006\u0004\b&\u0010'J\u0019\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00020%*\u00020\u0002H\u0002¢\u0006\u0004\b&\u0010(J\u0019\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00020%*\u00020\u0010H\u0002¢\u0006\u0004\b)\u0010'J\u000f\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b+\u0010,J\u0013\u0010-\u001a\u00020**\u00020\u0010H\u0002¢\u0006\u0004\b-\u0010.J\u001b\u00100\u001a\b\u0012\u0004\u0012\u00020\u00020%*\u0004\u0018\u00010/H\u0002¢\u0006\u0004\b0\u00101J)\u00106\u001a\u00020\u00022\u001a\u00105\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u0001040302¢\u0006\u0004\b6\u00107J\u0015\u00109\u001a\u00020\u00012\u0006\u00108\u001a\u00020\u0002¢\u0006\u0004\b9\u0010:J!\u00105\u001a\u00020\u00012\u0006\u0010;\u001a\u00020\u00022\b\u0010<\u001a\u0004\u0018\u000104H\u0016¢\u0006\u0004\b5\u0010=J\u001f\u0010>\u001a\u00020\u00012\u0006\u0010;\u001a\u00020\u00022\u0006\u0010<\u001a\u00020\u0002H\u0016¢\u0006\u0004\b>\u0010?J\r\u0010@\u001a\u00020\t¢\u0006\u0004\b@\u0010AJ\u0017\u0010B\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u0017H\u0016¢\u0006\u0004\bB\u0010CJ\u0017\u0010B\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020!H\u0016¢\u0006\u0004\bB\u0010DJ'\u0010B\u001a\u00020\t2\u0006\u0010F\u001a\u00020E2\u0006\u0010G\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020HH\u0016¢\u0006\u0004\bB\u0010IJ\u001f\u0010B\u001a\u00020\t2\u0006\u0010K\u001a\u00020J2\u0006\u0010\u0018\u001a\u00020LH\u0016¢\u0006\u0004\bB\u0010MR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010N\u001a\u0004\bO\u0010PR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010Q\u001a\u0004\bR\u0010SR+\u0010U\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u000104030T8\u0006¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR\u001a\u0010Y\u001a\u00020*8\u0006X\u0086D¢\u0006\f\n\u0004\bY\u0010Z\u001a\u0004\b[\u0010,R$\u0010]\u001a\u0004\u0018\u00010\\8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b]\u0010^\u001a\u0004\b_\u0010`\"\u0004\ba\u0010bR0\u0010d\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u0002\u0018\u00010c8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bd\u0010e\u001a\u0004\bf\u0010g\"\u0004\bh\u0010iR6\u0010j\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u000104030T8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bj\u0010V\u001a\u0004\bk\u0010X\"\u0004\bl\u0010m¨\u0006o"}, d2 = {"Lcom/yunbao/common/http/fuel/FuelRequest;", "Lcom/yunbao/common/http/IHttpRequest;", "", "mUrl", "Lcom/yunbao/common/http/fuel/FuelRequest$Method;", "mMehtod", "<init>", "(Ljava/lang/String;Lcom/yunbao/common/http/fuel/FuelRequest$Method;)V", "content", "Lqc4;", "log", "(Ljava/lang/String;)V", "", "maxLength", "previewLog", "(Ljava/lang/String;I)Ljava/lang/String;", "Lcom/alibaba/fastjson/JSONObject;", "jsonObject", "Lcom/yunbao/common/http/Data;", "parseHttpData", "(Lcom/alibaba/fastjson/JSONObject;)Lcom/yunbao/common/http/Data;", "stage", "clearMemoryIfCritical", "Lcom/yunbao/common/http/HttpCallback;", "callback", "Ljava/lang/OutOfMemoryError;", "error", "handleHttpResponseOom", "(Lcom/yunbao/common/http/HttpCallback;Ljava/lang/String;Ljava/lang/OutOfMemoryError;)V", "Ljava/lang/Exception;", "Lkotlin/Exception;", "handleHttpResponseException", "(Lcom/yunbao/common/http/HttpCallback;Ljava/lang/String;Ljava/lang/Exception;)V", "Lcom/yunbao/common/http/StringHttpCallback;", "handleStringResponseOom", "(Lcom/yunbao/common/http/StringHttpCallback;Ljava/lang/String;Ljava/lang/OutOfMemoryError;)V", "toHttpData", "", "toInfoStringArray", "(Lcom/alibaba/fastjson/JSONObject;)[Ljava/lang/String;", "(Ljava/lang/String;)[Ljava/lang/String;", "paymentPayloadStringArray", "", "isPaymentRequest", "()Z", "hasPaymentUrlField", "(Lcom/alibaba/fastjson/JSONObject;)Z", "Lcom/alibaba/fastjson/JSONArray;", "toStringArray", "(Lcom/alibaba/fastjson/JSONArray;)[Ljava/lang/String;", "", "Lkotlin/Pair;", "", "params", "pairsToQueryString", "(Ljava/util/List;)Ljava/lang/String;", "serviceName", "setServiceName", "(Ljava/lang/String;)Lcom/yunbao/common/http/IHttpRequest;", "key", "value", "(Ljava/lang/String;Ljava/lang/Object;)Lcom/yunbao/common/http/IHttpRequest;", "headers", "(Ljava/lang/String;Ljava/lang/String;)Lcom/yunbao/common/http/IHttpRequest;", "cancel", "()V", "execute", "(Lcom/yunbao/common/http/HttpCallback;)V", "(Lcom/yunbao/common/http/StringHttpCallback;)V", "Ljava/io/File;", "dir", "fileName", "Lcom/yunbao/common/http/FileDownloadCallback;", "(Ljava/io/File;Ljava/lang/String;Lcom/yunbao/common/http/FileDownloadCallback;)V", "Landroid/net/Uri;", "uri", "Lcom/yunbao/common/http/UriDownloadCallback;", "(Landroid/net/Uri;Lcom/yunbao/common/http/UriDownloadCallback;)V", "Ljava/lang/String;", "getMUrl", "()Ljava/lang/String;", "Lcom/yunbao/common/http/fuel/FuelRequest$Method;", "getMMehtod", "()Lcom/yunbao/common/http/fuel/FuelRequest$Method;", "", "mParams", "Ljava/util/List;", "getMParams", "()Ljava/util/List;", "mDebug", "Z", "getMDebug", "Lcom/github/kittinunf/fuel/core/requests/CancellableRequest;", "mReq", "Lcom/github/kittinunf/fuel/core/requests/CancellableRequest;", "getMReq", "()Lcom/github/kittinunf/fuel/core/requests/CancellableRequest;", "setMReq", "(Lcom/github/kittinunf/fuel/core/requests/CancellableRequest;)V", "", "mHeaders", "Ljava/util/Map;", "getMHeaders", "()Ljava/util/Map;", "setMHeaders", "(Ljava/util/Map;)V", "serviceMap", "getServiceMap", "setServiceMap", "(Ljava/util/List;)V", "Method", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: /tmp/classes2.dex */
public final class FuelRequest implements IHttpRequest {
    private final boolean mDebug;
    private Map<String, String> mHeaders;
    private final Method mMehtod;
    private final List<Pair<String, Object>> mParams;
    private CancellableRequest mReq;
    private final String mUrl;
    private List<Pair<String, Object>> serviceMap;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/yunbao/common/http/fuel/FuelRequest$Method;", "", "<init>", "(Ljava/lang/String;I)V", "GET", "POST", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
    /* loaded from: /tmp/classes2.dex */
    public static final class Method {
        private static final /* synthetic */ gu0 $ENTRIES;
        private static final /* synthetic */ Method[] $VALUES;
        public static final Method GET = new Method("GET", 0);
        public static final Method POST = new Method("POST", 1);

        private static final /* synthetic */ Method[] $values() {
            return new Method[]{GET, POST};
        }

        static {
            Method[] $values = $values();
            $VALUES = $values;
            $ENTRIES = a.a($values);
        }

        private Method(String str, int i) {
        }

        public static gu0 getEntries() {
            return $ENTRIES;
        }

        public static Method valueOf(String str) {
            return (Method) Enum.valueOf(Method.class, str);
        }

        public static Method[] values() {
            return (Method[]) $VALUES.clone();
        }
    }

    public FuelRequest(String str, Method method) {
        str.getClass();
        method.getClass();
        this.mUrl = str;
        this.mMehtod = method;
        this.mParams = new ArrayList();
        this.serviceMap = new ArrayList();
    }

    public /* synthetic */ FuelRequest(String str, Method method, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? Method.GET : method);
    }

    public static qc4 a(final Ref$IntRef ref$IntRef, FuelRequest fuelRequest, Executor executor, final FileDownloadCallback fileDownloadCallback, long j, long j2) {
        int i = (int) ((((float) j) / ((float) j2)) * 100.0f);
        if (ref$IntRef.a != i) {
            ref$IntRef.a = i;
            if (fuelRequest.mDebug) {
                fuelRequest.log("下载进度--->" + ref$IntRef.a);
            }
            executor.execute(new Runnable() { // from class: a81
                @Override // java.lang.Runnable
                public final void run() {
                    FuelRequest.execute$lambda$7$0(FileDownloadCallback.this, ref$IntRef);
                }
            });
        }
        return qc4.a;
    }

    public static Pair c(Ref$ObjectRef ref$ObjectRef, final Ref$ObjectRef ref$ObjectRef2, Response response, final Request request) {
        response.getClass();
        request.getClass();
        return new Pair(ref$ObjectRef.a, new l81() { // from class: b81
            @Override // defpackage.l81
            public final Object invoke() {
                InputStream execute$lambda$6$0;
                execute$lambda$6$0 = FuelRequest.execute$lambda$6$0(Ref$ObjectRef.this, request);
                return execute$lambda$6$0;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void clearMemoryIfCritical(String stage) {
        if (MemoryPressureUtil.i()) {
            lx1.c("9527", "clear memory before " + stage + ", url=" + this.mUrl + ", available=" + MemoryPressureUtil.g());
            MemoryPressureUtil.e();
        }
    }

    public static qc4 d(final Ref$IntRef ref$IntRef, FuelRequest fuelRequest, Executor executor, final UriDownloadCallback uriDownloadCallback, long j, long j2) {
        int i = (int) ((((float) j) / ((float) j2)) * 100.0f);
        if (ref$IntRef.a != i) {
            ref$IntRef.a = i;
            if (fuelRequest.mDebug) {
                fuelRequest.log("下载进度--->" + ref$IntRef.a);
            }
            executor.execute(new Runnable() { // from class: z71
                @Override // java.lang.Runnable
                public final void run() {
                    FuelRequest.execute$lambda$10$0(UriDownloadCallback.this, ref$IntRef);
                }
            });
        }
        return qc4.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void execute$lambda$10$0(UriDownloadCallback uriDownloadCallback, Ref$IntRef ref$IntRef) {
        uriDownloadCallback.onProgress(ref$IntRef.a / 100.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InputStream execute$lambda$6$0(Ref$ObjectRef ref$ObjectRef, Request request) {
        InputStream stream = request.getBody().toStream();
        ref$ObjectRef.a = stream;
        stream.getClass();
        return stream;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void execute$lambda$7$0(FileDownloadCallback fileDownloadCallback, Ref$IntRef ref$IntRef) {
        fileDownloadCallback.onProgress(ref$IntRef.a / 100.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final InputStream execute$lambda$9$0(Ref$ObjectRef ref$ObjectRef, Request request) {
        InputStream stream = request.getBody().toStream();
        ref$ObjectRef.a = stream;
        stream.getClass();
        return stream;
    }

    public static Pair f(OutputStream outputStream, final Ref$ObjectRef ref$ObjectRef, Response response, final Request request) {
        response.getClass();
        request.getClass();
        return new Pair(outputStream, new l81() { // from class: x71
            @Override // defpackage.l81
            public final Object invoke() {
                InputStream execute$lambda$9$0;
                execute$lambda$9$0 = FuelRequest.execute$lambda$9$0(Ref$ObjectRef.this, request);
                return execute$lambda$9$0;
            }
        });
    }

    public static CharSequence g(Pair pair) {
        pair.getClass();
        return String.valueOf(pair.d());
    }

    public static CharSequence h(Pair pair) {
        pair.getClass();
        String str = (String) pair.getFirst();
        Object second = pair.getSecond();
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append('=');
        if (second == null) {
            second = "";
        }
        sb.append(second);
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleHttpResponseException(HttpCallback callback, String stage, Exception error) {
        lx1.c("9527", "http response error at " + stage + ", url=" + this.mUrl + ", type=" + error.getClass().getSimpleName() + ", message=" + error.getMessage());
        callback.onError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleHttpResponseOom(HttpCallback callback, String stage, OutOfMemoryError error) {
        lx1.c("9527", "http response oom at " + stage + ", url=" + this.mUrl + ", message=" + error.getMessage());
        MemoryPressureUtil.e();
        callback.onError();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleStringResponseOom(StringHttpCallback callback, String stage, OutOfMemoryError error) {
        lx1.c("9527", "string response oom at " + stage + ", url=" + this.mUrl + ", message=" + error.getMessage());
        MemoryPressureUtil.e();
        callback.onError(error);
    }

    private final boolean hasPaymentUrlField(JSONObject jSONObject) {
        return jSONObject.containsKey("pay_url") || jSONObject.containsKey("payUrl") || jSONObject.containsKey("payurl") || jSONObject.containsKey(IjkMediaPlayer.OnNativeInvokeListener.ARG_URL) || jSONObject.containsKey("redirect_url");
    }

    private final boolean isPaymentRequest() {
        List<Pair<String, Object>> list = this.serviceMap;
        if (list != null && list.isEmpty()) {
            return false;
        }
        Iterator<T> it = list.iterator();
        while (it.hasNext()) {
            Object second = ((Pair) it.next()).getSecond();
            if (dq1.a(second, "User.chargePay") || dq1.a(second, "User.vipPay")) {
                return true;
            }
        }
        return false;
    }

    public static boolean k(Pair pair) {
        pair.getClass();
        return dq1.a(pair.c(), UMCrash.SP_KEY_TIMESTAMP);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void log(String content) {
        lx1.c("9527", content);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Data parseHttpData(JSONObject jsonObject) {
        JSONObject parseObject;
        try {
            Object obj = jsonObject.get(cl.b);
            if (obj instanceof JSONObject) {
                return toHttpData((JSONObject) obj);
            }
            if (!(obj instanceof String) || (parseObject = JSON.parseObject((String) obj)) == null) {
                return null;
            }
            return toHttpData(parseObject);
        } catch (Exception unused) {
            return null;
        } catch (OutOfMemoryError unused2) {
            lx1.c("9527", "parse http data oom, url=" + this.mUrl);
            return null;
        }
    }

    private final String[] paymentPayloadStringArray(JSONObject jSONObject) {
        if (!isPaymentRequest() || !hasPaymentUrlField(jSONObject)) {
            return new String[0];
        }
        JSONObject jSONObject2 = new JSONObject();
        for (String str : jSONObject.keySet()) {
            if (!dq1.a(str, cl.g) && !dq1.a(str, cl.h)) {
                jSONObject2.put(str, jSONObject.get(str));
            }
        }
        String jSONString = jSONObject2.toJSONString();
        jSONString.getClass();
        return new String[]{jSONString};
    }

    private final String previewLog(String content, int maxLength) {
        if (content == null || content.length() <= maxLength) {
            return content == null ? "" : content;
        }
        return content.substring(0, maxLength) + "...(truncated, length=" + content.length() + ')';
    }

    public static /* synthetic */ String previewLog$default(FuelRequest fuelRequest, String str, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 4096;
        }
        return fuelRequest.previewLog(str, i);
    }

    private final Data toHttpData(JSONObject jSONObject) {
        Data data = new Data();
        data.setCode(jSONObject.getIntValue(cl.g));
        data.setMsg(jSONObject.getString(cl.h));
        data.setInfo(toInfoStringArray(jSONObject));
        return data;
    }

    private final String[] toInfoStringArray(JSONObject jSONObject) {
        Object obj = jSONObject.get("info");
        if (obj instanceof JSONArray) {
            return toStringArray((JSONArray) obj);
        }
        if (!(obj instanceof JSONObject)) {
            return obj instanceof String ? toInfoStringArray((String) obj) : obj == null ? paymentPayloadStringArray(jSONObject) : new String[]{obj.toString()};
        }
        String jSONString = ((JSONObject) obj).toJSONString();
        jSONString.getClass();
        return new String[]{jSONString};
    }

    private final String[] toInfoStringArray(String str) {
        String obj = hw3.P0(str).toString();
        if (obj.length() == 0) {
            return new String[0];
        }
        try {
            return fw3.J(obj, "[", false, 2, null) ? toStringArray(JSON.parseArray(obj)) : fw3.J(obj, "{", false, 2, null) ? new String[]{obj} : new String[]{obj};
        } catch (Exception unused) {
            return new String[]{obj};
        }
    }

    private final String[] toStringArray(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.isEmpty()) {
            return new String[0];
        }
        int size = jSONArray.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            Object obj = jSONArray.get(i);
            strArr[i] = obj == null ? "" : obj instanceof String ? (String) obj : obj.toString();
        }
        return strArr;
    }

    public final void cancel() {
        CancellableRequest cancellableRequest = this.mReq;
        if (cancellableRequest != null) {
            cancellableRequest.cancel();
        }
        this.mReq = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:17:? A[RETURN, SYNTHETIC] */
    @Override // com.yunbao.common.http.IHttpRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void execute(final android.net.Uri r11, final com.yunbao.common.http.UriDownloadCallback r12) {
        /*
            r10 = this;
            java.lang.String r0 = "开始下载===>"
            r11.getClass()
            r12.getClass()
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            com.yunbao.common.CommonAppContext r1 = com.yunbao.common.CommonAppContext.n()
            android.content.ContentResolver r1 = r1.getContentResolver()
            java.io.OutputStream r3 = r1.openOutputStream(r11)
            if (r3 != 0) goto L1d
            goto L9a
        L1d:
            kotlin.jvm.internal.Ref$IntRef r1 = new kotlin.jvm.internal.Ref$IntRef     // Catch: java.lang.Exception -> L7d
            r1.<init>()     // Catch: java.lang.Exception -> L7d
            com.github.kittinunf.fuel.Fuel r4 = com.github.kittinunf.fuel.Fuel.INSTANCE     // Catch: java.lang.Exception -> L7d
            java.lang.String r5 = r10.mUrl     // Catch: java.lang.Exception -> L7d
            java.util.List<kotlin.Pair<java.lang.String, java.lang.Object>> r7 = r10.mParams     // Catch: java.lang.Exception -> L7d
            r8 = 2
            r9 = 0
            r6 = 0
            com.github.kittinunf.fuel.core.requests.DownloadRequest r7 = com.github.kittinunf.fuel.core.RequestFactory.Convenience.DefaultImpls.download$default(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Exception -> L7d
            com.github.kittinunf.fuel.core.RequestExecutionOptions r4 = r7.getExecutionOptions()     // Catch: java.lang.Exception -> L7d
            java.util.concurrent.Executor r4 = r4.getCallbackExecutor()     // Catch: java.lang.Exception -> L7d
            g81 r5 = new g81     // Catch: java.lang.Exception -> L7d
            r5.<init>()     // Catch: java.lang.Exception -> L7d
            com.github.kittinunf.fuel.core.requests.DownloadRequest r5 = r7.streamDestination(r5)     // Catch: java.lang.Exception -> L7d
            h81 r6 = new h81     // Catch: java.lang.Exception -> L7d
            r6.<init>()     // Catch: java.lang.Exception -> L7d
            r5.progress(r6)     // Catch: java.lang.Exception -> L7d
            java.util.Map<java.lang.String, java.lang.String> r1 = r10.mHeaders     // Catch: java.lang.Exception -> L7d
            if (r1 == 0) goto L54
            r7.header(r1)     // Catch: java.lang.Exception -> L50
            goto L54
        L50:
            r0 = move-exception
            r11 = r0
            r4 = r10
            goto L80
        L54:
            boolean r1 = r10.mDebug     // Catch: java.lang.Exception -> L7d
            if (r1 == 0) goto L6b
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L50
            r1.<init>(r0)     // Catch: java.lang.Exception -> L50
            java.lang.String r0 = com.github.kittinunf.fuel.core.extensions.FormattingKt.httpString(r7)     // Catch: java.lang.Exception -> L50
            r1.append(r0)     // Catch: java.lang.Exception -> L50
            java.lang.String r0 = r1.toString()     // Catch: java.lang.Exception -> L50
            r10.log(r0)     // Catch: java.lang.Exception -> L50
        L6b:
            com.yunbao.common.http.fuel.FuelRequest$execute$14 r1 = new com.yunbao.common.http.fuel.FuelRequest$execute$14     // Catch: java.lang.Exception -> L7d
            r4 = r10
            r5 = r11
            r6 = r12
            r1.<init>()     // Catch: java.lang.Exception -> L7a
            com.github.kittinunf.fuel.core.requests.CancellableRequest r10 = r7.response(r1)     // Catch: java.lang.Exception -> L7a
            r4.mReq = r10     // Catch: java.lang.Exception -> L7a
            return
        L7a:
            r0 = move-exception
        L7b:
            r11 = r0
            goto L80
        L7d:
            r0 = move-exception
            r4 = r10
            goto L7b
        L80:
            boolean r10 = r4.mDebug
            if (r10 == 0) goto L9a
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r12 = "下载报错---Exception-->"
            r10.<init>(r12)
            r11.printStackTrace()
            qc4 r11 = defpackage.qc4.a
            r10.append(r11)
            java.lang.String r10 = r10.toString()
            r4.log(r10)
        L9a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yunbao.common.http.fuel.FuelRequest.execute(android.net.Uri, com.yunbao.common.http.UriDownloadCallback):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0168, code lost:
    
        if (r1.header(r4) == null) goto L20;
     */
    @Override // com.yunbao.common.http.IHttpRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void execute(final com.yunbao.common.http.HttpCallback r13) {
        /*
            Method dump skipped, instructions count: 469
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yunbao.common.http.fuel.FuelRequest.execute(com.yunbao.common.http.HttpCallback):void");
    }

    @Override // com.yunbao.common.http.IHttpRequest
    public void execute(final StringHttpCallback callback) {
        callback.getClass();
        Request post$default = this.mMehtod == Method.POST ? RequestFactory.Convenience.DefaultImpls.post$default(Fuel.INSTANCE, this.mUrl, (List) null, 2, (Object) null) : Fuel.INSTANCE.get(this.mUrl, this.mParams);
        Map<String, String> map = this.mHeaders;
        if (map != null) {
            post$default.header(map);
        }
        if (this.mDebug) {
            log("发起请求===>" + FormattingKt.httpString(post$default));
        }
        this.mReq = post$default.responseString(new ResponseHandler<String>() { // from class: com.yunbao.common.http.fuel.FuelRequest$execute$6
            public void failure(Request request, Response response, FuelError error) {
                request.getClass();
                response.getClass();
                error.getClass();
                Throwable exception = error.getException();
                if (FuelRequest.this.getMDebug()) {
                    FuelRequest.this.log("请求失败<===" + FormattingKt.httpString(request));
                    FuelRequest.this.log("错误--message-->" + error.getMessage() + "--Throwable-->" + exception.getClass());
                }
                callback.onError(exception);
                callback.onFinish();
                FuelRequest.this.setMReq(null);
            }

            public void success(Request request, Response response, String value) {
                request.getClass();
                response.getClass();
                value.getClass();
                try {
                    try {
                        FuelRequest.this.clearMemoryIfCritical("string success");
                        if (FuelRequest.this.getMDebug()) {
                            FuelRequest.this.log("请求成功<===" + FormattingKt.httpString(request));
                        }
                        callback.onSuccess(value);
                    } catch (OutOfMemoryError e) {
                        FuelRequest.this.handleStringResponseOom(callback, "success", e);
                    }
                    callback.onFinish();
                    FuelRequest.this.setMReq(null);
                } catch (Throwable th) {
                    callback.onFinish();
                    FuelRequest.this.setMReq(null);
                    throw th;
                }
            }
        });
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    @Override // com.yunbao.common.http.IHttpRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void execute(java.io.File r13, java.lang.String r14, final com.yunbao.common.http.FileDownloadCallback r15) {
        /*
            r12 = this;
            java.lang.String r0 = "开始下载===>"
            r13.getClass()
            r14.getClass()
            r15.getClass()
            java.io.File r5 = new java.io.File
            r5.<init>(r13, r14)
            kotlin.jvm.internal.Ref$ObjectRef r2 = new kotlin.jvm.internal.Ref$ObjectRef
            r2.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r3 = new kotlin.jvm.internal.Ref$ObjectRef
            r3.<init>()
            kotlin.jvm.internal.Ref$IntRef r13 = new kotlin.jvm.internal.Ref$IntRef     // Catch: java.lang.Exception -> L80
            r13.<init>()     // Catch: java.lang.Exception -> L80
            java.io.FileOutputStream r14 = new java.io.FileOutputStream     // Catch: java.lang.Exception -> L80
            r14.<init>(r5)     // Catch: java.lang.Exception -> L80
            r3.a = r14     // Catch: java.lang.Exception -> L80
            com.github.kittinunf.fuel.Fuel r6 = com.github.kittinunf.fuel.Fuel.INSTANCE     // Catch: java.lang.Exception -> L80
            java.lang.String r7 = r12.mUrl     // Catch: java.lang.Exception -> L80
            java.util.List<kotlin.Pair<java.lang.String, java.lang.Object>> r9 = r12.mParams     // Catch: java.lang.Exception -> L80
            r10 = 2
            r11 = 0
            r8 = 0
            com.github.kittinunf.fuel.core.requests.DownloadRequest r14 = com.github.kittinunf.fuel.core.RequestFactory.Convenience.DefaultImpls.download$default(r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Exception -> L80
            com.github.kittinunf.fuel.core.RequestExecutionOptions r1 = r14.getExecutionOptions()     // Catch: java.lang.Exception -> L80
            java.util.concurrent.Executor r1 = r1.getCallbackExecutor()     // Catch: java.lang.Exception -> L80
            e81 r4 = new e81     // Catch: java.lang.Exception -> L80
            r4.<init>()     // Catch: java.lang.Exception -> L80
            com.github.kittinunf.fuel.core.requests.DownloadRequest r4 = r14.streamDestination(r4)     // Catch: java.lang.Exception -> L80
            f81 r6 = new f81     // Catch: java.lang.Exception -> L80
            r6.<init>()     // Catch: java.lang.Exception -> L80
            r4.progress(r6)     // Catch: java.lang.Exception -> L80
            java.util.Map<java.lang.String, java.lang.String> r13 = r12.mHeaders     // Catch: java.lang.Exception -> L80
            if (r13 == 0) goto L58
            r14.header(r13)     // Catch: java.lang.Exception -> L54
            goto L58
        L54:
            r0 = move-exception
            r13 = r0
            r4 = r12
            goto L83
        L58:
            boolean r13 = r12.mDebug     // Catch: java.lang.Exception -> L80
            if (r13 == 0) goto L6f
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L54
            r13.<init>(r0)     // Catch: java.lang.Exception -> L54
            java.lang.String r0 = com.github.kittinunf.fuel.core.extensions.FormattingKt.httpString(r14)     // Catch: java.lang.Exception -> L54
            r13.append(r0)     // Catch: java.lang.Exception -> L54
            java.lang.String r13 = r13.toString()     // Catch: java.lang.Exception -> L54
            r12.log(r13)     // Catch: java.lang.Exception -> L54
        L6f:
            com.yunbao.common.http.fuel.FuelRequest$execute$10 r1 = new com.yunbao.common.http.fuel.FuelRequest$execute$10     // Catch: java.lang.Exception -> L80
            r4 = r12
            r6 = r15
            r1.<init>()     // Catch: java.lang.Exception -> L7d
            com.github.kittinunf.fuel.core.requests.CancellableRequest r12 = r14.response(r1)     // Catch: java.lang.Exception -> L7d
            r4.mReq = r12     // Catch: java.lang.Exception -> L7d
            return
        L7d:
            r0 = move-exception
        L7e:
            r13 = r0
            goto L83
        L80:
            r0 = move-exception
            r4 = r12
            goto L7e
        L83:
            boolean r12 = r4.mDebug
            if (r12 == 0) goto L9d
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            java.lang.String r14 = "下载报错---Exception-->"
            r12.<init>(r14)
            r13.printStackTrace()
            qc4 r13 = defpackage.qc4.a
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            r4.log(r12)
        L9d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yunbao.common.http.fuel.FuelRequest.execute(java.io.File, java.lang.String, com.yunbao.common.http.FileDownloadCallback):void");
    }

    public final boolean getMDebug() {
        return this.mDebug;
    }

    public final Map<String, String> getMHeaders() {
        return this.mHeaders;
    }

    public final Method getMMehtod() {
        return this.mMehtod;
    }

    public final List<Pair<String, Object>> getMParams() {
        return this.mParams;
    }

    public final CancellableRequest getMReq() {
        return this.mReq;
    }

    public final String getMUrl() {
        return this.mUrl;
    }

    public final List<Pair<String, Object>> getServiceMap() {
        return this.serviceMap;
    }

    @Override // com.yunbao.common.http.IHttpRequest
    public IHttpRequest headers(String key, String value) {
        key.getClass();
        value.getClass();
        Map map = this.mHeaders;
        if (map == null) {
            map = new LinkedHashMap();
            this.mHeaders = map;
        }
        map.put(key, value);
        return this;
    }

    public final String pairsToQueryString(List<? extends Pair<String, ? extends Object>> params) {
        params.getClass();
        return b30.k0(params, "&", null, null, 0, null, new n81() { // from class: y71
            @Override // defpackage.n81
            public final Object invoke(Object obj) {
                return FuelRequest.h((Pair) obj);
            }
        }, 30, null);
    }

    @Override // com.yunbao.common.http.IHttpRequest
    public IHttpRequest params(String key, Object value) {
        key.getClass();
        if (value != null) {
            this.mParams.add(new Pair<>(key, value));
        }
        return this;
    }

    public final void setMHeaders(Map<String, String> map) {
        this.mHeaders = map;
    }

    public final void setMReq(CancellableRequest cancellableRequest) {
        this.mReq = cancellableRequest;
    }

    public final void setServiceMap(List<Pair<String, Object>> list) {
        list.getClass();
        this.serviceMap = list;
    }

    public final IHttpRequest setServiceName(String serviceName) {
        serviceName.getClass();
        this.mParams.add(new Pair<>("service", serviceName));
        this.serviceMap.add(new Pair<>("service", serviceName));
        return this;
    }
}
