package com.yunbao.common.utils;

import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import androidx.appcompat.widget.AppCompatEditText;
import com.yunbao.common.utils.EmojiLayout;
import defpackage.lh1;

/* loaded from: /tmp/classes2.dex */
public class EmojiEditText extends AppCompatEditText implements EmojiLayout.a {

    /* loaded from: /tmp/classes2.dex */
    public class a extends InputConnectionWrapper {
        public a(InputConnection inputConnection, boolean z) {
            super(inputConnection, z);
        }

        @Override // android.view.inputmethod.InputConnectionWrapper, android.view.inputmethod.InputConnection
        public boolean deleteSurroundingText(int i, int i2) {
            if (i != 1 || i2 != 0) {
                return super.deleteSurroundingText(i, i2);
            }
            EmojiEditText.this.e();
            return true;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void e() {
        onKeyDown(67, new KeyEvent(0, 67));
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return new a(super.onCreateInputConnection(editorInfo), true);
    }

    public void setEmojiResource(lh1 lh1Var) {
    }
}
