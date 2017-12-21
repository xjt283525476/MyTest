package cn.mr.connectionpool;

import java.sql.Connection;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  
  
public class TestDAO {  
  
    private final static String sql = "SELECT * FROM t_USER u WHERE u.loginname='root'";  
  
    public void query(Connection conn) {  
        try {  
            Statement st = conn.createStatement();  
            ResultSet result = st.executeQuery(sql);  
            result.close();  
            st.close();  
            conn.close();  
        } catch (SQLException e) {  
            e.printStackTrace();  
        }  
    }  
}  
