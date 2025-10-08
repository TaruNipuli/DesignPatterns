package command;

// Represents the 8x8 pixel grid
public class PixelGrid {
    private final int SIZE = 8;
    private boolean[][] pixels;
    private int cursorX;
    private int cursorY;

    public PixelGrid() {
        pixels = new boolean[SIZE][SIZE]; // All pixels initialized to false
        cursorX = 0;
        cursorY = 0;
    }

    public int getSize() {
        return SIZE;
    }

    public boolean isPixelOn(int x, int y) {
        return pixels[y][x];
    }

    public void togglePixel() {
        pixels[cursorY][cursorX] = !pixels[cursorY][cursorX];
    }

    public int getCursorX() {
        return cursorX;
    }

    public int getCursorY() {
        return cursorY;
    }

    public void moveCursorUp() {
        if (cursorY > 0) cursorY--;
    }

    public void moveCursorDown() {
        if (cursorY < SIZE - 1) cursorY++;
    }

    public void moveCursorLeft() {
        if (cursorX > 0) cursorX--;
    }

    public void moveCursorRight() {
        if (cursorX < SIZE - 1) cursorX++;
    }

    public boolean[][] getPixels() {
        return pixels;
    }
}

