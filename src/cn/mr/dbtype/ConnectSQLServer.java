package cn.mr.dbtype;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectSQLServer {

    /**
     * 2015-4-29 下午8:00:03 xuejiangtao添加此方法
     * 
     * @param args
     * @throws SQLException
     */
    public static void main(String[] args) throws SQLException {
        Connection conn = null;
        // 连接数据库对象
        Statement stmt = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // 加载数据库引擎，返回给定字符串名的类
            String url = "jdbc:sqlserver://192.168.20.165:2433;DatabaseName=jsppms";
            // test为你的数据库的名称
            String user = "sa";
            String password = "jasonzhang";
            conn = DriverManager.getConnection(url, user, password);
            stmt = conn.createStatement();
            // 读取数据
            ResultSet rs = stmt.executeQuery("SELECT * FROM prj_infomessage");
            // 循环输出每一条记录 rs最初指向第一条记录的前面
            while (rs.next()) {
                System.out.println(rs.getString("lfdwmc") + ", " + rs.getString("content"));
            }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            stmt.close();
            conn.close();
        }
    }
}
