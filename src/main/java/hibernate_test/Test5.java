package hibernate_test;

import hibernate_test.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test5 {
    public static void main(String[] args) {
        SessionFactory sessionFactory =
                new Configuration().configure("hibernate.cfg.xml")
                        .addAnnotatedClass(Employee.class).buildSessionFactory();
        try {
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("delete Employee where name = 'Oleg'").executeUpdate();
            session.getTransaction().commit();
            System.out.println("done");
        } finally {
            sessionFactory.close();
        }
    }
}
