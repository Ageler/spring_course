package hibernate_one2one;

import hibernate_one2one.entity.Detail;
import hibernate_one2one.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test2 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Detail.class)
                .buildSessionFactory();
        Session session = null;
        try {
          session = sessionFactory.getCurrentSession();
            /*Employee employee = new Employee("Nikolai", "Ivanov",
                    "HR", 850);
            Detail detail = new Detail("New York", "14340340211",
                    "nikola@bk.ru");
            employee.setEmpDetail(detail);
            detail.setEmployee(employee);*/
            session.beginTransaction();
            Detail detail = session.get(Detail.class, 1);
            detail.getEmployee().setEmpDetail(null);
            session.delete(detail);
            session.getTransaction().commit();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
