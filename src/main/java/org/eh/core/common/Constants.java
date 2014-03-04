package org.eh.core.common;

import java.util.HashMap;
import java.util.Map;

import org.eh.core.util.PropertyUtil;

/**
 *
 * @author guojing
 * @date 2014-3-3
 */
public class Constants {
	public static String PROPERTIES_NAME = "web.properties"; // 配置文件名
	public static String PACKAGE_PREFIX = "org.eh.web."; // 包前缀
	public static String VIEW_BASE_PATH = "org/eh/web/view/"; // view包路径

	public static Map<String, String> UrlClassMap = new HashMap<String, String>(); // url与class映射

	public static void loadFromProp(String path) {
		Map<String, String> map = new HashMap<String, String>();
		try {
			map = PropertyUtil.analysisProperties(path);
		} catch (Exception e) {
			System.out.println("配置文件不存在！");
		}

		for (String key : map.keySet()) {
			if (key.equals("PACKAGE_PREFIX")) {
				PACKAGE_PREFIX = map.get(key).toString();
			} else if (key.equals("VIEW_BASE_PATH")) {
				VIEW_BASE_PATH = map.get(key).toString();
			} else if (key.startsWith("url")) {
				UrlClassMap.put(key.replace("url", ""), map.get(key).toString());
			}
		}
	}
}
