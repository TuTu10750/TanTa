package com.yunbao.main.views;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.scwang.smart.refresh.footer.ClassicsFooter;
import com.scwang.smart.refresh.header.ClassicsHeader;
import com.scwang.smart.refresh.layout.SmartRefreshLayout;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;
import com.yunbao.common.activity.AbsActivity;
import com.yunbao.common.activity.WebViewActivity;
import com.yunbao.common.http.HttpCallback;
import com.yunbao.common.utils.MemoryPressureUtil;
import com.yunbao.live.bean.LiveBean;
import com.yunbao.main.activity.LiveFollowActivity;
import com.yunbao.main.activity.LiveVoiceRoomListActivity;
import com.yunbao.main.bean.BannerBean;
import com.yunbao.main.views.MainHomeLiveViewHolder;
import defpackage.b1;
import defpackage.c73;
import defpackage.db2;
import defpackage.et2;
import defpackage.ie3;
import defpackage.j10;
import defpackage.j30;
import defpackage.kn1;
import defpackage.la;
import defpackage.lx1;
import defpackage.m12;
import defpackage.pw3;
import defpackage.v0;
import defpackage.xa2;
import defpackage.y63;
import defpackage.y73;
import defpackage.ys2;
import defpackage.zn0;
import defpackage.zu0;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: /tmp/classes2.dex */
public class MainHomeLiveViewHolder extends v0 implements et2, View.OnClickListener {
    private static final int BANNER_IMAGE_HEIGHT = 320;
    private static final int BANNER_IMAGE_WIDTH = 720;
    List<LiveBean> alllist;
    private LinearLayout llHasNew;
    private Banner mBanner;
    private List<BannerBean> mBannerList;
    private boolean mBannerNeedUpdate;
    private xa2 mBottomAdapter;
    private int mClassId;
    private ClassicsFooter mFooter;
    private ClassicsHeader mHeader;
    private int mIntervalTime;
    private Long mLastShowHasNew;
    private View mLiveEmptyTip;
    private String mNextCursor;
    private SmartRefreshLayout mSmartRefreshLayout;
    private int oldUid;
    RecyclerView recyclerViewBottom;

    public MainHomeLiveViewHolder(Context context, ViewGroup viewGroup) {
        super(context, viewGroup);
        this.mNextCursor = "";
        this.mLastShowHasNew = Long.valueOf(System.currentTimeMillis());
        this.mIntervalTime = j30.q().h().getIntervalTime();
        this.alllist = new ArrayList();
    }

    public MainHomeLiveViewHolder(Context context, ViewGroup viewGroup, int i) {
        super(context, viewGroup);
        this.mNextCursor = "";
        this.mLastShowHasNew = Long.valueOf(System.currentTimeMillis());
        this.mIntervalTime = j30.q().h().getIntervalTime();
        this.alllist = new ArrayList();
        this.mClassId = i;
    }

    public static /* synthetic */ void a0(MainHomeLiveViewHolder mainHomeLiveViewHolder, View view) {
        mainHomeLiveViewHolder.mNextCursor = "";
        mainHomeLiveViewHolder.getList();
        mainHomeLiveViewHolder.llHasNew.setVisibility(8);
    }

