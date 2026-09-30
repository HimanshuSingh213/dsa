/*
QUESTION 2: Complex Number Calculator using Friend Function

Create a class `Complex` to represent a complex number.

Requirements:

1. The class must contain two private data members:
   - real
   - imaginary

2. Implement:
   - A default constructor
   - A parameterized constructor
   - A member function `display()` to print the complex number

3. Create a FRIEND FUNCTION:
       Complex add(const Complex&, const Complex&);

   It must:
   - Accept two Complex objects by const reference.
   - Access their private members directly.
   - Return a NEW Complex object containing their sum.

4. Also create another friend function:
       bool isEqual(const Complex&, const Complex&);

   It should return true if both complex numbers have identical
   real and imaginary parts.

5. In main():
   - Create two Complex objects using parameterized constructors.
   - Add them using the friend function.
   - Display the result.
   - Check whether the two original objects are equal.

6. Keep the data members PRIVATE.
   Do not create public getters just to implement the friend functions.

7. Do not use global variables.

Concepts being tested:
- Class and objects
- Encapsulation
- Data hiding
- Private members
- Constructors
- Objects as function arguments
- Objects as return values
- const references
- Friend functions
- Accessing private data through friend functions

BONUS:
Add a friend function:
    void compareMagnitude(const Complex&, const Complex&);

that prints which complex number has the larger magnitude.

Do NOT use operator overloading for this question.
*/

#include <iostream>
using namespace std;

class Complex{
    int real;
    int imaginary;
    
    public:
    Complex(){
        real = 0;
        imaginary = 0;
    }

    Complex(int real, int imaginary){
        this->real = real;
        this->imaginary = imaginary;
    }

    void display(){
        cout << real << " + i" << imaginary << endl;
    }

    friend Complex add(const Complex &c1, const Complex &c2);

    friend bool isEqual(const Complex &c1, const Complex &c2);
};

Complex add(const Complex &c1, const Complex &c2){
    Complex c3(c1.real + c2.real, c1.imaginary + c2.imaginary);
    return c3;
}

bool isEqual(const Complex &c1, const Complex &c2){
    return ((c1.real == c2.real) && (c1.imaginary == c2.imaginary));
}

int main() {
    
    Complex c1(2,3);
    Complex c2(4,5);

    Complex c3 = add(c1, c2);

    c3.display();
    cout << isEqual(c1, c2) << endl;


    return 0;
}