package airQuality;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

import java.util.List;
import java.util.Properties;

public class Calculate {

    Parameters parameters = new Parameters();
    ParametersRepository parametersRepository = new ParametersRepository();
    Location location = new Location();

    public static List<String> showChemicalCompoundsInCity(int stationId) {

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("airQuality", ApplicationPropertiesProvider.getAirQualityProperties());
        EntityManager entityManager = entityManagerFactory.createEntityManager();



        try {

            List <String> result;
            Query query = entityManager.createQuery(
                    " SELECT parameterName FROM Parameters parameters WHERE parameters.stationId LIKE :stationId");

            query.setParameter("stationId", stationId);

            result = query.getResultList();

            System.out.println(result);
            return result;


        } finally {
            entityManagerFactory.close();
        }
    }


    }


