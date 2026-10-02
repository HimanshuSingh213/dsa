/*
=============================================================
OOPS PRACTICE — QUESTION 2
Topic:
Operator Overloading + Friend Functions + Copy Constructor
+ Assignment Operator + Dynamic Memory + Const + Static
=============================================================

Design a class `Complex` to represent complex numbers.

Each object should contain:
    real and imaginary parts.

IMPORTANT:
Do NOT simply use two normal int/double data members.
Store the complex number's real and imaginary values using
DYNAMIC MEMORY (two dynamically allocated values).

Requirements:

1. Create class `Complex` with:
   - private dynamically allocated data for real and imaginary parts
   - static data member `objectCount`

2. Implement:
   - Default constructor
   - Parameterized constructor
   - Copy constructor
   - Destructor
   - Copy assignment operator

3. `objectCount` must track the number of currently existing
   Complex objects.

4. Overload binary `+` operator so that:

       c3 = c1 + c2

   performs complex-number addition.

5. Overload binary `-` operator so that:

       c3 = c1 - c2

   performs complex-number subtraction.

6. Overload `==` to compare two Complex objects.

7. Overload stream insertion operator `<<` so that:

       cout << c1;

   displays the complex number in a readable form.

8. Overload stream extraction operator `>>` so that:

       cin >> c1;

   allows the user to enter real and imaginary parts.

9. `operator<<` must NOT modify the Complex object.
   Use const-correctness wherever appropriate.

10. Implement a const member function:

        void display() const;

11. Demonstrate the difference between:
        Complex c2 = c1;      // Copy constructor
        c3 = c1;              // Assignment operator

12. Your copy constructor and assignment operator must perform
    DEEP COPY.

    Two different Complex objects must NOT share the same
    dynamically allocated memory.

13. Demonstrate this by:
    - creating one object
    - copying it
    - modifying the copied object
    - showing that the original object remains unchanged

14. Use a FRIEND FUNCTION for at least ONE of the following:
    - operator+
    - operator-
    - operator==

    Do not make every operator a friend just for the sake of it.

15. Add a static member function:

        static int getObjectCount();

    It should return the current number of Complex objects.

16. In main(), demonstrate:
    - parameterized construction
    - copy construction
    - assignment
    - + operator
    - - operator
    - == operator
    - << and >> operators
    - deep copy
    - object count

17. Do NOT use vector, string, smart pointers, or other
    advanced STL containers for this problem.

18. Make sure there are no:
    - memory leaks
    - double deletes
    - dangling pointers

=============================================================
*/

#include <iostream>
using namespace std;

class Complex {
  int *real;
  int *imag;

public:
  static int objectCount;
  // default constructor
  Complex() {
    real = new int(0);
    imag = new int(0);
    objectCount++;
  }

  // parametrized constructor
  Complex(int real, int imag) {
    this->real = new int(real);
    this->imag = new int(imag);
    objectCount++;
  }

  // copy constructor - with deep copy
  Complex(const Complex &obj) {
    this->real = new int(*(obj.real));
    this->imag = new int(*(obj.imag));
    objectCount++;
  }

  // destructor
  ~Complex() {
    delete imag;
    delete real;
    objectCount--;
    cout << "Complex class Destructor called." << endl;
  }

  // copy assignment constructor
  Complex &operator=(const Complex &obj) {
    *(this->imag) = *(obj.imag);
    *(this->real) = *(obj.real);

    return *this;
  }

  // addition
  friend Complex operator+(const Complex &c1, const Complex &c2) {
    int newImag = (*(c1.imag) + *(c2.imag));
    int newReal = (*(c1.real) + *(c2.real));
    return Complex(newReal, newImag);
  }

  // substraction
  Complex operator-(const Complex &c) {
    int newReal = (*(c.imag) - *(this->imag));
    int newImag = (*(c.real) - *(this->real));

    return Complex(newReal, newImag);
  }

  // equality check operator
  bool operator==(const Complex &c) const {
    return ((*(this->real) == *(c.real)) && (*(this->imag) == *(c.imag)));
  }

  friend ostream &operator<<(ostream &out, const Complex &c) {
    out << *(c.real) << " + i" << *(c.imag) << endl;
    return out;
  }

  friend istream &operator>>(istream &in, Complex &c) {
    in >> *c.real >> *c.imag;
    return in;
  }

  void display() const {
    cout << *(this->real) << " + i" << *(this->imag) << endl;
  }

  static void getObjectCount() {
    cout << "Total Objects: " << objectCount << endl;
  }
};

int Complex::objectCount = 0;

int main() {

  Complex c1(4, 5);
  Complex c2 = c1;
  Complex c3(8, 10);


  cout << "Before:" << endl;
  cout << "c1 = " << c1 << endl;
  cout << "c2 = " << c2 << endl;

  cin >> c2;

  cout << "After modifying c2:" << endl;
  cout << "c1 = " << c1 << endl;
  cout << "c2 = " << c2 << endl;

  Complex c4(c2);
  c4 == c2? cout << "true" << endl : cout << "false" << endl;
  cout << c1;
  c4.display();

  c4.getObjectCount();

  return 0;
}