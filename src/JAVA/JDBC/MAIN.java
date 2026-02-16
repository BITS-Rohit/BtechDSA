package JAVA.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class MAIN {
    private static final String url = "jdbc:mysql://localhost:3306";
    public static final String username = "root";
    public static final String password = "root";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            Connection connect = DriverManager.getConnection(url, username, password);
            String Q1= "Insert Into rohit.students(name , age , marks) values (?, ? , ? ) ";
            PreparedStatement ps = connect.prepareStatement(Q1);
            Scanner in = new Scanner(System.in);
            while ( true ){
                System.out.println(" Enter Name : "); String name = in.next();
                System.out.println(" Enter age : "); int age = in.nextInt();
                System.out.println(" Enter marks : "); double marks = in.nextDouble();
                ps.setString(1,name);
                ps.setInt(2,age);
                ps.setDouble(3,marks);
                int rowAffected = ps.executeUpdate();
                if (rowAffected >0) System.out.println(" Data Inserted Successfully ");
                else System.out.println(" Error Try again ");
                System.out.println(" Enter Choice (Y/N) ");String choice = in.next();
                ps.addBatch();
                if ( choice.equalsIgnoreCase("N") ) break;
            }
            ps.executeBatch();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}

//            String  Q1 = "select * from  rohit.students";
//                int id = result.getInt("id");
//                String name = result.getString("name");
//                int age = result.getInt("age");
//                double marks = result.getDouble("marks");
//                System.out.println("Row no := "+row );
//                System.out.println("ID : "+ id);
//                System.out.println("Name  : "+ name);
//                System.out.println("Age : "+ age);
//                System.out.println("Marks : "+ marks);
//                System.out.println();
//            ResultSet result = statement.executeQuery(Q1);
//            int row =1;
//            while ( result.next()){
//                row++;
//            }
//        } catch (SQLException %m%.sql) {
//            System.out.println(%m%.sql.getMessage());
//        }
//    }}





//            Statement s = connect.createStatement();
/////////////////////////////////////////////Statement/////////////////////////////
//            String Q2 = String.format("Insert into rohit.students (name,age,marks) values ('%s','%o','%f')" , "Radhe Radhe",23,39.9);
//            int rowsAffected = statement.executeUpdate(Q2);
//
//            if (rowsAffected>0) System.out.println("🔰🔰 Data inserted Successfully 🔰🔰");
//            else System.out.println("Query Error");
//
//            String Q3 = String.format("Update rohit.students SET marks = 34 where id ='%o' ",2);
//            int rows = statement.executeUpdate(Q3);
//
//            if (rowsAffected>0) System.out.println("🔰🔰 Data Updated Successfully 🔰🔰");
//            else System.out.println("Query Error");
///////////////////////////////// Prepared Statement        ///////////////////
//            String query = " INSERT INTO rohit.students( name , age , marks) values(?,?,?) ";
//            PreparedStatement ps = connect.prepareStatement(query);
//
//            ps.setString(1,"Jasmine");
////            ps.setString(1,"Jas");
////            ps.setString(1,"Smuggler");
//
//            ps.setInt(2,18);
////            ps.setInt(2,16);
////            ps.setInt(2,15);
//
//            ps.setDouble(3,77);
////            ps.setDouble(3,70);
////            ps.setDouble(3,80);

//            ps.executeUpdate();
//            String Q = "Update rohit.students set ID =3 where name =? ";
//            PreparedStatement PS = connect.prepareStatement(Q);
//            PS.setString(1, "Radhe Radhe");
//
//             int r = PS.executeUpdate();
//            if (r>0) System.out.println("🔰🔰 Data Updated Successfully 🔰🔰");
//            else System.out.println("Query Error");
//              if ( resultSet.next()){
//                  System.out.println("Marks :"+resultSet.getDouble("marks"));
//              }
//              else System.out.println("No Value is there at that parameter");