    private void cleanupMemoryBeforeLiveListUpdate() {
        if (MemoryPressureUtil.j()) {
            lx1.c("MainHomeLive", "live list low memory, available=" + MemoryPressureUtil.g());
            clearImageMemoryCacheSafely();
            MemoryPressureUtil.l();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void clearImageMemoryCacheSafely() {
        try {
            kn1.c();
        } catch (RuntimeException e) {
            lx1.c("MainHomeLive", "clear image memory failed: " + e.getMessage());
        }
    }

    private long getAvailableRuntimeMemory() {
        return MemoryPressureUtil.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getList() {
        db2.J(this.mClassId, this.mNextCursor, new HttpCallback() { // from class: com.yunbao.main.views.MainHomeLiveViewHolder.7
            @Override // com.yunbao.common.http.HttpCallback
            public void onError() {
                super.onError();
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onFinish() {
                super.onFinish();
                MainHomeLiveViewHolder.this.mSmartRefreshLayout.u();
                MainHomeLiveViewHolder.this.mSmartRefreshLayout.p();
            }

            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                List list;
                System.out.println("info---" + strArr);
                JSONObject parseInfoObject = MainHomeLiveViewHolder.this.parseInfoObject(strArr);
                if (parseInfoObject == null) {
                    MainHomeLiveViewHolder.this.setDate(new ArrayList(), "");
                    return;
                }
                String string = parseInfoObject.getString("next_cursor");
                String str2 = string != null ? string : "";
                String string2 = parseInfoObject.getString("list_revision");
                String string3 = parseInfoObject.getString("latest_revision");
                if (parseInfoObject.containsKey("has_more")) {
                    boolean booleanValue = parseInfoObject.getBooleanValue("has_more");
                    MainHomeLiveViewHolder mainHomeLiveViewHolder = MainHomeLiveViewHolder.this;
                    if (booleanValue) {
                        mainHomeLiveViewHolder.mSmartRefreshLayout.K(false);
                    } else {
                        mainHomeLiveViewHolder.mSmartRefreshLayout.H(true);
                        MainHomeLiveViewHolder.this.mSmartRefreshLayout.t();
                    }
                }
                int intValue = parseInfoObject.getIntValue("stale");
                try {
                    list = JSON.parseArray(parseInfoObject.getString("list"), LiveBean.class);
                } catch (Exception e) {
                    lx1.c("MainHomeLive", "parse live list failed: " + e.getMessage());
                    list = null;
                }
                if (list == null) {
                    list = new ArrayList();
                }
                if (intValue == 2) {
                    MainHomeLiveViewHolder.this.refresh();
                    return;
                }
                boolean z = (System.currentTimeMillis() - MainHomeLiveViewHolder.this.mLastShowHasNew.longValue()) / 1000 > ((long) MainHomeLiveViewHolder.this.mIntervalTime);
                lx1.c("9797", "mLastShowHasNew:" + new Date(MainHomeLiveViewHolder.this.mLastShowHasNew.longValue()));
                lx1.c("9797", "isShow:" + z);
                if (!TextUtils.equals(string2, string3) && z) {
                    MainHomeLiveViewHolder.this.mLastShowHasNew = Long.valueOf(System.currentTimeMillis());
                    MainHomeLiveViewHolder.this.llHasNew.setVisibility(0);
                }
                if (MainHomeLiveViewHolder.this.mNextCursor.isEmpty()) {
                    MainHomeLiveViewHolder.this.llHasNew.setVisibility(8);
                }
                MainHomeLiveViewHolder.this.setDate(list, str2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleHomeLiveItemClick(LiveBean liveBean, int i) {
        if (j10.b(2000) && !j30.q().L()) {
            this.oldUid = i;
            watchHomeLive(liveBean, i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideBannerSafely() {
        Banner banner = this.mBanner;
        if (banner == null) {
            return;
        }
        try {
            if (banner.getVisibility() != 8) {
                this.mBanner.setVisibility(8);
            }
        } catch (RuntimeException e) {
            lx1.c("MainHomeLive", "hide banner failed: " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public JSONObject parseInfoObject(String[] strArr) {
        if (strArr != null && strArr.length != 0 && !TextUtils.isEmpty(strArr[0])) {
            try {
                return JSON.parseObject(strArr[0]);
            } catch (Exception e) {
                lx1.c("MainHomeLive", "parse info failed: " + e.getMessage());
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean prepareMemoryForBanner() {
        if (!MemoryPressureUtil.j()) {
            return true;
        }
        lx1.c("MainHomeLive", "banner low memory, available=" + MemoryPressureUtil.g());
        clearImageMemoryCacheSafely();
        MemoryPressureUtil.l();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refresh() {
        this.mNextCursor = "";
        this.mSmartRefreshLayout.I(true);
        getList();
        showBanner();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setDate(List<LiveBean> list, String str) {
        if (this.mNextCursor.isEmpty()) {
            this.alllist.clear();
        }
        cleanupMemoryBeforeLiveListUpdate();
        if (list != null) {
            this.alllist.addAll(list);
        }
        if (this.mBottomAdapter != null && list != null && list.size() > 0) {
            boolean isEmpty = this.mNextCursor.isEmpty();
            xa2 xa2Var = this.mBottomAdapter;
            if (isEmpty) {
                xa2Var.P(list);
            } else {
                xa2Var.O(list);
            }
        }
        if (!this.mNextCursor.isEmpty()) {
            View view = this.mLiveEmptyTip;
            if (view != null) {
                view.setVisibility(8);
            }
        } else if (list == null || list.isEmpty()) {
            View view2 = this.mLiveEmptyTip;
            if (view2 != null && view2.getVisibility() != 0) {
                this.mLiveEmptyTip.setVisibility(0);
            }
            xa2 xa2Var2 = this.mBottomAdapter;
            if (xa2Var2 != null) {
                xa2Var2.M();
            }
        } else {
            View view3 = this.mLiveEmptyTip;
            if (view3 != null) {
                view3.setVisibility(8);
            }
        }
        this.mNextCursor = str;
    }

    private void showBanner() {
        if (this.mBanner == null) {
            return;
        }
        db2.D(new HttpCallback() { // from class: com.yunbao.main.views.MainHomeLiveViewHolder.8
            @Override // com.yunbao.common.http.HttpCallback
            public void onSuccess(int i, String str, String[] strArr) {
                List list;
                if (i == 0) {
                    JSONObject parseInfoObject = MainHomeLiveViewHolder.this.parseInfoObject(strArr);
                    MainHomeLiveViewHolder mainHomeLiveViewHolder = MainHomeLiveViewHolder.this;
                    if (parseInfoObject == null) {
                        if (mainHomeLiveViewHolder.mBanner.getVisibility() != 8) {
                            MainHomeLiveViewHolder.this.mBanner.setVisibility(8);
                        }
                        MainHomeLiveViewHolder.this.mBannerList = new ArrayList();
                        return;
                    }
                    mainHomeLiveViewHolder.mBannerNeedUpdate = false;
                    try {
                        list = JSON.parseArray(parseInfoObject.getString("slide"), BannerBean.class);
                    } catch (Exception e) {
                        lx1.c("MainHomeLive", "parse banner list failed: " + e.getMessage());
                        list = null;
                    }
                    if (list == null) {
                        list = new ArrayList();
                    }
                    if (list.size() > 0) {
                        if (MainHomeLiveViewHolder.this.mBannerList == null || MainHomeLiveViewHolder.this.mBannerList.size() != list.size()) {
                            MainHomeLiveViewHolder.this.mBannerNeedUpdate = true;
                        } else {
                            for (int i2 = 0; i2 < MainHomeLiveViewHolder.this.mBannerList.size(); i2++) {
                                BannerBean bannerBean = (BannerBean) MainHomeLiveViewHolder.this.mBannerList.get(i2);
                                if (bannerBean == null || !bannerBean.isEqual((BannerBean) list.get(i2))) {
                                    MainHomeLiveViewHolder.this.mBannerNeedUpdate = true;
                                    break;
                                }
                            }
                        }
                    }
                    MainHomeLiveViewHolder.this.mBannerList = list;
                    if (MainHomeLiveViewHolder.this.mBannerList == null || MainHomeLiveViewHolder.this.mBannerList.size() <= 0) {
                        MainHomeLiveViewHolder.this.hideBannerSafely();
                        return;
                    }
                    MainHomeLiveViewHolder.this.prepareMemoryForBanner();
                    if (MainHomeLiveViewHolder.this.mBanner.getVisibility() != 0) {
                        MainHomeLiveViewHolder.this.mBanner.setVisibility(0);
                    }
                    if (MainHomeLiveViewHolder.this.mBannerNeedUpdate) {
                        MainHomeLiveViewHolder.this.updateBannerSafely();
                    }
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateBannerSafely() {
        try {
            this.mBanner.D(this.mBannerList);
        } catch (OutOfMemoryError e) {
            lx1.c("MainHomeLive", "update banner OOM: " + e.getMessage());
            clearImageMemoryCacheSafely();
            this.mBannerNeedUpdate = false;
            MemoryPressureUtil.l();
        } catch (RuntimeException e2) {
            lx1.c("MainHomeLive", "update banner failed: " + e2.getMessage());
            this.mBannerNeedUpdate = false;
        }
    }

    private void watchHomeLive(LiveBean liveBean, int i) {
        watchLive(liveBean, "liveHome", i);
    }

    @Override // defpackage.b1
    public int getLayoutId() {
        return y73.k1;
    }

    @Override // defpackage.b1
    public void init() {
        zu0.c().n(this);
        if (this.mIntervalTime == 0) {
            this.mIntervalTime = 300;
        }
        SmartRefreshLayout findViewById = findViewById(y63.a0);
        this.mSmartRefreshLayout = findViewById;
        findViewById.J(true);
        this.mSmartRefreshLayout.I(true);
        this.mSmartRefreshLayout.G(true);
        this.mSmartRefreshLayout.N(new pt2() { // from class: com.yunbao.main.views.MainHomeLiveViewHolder.1
            public void onLoadMore(ke3 ke3Var) {
                MainHomeLiveViewHolder.this.getList();
                lx1.d("9090", "5555555");
            }

            public void onRefresh(ke3 ke3Var) {
                MainHomeLiveViewHolder.this.refresh();
                if (MainHomeLiveViewHolder.this.mNextCursor.isEmpty() && MainHomeLiveViewHolder.this.mBottomAdapter != null) {
                    MainHomeLiveViewHolder.this.mBottomAdapter.e0(-1);
                }
                lx1.d("9090", "44444444");
            }
        });
        LinearLayout linearLayout = (LinearLayout) findViewById(c73.B3);
        this.llHasNew = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() { // from class: ab2
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                MainHomeLiveViewHolder.a0(MainHomeLiveViewHolder.this, view);
            }
        });
        this.mHeader = findViewById(y63.L);
        this.mFooter = findViewById(y63.G);
        this.mSmartRefreshLayout.Q(this.mHeader);
        this.mSmartRefreshLayout.O(this.mFooter);
        RecyclerView findViewById2 = findViewById(c73.s4);
        this.recyclerViewBottom = findViewById2;
        findViewById2.setHasFixedSize(true);
        this.recyclerViewBottom.setItemViewCacheSize(0);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this.mContext, 3, 1, false);
        gridLayoutManager.s3(new GridLayoutManager.c() { // from class: com.yunbao.main.views.MainHomeLiveViewHolder.2
            public int getSpanSize(int i) {
                return (MainHomeLiveViewHolder.this.mBottomAdapter == null || !MainHomeLiveViewHolder.this.mBottomAdapter.c0(i)) ? 1 : 3;
            }
        });
        this.recyclerViewBottom.setLayoutManager(gridLayoutManager);
        final int a = zn0.a(4);
        this.recyclerViewBottom.k(new RecyclerView.n() { // from class: com.yunbao.main.views.MainHomeLiveViewHolder.3
            public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.a0 a0Var) {
                int n0 = recyclerView.n0(view);
                int i = 0;
                if (n0 == -1) {
                    rect.set(0, 0, 0, 0);
                    return;
                }
                if (MainHomeLiveViewHolder.this.mBottomAdapter != null && MainHomeLiveViewHolder.this.mBottomAdapter.c0(n0)) {
                    rect.set(0, 0, 0, 0);
                    return;
                }
                if (MainHomeLiveViewHolder.this.mBottomAdapter != null && MainHomeLiveViewHolder.this.mBottomAdapter.c0(0)) {
                    i = 1;
                }
                int i2 = n0 - i;
                int i3 = i2 % 3;
                int i4 = i2 / 3;
                int i5 = a;
                rect.left = (i3 * i5) / 3;
                rect.right = i5 - (((i3 + 1) * i5) / 3);
                if (i4 > 0) {
                    rect.top = i5;
                }
            }
        });
        View inflate = LayoutInflater.from(this.mContext).inflate(y73.l1, (ViewGroup) this.recyclerViewBottom, false);
        this.mLiveEmptyTip = inflate.findViewById(c73.A3);
        this.mBanner = (Banner) inflate.findViewById(c73.v);
        xa2 xa2Var = new xa2(this.mContext, new ArrayList());
        this.mBottomAdapter = xa2Var;
        xa2Var.d0(inflate);
        this.mBottomAdapter.R(new et2() { // from class: com.yunbao.main.views.MainHomeLiveViewHolder.4
            @Override // defpackage.et2
            public void onItemClick(LiveBean liveBean, int i) {
                MainHomeLiveViewHolder.this.handleHomeLiveItemClick(liveBean, i);
            }
        });
        this.recyclerViewBottom.setAdapter(this.mBottomAdapter);
        this.mBanner.w(new ImageLoader() { // from class: com.yunbao.main.views.MainHomeLiveViewHolder.5
            @Override // com.youth.banner.loader.ImageLoaderInterface
            public void displayImage(Context context, Object obj, ImageView imageView) {
                if (!(obj instanceof BannerBean)) {
                    kn1.a(imageView);
                    return;
                }
                if (MemoryPressureUtil.j()) {
                    lx1.c("MainHomeLive", "load banner image in low memory, available=" + MemoryPressureUtil.g());
                    MainHomeLiveViewHolder.this.clearImageMemoryCacheSafely();
                    MemoryPressureUtil.l();
                }
                try {
                    kn1.k(((b1) MainHomeLiveViewHolder.this).mContext, ((BannerBean) obj).getImageUrl(), imageView, MainHomeLiveViewHolder.BANNER_IMAGE_WIDTH, MainHomeLiveViewHolder.BANNER_IMAGE_HEIGHT);
                } catch (OutOfMemoryError e) {
                    lx1.c("MainHomeLive", "load banner image OOM: " + e.getMessage());
                    kn1.a(imageView);
                    MainHomeLiveViewHolder.this.clearImageMemoryCacheSafely();
                } catch (RuntimeException e2) {
                    lx1.c("MainHomeLive", "load banner image failed: " + e2.getMessage());
                    kn1.a(imageView);
                }
            }
        });
        this.mBanner.x(new ys2() { // from class: com.yunbao.main.views.MainHomeLiveViewHolder.6
            @Override // defpackage.ys2
            public void OnBannerClick(int i) {
                BannerBean bannerBean;
                if (j30.q().L() || MainHomeLiveViewHolder.this.mBannerList == null || i < 0 || i >= MainHomeLiveViewHolder.this.mBannerList.size() || (bannerBean = (BannerBean) MainHomeLiveViewHolder.this.mBannerList.get(i)) == null) {
                    return;
                }
                String link = bannerBean.getLink();
                if (TextUtils.isEmpty(link)) {
                    return;
                }
                if (bannerBean.getTarget() == 1) {
                    WebViewActivity.E1(((b1) MainHomeLiveViewHolder.this).mContext, link);
                    return;
                }
                try {
                    Intent intent = new Intent();
                    intent.setAction("android.intent.action.VIEW");
                    intent.setData(Uri.parse(link));
                    ((b1) MainHomeLiveViewHolder.this).mContext.startActivity(intent);
                } catch (Exception unused) {
                }
            }
        });
    }

    @Override // defpackage.y0
    public void loadData() {
        if (isFirstLoadData()) {
            lx1.d("9090", "1111111");
            refresh();
        }
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onAppLifecycleEvent(la laVar) {
        lx1.d("9090", "9999999");
        getList();
        lx1.d("9527", "首页刷新Event");
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (j30.q().L()) {
            return;
        }
        int id = view.getId();
        if (id == c73.K0) {
            LiveVoiceRoomListActivity.z1(this.mContext);
        } else if (id == c73.J0 && ((AbsActivity) this.mContext).e1()) {
            LiveFollowActivity.C1(this.mContext);
        }
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onDestroy() {
        super.onDestroy();
        zu0.c().p(this);
        release();
    }

    @Override // defpackage.et2
    public void onItemClick(LiveBean liveBean, int i) {
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onLiveClassSelectedEvent(m12 m12Var) {
        lx1.d("9090", "8888888");
        getList();
    }

    @pw3(threadMode = ThreadMode.MAIN)
    public void onRefreshHomeLiveEvent(ie3 ie3Var) {
        lx1.d("9090", "999999");
        String a = ie3Var == null ? null : ie3Var.a();
        if (TextUtils.isEmpty(a)) {
            getList();
            return;
        }
        xa2 xa2Var = this.mBottomAdapter;
        if (xa2Var != null) {
            xa2Var.Z(a);
        }
        if (this.alllist != null) {
            for (int i = 0; i < this.alllist.size(); i++) {
                if (a.equals(this.alllist.get(i).getUid())) {
                    this.alllist.remove(i);
                    return;
                }
            }
        }
    }

    @Override // defpackage.b1, defpackage.uy1
    public void onResume() {
        super.onResume();
        lx1.d("9090", "222222222");
        xa2 xa2Var = this.mBottomAdapter;
        if (xa2Var != null) {
            xa2Var.e0(this.oldUid);
        }
    }

    @Override // defpackage.b1
    public void release() {
        db2.i("getHot");
    }
}
