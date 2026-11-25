package com.yunbao.im.dao;

import androidx.room.RoomDatabase;
import androidx.room.d;
import androidx.room.g;
import com.umeng.analytics.pro.cl;
import com.umeng.umcrash.UMCrash;
import defpackage.dy3$b;
import defpackage.qh1;
import defpackage.rh1;
import defpackage.th1;
import defpackage.ue2;
import defpackage.uh1;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /tmp/classes2.dex */
public final class AppDatabase_Impl extends AppDatabase {
    public volatile th1 q;
    public volatile qh1 r;

    /* loaded from: /tmp/classes2.dex */
    public class a extends g.a {
        public a(int i) {
            super(i);
        }

        public void a(cy3 cy3Var) {
            cy3Var.r("CREATE TABLE IF NOT EXISTS `tb_user` (`id` TEXT NOT NULL, `userNiceName` TEXT NOT NULL, `avatar` TEXT NOT NULL, `sex` INTEGER NOT NULL, `level` INTEGER NOT NULL, `attent` INTEGER NOT NULL, `otherAttent` INTEGER NOT NULL, `anchorItem` INTEGER NOT NULL, `tips` TEXT NOT NULL, `unReadCount` INTEGER NOT NULL, `isGroup` INTEGER NOT NULL, `conversationID` TEXT, `userID` TEXT NOT NULL, `groupID` TEXT, `lastMsgId` TEXT NOT NULL, `lastMsgString` TEXT NOT NULL, `lastMsgTime` INTEGER NOT NULL, `lastMsgTimeString` TEXT, PRIMARY KEY(`id`))");
            cy3Var.r("CREATE UNIQUE INDEX IF NOT EXISTS `index_tb_user_id` ON `tb_user` (`id`)");
            cy3Var.r("CREATE TABLE IF NOT EXISTS `tb_msg` (`msgId` TEXT NOT NULL, `userId` TEXT NOT NULL, `senderId` TEXT, `groupId` TEXT, `timestamp` INTEGER NOT NULL, `self` INTEGER NOT NULL, `type` INTEGER NOT NULL, `status` INTEGER NOT NULL, `revoked` INTEGER NOT NULL, `showTimeString` TEXT, `text` TEXT NOT NULL, `localPath` TEXT NOT NULL, `originImageUrl` TEXT NOT NULL, `thumbImageUrl` TEXT NOT NULL, `width` INTEGER NOT NULL, `height` INTEGER NOT NULL, `duration` INTEGER NOT NULL, PRIMARY KEY(`msgId`))");
            cy3Var.r("CREATE UNIQUE INDEX IF NOT EXISTS `index_tb_msg_msgId` ON `tb_msg` (`msgId`)");
            cy3Var.r("CREATE TABLE IF NOT EXISTS room_master_table (id INTEGER PRIMARY KEY,identity_hash TEXT)");
            cy3Var.r("INSERT OR REPLACE INTO room_master_table (id,identity_hash) VALUES(42, '1522c6fdf29984c8026375f065515696')");
        }

        public void b(cy3 cy3Var) {
            cy3Var.r("DROP TABLE IF EXISTS `tb_user`");
            cy3Var.r("DROP TABLE IF EXISTS `tb_msg`");
            if (((RoomDatabase) AppDatabase_Impl.this).h == null || ((RoomDatabase) AppDatabase_Impl.this).h.size() <= 0) {
                return;
            }
            ue2.a(((RoomDatabase) AppDatabase_Impl.this).h.get(0));
            throw null;
        }

        public void c(cy3 cy3Var) {
            if (((RoomDatabase) AppDatabase_Impl.this).h == null || ((RoomDatabase) AppDatabase_Impl.this).h.size() <= 0) {
                return;
            }
            ue2.a(((RoomDatabase) AppDatabase_Impl.this).h.get(0));
            throw null;
        }

        public void d(cy3 cy3Var) {
            ((RoomDatabase) AppDatabase_Impl.this).a = cy3Var;
            AppDatabase_Impl.this.t(cy3Var);
            if (((RoomDatabase) AppDatabase_Impl.this).h == null || ((RoomDatabase) AppDatabase_Impl.this).h.size() <= 0) {
                return;
            }
            ue2.a(((RoomDatabase) AppDatabase_Impl.this).h.get(0));
            throw null;
        }

        public void e(cy3 cy3Var) {
        }

        public void f(cy3 cy3Var) {
            x80.a(cy3Var);
        }

