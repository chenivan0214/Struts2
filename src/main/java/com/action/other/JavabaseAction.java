package com.action.other;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.opensymphony.xwork2.ActionSupport;

public class JavabaseAction extends ActionSupport {
    private static final long serialVersionUID = 1L;
    
    public String string() {
        String string1 = "string1"; //String string1 = new String("string");
        String string2 = "string2";
        String string3 = "string3";
        
        //取得特定位置
        System.out.println(string1.charAt(1));
        
        //比較兩字串大小
        //0表示相等，-1表示不相等
        System.out.println(string1.compareTo(string1));
        
        //比較兩字串內容
        System.out.println(string1.equals(string3));
        
        //比較兩字串記憶體位址
        System.out.println(string1 == string2);
        
        //字串連接
        string2 = string1.concat(string2);
        System.out.println(string2);
        
        //找尋特定字元
        //不存在返回-1
        System.out.println(string1.indexOf('s'));
        
        //字串長度
        System.out.println(string1.length());
        
        //取代replace("被取代的字串", "要取代的字串")
        string2 = string1.replace("str", "string");
        System.out.println(string2);
        
        //取代replaceAll("被取代的字串reg", "要取代的字串")
        string2 = string1.replaceAll("s|1", "z");
        System.out.println(string2);
        
        //取出指定位置
        System.out.println(string1.substring(1,3));
        
        //轉成小寫
        System.out.println(string1.toLowerCase());
        
        //轉成大寫
        System.out.println(string1.toUpperCase());
        
        //去除trim
        string3 = string3.replaceAll("s|1", "     ");
        System.out.println(string3);
        System.out.println(string3.trim());
        
        return "string";
    }
    
    public String typeChange() {
        //int轉string
        int a = 123;
        System.out.println(Integer.toString(a));
        System.out.println(Integer.toString(a).getClass().getName());
        
        //string轉int
        String b = "123";
        System.out.println(Integer.parseInt(b));
        
        //檢查兩者型態是否相同
        Integer c = new Integer(123);
        String n1 = Integer.toString(a).getClass().getName();
        String n2 = c.getClass().getName();
        System.out.println(n1);
        System.out.println(c.toString());
        
        return "type_change";
    }
    
    public String dateSample() {
        Date nowDate = new Date();
        
        //轉成毫秒數&秒數
        long nowMillisecond = nowDate.getTime();
        int nowSecond = (int)(nowMillisecond / 1000);
        System.out.println(nowMillisecond);
        System.out.println(nowSecond);
        
        //指定特定時間
        String inputSpecifyDate = "2000-07-06 12:00:00";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date specifyDate = null;
        long specifyMillisecond = 0;
        int specifySecond = 0;
        
        try {
            specifyDate = simpleDateFormat.parse(inputSpecifyDate);
            specifyMillisecond = specifyDate.getTime();
            specifySecond = (int)(specifyMillisecond / 1000);
            
            System.out.println(specifyDate);
            System.out.println(specifyMillisecond);
            System.out.println(specifySecond);
        } catch (Exception e) {
            System.out.println(e);
        }
        
        //日期間隔
        long diffMillisecond = nowMillisecond - specifyMillisecond;
        int diffDay = (int)(diffMillisecond / (1000*60*60*24));
        System.out.println(diffMillisecond);
        System.out.println(diffDay);
        
        //日期相加
        Date destDate = null;
        long destMillisecond = 0;
        long addMillisecond = 7 * 24 * 60 * 60 * 1000;
        String outputDestDate = "";
        
        destMillisecond = nowMillisecond + addMillisecond;
        destDate = new Date(destMillisecond);
        outputDestDate = simpleDateFormat.format(destDate);
        
        System.out.println(destMillisecond);
        System.out.println(destDate);
        System.out.println(outputDestDate);
        
        return "date_sample";
    }

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
