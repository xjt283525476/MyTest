package cn.mr.test.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {

    /**
     * 2013-6-26 下午4:21:27 xuejiangtao添加此方法
     * 
     * @param args
     */
    public static void main(String[] args) {
        Map<Long, Map<Integer, Integer>> map = new HashMap<Long, Map<Integer, Integer>>();
        Map<Integer, Integer> map1 = map.get(1);
        if (map1 == null) {
            map1 = new HashMap<Integer, Integer>();
            map.put(new Long(1), map1);
        }
        map1.put(11, 111);

        map1 = map.get(1);
        if (map1 == null) {
            map1 = new HashMap<Integer, Integer>();
            map.put(new Long(1), map1);
        }
        map1.put(22, 222);

        System.out.println(map.toString());
    }

}
