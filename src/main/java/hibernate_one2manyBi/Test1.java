package hibernate_one2manyBi;

import hibernate_one2manyBi.entity.Department;
import hibernate_one2manyBi.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Department.class)
                .buildSessionFactory();
        Session session = null;
        try {
           /* session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Department department = new Department("Sales",
                    300, 1500);
            Employee ivan = new Employee("Ivan", "Ivanov",
                    1500);
            Employee sergey = new Employee("Sergey", "Korshunov",
                    1500);
            Employee employee3 = new Employee("Anton", "Sidorov", 700);
            department.addEmployeeToDepartment(ivan);
            department.addEmployeeToDepartment(sergey);
            department.addEmployeeToDepartment(employee3);
            session.save(department);
            session.getTransaction().commit();*/

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            System.out.println("get department");
            Department department = session.get(Department.class, 7);
            System.out.println("show department");
            System.out.println(department);
            System.out.println("show employees of the department");
            System.out.println(department.getEmployees());
            session.getTransaction().commit();

           /* session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, 1);
            System.out.println(employee.getDepartment());
            session.getTransaction().commit();*/

            /*session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Employee employee = session.get(Employee.class, 1);
            session.delete(employee);
            session.getTransaction().commit();*/

        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
