package cn.mr.classload;

public class LoaderSample {
    public static void main(String[] args) {
        Class c;
        ClassLoader cl;
        cl = ClassLoader.getSystemClassLoader();
        System.out.println(cl);
        while (cl != null) {
            cl = cl.getParent();
            System.out.println(cl);
        }
        try {
            c = Class.forName("java.lang.Object");
            cl = c.getClassLoader();
            System.out.println("java.lang.Object's loader is " + cl);
            c = Class.forName("cn.mr.classload.LoaderSample");
            cl = c.getClassLoader();
            System.out.println("LoaderSample's loader is  " + cl);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 执行结果
        /*
         * sun.misc.Launcher$AppClassLoader@19821f sun.misc.Launcher$ExtClassLoader@addbf1 null java.lang.Object's
         * loader is null LoaderSample's loader is sun.misc.Launcher$AppClassLoader@19821f
         */

        // 分析
        /*
         * 第一行表示，系统类装载器实例化自类sun.misc.Launcher$AppClassLoader 第二行表示，系统类装载器的parent实例化自类sun.misc.Launcher$ExtClassLoader
         * 第三行表示，系统类装载器parent的parent为bootstrap 第四行表示，核心类java.lang.Object是由bootstrap装载的 第五行表示，用户类LoaderSample1是由系统类装载器装载的
         */
    }
}
