package composite;

// Abstract class representing component in the organization (department or employee)
public abstract class Component {
    protected String name; // Name of the component (department or employee)

    // Constructor to initialize the name of the component
    public Component(String name) {
        this.name = name;
    }

    // Abstract method to add child component
    public abstract void add(Component component);

    // Abstract method to remove child component
    public abstract void remove(Component component);

    // Abstract method to get the salary of the component
    public abstract double getSalary();

    // Abstract method to print the component in XML format
    public abstract void printXML();
}
