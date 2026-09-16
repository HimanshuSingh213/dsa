#include <iostream>
using namespace std;

class Student{
    public:
    void print(){
        cout << "I am a Student." << endl;
    }
};

class Male{
    public:
    void MalePrint(){
        cout << "I am Male." << endl;
    }
};

class Female{
    public:
    void FemalePrint(){
        cout << "I am Female." << endl;
    }
};

class Boy: public Student, public Male{
    public:
    void BoyPrint(){
        cout << "I am a Btech Boy." << endl;
    }
};

class Girl: public Student, public Female{
    public:
    void GirlPrint(){
        cout << "I am a Btech Girl." << endl;
    }
};



int main() {

    Girl G1;
    G1.FemalePrint();
    G1.GirlPrint();
    G1.print();

    Boy B1;
    B1.MalePrint();
    B1.print();
    B1.MalePrint();
    
    return 0;
}