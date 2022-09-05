package com.rest.pojo.collections;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Requestroot_Response extends Requestroot_Base {
    //private String name;
//    Request_Base requestBase;
    Request_Response requestBase;

     public Requestroot_Response(){

     }
     public Requestroot_Response(String name, Request_Response requestBase){
        // this.name=name;
         super(name);
        this.requestBase = requestBase;
     }
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public Request_Base getRequestBase() {
        return requestBase;
    }

    public void setRequestBase(Request_Response requestBase) {
        this.requestBase = requestBase;
    }

}
