package visitor;


public interface FileSystemVisitor {
    void visit(Directory directory);
    void visit(File file);
}
