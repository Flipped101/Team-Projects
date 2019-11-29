import java.sql.*;

public class DBDeleteTest {
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

        //�ڸ������ϴ��������Ӷ���
        PreparedStatement preparedStatement = connection.prepareStatement(delete);
        preparedStatement.setInt(1,10);

        int affect = preparedStatement.executeUpdate();
        System.out.println("ɾ�� " + affect + " ��");
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
