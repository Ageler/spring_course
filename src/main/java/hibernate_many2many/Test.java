package hibernate_many2many;

import hibernate_many2many.entity.Child;
import hibernate_many2many.entity.Section;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Child.class)
                .addAnnotatedClass(Section.class)
                .buildSessionFactory();

        Session session = null;
        try {
           /* session = factory.getCurrentSession();
            session.beginTransaction();
            Section section1 = new Section("volleyball");
            Child child1 = new Child("Nekit", 5);
            Child child2 = new Child("Vasya", 8);
            Child child3 = new Child("Kate", 10);
            section1.addChild(child1);
            section1.addChild(child2);
            section1.addChild(child3);
            session.persist(section1);
            session.getTransaction().commit();
            System.out.println("done");*/

            session = factory.getCurrentSession();
            session.beginTransaction();
            Section section = session.get(Section.class, 3);
            session.delete(section);
            session.getTransaction().commit();
            System.out.println("done");

        } finally {
            session.close();
            factory.close();
        }
    }
}
