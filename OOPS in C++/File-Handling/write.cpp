#include <iostream>
#include <fstream>
using namespace std;

int main() {
    ofstream file("student.txt");

    file << "Name: Himanshu Singh" << endl;
    file << "Enrollment no.: 40216449825" << endl;
    file << "Branch: CSE-DS" << endl;

    file.close();

    cout << "Data Written Successfully." << endl;


    return 0;
}