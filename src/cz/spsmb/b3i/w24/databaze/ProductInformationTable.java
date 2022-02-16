package cz.spsmb.b3i.w24.databaze;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductInformationTable {
    private String dbName;
    private Connection con;
    private String dbms;

    public ProductInformationTable(Connection connArg, String dbNameArg, String dbmsArg) {
        super();
        this.con = connArg;
        this.dbName = dbNameArg;
        this.dbms = dbmsArg;
    }

    public void populateTable(String fileName) throws SQLException,
            ParserConfigurationException,
            SAXException, IOException,
            XPathExpressionException {
        javax.xml.parsers.DocumentBuilderFactory factory =
                javax.xml.parsers.DocumentBuilderFactory.newInstance();
        // factory.setNamespaceAware(true);
        factory.setNamespaceAware(true);
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(fileName);
        XPathFactory xPathfactory = XPathFactory.newInstance();
        XPath xPath = xPathfactory.newXPath();
        NodeList nodes = (NodeList) xPath.evaluate(
                "/coffee-product-information/item[coffee = 'Columbian']",
                doc,
                XPathConstants.NODESET);

        for (int i = 0; i < nodes.getLength(); i++) {
            Node currentNode = nodes.item(i);
            // Retrieve the description element
            currentNode.normalize();
            if (currentNode == null) {
                System.out.println("Current node is null");
            }
//      System.out.println(currentNode.getTextContent());
            Node descriptionNode = (Node) xPath.evaluate(
                    "description",
                    currentNode,
                    XPathConstants.NODE);

            if (descriptionNode == null) {
                System.out.println("DescriptionNode is null");
            } else {
                System.out.println(descriptionNode.getTextContent());
                NodeList descriptionNodeChildren = descriptionNode.getChildNodes();
                System.out.println("Description node has " + descriptionNodeChildren.getLength() + " child nodes");
                Node descNodeChild = descriptionNode.getFirstChild();
                System.out.println("Only child node type: " + descNodeChild.getNodeType());
            }
//      System.out.println("Description: " + descriptionNode.getNodeValue());
            // System.out.println(nodes.item(i).getNodeValue());
        }

    }

    public void createTable() throws SQLException {
        String createString = "create table PRODUCT_INFORMATION" +
                "  (COF_NAME varchar(32) NOT NULL," +
                "  INFO clob NOT NULL," +
                "  FOREIGN KEY (COF_NAME) REFERENCES COFFEES (COF_NAME))";
        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate(createString);
        } catch (SQLException e) {
            DBconn2.printSQLException(e);
        }
    }

    public void dropTable() throws SQLException {

        try (Statement stmt = con.createStatement()) {
            if (this.dbms.equals("mysql")) {
                stmt.executeUpdate("DROP TABLE IF EXISTS PRODUCT_INFORMATION");
            } else if (this.dbms.equals("derby")) {
                stmt.executeUpdate("DROP TABLE PRODUCT_INFORMATION");
            }
        } catch (SQLException e) {
            DBconn2.printSQLException(e);
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
                dBconn2 = new DBconn2(args[0]);
            } catch (Exception e) {
                System.err.println("Problem reading properties file " + args[0]);
                e.printStackTrace();
                return;
            }
        }

        try {
//      myConnection = myJDBCTutorialUtilities.getConnection();

            // Java DB does not have an SQL create database command; it does require createDatabase
      /*
      JDBCTutorialUtilities.createDatabase(myConnection,
                                           myJDBCTutorialUtilities.dbName,
                                           myJDBCTutorialUtilities.dbms);

      JDBCTutorialUtilities.initializeTables(myConnection,
                                             myJDBCTutorialUtilities.dbName,
                                             myJDBCTutorialUtilities.dbms);
      */


            ProductInformationTable myProductInformationTable =
                    new ProductInformationTable(myConnection, dBconn2.dbName,
                            dBconn2.dbms);

            myProductInformationTable.populateTable("xml/coffee-information.xml");

        } catch (SQLException e) {
            DBconn2.printSQLException(e);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        finally {
            DBconn2.closeConnection(myConnection);
        }
    }
}
