package flyweight;

public class Main {
    public static void main(String[] args) {
        // Create the map
        GameView.map = createMap("wilderness", 10, 10);
        // Launch the JavaFX
        GameView.launch(GameView.class, args);
    }

    // Create either a city map or wilderness map
    public static Map createMap(String type, int width, int height) {
        if (type.equals("city")) {
            return new CityMap(width, height);
        } else {
            return new WildernessMap(width, height);
        }
    }
}
