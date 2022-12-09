package airQuality;

import org.json.JSONArray;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MeasurementConnection {


    public static JSONObject getDateAndValues(int id) {

        try {

            URL url = new URL("https://api.gios.gov.pl/pjp-api/rest/data/getData/" + id);

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


    // wczytanie danych z powyższego// API do bazy danych
    public static List<Measurement> measurementList(int userChoice) {

        List<Measurement> measurementList = new ArrayList<>();

        org.json.JSONObject obj = new org.json.JSONObject(getDateAndValues(userChoice));
        JSONArray array = obj.getJSONArray("values");

        for (int i = 1; i < array.length() - 1; i++) {

            String date =array.getJSONObject(i).getString("date");
            double value = array.getJSONObject(i).getDouble("value");

            measurementList.add(new Measurement(date, value));
        }
        System.out.println(measurementList);
        return measurementList;

    }
}

