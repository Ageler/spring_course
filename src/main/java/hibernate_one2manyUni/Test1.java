package hibernate_one2manyUni;

import hibernate_one2manyUni.entity.Department;
import hibernate_one2manyUni.entity.Employee;
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
          session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Department department = new Department("HR",
                    500, 1000);
            Employee andrew = new Employee("qqq", "zzz",
                    600);
            Employee nikita = new Employee("lll", "kkk",
                    700);
            department.addEmployeeToDepartment(andrew);
            department.addEmployeeToDepartment(nikita);
            session.save(department);
            session.getTransaction().commit();

         /*   session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            Department department = session.get(Department.class, 1);
            System.out.println(department);
            System.out.println(department.getEmployees());
            session.getTransaction().commit();*/

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
