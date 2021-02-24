package com.xwc.demo.commons;

import java.util.ArrayList;
import java.util.List;

public class CollectionUtils {

    public static <T> T findFirst(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        } else {
            return list.get(0);
        }
    }

    public static <T> T findLast(List<T> list) {
        if (list == null || list.isEmpty()) {
            return null;
        } else {
            return list.get(list.size() - 1);
        }
    }

    public static <T> List<List<T>> split(List<T> list, int spiltLength) {
        List<List<T>> spiltList = new ArrayList<>();
        return spiltList;
    }
}
