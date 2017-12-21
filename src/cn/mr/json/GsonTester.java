package cn.mr.json;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Google Gson解析Json数据实例
 * 
 * 1.Bean、Json转换 testBeanJson() 2.List -> Json转换 testList2Json() 3.泛型List、Json相互转换 testGenericList2Json() 4.Map ->
 * Json转换 testMap2Json() 5.泛型Map、Json相互转换 testGenericMap2Json() 6.带日期属性Bean、Json转换 testDateBeanJson()
 * 7.带日期属性泛型List、Json转换 testDateGenericListJson()
 * 
 * @author xuejiangtao 2012-8-23 上午11:22:24
 */
@SuppressWarnings("unchecked")
public class GsonTester {
    private Gson gson = null;
    private GsonBuilder gsonBuilder = null;

    @Before
    public void setUp() {
        gson = new Gson();
        gsonBuilder = new GsonBuilder();
    }

    /**
     * JavaBean锟斤拷Json锟洁互转锟斤拷
     */
    @Test
    public void testBeanJson() {
        JavaBean bean = new JavaBean("1001", "scott", 20, "TL");

        // Bean -> Json
        String json = gson.toJson(bean);
        System.out.println(json);

        // Json -> Bean
        bean = gson.fromJson(json, JavaBean.class);
        System.out.println(bean);
    }

    /**
     * List转换成Json字符串
     */
    @Test
    public void testList2Json() {
        // List
        List list = new ArrayList();
        for (int i = 0; i < 5; i++) {
            list.add("element" + i);
        }
        System.out.println(list);

        // List -> Json
        String json = gson.toJson(list);
        System.out.println(json);
    }

    /**
     * 泛型List、Json相互转换
     */
    @Test
    public void testGenericListJson() {
        // 泛型List
        List<JavaBean> list = new ArrayList<JavaBean>();
        for (int i = 0; i < 3; i++) {
            JavaBean user = new JavaBean("100" + i, "name" + i, 20 + i, "BJ" + i);
            list.add(user);
        }
        System.out.println(list);

        // 泛型List -> Json
        java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<List<JavaBean>>() {
        }.getType();
        String json = gson.toJson(list, type);
        System.out.println(json);

        // Json -> 泛型List
        List<JavaBean> users = gson.fromJson(json.toString(), type);
        System.out.println(users);
    }

    /**
     * Map转换成Json字符串
     */
    @Test
    public void testMap2Json() {
        // Map数据
        Map map = new HashMap();
        map.put("id", "1001");
        map.put("name", "scott");
        map.put("age", 20);
        map.put("addr", "BJ");
        System.out.println(map);

        // Map -> Json
        String json = gson.toJson(map);
        System.out.println(json);
    }

    /**
     * 泛型Map、Json相互转换
     */
    @Test
    public void testGenericMapJson() {
        // 泛型Map数据
        Map<String, JavaBean> map = new HashMap<String, JavaBean>();
        for (int i = 0; i < 5; i++) {
            JavaBean user = new JavaBean("100" + i, "name" + i, 20 + i, "LN" + i);
            map.put("100" + i, user);
        }
        System.out.println(map);

        // 泛型Map -> Json
        java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<List<Map<String, String>>>() {
        }.getType();
        // String json = gson.toJson(map, type);
        String json = "[{'longitude':'0.0','latitude':'0.0'},{'longitude':'0.0','latitude':'0.0'},{'longitude':'0.0','latitude':'0.0'},"
                + "{'longitude':'0.0','latitude':'0.0'},{'longitude':'0.0','latitude':'0.0'},{'longitude':'0.0','latitude':'0.0'},"
                + "{'longitude':'0.0','latitude':'0.0'},{'longitude':'0.0','latitude':'0.0'},{'longitude':'0.0','latitude':'0.0'},"
                + "{'longitude':'0.0','latitude':'0.0'}]";
        System.out.println(json);

        // Json -> Map
        List<Map<String, String>> users = gson.fromJson(json.toString(), type);
        System.out.println(users);

    }

    /**
     * 带日期类型Bean、Json相互转换
     */
    @Test
    public void testDateBeanJson() {
        // 日期Bean数据
        DateBean bean = new DateBean("1001", "scott", 20, new Date());

        // Bean(带日期属性) -> Json
        gson = gsonBuilder.registerTypeAdapter(java.util.Date.class, new DateSerializerUtils())
                .setDateFormat(DateFormat.LONG).create();
        String json = gson.toJson(bean);
        System.out.println(json);

        // Json -> Bean(带日期类型属性)
        gson = gsonBuilder.registerTypeAdapter(java.util.Date.class, new DateDeserializerUtils())
                .setDateFormat(DateFormat.LONG).create();
        java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<DateBean>() {
        }.getType();
        DateBean b = gson.fromJson(json, type);
        System.out.println(b);
    }

    /**
     * 泛型日期List、Json相互转换
     */
    @Test
    public void testDateGenericListJson() {
        // 泛型日期List
        List<DateBean> list = new ArrayList<DateBean>();
        for (int i = 0; i < 3; i++) {
            DateBean user = new DateBean("100" + i, "name" + i, 20 + i, new Date());
            list.add(user);
        }
        System.out.println(list);

        // 泛型日期List -> Json
        gson = gsonBuilder.registerTypeAdapter(java.util.Date.class, new DateSerializerUtils())
                .setDateFormat(DateFormat.LONG).create();
        java.lang.reflect.Type type = new com.google.gson.reflect.TypeToken<List<DateBean>>() {
        }.getType();
        String json = gson.toJson(list, type);
        System.out.println(json);

        // Json -> 泛型日期List
        gson = gsonBuilder.registerTypeAdapter(java.util.Date.class, new DateDeserializerUtils())
                .setDateFormat(DateFormat.LONG).create();
        List<DateBean> users = gson.fromJson(json.toString(), type);
        System.out.println(users);
    }
}
