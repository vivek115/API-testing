package com.rest.pojo.collections;
import java.util.List;

public class Request_Response extends Request_Base {
    URL url;
   //private String url;
//    private String method;
//    List<Header> headerList;
//    Body body;
//    private String description;

    public Request_Response(){

    }
   // public Request(String url,String method,List<Header> headerList,Body body,String description){
   public Request_Response(URL url,String method, List<Header> headerList, Body body, String description){
        super();
        this.url=url;
//        this.method=method;
//        this.headerList=headerList;
//        this.body=body;
//        this.description=description;
    }
    public URL getUrl() {
        return url;
    }

    public void setUrl(URL url) {
        this.url = url;
    }

//    public String getMethod() {
//        return method;
//    }
//
//    public void setMethod(String method) {
//        this.method = method;
//    }
//
//    public List<Header> getHeaderList() {
//        return headerList;
//    }
//
//    public void setHeaderList(List<Header> headerList) {
//        this.headerList = headerList;
//    }
//
//    public Body getBody() {
//        return body;
//    }
//
//    public void setBody(Body body) {
//        this.body = body;
//    }
//
//    public String getDescription() {
//        return description;
//    }
//
//    public void setDescription(String description) {
//        this.description = description;
//    }
}