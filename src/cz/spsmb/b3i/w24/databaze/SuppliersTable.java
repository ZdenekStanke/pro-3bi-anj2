package cz.spsmb.b3i.w24.databaze;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SuppliersTable {
    private String dbName;
    private Connection con;
    private String dbms;

    public SuppliersTable(Connection connArg, String dbNameArg, String dbmsArg) {
        super();
        this.con = connArg;
        this.dbName = dbNameArg;
        this.dbms = dbmsArg;
    }

    public void createTable() throws SQLException {
        String createString =
                "create table SUPPLIERS " + "(SUP_ID integer NOT NULL, " +
                        "SUP_NAME varchar(40) NOT NULL, " + "STREET varchar(40) NOT NULL, " +
                        "CITY varchar(20) NOT NULL, " + "STATE char(2) NOT NULL, " +
                        "ZIP char(5), " + "PRIMARY KEY (SUP_ID))";

        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate(createString);
        } catch (SQLException e) {
            DBconn2.printSQLException(e);
        }
    }

    public void dropTable() throws SQLException {
        try (Statement stmt = con.createStatement()) {
            if (this.dbms.equals("mysql")) {
                System.out.println("Dropping table SUPPLIERS from MySQL");
                stmt.executeUpdate("DROP TABLE IF EXISTS SUPPLIERS");
            } else if (this.dbms.equals("derby")) {
                stmt.executeUpdate("DROP TABLE SUPPLIERS");
            }
        } catch (SQLException e) {
            DBconn2.printSQLException(e);
        }
    }

    public void populateTable() throws SQLException {
        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate("insert into SUPPLIERS " +
                    "values(49, 'Superior Coffee', '1 Party Place', " +
                    "'Mendocino', 'CA', '95460')");
            stmt.executeUpdate("insert into SUPPLIERS " +
                    "values(101, 'Acme, Inc.', '99 Market Street', " +
                    "'Groundsville', 'CA', '95199')");
            stmt.executeUpdate("insert into SUPPLIERS " +
                    "values(150, 'The High Ground', '100 Coffee Lane', " +
                    "'Meadows', 'CA', '93966')");
        } catch (SQLException e) {
            DBconn2.printSQLException(e);
        }
    }

    public void viewSuppliers() throws SQLException {

        String query = "select SUP_NAME, SUP_ID from SUPPLIERS";
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            System.out.println("Suppliers and their ID Numbers:");
            while (rs.next()) {
                String s = rs.getString("SUP_NAME");
                int n = rs.getInt("SUP_ID");
                System.out.println(s + "   " + n);
            }
        } catch (SQLException e) {
            DBconn2.printSQLException(e);
        }
    }

    public static void viewTable(Connection con) throws SQLException {
        String query =
                "select SUP_ID, SUP_NAME, STREET, CITY, STATE, ZIP from SUPPLIERS";
        try (Statement stmt = con.createStatement()) {
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                int supplierID = rs.getInt("SUP_ID");
                String supplierName = rs.getString("SUP_NAME");
                String street = rs.getString("STREET");
                String city = rs.getString("CITY");
                String state = rs.getString("STATE");
                String zip = rs.getString("ZIP");
                System.out.println(supplierName + "(" + supplierID + "): " + street +
                        ", " + city + ", " + state + ", " + zip);
            }
        } catch (SQLException e) {
            DBconn2.printSQLException(e);
        }
    }

    public static void main(String[] args) {

        DBconn2 myJDBCTutorialUtilities;
        Connection myConnection = null;

        if (args[0] == null) {
            System.err.println("Properties file not specified at command line");
            return;
        } else {
            try {
                myJDBCTutorialUtilities = new DBconn2(args[0]);
            } catch (Exception e) {
                System.err.println("Problem reading properties file " + args[0]);
                e.printStackTrace();
                return;
            }
        }
        try {
            myConnection = myJDBCTutorialUtilities.getConnection();

            // Java DB does not have an SQL create database command; it does require createDatabase
//      JDBCTutorialUtilities.createDatabase(myConnection,
//                                           myJDBCTutorialUtilities.dbName,
//                                           myJDBCTutorialUtilities.dbms);
//
//      JDBCTutorialUtilities.initializeTables(myConnection,
//                                             myJDBCTutorialUtilities.dbName,
//                                             myJDBCTutorialUtilities.dbms);

            System.out.println("\nContents of SUPPLIERS table:");

            SuppliersTable.viewTable(myConnection);

        } catch (SQLException e) {
            DBconn2.printSQLException(e);
        } finally {
            DBconn2.closeConnection(myConnection);
        }
    }
}
