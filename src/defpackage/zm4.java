package defpackage;

import android.content.Context;
import android.text.Html;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TextView;

/* loaded from: /tmp/classes2.dex */
public abstract class zm4 {
    public static boolean a;

    public static WebView a(Context context) {
        if (context != null && !a) {
            try {
                return new WebView(context);
            } catch (Throwable th) {
                a = true;
                lx1.c("WebViewUtil", "create WebView failed: " + th.getMessage());
            }
        }
        return null;
    }

    public static void b(WebView webView) {
        if (webView == null) {
            return;
        }
        try {
            webView.stopLoading();
            webView.onPause();
            webView.setWebChromeClient(null);
            webView.setWebViewClient(null);
            webView.loadUrl("about:blank");
            webView.clearHistory();
            webView.clearCache(true);
            webView.removeAllViews();
            ViewGroup viewGroup = (ViewGroup) webView.getParent();
            if (viewGroup != null) {
                viewGroup.removeView(webView);
            }
            webView.destroy();
        } catch (Throwable th) {
            lx1.c("WebViewUtil", "destroy WebView failed: " + th.getMessage());
        }
    }

    public static CharSequence c(String str) {
        if (str == null) {
            str = "";
        }
        return Html.fromHtml(str, 0);
    }

    public static void d(WebView webView) {
        if (webView == null) {
            return;
        }
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDefaultTextEncodingName("utf-8");
    }

    public static void e(FrameLayout frameLayout, String str) {
        if (frameLayout == null) {
            return;
        }
        frameLayout.removeAllViews();
        ScrollView scrollView = new ScrollView(frameLayout.getContext());
        scrollView.setFillViewport(true);
        TextView textView = new TextView(frameLayout.getContext());
        int a2 = zn0.a(8);
        textView.setPadding(a2, a2, a2, a2);
        textView.setTextColor(-13421773);
        textView.setTextSize(14.0f);
        textView.setLineSpacing(0.0f, 1.15f);
        textView.setText(c(str));
        scrollView.addView(textView, new FrameLayout.LayoutParams(-1, -2));
        frameLayout.addView(scrollView, new FrameLayout.LayoutParams(-1, -1));
    }
}
