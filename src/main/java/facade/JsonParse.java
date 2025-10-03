package facade;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// Subsystem 2: Handles JSON parsing and gets a value for the requested attribute
public class JsonParse{
    public String getAttribute(String json, String attributeName) throws IllegalArgumentException {
        try {
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(json);
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

