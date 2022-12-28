package airQuality;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class AirQualityIndexRepository {

    public  static List<AirQualityIndex> addMeasurementsToDataBase (List<AirQualityIndex> airQualityIndex){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("airQuality", ApplicationPropertiesProvider.getAirQualityProperties());
        EntityManager entityManager = entityManagerFactory.createEntityManager();



        try {
            entityManager.getTransaction().begin();
            airQualityIndex.forEach(airQualityIndex1 -> entityManager.persist(airQualityIndex1));
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);

        } finally {
            entityManagerFactory.close();
        }


        return airQualityIndex;
    }


    public static List<String> findParameters(){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("airQuality", ApplicationPropertiesProvider.getAirQualityProperties());
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        List<String> result = new ArrayList<>();

        try {

            Query query = entityManager.createQuery("FROM AirQualityIndex");

            result = query.getResultList();

        } finally {
            entityManagerFactory.close();
        }
        return result;
    }

    public static void deleteDataParametersFromDataBase() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("airQuality", ApplicationPropertiesProvider.getAirQualityProperties());
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery(" DELETE FROM AirQualityIndex").executeUpdate();

            entityManager.getTransaction().commit();
        } finally {
            entityManagerFactory.close();
        }

    }

}


