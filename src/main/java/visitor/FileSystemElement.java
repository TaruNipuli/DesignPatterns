package visitor;

// A base for both files and directories
public interface FileSystemElement {

    // Accepts a visitor that performs operations on this element
    void accept(FileSystemVisitor visitor);
}
