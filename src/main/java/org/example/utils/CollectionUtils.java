package org.example.utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionUtils {

    public static <T> Set<T> buildConcatSet(Set<T> set1, Set<T> set2) {
        Set<T> newSet = new HashSet<>();
        newSet.addAll(set1);
        newSet.addAll(set2);
        return newSet;
    }

    public static <T> List<T> buildConcatList(List<T> set1, List<T> set2) {
        List<T> newList = new ArrayList<>();
        newList.addAll(set1);
        newList.addAll(set2);
        return newList;
    }

    public static <T> List<T> allButFirst(List<T> currentList) {
        return currentList.isEmpty() ? currentList : currentList.subList(1, currentList.size());
    }
}
