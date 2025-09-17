package visitor;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystemElement {

    private String name;
    private List<FileSystemElement> children;

    public  Directory(String name) {
        this.name = name;
        children = new ArrayList<FileSystemElement>();
    }

    // Returns the list of children
    public List<FileSystemElement> getChildren() {
        return children;
    }

    // Adds a child element (file or directory)
    public void addChild(FileSystemElement element) {
        children.add(element);
    }

    @Override
    public void accept(FileSystemVisitor visitor) {
        visitor.visit(this);
    }
}
