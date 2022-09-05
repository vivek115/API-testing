package com.rest.pojo.collections;
public class CollectionRoot_Request extends CollectionRoot_Base{
    Collection_Request collections;
    // collections is another pojo class and collection is the json object of collectionroot
    public CollectionRoot_Request(){

    }
    public CollectionRoot_Request(Collection_Request collections){
        this.collections=collections;
    }
    public Collection_Base getCollections() {
        return collections;
    }

    public void setCollections(Collection_Request collections) {
        this.collections = collections;
    }
}
