package airQuality;

import jakarta.persistence.*;

import java.util.List;
import java.util.Properties;

public class LocationRepository {

    // załadowanie danych do bazy danych
    //load data into database
    public  static List<Location> addDataToDataBase (Properties properties, List<Location> locations){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("airQuality", properties);
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            locations.forEach(location -> entityManager.persist(location));
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);

        } finally {
            entityManagerFactory.close();
        }


        return locations;
    }

    public static int getUserChoice (String cityName, Properties properties){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("airQuality", properties);
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        try {

            List<Integer> result;
           Query query = entityManager.createQuery(
                    " SELECT id FROM Location location WHERE location.cityName LIKE :cityName");

            query.setParameter("cityName", cityName);

            result = query.getResultList();


            int xx = result.get(0);

            return xx;

        } finally {
            entityManagerFactory.close();
        }
    }


}
