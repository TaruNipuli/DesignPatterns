package visitor;

import java.util.ArrayList;
import java.util.List;

// SearchVisitor traverses the file system and collects files
// that match a specified name pattern or file extension.
public class SearchVisitor implements FileSystemVisitor {

    // List to store matching files
    private List<File> matchingFiles;

    // String pattern to match in file names
    private String searchPattern;

    // Constructor accepts a search pattern
    public SearchVisitor(String searchPattern) {
        this.searchPattern = searchPattern;
        this.matchingFiles = new ArrayList<>();
    }

    // Visit a file: if its name contains the search pattern, add it to the list
    @Override
    public void visit(File file) {
        if (file.getName().contains(searchPattern)) {
            matchingFiles.add(file);
        }
    }

    // Visit a directory: traverse all children recursively
    @Override
    public void visit(Directory directory) {
        for (FileSystemElement element : directory.getChildren()) {
            element.accept(this);
        }
    }

    // Returns the list of matching files
    public List<File> getMatchingFiles() {
        return matchingFiles;
    }
}
