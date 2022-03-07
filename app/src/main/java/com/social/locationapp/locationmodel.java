package com.social.locationapp;

public class locationmodel {
    String distance,  name, addess_1,  address_2,  pincode,  mobile,telephone_1,telephone_2,comm_email,alt_email,website,reservation_link,place,image;

    public locationmodel(String distance, String name, String addess_1, String address_2, String pincode, String mobile, String telephone_1, String telephone_2, String comm_email, String alt_email, String website, String reservation_link, String place, String image) {
        this.distance = distance;
        this.name = name;
        this.addess_1 = addess_1;
        this.address_2 = address_2;
        this.pincode = pincode;
        this.mobile = mobile;
        this.telephone_1 = telephone_1;
        this.telephone_2 = telephone_2;
        this.comm_email = comm_email;
        this.alt_email = alt_email;
        this.website = website;
        this.reservation_link = reservation_link;
        this.place = place;
        this.image = image;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddess_1() {
        return addess_1;
    }

    public void setAddess_1(String addess_1) {
        this.addess_1 = addess_1;
    }

    public String getAddress_2() {
        return address_2;
    }

    public void setAddress_2(String address_2) {
        this.address_2 = address_2;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getTelephone_1() {
        return telephone_1;
    }

    public void setTelephone_1(String telephone_1) {
        this.telephone_1 = telephone_1;
    }

    public String getTelephone_2() {
        return telephone_2;
    }

    public void setTelephone_2(String telephone_2) {
        this.telephone_2 = telephone_2;
    }

    public String getComm_email() {
        return comm_email;
    }

    public void setComm_email(String comm_email) {
        this.comm_email = comm_email;
    }

    public String getAlt_email() {
        return alt_email;
    }

    public void setAlt_email(String alt_email) {
        this.alt_email = alt_email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getReservation_link() {
        return reservation_link;
    }

    public void setReservation_link(String reservation_link) {
        this.reservation_link = reservation_link;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
