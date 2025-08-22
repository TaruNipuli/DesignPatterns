package facotory_method;

// This is the main class to run the game
public class Game {
    public static void main(String[] args) {
        // Create a city map instance
        Map map = createMap("city", 5, 5); // city or wilderness
        map.display(); // display the map, used from Map class
    }

    // Create map instance based on type
    public static Map createMap(String type, int width, int height) {
        if (type.equals("city")) {
            System.out.println("Creating a city map");
            return new CityMap(width, height);
        } else {
            System.out.println("Creating a wilderness map");
            return new WildernessMap(width, height);
        }
    }
}
