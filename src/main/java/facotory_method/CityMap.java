package facotory_method;

import java.util.Random;

// CityMap is a subclass of Map + fills the map with random road, build and forest tiles
public class CityMap extends Map {

    // Random generator used to create tiles
    private Random rand = new Random();

    // Constructor that initializes map with the given width and height
    // and fills each cell with a random tile
    public CityMap(int width, int height) {
        super(width, height);
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = createTile(); // factory method
            }
        }
    }

    // Creates a single random tile (road, building, or forest)
    @Override
    public Tile createTile() {
        int choice = rand.nextInt(3); // generates a random number between 0 and 2 to choose a tile type
        // Return a tile based on the random choice
        switch (choice) {
            case 0: return new RoadTile();
            case 1: return new ForestTile();
            default: return new BuildingTile();
        }
    }
}
