package Hibernate;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class HiberMain {

    public static void runHiber(){

        // create the session manager
        SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Employee.class).addAnnotatedClass(EmployeePrivate.class).buildSessionFactory();

        // create a Session object to establish the connection with the database
        Session session = factory.getCurrentSession();

        System.out.println("\n-------------------------------------\n"
                          +"Hibernate - Object Relational Mapping\n"
                          +"-------------------------------------\n");

        try {
            // create new Employee objects tht will be mapped as records in the DB
            Employee emp1 = new Employee("IT", "080-9998877", "DB Admin");
            Employee emp2 = new Employee("HR", "080-9998866", "HR Coordinator");
            Employee emp3 = new Employee("Marketing", "080-9998855", "Consultant");
            Employee emp4 = new Employee("IT", "080-9998811", "Support Technician");

            EmployeePrivate emp1private = new EmployeePrivate("999-3535-934", "333 Frye Ave, 85225 AZ", 3500);
            EmployeePrivate emp2private = new EmployeePrivate("999-1525-765", "65 Galveston Road, 85225 AZ", 2750);
            EmployeePrivate emp3private = new EmployeePrivate("999-1120-553", "2000 Chandler Road, 85225 AZ", 2950);
            EmployeePrivate emp4private = new EmployeePrivate("999-1120-309", "35 Del Rio Street, 85225 AZ", 1950);

            emp1private.setEmployee(emp1);
            emp2private.setEmployee(emp2);
            emp3private.setEmployee(emp3);
            emp4private.setEmployee(emp4);


            // provisional saving
            session.beginTransaction();
            session.save(emp1private);
            session.save(emp2private);
            session.save(emp3private);
            session.save(emp4private);

            System.out.println("Adding the following records to the database:\n");

            // retrieve back records - NOTE: the IDE underlines in red the word Employee but it works! :)
            Query allEmp = session.createQuery("from Employee");
            List<Employee> employees = allEmp.getResultList();

            // commit the changes
            session.getTransaction().commit();

            // iterate through
            for(Employee e : employees){
                System.out.println("Employee id: "+e.getEmployeeId()
                                  +", Department: "+ e.getEmployeeDept()
                                  +", Title: " +e.getEmployeeTitle()
                                  +"\n");
            }

        } finally {
            session.close();
            factory.close();
        }

        // Exiting
        System.out.println("\nGoing back to the selection menu...");

    }
}
