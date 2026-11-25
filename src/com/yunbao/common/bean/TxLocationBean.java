package com.yunbao.common.bean;

import java.util.List;

/* loaded from: /tmp/classes2.dex */
public class TxLocationBean {
    private String address;
    private String city;
    private String district;
    private double lat;
    private double lng;
    private String nation;
    private List<TxLocationPoiBean> poiList;
    private String province;
    private String street;

    public String getAddress() {
        return this.address;
    }

    public String getCity() {
        return this.city;
    }

    public String getDistrict() {
        return this.district;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLng() {
        return this.lng;
    }

    public String getNation() {
        return this.nation;
    }

    public List<TxLocationPoiBean> getPoiList() {
        return this.poiList;
    }

    public String getProvince() {
        return this.province;
    }

    public String getStreet() {
        return this.street;
    }

    public void setAddress(String str) {
        this.address = str;
    }

    public void setCity(String str) {
        this.city = str;
    }

    public void setDistrict(String str) {
        this.district = str;
    }

    public void setLat(double d) {
        this.lat = d;
    }

    public void setLng(double d) {
        this.lng = d;
    }

    public void setNation(String str) {
        this.nation = str;
    }

    public void setPoiList(List<TxLocationPoiBean> list) {
        this.poiList = list;
    }

    public void setProvince(String str) {
        this.province = str;
    }

    public void setStreet(String str) {
        this.street = str;
    }
}
