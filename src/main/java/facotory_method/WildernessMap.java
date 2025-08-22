package facotory_method;

import java.util.Random;

// WildernessMap is a subclass of Map + fills map with random swamp, water, and forest tiles
public class WildernessMap extends Map {

    // Random generator used to create tiles
    private Random rand = new Random();

    // Constructor that initializes map with the given width and height
    // and fills each cell with a random tile
    public WildernessMap(int width, int height) {
        super(width, height);
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                map[i][j] = createTile();
            }
        }
    }

    // Creates a single random tile (swamp, water, or forest)
    @Override
    public Tile createTile() {
        int choice = rand.nextInt(3); // generates a random number between 0 and 2 to choose a tile type
        // Return a tile based on the random choice
        switch (choice) {
            case 0: return new SwampTile();
            case 1: return new WaterTile();
            default: return new ForestTile();
        }
    }
}
