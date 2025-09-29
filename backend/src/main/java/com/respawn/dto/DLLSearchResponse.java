package com.respawn.dto;
public class DLLSearchResponse { private String name; private String description; private Long downloadCount; public DLLSearchResponse(){} public DLLSearchResponse(String n,String d,Long c){this.name=n; this.description=d; this.downloadCount=c;} public String getName(){return name;} public void setName(String name){this.name=name;} public String getDescription(){return description;} public void setDescription(String description){this.description=description;} public Long getDownloadCount(){return downloadCount;} public void setDownloadCount(Long downloadCount){this.downloadCount=downloadCount;} }



