package airQuality;
import org.json.JSONArray;
import org.json.JSONObject;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;

public class ParametersConnection {


// połączenie sie z API o wskazanym ID

    public static JSONArray getParameters(int id) {

        try {

            URL url = new URL("https://api.gios.gov.pl/pjp-api/rest/station/sensors/" + id);

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
                String content = informationString.toString();
                JSONArray jsonArray = new JSONArray(content);


                return jsonArray;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    // wczytanie danych z powyższego API do bazy danych
    public static List<Parameters> parametersList(List<Integer> userChoice) {

        List<Parameters> parameters = new ArrayList<>();

        ParametersConnection conn = new ParametersConnection();
        for (int i = 0; i < userChoice.size(); i++) {
            JSONArray array = new JSONArray(getParameters(userChoice.get(i)));

            for (int j = 0; j < array.length(); j++) {

                JSONObject jsonobject = (JSONObject) array.get(j);
                String parameterName = jsonobject.getJSONObject("param").getString("paramName");
                String parameterFormula = jsonobject.getJSONObject("param").getString("paramFormula");
                String parameterCode = jsonobject.getJSONObject("param").getString("paramCode");
                int idParameter = jsonobject.getJSONObject("param").getInt("idParam");
                int id = jsonobject.getInt("id");
                int stationId = jsonobject.getInt("stationId");

                parameters.add(new Parameters(parameterFormula, parameterCode, idParameter, parameterName, id, stationId));

            }
        }
        System.out.println(parameters);
        return parameters;

    }
}
