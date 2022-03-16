package cz.spsmb.b3i.w25.databaze;

import java.io.*;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;

//
// Načtěte státy z :\stemberk\verejne_zaci\staty.txt do DB
// s tabulkou, která má primární klíč (ID) INT UNSIGNED AUTOINKREMENT
// a současně použijte třídu Map<Integer, String> pro uložení vložených
// prvků. Jako klíče použijte hodnoty, které vytvořila databáze.


public class Cviceni {

    private final String dbms = "mysql";
    private final String serverName = "vydb1.spsmb.cz";
    private final int portNumber = 3306;
    private final String dbName = "student_josef.matousek_staty";
    private final String userName = "josef.matousek";
    private final String password ="Dpusl781.";
    private Connection conn;

    public void getConnectionToDatabase() throws SQLException {
        {
            if (this.dbms.equals("mysql")) {
                this.conn =
                        DriverManager.getConnection("jdbc:" + this.dbms + "://" + this.serverName +
                                ":" + this.portNumber + "/" + this.dbName, this.userName, this.password);
                this.conn.setCatalog(this.dbName);
                //Statement stmt = this.conn.createStatement();
                //stmt.executeQuery("set names utf8;");
            }
            System.out.println("Connected to database");
        }
    }

    public long insertState(String nazev, String kod) throws SQLException {
        long returnValue;
        try (
                PreparedStatement statement = this.conn.prepareStatement(
                        "INSERT INTO staty (nazev, kod) VALUES (?,?);",
                        Statement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, nazev);
            statement.setString(2, kod);
            // ...

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    returnValue = generatedKeys.getLong(1);
                } else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        }
        return returnValue;
    }

    public static void main(String[] args) throws IOException, SQLException {
        //  Class.forName("com.mysql.jdbc.Driver");
        Cviceni cviceni = new Cviceni();
        cviceni.getConnectionToDatabase();
        FileReader fr = new FileReader("Y:\\stemberk\\verejne_zaci\\staty.txt");
        BufferedReader in = new BufferedReader(fr);
        String radka;

        Map<Integer, String> staty = new HashMap<>();

        while ((radka = in.readLine()) != null) {
            //System.out.println(radka);
            String nazev = radka.substring(0, radka.indexOf(' '));
            String kod =  radka.substring(radka.lastIndexOf(' ') + 1);
            System.out.format("%s,%s%n",nazev, kod);
            long id = cviceni.insertState(nazev, kod);
            staty.put((int)id, nazev);
        }

        staty.forEach(new BiConsumer<Integer, String>() {
            @Override
            public void accept(Integer integer, String s) {
                System.out.println(integer + s);
            }
        });


        fr.close();
    }
}
