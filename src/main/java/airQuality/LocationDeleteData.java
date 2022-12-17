package airQuality;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class LocationDeleteData {

    public void deleteDataLocationsFromDataBase() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("airQuality", ApplicationPropertiesProvider.getAirQualityProperties());
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        try {
            entityManager.getTransaction().begin();
            entityManager.createQuery(" DELETE FROM Location").executeUpdate();

            entityManager.getTransaction().commit();
        } finally {
            entityManagerFactory.close();
        }

    }
}
