package defpackage;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import com.umeng.analytics.pro.cl;
import com.umeng.umcrash.UMCrash;
import com.yunbao.im.dao.IMMessageBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public final class rh1 implements qh1 {
    public final RoomDatabase a;
    public final fu0 b;
    public final eu0 c;
    public final to3 d;
    public final to3 e;

    /* loaded from: /tmp/classes2.dex */
    public class a extends fu0 {
        public a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // defpackage.to3
        public String d() {
            return "INSERT OR IGNORE INTO `tb_msg` (`msgId`,`userId`,`senderId`,`groupId`,`timestamp`,`self`,`type`,`status`,`revoked`,`showTimeString`,`text`,`localPath`,`originImageUrl`,`thumbImageUrl`,`width`,`height`,`duration`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // defpackage.fu0
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void g(gy3 gy3Var, IMMessageBean iMMessageBean) {
            if (iMMessageBean.getMsgId() == null) {
                gy3Var.f0(1);
            } else {
                gy3Var.d(1, iMMessageBean.getMsgId());
            }
            if (iMMessageBean.getUserId() == null) {
                gy3Var.f0(2);
            } else {
                gy3Var.d(2, iMMessageBean.getUserId());
            }
            if (iMMessageBean.getSenderId() == null) {
                gy3Var.f0(3);
            } else {
                gy3Var.d(3, iMMessageBean.getSenderId());
            }
            if (iMMessageBean.getGroupId() == null) {
                gy3Var.f0(4);
            } else {
                gy3Var.d(4, iMMessageBean.getGroupId());
            }
            gy3Var.J(5, iMMessageBean.getTimestamp());
            gy3Var.J(6, iMMessageBean.getSelf() ? 1L : 0L);
            gy3Var.J(7, iMMessageBean.getType());
            gy3Var.J(8, iMMessageBean.getStatus());
            gy3Var.J(9, iMMessageBean.getRevoked() ? 1L : 0L);
            if (iMMessageBean.getShowTimeString() == null) {
                gy3Var.f0(10);
            } else {
                gy3Var.d(10, iMMessageBean.getShowTimeString());
            }
            if (iMMessageBean.getText() == null) {
                gy3Var.f0(11);
            } else {
                gy3Var.d(11, iMMessageBean.getText());
            }
            if (iMMessageBean.getLocalPath() == null) {
                gy3Var.f0(12);
            } else {
                gy3Var.d(12, iMMessageBean.getLocalPath());
            }
            if (iMMessageBean.getOriginImageUrl() == null) {
                gy3Var.f0(13);
            } else {
                gy3Var.d(13, iMMessageBean.getOriginImageUrl());
            }
            if (iMMessageBean.getThumbImageUrl() == null) {
                gy3Var.f0(14);
            } else {
                gy3Var.d(14, iMMessageBean.getThumbImageUrl());
            }
            gy3Var.J(15, iMMessageBean.getWidth());
            gy3Var.J(16, iMMessageBean.getHeight());
            gy3Var.J(17, iMMessageBean.getDuration());
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends eu0 {
        public b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // defpackage.to3
        public String d() {
            return "UPDATE OR REPLACE `tb_msg` SET `msgId` = ?,`userId` = ?,`senderId` = ?,`groupId` = ?,`timestamp` = ?,`self` = ?,`type` = ?,`status` = ?,`revoked` = ?,`showTimeString` = ?,`text` = ?,`localPath` = ?,`originImageUrl` = ?,`thumbImageUrl` = ?,`width` = ?,`height` = ?,`duration` = ? WHERE `msgId` = ?";
        }

        @Override // defpackage.eu0
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(gy3 gy3Var, IMMessageBean iMMessageBean) {
            if (iMMessageBean.getMsgId() == null) {
                gy3Var.f0(1);
            } else {
                gy3Var.d(1, iMMessageBean.getMsgId());
            }
            if (iMMessageBean.getUserId() == null) {
                gy3Var.f0(2);
            } else {
                gy3Var.d(2, iMMessageBean.getUserId());
            }
            if (iMMessageBean.getSenderId() == null) {
                gy3Var.f0(3);
            } else {
                gy3Var.d(3, iMMessageBean.getSenderId());
            }
            if (iMMessageBean.getGroupId() == null) {
                gy3Var.f0(4);
            } else {
                gy3Var.d(4, iMMessageBean.getGroupId());
            }
            gy3Var.J(5, iMMessageBean.getTimestamp());
            gy3Var.J(6, iMMessageBean.getSelf() ? 1L : 0L);
            gy3Var.J(7, iMMessageBean.getType());
            gy3Var.J(8, iMMessageBean.getStatus());
            gy3Var.J(9, iMMessageBean.getRevoked() ? 1L : 0L);
            if (iMMessageBean.getShowTimeString() == null) {
                gy3Var.f0(10);
            } else {
                gy3Var.d(10, iMMessageBean.getShowTimeString());
            }
            if (iMMessageBean.getText() == null) {
                gy3Var.f0(11);
            } else {
                gy3Var.d(11, iMMessageBean.getText());
            }
            if (iMMessageBean.getLocalPath() == null) {
                gy3Var.f0(12);
            } else {
                gy3Var.d(12, iMMessageBean.getLocalPath());
            }
            if (iMMessageBean.getOriginImageUrl() == null) {
                gy3Var.f0(13);
            } else {
                gy3Var.d(13, iMMessageBean.getOriginImageUrl());
            }
            if (iMMessageBean.getThumbImageUrl() == null) {
                gy3Var.f0(14);
            } else {
                gy3Var.d(14, iMMessageBean.getThumbImageUrl());
            }
            gy3Var.J(15, iMMessageBean.getWidth());
            gy3Var.J(16, iMMessageBean.getHeight());
            gy3Var.J(17, iMMessageBean.getDuration());
            if (iMMessageBean.getMsgId() == null) {
                gy3Var.f0(18);
            } else {
                gy3Var.d(18, iMMessageBean.getMsgId());
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class c extends to3 {
        public c(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // defpackage.to3
        public String d() {
            return "DELETE FROM tb_msg WHERE msgId = ?";
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class d extends to3 {
        public d(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // defpackage.to3
        public String d() {
            return "DELETE FROM tb_msg WHERE userId = ?";
        }
    }

    public rh1(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
        this.e = new d(roomDatabase);
    }

    public static List g() {
        return Collections.EMPTY_LIST;
    }

    @Override // defpackage.qh1
    public void a(IMMessageBean iMMessageBean) {
        this.a.d();
        this.a.e();
        try {
            this.c.h(iMMessageBean);
            this.a.y();
        } finally {
            this.a.i();
        }
    }

    @Override // defpackage.qh1
    public IMMessageBean b(String str) {
        ei3 ei3Var;
        IMMessageBean iMMessageBean;
        ei3 c2 = ei3.c("SELECT * FROM tb_msg WHERE msgId=?", 1);
        if (str == null) {
            c2.f0(1);
        } else {
            c2.d(1, str);
        }
        this.a.d();
        Cursor b2 = x80.b(this.a, c2, false, (CancellationSignal) null);
        try {
            int d2 = p80.d(b2, "msgId");
            int d3 = p80.d(b2, "userId");
            int d4 = p80.d(b2, "senderId");
            int d5 = p80.d(b2, "groupId");
            int d6 = p80.d(b2, UMCrash.SP_KEY_TIMESTAMP);
            int d7 = p80.d(b2, "self");
            int d8 = p80.d(b2, "type");
            int d9 = p80.d(b2, cl.i);
            int d10 = p80.d(b2, "revoked");
            int d11 = p80.d(b2, "showTimeString");
            int d12 = p80.d(b2, "text");
            int d13 = p80.d(b2, "localPath");
            int d14 = p80.d(b2, "originImageUrl");
            int d15 = p80.d(b2, "thumbImageUrl");
            ei3Var = c2;
            try {
                int d16 = p80.d(b2, "width");
                int d17 = p80.d(b2, "height");
                int d18 = p80.d(b2, "duration");
                if (b2.moveToFirst()) {
                    iMMessageBean = new IMMessageBean(b2.isNull(d2) ? null : b2.getString(d2), b2.isNull(d3) ? null : b2.getString(d3), b2.isNull(d4) ? null : b2.getString(d4), b2.isNull(d5) ? null : b2.getString(d5), b2.getLong(d6), b2.getInt(d7) != 0, b2.getInt(d8), b2.getInt(d9), b2.getInt(d10) != 0, b2.isNull(d11) ? null : b2.getString(d11), b2.isNull(d12) ? null : b2.getString(d12), b2.isNull(d13) ? null : b2.getString(d13), b2.isNull(d14) ? null : b2.getString(d14), b2.isNull(d15) ? null : b2.getString(d15), b2.getInt(d16), b2.getInt(d17), b2.getInt(d18));
                } else {
                    iMMessageBean = null;
                }
                b2.close();
                ei3Var.T();
                return iMMessageBean;
            } catch (Throwable th) {
                th = th;
                b2.close();
                ei3Var.T();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            ei3Var = c2;
        }
    }

    @Override // defpackage.qh1
    public void c(List list) {
        this.a.d();
        this.a.e();
        try {
            this.b.h(list);
            this.a.y();
        } finally {
            this.a.i();
        }
    }

    @Override // defpackage.qh1
    public void d(IMMessageBean iMMessageBean) {
        this.a.d();
        this.a.e();
        try {
            this.b.i(iMMessageBean);
            this.a.y();
        } finally {
            this.a.i();
        }
    }

    @Override // defpackage.qh1
    public void e(String str) {
        this.a.d();
        gy3 a2 = this.e.a();
        if (str == null) {
            a2.f0(1);
        } else {
            a2.d(1, str);
        }
        this.a.e();
        try {
            a2.u();
            this.a.y();
        } finally {
            this.a.i();
            this.e.f(a2);
        }
    }

    @Override // defpackage.qh1
    public List f(String str) {
        ei3 ei3Var;
        int i;
        int i2;
        String string;
        ei3 c2 = ei3.c("SELECT * FROM tb_msg WHERE userId=? ORDER BY timestamp ASC", 1);
        if (str == null) {
            c2.f0(1);
        } else {
            c2.d(1, str);
        }
        this.a.d();
        Cursor b2 = x80.b(this.a, c2, false, (CancellationSignal) null);
        try {
            int d2 = p80.d(b2, "msgId");
            int d3 = p80.d(b2, "userId");
            int d4 = p80.d(b2, "senderId");
            int d5 = p80.d(b2, "groupId");
            int d6 = p80.d(b2, UMCrash.SP_KEY_TIMESTAMP);
            int d7 = p80.d(b2, "self");
            int d8 = p80.d(b2, "type");
            int d9 = p80.d(b2, cl.i);
            int d10 = p80.d(b2, "revoked");
            int d11 = p80.d(b2, "showTimeString");
            int d12 = p80.d(b2, "text");
            int d13 = p80.d(b2, "localPath");
            int d14 = p80.d(b2, "originImageUrl");
            int d15 = p80.d(b2, "thumbImageUrl");
            ei3Var = c2;
            try {
                int d16 = p80.d(b2, "width");
                int d17 = p80.d(b2, "height");
                int d18 = p80.d(b2, "duration");
                int i3 = d15;
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    String string2 = b2.isNull(d2) ? null : b2.getString(d2);
                    String string3 = b2.isNull(d3) ? null : b2.getString(d3);
                    String string4 = b2.isNull(d4) ? null : b2.getString(d4);
                    String string5 = b2.isNull(d5) ? null : b2.getString(d5);
                    long j = b2.getLong(d6);
                    boolean z = b2.getInt(d7) != 0;
                    int i4 = b2.getInt(d8);
                    int i5 = b2.getInt(d9);
                    boolean z2 = b2.getInt(d10) != 0;
                    String string6 = b2.isNull(d11) ? null : b2.getString(d11);
                    String string7 = b2.isNull(d12) ? null : b2.getString(d12);
                    String string8 = b2.isNull(d13) ? null : b2.getString(d13);
                    String string9 = b2.isNull(d14) ? null : b2.getString(d14);
                    int i6 = i3;
                    if (b2.isNull(i6)) {
                        int i7 = d16;
                        i = d2;
                        i2 = i7;
                        string = null;
                    } else {
                        int i8 = d16;
                        i = d2;
                        i2 = i8;
                        string = b2.getString(i6);
                    }
                    int i9 = b2.getInt(i2);
                    int i10 = i2;
                    int i11 = d17;
                    int i12 = b2.getInt(i11);
                    d17 = i11;
                    int i13 = d18;
                    d18 = i13;
                    arrayList.add(new IMMessageBean(string2, string3, string4, string5, j, z, i4, i5, z2, string6, string7, string8, string9, string, i9, i12, b2.getInt(i13)));
                    d2 = i;
                    d16 = i10;
                    i3 = i6;
                }
                b2.close();
                ei3Var.T();
                return arrayList;
            } catch (Throwable th) {
                th = th;
                b2.close();
                ei3Var.T();
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            ei3Var = c2;
        }
    }
}
