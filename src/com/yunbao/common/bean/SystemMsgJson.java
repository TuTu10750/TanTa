package com.yunbao.common.bean;

/* loaded from: /tmp/classes2.dex */
public class SystemMsgJson {
    public Info data;
    public String system_view_type;

    /* loaded from: /tmp/classes2.dex */
    public static class Info {
        public String content;
        public int guard_nums;
        public int type;
        public User user;

        /* loaded from: /tmp/classes2.dex */
        public static class User {
            public String avatarUrl;
            public String level;
            public String userId;
            public String userName;
        }
    }
}
