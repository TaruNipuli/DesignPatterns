package builder;

// Concrete builder for creating office computer
public class OfficeComputerBuilder implements ComputerBuilder {
    private  Computer computer;

    // Initialize new Computer instance
    public OfficeComputerBuilder() {
        this.computer = new  Computer();
    }

    @Override
    public void buildProcessor() {
        computer.setProcessor("Office computer CPU");
    }

    @Override
    public void buildRAM() {
        computer.setRAM(30);
    }

    public void buildHardDrive() {
        computer.setHardDrive("Office computer hard drive");
    }

    @Override
    public void buildGraphicsCard() {
        computer.setGraphicsCard("Office computer graphics card");
    }

    @Override
    public void buildOperatingSystem() {
        computer.setOperatingSystem("Office computer operating system");
    }

    // Return the fully built computer
    @Override
    public Computer getComputer() {
        return computer;
    }
}
