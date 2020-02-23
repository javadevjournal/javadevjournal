package com.javadevjournal.data;

import org.springframework.core.io.Resource;

public class FileMetaData {

    private String fileName;
    private String url;
    private String mime;
    private long size;
    private Resource resource;

    public FileMetaData() {
    }

    public FileMetaData(String fileName, String url, String mime, long size) {
        this.fileName = fileName;
        this.url = url;
        this.mime = mime;
        this.size = size;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getMime() {
        return mime;
    }

    public void setMime(String mime) {
        this.mime = mime;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public Resource getResource() {
        return resource;
    }

    public void setResource(Resource resource) {
        this.resource = resource;
    }
}
