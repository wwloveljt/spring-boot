package com.zhanhongit.model;

import java.util.ArrayList;
import java.util.List;


public class JsonValue {
	private String name;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName_id() {
		return name_id;
	}

	public void setName_id(String name_id) {
		this.name_id = name_id;
	}

	private String name_id;
	
	public JsonValue(String name, String name_id) {
		this.name = name;
		this.name_id= name_id;
	}
	
	public static List<JsonValue> getJsonValues(List<String> val){
		List<JsonValue> values = new ArrayList<JsonValue>();
		
		for (int j = 0; j < val.size(); j++) {
			JsonValue jValue = new JsonValue(val.get(j), val.get(j));
			values.add(jValue);
		}
		
		return values;
	}

	

	
}
