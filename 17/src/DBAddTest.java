import java.sql.*;

public class DBAddTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //������������
        Class.forName("com.mysql.cj.jdbc.Driver");
        //urlΪ���ݿ������ִ�������
        //jdbcΪЭ�飬mysqlΪ��Э��
        //localhost:3306Ϊ���ݿ�������ĵ�ַ�Ͷ˿�
        String url = "jdbc:mysql://localhost:3306/bysj" +
                "?useUnicode=true&characterEncoding=utf8" + //?������ָ������utf8
                "&serverTimezone=Asia/Shanghai";//������ʱ��Ϊ�й��Ϻ�

        //�û���
        String username = "root";
        //����
        String password = "19990623";
        //������Ӷ���
        Connection connection = DriverManager.getConnection(url,username,password);

        String delete = "DELETE FROM degree WHERE id = ?";

        //����SQL���
        String addDegree_sql = "INSERT INTO degree (no,description,remarks) VALUES" +
                "(?,?,?)";
        //�ڸ������ϴ��������Ӷ���
       PreparedStatement preparedStatement = connection.prepareStatement(addDegree_sql);
//        preparedStatement.setInt(1,5);

        preparedStatement.setString(1,"04");
        preparedStatement.setString(2,"˶ʿ");
        preparedStatement.setString(3,"");



        int affect = preparedStatement.executeUpdate();
        System.out.println("���� " + affect + " ��");
        //ִ��SQL��ѯ���
        ResultSet resultSet = preparedStatement.executeQuery("select * from degree");
        //ִ��ѭ��
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
        //�ر�connection����
        connection.close();


    }
}
