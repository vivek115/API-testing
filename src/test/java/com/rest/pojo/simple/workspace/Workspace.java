package com.rest.pojo.simple.workspace;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;

//@JsonInclude(JsonInclude.Include.NON_NULL)
//@JsonInclude(JsonInclude.Include.NON_DEFAULT)
// DEFAULT VALUE FOR i is 0 and for id is null

// we can set json annotations at class level and field level
@JsonIgnoreProperties(value = "id",allowSetters = true)
// for multiple value we used curly bracket
//@JsonIgnoreProperties(value = {"id","i"},allowSetters = true)
public class Workspace {
   // @JsonInclude(JsonInclude.Include.NON_DEFAULT)
    @JsonIgnore
    private int i;
   // @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id;
   // @JsonInclude(JsonInclude.Include.NON_EMPTY)
   @JsonIgnore
    //it will ignore empty value for hashmap and it will work for list as well
    private HashMap<String,String> myhashmap;
    private String description;
    private String name;
    private String type;

    public Workspace(){

    }
    public Workspace(String name,String type,String description){
        this.name=name;
        this.type=type;
        this.description=description;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public HashMap<String, String> getMyhashmap() {
        return myhashmap;
    }

    public void setMyhashmap(HashMap<String, String> myhashmap) {
        this.myhashmap = myhashmap;
    }

    public void setId(String id) {
        this.id = id;
    }
    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
