package com.maheshrestassured;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class ParseDynamicJsonUtility {

	public static void parseObject(JSONObject json, String key) {
		//System.out.println(json.has(key));
		System.out.println(json.get(key));

	}


	public static void getKey(JSONObject json, String key) {
		boolean exists=json.has(key);
		Iterator<?> keys;
		String nextKeys;



		if(!exists) {
			keys=json.keys();
			while(keys.hasNext()) {
				nextKeys=(String)keys.next();
				try {
					if(json.get(nextKeys) instanceof JSONObject) {
						if(exists == false) {
							getKey(json.getJSONObject(nextKeys), key); //recurssive call
						}

					}else if(json.get(nextKeys) instanceof JSONArray) {
						JSONArray jsonarray=json.getJSONArray(nextKeys);
						for(int i=0; i<jsonarray.length(); i++) {
							String jsonArrayString=jsonarray.get(i).toString();
							JSONObject innerJson=new JSONObject(jsonArrayString); 

							if(exists == false) {
								getKey(innerJson, key); // recurssive call
							}
						}
					}
				}catch(Exception e) {

				}
			}

		}else {
			parseObject(json, key);
		}
	}

	public static void main(String[] args) {
		String inputJson="{\r\n"
				+ "  \"myObjects\": [\r\n"
				+ "    {\r\n"
				+ "      \"code\": \"JM\",\r\n"
				+ "      \"another_objects\": [\r\n"
				+ "        {\r\n"
				+ "          \"attribute1\": \"value1\",\r\n"
				+ "          \r\n"
				+ "          \"attribute2\": \"value2\",\r\n"
				+ "          \"attribute3\": \"value3\",\r\n"
				+ "          \"attribute4\": \"value4\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"attribute1\": \"value1\",\r\n"
				+ "          \"attribute2\": \"value2\",\r\n"
				+ "          \"attribute3\": \"value3\",\r\n"
				+ "          \"attribute4\": \"value4\",\r\n"
				+ "          \"another_objects1\": [\r\n"
				+ "        {\r\n"
				+ "          \"attribute11\": \"value11\",\r\n"
				+ "          \"attribute21\": \"value22\",\r\n"
				+ "          \"attribute31\": \"value33\",\r\n"
				+ "          \"attribute41\": \"value44\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"attribute11\": \"value11\",\r\n"
				+ "          \"attribute21\": \"value22\",\r\n"
				+ "          \"attribute31\": \"value33\",\r\n"
				+ "          \"attribute41\": \"value44\"\r\n"
				+ "        }\r\n"
				+ "      ]\r\n"
				+ "        }\r\n"
				+ "      ],\r\n"
				+ "      \"another_objects22\": [\r\n"
				+ "        {\r\n"
				+ "          \"attribute1\": \"value1\",\r\n"
				+ "          \r\n"
				+ "          \"attribute2\": \"value2\",\r\n"
				+ "          \"attribute3\": \"value3\",\r\n"
				+ "          \"attribute4\": \"value4\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"attribute1\": \"value1\",\r\n"
				+ "          \"attribute2\": \"value2\",\r\n"
				+ "          \"attribute3\": \"value3\",\r\n"
				+ "          \"attribute4\": \"value4\",\r\n"
				+ "          \"another_objects1\": [\r\n"
				+ "        {\r\n"
				+ "          \"attribute11\": \"value11\",\r\n"
				+ "          \"attribute21\": \"value22\",\r\n"
				+ "          \"attribute31\": \"value33\",\r\n"
				+ "          \"attribute41\": \"value44\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "          \"attribute11\": \"value11\",\r\n"
				+ "          \"attribute21\": \"value22\",\r\n"
				+ "          \"attribute31\": \"value33\",\r\n"
				+ "          \"attribute41\": \"value44\"\r\n"
				+ "        }\r\n"
				+ "      ]\r\n"
				+ "        }\r\n"
				+ "      ]\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "  \r\n"
				+ "}";
				

		JSONObject inputJSONObject=new JSONObject(inputJson);

		getKey(inputJSONObject, "code");
		getKey(inputJSONObject, "attribute1");
		getKey(inputJSONObject, "attribute3");
		getKey(inputJSONObject, "attribute4");
		getKey(inputJSONObject, "attribute41");

 


	}

}
