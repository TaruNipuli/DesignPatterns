package builder;

// Defines the steps required to build a Computer
// Each concrete builder implements these methods to configure a Computer with specific components
public interface ComputerBuilder {
    void buildProcessor();
    void buildRAM();
    void buildHardDrive();
    void buildGraphicsCard();
    void buildOperatingSystem();
    Computer getComputer();
}
