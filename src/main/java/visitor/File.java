package visitor;

// Represents single file in the file system
public class File implements FileSystemElement {
    private String name;
    private int size;

    public File(String name, int size) {
        this.name = name;
        this.size = size;
    }

    // Returns name of the file
    public String getName() {
        return name;
    }

    // Returns size of the file
    public int getSize() {
        return size;
    }

    // Accepts a visitor and allows it to perform operations on this file
    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }


    @Override
    public String toString() {
        return name;
    }
}
