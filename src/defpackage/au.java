package defpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import com.trtc.tuikit.common.R;
import com.trtc.tuikit.common.ui.PopupDialog;
import java.util.Locale;

/* loaded from: /tmp/classes2.dex */
public class au extends PopupDialog {
    public float a;
    public int b;
    public k30 c;

    /* loaded from: /tmp/classes2.dex */
    public class a implements SeekBar.OnSeekBarChangeListener {
        public final /* synthetic */ TextView a;

        public a(TextView textView) {
            this.a = textView;
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            au.this.c.a(Integer.valueOf(i));
            this.a.setText(String.format(Locale.US, "%.1f", Float.valueOf(i * 0.1f)));
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    public au(Context context, float f, int i) {
        super(context, R.style.TUICommonBottomDialogTheme);
        this.a = f;
        this.b = i;
        i();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void i() {
        View inflate = LayoutInflater.from(getContext()).inflate(x73.S, (ViewGroup) null);
        SeekBar seekBar = (SeekBar) inflate.findViewById(b73.P4);
        TextView textView = (TextView) inflate.findViewById(b73.a6);
        TextView textView2 = (TextView) inflate.findViewById(b73.A5);
        Locale locale = Locale.US;
        textView2.setText(String.format(locale, "%.1f", Float.valueOf(this.a)));
        seekBar.setMax(((int) this.a) * 10);
        seekBar.setProgress(this.b);
        textView.setText(String.format(locale, "%.1f", Float.valueOf(this.b * 0.1f)));
        seekBar.setMin(10);
        seekBar.setOnSeekBarChangeListener(new a(textView));
        setView(inflate);
    }

    public void j(k30 k30Var) {
        this.c = k30Var;
    }
}
