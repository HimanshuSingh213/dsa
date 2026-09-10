#include <iostream>
using namespace std;

/*
5. FIND THE SMALLEST MISSING POSITIVE
-------------------------------------

Given an array of integers, find the smallest POSITIVE
integer (1, 2, 3, ...) that does NOT appear in the array.

Example:

arr = [1, 2, 4, 5]

Output:
3


Example:

arr = [3, 4, -1, 1]

Output:
2


Example:

arr = [1, 2, 3, 4]

Output:
5


Example:

arr = [-3, -2, 0, 2, 5]

Output:
1


Function:

int smallestMissingPositive(int arr[], int n);


Rules:

1. NO vector.
2. NO map.
3. NO sort().
4. You can use another normal array if needed.
5. Focus on getting the correct answer first.
6. Don't worry about making it O(n) yet.

*/

int smallestMissingPositive(int arr[], int n) {
  // finding largest
  int largest = -99999, found = 0;
  for (int i = 0; i < n; i++) {
    if (arr[i] > largest)
      largest = arr[i];
  }

  if (largest < 1)
    return 1;

  // looping to find the lowest number through scanning full array for each number.
  for (int i = 1; i <= largest; i++) {
    found = 0;
    for (int j = 0; j < n; j++) {
      if (arr[j] == i) {
        found = 1;
        break;
      }
    }
    if (!found)
      return i;
  }

  return largest+1;
}

int main() {
  // ================= TEST CASES =================

  // Test 1: Missing number in the middle
  int test1[] = {1, 2, 4, 5};
  cout << "Test 1: " << smallestMissingPositive(test1, 4) << endl;
  // Expected: 3

  // Test 2: Negative number + missing 2
  int test2[] = {3, 4, -1, 1};
  cout << "Test 2: " << smallestMissingPositive(test2, 4) << endl;
  // Expected: 2

  // Test 3: Complete sequence
  int test3[] = {1, 2, 3, 4};
  cout << "Test 3: " << smallestMissingPositive(test3, 4) << endl;
  // Expected: 5

  // Test 4: No positive numbers
  int test4[] = {-3, -2, 0, -5};
  cout << "Test 4: " << smallestMissingPositive(test4, 4) << endl;
  // Expected: 1

  // Test 5: Unsorted array
  int test5[] = {7, 2, 1, 5, 3, 6};
  cout << "Test 5: " << smallestMissingPositive(test5, 6) << endl;
  // Expected: 4

  // Test 6: Duplicate values
  int test6[] = {1, 1, 2, 2, 4, 4};
  cout << "Test 6: " << smallestMissingPositive(test6, 6) << endl;
  // Expected: 3

  // Test 7: Zero and negative values
  int test7[] = {0, -1, 2, 3, 4};
  cout << "Test 7: " << smallestMissingPositive(test7, 5) << endl;
  // Expected: 1

  // Test 8: Missing 1
  int test8[] = {2, 3, 4, 5};
  cout << "Test 8: " << smallestMissingPositive(test8, 4) << endl;
  // Expected: 1
  return 0;
}
