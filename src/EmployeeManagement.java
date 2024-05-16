import java.util.*;
import java.sql.*;

public class EmployeeManagement {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "siran1234";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement();
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connected to PostgreSQL database!");

            // Get employee details from the user
            System.out.println("Enter employee ID:");
            int id = scanner.nextInt();

            scanner.nextLine(); // Consume newline character

            System.out.println("Enter employee name:");
            String name = scanner.nextLine();

            System.out.println("Enter employee salary:");
            int salary = scanner.nextInt();

            scanner.nextLine(); // Consume newline character

            System.out.println("Enter employee address:");
            String address = scanner.nextLine();

            System.out.println("Enter employee pincode:");
            int pincode = scanner.nextInt();

            // Insert employee data into the "employees" table
            String insertQuery = "INSERT INTO employees (id, name, salary, address, pincode) " +
                    "VALUES (" + id + ", '" + name + "', " + salary + ", '" + address + "', " + pincode + ")";
            int rowsInserted = statement.executeUpdate(insertQuery);

            if (rowsInserted > 0) {
                System.out.println("Employee data inserted successfully!");
            } else {
                System.out.println("Employee data failed to insert.");
                // return;
            }

            // Select and display all employee records from the "employees" table
            String selectQuery = "SELECT * FROM employees";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            System.out.println("Employee Records:");
            while (resultSet.next()) {
                int employeeId = resultSet.getInt("id");
                String employeeName = resultSet.getString("name");
                int employeeSalary = resultSet.getInt("salary");
                String employeeAddress = resultSet.getString("address");
                int employeePincode = resultSet.getInt("pincode");

                System.out.println("ID: " + employeeId + ", Name: " + employeeName +
                        ", Salary: " + employeeSalary + ", Address: " + employeeAddress +
                        ", Pincode: " + employeePincode);
            }

            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Error connecting to PostgreSQL database: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid value.");
        }
    }
}
