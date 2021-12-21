package hibernate_one2one;

import hibernate_one2one.entity.Detail;
import hibernate_one2one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test1 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;
        try {
          session = sessionFactory.getCurrentSession();
           /* Employee employee = new Employee("Andrew", "Borchenko",
                    "IT", 500);
            Detail detail = new Detail("Baku", "123456789",
                    "andrei-borchenko@mail.ru");
            employee.setEmpDetail(detail);*/

            session.beginTransaction();
            Employee employee = session.get(Employee.class, 1);
            System.out.println(employee.getEmpDetail());
            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
