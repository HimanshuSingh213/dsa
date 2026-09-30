#include <iostream>
using namespace std;

class Human{
    public:
    string name;

    void display(){
        cout << "My name is " << name << endl;
    }
};

class Engineer: public virtual Human{
    protected:
    string specialization;

    public:
    void work(){
        cout << "I am from " << specialization << " specialization" << endl;
    }
};

class Youtuber: public virtual Human{
    protected:
    int subscribers;

    public:
    void contentCreator(){
        cout << "I have " << subscribers << " subcribers." << endl;
    }
};

class CodeTeacher: public Engineer, public Youtuber{

    int salary;

    public:

    CodeTeacher(string name, string specilization, int subscribers, int salary){
        this->name = name;
        this->specialization = specilization;
        this->subscribers = subscribers;
        this->salary = salary;
    }

    void showcase(){
        cout << "\nMy details are as follows:" << endl;
        cout << "My name is " << name << endl;
        work();
        contentCreator();
    }
};

int main() { 
    CodeTeacher A1("Himanshu Singh", "CSE" , 40000, 2000);
    A1.display();
    A1.showcase();

    return 0;
}