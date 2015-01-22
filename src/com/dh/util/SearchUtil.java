// Search Engine Demo for DHGate.com 
// Author: Shen Jiyi  shenjiyi@dhgate.com
// 2015.1.19

package com.dh.util;

import com.alibaba.fastjson.JSONObject;
import java.util.*;
import java.io.*;

public class SearchUtil {

	public static final String baseUrl="http://54.164.174.84/piclight/query?json=";
	public static String getSearchStr(String picurl,Integer type) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("url", picurl);
		jsonObject.put("action", "query");
		jsonObject.put("rows", 20);
		jsonObject.put("feature", type);
		return jsonObject.toJSONString();
	}
	public static String getSearchStr2(String picurl,Integer type) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("id", picurl);
		jsonObject.put("action", "query");
		jsonObject.put("rows", 20);
		jsonObject.put("feature", type);
		return jsonObject.toJSONString();
	}	
}
