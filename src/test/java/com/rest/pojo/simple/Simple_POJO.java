package com.rest.pojo.simple;

public class Simple_POJO {
    // now create a parameterize constructor for this class
    public Simple_POJO(String key1,String key2){
        this.key1=key1;
        this.key2=key2;
    }
    public String getKey1() {
        return key1;
    }

    public void setKey1(String key1) {
        this.key1 = key1;
    }

    public String getKey2() {
        return key2;
    }

    public void setKey2(String key2) {
        this.key2 = key2;
    }

    // firstly we have to create variable of payload
    private String key1;
    private String key2;
    // second you have to create  getter and setter methods for both the variables

}
