package com.naveen.transformation;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.google.common.collect.ImmutableMap;

public class TransformationUtils {
	public static ImmutableMap<String, Object> map = ImmutableMap.of("name", "c_name", "email", "c_email");

	public static void main(String args[]) {
		System.out.println("--------" + map.size());
		Map<String, Object> hm = new HashMap<>();
		hm.put("name", "xxx");
		hm.put("email", "xxx@xxx.com");
		dataTransformation(hm, map);
	}

	private static Map<String, Object> dataTransformation(Map<String, Object> hm, ImmutableMap<String, Object> map2) {
		// TODO Auto-generated method stub
		if (hm.size() == map2.size()) {
			ConcurrentHashMap<String, Object> chm = new ConcurrentHashMap<>(hm);
			Set<Entry<String, Object>> keys = chm.entrySet();
			for (Entry<String, Object> object : keys) {
				String key = object.getKey();
				hm.put((String) map2.get(key), object.getValue());
				hm.remove(key);
			}
		}
		return hm;

	}
}
