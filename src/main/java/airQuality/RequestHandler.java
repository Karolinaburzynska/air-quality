package airQuality;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RequestHandler {

    public void userChoice(int choice) {

        Scanner scanner = new Scanner(System.in);

            if (choice == 1) {

                System.out.println("Proszę podać miasto:");
                String city = scanner.nextLine();

                List<Parameters> xxx = ParametersConnection.parametersList(LocationRepository.findCityId(city));
                ParametersRepository.addDataToDataBase(xxx);
                System.out.println("Związki chemiczne znajdujące się w powietrzu dla wybranego miasta" + LocationRepository.findParameters());
                ParametersRepository.deleteDataParametersFromDataBase();

            } else if (choice == 2) {

                System.out.println("Proszę podać miasto:");
                String city = scanner.nextLine();

                List<Integer> idCitiesList = LocationRepository.findCityId(city);
                List<AirQualityIndex> cityIndex = AirQualityIndexConnection.airQualityIndex(idCitiesList.get(0));
                AirQualityIndexRepository.addMeasurementsToDataBase(cityIndex);

                System.out.println("Jakość powietrza dla miasta " + city + " to: " + AirQualityIndexRepository.findParameters());
                AirQualityIndexRepository.deleteDataParametersFromDataBase();


            } else if (choice > 3 || choice < 1) {
                System.out.println("Nieprawidłowy wybór, spróbuj ponownie");

            }
    }
}
