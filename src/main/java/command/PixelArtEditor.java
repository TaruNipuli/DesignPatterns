package command;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PixelArtEditor extends Application {
    private PixelGrid grid = new PixelGrid();
    private Rectangle[][] rects = new Rectangle[8][8];

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();

        // Create 8x8 rectangles for pixels
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                Rectangle rect = new Rectangle(30, 30);
                rect.setStroke(Color.BLACK);
                rect.setFill(Color.WHITE);
                rects[y][x] = rect;
                gridPane.add(rect, x, y);
            }
        }

        // Button to generate pixel matrix code
        Button generateButton = new Button("Generate Pixel Matrix");
        generateButton.setOnAction(e -> new Commands.GenerateCodeCommand(grid).execute());
        gridPane.add(generateButton, 0, 8, 8, 1); // span across row 8

        Scene scene = new Scene(gridPane);

        // Make sure the GridPane can receive keyboard focus
        gridPane.setFocusTraversable(true);
        gridPane.requestFocus(); // important so that key events work

        // Keyboard input handling
        scene.setOnKeyPressed(e -> {
            Command command = null;

            switch (e.getCode()) {
                case UP -> command = new Commands.MoveCursorUpCommand(grid);
                case DOWN -> command = new Commands.MoveCursorDownCommand(grid);
                case LEFT -> command = new Commands.MoveCursorLeftCommand(grid);
                case RIGHT -> command = new Commands.MoveCursorRightCommand(grid);
                case SPACE -> command = new Commands.TogglePixelCommand(grid); // change color with space
                default -> { }
            }

            if (command != null) {
                command.execute();
                updateGrid();
            }
        });

        primaryStage.setTitle("Pixel Art");
        primaryStage.setScene(scene);
        primaryStage.show();
        updateGrid();
    }

    // Updates rectangle colors based on grid state and cursor position
    private void updateGrid() {
        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (grid.getCursorX() == x && grid.getCursorY() == y) {
                    rects[y][x].setStroke(Color.RED); // highlight cursor
                } else {
                    rects[y][x].setStroke(Color.BLACK); // normal border
                }
                rects[y][x].setFill(grid.isPixelOn(x, y) ? Color.GREEN : Color.WHITE); // pixel on/off color
            }
        }
    }
}
