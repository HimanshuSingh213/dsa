/*
QUESTION 3: Employee Payroll — Runtime Polymorphism

Create a base class `Employee` and two derived classes:
    Manager
    Developer

REQUIREMENTS:

1. Base class `Employee`:
   - private/protected data member:
         string name
   - parameterized constructor to initialize the name
   - virtual function:
         void calculateSalary()
   - virtual destructor
   - function:
         void showName()

2. Derived class `Manager`:
   - additional data member:
         double bonus
   - constructor accepting name and bonus
   - override `calculateSalary()`
   - destructor

   Manager salary = 50000 + bonus

3. Derived class `Developer`:
   - additional data member:
         double projectAllowance
   - constructor accepting name and allowance
   - override `calculateSalary()`
   - destructor

   Developer salary = 40000 + projectAllowance

4. In main():

   Create objects dynamically using base-class pointers:

       Employee* e1 = new Manager("Alice", 15000);
       Employee* e2 = new Developer("Bob", 10000);

   Store both pointers in an array:

       Employee* employees[2];

   Then use a loop to call:

       employees[i]->showName();
       employees[i]->calculateSalary();

5. The call to `calculateSalary()` MUST demonstrate
   runtime polymorphism / dynamic binding.

6. Finally, properly destroy both objects using:

       delete employees[i];

7. Add suitable messages inside every constructor and destructor
   so that you can observe the exact order in which they execute.

8. Do NOT use RTTI, `dynamic_cast`, or manual type checking.

9. Do NOT use `if`/`else` to determine whether the object is a
   Manager or Developer.

CONCEPTS BEING TESTED:

- Base and derived classes
- Inheritance
- Constructor invocation order
- Destructor invocation order
- Function overriding
- Virtual functions
- Runtime polymorphism
- Dynamic/late binding
- Base-class pointer → derived-class object
- Virtual destructor
- Dynamic memory allocation
- Object lifetime

BONUS:

Add a third derived class:

    Intern

with salary = 20000.

You should be able to add it without modifying
`Employee::calculateSalary()` or adding type-checking logic.

QUESTION TO THINK ABOUT:

What would happen if `Employee::calculateSalary()` were NOT virtual?

And what problem could occur if the Employee destructor
were NOT virtual?
*/

#include <iostream>
using namespace std;

class Employee{
    protected:
    string name;

    public:

    Employee(string name){
        this->name = name;
    }

    virtual void calculateSalary(){
        cout << "Base class calculateSalary." << endl;
    }

    void showName(){
        cout << "Name: " << name << endl;
    }

    virtual ~Employee(){
        cout << "Base class destructor called." << endl;
    }

};

class Manager: public Employee{
    double bonus;

    public:
    Manager(string name, double bonus): Employee(name){
        this->bonus = bonus;
    }

    void calculateSalary(){
        cout << "derived class calculateSalary." << endl;
        cout << "Salary: " << 50000 + bonus << endl;
    }

    ~Manager(){
        cout << "Manager Class destructor called." << endl;
    }
};

class Developer: public Employee{
    double projectAllowances;

    public:
    Developer(string name, double projectAllowances): Employee(name){
        this->projectAllowances = projectAllowances;
    }

    void calculateSalary(){
        cout << "derived class calculateSalary." << endl;
        cout << "Salary: " << 40000 + projectAllowances << endl;
    }

    ~Developer(){
        cout << "Developer class destructor called." << endl;
    }
};

int main() {
    Employee* employee[3];

    employee[0] = new Manager("Himanshu Singh", 15000);
    employee[1] = new Developer("Kaaju", 10000);

    for (int i = 0; i < 2; i++) {
        employee[i]->showName();
        employee[i]->calculateSalary();
    }

    for (int i = 0; i < 2; i++) {
        delete employee[i];
    }
    
    return 0;
}