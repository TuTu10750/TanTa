package defpackage;

import com.yunbao.im.bean.ImConversationBean;

/* loaded from: /tmp/classes2.dex */
public class ij1 {
    public ImConversationBean a;

    public ij1(ImConversationBean imConversationBean) {
        this.a = imConversationBean;
    }

    public ImConversationBean a() {
        return this.a;
    }

    public String b() {
        ImConversationBean imConversationBean = this.a;
        return imConversationBean != null ? imConversationBean.getUserID() : "";
    }
}
