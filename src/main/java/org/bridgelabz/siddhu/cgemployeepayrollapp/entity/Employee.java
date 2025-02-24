package org.bridgelabz.siddhu.cgemployeepayrollapp.entity;






public class Employee {

    private Long id;
    private String name;
    private double salary;
    public Employee( Long id,String name, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}
