package com.javadevjournal.repolister.model;

public class Repo {
    private String id;
    private String name;
    private String full_name;
    private String html_url;
    private String description;
    
    
	public Repo() {
	}
	public Repo(String id, String name, String full_name, String html_url, String description) {
		this.id = id;
		this.name = name;
		this.full_name = full_name;
		this.html_url = html_url;
		this.description = description;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getHtml_url() {
		return html_url;
	}
	public void setHtml_url(String html_url) {
		this.html_url = html_url;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
