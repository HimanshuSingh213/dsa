#include "iostream"
#include <cmath>
using namespace std;

// Division Method
long long decimalToBinary(int num) {
  // Works for non-negative integer numbers

  if (num == 0)
    return 0;

  long long binary = 0;
  int i = 0;
  while (num > 0) {
    int digit = num % 2;
    binary = digit * pow(10, i++) + binary;
    num /= 2;
  }

  return binary;
}

// Bitwise Method
long long bitwiseDecimalToBinary(int num){
    if(num == 0) return 0;

    long long binary = 0;
    int i = 0;

    while(num != 0){
        int bit = num & 1;
        binary = bit * pow(10, i++) + binary;
        num = num >> 1;
    }

    return binary;
}

// Division method
int binaryToDecimal(long long num) {
  // Works for non-negative integer numbers

  if (num == 0)
    return 0;

  int i = 0, decimal = 0;
  while (num != 0) {
    int digit = num % 10;
    decimal += digit * (pow(2, i++));
    num /= 10;
  }

  return decimal;
}

// Division method
int BitwiseBinaryToDecimal(long long num) {
  // Works for non-negative integer numbers

  if (num == 0)
    return 0;

  int i = 0, decimal = 0;
  while (num != 0) {
    int digit = num ;
    decimal += digit * (pow(2, i++));
    num /= 10;
  }

  return decimal;
}

int main() {
  cout << "\nDecimal To Binary Converter\n";
  cout << "Please enter the no.: ";

  int num;
  cin >> num;

  long long binary = decimalToBinary(num);
  cout << endl << binary << endl;
  cout << "\nFor Verfication:\n";
  cout << binaryToDecimal(binary);
}