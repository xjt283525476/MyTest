package cn.mr.test.main;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class StringTest {

    public static final int MB = 1024*1024*100;

    /**
     * 2013-5-10 下午11:41:24 xuejiangtao添加此方法
     * 
     * @param args
     */
    public static void main(java.lang.String[] args) {
        System.out.println(-4 & 7);
        






        
        /*for (int i= 0; i<1000; i++) {
            System.out.println(Math.rint(Math.random()*100000)/10000);
        }*/
        
        /*Stu a = new Stu();

        System.out.println(a.getAge());*/

        /*StringBuilder sb = new StringBuilder();
        sb.append("123456");
        String sb1 = sb.toString().substring(0, sb.toString().length() - 1);
        System.out.println(sb1);*/

        /*
         * List<String> list = new ArrayList<String>(); list.add("13814881588@139.com");
         * list.add("13861307188@139.com"); list.add("13616272245@139.com"); list.add("15021087650@139.com");
         * list.add("zhjs_sz@163.com"); list.add("13402567619@139.com"); list.add("13905157663@139.com");
         * list.add("15850010606@139.com"); list.add("13382183938@189.cn"); list.add("13995589692@139.com");
         * list.add("zhangyin@139.com"); list.add("l_jw111@163.com"); String mail =
         * "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$"; for (String n :
         * list) {
         * 
         * boolean matches = Pattern.matches(mail, n); System.out.println(matches); }
         */

        /*
         * System.out.println("abcd\n1234");
         * 
         * List<String> recievers = new ArrayList<String>(); StringBuffer mobiles = new StringBuffer(); for (int i = 0;
         * i < 10; i++){ String mobile = "13770555019"; if(!StringUtils.isBlank(mobile)){ if (mobiles.length() +
         * mobile.length() > 512) { recievers.add(mobiles.toString()); mobiles = new StringBuffer(); }
         * mobiles.append(mobile).append(","); } } if (mobiles.length() > 0) { recievers.add(mobiles.toString()); }
         */

        
        /*long begin = System.currentTimeMillis();
        testString();
        long mid = System.currentTimeMillis();
        System.out.println("String:" + (mid - begin) + "ms");
        testStringBuilder();
        long end = System.currentTimeMillis();
        System.out.println("StringBuilder:" + (end - mid) + "ms");
        testStringBuffer();
        long end1 = System.currentTimeMillis();
        System.out.println("StringBuffer:" + (end1 - end) + "ms");*/

    }

    public static void testString() {
        String s = "";
        for (int i = 0; i < MB; i++) {
            s += "a";
        }
    }

    public static void testStringBuilder() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < MB; i++) {
            sb.append("a");
        }
    }

    public static void testStringBuffer() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < MB; i++) {
            sb.append("a");
        }
    }
}
