package airQuality;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        // wczytanie pliku

        File fileWithData = new File("LocationCity.json");
        String jsonString = airQuality.File.fileLoading(fileWithData);
        JSONObject jsonObject = new JSONObject(jsonString);
        JSONArray array = jsonObject.getJSONArray("data");
        List<Location> locationList = new ArrayList<>();
        System.out.println(array.length());


        // pętla, która wczytuje dane z json do List<Location>
        for (int i = 0; i < array.length() - 1; i++) {

            int id = array.getJSONObject(i).getInt("id");
            String stationName = array.getJSONObject(i).getString("stationName");
            double latitude = array.getJSONObject(i).getDouble("gegrLat");
            double longitude = array.getJSONObject(i).getDouble("gegrLon");
            int cityId = array.getJSONObject(i).getJSONObject("city").getInt("id");
            String cityName = array.getJSONObject(i).getJSONObject("city").getString("name");
            String provinceName = array.getJSONObject(i).getJSONObject("city").getJSONObject("commune").getString("provinceName");

            locationList.add(new Location(id, stationName, latitude, longitude, cityId, cityName, provinceName));
        }

        for (Location o : locationList) {
            System.out.println(o);
        }
        // wywołanie metody, która doda dane do bazy danych
        List<Location> locationListAddedToDatabase = LocationRepository.addDataToDataBase(ApplicationPropertiesProvider.getAirQualityProperties(), locationList);

    }


}

