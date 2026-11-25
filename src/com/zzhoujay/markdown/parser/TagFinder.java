package com.zzhoujay.markdown.parser;

/* loaded from: /tmp/classes2.dex */
public interface TagFinder {
    boolean find(int i, Line line);

    boolean find(int i, String str);

    int findCount(int i, Line line, int i2);

    int findCount(int i, String str, int i2);
}
