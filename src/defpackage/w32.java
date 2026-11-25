package defpackage;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yunbao.common.http.FileDownloadCallback;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.live.music.LiveMusicBean;
import defpackage.v32;
import java.io.File;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class w32 extends l0 implements View.OnClickListener, v32.c {
    public RecyclerView A0;
    public View B0;
    public String C0;
    public v32 D0;
    public yn0 E0;
    public e F0;
    public HttpCallback G0 = new c();
    public io2 H0 = new d();
    public EditText z0;

    /* loaded from: /tmp/classes2.dex */
    public class a implements TextView.OnEditorActionListener {
        public a() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 3) {
                return false;
            }
            w32.this.y2();
            return true;
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b implements TextWatcher {
        public b() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (charSequence.length() == 0) {
                w32.this.x2();
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends HttpCallback {
        public c() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                if (w32.this.B0.getVisibility() == 0) {
                    w32.this.B0.setVisibility(4);
                }
                w32.this.D0.V(JSON.parseArray(Arrays.toString(strArr), LiveMusicBean.class));
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends io2 {

        /* loaded from: /tmp/classes2.dex */
        public class a extends FileDownloadCallback {
            public final /* synthetic */ LiveMusicBean a;
            public final /* synthetic */ String b;

            public a(LiveMusicBean liveMusicBean, String str) {
                this.a = liveMusicBean;
                this.b = str;
            }

            @Override // com.yunbao.common.http.FileDownloadCallback
            public void onProgress(float f) {
                if (w32.this.D0 != null) {
                    w32.this.D0.W(this.b, (int) (f * 100.0f));
                }
            }

            @Override // com.yunbao.common.http.FileDownloadCallback
            public void onSuccess(File file) {
                ho2.b().d(this.a);
            }
        }

        public d() {
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i != 0 || strArr.length <= 0) {
                t54.b(str);
                return;
            }
            JSONObject parseObject = JSON.parseObject(strArr[0]);
            String string = parseObject.getString("audio_link");
            String string2 = parseObject.getString("lrc_content");
            if (TextUtils.isEmpty(string)) {
                t54.a(m93.Q8);
                return;
            }
            LiveMusicBean a2 = a();
            if (a2 != null) {
                if (w32.this.E0 == null) {
                    w32.this.E0 = new yn0("downloadMusic");
                }
                String id = a2.getId();
                File file = new File(j30.L);
                if (!file.exists()) {
                    file.mkdirs();
                }
                if (!TextUtils.isEmpty(string2)) {
                    r11.a(file, string2, id + ".lrc");
                }
                w32.this.E0.c(file, id + ".mp3", string, new a(a2, id));
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface e {
        void a(String str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void y2() {
        String trim = this.z0.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            t54.b(c0(m93.r1));
        } else if (TextUtils.isEmpty(this.C0) || !this.C0.equals(trim)) {
            this.C0 = trim;
            e32.x0(trim, this.G0);
        }
    }

    @Override // defpackage.l0
    public void C0() {
        e32.f("searchMusic");
        e32.f("getMusicUrl");
        v32 v32Var = this.D0;
        if (v32Var != null) {
            v32Var.T();
        }
        super.C0();
    }

    @Override // v32.c
    public void f(String str, int i) {
        ho2.b().a(str);
        String str2 = j30.L;
        File file = new File(str2, str + ".mp3");
        if (file.exists()) {
            file.delete();
        }
        File file2 = new File(str2, str + ".lrc");
        if (file2.exists()) {
            file2.delete();
        }
        if (i == 0) {
            x2();
        }
    }

    @Override // defpackage.l0
    public boolean f2() {
        return true;
    }

    @Override // v32.c
    public void g(LiveMusicBean liveMusicBean) {
        this.H0.b(liveMusicBean);
        e32.X(liveMusicBean.getId(), this.H0);
    }

    @Override // v32.c
    public void k(LiveMusicBean liveMusicBean) {
        S1();
        e eVar = this.F0;
        if (eVar != null) {
            eVar.a(liveMusicBean.getId());
        }
    }

    @Override // defpackage.l0
    public int l2() {
        return s93.d;
    }

    @Override // defpackage.l0
    public int m2() {
        return x73.O;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (g2()) {
            int id = view.getId();
            if (id == b73.X0) {
                y2();
            } else if (id == b73.H) {
                S1();
            }
        }
    }

    @Override // defpackage.l0
    public void p2(Window window) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        attributes.width = zn0.a(280);
        attributes.height = zn0.a(360);
        attributes.gravity = 17;
        window.setAttributes(attributes);
    }

    public void r0(Bundle bundle) {
        super.r0(bundle);
        EditText editText = (EditText) this.y0.findViewById(b73.N1);
        this.z0 = editText;
        editText.setOnEditorActionListener(new a());
        this.z0.addTextChangedListener(new b());
        this.B0 = this.y0.findViewById(b73.j4);
        RecyclerView findViewById = this.y0.findViewById(b73.B4);
        this.A0 = findViewById;
        findViewById.setLayoutManager(new LinearLayoutManager(this.x0, 1, false));
        v32 v32Var = new v32(this.x0);
        this.D0 = v32Var;
        v32Var.U(this);
        this.A0.setAdapter(this.D0);
        this.y0.findViewById(b73.X0).setOnClickListener(this);
        this.y0.findViewById(b73.H).setOnClickListener(this);
        x2();
    }

    public final void x2() {
        List c2 = ho2.b().c();
        int size = c2.size();
        View view = this.B0;
        if (size > 0) {
            if (view.getVisibility() == 0) {
                this.B0.setVisibility(4);
            }
            this.D0.V(c2);
        } else if (view.getVisibility() != 0) {
            this.B0.setVisibility(0);
        }
    }

    public void z2(e eVar) {
        this.F0 = eVar;
    }
}
