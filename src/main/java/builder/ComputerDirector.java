package builder;

// Constructs computers using a builder
public class ComputerDirector {

    // The builder used to assemble the computer
    private ComputerBuilder computerBuilder;

    public ComputerDirector(ComputerBuilder computerBuilder) {
        this.computerBuilder = computerBuilder;
    }

    // Constructs a gaming computer by calling builder methods
    public void constructGamingComputer() {
        computerBuilder.buildProcessor();
        computerBuilder.buildHardDrive();
        computerBuilder.buildOperatingSystem();
        computerBuilder.buildGraphicsCard();
        computerBuilder.buildRAM();
    }

    // Constructs an office computer by calling builder methods
    public void constructOfficeComputer() {
        computerBuilder.buildProcessor();
        computerBuilder.buildHardDrive();
        computerBuilder.buildOperatingSystem();
        computerBuilder.buildGraphicsCard();
        computerBuilder.buildRAM();
    }
}
