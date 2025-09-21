package builder;


public class Computer {
    private String processor;
    private int ramSize;
    private String hardDrive;
    private String graphicsCard;
    private String operatingSystem;


    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public void setRAM(int ram) {
        this.ramSize = ram;
    }

    public void setHardDrive(String hardDrive) {
        this.hardDrive = hardDrive;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }


    // Returnsreadable string of the computer configuration
    @Override
    public String toString() {
        return "Computer Configuration:\n" +
                "Processor: " + processor + "\n" +
                "RAM: " + ramSize + " GB\n" +
                "Hard Drive: " + hardDrive + "\n" +
                "Graphics Card: " + graphicsCard + "\n" +
                "Operating System: " + operatingSystem + "\n";
    }
}
