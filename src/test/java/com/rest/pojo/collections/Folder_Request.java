package com.rest.pojo.collections;

import java.util.List;

public class Folder_Request extends Folder_Base {
   // private String name;
    List<Requestroot_Base> item;
     public Folder_Request(){

     }
      public Folder_Request(String name, List<Requestroot_Base> item){
        // this.name=name;
        super(name);
         this.item = item;
      }

//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }

    public List<Requestroot_Base> getItem() {
        return item;
    }

    public void setItem(List<Requestroot_Base> item) {
        this.item = item;
    }
}
