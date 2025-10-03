package facade;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// Facade class that simplifies API calls
public class ApiFacade {

    // Facade method for Chuck Norris joke
    public String getRandomJoke() throws IOException, IllegalArgumentException {
        return getAttributeValueFromJson("https://api.chucknorris.io/jokes/random", "value");
    }

    // Facade method for random cat fact
    public String getRandomCatFact() throws IOException, IllegalArgumentException {
        return getAttributeValueFromJson("https://catfact.ninja/fact", "fact");
    }

    // Internal method: sends HTTP GET request and extracts JSON attribute
    private String getAttributeValueFromJson(String urlString, String attributeName)
            throws IOException, IllegalArgumentException {

        // Send HTTP GET request
        URL url = new URL(urlString);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        int status = con.getResponseCode();
        if (status != HttpURLConnection.HTTP_OK) {
            con.disconnect();
            throw new IOException("HTTP request failed with status code: " + status);
        }

        // Read response
        StringBuilder content = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
        } finally {
            con.disconnect();
        }

        // Parse JSON and get attribute
        try {
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(content.toString());

            if (!jsonObject.containsKey(attributeName)) {
                throw new IllegalArgumentException("Attribute not found: " + attributeName);
            }

            Object value = jsonObject.get(attributeName);
            return value != null ? value.toString() : null;

        } catch (ParseException e) {
            throw new IllegalArgumentException("Failed to parse JSON", e);
        }
    }
}
