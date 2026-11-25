package com.yunbao.common.bean;

/* loaded from: /tmp/classes2.dex */
public class TxLocationPoiBean {
    private String _dir_desc;
    private double _distance;
    private String address;
    private String category;
    private boolean checked;
    private String id;
    private Location location;
    private String title;

    /* loaded from: /tmp/classes2.dex */
    public class Location {
        private double lat;
        private double lng;

        public Location() {
        }

        public double getLat() {
            return this.lat;
        }

        public double getLng() {
            return this.lng;
        }

        public void setLat(double d) {
            this.lat = d;
        }

        public void setLng(double d) {
            this.lng = d;
        }
    }

    public String getAddress() {
        return this.address;
    }

    public String getCategory() {
        return this.category;
    }

    public String getId() {
        return this.id;
    }

    public Location getLocation() {
        return this.location;
    }

    public String getTitle() {
        return this.title;
    }

    public String get_dir_desc() {
        return this._dir_desc;
    }

    public double get_distance() {
        return this._distance;
    }

    public boolean isChecked() {
        return this.checked;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public void setChecked(boolean z) {
        this.checked = z;
    }

    public void setId(String str) {
        this.id = str;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public void set_dir_desc(String str) {
        this._dir_desc = str;
    }

    public void set_distance(double d) {
        this._distance = d;
    }
}
