package com.rest.pojo.collections;

import java.util.List;

public class Folder_Response extends Folder_Base{
   // private String name;
//    List<Requestroot_Base> item;
   List<Requestroot_Response> item;
     public Folder_Response(){

     }
      public Folder_Response(String name, List<Requestroot_Response> item){
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

    public List<Requestroot_Response> getItem() {
        return item;
    }

    public void setItem(List<Requestroot_Response> item) {
        this.item = item;
    }
}
