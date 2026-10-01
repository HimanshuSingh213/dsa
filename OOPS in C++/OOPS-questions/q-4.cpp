/*
QUESTION 4: Bank Account Management

Create a class `BankAccount` that models a simple bank account.

REQUIREMENTS:

1. PRIVATE DATA MEMBERS:
   - accountNumber
   - holderName
   - balance

2. CONSTRUCTORS:
   - Default constructor
   - Parameterized constructor

3. MEMBER FUNCTIONS:

   a) deposit(double amount)
      - Add amount to balance.
      - Reject zero/negative deposits.

   b) withdraw(double amount)
      - Subtract amount from balance only if sufficient funds exist.
      - Otherwise print an appropriate message.

   c) getBalance() const
      - Return the current balance.
      - Must be a CONST member function.

   d) display() const
      - Display all account information.
      - Must be a CONST member function.

4. REFERENCE REQUIREMENT:

   Create a function:

       void transfer(BankAccount &from,
                     BankAccount &to,
                     double amount);

   The function should transfer money from one account to another.

   IMPORTANT:
   - Do NOT return either object.
   - The transfer must modify the original objects.
   - Use references so that no unnecessary copies are created.

5. CONST REQUIREMENT:

   Create:

       void showAccount(const BankAccount &account);

   It should display the account using the object's `display()`
   function.

   You should NOT be able to modify the account inside this function.

6. STATIC MEMBER:

   Add:

       static int totalAccounts;

   Every time a BankAccount is created, increment it.

   Provide:

       static void showTotalAccounts();

7. MAIN():

   Create at least three accounts.

   Perform:
   - deposits
   - withdrawals
   - transfer between two accounts
   - display balances before and after transfer
   - display total number of accounts

8. DATA HIDING:

   `balance` must remain PRIVATE.

   Do NOT provide a public function such as:

       setBalance(...)

   that directly allows the caller to overwrite the balance.

9. BONUS:

   Create:

       const BankAccount acc(...);

   and verify which member functions can and cannot be called on
   this const object.

CONCEPTS BEING TESTED:

- Encapsulation
- Data hiding
- Abstraction
- Private members
- Constructors
- const member functions
- const objects
- const references
- Objects as function arguments
- Pass-by-reference
- Static data members
- Static member functions
- Scope resolution operator

THINK BEFORE CODING:

Why should `display()` and `getBalance()` be const?

Why should `transfer()` receive objects by reference?

Why should `showAccount()` receive a const reference?

Why is directly exposing `balance` through a setter bad encapsulation?
*/

#include <iostream>
using namespace std;

class BankAccount {
    int accountNo;
    string holderName;
    double balance;
    
    public:
    static int totaLAccount;
    BankAccount(){
        accountNo = -1;
        holderName = "";
        balance = 0;
        totaLAccount++;
        cout << "Default Constructor called." << endl;
    }

    BankAccount(int accountNo, string holderName, double balance){
        this->holderName = holderName;
        this->accountNo = accountNo;
        this->balance = balance;
        totaLAccount++;
    }

    void deposit(double amount){
        if(amount > 0) {
            balance += amount;
            cout << "Amount " << amount << " deposited to account no. " << accountNo << endl;
        }
        else
        cout << "Invalid Amount." << endl;
    }

    void withdraw(double amount){
        if(amount <= balance && amount > 0){
            balance -= amount;
            cout << "Amount " << amount << " debited from account no. " << accountNo << endl;
        }
        else
        cout << "Insufficient Amount." << endl;
    }

    double getBalance() const {
        return balance;
    }

    void display() const {
        cout << "Account Details: " << endl;
        cout << "Account Number: " << accountNo << endl;
        cout << "Holder Name: " << holderName << endl;
        cout << "Balance: " << balance << endl;
        cout << "\n" << endl;
    }

    static void transfer( BankAccount &from, BankAccount &to, double amount){
        if(from.balance >= amount && amount > 0){
            from.balance -= amount;
            cout << "Amount " << amount << " Successfully transfered from " << from.holderName << "'s account to " << to.holderName << " account." << endl;
        }
        else
        cout << "Insufficient Amount." << endl;
    }

    static void showAccount(const BankAccount &account){
        account.display();
    }

    static void showTotalAccount(){
        cout << "Total Number of Accounts: " << totaLAccount << endl;
    }
};

int BankAccount::totaLAccount = 0;

int main() {


    BankAccount b1(1000, "Himanshu Singh", 1000);
    BankAccount b2(1001, "Kaaju", 2000);

    BankAccount::showAccount(b1);
    BankAccount::showAccount(b2);

    b1.deposit(1200);

    BankAccount::transfer(b1, b2, 500);

    b1.display();

    BankAccount::showTotalAccount();

    
    return 0;
}