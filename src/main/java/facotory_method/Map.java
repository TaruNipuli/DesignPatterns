package facotory_method;

// Abstract class for different types of maps (CityMap, WildernessMap)
public abstract class Map {

    // Dimensions of the map, these are protected so subclasses (CityMap, WildernessMap) can access them
    protected int width;
    protected int height;
    protected Tile[][] map;

    // Constructor to initialize the map with given width and height
    public Map(int width, int height) {
        this.width = width;
        this.height = height;
        this.map = new Tile[width][height];
    }

    // Abstract method to create a tile, are implemented by subclasses
    public abstract Tile createTile();

    // Displays the map as a grid of characters (S, W, R...)
    // Iterates through tile array and prints each tile's character
    public void display() {
        // Loop through each row of the map, map.length gives the number of rows
        for (int i = 0; i < map.length; i++) {
            // Loop through each column in the current row, maps[i].length gives the number of columns
            for (int j = 0; j < map[i].length; j++) {
                // Print the character representing the current tile
                System.out.print(map[i][j].getCharacter() + " "); // " " to add space between characters
            }
            // Move to the next line after printing a row
            System.out.println();
        }
    }
}