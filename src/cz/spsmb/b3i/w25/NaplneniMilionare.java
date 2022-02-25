package cz.spsmb.b3i.w25;

import java.sql.*;

public class NaplneniMilionare {
//File->Project Structure->Libraries, Maven,  mysql:mysql-connector-java:5.1.40
    private final String dbms="mysql";
    private final String serverName = "elektrovit.cz";
    private final int portNumber = 3306;
    private final String dbName = "student_josef.matousek_milionar";
    private final String userName="matousek";
    private final String password="milion85";
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

    public long insertQuestion(int obtiznost_id, String question, long spravna_odpoved) throws SQLException {
        long returnValue;
        try (
                PreparedStatement statement = this.conn.prepareStatement(
                        "INSERT INTO otazky (obtiznost_id, nazev, spravna_odpoved) VALUES (?,?,?);",
                        Statement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, String.valueOf(obtiznost_id));
            statement.setString(2, question);
            statement.setString(3, String.valueOf(spravna_odpoved));
            // ...

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    returnValue = generatedKeys.getLong(1);
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        }
        return returnValue;
    }
    public long insertAnswer(String answer) throws SQLException {
        long returnValue;
        try (
                PreparedStatement statement = this.conn.prepareStatement(
                        "INSERT INTO odpovedi (nazev) VALUES (?);",
                        Statement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, answer);
            // ...

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    returnValue = generatedKeys.getLong(1);
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        }
        return returnValue;
    }
    public long insertWrongAnswerMap(long question, long answer) throws SQLException {
        long returnValue;
        try (
                PreparedStatement statement = this.conn.prepareStatement(
                        "INSERT INTO otazky_spatne_odpovedi (otazka_id, odpoved_id) VALUES (?,?);",
                        Statement.RETURN_GENERATED_KEYS);
        ) {
            statement.setString(1, String.valueOf(question));
            statement.setString(2, String.valueOf(answer));
            // ...

            int affectedRows = statement.executeUpdate();

            if (affectedRows == 0) {
                throw new SQLException("Creating user failed, no rows affected.");
            }

            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    returnValue = generatedKeys.getLong(1);
                }
                else {
                    throw new SQLException("Creating user failed, no ID obtained.");
                }
            }
        }
        return returnValue;
    }

    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            NaplneniMilionare dbConnection = new NaplneniMilionare();
            dbConnection.getConnectionToDatabase();
            Statement stmt = dbConnection.conn.createStatement();
            String[][] q = Questions.question1();
            for (int i = 0; i < q.length; i++) {
                //vložení správné odpovědí - index 1:
                long answerId = dbConnection.insertAnswer(q[i][1]);
                //vložení otázky - index 0
                long questionId = dbConnection.insertQuestion(1, q[i][0], answerId);
                //vložení špatných odpovědí
                for (int j = 2; j <= 4 ; j++) {
                    answerId = dbConnection.insertAnswer(q[i][j]);
                    dbConnection.insertWrongAnswerMap(questionId, answerId);
                }

            }
            //ResultSet rs = stmt.executeQuery("select * from vyrobky");
            //while (rs.next())
            //    System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3));
            dbConnection.conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
