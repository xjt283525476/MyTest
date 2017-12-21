package cn.mr.test.main;

public class ExcepteTest {

    /**
     * 2013-6-18 下午12:20:39 xuejiangtao添加此方法
     * 
     * @param args
     */
    public static void main(String[] args) {
        String abc = abc();
        System.out.println(abc);
    }

    public static String abc() {
        String a = "aa";
        try {

            if (a.equals("aa")) {
                throw new NullPointerException();
            }
            a = "aaa";
            return a;
        } catch (Exception e) {
            a = "bbb";
            return a;
        } finally {
            a = "ccc";
             return a;
        }
    }

}
