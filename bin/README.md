### Question

Write a Java program to connect to a PostgreSQL database using JDBC, create a table named "employees" with columns for employee ID, name, salary, address, and pincode, insert employee records into the table, and retrieve all employee records from the table.

### Aim:

To write a Java program to connect to a PostgreSQL database using JDBC and perform the given operations.

### Procedure:

1. Connect to PostgreSQL Database:
2. Create Table in PostgreSQL:
   - Execute the following SQL query in SQL shell (psql) or pgAdmin to create the "employees" table with columns for employee ID, name, salary, address, and pincode.:
     ```sql
     CREATE TABLE employees (
         id INT PRIMARY KEY,
         name VARCHAR(100),
         salary INT,
         address VARCHAR(255),
         pincode INT
     );
     ```
3. Run the Java program to insert employee records and retrieve all employee records from the table.

    <!-- - Use the following command to compile the Java code:
      ```bash
      javac -cp lib/postgresql-42.7.3.jar -d bin src/EmployeeDatabase.java
      ```
    - Use the following command to run the Java program:
      ```bash
      java -cp bin;lib/postgresql-42.7.3.jar EmployeeDatabase
      ``` -->

<!-- 
### Detailed Procedure:

1. **Connect to PostgreSQL Database:**
   - Use SQL Shell (psql) or pgAdmin and connect to your PostgreSQL database using the appropriate credentials (username, password).

2. **Create Table in PostgreSQL:**
   - Execute the following SQL query to create the "employees" table with columns for employee ID, name, salary, address, and pincode.:
     ```sql
     CREATE TABLE employees (
         id INT PRIMARY KEY,
         name VARCHAR(100),
         salary INT,
         address VARCHAR(255),
         pincode INT
     );
     ```
    - Use the following command to check the table:
      ```sql
      \d employees
      ```

3. **Java Code for Database Interaction:**
   - Using VS Code, create a new Java file (e.g., `EmployeeDatabase.java`) in the `src` directory of your Java project.
   - Write Java code to connect to the PostgreSQL database, insert records, and retrieve records with necessary imports.

4. **Compile and Run Java Code:**
   - To run the Java code, click the "Run" option in the context menu or use the shortcut F5 key. Alternatively, you can use the integrated terminal in VS Code.
    - Use the following command to compile the Java code:
      ```bash
      javac -cp lib/postgresql-42.7.3.jar -d bin src/EmployeeDatabase.java
      ```
    - Use the following command to run the Java program:
      ```bash
      java -cp bin;lib/postgresql-42.7.3.jar EmployeeDatabase
      ```
   - Follow the prompts in the Java program to enter employee details.
   - The program will insert the data into the "employees" table and display all employee records retrieved from the table.

5. **Verify Data in PostgreSQL:**
   - After running the Java program, verify that the employee records have been successfully inserted into the "employees" table in PostgreSQL.
   - You can use SQL queries (`SELECT * FROM employees`) in SQL Shell (psql) or pgAdmin to check the inserted data. -->



### Algorithm:

1. Start the program.
2. Define the PostgreSQL database connection URL, username, and password.
3. Establish a connection to the PostgreSQL database using the `DriverManager.getConnection()` method.
4. Create a `Statement` object to execute SQL queries.
5. Create a `Scanner` object to read user input.
6. Prompt the user to enter employee details (ID, name, salary, address, pincode).
7. Insert the employee data into the "employees" table using an SQL `INSERT` query.
8. Display a success message if the data is inserted successfully.
9. Execute an SQL `SELECT` query to retrieve all employee records from the "employees" table.
10. Display the retrieved employee records.
11. Handle exceptions for SQL errors and invalid input.
12. End the program.


### Program:

```java

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
        } catch (SQLException e) {
            System.out.println("Error connecting to PostgreSQL database: " + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid value.");
        }
    }
}

```


### Example Output:

```
Connected to PostgreSQL database!
Enter employee ID:
101
Enter employee name:
Alice
Enter employee salary:
50000
Enter employee address:
123 Main Street
Enter employee pincode:
560001
Employee data inserted successfully!
Employee Records:
ID: 101, Name: Alice, Salary: 50000, Address: 123 Main Street, Pincode: 560001
```

### Result:

Thus, the Java program to connect to a PostgreSQL database using JDBC,  insert employee records, and retrieve employee records has been successfully implemented and executed.

