#include <iostream>
using namespace std;

class InvalidAmountError: public runtime_error{
    public:
    InvalidAmountError(const string &msg): runtime_error(msg) {}
};

class Customer{
    string name;
    int balance, account_number;

    public:
    Customer(string name, int balance, int account_number){
        this->name = name;
        this->balance = balance;
        this->account_number = account_number;
    }

    void deposit(int amount){
        if(amount > 0){
            balance += amount;
            cout << "Amount " << amount << " credited successfully." << endl;
        }
        else
            throw InvalidAmountError("Invalid Amount");
    }

    void withdraw(int amount){
        if(balance >= amount && amount > 0){
            balance -= amount;
            cout << "Amount " << amount << " debited successfully." << endl;
        }
        else if(amount <= 0)
            throw InvalidAmountError("Amount must be greater than 0.");
        else
            throw runtime_error("Insufficient Balance");
    }

    int getBalance(){
        return balance;
    }
};

int main() {
    Customer c1("Himanshu singh", 1000, 1234567890);
    try{
        c1.deposit(1000);
        c1.withdraw(-2);
        c1.withdraw(2500);
        c1.deposit(1500);
    }
    catch(const InvalidAmountError &msg){
        cout << msg.what() << endl;
    }
    catch(const bad_alloc &msg){
        cout << msg.what() << endl;
    }
    catch(...){
        cout << "Error occured" << endl;
    }

    cout << "Account Balance: " << c1.getBalance() << endl;
    
    
    return 0;
}