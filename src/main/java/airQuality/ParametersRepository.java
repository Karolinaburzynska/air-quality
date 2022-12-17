package airQuality;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class ParametersRepository {

    public static void addDataToDataBase(List<Parameters> parameters) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("airQuality", ApplicationPropertiesProvider.getAirQualityProperties());
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            parameters.forEach(parameter -> entityManager.persist(parameter));
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);

        } finally {
            entityManagerFactory.close();
        }

        System.out.println(parameters);

    }


    public static void deleteDataParametersFromDataBase() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("airQuality", ApplicationPropertiesProvider.getAirQualityProperties());
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery(" DELETE FROM Parameters").executeUpdate();

            entityManager.getTransaction().commit();
        } finally {
            entityManagerFactory.close();
        }

    }
}





