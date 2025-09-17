package visitor;

import java.util.ArrayList;
import java.util.List;

// Represents folder that can contain files and other directories
public class Directory implements FileSystemElement {

    private String name;

    // List of child elements
    private List<FileSystemElement> children;

    public Directory(String name) {
        this.name = name;
        children = new ArrayList<>();
    }

    // Returns list of child elements
    public List<FileSystemElement> getChildren() {
        return children;
    }

    // Adds a child element to this directory
    public void addChild(FileSystemElement element) {
        children.add(element);
    }

    // Accepts a visitor and allows it to perform operations on this directory
    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}
