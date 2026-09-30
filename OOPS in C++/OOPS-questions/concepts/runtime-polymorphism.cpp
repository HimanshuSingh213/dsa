#include <iostream>
using namespace std;
class Animal{
    public:
    virtual void speak(){
        cout << "huhuhuhu" << endl;
    }

    // as abstract class , fully virtual function to be implemented in clid classes
    // virtual void speak2() = 0;
};

class Dog: public Animal{
    public:

    void speak(){
        cout << "Bark" << endl;
    }

};

int main() {
    Animal *p;
    p = new Dog();
    p->speak();
    
    return 0;
}