package flyweight;


// Implementation of the Tile interface representing a road tile
public class RoadTile implements Tile {
    @Override
    public char getCharacter() {
        return 'R'; // Character on the map
    }

    @Override
    public String getType() {
        return "Road"; // Type of the tile
    }
}
