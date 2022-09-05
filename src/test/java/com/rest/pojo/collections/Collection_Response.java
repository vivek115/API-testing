package com.rest.pojo.collections;

import java.util.List;

public abstract class Collection_Response extends Collection_Base {
//    Info info;
    List<Folder_Base> item;

    public Collection_Response(){

    }
    public Collection_Response(Info info, List<Folder_Base> item){
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
    public List<Folder_Base> getItem() {
        return item;
    }
//
    public void setItem(List<Folder_Base> item) {
        this.item = item;
    }

}
