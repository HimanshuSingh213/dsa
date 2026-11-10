#include <iostream>
#include <fstream>
using namespace std;

int main() {
    ofstream file("student.txt", ios::app);

    file << "\nSamsung Galaxy S25 FE 5G (Jetblack, 128 GB)" << endl;

    file.close();

    cout << "Data Written Successfully." << endl;


    return 0;
}