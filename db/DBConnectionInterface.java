package db;

import java.util.List;

import model.Employe;

public interface DBConnectionInterface {

  int saveToDB(Employe employe);

  Employe getEmployeById(int id);

  int deleteEmployeById(int id);

  int updateEmploye(Employe employe);

  List<Employe> getAllEmployes();

}
