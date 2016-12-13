import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 * Created by Влад on 13.07.2016.
 */
public class HibernateUtil {

    private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try{

//            SessionFactory sf = new AnnotationConfiguration().configure().buildSessionFactory();
//            Session session = sf.openSession();

            Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
//            StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
            sessionFactory = configuration.configure().buildSessionFactory();
            return sessionFactory;
        }catch (Exception ex){
            System.err.println("Exception of initializer");
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static void shutdown(){
        getSessionFactory().close();
    }

}
