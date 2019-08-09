package com.site.kido.kidding.utils;

import com.google.gson.Gson;

/**
 * @author chendianshu
 * @version 1.0
 * @created 2019-08-09.
 */
public class GSONUtil {

    private static final Gson gson = new Gson();

    public static String toJson(Object object) {
        return gson.toJson(object);
    }

    public <T> T fromJson(String json, Class<T> classOfT) {
        return gson.fromJson(json, classOfT);
    }

}
