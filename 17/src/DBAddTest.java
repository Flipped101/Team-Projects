import java.sql.*;

/**
 * 用预编译语句完成学位的增加和删除
 */
public class DBAddTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //加载驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");
        //url为数据库连接字串，其中
        //jdbc为协议，mysql为子协议
        //localhost:3306为数据库服务器的地址和端口
        String url = "jdbc:mysql://localhost:3306/bysj" +
                "?useUnicode=true&characterEncoding=utf8" + //?后面是指定编码utf8
                "&serverTimezone=Asia/Shanghai";//服务器时区为中国上海

        //用户名
        String username = "root";
        //密码
        String password = "20000306ss301!";
        //获得连接对象
        Connection connection = DriverManager.getConnection(url,username,password);

        String delete = "DELETE FROM degree WHERE id = ?";

        //创建SQL语句
        String addDegree_sql = "INSERT INTO degree (no,description,remarks) VALUES" +
                "(?,?,?)";
        //在该链接上创建语句盒子对象
       PreparedStatement preparedStatement = connection.prepareStatement(addDegree_sql);
//        preparedStatement.setInt(1,5);

        preparedStatement.setString(1,"04");
        preparedStatement.setString(2,"硕士");
        preparedStatement.setString(3,"");
        

        int affect = preparedStatement.executeUpdate();
        System.out.println("增加 " + affect + " 行");
        //执行SQL查询语句
        ResultSet resultSet = preparedStatement.executeQuery("select * from degree");
        System.out.println("查找结果:");
        //执行循环
        while (resultSet.next()){
            System.out.println(resultSet.getInt("id") + "," +
                    resultSet.getString("description") + "," +
                    resultSet.getString("no") + "," +
                    resultSet.getString("remarks"));
        }
        preparedStatement.close();
        //关闭connection对象
        connection.close();


    }
}
