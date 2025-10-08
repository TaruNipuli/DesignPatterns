package command;

// Cntains all commands for manipulating the PixelGrid
public class Commands {

    public static class MoveCursorUpCommand implements Command {
        private PixelGrid grid;
        public MoveCursorUpCommand(PixelGrid grid) { this.grid = grid; }
        public void execute() { grid.moveCursorUp(); }
    }

    public static class MoveCursorDownCommand implements Command {
        private PixelGrid grid;
        public MoveCursorDownCommand(PixelGrid grid) { this.grid = grid; }
        public void execute() { grid.moveCursorDown(); }
    }

    public static class MoveCursorLeftCommand implements Command {
        private PixelGrid grid;
        public MoveCursorLeftCommand(PixelGrid grid) { this.grid = grid; }
        public void execute() { grid.moveCursorLeft(); }
    }

    public static class MoveCursorRightCommand implements Command {
        private PixelGrid grid;
        public MoveCursorRightCommand(PixelGrid grid) { this.grid = grid; }
        public void execute() { grid.moveCursorRight(); }
    }

    public static class TogglePixelCommand implements Command {
        private PixelGrid grid;
        public TogglePixelCommand(PixelGrid grid) { this.grid = grid; }
        public void execute() { grid.togglePixel(); }
    }

    public static class GenerateCodeCommand implements Command {
        private PixelGrid grid;
        public GenerateCodeCommand(PixelGrid grid) { this.grid = grid; }
        public void execute() {
            boolean[][] pixels = grid.getPixels();
            System.out.println("int[][] pixelArt = {");
            for (int y = 0; y < pixels.length; y++) {
                System.out.print("    {");
                for (int x = 0; x < pixels[y].length; x++) {
                    System.out.print(pixels[y][x] ? "1" : "0");
                    if (x < pixels[y].length - 1) System.out.print(", ");
                }
                System.out.println("}" + (y < pixels.length - 1 ? "," : ""));
            }
            System.out.println("};");
        }
    }
}
