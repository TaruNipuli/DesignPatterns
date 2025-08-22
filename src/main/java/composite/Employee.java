package composite;

// Leaf class representing an employee (this class doesn't have children)
public class Employee extends Component {
    private double salary; // The salary of an employee

    // Constructor to set the employee's name and salary
    public Employee(String name, double salary) {
        super(name);
        this.salary = salary;
    }

    // Returns the salary of the employee
    @Override
    public double getSalary() {
        return salary;
    }

    // Execption because leaf nodes (employees) cannot add children
    @Override
    public void add(Component component) {
        throw new UnsupportedOperationException("Cannot add to an employee.");
    }

    @Override
    public void remove(Component component) {
        throw new UnsupportedOperationException("Cannot remove from an employee.");
    }

    // Prints the employee in XML format
    @Override
    public void printXML() {
        System.out.println("<Employee=\"" + name + "\" salary=\"" + salary + "\" />");
    }

}
