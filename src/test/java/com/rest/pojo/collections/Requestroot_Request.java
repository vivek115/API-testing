package com.rest.pojo.collections;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Requestroot_Request extends Requestroot_Base{
  //  private String name;
//    Request_Base requestBase;
  Request_Request requestBase;
     public Requestroot_Request(){

     }
     public Requestroot_Request(String name, Request_Request requestBase){
         //this.name=name;
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

    public void setRequestBase(Request_Request requestBase) {
        this.requestBase = requestBase;
    }

}
