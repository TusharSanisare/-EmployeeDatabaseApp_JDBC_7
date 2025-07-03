import java.util.Scanner;

import db.saveToMysql;
import service.EmpService;

class Main {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    EmpService empService = new EmpService(new saveToMysql());

    System.out.println(" Employee Database Application");

    while (true) {
      System.out.println(
          "\nPress '1':ADD \t '2':SEARCH EMPLOYE \t '3':UPDATE \t '4':DELETE \t '5':'VIEW ALL EMPLOYES' \t '0':Exit");
      System.out.print("Choose an option: ");
      int choice = sc.nextInt();
      sc.nextLine();

      switch (choice) {
        case 1:
          empService.saveEmp();
          break;
        case 2:
          empService.printEmp();
          break;
        case 3:
          empService.updateEmp();
          break;
        case 4:
          empService.deleteEmp();
          break;
        case 5:
          empService.printAllEmp();
          break;
        case 0:
          System.exit(0);
          break;
        default:
          System.out.println("Invalid choice.");
      }
    }

  }
}
