package com.rest.pojo.collections;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class CollectionRoot_Base {
    // collections is another pojo class and collection is the json object of collectionroot
    public CollectionRoot_Base(){

    }
}
