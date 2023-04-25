import java.sql.*; // Needed for JDBC classes

public class CRUDBilling{
    // Create a named constant for the URL.
    final String DatabaseURL = "jdbc:mysql://localhost:3306/customer";

    // Your database user name
    final String Username = "root";

    // Your database password
    final String Password = "root";

    public CRUDBilling(){
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
    public void addBill(int billingID, int billingAmt, int customerID, int Gas, int Electricity, int Water, int AirCondition, int paid){
        try {
            // Create a connection to the database.
            Connection connection = DriverManager.getConnection(DatabaseURL, Username, Password);
            System.out.println("Connection created to billing.");

            // Create a Statement object.
            Statement statement = connection.createStatement();

            // Create a string with a INSERT statement.
            String sqlStatement = "INSERT INTO billing (billingID, billingAmt, customerID, Gas, Electricity," +
                    " Water, AirCondition, paid) VALUES (" + billingID + ", '" + billingAmt + "', '" +
                    customerID + "', '" + Gas + "', '" + Electricity + "', '" + Water + "', '" + AirCondition + "', " + paid + ")";

            // Send the statement to the DBMS.
            statement.executeUpdate(sqlStatement);

            // close connection
            connection.close();
            System.out.println("Connection closed.");

        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public Billing getBill(int customerID) {
        try {
            // Create a connection to the database.
            Connection connection = DriverManager.getConnection(DatabaseURL, Username, Password);
            System.out.println("Connection created to customer.");

            // Create a string with a INSERT statement.
            String sqlStatement = "SELECT * FROM billing WHERE customerID = " + customerID;
            PreparedStatement statement = connection.prepareStatement(sqlStatement);

            // Execute the SQL statement and retrieve the matching row
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Retrieve the values of the columns in the matching row
                int billingId = resultSet.getInt("billingID");
                int billingAmt = resultSet.getInt("billingAmt");
                int customerId = resultSet.getInt("customerID");
                int Gas = resultSet.getInt("Gas");
                int Electricity = resultSet.getInt("Electricity");
                int Water = resultSet.getInt("Water");
                int AirCondition = resultSet.getInt("AirCondition");
                int paid = resultSet.getInt("paid");
                // Do something with the retrieved values
                System.out.println(billingId + "\n" + billingAmt + "\n" + customerId + "\n" + Gas + "\n" + Electricity + "\n" + Water + "\n" + AirCondition + "\n" + paid);
                return new Billing(billingId, billingAmt, customerId, Gas, Electricity, Water, AirCondition, paid);
            } else {
                System.out.println("No matching rows found");
            }
            // close connection
            connection.close();
            System.out.println("Connection closed.");


        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
        return null;
    }

}
