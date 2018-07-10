/**  
 * @Title: BeanUtil.java
 * @Package net.platform.utils
 * @author linyiting
 * @date 2018年3月12日
 * @Description: TODO
 */
package net.platform.utils;

/**
 * @Title: BeanUtil.java
 * @Package net.platform.utils
 * @ClassName: BeanUtil 
 * @author linyiting
 * @date 2018年3月12日
 * @Description: TODO
 */

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * BeanUtils.populate方法的限制：<br>
 * The class must be public, and provide a public constructor that accepts no
 * arguments. <br>
 * This allows tools and applications to dynamically create new instances of
 * your bean, <br>
 * without necessarily knowing what Java class name will be used ahead of time
 */
public class BeanUtils {

	public static void main(String[] args) {
//
//		SuplSample person = new SuplSample();
//		Map<String, Object> mp = new HashMap<String, Object>();
//		mp.put("id", 1);
//		mp.put("companyType","male" );
//		mp.put("standardNum", 25);
//
//		// 将map转换为bean
//		transMap2Bean(mp, person);
//
//		System.out.println("--- transMap2Bean Map Info: ");
//		for (Map.Entry<String, Object> entry : mp.entrySet()) {
//			System.out.println(entry.getKey() + ": " + entry.getValue());
//		}
//
//		System.out.println("--- Bean Info: ");
//		System.out.println("id: " + person.getId());
//		System.out.println("companyType: " + person.getCompanyType());
//		System.out.println("standardNum: " + person.getStandardNum());
//
//		// 将javaBean 转换为map
//		Map<String, Object> map = transBean2Map(person);
//
//		System.out.println("--- transBean2Map Map Info: ");
//		for (Map.Entry<String, Object> entry : map.entrySet()) {
//			System.out.println(entry.getKey() + ": " + entry.getValue());
//		}

	}

	// Map --> Bean 1: 利用Introspector,PropertyDescriptor实现 Map --> Bean
	public static void transMap2Bean(Map<String, Object> map, Object obj) {

		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo
					.getPropertyDescriptors();

			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();

				if (map.containsKey(key)) {
					Object value = map.get(key);
					// 得到property对应的setter方法
					Method setter = property.getWriteMethod();
					setter.invoke(obj, value);
				}

			}

		} catch (Exception e) {
			System.out.println("transMap2Bean Error " + e);
		}

		return;

	}

	// Bean --> Map 1: 利用Introspector和PropertyDescriptor 将Bean --> Map
	public static Map<String, Object> transBean2Map(Object obj) {

		if (obj == null) {
			return null;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo
					.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();

				// 过滤class属性
				if (!key.equals("class")) {
					// 得到property对应的getter方法
					Method getter = property.getReadMethod();
					Object value = getter.invoke(obj);

					map.put(key, value);
				}

			}
		} catch (Exception e) {
			System.out.println("transBean2Map Error " + e);
		}

		return map;

	}
	public static Map<String, String> transBean2StrMap(Object obj) {

		if (obj == null) {
			return null;
		}
		Map<String, String> map = new HashMap<String, String>();
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
			PropertyDescriptor[] propertyDescriptors = beanInfo
					.getPropertyDescriptors();
			for (PropertyDescriptor property : propertyDescriptors) {
				String key = property.getName();
                //System.out.println(key);
				// 过滤class属性
				if (!key.equals("class")) {
					// 得到property对应的getter方法
					Method getter = property.getReadMethod();
					Object value = getter.invoke(obj);

					map.put(key, value.toString());
				}

			}
		} catch (Exception e) {
			System.out.println("transBean2StrMap Error " + e.getMessage());
		}

		return map;

	}
}