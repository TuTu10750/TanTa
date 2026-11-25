package com.yunbao.common.bean;

import android.view.View;
import defpackage.dq1;
import defpackage.po3;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0015\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u0012\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u000f\u0010\u000eJ\u0012\u0010\u0010\u001a\u0004\u0018\u00010\u0002HÆ\u0003¢\u0006\u0004\b\u0010\u0010\u000eJ4\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0011\u0010\u0012J\u0010\u0010\u0013\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0013\u0010\u000eJ\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u001a\u0010\u0019\u001a\u00020\u00182\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0019\u0010\u001aR$\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u001b\u001a\u0004\b\u001c\u0010\u000e\"\u0004\b\u001d\u0010\u001eR$\u0010\u0004\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u001b\u001a\u0004\b\u001f\u0010\u000e\"\u0004\b \u0010\u001eR$\u0010\u0005\u001a\u0004\u0018\u00010\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b!\u0010\u000e\"\u0004\b\"\u0010\u001e¨\u0006#"}, d2 = {"Lcom/yunbao/common/bean/MsgStyleBean;", "", "", "backgroundColor", "borderColor", "textColor", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/view/View;", "view", "Lqc4;", "setViewBg", "(Landroid/view/View;)V", "component1", "()Ljava/lang/String;", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/yunbao/common/bean/MsgStyleBean;", "toString", "", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", "getBackgroundColor", "setBackgroundColor", "(Ljava/lang/String;)V", "getBorderColor", "setBorderColor", "getTextColor", "setTextColor", "common_release"}, k = 1, mv = {2, 3, 0}, xi = 48)
/* loaded from: /tmp/classes2.dex */
public final /* data */ class MsgStyleBean {
    private String backgroundColor;
    private String borderColor;
    private String textColor;

    public MsgStyleBean() {
        this(null, null, null, 7, null);
    }

    public MsgStyleBean(String str, String str2, String str3) {
        this.backgroundColor = str;
        this.borderColor = str2;
        this.textColor = str3;
    }

    public /* synthetic */ MsgStyleBean(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    public static /* synthetic */ MsgStyleBean copy$default(MsgStyleBean msgStyleBean, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = msgStyleBean.backgroundColor;
        }
        if ((i & 2) != 0) {
            str2 = msgStyleBean.borderColor;
        }
        if ((i & 4) != 0) {
            str3 = msgStyleBean.textColor;
        }
        return msgStyleBean.copy(str, str2, str3);
    }

    /* renamed from: component1, reason: from getter */
    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBorderColor() {
        return this.borderColor;
    }

    /* renamed from: component3, reason: from getter */
    public final String getTextColor() {
        return this.textColor;
    }

    public final MsgStyleBean copy(String backgroundColor, String borderColor, String textColor) {
        return new MsgStyleBean(backgroundColor, borderColor, textColor);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MsgStyleBean)) {
            return false;
        }
        MsgStyleBean msgStyleBean = (MsgStyleBean) other;
        return dq1.a(this.backgroundColor, msgStyleBean.backgroundColor) && dq1.a(this.borderColor, msgStyleBean.borderColor) && dq1.a(this.textColor, msgStyleBean.textColor);
    }

    public final String getBackgroundColor() {
        return this.backgroundColor;
    }

    public final String getBorderColor() {
        return this.borderColor;
    }

    public final String getTextColor() {
        return this.textColor;
    }

    public int hashCode() {
        String str = this.backgroundColor;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.borderColor;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.textColor;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    public final void setBackgroundColor(String str) {
        this.backgroundColor = str;
    }

    public final void setBorderColor(String str) {
        this.borderColor = str;
    }

    public final void setTextColor(String str) {
        this.textColor = str;
    }

    public final void setViewBg(View view) {
        view.getClass();
        po3.b(view.getContext(), view, this.backgroundColor, 10.0f, 1.0f, this.borderColor, 0);
    }

    public String toString() {
        return "MsgStyleBean(backgroundColor=" + this.backgroundColor + ", borderColor=" + this.borderColor + ", textColor=" + this.textColor + ')';
    }
}
