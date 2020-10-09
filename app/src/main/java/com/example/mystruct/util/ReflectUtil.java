package com.example.mystruct.util;

import java.lang.reflect.ParameterizedType;

/**
 * @author smart
 */
public class ReflectUtil {
    public static Object getT(Object o, int i){
        try {
            return ((Class)((ParameterizedType)(o.getClass().getGenericSuperclass())).getActualTypeArguments()[i]).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
