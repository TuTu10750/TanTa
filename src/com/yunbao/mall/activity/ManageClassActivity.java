package com.yunbao.mall.activity;

import android.content.Intent;
import android.os.Parcelable;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.mall.bean.ManageClassBean;
import defpackage.aq4;
import defpackage.d73;
import defpackage.ec2;
import defpackage.gc2;
import defpackage.m93;
import defpackage.t54;
import defpackage.z73;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class ManageClassActivity extends AbsActivity implements View.OnClickListener {
    public RecyclerView e;
    public gc2 f;

    /* loaded from: /tmp/classes2.dex */
    public class a extends HttpCallback {
        public final /* synthetic */ List a;

        public a(List list) {
            this.a = list;
        }

        @Override // com.yunbao.common.http.HttpCallback
        public void onSuccess(int i, String str, String[] strArr) {
            if (i == 0) {
                List<ManageClassBean> parseArray = JSON.parseArray(Arrays.toString(strArr), ManageClassBean.class);
                List list = this.a;
                if (list != null && list.size() > 0) {
                    for (ManageClassBean manageClassBean : parseArray) {
                        Iterator it = this.a.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                if (((String) it.next()).equals(manageClassBean.getId())) {
                                    manageClassBean.setChecked(true);
                                    break;
                                }
                            } else {
                                break;
                            }
                        }
                    }
                }
                if (ManageClassActivity.this.e != null) {
                    ManageClassActivity manageClassActivity = ManageClassActivity.this;
                    manageClassActivity.f = new gc2(manageClassActivity.b, parseArray);
                    ManageClassActivity.this.e.setAdapter(ManageClassActivity.this.f);
                }
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void A1() {
        gc2 gc2Var = this.f;
        if (gc2Var != null) {
            ArrayList<? extends Parcelable> W = gc2Var.W();
            if (W == null || W.size() <= 0) {
                t54.a(m93.y5);
                return;
            }
            Intent intent = new Intent();
            intent.putParcelableArrayListExtra("mallApplyManageClass", W);
            setResult(-1, intent);
            finish();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public int g1() {
        return z73.y;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.yunbao.common.activity.AbsActivity
    public void m1() {
        t1(aq4.a(m93.x5));
        RecyclerView findViewById = findViewById(d73.u3);
        this.e = findViewById;
        findViewById.setHasFixedSize(true);
        this.e.setLayoutManager(new LinearLayoutManager(this.b, 1, false));
        findViewById(d73.n1).setOnClickListener(this);
        ec2.P(new a(getIntent().getStringArrayListExtra("mallApplyManageClass")));
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == d73.n1) {
            A1();
        }
    }

    @Override // com.yunbao.common.activity.AbsActivity
    public void onDestroy() {
        ec2.u("getManageClass");
        super.onDestroy();
    }
}
