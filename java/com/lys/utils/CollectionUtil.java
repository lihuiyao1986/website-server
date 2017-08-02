package com.lys.utils;

import java.util.List;
import java.util.Map;

/**
 * 集合操作工具类
 */
public class CollectionUtil {


    public static <T> boolean isEmpty(List<T> list) {
        boolean istrue = true;
        if (list != null && list.size() > 0) {
            istrue = false;
        }
        return istrue;
    }

    public static <T> boolean isEmpty(Map<T, Object> map) {
        boolean istrue = true;
        if (map != null && map.size() > 0) {
            istrue = false;
        }
        return istrue;
    }

    public static boolean isEmpty(Object[] obj){
        return null == obj || obj.length==0;
    }

}
