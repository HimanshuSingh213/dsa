#include <iostream>
using namespace std;

class Engineer{
    protected:
    string specialization;

    public:
    void work(){
        cout << "I am from " << specialization << " specialization" << endl;
    }
};

class Youtuber{
    protected:
    int subscribers;

    public:
    void contentCreator(){
        cout << "I have " << subscribers << " subcribers." << endl;
    }
};

class CodeTeacher: public Engineer, public Youtuber{

    string name;

    public:
    CodeTeacher(string name, string specilization, int subscribers){
        this->name = name;
        this->specialization = specilization;
        this->subscribers = subscribers;
    }

    void showcase(){
        cout << "\nMy details are as follows:" << endl;
        cout << "My name is " << name << endl;
        work();
        contentCreator();
    }
};

int main() { 
    CodeTeacher A1("Himanshu Singh", "CSE", 2000000);
    A1.showcase();

    // constructors are called by MRO like Python 
    // means first the left parent -> right parent -> child
    return 0;
}