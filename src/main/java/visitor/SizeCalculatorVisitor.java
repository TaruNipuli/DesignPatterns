package visitor;

// Visitor that calculates the total size of all files in the file system
public class SizeCalculatorVisitor implements FileSystemVisitor {
    private int totalSize = 0;

    // Visit a file: add its size to the total
    @Override
    public void visit(File file) {
        totalSize += file.getSize();
    }

    // Visit a directory: visit each child element (files or subdirectories)
    @Override
    public void visit(Directory directory) {
        for (FileSystemElement element : directory.getChildren()) {
            element.accept(this);
        }
    }

    // Returns total size of all visited files
    public int getTotalSize() {
        return totalSize;
    }
}
