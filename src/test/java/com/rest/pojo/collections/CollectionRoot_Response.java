package com.rest.pojo.collections;
public class CollectionRoot_Response extends CollectionRoot_Base{
    Collection_Response collections;
    // collections is another pojo class and collection is the json object of collectionroot
    public CollectionRoot_Response(){

    }
    public CollectionRoot_Response(Collection_Response collections){
        this.collections=collections;
    }
    public Collection_Response getCollections() {
        return collections;
    }

    public void setCollections(Collection_Response collections) {
        this.collections = collections;
    }
}
