package facotory_method;

// Implementation of the Tile interface representing a swamp tile
public class SwampTile implements Tile{
    @Override
    public char getCharacter() {
        return 'S'; // Character on the map
    }

    @Override
    public String getType() {
        return "Swamp"; // Type of the tile
    }
}
