import java.sql.*; // Needed for JDBC classes


public class CRUDCustomers {
    // Create a named constant for the URL.
    final String DatabaseURL = "jdbc:mysql://localhost:3306/customer";

    // Your database user name
    final String Username = "root";

    // Your database password
    final String Password = "root";
//    Record an account and add to sql db
    public CRUDCustomers(int customerID, String Name, String PhoneNumber, String Address, String MeterType, int EnergyTariff) {
        try {
            // Create a connection to the database.
            Connection connection = DriverManager.getConnection(DatabaseURL, Username, Password);
            System.out.println("Connection created to customer.");

            // Create a Statement object.
            Statement statement = connection.createStatement();

            // Create a string with a INSERT statement.
            String sqlStatement = "INSERT INTO customers (customerID, Name, PhoneNumber, Address, MeterType," +
                    " EnergyTariff) VALUES (" + customerID + ", '" + Name + "', '" +
                    PhoneNumber + "', '" + Address + "', '" + MeterType + "', " + EnergyTariff + ")";

            // Send the statement to the DBMS.
            statement.executeUpdate(sqlStatement);
            // close connection
            connection.close();
            System.out.println("Connection closed.");

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public CRUDCustomers(){
//        try {
//            // Create a connection to the database.
//            Connection connection = DriverManager.getConnection(DatabaseURL, Username, Password);
//            System.out.println("Connection created to customer.");
//            connection.close();
//            System.out.println("Connection closed.");
//
//        } catch (Exception e) {
//            System.out.println("ERROR: " + e.getMessage());
//        }
    }

    public void updateCustomer(int customerID, String Name, String PhoneNumber, String Address, String MeterType, int EnergyTariff) {
        try {
            // Create a connection to the database.
            Connection connection = DriverManager.getConnection(DatabaseURL, Username, Password);
            System.out.println("Connection created to customer.");

            // Create a Statement object.
            Statement statement = connection.createStatement();

            // Create a string with a INSERT statement.
            String sqlStatement = "UPDATE customers SET Name = '" + Name + "', PhoneNumber = '" + PhoneNumber + "', Address = '" + Address + "', MeterType = '" + MeterType + "', EnergyTariff = " + EnergyTariff + " WHERE customerID = " + customerID;

            // Send the statement to the DBMS.
            statement.executeUpdate(sqlStatement);
            // close connection
            connection.close();
            System.out.println("Connection closed.");

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void deleteCustomer(int customerID) {
        try {
            // Create a connection to the database.
            Connection connection = DriverManager.getConnection(DatabaseURL, Username, Password);
            System.out.println("Connection created to customer.");

            // Create a Statement object.
            Statement statement = connection.createStatement();

            // Create a string with a INSERT statement.
            String sqlStatement = "DELETE FROM customers WHERE customerID = " + customerID;

            // Send the statement to the DBMS.
            statement.executeUpdate(sqlStatement);
            // close connection
            connection.close();
            System.out.println("Connection closed.");

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }


}
