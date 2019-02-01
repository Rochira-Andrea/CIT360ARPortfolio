package Hibernate;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name="EmployeePrivate")

public class EmployeePrivate {

    @Id
    @GeneratedValue(generator = "newgenerator")
    @GenericGenerator(name="newgenerator",strategy="foreign",parameters = { @org.hibernate.annotations.Parameter(value="employee",name="property")})
    @Column(name="EmployeeID")
    private int employeeId;

    @Column(name = "EmployeeSocialSecurity")
    private String empSSN;

    @Column(name = "EmployeeAddress")
    private String empAddress;

    @Column(name = "EmployeeSalary")
    private double empSalary;

    // empty constructor
    public EmployeePrivate() {
    }

    // parameterized constructor
    public EmployeePrivate(String empSSN, String empAddress, double empSalary) {
        this.empSSN = empSSN;
        this.empAddress = empAddress;
        this.empSalary = empSalary;
    }

    // establish one-to-one relation with Employee class
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "EmployeeID")
    private Employee employee;

    public Employee getEmployee(){
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    // getters & setters of EmployeePrivate
    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmpSSN() {
        return empSSN;
    }

    public void setEmpSSN(String empSSN) {
        this.empSSN = empSSN;
    }

    public String getEmpAddress() {
        return empAddress;
    }

    public void setEmpAddress(String empAddress) {
        this.empAddress = empAddress;
    }

    public double getEmpSalary() {
        return empSalary;
    }

    public void setEmpSalary(double empSalary) {
        this.empSalary = empSalary;
    }
}
