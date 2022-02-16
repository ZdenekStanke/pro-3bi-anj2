package cz.spsmb.b3i.w24.databaze;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.InvalidPropertiesFormatException;
import java.util.Properties;

//property file:
/*
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE properties SYSTEM "http://java.sun.com/dtd/properties.dtd">
<properties>
  <entry key="database_name">testdb</entry>
  <entry key="user_name">root</entry>
  <entry key="password">root</entry>
  <entry key="server_name">localhost</entry>
  <entry key="port_number">3306</entry>
</properties>

 */
public class DBconn2 {
    public String dbms = "mysql";

    public String dbName;
    public String userName;
    public String password;
    //private String driver;
    private String serverName;
    private int portNumber;

    public String urlString;
    private Properties prop;

    public DBconn2(String propertiesFileName) throws FileNotFoundException,
            IOException,
            InvalidPropertiesFormatException {
        super();
        this.setProperties(propertiesFileName);
    }

    private void setProperties(String fileName) throws FileNotFoundException,
            IOException,
            InvalidPropertiesFormatException {
        this.prop = new Properties();
        FileInputStream fis = new FileInputStream(fileName);
        prop.loadFromXML(fis);

        //this.dbms = this.prop.getProperty("dbms");
        //this.jarFile = this.prop.getProperty("jar_file");
        //this.driver = this.prop.getProperty("driver");
        this.dbName = this.prop.getProperty("database_name");
        this.userName = this.prop.getProperty("user_name");
        this.password = this.prop.getProperty("password");
        this.serverName = this.prop.getProperty("server_name");
        this.portNumber = Integer.parseInt(this.prop.getProperty("port_number"));

        System.out.println("Set the following properties:");
        //System.out.println("dbms: " + dbms);
        //System.out.println("driver: " + driver);
        System.out.println("dbName: " + dbName);
        System.out.println("userName: " + userName);
        System.out.println("serverName: " + serverName);
        System.out.println("portNumber: " + portNumber);
    }
    public Connection getConnection() throws SQLException {
        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", this.userName);
        connectionProps.put("password", this.password);

        String currentUrlString = null;
        currentUrlString = "jdbc:" + this.dbms + "://" + this.serverName +
                ":" + this.portNumber + "/";
        conn =
                DriverManager.getConnection(currentUrlString,
                        connectionProps);

        this.urlString = currentUrlString + this.dbName;
        conn.setCatalog(this.dbName);
        System.out.println("Connected to database");
        return conn;
    }

    public static void initializeTables(Connection con, String dbNameArg, String dbmsArg) throws SQLException {
        SuppliersTable mySuppliersTable =
                new SuppliersTable(con, dbNameArg, dbmsArg);
        CoffeesTable myCoffeeTable =
                new CoffeesTable(con, dbNameArg, dbmsArg);
        ProductInformationTable myPIT =
                new ProductInformationTable(con, dbNameArg, dbmsArg);

        System.out.println("\nDropping exisiting PRODUCT_INFORMATION, COFFEES and SUPPLIERS tables");
        myPIT.dropTable();
        myCoffeeTable.dropTable();
        mySuppliersTable.dropTable();

        System.out.println("\nCreating and populating SUPPLIERS table...");

        System.out.println("\nCreating SUPPLIERS table");
        mySuppliersTable.createTable();
        System.out.println("\nPopulating SUPPLIERS table");
        mySuppliersTable.populateTable();

        System.out.println("\nCreating and populating COFFEES table...");

        System.out.println("\nCreating COFFEES table");
        myCoffeeTable.createTable();
        System.out.println("\nPopulating COFFEES table");
        myCoffeeTable.populateTable();

        System.out.println("\nCreating RSS_FEEDS table...");
    }

    // Některé výjimky si můžem dovolit ignorovat:
    public static boolean ignoreSQLException(String sqlState) {
        if (sqlState == null) {
            System.out.println("The SQL state is not defined!");
            return false;
        }
        // X0Y32: Jar file already exists in schema
        if (sqlState.equalsIgnoreCase("X0Y32"))
            return true;
        // 42Y55: Table already exists in schema
        if (sqlState.equalsIgnoreCase("42Y55"))
            return true;
        return false;
    }
    public static void printBatchUpdateException(BatchUpdateException b) {
        System.err.println("----BatchUpdateException----");
        System.err.println("SQLState:  " + b.getSQLState());
        System.err.println("Message:  " + b.getMessage());
        System.err.println("Vendor:  " + b.getErrorCode());
        System.err.print("Update counts:  ");
        int[] updateCounts = b.getUpdateCounts();
        for (int i = 0; i < updateCounts.length; i++) {
            System.err.print(updateCounts[i] + "   ");
        }
    }

