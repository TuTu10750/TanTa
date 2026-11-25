package com.zzhoujay.markdown.parser;

import android.text.SpannableStringBuilder;

/* loaded from: /tmp/classes2.dex */
public interface StyleBuilder {
    SpannableStringBuilder code(CharSequence charSequence);

    SpannableStringBuilder codeBlock(String str);

    SpannableStringBuilder codeBlock(CharSequence... charSequenceArr);

    SpannableStringBuilder delete(CharSequence charSequence);

    SpannableStringBuilder em(CharSequence charSequence);

    SpannableStringBuilder emItalic(CharSequence charSequence);

    SpannableStringBuilder email(CharSequence charSequence);

    SpannableStringBuilder gap();

    SpannableStringBuilder h1(CharSequence charSequence);

    SpannableStringBuilder h2(CharSequence charSequence);

    SpannableStringBuilder h3(CharSequence charSequence);

    SpannableStringBuilder h4(CharSequence charSequence);

    SpannableStringBuilder h5(CharSequence charSequence);

    SpannableStringBuilder h6(CharSequence charSequence);

    SpannableStringBuilder image(CharSequence charSequence, String str, String str2);

    SpannableStringBuilder italic(CharSequence charSequence);

    SpannableStringBuilder link(CharSequence charSequence, String str, String str2);

    SpannableStringBuilder ol(CharSequence charSequence, int i, int i2);

    SpannableStringBuilder ol2(CharSequence charSequence, int i, int i2, int i3);

    SpannableStringBuilder quota(CharSequence charSequence);

    SpannableStringBuilder ul(CharSequence charSequence, int i);

    SpannableStringBuilder ul2(CharSequence charSequence, int i, int i2);
}
