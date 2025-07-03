package model;

public class Employe {
  private int id;
  private String name;
  private Double salary;
  private String designation;

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Double getSalary() {
    return salary;
  }

  public String getDesignation() {
    return designation;
  }

  public Employe(Builder builder) {
    this.id = builder.id;
    this.name = builder.name;
    this.salary = builder.salary;
    this.designation = builder.designation;
  }

  public Employe() {
  }

  public static class Builder {
    private int id;
    private String name;
    private Double salary;
    private String designation;

    public Builder setId(int id) {
      this.id = id;
      return this;
    }

    public Builder setName(String name) {
      this.name = name;
      return this;
    }

    public Builder setSalary(Double salary) {
      this.salary = salary;
      return this;
    }

    public Builder setDesignation(String designation) {
      this.designation = designation;
      return this;
    }

    public Employe build() {
      return new Employe(this);
    }

  }

}
