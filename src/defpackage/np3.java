package defpackage;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.beauty.bean.SimpleFilterBean;
import defpackage.gh1;

/* loaded from: /tmp/classes2.dex */
public class np3 extends b1 implements gh1, View.OnClickListener, et2 {
    public View a;
    public View b;
    public TextView c;
    public TextView d;
    public TextView e;
    public boolean f;
    public gh1.a g;
    public boolean h;

    /* loaded from: /tmp/classes2.dex */
    public class a implements SeekBar.OnSeekBarChangeListener {
        public a() {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            int id = seekBar.getId();
            if (id == x63.u) {
                if (np3.this.c != null) {
                    np3.this.c.setText(String.valueOf(i));
                }
                rp3.e().u(i);
            } else if (id == x63.v) {
                if (np3.this.d != null) {
                    np3.this.d.setText(String.valueOf(i));
                }
                rp3.e().w(i);
            } else if (id == x63.t) {
                if (np3.this.e != null) {
                    np3.this.e.setText(String.valueOf(i));
                }
                rp3.e().t(i);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    public np3(Context context, ViewGroup viewGroup, boolean z) {
        super(context, viewGroup, Boolean.valueOf(z));
    }

    @Override // defpackage.gh1
    public void N(gh1.a aVar) {
        this.g = aVar;
    }

    @Override // defpackage.et2
    /* renamed from: e0, reason: merged with bridge method [inline-methods] */
    public void onItemClick(SimpleFilterBean simpleFilterBean, int i) {
        rp3.e().s(simpleFilterBean.getFilterSrc() != 0 ? BitmapFactory.decodeResource(this.mContext.getResources(), simpleFilterBean.getFilterSrc()) : null);
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return n83.d;
    }

    @Override // defpackage.gh1
    public void hide() {
        removeFromParent();
        gh1.a aVar = this.g;
        if (aVar != null) {
            aVar.a(false);
        }
        this.f = false;
        rp3.e().q();
    }

    @Override // defpackage.b1
    public void init() {
        this.a = findViewById(x63.h);
        this.b = findViewById(x63.i);
        findViewById(x63.d).setOnClickListener(this);
        findViewById(x63.b).setOnClickListener(this);
        findViewById(x63.c).setOnClickListener(this);
        SeekBar seekBar = (SeekBar) findViewById(x63.u);
        SeekBar seekBar2 = (SeekBar) findViewById(x63.v);
        SeekBar seekBar3 = (SeekBar) findViewById(x63.t);
        if (!this.h) {
            findViewById(x63.a).setVisibility(8);
            seekBar.setMax(10);
            seekBar2.setMax(10);
            seekBar3.setMax(10);
        }
        this.c = (TextView) findViewById(x63.y);
        this.d = (TextView) findViewById(x63.z);
        this.e = (TextView) findViewById(x63.x);
        a aVar = new a();
        seekBar.setOnSeekBarChangeListener(aVar);
        seekBar2.setOnSeekBarChangeListener(aVar);
        seekBar3.setOnSeekBarChangeListener(aVar);
        seekBar.setProgress(rp3.e().f());
        seekBar2.setProgress(rp3.e().g());
        seekBar3.setProgress(rp3.e().d());
        RecyclerView findViewById = findViewById(x63.g);
        findViewById.setLayoutManager(new LinearLayoutManager(this.mContext, 0, false));
        tp3 tp3Var = new tp3(this.mContext);
        tp3Var.T(this);
        findViewById.setAdapter(tp3Var);
    }

    @Override // defpackage.gh1
    public boolean isShowed() {
        return this.f;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == x63.d) {
            hide();
            return;
        }
        if (id == x63.b) {
            View view2 = this.a;
            if (view2 != null && view2.getVisibility() != 0) {
                this.a.setVisibility(0);
            }
            View view3 = this.b;
            if (view3 == null || view3.getVisibility() == 8) {
                return;
            }
            this.b.setVisibility(8);
            return;
        }
        if (id == x63.c) {
            View view4 = this.a;
            if (view4 != null && view4.getVisibility() != 8) {
                this.a.setVisibility(8);
            }
            View view5 = this.b;
            if (view5 == null || view5.getVisibility() == 0) {
                return;
            }
            this.b.setVisibility(0);
        }
    }

    @Override // defpackage.b1
    public void processArguments(Object... objArr) {
        this.h = ((Boolean) objArr[0]).booleanValue();
    }

    @Override // defpackage.gh1
    public void show() {
        View view;
        gh1.a aVar = this.g;
        if (aVar != null) {
            aVar.a(true);
        }
        if (this.mParentView != null && (view = this.mContentView) != null) {
            ViewParent parent = view.getParent();
            if (parent != null) {
                ((ViewGroup) parent).removeView(this.mContentView);
            }
            this.mParentView.addView(this.mContentView);
        }
        this.f = true;
    }
}
