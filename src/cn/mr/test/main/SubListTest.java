package cn.mr.test.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class SubListTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        /*List<String> myStudentslist = new ArrayList<String>();
        myStudentslist.add("123");
        myStudentslist.add("234");
        myStudentslist.add("345");
        myStudentslist.add("456");*/
        /*List<String> subList = myStudentslist.subList(1, 2);
        myStudentslist.remove(0);
        System.out.println(subList.toString());*/
        
        /*String[] array = myStudentslist.toArray(new String[2]);
        int i = 1;
        for (String string : array) {
            
            System.out.println(i++ + ":" + string);
        }*/
        
        /*String[] array = new String[]{"qwe", "asd"};
        List<String> asList = Arrays.asList(array);
        asList.add("123456");*/
        
        
        /*Iterator<String> iterator = myStudentslist.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if ("234".equals(item)) {
                iterator.remove();
            }
        }
        System.out.println(myStudentslist.toString());*/
        
        /*List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        for (String item : list) {
            if ("2".equals(item)) {
                list.remove(item);
            }
        }
        System.out.println(list.toString());*/
        
        
        /*System.out.println(tableSizeFor(13));*/
        
        Map<String, Integer> map = new HashMap<String, Integer>(32);
        map.put("1", 1);
        Set<Entry<String,Integer>> entrySet = map.entrySet();
        for (Entry<String, Integer> entry : entrySet) {
            
        }
        
        Set<String> keySet = map.keySet();
        
    }
    
    static final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : (n >= 1073741824 ) ? 1073741824  : n + 1;
    }

}
