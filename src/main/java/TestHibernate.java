import org.hibernate.Session;

/**
 * Created by Влад on 14.07.2016.
 */
public class TestHibernate {

    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        EmployeeEntity ee = new EmployeeEntity();
        ee.setEmail("standart@mail.com");
        ee.setFirstName("Max");
        ee.setLastName("Fitcher");

        session.save(ee);

        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
