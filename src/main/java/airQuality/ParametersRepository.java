package airQuality;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Properties;

public class ParametersRepository {

    public  static List<Parameters> addDataToDataBase (Properties properties, List<Parameters> parameters){
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("airQuality", properties);
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


        return parameters;
    }



}
