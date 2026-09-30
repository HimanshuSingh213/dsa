/*
QUESTION 1: Object Lifetime Tracker

Create a class `Employee` that keeps track of how many Employee objects
are currently alive.

Requirements:
1. The class must contain:
   - employee ID
   - employee name
   - a static data member `activeCount`

2. Implement:
   - A default constructor
   - A parameterized constructor
   - A copy constructor
   - A destructor

3. Every time an Employee object is successfully created, increment
   `activeCount`.

4. Every time an Employee object is destroyed, decrement `activeCount`.

5. Create a static member function:
       static void showActiveCount();

   It should display the current number of live Employee objects.

6. In `main()`:
   - Create one object using the default constructor.
   - Create another using the parameterized constructor.
   - Create a third object by copying the second object.
   - Display the active object count.
   - Create another object inside a separate `{ }` block and display
     the count inside and outside that block.
   - Finally display the count before `main()` ends.

7. Do NOT use global variables.

Concepts being tested:
- Classes and objects
- Default constructor
- Parameterized constructor
- Copy constructor
- Destructor
- Static data member
- Static member function
- Object lifetime
- Scope

Bonus:
Print a message from every constructor and destructor so that the
order of object creation and destruction can be observed.
*/

#include <iostream>
using namespace std;

class Employee{
    int EmpId;
    string EmpName;

    public:
    static int activeCount;

    // Default Contructors
    Employee(){
        cout << "Default Employee Constructor." << endl;
        activeCount++;
        cout << "Object " << activeCount << " Created." << endl;
    }

    // Parameterized Constructors
    Employee(int EmpId, string EmpName){
        this->EmpName = EmpName;
        this->EmpId = EmpId;
        activeCount++;
        cout << "parameterized Employee Contructor." << endl;
        cout << "Object " << activeCount << " Created." << endl;
    }

    // Copy Constructor 
    Employee(const Employee &obj){
        this->EmpId = obj.EmpId;
        this->EmpName = obj.EmpName;
        activeCount++;
        cout << "Copy Employee Contructor." << endl;
        cout << "Object " << activeCount << " Created." << endl;
    }

    // show ActiveCount
    static void showActiveCount(){
        cout << "Active Count: " << activeCount << endl;
    }

    //Destructor
    ~Employee(){
        activeCount--;
    }
};

int Employee::activeCount = 0;

int main() {

    Employee E1;

    Employee::showActiveCount();

    Employee E2(100, "Himanshu Singh");

    Employee E3(E2);

    Employee::showActiveCount();

    {
        Employee E4;
        Employee::showActiveCount();
    }

    Employee::showActiveCount();
    
    return 0;
}