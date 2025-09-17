package visitor;

// Defines visit methods for both directories and files
public interface FileSystemVisitor {

    // Method to visit a directory
    void visit(Directory directory);

    // Method to visit a file
    void visit(File file);
}
