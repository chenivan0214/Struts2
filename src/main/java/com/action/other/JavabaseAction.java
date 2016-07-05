package com.action.other;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.opensymphony.xwork2.ActionSupport;

public class JavabaseAction extends ActionSupport {
    private static final long serialVersionUID = 1L;

    public String mapSample1() {
        Map<Integer, String> map = new HashMap<Integer, String>();
        
        for (int a = 0; a < 10; a++) {
            map.put(a, Integer.toString(a));
        }
        
        //for (Object object: map.keySet()) {
        //    String value = map.get(object);
        //    System.out.println(value);
        //}
        
        Iterator<Integer> iterator = map.keySet().iterator();
        
        //遍歷
        while (iterator.hasNext()) {
            String key = iterator.next().toString();
            String value = map.get(Integer.parseInt(key));
            System.out.println(key + "/" + value);
        }
        
        //取出指定特定位置
        String value = map.get(9);
        System.out.println(Integer.toString(9) + "/" + value);
        System.out.println(map);
        
        //修改特定位置的值
        map.put(8, "88888");
        System.out.println(map);

        //刪除特定位置
        map.remove(9);
        System.out.println(map);
        
        return "map_sample1";
    }

    public String mapSample2() {
        Map<Integer, Map<Integer, Integer>> parentMap = new HashMap<Integer, Map<Integer, Integer>>();
        
        for (int a = 0; a < 10; a++) {
            Map<Integer, Integer> childMap = new HashMap<Integer, Integer>();
            childMap.put(a, a);
            parentMap.put(a, childMap);
        }
        
        //遍歷
        Iterator<Entry<Integer, Map<Integer, Integer>>> it = parentMap.entrySet().iterator();
        
        while (it.hasNext()) {
            Map.Entry<Integer, Map<Integer, Integer>> entry = it.next();
            Integer parentKey = entry.getKey();
            Map<Integer, Integer> parentValue = entry.getValue();
            System.out.print(parentKey + "-");
            System.out.println(parentValue.get(parentKey));
        }
        
        //取出指定特定位置
        Map<Integer, Integer> childMap1 = parentMap.get(8);
        Integer value = childMap1.get(8);
        System.out.println(value);
        
        //修改特定位置的值
        Map<Integer, Integer> childMap2 = new HashMap<Integer, Integer>();
        childMap2.put(1, 100);
        parentMap.put(9, childMap2);
        System.out.println(parentMap);
        
        //刪除特定位置
        parentMap.remove(9);
        System.out.println(parentMap);
        
        return "map_sample2";
    }
    
    public String listSample1() {
        List<String> list = new ArrayList<String>();
        
        for (int a = 0; a < 10; a++) {
            list.add(Integer.toString(a));
        }
        
        Iterator<String> it = list.iterator();
        int a = 0;
        
        //遍歷
        while (it.hasNext()) {
            String value = it.next();
            System.out.println(a + "/" + value);
            a++;
        }
        
        //取出指定特定位置
        System.out.println(list.get(8));
        
        //修改特定位置的值
        list.set(2, "2222");
        System.out.println(list);
        
        //刪除特定位置
        list.remove(2);
        System.out.println(list);
        
        return "list_sample1";
    }
}
