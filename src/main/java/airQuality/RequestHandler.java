package airQuality;

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

        } else if (choice == 3) {

        } else if (choice == 4) {

        } else if (choice == 5) {

        } else if (choice == 6) {

        } else if (choice == 7) {

        } else if (choice == 8) {

        } else if (choice == 9) {

        } else if (choice > 10 || choice < 1) {
            System.out.println("Nieprawidłowy wybór, spróbuj ponownie");
        }
    }
}
