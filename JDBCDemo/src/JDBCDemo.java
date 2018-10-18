import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCDemo {
    public static void main(String[] args) {
        try {
            //注册驱动
            //Class.forName("com.mysql.jdbc.Driver");

            //建立连接
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/jdbc_demo_mysql", "root", "root");

            //创建statement
            Statement st = conn.createStatement();

            //执行SQL语句
            String sql = "select * from user";
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                System.out.println("id:"+id+", name:"+name+", age"+age);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }finally {

        }

    }
}
