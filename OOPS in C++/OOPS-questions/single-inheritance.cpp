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
    // initializing in this class itself 
    // Student (string name, int rollNo, int age, int fees){
    //     this->name = name;
    //     this->rollNo = rollNo;
    //     this->fees = fees;
    //     this->age = age;
    // }

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

int main() {

    Student A1("Himanshu Singh", 402, 19, 10000);
    A1.display();
    A1.work();

    // constructors are called in parent -> child classes 
    // but destructors are called in child -> parent classes
    
    return 0;
}