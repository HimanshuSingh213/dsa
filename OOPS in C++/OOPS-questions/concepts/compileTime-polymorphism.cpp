#include <iostream>
using namespace std;

class Area{
    public:

    // Function overloading 
    int calculateArea(int r){
        return 3.14*r*r;
    }

    int calculateArea(int l, int b){
        return l*b;
    }
};

class Complex{
    int real, img;

    public:
    Complex(int real, int img){
        this->real = real;
        this->img = img;
    }

    Complex(){

    }

    void display(){
        cout << "Complex no.: "<< real << " + i" << img << endl;
    }

    // operator overloading
    Complex operator +(Complex &C){
        Complex ans;
        ans.real = real + C.real;
        ans.img = img + C.img;
        return ans;
    }
};

int main() {

    Area A1;
    cout << "The Area of rectangle is " << A1.calculateArea(12,3) << endl;
    cout << "The Area of Circle is " << A1.calculateArea(12) << endl;

    cout << "\n" << endl;

    Complex C1(3, 2);
    Complex C2(4, 6);
    C1.display();
    C2.display();

    Complex C3 = C1 + C2;
    cout << "Vector addition: " << endl;
    C3.display();
    return 0;
}