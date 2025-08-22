package facotory_method;

// Implementation of the Tile interface representing a water tile
public class WaterTile implements Tile{

    @Override
    public char getCharacter() {
        return 'W'; // Character on the map
    }

    @Override
    public String getType() {
        return "Water"; // Type of the tile
    }
}
