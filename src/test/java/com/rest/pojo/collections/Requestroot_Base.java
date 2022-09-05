package com.rest.pojo.collections;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class Requestroot_Base {
    private String name;
//    Request request;
     public Requestroot_Base(){

     }
     //public Requestroot_Base(String name, Request request){
    public Requestroot_Base(String name){
         this.name=name;
//         this.request=request;
     }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



//    public Request getRequest() {
//        return request;
//    }
//
//    public void setRequest(Request request) {
//        this.request = request;
//    }

}
