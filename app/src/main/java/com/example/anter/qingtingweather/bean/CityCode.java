package com.example.anter.qingtingweather.bean;

public class CityCode {
    public String province;
    public String districtcn;
    public String namecn;
    public String citycode;

    public CityCode(String province, String districtcn, String namecn, String citycode) {
        this.province = province;
        this.districtcn = districtcn;
        this.namecn = namecn;
        this.citycode = citycode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrictcn() {
        return districtcn;
    }

    public void setDistrictcn(String districtcn) {
        this.districtcn = districtcn;
    }

    public String getNamecn() {
        return namecn;
    }

    public void setNamecn(String namecn) {
        this.namecn = namecn;
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }
}
