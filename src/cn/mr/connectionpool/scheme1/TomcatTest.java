package cn.mr.connectionpool.scheme1;

import java.io.IOException;  
import java.sql.SQLException;  
import org.apache.tomcat.jdbc.pool.DataSource;  

import cn.mr.connectionpool.TestDAO;
  
public class TomcatTest {  
  
    // 数据库驱动名称  
    final static String driver = "com.mysql.jdbc.Driver";  
 // 数据库连接地址
    final static String jdbcUrl = "jdbc:mysql://192.168.1.239:3306/dev_mis_20140923";
    // 数据库用户名
    final static String user = "root";
    // 数据库密码
    final static String passwd = "87783121";  
    // 连接池初始化大小  
    final static int initialSize = 5;  
    // 连接池最小空闲  
    final static int minPoolSize = 10;  
    // 连接池最大连接数量  
    final static int maxPoolSize = 50;  
    // 最小逐出时间，100秒  
    final static int maxIdleTime = 100000;  
    // 连接失败重试次数  
    final static int retryAttempts = 10;  
    // 当连接池连接耗尽时获取连接数  
    final static int acquireIncrement = 5;  
    // Tomcat Jdbc Pool数据源  
    final static DataSource tomcatDataSource = getTomcatDataSource();  
    // 查询次数  
    final static int count = 100;  
  
    /** 
     * 测试方式： 每种数据源配置信息尽量相同，以求结果更加准确 
     * 每种数据源做10次、100次、500次、1000次、2000次、4000次、8000次查询操作 每种查询重复100次，查看100次执行时间的波动图 
     * @param args 
     * @throws IOException 
     * @throws SQLException 
     */  
    public static void main(String[] args) throws IOException, SQLException {  
  
        TestDAO testDAO = new TestDAO();  
        System.out.println("查询次数为：" + count);  
        System.out.println();  
        System.out.println("==========================Tomcat Jdbc Pool 测试开始==========================");  
        // 测试Tomcat Jdbc Pool  
        for (int i = 0; i < 100; i++) {  
            queryTomcatJDBC(testDAO, tomcatDataSource, count);  
        }  
        System.out.println("==========================Tomcat Jdbc Pool 测试结束==========================");  
    }  
  
    /** 
     * Tomcat Jdbc Pool测试 
     * @param testDAO 
     * @param ds 
     * @param count 
     * @throws SQLException 
     */  
    public static void queryTomcatJDBC(TestDAO testDAO, DataSource ds, int count) throws SQLException {  
        // 查询100次以初始化连接池  
        for (int i = 0; i < 100; i++) {  
            testDAO.query(ds.getConnection());  
        }  
        // 开始时间  
        long startMillis = System.currentTimeMillis();  
        // 循环查询  
        for (int i = 0; i < count; i++) {  
            testDAO.query(ds.getConnection());  
        }  
        // 结束时间  
        long endMillis = System.currentTimeMillis();  
        // 输出结束时间  
        System.out.println(endMillis - startMillis);  
    }  
  
    /** 
     * 获取Apache tomcat jdbc pool数据源 
     * @return 
     */  
    public static DataSource getTomcatDataSource() {  
        DataSource ds = new DataSource();  
        ds.setUrl(jdbcUrl);  
        ds.setUsername(user);  
        ds.setPassword(passwd);  
        ds.setDriverClassName(driver);  
        ds.setInitialSize(initialSize);  
        ds.setMaxIdle(minPoolSize);  
        ds.setMaxActive(maxPoolSize);  
        ds.setTestWhileIdle(false);  
        ds.setTestOnBorrow(false);  
        ds.setTestOnConnect(false);  
        ds.setTestOnReturn(false);  
        return ds;  
    }  
}  