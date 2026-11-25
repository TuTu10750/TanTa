package com.yunbao.video.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import defpackage.b83;
import defpackage.f73;
import defpackage.s44;

/* loaded from: /tmp/classes2.dex */
public class VideoProgressView extends FrameLayout {
    public Context a;
    public View b;
    public RecyclerView c;
    public s44 d;

    public VideoProgressView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VideoProgressView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.a = context;
    }

    public ViewGroup getParentView() {
        return (ViewGroup) this.b;
    }

    public RecyclerView getRecyclerView() {
        return this.c;
    }

    public int getThumbnailCount() {
        if (this.d != null) {
            return r0.j() - 2;
        }
        return 0;
    }

    @Override // android.view.View
    public void onFinishInflate() {
        super.onFinishInflate();
        View inflate = LayoutInflater.from(this.a).inflate(b83.q, (ViewGroup) this, false);
        this.b = inflate;
        RecyclerView findViewById = inflate.findViewById(f73.R);
        this.c = findViewById;
        findViewById.setHasFixedSize(true);
        this.c.setLayoutManager(new LinearLayoutManager(this.a, 0, false));
        s44 s44Var = new s44(this.a);
        this.d = s44Var;
        this.c.setAdapter(s44Var);
        addView(this.b);
    }
}
