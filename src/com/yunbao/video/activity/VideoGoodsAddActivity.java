package com.yunbao.video.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.bean.GoodsBean;
import com.yunbao.common.custom.CommonRefreshView;
import com.yunbao.common.http.HttpCallback;
import defpackage.aq4;
import defpackage.b83;
import defpackage.ce3;
import defpackage.et2;
import defpackage.f73;
import defpackage.m93;
import defpackage.mu1;
import defpackage.t54;
import defpackage.wh4;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class VideoGoodsAddActivity extends AbsActivity implements et2 {
    public EditText e;
    public String f = "";
    public CommonRefreshView g;
    public CommonRefreshView h;
    public wh4 i;
    public wh4 j;
    public e k;
    public GoodsBean l;

    /* loaded from: /tmp/classes2.dex */
    public class a implements TextView.OnEditorActionListener {
        public a() {
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            if (i != 3) {
                return false;
            }
            VideoGoodsAddActivity.this.K1();
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
            if (VideoGoodsAddActivity.this.k != null) {
                VideoGoodsAddActivity.this.k.removeCallbacksAndMessages(null);
            }
            boolean isEmpty = TextUtils.isEmpty(charSequence);
            VideoGoodsAddActivity videoGoodsAddActivity = VideoGoodsAddActivity.this;
            if (!isEmpty) {
                if (videoGoodsAddActivity.k != null) {
                    VideoGoodsAddActivity.this.k.sendEmptyMessageDelayed(0, 500L);
                    return;
                }
                return;
            }
            videoGoodsAddActivity.f = null;
            if (VideoGoodsAddActivity.this.j != null) {
                VideoGoodsAddActivity.this.j.M();
            }
            if (VideoGoodsAddActivity.this.h.getVisibility() == 0) {
                VideoGoodsAddActivity.this.h.setVisibility(4);
                VideoGoodsAddActivity.this.i.Z(VideoGoodsAddActivity.this.l);
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c implements CommonRefreshView.e {
        public c() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (VideoGoodsAddActivity.this.i == null) {
                VideoGoodsAddActivity videoGoodsAddActivity = VideoGoodsAddActivity.this;
                videoGoodsAddActivity.i = new wh4(videoGoodsAddActivity.b);
                VideoGoodsAddActivity.this.i.R(VideoGoodsAddActivity.this);
            }
            return VideoGoodsAddActivity.this.i;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onLoadMoreFailure() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onLoadMoreSuccess(List list, int i) {
            VideoGoodsAddActivity.this.i.Z(VideoGoodsAddActivity.this.l);
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onRefreshFailure() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onRefreshSuccess(List list, int i) {
            VideoGoodsAddActivity.this.i.Z(VideoGoodsAddActivity.this.l);
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public List processData(String[] strArr) {
            return VideoGoodsAddActivity.this.J1(strArr);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d implements CommonRefreshView.e {
        public d() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public ce3 getAdapter() {
            if (VideoGoodsAddActivity.this.j == null) {
                VideoGoodsAddActivity videoGoodsAddActivity = VideoGoodsAddActivity.this;
                videoGoodsAddActivity.j = new wh4(videoGoodsAddActivity.b);
                VideoGoodsAddActivity.this.j.R(VideoGoodsAddActivity.this);
            }
            return VideoGoodsAddActivity.this.j;
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void loadData(int i, HttpCallback httpCallback) {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onLoadMoreFailure() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onLoadMoreSuccess(List list, int i) {
            VideoGoodsAddActivity.this.j.Z(VideoGoodsAddActivity.this.l);
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onRefreshFailure() {
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public void onRefreshSuccess(List list, int i) {
            VideoGoodsAddActivity.this.j.Z(VideoGoodsAddActivity.this.l);
        }

        @Override // com.yunbao.common.custom.CommonRefreshView.e
        public List processData(String[] strArr) {
            return VideoGoodsAddActivity.this.J1(strArr);
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public static class e extends Handler {
        public VideoGoodsAddActivity a;

        public e(VideoGoodsAddActivity videoGoodsAddActivity) {
            this.a = (VideoGoodsAddActivity) new WeakReference(videoGoodsAddActivity).get();
        }

        public void a() {
            this.a = null;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            VideoGoodsAddActivity videoGoodsAddActivity = this.a;
            if (videoGoodsAddActivity != null) {
                videoGoodsAddActivity.K1();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List J1(String[] strArr) {
        return (strArr == null || strArr.length <= 0) ? new ArrayList(1) : mu1.a(Arrays.toString(strArr), GoodsBean.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K1() {
        String trim = this.e.getText().toString().trim();
        if (TextUtils.isEmpty(trim)) {
            t54.a(m93.r1);
            return;
        }
        e eVar = this.k;
        if (eVar != null) {
            eVar.removeCallbacksAndMessages(null);
        }
        this.f = trim;
        if (this.h.getVisibility() != 0) {
            this.h.setVisibility(0);
        }
        this.h.k();
    }

    @Override // defpackage.et2
    /* renamed from: I1, reason: merged with bridge method [inline-methods] */
    public void onItemClick(GoodsBean goodsBean, int i) {
        this.l = goodsBean;
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return b83.c;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.W1));
        this.l = (GoodsBean) getIntent().getParcelableExtra("goods");
        EditText editText = (EditText) findViewById(f73.y);
        this.e = editText;
        editText.setOnEditorActionListener(new a());
        this.e.addTextChangedListener(new b());
        CommonRefreshView commonRefreshView = (CommonRefreshView) findViewById(f73.N);
        this.g = commonRefreshView;
        commonRefreshView.setEmptyLayoutId(b83.t);
        this.g.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        this.g.setDataHelper(new c());
        CommonRefreshView commonRefreshView2 = (CommonRefreshView) findViewById(f73.O);
        this.h = commonRefreshView2;
        commonRefreshView2.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        this.h.setDataHelper(new d());
        this.k = new e(this);
        this.g.k();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void onBackPressed() {
        Intent intent = getIntent();
        GoodsBean goodsBean = this.l;
        if (goodsBean != null) {
            intent.putExtra("goods", goodsBean);
        } else {
            intent.removeExtra("goods");
        }
        setResult(-1, intent);
        super/*androidx.activity.ComponentActivity*/.onBackPressed();
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        e eVar = this.k;
        if (eVar != null) {
            eVar.removeCallbacksAndMessages(null);
            this.k.a();
        }
        this.k = null;
        super.onDestroy();
    }
}
