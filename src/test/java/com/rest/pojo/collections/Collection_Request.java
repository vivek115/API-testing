package com.rest.pojo.collections;

import java.util.List;

public class Collection_Request extends Collection_Base {
//    Info info;
   // List<Folder_Base> item;
List<Folder_Request> item;

    public Collection_Request(){

    }
    public Collection_Request(Info info, List<Folder_Request> item){

//        this.info=info;
        // super is used to extracting the construtor of the base class
        super(info);
        this.item =item;
    }
//    public Info getInfo() {
//        return info;
//    }
//
//    public void setInfo(Info info) {
//        this.info = info;
//    }
//
    public List<Folder_Request> getItem() {
        return item;
    }
//
    public void setItem(List<Folder_Request> item) {
        this.item = item;
    }

}
