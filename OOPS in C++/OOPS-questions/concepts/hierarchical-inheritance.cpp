#include <iostream>
using namespace std;

class Human{
    protected:
    string name;
    int age;

    public:
    Human(string name, int age){
        this->name = name;
        this->age = age;
    }

    void work(){
        cout << "\nI am working.\n" << endl;
    }

    void display(){
        cout << "Human Details: " << endl;
        cout << "Name: " << name << endl;
        cout << "Age: " << age << endl;
    }
};

class Student: public Human{
    int rollNo, fees;

    public:
    // using parent class' constructor
    Student (string name, int rollNo, int age, int fees): Human(name, age){
        this->rollNo = rollNo;
        this->fees = fees;
    }

    void display(){
        cout << "Student Details: " << endl;
        cout << "Name: " << name << endl;
        cout << "Roll No: " << rollNo << endl;
        cout << "Age: " << age << endl;
        cout << "Fees: " << fees << endl;
    }
};

class Teacher: public Human{
    int salary;

    public:
    Teacher(string name, int salary, int age): Human(name, age){
        this->salary = salary;
    }

    void display(){
        cout << "Teacher Details: " << endl;
        cout << "Name: " << name << endl;
        cout << "Age: " << age << endl;
        cout << "Salary: "<< salary << endl;
    }
};

int main() {

    Student A1("Himanshu Singh", 402, 19, 10000);
    A1.display();
    A1.work();

    // constructors are called in parent -> child classes 
    // but destructors are called in child -> parent classes

    Teacher A2("himanshu singh", 4000, 19 );
    A2.display();
    
    return 0;
}