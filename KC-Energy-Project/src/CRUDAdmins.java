import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class CRUDAdmins {
    // Create a named constant for the URL.
    final String DatabaseURL = "jdbc:mysql://localhost:3306/customer";

    // Your database user name
    final String Username = "root";

    // Your database password
    final String Password = "root";
    public admins login(String UserName, String UserPassword) {
        try {
            // Create a connection to the database.
            Connection connection = DriverManager.getConnection(DatabaseURL, Username, Password);
            System.out.println("Connection created to customer.");

            // Create a string with a INSERT statement.
            String sqlStatement = "SELECT * FROM admins WHERE UserName = '" + UserName + "' AND Password = '" + UserPassword + "'";
            PreparedStatement statement = connection.prepareStatement(sqlStatement);

            // Execute the SQL statement and retrieve the matching row
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Retrieve the values of the columns in the matching row
                int id = resultSet.getInt("adminID");
                String username = resultSet.getString("UserName");
                String password = resultSet.getString("Password");
                // Do something with the retrieved values
                System.out.println(id + "\n" + username + "\n" + password);
                return new admins(id, username, password);
            } else {
                System.out.println("No matching rows found");
            }

            // close connection
            connection.close();
            System.out.println("Connection closed.");
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            return null;
        }

        return null;

    }
}
