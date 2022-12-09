package airQuality;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Properties;

public class AirQualityIndexRepository {

    public  static List<AirQualityIndex> addMeasurementsToDataBase (Properties properties, List<AirQualityIndex> airQualityIndex){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("airQuality", properties);
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

}


