package com.rest.pojo.collections;

public class Body {
    private String mode;
    private String raw;
    public Body(){

    }
    public Body(String mode,String raw){
        this.raw=raw;
        this.mode=mode;
    }
    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }
}
