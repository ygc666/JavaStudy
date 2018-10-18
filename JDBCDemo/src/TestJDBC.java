import util.JDBCUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            //1.获取Connection对象
            conn = JDBCUtil.getConn();

            //2.根据连接对象，得到statement
            st = conn.createStatement();

            //3.执行sql语句，返回ResultSet
            String sql = "select * from user";
            rs = st.executeQuery(sql);

            //4.遍历结果集
            while (rs.next()){
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("name:"+name+",age:"+age);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtil.release(conn,st,rs);
        }

    }
}
