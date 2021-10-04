import java.sql.*;

public class main {
    private static String CLASSNAME = "com.mysql.cj.jdbc.Driver";
    private static String DBURL = "jdbc:mysql://localhost:3306/mydb";
    private static String USER = "root";
    private static String PASSWORD = "Sixgun1254?m";
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        // DB 접속
        ResultSet rs = null;
        Class.forName(CLASSNAME);
        Connection conn = DriverManager.getConnection(DBURL, USER, PASSWORD);
        String table = "SELECT * FROM table1";
        PreparedStatement state = conn.prepareStatement(table);
        rs = state.executeQuery(table);

        //Read
        System.out.println("====================== READ========================");
        while(rs.next()){
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String job = rs.getString("job");

            System.out.println("name: " + name + " age: "+ age + " job: "+ job);
        }
        System.out.println("====================== INSERT========================");


        // INSERT
        String query = "INSERT INTO table1 (name, age, job) VALUES ('아저씨', 30, '백수')";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.executeUpdate();
        //Read
        state = conn.prepareStatement(table);
        rs = state.executeQuery(table);
        while(rs.next()){
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String job = rs.getString("job");

            System.out.println("name: " + name + " age: "+ age + " job: "+ job);
        }
        System.out.println("====================== UPDATE ========================");
        //Update
        query = "UPDATE table1 SET name = 'RichMen', age = 30, job='건물주' WHERE name = '아저씨'";
        ps = conn.prepareStatement(query);
        ps.executeUpdate();

        //Read
        state = conn.prepareStatement(table);
        rs = state.executeQuery(table);
        while(rs.next()){
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String job = rs.getString("job");

            System.out.println("name: " + name + " age: "+ age + " job: "+ job);
        }

        //DELETE
        System.out.println("====================== DELETE ========================");
        query = "DELETE FROM table1 WHERE name ='RichMen'";
        ps = conn.prepareStatement(query);
        ps.executeUpdate();

        //Read
        state = conn.prepareStatement(table);
        rs = state.executeQuery(table);
        while(rs.next()){
            String name = rs.getString("name");
            int age = rs.getInt("age");
            String job = rs.getString("job");

            System.out.println("name: " + name + " age: "+ age + " job: "+ job);
        }
        System.out.println("==============================================");

        rs.close();
        ps.close();
        state.close();
        conn.close();
    }
}

