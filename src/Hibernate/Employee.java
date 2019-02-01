package Hibernate;

import javax.persistence.*;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
@Table(name="Employee")

public class Employee {

    @Id
    @GeneratedValue(strategy = IDENTITY )
    @Column(name="EmployeeID")
    private int employeeId;

    @Column(name="EmployeeDept")
    private String employeeDept;

    @Column(name="EmployeeBusinessPhone")
    private String employeeBusinessPhone;

    @Column(name="EmployeeTitle")
    private String employeeTitle;

    // empty constructor
    public Employee() {
    }

    /* parameterized constructor
        /* it does not include Id because that’s
        /* a value assigned by the database */
    public Employee(String employeeDept, String employeeBusinessPhone, String employeeTitle) {
        this.employeeDept = employeeDept;
        this.employeeBusinessPhone = employeeBusinessPhone;
        this.employeeTitle = employeeTitle;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeDept() {
        return employeeDept;
    }

    public void setEmployeeDept(String employeeDept) {
        this.employeeDept = employeeDept;
    }

    public String getEmployeeBusinessPhone() {
        return employeeBusinessPhone;
    }

    public void setEmployeeBusinessPhone(String employeeBusinessPhone) {
        this.employeeBusinessPhone = employeeBusinessPhone;
    }

    public String getEmployeeTitle() {
        return employeeTitle;
    }

    public void setEmployeeTitle(String employeeTitle) {
        this.employeeTitle = employeeTitle;
    }

    // not strictly required but it may come in handy


    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", employeeDept=" + employeeDept +
                ", employeeBusinessPhone=" + employeeBusinessPhone +
                ", employeeTitle=" + employeeTitle +
                '}';
    }
}
