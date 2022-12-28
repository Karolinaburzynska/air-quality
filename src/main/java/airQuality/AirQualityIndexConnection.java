package airQuality;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AirQualityIndexConnection {
    public static JSONObject getDateAndValues(int id) {

        try {

            URL url = new URL("https://api.gios.gov.pl/pjp-api/rest/aqindex/getIndex/" + id);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();

            if (responseCode != 200) {
                throw new RuntimeException("HttpResponseCode: " + responseCode);
            } else {

                StringBuilder informationString = new StringBuilder();
                Scanner scanner = new Scanner(url.openStream());

                while (scanner.hasNext()) {
                    informationString.append(scanner.nextLine());
                }

                scanner.close();
                JSONParser parser = new JSONParser();
                Object obj = parser.parse(String.valueOf(informationString));


                return (JSONObject) obj;
            }

        } catch (
                Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    // wczytanie danych z powyższego do zmiennych
    public static List<AirQualityIndex> airQualityIndex(int userChoice) {

        List<AirQualityIndex> airQualityList = new ArrayList<>();

        org.json.JSONObject obj = new org.json.JSONObject(getDateAndValues(userChoice));

        int id = obj.getInt("id");
        String so2IndexLevelName;
        if (obj.has("so2IndexLevel")) {
            so2IndexLevelName = obj.getJSONObject("so2IndexLevel").getString("indexLevelName");
        } else {
            so2IndexLevelName = null;
        }

        String stIndexLevelName = obj.getJSONObject("stIndexLevel").getString("indexLevelName");
        String no2IndexLevelName = obj.getJSONObject("no2IndexLevel").getString("indexLevelName");

        String pm10IndexLevelName;
        if (obj.has("pm10IndexLevel")) {
            pm10IndexLevelName = obj.getJSONObject("pm10IndexLevel").getString("indexLevelName");
        } else {
            pm10IndexLevelName = null;
        }

        String pm25IndexLevelName;
        if (obj.has("pm25IndexLevel")) {
            pm25IndexLevelName = obj.getJSONObject("pm25IndexLevel").getString("indexLevelName");
        } else {
            pm25IndexLevelName = null;
        }

        String o3IndexLevelName;
        if (obj.has("o3IndexLevel")) {
            o3IndexLevelName = obj.getJSONObject("o3IndexLevel").getString("indexLevelName");;
        }else {
            o3IndexLevelName = null;
        }


        airQualityList.add(new AirQualityIndex(id, stIndexLevelName,so2IndexLevelName, no2IndexLevelName, pm10IndexLevelName, pm25IndexLevelName, o3IndexLevelName));

        System.out.println(airQualityList);
        return airQualityList;

    }
}


