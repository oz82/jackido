package jackido.collection;

import java.util.*;

public class JDMap {
    // adapted from https://stackoverflow.com/questions/59136811/how-to-sort-a-hashmap-if-both-have-same-key
    public static LinkedHashMap sortByValues(HashMap map, boolean sortMode) {
        List list = new LinkedList(map.entrySet());
        // Defined Custom Comparator here
        if (sortMode) {
            Collections.sort(list, new Comparator() {
                public int compare(Object o1, Object o2) {
                    return ((Comparable) ((Map.Entry) (o1)).getValue())
                            .compareTo(((Map.Entry) (o2)).getValue());
                }
            });
        } else {
            Collections.sort(list, new Comparator() {
                public int compare(Object o1, Object o2) {
                    return ((Comparable) ((Map.Entry) (o2)).getValue())
                            .compareTo(((Map.Entry) (o1)).getValue());
                }
            });
        }

        LinkedHashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }

    public static LinkedHashMap sortByValues(HashMap map) {
        return sortByValues(map, false);
    }

    public static void add1(HashMap<String, Integer> map, String s, int f) {
        Integer freq = map.get(s);
        if (freq == null) {
            freq = 0;
        }
        if (f == 0) {
            map.put(s, ++freq);
        } else if (f < 0) {
            map.put(s, freq + (-f));
        } else {
            map.put(s, f);
        }
    }

    public static void addMap1(HashMap<String, Integer> map, String s) {
        Integer freq = map.get(s);
        if (freq == null) {
            freq = 0;
        }
        map.put(s, ++freq);
    }

    public static void add1(HashMap<Integer, Integer> map, Integer s, int f) {
        Integer freq = map.get(s);
        if (freq == null) {
            freq = 0;
        }
        if (f == 0) {
            map.put(s, ++freq);
        } else if (f < 0) {
            map.put(s, freq + (-f));
        } else {
            map.put(s, f);
        }
    }

    public static void add2(HashMap<String, HashMap<String, Integer>> map, String s1, String s2) {
        HashMap<String, Integer> innerMap = map.get(s1);
        if (innerMap == null) {
            innerMap = new HashMap<>();
            innerMap.put(s2, 1);
        } else {
            Integer freq;
            freq = innerMap.get(s2);
            if (freq == null)
                freq = 0;
            innerMap.put(s2, ++freq);
        }
        map.put(s1, innerMap);
    }

    public static long sum(HashMap<String, Integer> map) {
        Set keySet = map.keySet();
        Iterator iter = keySet.iterator();
        long result = 0;
        while (iter.hasNext()) {
            String key = (String) iter.next();
            result += map.get(key);
        }
        return result;
    }

    public static void addDouble(HashMap<String, Double> map, String s, double d) {
        Double temp = map.get(s);
        if (temp == null) {
            temp = 0.0;
        }
        map.put(s, temp + d);
    }

    public static Exception add(HashMap<String, Integer> map, String s) {
        try {
            Integer freq = map.get(s);
            if (freq == null) {
                freq = 0;
            }
            map.put(s, ++freq);
        } catch (Exception e) {
            return e;
        }
        return null;
    }

    public static Exception add(HashMap<String, HashMap<String, Integer>> map, String s1, String s2) {
        try {
            HashMap<String, Integer> innerMap = map.get(s1);
            if (innerMap == null) {
                innerMap = new HashMap<>();
                innerMap.put(s2, 0);
            }
            Integer freq = innerMap.get(s2);
            if (freq == null) freq = 0;
            innerMap.put(s2, ++freq);
            map.put(s1, innerMap);
        } catch (Exception e) {
            return e;
        }
        return null;
    }
}