    //SQLException představuje celý spojový seznam výjimek:
    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                if (ignoreSQLException(((SQLException)e).getSQLState()) == false) {
                    e.printStackTrace(System.err);
                    System.err.println("SQLState: " + ((SQLException)e).getSQLState());
                    System.err.println("Error Code: " + ((SQLException)e).getErrorCode());
                    System.err.println("Message: " + e.getMessage());
                    Throwable t = ex.getCause();
                    while (t != null) {
                        System.out.println("Cause: " + t);
                        t = t.getCause();
                    }
                }
            }
        }
    }
    public static void rowIdLifetime(Connection conn) throws SQLException {
        DatabaseMetaData dbMetaData = conn.getMetaData();
        RowIdLifetime lifetime = dbMetaData.getRowIdLifetime();
        switch (lifetime) {
            case ROWID_UNSUPPORTED:
                System.out.println("ROWID type not supported");
                break;
            case ROWID_VALID_FOREVER:
                System.out.println("ROWID has unlimited lifetime");
                break;
            case ROWID_VALID_OTHER:
                System.out.println("ROWID has indeterminate lifetime");
                break;
            case ROWID_VALID_SESSION:
                System.out.println("ROWID type has lifetime that is valid for at least the containing session");
                break;
            case ROWID_VALID_TRANSACTION:
                System.out.println("ROWID type has lifetime that is valid for at least the containing transaction");
        }
    }
    public static void cursorHoldabilitySupport(Connection conn) throws SQLException {
        DatabaseMetaData dbMetaData = conn.getMetaData();
        System.out.println("ResultSet.HOLD_CURSORS_OVER_COMMIT = " +
                ResultSet.HOLD_CURSORS_OVER_COMMIT);
        System.out.println("ResultSet.CLOSE_CURSORS_AT_COMMIT = " +
                ResultSet.CLOSE_CURSORS_AT_COMMIT);
        System.out.println("Default cursor holdability: " +
                dbMetaData.getResultSetHoldability());
        System.out.println("Supports HOLD_CURSORS_OVER_COMMIT? " +
                dbMetaData.supportsResultSetHoldability(ResultSet.HOLD_CURSORS_OVER_COMMIT));
        System.out.println("Supports CLOSE_CURSORS_AT_COMMIT? " +
                dbMetaData.supportsResultSetHoldability(ResultSet.CLOSE_CURSORS_AT_COMMIT));
    }

    public static void createDatabase(Connection connArg, String dbNameArg) {
        try {
            Statement s = connArg.createStatement();
            s.executeUpdate("SET sql_mode='ANSI_QUOTES';");
            String newDatabaseString =
                    "CREATE DATABASE IF NOT EXISTS \"" + dbNameArg + "\"";
            // String newDatabaseString = "CREATE DATABASE " + dbName;
            s.executeUpdate(newDatabaseString);

            System.out.println("Created database " + dbNameArg);
        } catch (SQLException e) {
            printSQLException(e);
        }
    }
    public static void closeConnection(Connection connArg) {
        System.out.println("Releasing all open resources ...");
        try {
            if (connArg != null) {
                connArg.close();
                connArg = null;
            }
        } catch (SQLException sqle) {
            printSQLException(sqle);
        }
    }
    public static void main(String[] args) {
        DBconn2 dBconn2;
        Connection myConnection = null;
        if (args[0] == null) {
            System.err.println("Properties file not specified at command line");
            return;
        } else {
            try {
                System.out.println("Reading properties file " + args[0]);
                dBconn2 = new DBconn2(args[0]);
            } catch (Exception e) {
                System.err.println("Problem reading properties file " + args[0]);
                e.printStackTrace();
                return;
            }
        }

        try {
            myConnection = dBconn2.getConnection();
            DBconn2.createDatabase(myConnection,
                    dBconn2.dbName);
            initializeTables(myConnection, dBconn2.dbName, dBconn2.dbms);
            DBconn2.cursorHoldabilitySupport(myConnection);
            DBconn2.rowIdLifetime(myConnection);
            CoffeesTable.viewTable(myConnection);

        } catch (SQLException e) {
            DBconn2.printSQLException(e);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        } finally {
            DBconn2.closeConnection(myConnection);
        }

    }
}
