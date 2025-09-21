package builder;

// Concrete builder for creating gaming computer
public class GamingComputerBuilder implements ComputerBuilder {
    private  Computer computer;

    // Initialize new Computer instance
    public GamingComputerBuilder() {
        this.computer = new  Computer();
    }

    @Override
    public void buildProcessor() {
        computer.setProcessor("Gaming computer CPU");
    }

    @Override
    public void buildRAM() {
        computer.setRAM(40);
    }

    public void buildHardDrive() {
        computer.setHardDrive("Gaming computer hard drive");
    }

    @Override
    public void buildGraphicsCard() {
        computer.setGraphicsCard("Gaming computer graphics card");
    }

    @Override
    public void buildOperatingSystem() {
        computer.setOperatingSystem("Gaming computer operating system");
    }

    // Return the fully built computer
    @Override
    public Computer getComputer() {
        return computer;
    }
}
