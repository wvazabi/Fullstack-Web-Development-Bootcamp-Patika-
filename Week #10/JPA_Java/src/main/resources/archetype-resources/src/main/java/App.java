package $dev.wasabiTech;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        // database connection jakarta üzerinden gelen kodlar veri tabanına bağlanırken hangi ayarları kullanalım
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("market");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        System.out.println("test");
}