        public g.b g(cy3 cy3Var) {
            HashMap hashMap = new HashMap(18);
            hashMap.put("id", new a("id", "TEXT", true, 1, (String) null, 1));
            hashMap.put("userNiceName", new a("userNiceName", "TEXT", true, 0, (String) null, 1));
            hashMap.put("avatar", new a("avatar", "TEXT", true, 0, (String) null, 1));
            hashMap.put("sex", new a("sex", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("level", new a("level", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("attent", new a("attent", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("otherAttent", new a("otherAttent", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("anchorItem", new a("anchorItem", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("tips", new a("tips", "TEXT", true, 0, (String) null, 1));
            hashMap.put("unReadCount", new a("unReadCount", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("isGroup", new a("isGroup", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("conversationID", new a("conversationID", "TEXT", false, 0, (String) null, 1));
            hashMap.put("userID", new a("userID", "TEXT", true, 0, (String) null, 1));
            hashMap.put("groupID", new a("groupID", "TEXT", false, 0, (String) null, 1));
            hashMap.put("lastMsgId", new a("lastMsgId", "TEXT", true, 0, (String) null, 1));
            hashMap.put("lastMsgString", new a("lastMsgString", "TEXT", true, 0, (String) null, 1));
            hashMap.put("lastMsgTime", new a("lastMsgTime", "INTEGER", true, 0, (String) null, 1));
            hashMap.put("lastMsgTimeString", new a("lastMsgTimeString", "TEXT", false, 0, (String) null, 1));
            HashSet hashSet = new HashSet(0);
            HashSet hashSet2 = new HashSet(1);
            hashSet2.add(new d("index_tb_user_id", true, Arrays.asList("id"), Arrays.asList("ASC")));
            t14 t14Var = new t14("tb_user", hashMap, hashSet, hashSet2);
            t14 a = t14.a(cy3Var, "tb_user");
            if (!t14Var.equals(a)) {
                return new g.b(false, "tb_user(com.yunbao.im.dao.IMUserBean).\n Expected:\n" + t14Var + "\n Found:\n" + a);
            }
            HashMap hashMap2 = new HashMap(17);
            hashMap2.put("msgId", new a("msgId", "TEXT", true, 1, (String) null, 1));
            hashMap2.put("userId", new a("userId", "TEXT", true, 0, (String) null, 1));
            hashMap2.put("senderId", new a("senderId", "TEXT", false, 0, (String) null, 1));
            hashMap2.put("groupId", new a("groupId", "TEXT", false, 0, (String) null, 1));
            hashMap2.put(UMCrash.SP_KEY_TIMESTAMP, new a(UMCrash.SP_KEY_TIMESTAMP, "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("self", new a("self", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("type", new a("type", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put(cl.i, new a(cl.i, "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("revoked", new a("revoked", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("showTimeString", new a("showTimeString", "TEXT", false, 0, (String) null, 1));
            hashMap2.put("text", new a("text", "TEXT", true, 0, (String) null, 1));
            hashMap2.put("localPath", new a("localPath", "TEXT", true, 0, (String) null, 1));
            hashMap2.put("originImageUrl", new a("originImageUrl", "TEXT", true, 0, (String) null, 1));
            hashMap2.put("thumbImageUrl", new a("thumbImageUrl", "TEXT", true, 0, (String) null, 1));
            hashMap2.put("width", new a("width", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("height", new a("height", "INTEGER", true, 0, (String) null, 1));
            hashMap2.put("duration", new a("duration", "INTEGER", true, 0, (String) null, 1));
            HashSet hashSet3 = new HashSet(0);
            HashSet hashSet4 = new HashSet(1);
            hashSet4.add(new d("index_tb_msg_msgId", true, Arrays.asList("msgId"), Arrays.asList("ASC")));
            t14 t14Var2 = new t14("tb_msg", hashMap2, hashSet3, hashSet4);
            t14 a2 = t14.a(cy3Var, "tb_msg");
            if (t14Var2.equals(a2)) {
                return new g.b(true, (String) null);
            }
            return new g.b(false, "tb_msg(com.yunbao.im.dao.IMMessageBean).\n Expected:\n" + t14Var2 + "\n Found:\n" + a2);
        }
    }

    @Override // com.yunbao.im.dao.AppDatabase
    public qh1 C() {
        qh1 qh1Var;
        if (this.r != null) {
            return this.r;
        }
        synchronized (this) {
            try {
                if (this.r == null) {
                    this.r = new rh1(this);
                }
                qh1Var = this.r;
            } catch (Throwable th) {
                throw th;
            }
        }
        return qh1Var;
    }

    @Override // com.yunbao.im.dao.AppDatabase
    public th1 D() {
        th1 th1Var;
        if (this.q != null) {
            return this.q;
        }
        synchronized (this) {
            try {
                if (this.q == null) {
                    this.q = new uh1(this);
                }
                th1Var = this.q;
            } catch (Throwable th) {
                throw th;
            }
        }
        return th1Var;
    }

    public d g() {
        return new d(this, new HashMap(0), new HashMap(0), new String[]{"tb_user", "tb_msg"});
    }

    public dy3 h(androidx.room.a aVar) {
        return aVar.a.a(dy3$b.a(aVar.b).c(aVar.c).b(new g(aVar, new a(1), "1522c6fdf29984c8026375f065515696", "d5d0ed3ba7afb7c4ad76c904dce45a20")).a());
    }

    public List j(Map map) {
        return Arrays.asList(new sl2[0]);
    }

    public Set n() {
        return new HashSet();
    }

    public Map o() {
        HashMap hashMap = new HashMap();
        hashMap.put(th1.class, uh1.f());
        hashMap.put(qh1.class, rh1.g());
        return hashMap;
    }
}
