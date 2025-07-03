package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Employe;

public class saveToMysql implements DBConnectionInterface {

  private static final String USER = "root";
  private static final String PASS = "tusharsql";
  private static final String DB_URL = "jdbc:mysql://localhost:3306/employee_db";
  private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
  private static Connection conn;

  static {
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/employee_db", "root", "tusharsql");
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // public saveToMysql() {
  // try {
  // Class.forName(DRIVER);
  // conn = DriverManager.getConnection(DB_URL, USER, PASS);
  // } catch (Exception e) {
  // e.printStackTrace();
  // }
  // }

  @Override
  public int saveToDB(Employe employe) {
    try {
      String query = "INSERT INTO employees (name, designation, salary) VALUES (?, ?, ?)";
      PreparedStatement ps = conn.prepareStatement(query);

      ps.setString(1, employe.getName());
      ps.setString(2, employe.getDesignation());
      ps.setDouble(3, employe.getSalary());
      int rows = ps.executeUpdate();
      return rows;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return 0;
  }

  @Override
  public Employe getEmployeById(int id) {
    try {
      String query = "SELECT * FROM employees where id=?";
      PreparedStatement ps = conn.prepareStatement(query);
      ps.setInt(1, id);
      ResultSet rs = ps.executeQuery();

      if (rs.next()) {
        Employe e = new Employe.Builder()
            .setId(rs.getInt("id"))
            .setName(rs.getString("name"))
            .setDesignation(rs.getString("designation"))
            .setSalary(rs.getDouble("salary"))
            .build();

        return e;
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return null;
  }

  @Override
  public int deleteEmployeById(int id) {
    try {
      String query = "DELETE FROM employees WHERE id=?";
      PreparedStatement ps = conn.prepareStatement(query);
      ps.setInt(1, id);
      int rows = ps.executeUpdate();
      return rows;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return 0;
  }

  @Override
  public int updateEmploye(Employe employe) {
    try {
      String query = "UPDATE employees SET name=?, designation=?, salary=? WHERE id=?";
      PreparedStatement ps = conn.prepareStatement(query);
      ps.setString(1, employe.getName());
      ps.setString(2, employe.getDesignation());
      ps.setDouble(3, employe.getSalary());
      ps.setInt(4, employe.getId());
      int rows = ps.executeUpdate();
      return rows;
    } catch (Exception e) {
      e.printStackTrace();
    }
    return 0;
  }

  @Override
  public List<Employe> getAllEmployes() {
    List<Employe> li = new ArrayList<>();
    try {
      String query = "SELECT * FROM employees";
      PreparedStatement ps = conn.prepareStatement(query);
      ResultSet rs = ps.executeQuery();

      while (rs.next()) {
        Employe e = new Employe.Builder()
            .setId(rs.getInt("id"))
            .setName(rs.getString("name"))
            .setDesignation(rs.getString("designation"))
            .setSalary(rs.getDouble("salary"))
            .build();

        li.add(e);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
    return li;
  }

}
