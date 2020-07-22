package com.Pranav.Server.Model;




public class Data {

	
private long id;	
	private Integer value;
	private String key;
	public Integer getValue() {
		return value;
	}
	public void setValue(Integer value) {
		this.value = value;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	@Override
	public String toString() {
		return "Data [value=" + value + ", key=" + key + "]";
	}
	
	
	
	 
}