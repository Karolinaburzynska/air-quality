package airQuality;

import java.util.List;


public class Main {
    public static void main(String[] args) {

        RequestHandler handler = new RequestHandler();
        LocationLoadData locationLoadData = new LocationLoadData();
        LocationDeleteData locationDeleteData = new LocationDeleteData();
        boolean start = true;

        //loading location data to database
        List<Location> locationListAddedToDatabase = LocationRepository.addDataToDataBase(ApplicationPropertiesProvider.getAirQualityProperties(), locationLoadData.loadData());

        while (start) {

            GUI.showMenu();
            int choice = GUI.getUserChoice();
            handler.userChoice(choice);
            if(choice == 10){
                locationDeleteData.deleteDataLocationsFromDataBase();
                start = false;
            }
        }
    }
}






