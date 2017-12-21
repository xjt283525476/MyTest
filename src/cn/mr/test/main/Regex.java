package cn.mr.test.main;

import java.util.regex.Pattern;

public class Regex {

    /**
     * 2014-3-7 下午2:44:14 xuejiangtao添加此方法
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(Pattern.matches("[0-9]{2}:[0-9]{2}", "00:30"));
    }

}
