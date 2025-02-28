import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private double salary;

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Salary: " + salary;
    }
}

public class EmployeeManagement {
    private ArrayList<Employee> employees = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    public void addEmployee() {
        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Employee Salary: ");
        double salary = scanner.nextDouble();

        employees.add(new Employee(id, name, salary));
        System.out.println("Employee added successfully!\n");
    }

    public void updateEmployee() {
        System.out.print("Enter Employee ID to Update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        for (Employee emp : employees) {
            if (emp.getId() == id) {
                System.out.print("Enter New Name: ");
                String name = scanner.nextLine();
                System.out.print("Enter New Salary: ");
                double salary = scanner.nextDouble();

                emp.setName(name);
                emp.setSalary(salary);

                System.out.println("Employee details updated successfully!\n");
                return;
            }
        }
        System.out.println("Employee not found!\n");
    }

    public void removeEmployee() {
        System.out.print("Enter Employee ID to Remove: ");
        int id = scanner.nextInt();

        employees.removeIf(emp -> emp.getId() == id);
        System.out.println("Employee removed successfully!\n");
    }

    public void searchEmployee() {
        System.out.print("Enter Employee ID to Search: ");
        int id = scanner.nextInt();

        for (Employee emp : employees) {
            if (emp.getId() == id) {
                System.out.println("Employee Found: " + emp + "\n");
                return;
            }
        }
        System.out.println("Employee not found!\n");
    }

    public void displayAllEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No Employees Available\n");
        } else {
            System.out.println("Employee List:");
            for (Employee emp : employees) {
                System.out.println(emp);
            }
            System.out.println();
        }
    }

    public void menu() {
        while (true) {
            System.out.println("Employee Management System");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. Search Employee");
            System.out.println("5. Display All Employees");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    updateEmployee();
                    break;
                case 3:
                    removeEmployee();
                    break;
                case 4:
                    searchEmployee();
                    break;
                case 5:
                    displayAllEmployees();
                    break;
                case 6:
                    System.out.println("Exiting System...");
                    return;
                default:
                    System.out.println("Invalid Choice! Try again.\n");
            }
        }
    }

    public static void main(String[] args) {
        EmployeeManagement em = new EmployeeManagement();
        em.menu();
    }
}
