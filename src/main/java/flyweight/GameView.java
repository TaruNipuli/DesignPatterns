package flyweight;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

// Responsible for displaying the map
public class GameView extends Application {
    public static Map map;

    @Override
    public void start(Stage stage) {
        // Calculate canvas size based on map dimensions and tile size
        int canvasWidth = map.width * Map.TILE_SIZE;
        int canvasHeight = map.height * Map.TILE_SIZE;

        // Create a canvas
        Canvas canvas = new Canvas(canvasWidth, canvasHeight);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        map.render(gc);

        // Add the canvas to the root container
        Pane root = new Pane(canvas);
        // Create a scene containing the root container
        Scene scene = new Scene(root);

        stage.setTitle("RPG Map");
        stage.setScene(scene);
        stage.show();
    }
}
