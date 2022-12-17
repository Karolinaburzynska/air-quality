package airQuality;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class LocationRepository {

 
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

    public static List<Integer> findCityId (String cityName){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("airQuality", ApplicationPropertiesProvider.getAirQualityProperties());
        EntityManager entityManager = entityManagerFactory.createEntityManager();


        try {

            List<Integer> result;
           Query query = entityManager.createQuery(
                    " SELECT id FROM Location location WHERE location.cityName LIKE :cityName");

            query.setParameter("cityName", cityName);

            result = query.getResultList();

            return result;

        } finally {
            entityManagerFactory.close();
        }
    }


    public static List<String> findParameters(){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("airQuality", ApplicationPropertiesProvider.getAirQualityProperties());
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<String> result = new ArrayList<>();

        try {

                Query query = entityManager.createQuery("SELECT parameterName FROM Parameters");

                        result = query.getResultList();

        } finally {
            entityManagerFactory.close();
        }
        return result;
    }
}
