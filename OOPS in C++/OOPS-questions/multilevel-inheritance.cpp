#include <iostream>
using namespace std;

class Person{
    protected:
    string name;

    public:
    void introduce(){
        cout << "\nhello, my name is " << name << endl;
    }
};

class Employee: public Person{
    protected:
    int salary;

    public:
    void monthlySalary(){
        cout << "\nMy monthly salary is: "<< salary << endl;
    }
};

class Manager: public Employee{
    protected:
    string department;

    public:
    Manager(string name, int salary, string department){
        this->name= name;
        this->department = department;
        this->salary = salary;
    }

    void work(){
        cout << "\nI am leading " << department << " department\n" << endl;
    }
};


int main() {
    Manager A1("Himanshu Singh", 2000, "IT");
    A1.work();
    A1.monthlySalary();
    A1.introduce();
    return 0;
}