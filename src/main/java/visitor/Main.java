package visitor;

public class Main {
    public static void main(String[] args) {

        // Create files
        File file1 = new File("notes.txt", 50);
        File file2 = new File("report.pdf", 20);
        File file3 = new File("photo.jpg", 30);
        File file4 = new File("picture.jpg", 10);

        // Crate directories
        Directory directory = new Directory("MainFolder");
        Directory directory1 = new Directory("Documents");
        Directory directory2 = new Directory("Reports");
        Directory directory3 = new Directory("Photos");

        // Directory structure
        directory1.addChild(file1);
        directory2.addChild(file2);
        directory3.addChild(file3);
        directory3.addChild(file4);

        directory1.addChild(directory2);
        directory.addChild(directory1);
        directory.addChild(directory3);

        // Create SizeCalculatorVisitor
        SizeCalculatorVisitor sizeCalculatorVisitor = new SizeCalculatorVisitor();

        // Create SearchVisitor
        SearchVisitor searchVisitor = new SearchVisitor(".jpg");

        // Accept visitors
        directory.accept(sizeCalculatorVisitor);
        directory.accept(searchVisitor);

        // Print total size
        System.out.println("Total size: " + sizeCalculatorVisitor.getTotalSize() + " MB");

        // Print matching files
        System.out.println("Matching files: " + searchVisitor.getMatchingFiles());





    }
}
