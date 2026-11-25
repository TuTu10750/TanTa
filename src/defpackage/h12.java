package defpackage;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.yunbao.common.CommonAppContext;
import com.yunbao.common.bean.LevelBean;
import com.yunbao.live.bean.LiveChatBean;
import defpackage.kn1;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class h12 extends RecyclerView.Adapter {
    public Context d;
    public LayoutInflater f;
    public et2 h;
    public RecyclerView i;
    public String k;
    public List e = new ArrayList();
    public View.OnClickListener g = new a();
    public Runnable j = new b();

    /* loaded from: /tmp/classes2.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Object tag = view.getTag();
            if (tag != null) {
                LiveChatBean liveChatBean = (LiveChatBean) tag;
                if (liveChatBean.getType() == 1 || h12.this.h == null) {
                    return;
                }
                h12.this.h.onItemClick(liveChatBean, 0);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (h12.this.e.size() <= 0 || h12.this.i == null) {
                return;
            }
            h12.this.i.v1(h12.this.e.size() - 1);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends k30 {
        public final /* synthetic */ LiveChatBean a;
        public final /* synthetic */ SpannableStringBuilder b;
        public final /* synthetic */ int c;
        public final /* synthetic */ String d;
        public final /* synthetic */ TextView e;

        public c(LiveChatBean liveChatBean, SpannableStringBuilder spannableStringBuilder, int i, String str, TextView textView) {
            this.a = liveChatBean;
            this.b = spannableStringBuilder;
            this.c = i;
            this.d = str;
            this.e = textView;
        }

        @Override // defpackage.k30
        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void a(Drawable drawable) {
            int i;
            Drawable d;
            Drawable d2;
            Drawable d3;
            String str;
            int i2 = 2;
            if (this.a.isSuper()) {
                Drawable d4 = o60.d(CommonAppContext.n(), t83.E);
                if (d4 != null) {
                    this.b.append((CharSequence) "  ");
                    d4.setBounds(0, 0, zn0.a(25), zn0.a(14));
                    this.b.setSpan(new mg4(d4), 0, 1, 33);
                } else {
                    i2 = 0;
                }
            } else {
                if (drawable != null) {
                    this.b.append((CharSequence) "  ");
                    drawable.setBounds(0, 0, zn0.a(28), zn0.a(14));
                    this.b.setSpan(new mg4(drawable), 0, 1, 33);
                    i = 2;
                } else {
                    i = 0;
                }
                if (this.a.getVipType() == 1 && (d3 = o60.d(CommonAppContext.n(), t83.S0)) != null) {
                    this.b.append((CharSequence) "  ");
                    d3.setBounds(0, 0, zn0.a(30), zn0.a(14));
                    this.b.setSpan(new mg4(d3), i, i + 1, 33);
                    i += 2;
                }
                if (this.a.isManager() && (d2 = o60.d(CommonAppContext.n(), t83.D)) != null) {
                    this.b.append((CharSequence) "  ");
                    d2.setBounds(0, 0, zn0.a(17), zn0.a(14));
                    this.b.setSpan(new mg4(d2), i, i + 1, 33);
                    i += 2;
                }
                if (this.a.getGuardType() > 0) {
                    Drawable d5 = o60.d(CommonAppContext.n(), this.a.getGuardType() == 2 ? t83.B : t83.A);
                    if (d5 != null) {
                        this.b.append((CharSequence) "  ");
                        d5.setBounds(0, 0, zn0.a(16), zn0.a(16));
                        this.b.setSpan(new mg4(d5), i, i + 1, 33);
                        i += 2;
                    }
                }
                i2 = i;
                if (!TextUtils.isEmpty(this.a.getLiangName()) && (d = o60.d(CommonAppContext.n(), t83.C)) != null) {
                    this.b.append((CharSequence) "  ");
                    d.setBounds(0, 0, zn0.a(17), zn0.a(14));
                    this.b.setSpan(new mg4(d), i2, i2 + 1, 33);
                    i2 += 2;
                }
            }
            String userNiceName = this.a.getUserNiceName();
            if (TextUtils.isEmpty(userNiceName)) {
                userNiceName = "";
            }
            int parseColor = Color.parseColor(j30.q().s(this.c).getColor());
            if (this.a.isSuper()) {
                userNiceName = "超管";
                parseColor = -336640;
            }
            if (TextUtils.isEmpty(this.d)) {
                str = userNiceName + ": ";
            } else {
                str = this.d + userNiceName + ": ";
            }
            this.b.append((CharSequence) str);
            this.b.setSpan(new ForegroundColorSpan(parseColor), i2, str.length() + i2, 33);
            CharSequence b = iz0.b(this.a.getContent());
            this.b.append(b);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan((this.a.getMsgStyleBean() == null || this.a.getMsgStyleBean().getTextColor() == null) ? -1 : Color.parseColor(this.a.getMsgStyleBean().getTextColor()));
            SpannableStringBuilder spannableStringBuilder = this.b;
            spannableStringBuilder.setSpan(foregroundColorSpan, spannableStringBuilder.length() - b.length(), this.b.length(), 33);
            this.e.setText(this.b);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements kn1.a {
        public final /* synthetic */ k30 a;

        public d(k30 k30Var) {
            this.a = k30Var;
        }

        @Override // kn1.a
        public void onLoadFailed() {
            this.a.a(null);
        }

        @Override // kn1.a
        public void onLoadSuccess(Drawable drawable) {
            this.a.a(drawable);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class e extends RecyclerView.e0 {
        public TextView u;

        public e(View view) {
            super(view);
            this.u = (TextView) view;
        }

        public void O(LiveChatBean liveChatBean) {
            this.u.setText(liveChatBean.getContent());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class f extends RecyclerView.e0 {
        public TextView u;

        public f(View view) {
            super(view);
            this.u = (TextView) view;
        }

        public void O(LiveChatBean liveChatBean) {
            this.u.setText(liveChatBean.getContent());
            if (liveChatBean.getMsgStyleBean() == null || liveChatBean.getMsgStyleBean().getTextColor() == null) {
                return;
            }
            liveChatBean.getMsgStyleBean().setViewBg(this.u);
            this.u.setTextColor(Color.parseColor(liveChatBean.getMsgStyleBean().getTextColor()));
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class g extends RecyclerView.e0 {
        public TextView u;
        public TextView v;

        public g(View view) {
            super(view);
            this.u = (TextView) view.findViewById(b73.B5);
            this.v = (TextView) view.findViewById(b73.n5);
            view.setOnClickListener(h12.this.g);
        }

        public void O(LiveChatBean liveChatBean) {
            ((RecyclerView.e0) this).a.setTag(liveChatBean);
            int S = h12.this.S(this.u);
            boolean isAnchor = liveChatBean.isAnchor();
            TextView textView = this.v;
            if (isAnchor) {
                textView.setVisibility(8);
                h12.this.Y(liveChatBean, S, h12.this.U(this.u), this.u);
            } else {
                textView.setVisibility(8);
                h12.this.Y(liveChatBean, S, "", this.u);
            }
            if (liveChatBean.getMsgStyleBean() == null || liveChatBean.getMsgStyleBean().getTextColor() == null) {
                return;
            }
            liveChatBean.getMsgStyleBean().setViewBg(((RecyclerView.e0) this).a);
        }
    }

    public h12(Context context, String str) {
        this.k = str;
        this.d = context;
        this.f = LayoutInflater.from(context);
    }

    public RecyclerView.e0 B(ViewGroup viewGroup, int i) {
        return i == 1 ? new f(this.f.inflate(x73.I0, viewGroup, false)) : i == 5 ? new e(this.f.inflate(x73.H0, viewGroup, false)) : new g(this.f.inflate(x73.G0, viewGroup, false));
    }

    public void R() {
        List list = this.e;
        if (list != null) {
            list.clear();
        }
        p();
    }

    public int S(TextView textView) {
        Paint paint = new Paint();
        paint.setTextSize(textView.getTextSize());
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return (int) Math.ceil(fontMetrics.bottom - fontMetrics.top);
    }

    public final void T(int i, k30 k30Var) {
        LevelBean s = j30.q().s(i);
        if (s == null || s.getThumb() == null) {
            return;
        }
        kn1.j(this.d, s.getThumb(), new d(k30Var));
    }

    public final String U(TextView textView) {
        int applyDimension = ((int) (TypedValue.applyDimension(1, 35.0f, textView.getContext().getResources().getDisplayMetrics()) / textView.getPaint().measureText(" "))) + 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < applyDimension; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public void V(LiveChatBean liveChatBean) {
        if (liveChatBean == null) {
            return;
        }
        int size = this.e.size();
        this.e.add(liveChatBean);
        s(size);
        a0();
        X();
    }

    public void W(List list) {
        if (list == null || list.size() == 0) {
            return;
        }
        int size = this.e.size();
        this.e.addAll(list);
        v(size, list.size());
        a0();
        X();
    }

    public void X() {
        RecyclerView recyclerView;
        if (this.e.size() <= 0 || (recyclerView = this.i) == null) {
            return;
        }
        recyclerView.v1(this.e.size() - 1);
        this.i.postDelayed(this.j, 50L);
    }

    public final void Y(LiveChatBean liveChatBean, int i, String str, TextView textView) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (TextUtils.isEmpty(str)) {
            int level = liveChatBean.getLevel();
            T(level, new c(liveChatBean, spannableStringBuilder, level, str, textView));
            return;
        }
        Drawable d2 = o60.d(CommonAppContext.n(), t83.w);
        spannableStringBuilder.append((CharSequence) "  ");
        d2.setBounds(0, 0, zn0.a(28), zn0.a(14));
        spannableStringBuilder.setSpan(new kx(d2), 0, 1, 33);
        String userNiceName = liveChatBean.getUserNiceName();
        if (TextUtils.isEmpty(userNiceName)) {
            userNiceName = "";
        }
        int color = this.d.getResources().getColor(q53.b);
        String str2 = userNiceName + ": ";
        spannableStringBuilder.append((CharSequence) str2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(color), 0, str2.length(), 33);
        CharSequence b2 = iz0.b(liveChatBean.getContent());
        spannableStringBuilder.append(b2);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(this.d.getResources().getColor(q53.a)), spannableStringBuilder.length() - b2.length(), spannableStringBuilder.length(), 33);
        textView.setText(spannableStringBuilder);
    }

    public void Z(et2 et2Var) {
        this.h = et2Var;
    }

    public final void a0() {
        int size = this.e.size() - 200;
        if (size <= 0) {
            return;
        }
        for (int i = 0; i < size; i++) {
            this.e.remove(0);
        }
        w(0, size);
    }

    public int j() {
        return this.e.size();
    }

    public int l(int i) {
        return ((LiveChatBean) this.e.get(i)).getType();
    }

    public void y(RecyclerView recyclerView) {
        this.i = recyclerView;
    }

    public void z(RecyclerView.e0 e0Var, int i) {
        if (e0Var instanceof f) {
            ((f) e0Var).O((LiveChatBean) this.e.get(i));
        } else if (e0Var instanceof g) {
            ((g) e0Var).O((LiveChatBean) this.e.get(i));
        } else if (e0Var instanceof e) {
            ((e) e0Var).O((LiveChatBean) this.e.get(i));
        }
    }
}
