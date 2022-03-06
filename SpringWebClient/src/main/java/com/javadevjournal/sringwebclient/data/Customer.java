package com.javadevjournal.sringwebclient.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Customer {

	@JsonProperty("data")
	private Data data;

	@JsonProperty("support")
	private Support support;

	public Data getData(){
		return data;
	}

	public Support getSupport(){
		return support;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public void setSupport(Support support) {
		this.support = support;
	}
}