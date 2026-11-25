package com.zzhoujay.richtext.ext;

import android.graphics.Color;
import android.text.Editable;
import android.text.Html;
import android.widget.TextView;
import com.umeng.analytics.pro.cl;
import com.zzhoujay.markdown.style.CodeSpan;
import com.zzhoujay.markdown.style.MarkDownBulletSpan;
import java.lang.ref.SoftReference;
import java.util.Stack;
import org.xml.sax.XMLReader;

/* loaded from: /tmp/classes2.dex */
public class HtmlTagHandler implements Html.TagHandler {
    private static final int code_color = Color.parseColor("#F0F0F0");
    private static final int h1_color = Color.parseColor("#333333");
    private SoftReference<TextView> textViewSoftReference;
    private int index = 0;
    private Stack<Integer> stack = new Stack<>();
    private Stack<Boolean> list = new Stack<>();

    public HtmlTagHandler(TextView textView) {
        this.textViewSoftReference = new SoftReference<>(textView);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void reallyHandler(int i, int i2, String str, Editable editable, XMLReader xMLReader) {
        char c;
        String lowerCase = str.toLowerCase();
        lowerCase.getClass();
        int i3 = -1;
        switch (lowerCase.hashCode()) {
            case 3453:
                if (lowerCase.equals("li")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            case 3549:
                if (lowerCase.equals("ol")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 3735:
                if (lowerCase.equals("ul")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case 3059181:
                if (lowerCase.equals(cl.g)) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        switch (c) {
            case 0:
                if (this.list.peek().booleanValue()) {
                    this.index = 0;
                } else {
                    i3 = this.index + 1;
                    this.index = i3;
                }
                editable.append('\n');
                TextView textView = this.textViewSoftReference.get();
                if (textView == null) {
                    return;
                }
                editable.setSpan(new MarkDownBulletSpan(this.list.size() - 1, h1_color, i3, textView), i, editable.length(), 33);
                return;
            case 1:
            case 2:
                editable.append('\n');
                if (this.list.isEmpty()) {
                    return;
                }
                this.list.pop();
                return;
            case 3:
                editable.setSpan(new CodeSpan(code_color), i, i2, 33);
                return;
            default:
                return;
        }
    }

    private void startTag(String str, Editable editable, XMLReader xMLReader) {
        String lowerCase = str.toLowerCase();
        int hashCode = lowerCase.hashCode();
        if (hashCode == 3549) {
            if (lowerCase.equals("ol")) {
                this.list.push(Boolean.FALSE);
                editable.append('\n');
                return;
            }
            return;
        }
        if (hashCode != 3735) {
            if (hashCode != 111267) {
                return;
            }
            lowerCase.equals("pre");
        } else if (lowerCase.equals("ul")) {
            this.list.push(Boolean.TRUE);
            editable.append('\n');
        }
    }

    @Override // android.text.Html.TagHandler
    public void handleTag(boolean z, String str, Editable editable, XMLReader xMLReader) {
        if (!z) {
            reallyHandler(this.stack.isEmpty() ? 0 : this.stack.pop().intValue(), editable.length(), str.toLowerCase(), editable, xMLReader);
        } else {
            startTag(str, editable, xMLReader);
            this.stack.push(Integer.valueOf(editable.length()));
        }
    }
}
