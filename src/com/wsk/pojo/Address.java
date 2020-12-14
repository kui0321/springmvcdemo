package com.wsk.pojo;

public class Address {
    private String phonenumber;
    private String postcode;

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    @Override
    public String toString() {
        return "Address{" +
                "phonenumber='" + phonenumber + '\'' +
                ", postcode='" + postcode + '\'' +
                '}';
    }
}
