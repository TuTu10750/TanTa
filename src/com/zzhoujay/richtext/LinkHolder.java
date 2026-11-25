package com.zzhoujay.richtext;

import android.graphics.Color;

/* loaded from: /tmp/classes2.dex */
public class LinkHolder {
    private static final int link_color = Color.parseColor("#4078C0");
    private int color = link_color;
    private boolean underLine = true;
    private final String url;

    public LinkHolder(String str) {
        this.url = str;
    }

    public int getColor() {
        return this.color;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isUnderLine() {
        return this.underLine;
    }

    public void setColor(int i) {
        this.color = i;
    }

    public void setUnderLine(boolean z) {
        this.underLine = z;
    }
}
