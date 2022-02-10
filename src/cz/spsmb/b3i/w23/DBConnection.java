package cz.spsmb.b3i.w23;
//Balíček java.sql.* umožňuje spojení s DB
//Java Database Connectivity (známé spíše jako JDBC) je Java API, které definuje jednotné rozhraní pro přístup
// k relačním databázím. JDBC je součástí Javy SE („Standard Edition“) od JDK 1.1.
// Pro přístup ke konkrétnímu databázovému serveru je potřeba JDBC driver (ovladač),
// který poskytuje tvůrce databázového serveru.
// https://docs.oracle.com/en/java/javase/17/docs/api/index.html
// #stáhnout driver: https://dev.mysql.com/downloads/connector/j/5.0.html
// #https://stackoverflow.com/questions/30651830/use-jdbc-mysql-connector-in-intellij-idea
//File->Project Structure->Libraries, Maven,  mysql:mysql-connector-java:5.1.40

import java.sql.*;

public class DBConnection {
    private final String dbms="mysql";
    private final String serverName = "vydb1.spsmb.cz";
    private final int portNumber = 3306;
    private final String dbName = "ucitelverejne_stemberk_test01";
    private final String userName="stemberk";
    private final String password="";
    private Connection conn;
    public void getConnectionToDatabase() throws SQLException {
        {
            if (this.dbms.equals("mysql")) {
                this.conn =
                        DriverManager.getConnection("jdbc:" + this.dbms + "://" + this.serverName +
                                ":" + this.portNumber + "/" + this.dbName, this.userName, this.password);
                this.conn.setCatalog(this.dbName);
            }
            System.out.println("Connected to database");
        }
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            DBConnection dbConnection = new DBConnection();
            dbConnection.getConnectionToDatabase();
            Statement stmt = dbConnection.conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from vyrobky");
            while (rs.next())
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            dbConnection.conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
