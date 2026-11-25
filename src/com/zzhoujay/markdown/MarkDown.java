package com.zzhoujay.markdown;

import android.text.Html;
import android.text.Spanned;
import android.widget.TextView;
import com.zzhoujay.markdown.parser.StyleBuilderImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;

/* loaded from: /tmp/classes2.dex */
public class MarkDown {
    public static Spanned fromMarkdown(BufferedReader bufferedReader, Html.ImageGetter imageGetter, TextView textView) {
        try {
            return new MarkDownParser(bufferedReader, new StyleBuilderImpl(textView, imageGetter)).parse();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Spanned fromMarkdown(InputStream inputStream, Html.ImageGetter imageGetter, TextView textView) {
        try {
            return new MarkDownParser(inputStream, new StyleBuilderImpl(textView, imageGetter)).parse();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Spanned fromMarkdown(String str, Html.ImageGetter imageGetter, TextView textView) {
        try {
            return new MarkDownParser(str, new StyleBuilderImpl(textView, imageGetter)).parse();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
