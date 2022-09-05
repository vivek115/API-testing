package com.rest.pojo.collections;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class Info {
    private String name;
    private String description;
    private String schema;
   @JsonIgnoreProperties(ignoreUnknown = true)
    public Info(){

    }
    public Info(String name,String description,String schema ){
        this.name=name;
        this.description=description;
        this.schema=schema;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSchema() {
        return schema;
    }

    public void setSchema(String schema) {
        this.schema = schema;
    }
}
