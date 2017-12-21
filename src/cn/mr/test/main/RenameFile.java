package cn.mr.test.main;

import java.io.File;

public class RenameFile {
    File parentFile;

    public RenameFile(File parentFile) {
        this.parentFile = parentFile;
        readDataBase(parentFile.list());
    }

    private void readDataBase(String[] list)// 这个函数里读数据库的方式可能跟你的不一样，自己看着改改
    {   int i = 1;
        for (String oldName : list) {/*
            try {
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                Connection conn = DriverManager.getConnection("jdbc:odbc:DSN", "", "");// DSN是数据源名字
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("Select * from TABLENAME where FILENAME = " + oldName);// TABLENAME是数据库里表的名字，FILENAME是表示文件名的字段的名字
                while (rs.next()) {
                    String newName = rs.getString("NUMBER");// NUMBER是表示学号的字段，getString要根据你定义的数据类型作改动为getInt或其他
                    rename(oldName, newName);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        */
            System.out.println(oldName);
            System.out.println(i);
//            rename(oldName, i+".JPG");
            i++;
        }
    }

    private void rename(String oldName, String newName) {
        try {
            File source = new File(parentFile.toString() + "\\" + oldName);
            File target = new File(source.getParent() + "\\" + newName);
            source.renameTo(target);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String path = "E:\\sinieco\\项目\\基建MIS\\电子档（拍照）";// 这里把path改成文件夹的路径
        File file = new File(path);
        new RenameFile(file);
    }
}
