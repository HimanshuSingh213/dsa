#include <iostream>
#include "exception"
using namespace std;


// basic structure of exception class and subclass runtime_error

// class exception{
//     string msg;

//     public:
//     exception(string msg){
//         this->msg = msg;
//     }

//     string what(){
//         return msg;
//     }
// };

// class runtime_error: public exception{
//     public:
//     runtime_error(const string &msg): exception(msg)
// };

int main() {
    try{
        int *p = new int[100000000000000000];
        cout << "Memory allocated successfully." << endl;
        delete []p;
    }
    catch(const exception &msg){
        cout << "Error occured: " << msg.what() << endl;
    }
    return 0;
}