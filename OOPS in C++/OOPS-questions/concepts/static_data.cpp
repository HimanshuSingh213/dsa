#include <iostream>
using namespace std;

class BankAccount{
    string master;
    int account_no;
    int balance;

    static int Accounts;
    static int Total_Deposits;

    public:
    BankAccount(string x, int y, int z){
        master = x;
        account_no = y;
        balance = z;

        Accounts++;
        Total_Deposits += z;
    }

    void display(){
        cout << "\nMaster: "<< master << endl;
        cout << "Account No.: "<< account_no << endl;
        cout << "Balance: "<< balance << endl;
    }

    static void getBankData(){
        cout << "\nTotal Deposits: "<< Total_Deposits << endl;
        cout << "Total no. of Accounts: "<< Accounts << endl;
        cout << "\n" << endl;
    }

    void deposit(int amount){
        if(amount > 0) balance += amount;
    }

    void withdraw(int amount){
        if(amount < balance){
            balance -= amount;
            cout << "Dear "<< master << ", Amount Rs." << amount << " has been withdrawn from Account No." << account_no << endl;
        }
        else {
            cout << "Insufficient balance." << endl;
        }
    }
};

int BankAccount::Accounts = 0;
int BankAccount::Total_Deposits = 0;

int main() {

    BankAccount B1("Himanshu Singh", 101, 1000);
    B1.display();

    BankAccount::getBankData();

    BankAccount B2("Anuj Kumar", 102, 18000);
    B2.display();

    BankAccount::getBankData();

    B1.deposit(1200);
    B1.display();

    B2.withdraw(2000);
    
    BankAccount::getBankData();
    
    return 0;
}