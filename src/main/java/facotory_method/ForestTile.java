package facotory_method;

// Implementation of the Tile interface representing a forest tile
public class ForestTile implements Tile{
    @Override
    public char getCharacter() {
        return 'F'; // Character on the map
    }

    @Override
    public String getType() {
        return "Forest"; // Type of the tile
    }
}
