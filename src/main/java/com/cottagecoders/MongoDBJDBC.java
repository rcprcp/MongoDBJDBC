package com.cottagecoders;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class MongoDBJDBC {

  private static final String DB_NAME = "bobdb";
  private static final String PEOPLE_COLLECTION = "people";

  // jdbc:mongodb://[username:password@]host1[:port1][,...hostN[:portN]][/[defaultauthdb][?option1=value1[&option2=value2]...]

  public static void main(String[] args) {

    MongoDBJDBC mdb = new MongoDBJDBC();
    mdb.run();
  }

  // String.format(
  //            "",
  void run() {
    String jdbcConnectionString =
        String.format(
            "jdbc:mongodb+srv://%s:%s@%s.mongodb.net",
            System.getenv("MONGODB_USERNAME"),
            System.getenv("MONGODB_PASSWORD"),
            System.getenv("MONGODB_CLUSTER_ID"));

    jdbcConnectionString =
        "jdbc:mongodb://atlas-sql-65b9b4a378435b475bd7a099-i8kej.a.query.mongodb.net/?ssl=true&authSource=admin";

    Properties p = new java.util.Properties();
    p.setProperty("database", DB_NAME);
    p.setProperty("user", System.getenv("MONGODB_USERNAME"));
    p.setProperty("password", System.getenv("MONGODB_PASSWORD"));

    try (Connection conn = DriverManager.getConnection(jdbcConnectionString, p)) {
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery("SELECT catname, count(catname)  FROM people GROUP BY catname ORDER BY catname");

      while (rs.next()) {
        System.out.println(rs.getString(1) + " " + rs.getString(2));
      }
    } catch (SQLException ex) {
      System.out.println("Exception: " + ex.getMessage());
      ex.printStackTrace();
      System.exit(2);
    }
  }
}
