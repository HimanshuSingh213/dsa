#include <iostream>
using namespace std;

class Student{
    private:
        string name;
        int age;
        long long enrollNo;
        float sgpa;

    public:
    void setName(string n){
        name = n;
    }

    void setAge(int x){
        age = x;
    }

    void setEnrollNo(long long x){
        enrollNo = x;
    }

    void setSGPA(float x){
        sgpa = x;
    }

    void Display(){
        cout << "Students Details:" << endl;
        cout << "Name: " << name << endl;
        cout << "Age: " << age << endl;
        cout << "Enrollment No.: " << enrollNo << endl;
        cout << "SGPA: " << sgpa << endl;
    }
};

int main() {
    Student s1;
    s1.setName("Himanshu Singh");
    s1.setAge(19);
    s1.setEnrollNo(40216449825);
    s1.setSGPA(7.80);


    s1.Display();


    return 0;
}