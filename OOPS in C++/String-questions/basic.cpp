#include <iostream>
#include <string>
using namespace std;

int getLength(char str[]){
    int length = 0, idx = 0;

    while (str[idx] != '\0'){
        length++; idx++;
    }

    return length;
}

string concat(char str1[], char str2[]){
    string finalStr = "";

    int j = 0;
    while(str1[j] != '\0'){
        finalStr += str1[j++];
    }
    j = 0;
    while(str2[j] != '\0'){
        finalStr += str2[j++];
    }

    return finalStr;
}

int main(){
    char str[] = "Himanshu Singh";
    char str2[] = ", Web Developer";

    // by conventional method of array of characters
    cout << "\nBy Conventional Method of array of characters:\n";
    cout << "The Length of string " << str << " is " << getLength(str) << endl;

    cout << "Concatinating string "<< str <<" & "<< str2 <<": " << concat(str, str2) << endl;

    cout << "\nUsing Library Function:\n";
    // using string library
    string st1 = "Himanshu";
    string st2 = "Singh";

    cout << "Length of string " << st1 << " is " << st1.length() << endl;
    cout << "Concatinating string(using + operator) "<< st1 <<" & "<< st2 <<": " << st1 + st2 << endl;
    cout << "Concatinating string(using append function) "<< st1 <<" & "<< st2 <<": " << st1.append(st2) << endl;
    cout << "inserting string(using insert function) "<< st1 <<" & "<< st2 <<": " << st1.insert(0, "Mr. ") << endl;
    cout << "substring(using substr function) "<< st1 <<" & "<< st2 <<": " << st1.substr(0, 5) << endl;
    cout << "comparing strings(using compare function) "<< st1 <<" & "<< st2 <<": " << st1.compare(st2) << endl;
    cout << "finding string(using find function) "<< st1 <<" & "<< st2 <<": " << st1.find(st2) << endl;
    return 0;
} 