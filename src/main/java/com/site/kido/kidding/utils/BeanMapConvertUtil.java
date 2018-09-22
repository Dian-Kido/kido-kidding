package com.site.kido.kidding.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2018/9/21.
 */
public class BeanMapConvertUtil {
    private static final Logger logger = LoggerFactory.getLogger(BeanMapConvertUtil.class);

    // Bean --> Map 1: 利用Introspector和PropertyDescriptor 将Bean --> Map
    public static Map<String, Object> transBean2Map(Object obj) {

        if (obj == null) {
            return null;
        }
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : propertyDescriptors) {
                String key = property.getName();
                // 得到property对应的getter方法
                Method getter = property.getReadMethod();
                Object value = getter.invoke(obj);
                map.put(key, value);
            }
            // 过滤serialVersionUID、class属性
            if (map.containsKey("serialVersionUID")) {
                map.remove("serialVersionUID");
            }
            if (map.containsKey("class")) {
                map.remove("class");
            }
        } catch (Exception e) {
            logger.error("transBean2Map Error ", e);
        }

        return map;

    }

    // Map --> Bean 1: 利用Introspector,PropertyDescriptor实现 Map --> Bean
    public static void transMap2Bean(Map<String, Object> map, Object obj) {

        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();

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
            logger.error("transMap2Bean Error ", e);
        }

        return;

    }

}
