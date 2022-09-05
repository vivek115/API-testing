package com.rest.pojo.collections;

import java.util.List;

public abstract class Folder_Base {
    private String name;
    //List<Requestroot> item;
     public Folder_Base(){

     }
      //public Folder_Base(String name, List<Requestroot> item){
      public Folder_Base(String name){
         this.name=name;
        // this.item = item;
      }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public List<Requestroot> getItem() {
//        return item;
//    }
//
//    public void setItem(List<Requestroot> item) {
//        this.item = item;
//    }
}
