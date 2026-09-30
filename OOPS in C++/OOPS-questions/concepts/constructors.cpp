#include <iostream>
using namespace std;

class Customer {
    string name;
    long long accountNum;
    double balance;
    int *p;

    public:
    // Default constructor
    Customer(){
        cout << "\nInitialized using Default Constructor:" << endl;
        name = "Hello World";
        accountNum = 16449825;
        balance = 0;
        display();
    }

    // parameterized constructor
    Customer(string name, long long accountNum, double balance){
        cout << "\nInitialized using parameterized Constructor:" << endl;
        this->name = name;
        this->accountNum = accountNum;
        this->balance = balance;
        this->p = new int;
        *p = balance;
        display();
        cout << "P: "<< *p << endl;
    }

    // inline constructor
    inline Customer(string name, long long accountNum): name(name), accountNum(accountNum), balance(0){
        cout << "\nInitialized using Inline Constructor:" << endl;
        display();
    }

    //copy constructor 
    Customer(Customer &B){
        cout << "\nInitialized using copy Constructor:" << endl;
        name = B.name;
        accountNum = B.accountNum;
        balance = B.balance;
        display();
    }

    // destructor for unallocating the allocated storage or closing opened files etc ...
    ~Customer(){
        cout << "\nDestructor is called\n" << endl;
        delete p;
    }

    void display(){
        cout << "\n\nCustomer Details:\n" << endl;
        cout << "Name: " << name << endl;
        cout << "Account Number: " << accountNum << endl;
        cout << "Balance: " << balance << endl;
    }
};

int main() {

    // constructors are called in order 
    // but destructors are called in reverse order

    Customer A1;
    Customer A2("Himanshu Singh", 40216449825, 1200.00);
    // A1.display();
    // A2.display();

    Customer A3("Himanshu Singh", 2256565655);

    Customer A4(A2);
    // A3.display();
    // A4.display();

    
    return 0;
}