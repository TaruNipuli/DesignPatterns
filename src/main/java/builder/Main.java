package builder;

public class Main {
    public static void main(String[] args) {

        // Build gaming computer
        ComputerBuilder computerBuilder = new GamingComputerBuilder();
        ComputerDirector director = new ComputerDirector(computerBuilder);
        director.constructGamingComputer();
        Computer computer = computerBuilder.getComputer();
        System.out.println(computer);

        // Build office computer
        ComputerBuilder computerBuilder2 = new OfficeComputerBuilder();
        ComputerDirector director2 = new ComputerDirector(computerBuilder2);
        director2.constructGamingComputer();
        Computer computer2 = computerBuilder2.getComputer();
        System.out.println(computer2);
    }
}
