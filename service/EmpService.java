package service;

import java.util.List;
import java.util.Scanner;

import db.DBConnectionInterface;
import model.Employe;

public class EmpService {

  private DBConnectionInterface db;
  private static Scanner sc = new Scanner(System.in);

  public EmpService(DBConnectionInterface db) {
    this.db = db;
  }

  public void saveEmp() {
    System.out.print("Enter name: ");
    String name = sc.nextLine();
    System.out.print("Enter designation: ");
    String designation = sc.nextLine();
    System.out.print("Enter salary: ");
    double salary = sc.nextDouble();
    sc.nextLine();

    Employe e = new Employe.Builder().setName(name).setSalary(salary).setDesignation(designation).build();

    int status = db.saveToDB(e);

    if (status != 0)
      System.out.println("Employee saved to database successfully..");
    else
      System.out.println("Oppss.. somthing went wrong!!!");
  }

  public void printEmp() {
    System.out.print("Enter Employee ID: ");
    int id = sc.nextInt();
    sc.nextLine();

    Employe e = db.getEmployeById(id);

    if (e == null) {
      System.out.println("Oppss.. somthing went wrong!!!");
      return;
    }

    System.out.println("ID: " + e.getId() + " | NAME: " + e.getName() + " | SALARY: " + e.getSalary()
        + " | DESIGNATION: " + e.getDesignation());

  }

  public void printAllEmp() {
    List<Employe> list = db.getAllEmployes();

    if (list == null) {
      System.out.println("Oppss.. somthing went wrong!!!");
      return;
    }

    int sno = 1;
    for (Employe e : list) {
      System.out.println(sno + "." + " ID: " + e.getId() + " | NAME: " + e.getName() + " | SALARY: " + e.getSalary()
          + " | DESIGNATION: " + e.getDesignation());
      sno++;
    }
  }

  public void updateEmp() {
    System.out.print("Enter Employee ID: ");
    int id = sc.nextInt();
    sc.nextLine();
    System.out.print("Enter new name: ");
    String name = sc.nextLine();
    System.out.print("Enter new designation: ");
    String designation = sc.nextLine();
    System.out.print("Enter new salary: ");
    double salary = sc.nextDouble();
    sc.nextLine();

    Employe e = new Employe.Builder().setId(id).setName(name).setSalary(salary).setDesignation(designation).build();

    int status = db.updateEmploye(e);

    if (status != 0)
      System.out.println("Employee updated successfully..");
    else
      System.out.println("Oppss.. somthing went wrong!!!");
  }

  public void deleteEmp() {
    System.out.print("Enter Employee ID: ");
    int id = sc.nextInt();
    sc.nextLine();

    int status = db.deleteEmployeById(id);

    if (status != 0)
      System.out.println("Employee deleted from database successfully..");
    else
      System.out.println("Oppss.. somthing went wrong!!!");
  }

}
