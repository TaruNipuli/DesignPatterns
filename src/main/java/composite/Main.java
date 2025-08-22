package composite;

public class Main {

    public static void main(String[] args) {

        // Top-level organization (root of the hierarchy)
        Component organization = new Department("Organization");

        // Departments in the organization
        Component marketing = new Department("Marketing");
        Component finance = new Department("Finance");
        Component it = new Department("IT");
        Component hr = new Department("HR");

        // Employees in departments
        Component alice = new Employee("Alice", 3000);
        Component bob = new Employee("Bob", 3200);
        Component charlie = new Employee("Charlie", 4000);
        Component diana = new Employee("Diana", 3800);
        Component eve = new Employee("Eve", 4500);

        // Add employees to departments
        marketing.add(alice);
        marketing.add(bob);

        finance.add(charlie);
        finance.add(diana);

        it.add(eve);

        // Add departments to the organization
        organization.add(marketing);
        organization.add(finance);
        organization.add(it);
        organization.add(hr);

        // Print the organization structure in XML format
        organization.printXML();

        // Print the total salary of the organization
        System.out.println();
        System.out.println("Total salary of the organization: " + organization.getSalary());
    }
}
