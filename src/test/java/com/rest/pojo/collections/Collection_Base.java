package com.rest.pojo.collections;

import java.util.List;

public  abstract class Collection_Base {
    Info info;


    public Collection_Base(){

    }
    public Collection_Base(Info info)//List<Folder> item)
    {
       this.info=info;
//        this.item =item;
   }
    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
//
//    public List<Folder> getItem() {
//        return item;
//    }
//
//    public void setItem(List<Folder> item) {
//        this.item = item;
//    }

}
