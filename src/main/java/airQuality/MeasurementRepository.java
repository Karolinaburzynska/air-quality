package airQuality;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.List;
import java.util.Properties;

public class MeasurementRepository {

    public  static List<Measurement> addMeasurementsToDataBase (Properties properties, List<Measurement> measurements){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("airQuality", properties);
        EntityManager entityManager = entityManagerFactory.createEntityManager();



        try {
            entityManager.getTransaction().begin();
            measurements.forEach(measurement -> entityManager.persist(measurement));
            entityManager.getTransaction().commit();

        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);

        } finally {
            entityManagerFactory.close();
        }


        return measurements;
    }

}
