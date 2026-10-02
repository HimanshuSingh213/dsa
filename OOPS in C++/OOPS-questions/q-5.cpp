/*
===========================================================
OOPS PRACTICE — QUESTION 1
Topic: Inheritance + Access Control + Function Overriding
       + Virtual Function + Dynamic Binding
===========================================================

Design an employee payroll system using inheritance.

Requirements:

1. Create a base class `Employee` containing:
   - private: `name`
   - protected: `baseSalary`
   - public:
       * parameterized constructor
       * virtual function `calculateSalary()`
       * function `displayBasicInfo()`

2. Create two derived classes:
   - `Manager`
   - `Developer`

3. Manager should have:
   - private: `bonus`
   - its own parameterized constructor
   - override `calculateSalary()`
       Manager salary = baseSalary + bonus

4. Developer should have:
   - private: `overtimePay`
   - its own parameterized constructor
   - override `calculateSalary()`
       Developer salary = baseSalary + overtimePay

5. `baseSalary` must NOT be directly accessible from outside
   the class hierarchy.

6. Create objects of both derived classes.

7. Use an `Employee*` pointer to point to each derived object
   and call:
       calculateSalary()

   The correct derived-class version must execute.

8. Also call `displayBasicInfo()` through the base pointer.

9. In `main()`, demonstrate that:
   - `baseSalary` cannot be directly accessed from outside.
   - `name` cannot be directly accessed from outside.
   - derived classes CAN use `baseSalary`.

10. Do NOT use `if/else` to determine the employee type.
    The salary calculation must happen through runtime
    polymorphism.

11. Add a virtual destructor to the base class.

Expected concepts:
- Single inheritance
- protected vs private
- Constructor in inheritance
- Function overriding
- Virtual function
- Base-class pointer
- Dynamic binding
- Runtime polymorphism
- Virtual destructor

Do not use advanced STL or smart pointers for this question.

Goal:
Write the complete working C++ program yourself.
===========================================================
*/

#include <iostream>
using namespace std;

class Employee{
    string name;

    protected:
    int baseSalary;

    public:
    Employee(string name, int baseSalary){
        this->name = name;
        this->baseSalary = baseSalary;
    }

    virtual void calculateSalary() = 0;

    void displayBasicInfo(){
        cout << "Employee basic info: " << endl;
        cout << "Name: " << name << endl;
        cout << "Base Salary: " << baseSalary << endl;
        cout << endl;
    }

    virtual ~Employee(){
        cout << "Employee class destructor called." << endl;
    }
};

class Manager: public Employee{
    int bonus;

    public:
    Manager(string name, int baseSalary, int bonus): Employee(name, baseSalary){
        this->bonus = bonus;
    }

    void calculateSalary(){
        cout << "Manager Salary: " << baseSalary + bonus << endl;
    }

    ~Manager(){
        cout << "Manager class destructor called." << endl;
    }
};

class Developer: public Employee{
    int overtimePay;

    public:
    Developer(string name, int baseSalary, int overtimePay): Employee(name, baseSalary){
        this->overtimePay = overtimePay;
    }

    void calculateSalary(){
        cout << "Developer Salary: " << baseSalary + overtimePay << endl;
    }

    ~Developer(){
        cout << "Developer class destructor called." << endl;
    }
};

int main() {

    Employee* m1 = new Manager("Anuj kumar", 40000, 12000);
    Employee* d1 = new Developer("Himanshu singh", 30000, 10000);

    m1->displayBasicInfo();
    m1->calculateSalary();
    d1->displayBasicInfo();
    d1->calculateSalary();

    delete m1, delete d1;
    
    return 0;
}