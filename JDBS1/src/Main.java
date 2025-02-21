import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/school";
        String username = "root";
        String password = "@EnterYourMysqlPassword";
//        String query = "SELECT * FROM employees WHERE name = ? and job_title = ?";
          String query ="INSERT INTO employees (name, job_title, salary) VALUES (?,?,?)";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {


            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("Connection established successfully");
            Scanner input = new Scanner(System.in);
            System.out.println("Enter name");
            String name = input.nextLine();
            System.out.println("Enter Job Title");
            String Job_title = input.nextLine();
            System.out.println("Enter salary");
            double salary = input.nextDouble();
//            Statement statement = con.createStatement();
            PreparedStatement preparedStatement = con.prepareStatement(query);
//            preparedStatement.setString(1,"Gaurav");
//            preparedStatement.setString(2,"Software Engineer");
//            preparedStatement.setInt(1,2);
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,Job_title);
            preparedStatement.setDouble(3,salary);

            int rows = preparedStatement.executeUpdate();
            if (rows>0){
                System.out.println("Insertion successfully");
            }else {
                System.out.println("Insertion failed");
            }

//            ResultSet resultSet = preparedStatement.executeQuery();
//            while (resultSet.next()){
//                int id = resultSet.getInt("id");  // Ensure correct column name
//                String name = resultSet.getString("name");
//                String jobTitle = resultSet.getString("job_title");
//                double salary = resultSet.getDouble("salary");
//
//                System.out.printf("| %-2d | %-7s | %-17s | %-6.2f |\n", id, name, jobTitle, salary);
//            }
//
//           resultSet.close();
            preparedStatement.close();
            con.close();
            System.out.println();
            System.out.println("Connection closed successfully");
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
