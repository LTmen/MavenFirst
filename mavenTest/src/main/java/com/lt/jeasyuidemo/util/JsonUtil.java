package com.lt.jeasyuidemo.util;

import java.lang.reflect.Type;

import com.google.gson.Gson;

public final class JsonUtil {
	public static String toJson(Object obj){
		Gson gson = new Gson();
		return 	gson.toJson(obj);
	}
	public static<T> T fromJson(String str,Type type){
		Gson gson = new Gson();
		return gson.fromJson(str, type);
	}
	public static<T> T fromJson(String str,Class<T> type){
		Gson gson = new Gson();
		return gson.fromJson(str, type);
	}
	
}

