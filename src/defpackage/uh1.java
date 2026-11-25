package defpackage;

import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.room.RoomDatabase;
import com.yunbao.im.dao.IMUserBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /tmp/classes2.dex */
public final class uh1 implements th1 {
    public final RoomDatabase a;
    public final fu0 b;
    public final eu0 c;
    public final to3 d;

    /* loaded from: /tmp/classes2.dex */
    public class a extends fu0 {
        public a(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // defpackage.to3
        public String d() {
            return "INSERT OR REPLACE INTO `tb_user` (`id`,`userNiceName`,`avatar`,`sex`,`level`,`attent`,`otherAttent`,`anchorItem`,`tips`,`unReadCount`,`isGroup`,`conversationID`,`userID`,`groupID`,`lastMsgId`,`lastMsgString`,`lastMsgTime`,`lastMsgTimeString`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        }

        @Override // defpackage.fu0
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void g(gy3 gy3Var, IMUserBean iMUserBean) {
            if (iMUserBean.getId() == null) {
                gy3Var.f0(1);
            } else {
                gy3Var.d(1, iMUserBean.getId());
            }
            if (iMUserBean.getUserNiceName() == null) {
                gy3Var.f0(2);
            } else {
                gy3Var.d(2, iMUserBean.getUserNiceName());
            }
            if (iMUserBean.getAvatar() == null) {
                gy3Var.f0(3);
            } else {
                gy3Var.d(3, iMUserBean.getAvatar());
            }
            gy3Var.J(4, iMUserBean.getSex());
            gy3Var.J(5, iMUserBean.getLevel());
            gy3Var.J(6, iMUserBean.getAttent());
            gy3Var.J(7, iMUserBean.getOtherAttent());
            gy3Var.J(8, iMUserBean.getAnchorItem() ? 1L : 0L);
            if (iMUserBean.getTips() == null) {
                gy3Var.f0(9);
            } else {
                gy3Var.d(9, iMUserBean.getTips());
            }
            gy3Var.J(10, iMUserBean.getUnReadCount());
            gy3Var.J(11, iMUserBean.isGroup() ? 1L : 0L);
            if (iMUserBean.getConversationID() == null) {
                gy3Var.f0(12);
            } else {
                gy3Var.d(12, iMUserBean.getConversationID());
            }
            if (iMUserBean.getUserID() == null) {
                gy3Var.f0(13);
            } else {
                gy3Var.d(13, iMUserBean.getUserID());
            }
            if (iMUserBean.getGroupID() == null) {
                gy3Var.f0(14);
            } else {
                gy3Var.d(14, iMUserBean.getGroupID());
            }
            if (iMUserBean.getLastMsgId() == null) {
                gy3Var.f0(15);
            } else {
                gy3Var.d(15, iMUserBean.getLastMsgId());
            }
            if (iMUserBean.getLastMsgString() == null) {
                gy3Var.f0(16);
            } else {
                gy3Var.d(16, iMUserBean.getLastMsgString());
            }
            gy3Var.J(17, iMUserBean.getLastMsgTime());
            if (iMUserBean.getLastMsgTimeString() == null) {
                gy3Var.f0(18);
            } else {
                gy3Var.d(18, iMUserBean.getLastMsgTimeString());
            }
        }
    }

    /* loaded from: /tmp/classes2.dex */
    public class b extends eu0 {
        public b(RoomDatabase roomDatabase) {
            super(roomDatabase);
        }

        @Override // defpackage.to3
        public String d() {
            return "UPDATE OR REPLACE `tb_user` SET `id` = ?,`userNiceName` = ?,`avatar` = ?,`sex` = ?,`level` = ?,`attent` = ?,`otherAttent` = ?,`anchorItem` = ?,`tips` = ?,`unReadCount` = ?,`isGroup` = ?,`conversationID` = ?,`userID` = ?,`groupID` = ?,`lastMsgId` = ?,`lastMsgString` = ?,`lastMsgTime` = ?,`lastMsgTimeString` = ? WHERE `id` = ?";
        }

        @Override // defpackage.eu0
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void g(gy3 gy3Var, IMUserBean iMUserBean) {
            if (iMUserBean.getId() == null) {
                gy3Var.f0(1);
            } else {
                gy3Var.d(1, iMUserBean.getId());
            }
            if (iMUserBean.getUserNiceName() == null) {
                gy3Var.f0(2);
            } else {
                gy3Var.d(2, iMUserBean.getUserNiceName());
            }
            if (iMUserBean.getAvatar() == null) {
                gy3Var.f0(3);
            } else {
                gy3Var.d(3, iMUserBean.getAvatar());
            }
            gy3Var.J(4, iMUserBean.getSex());
            gy3Var.J(5, iMUserBean.getLevel());
            gy3Var.J(6, iMUserBean.getAttent());
            gy3Var.J(7, iMUserBean.getOtherAttent());
            gy3Var.J(8, iMUserBean.getAnchorItem() ? 1L : 0L);
            if (iMUserBean.getTips() == null) {
                gy3Var.f0(9);
            } else {
                gy3Var.d(9, iMUserBean.getTips());
            }
            gy3Var.J(10, iMUserBean.getUnReadCount());
            gy3Var.J(11, iMUserBean.isGroup() ? 1L : 0L);
            if (iMUserBean.getConversationID() == null) {
                gy3Var.f0(12);
            } else {
                gy3Var.d(12, iMUserBean.getConversationID());
            }
            if (iMUserBean.getUserID() == null) {
                gy3Var.f0(13);
            } else {
                gy3Var.d(13, iMUserBean.getUserID());
            }
            if (iMUserBean.getGroupID() == null) {
                gy3Var.f0(14);
            } else {
                gy3Var.d(14, iMUserBean.getGroupID());
            }
            if (iMUserBean.getLastMsgId() == null) {
                gy3Var.f0(15);
            } else {
                gy3Var.d(15, iMUserBean.getLastMsgId());
            }
            if (iMUserBean.getLastMsgString() == null) {
                gy3Var.f0(16);
            } else {
                gy3Var.d(16, iMUserBean.getLastMsgString());
            }
            gy3Var.J(17, iMUserBean.getLastMsgTime());
            if (iMUserBean.getLastMsgTimeString() == null) {
                gy3Var.f0(18);
            } else {
                gy3Var.d(18, iMUserBean.getLastMsgTimeString());
            }
            if (iMUserBean.getId() == null) {
                gy3Var.f0(19);
            } else {
                gy3Var.d(19, iMUserBean.getId());
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
            return "DELETE FROM tb_user WHERE id = ?";
        }
    }

    public uh1(RoomDatabase roomDatabase) {
        this.a = roomDatabase;
        this.b = new a(roomDatabase);
        this.c = new b(roomDatabase);
        this.d = new c(roomDatabase);
    }

    public static List f() {
        return Collections.EMPTY_LIST;
    }

    @Override // defpackage.th1
    public void a(IMUserBean iMUserBean) {
        this.a.d();
        this.a.e();
        try {
            this.b.i(iMUserBean);
            this.a.y();
        } finally {
            this.a.i();
        }
    }

    @Override // defpackage.th1
    public void b(List list) {
        this.a.e();
        try {
            super.b(list);
            this.a.y();
        } finally {
            this.a.i();
        }
    }

    @Override // defpackage.th1
    public void c(String str) {
        this.a.d();
        gy3 a2 = this.d.a();
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
            this.d.f(a2);
        }
    }

    @Override // defpackage.th1
    public IMUserBean d(String str) {
        ei3 ei3Var;
        IMUserBean iMUserBean;
        ei3 c2 = ei3.c("SELECT * FROM tb_user WHERE userId=?", 1);
        if (str == null) {
            c2.f0(1);
        } else {
            c2.d(1, str);
        }
        this.a.d();
        Cursor b2 = x80.b(this.a, c2, false, (CancellationSignal) null);
        try {
            int d = p80.d(b2, "id");
            int d2 = p80.d(b2, "userNiceName");
            int d3 = p80.d(b2, "avatar");
            int d4 = p80.d(b2, "sex");
            int d5 = p80.d(b2, "level");
            int d6 = p80.d(b2, "attent");
            int d7 = p80.d(b2, "otherAttent");
            int d8 = p80.d(b2, "anchorItem");
            int d9 = p80.d(b2, "tips");
            int d10 = p80.d(b2, "unReadCount");
            int d11 = p80.d(b2, "isGroup");
            int d12 = p80.d(b2, "conversationID");
            int d13 = p80.d(b2, "userID");
            int d14 = p80.d(b2, "groupID");
            ei3Var = c2;
            try {
                int d15 = p80.d(b2, "lastMsgId");
                int d16 = p80.d(b2, "lastMsgString");
                int d17 = p80.d(b2, "lastMsgTime");
                int d18 = p80.d(b2, "lastMsgTimeString");
                if (b2.moveToFirst()) {
                    iMUserBean = new IMUserBean(b2.isNull(d) ? null : b2.getString(d), b2.isNull(d2) ? null : b2.getString(d2), b2.isNull(d3) ? null : b2.getString(d3), b2.getInt(d4), b2.getInt(d5), b2.getInt(d6), b2.getInt(d7), b2.getInt(d8) != 0, b2.isNull(d9) ? null : b2.getString(d9), b2.getInt(d10), b2.getInt(d11) != 0, b2.isNull(d12) ? null : b2.getString(d12), b2.isNull(d13) ? null : b2.getString(d13), b2.isNull(d14) ? null : b2.getString(d14), b2.isNull(d15) ? null : b2.getString(d15), b2.isNull(d16) ? null : b2.getString(d16), b2.getLong(d17), b2.isNull(d18) ? null : b2.getString(d18));
                } else {
                    iMUserBean = null;
                }
                b2.close();
                ei3Var.T();
                return iMUserBean;
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

    @Override // defpackage.th1
    public void e(IMUserBean iMUserBean) {
        this.a.e();
        try {
            super.e(iMUserBean);
            this.a.y();
        } finally {
            this.a.i();
        }
    }

    @Override // defpackage.th1
    public List getAll() {
        ei3 ei3Var;
        int i;
        int i2;
        String string;
        int i3;
        int i4;
        String str;
        int i5;
        int i6;
        String str2;
        ei3 c2 = ei3.c("SELECT * FROM tb_user ORDER BY lastMsgTime DESC", 0);
        this.a.d();
        Cursor b2 = x80.b(this.a, c2, false, (CancellationSignal) null);
        try {
            int d = p80.d(b2, "id");
            int d2 = p80.d(b2, "userNiceName");
            int d3 = p80.d(b2, "avatar");
            int d4 = p80.d(b2, "sex");
            int d5 = p80.d(b2, "level");
            int d6 = p80.d(b2, "attent");
            int d7 = p80.d(b2, "otherAttent");
            int d8 = p80.d(b2, "anchorItem");
            int d9 = p80.d(b2, "tips");
            int d10 = p80.d(b2, "unReadCount");
            int d11 = p80.d(b2, "isGroup");
            int d12 = p80.d(b2, "conversationID");
            int d13 = p80.d(b2, "userID");
            int d14 = p80.d(b2, "groupID");
            ei3Var = c2;
            try {
                int d15 = p80.d(b2, "lastMsgId");
                int d16 = p80.d(b2, "lastMsgString");
                int d17 = p80.d(b2, "lastMsgTime");
                int d18 = p80.d(b2, "lastMsgTimeString");
                int i7 = d14;
                ArrayList arrayList = new ArrayList(b2.getCount());
                while (b2.moveToNext()) {
                    String string2 = b2.isNull(d) ? null : b2.getString(d);
                    String string3 = b2.isNull(d2) ? null : b2.getString(d2);
                    String string4 = b2.isNull(d3) ? null : b2.getString(d3);
                    int i8 = b2.getInt(d4);
                    int i9 = b2.getInt(d5);
                    int i10 = b2.getInt(d6);
                    int i11 = b2.getInt(d7);
                    boolean z = b2.getInt(d8) != 0;
                    String string5 = b2.isNull(d9) ? null : b2.getString(d9);
                    int i12 = b2.getInt(d10);
                    boolean z2 = b2.getInt(d11) != 0;
                    String string6 = b2.isNull(d12) ? null : b2.getString(d12);
                    String string7 = b2.isNull(d13) ? null : b2.getString(d13);
                    int i13 = i7;
                    if (b2.isNull(i13)) {
                        int i14 = d15;
                        i = d;
                        i2 = i14;
                        string = null;
                    } else {
                        int i15 = d15;
                        i = d;
                        i2 = i15;
                        string = b2.getString(i13);
                    }
                    if (b2.isNull(i2)) {
                        int i16 = d16;
                        i3 = i2;
                        i4 = i16;
                        str = null;
                    } else {
                        String string8 = b2.getString(i2);
                        int i17 = d16;
                        i3 = i2;
                        i4 = i17;
                        str = string8;
                    }
                    if (b2.isNull(i4)) {
                        int i18 = d17;
                        i5 = i4;
                        i6 = i18;
                        str2 = null;
                    } else {
                        String string9 = b2.getString(i4);
                        int i19 = d17;
                        i5 = i4;
                        i6 = i19;
                        str2 = string9;
                    }
                    long j = b2.getLong(i6);
                    int i20 = i6;
                    int i21 = d18;
                    d18 = i21;
                    arrayList.add(new IMUserBean(string2, string3, string4, i8, i9, i10, i11, z, string5, i12, z2, string6, string7, string, str, str2, j, b2.isNull(i21) ? null : b2.getString(i21)));
                    d = i;
                    d15 = i3;
                    d16 = i5;
                    d17 = i20;
                    i7 = i13;
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
