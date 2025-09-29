package flyweight;

import javafx.scene.paint.Color;
import java.util.HashMap;

// Provides shared Color objects for each tile type
// All tiles of the same type use the same Color to save memory
public class TileGraphicFactory {
    // To store a single shared Color for each tile type
    private static final HashMap<String, Color> tileColors = new HashMap<>();

    // Returns a single shared color for each tile type
    // All tiles of the same type use the same color to save memory
    public static Color getTileColor(String type) {
        if (!tileColors.containsKey(type)) {
            Color color;
            switch (type) {
                case "Road":
                    color = Color.GRAY;
                    break;
                case "Forest":
                    color = Color.FORESTGREEN;
                    break;
                case "Water":
                    color = Color.DEEPSKYBLUE;
                    break;
                case "Swamp":
                    color = Color.DARKOLIVEGREEN;
                    break;
                case "Building":
                    color = Color.DARKGRAY;
                    break;
                default:
                    color = Color.BLACK;      // Color for unknown tile types
            }

            tileColors.put(type, color); // Store in Flyweight map
        }

        return tileColors.get(type); // Return shared color
    }
}
