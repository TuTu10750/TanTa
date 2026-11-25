package com.yunbao.video.custom;

import android.content.Context;
import android.text.Editable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import androidx.appcompat.widget.AppCompatEditText;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import defpackage.p53;
import defpackage.rc;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/* loaded from: /tmp/classes2.dex */
public class AtEditText extends AppCompatEditText {
    public Map g;
    public TextWatcher h;
    public c i;
    public int j;

    /* loaded from: /tmp/classes2.dex */
    public class a implements TextWatcher {
        public a() {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
        }

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (AtEditText.this.g == null || AtEditText.this.g.size() <= 0) {
                return;
            }
            Iterator it = AtEditText.this.g.entrySet().iterator();
            while (it.hasNext()) {
                rc rcVar = (rc) ((Map.Entry) it.next()).getValue();
                if (i < rcVar.c()) {
                    rcVar.e(i3 - i2);
                }
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            if (AtEditText.this.g == null || AtEditText.this.g.size() <= 0) {
                return;
            }
            String obj = AtEditText.this.getText().toString();
            Iterator it = AtEditText.this.g.entrySet().iterator();
            ArrayList arrayList = null;
            while (it.hasNext()) {
                rc rcVar = (rc) ((Map.Entry) it.next()).getValue();
                if (!rcVar.f() || !obj.contains(rcVar.b())) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(rcVar.d());
                }
            }
            if (arrayList != null) {
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    AtEditText.this.g.remove((String) it2.next());
                }
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends InputConnectionWrapper {
        public b(InputConnection inputConnection, boolean z) {
            super(inputConnection, z);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean commitText(CharSequence charSequence, int i) {
            if (!"@".equals(charSequence)) {
                return super.commitText(charSequence, i);
            }
            if (AtEditText.this.i == null) {
                return false;
            }
            AtEditText.this.i.b();
            return false;
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean sendKeyEvent(KeyEvent keyEvent) {
            if (keyEvent.getKeyCode() == 67 && keyEvent.getAction() == 0 && AtEditText.this.h()) {
                return true;
            }
            return super.sendKeyEvent(keyEvent);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public interface c {
        void a();

        void b();

        void c();
    }

    public AtEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        i(context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean g(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        Iterator it = this.g.entrySet().iterator();
        while (it.hasNext()) {
            rc rcVar = (rc) ((Map.Entry) it.next()).getValue();
            if (str.equals(rcVar.d())) {
                c cVar = this.i;
                if (cVar != null) {
                    cVar.a();
                }
                return false;
            }
            if (str2.equals(rcVar.b())) {
                c cVar2 = this.i;
                if (cVar2 != null) {
                    cVar2.c();
                }
                return false;
            }
        }
        String str3 = "@" + str2 + " ";
        Editable text = getText();
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str3);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(this.j), 0, str3.length(), 33);
        int selectionStart = getSelectionStart();
        text.insert(selectionStart, spannableStringBuilder);
        this.g.put(str, new rc(str, str2, str3, selectionStart));
        return true;
    }

    public String getAtUserInfo() {
        String obj = getText().toString();
        Iterator it = this.g.entrySet().iterator();
        JSONArray jSONArray = null;
        while (it.hasNext()) {
            rc rcVar = (rc) ((Map.Entry) it.next()).getValue();
            if (obj.contains(rcVar.b())) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("uid", rcVar.d());
                jSONObject.put("name", rcVar.b());
                if (jSONArray == null) {
                    jSONArray = new JSONArray();
                }
                jSONArray.add(jSONObject);
            }
        }
        return (jSONArray == null || jSONArray.size() <= 0) ? "" : jSONArray.toJSONString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean h() {
        Map map = this.g;
        if (map == null || map.size() <= 0 || getSelectionStart() != getSelectionEnd()) {
            return false;
        }
        Iterator it = this.g.entrySet().iterator();
        while (it.hasNext()) {
            rc rcVar = (rc) ((Map.Entry) it.next()).getValue();
            if (rcVar.f() && getSelectionStart() == rcVar.a()) {
                getText().delete(rcVar.c(), rcVar.a());
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void i(Context context) {
        this.j = o60.b(context, p53.g);
        this.g = new LinkedHashMap();
        a aVar = new a();
        this.h = aVar;
        addTextChangedListener(aVar);
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return new b(super.onCreateInputConnection(editorInfo), true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onSelectionChanged(int i, int i2) {
        Map map = this.g;
        if (map != null && map.size() > 0 && i == i2) {
            Iterator it = this.g.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                rc rcVar = (rc) ((Map.Entry) it.next()).getValue();
                if (i > rcVar.c() && i < rcVar.a()) {
                    setSelection(rcVar.a());
                    break;
                }
            }
        }
        super/*android.widget.TextView*/.onSelectionChanged(i, i2);
    }

    public void setActionListener(c cVar) {
        this.i = cVar;
    }
}
