class Employee {
    String name;
    int id;
    double salary;

    Employee(String name, int id, double salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public void displayEmployee() {
        System.out.println("Employee Name: " + name);
        System.out.println("Employee ID: " + id);
        System.out.println("Salary: " + salary);
    }
}

class Manager extends Employee {
    String department;
    int teamSize;

    Manager(String name, int id, double salary, String department, int teamSize) {
        super(name, id, salary);
        this.department = department;
        this.teamSize = teamSize;
    }

    void displayManager() {
        displayEmployee();
        System.out.println("Department: " + department);
        System.out.println("Team Size: " + teamSize);
    }
}

class SeniorManager extends Manager {
    String project;
    String location;

    SeniorManager(String name, int id, double salary, String department, int teamSize, String project, String location) {
        super(name, id, salary, department, teamSize);
        this.project = project;
        this.location = location;
    }

    void displaySeniorManager() {
        displayManager();
        System.out.println("Project: " + project);
        System.out.println("Location: " + location);
    }
}

public class multilevel_inheritance {
    public static void main(String[] args) {

        SeniorManager manager = new SeniorManager(
            "Rahul",
            101,
            85000,
            "Software Development",
            10,
            "Banking Application",
            "Delhi"
        );

        manager.displaySeniorManager();
    }
}

