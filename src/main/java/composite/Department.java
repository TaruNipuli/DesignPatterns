package composite;

import java.util.*;

// Composite class representing a department in the organization (can contain other departments or employees)
public class Department extends Component {
    // List of child components
    private List<Component> children = new ArrayList<>();

    // Constructor to set the department's name
    public Department(String name) {
        super(name);
    }

    // Adds a child component (employee or sub-department) to the department
    @Override
    public void add(Component component) {
        children.add(component);
    }

    // Removes a child component (employee or sub-department) from the department
    @Override
    public void remove(Component component) {
        children.remove(component);
    }

    // Returns the total salary
    @Override
    public double getSalary() {
        double totalSalary = 0;
        for (Component component : children) {
            totalSalary += component.getSalary();
        }
        return totalSalary;
    }

    // Prints the department and its children in XML format
    @Override
    public void printXML() {
        System.out.println("<Department name=\"" + name + "\">");
        for (Component component : children) {
            component.printXML();
        }
        System.out.println("</Department>");
    }


}
