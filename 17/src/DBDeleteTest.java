import java.sql.*;

public class DBDeleteTest {
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
        String password = "19990623";
        //获得连接对象
        Connection connection = DriverManager.getConnection(url,username,password);

        String delete = "DELETE FROM degree WHERE id = ?";

        //在该链接上创建语句盒子对象
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1,10);

        int affect = preparedStatement.executeUpdate();
        System.out.println("删除 " + affect + " 行");
        //执行SQL查询语句
        ResultSet resultSet = preparedStatement.executeQuery("select * from degree");
        //执行循环
        while (resultSet.next()){
            System.out.print(resultSet.getInt("id"));
            System.out.print(",");
            System.out.print(resultSet.getString("description"));
            System.out.print(",");
            System.out.print(resultSet.getString("no"));
            System.out.print(",");
            System.out.print(resultSet.getString("remarks"));
            System.out.println();
        }
        preparedStatement.close();
        //关闭connection对象
        connection.close();


    }
}
