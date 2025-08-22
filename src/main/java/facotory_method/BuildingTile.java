package facotory_method;

// Implementation of the Tile interface representing building tile
public class BuildingTile implements Tile {
    @Override
    public char getCharacter() {
        return 'B'; // Character on the map
    }

    @Override
    public String getType() {
        return "Building"; // Type of the tile
    }
}
