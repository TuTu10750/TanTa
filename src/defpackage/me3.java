package defpackage;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;

/* loaded from: /tmp/classes2.dex */
public abstract class me3 {
    public static final ed2 d(Matcher matcher, int i, CharSequence charSequence) {
        if (matcher.find(i)) {
            return new fd2(matcher, charSequence);
        }
        return null;
    }

    public static final ed2 e(Matcher matcher, CharSequence charSequence) {
        if (matcher.matches()) {
            return new fd2(matcher, charSequence);
        }
        return null;
    }

    public static final pp1 f(MatchResult matchResult, int i) {
        return fb3.m(matchResult.start(i), matchResult.end(i));
    }
}
