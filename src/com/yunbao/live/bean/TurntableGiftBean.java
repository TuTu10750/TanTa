package com.yunbao.live.bean;

/* loaded from: /tmp/classes2.dex */
public class TurntableGiftBean {
    private String id;
    private String name;
    private int nums;
    private String thumb;
    private int type;
    private String type_val;

    public boolean equals(Object obj) {
        try {
            if (obj instanceof TurntableGiftBean) {
                return this.id.equals(((TurntableGiftBean) obj).id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this == obj;
    }

    public String getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public int getNums() {
        return this.nums;
    }

    public String getThumb() {
        return this.thumb;
    }

    public int getType() {
        return this.type;
    }

    public String getType_val() {
        return this.type_val;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setNums(int i) {
        this.nums = i;
    }

    public void setThumb(String str) {
        this.thumb = str;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setType_val(String str) {
        this.type_val = str;
    }
}
