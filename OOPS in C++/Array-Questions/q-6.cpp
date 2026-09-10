#include <iostream>
using namespace std;

/*
6. FIND THE DUPLICATE ELEMENT
-----------------------------

Given an array containing numbers from 1 to n-1,
exactly one number appears more than once.

Find and return the duplicate number.

Example:

arr = [1, 3, 4, 2, 2]

Output:
2


Example:

arr = [3, 1, 3, 4, 2]

Output:
3


Example:

arr = [1, 4, 2, 3, 4]

Output:
4


Function:

int findDuplicate(int arr[], int n);


Rules:

1. NO vector.
2. NO map.
3. NO unordered_map.
4. NO sort().
5. You can use nested loops.
6. Focus on getting the correct answer first.
7. Don't worry about O(n) yet.
*/

int findDuplicate(int arr[], int n) {
  for (int i = 0; i < n - 1; i++) {
    for (int j = i + 1; j < n; j++) {
      if (arr[i] == arr[j])
        return arr[i];
    }
  }

  return -1;
}

int main() {

  // ================= TEST CASES =================

  // Test 1: Duplicate at the end
  int test1[] = {1, 3, 4, 2, 2};
  cout << "Test 1: " << findDuplicate(test1, 5) << endl;
  // Expected: 2

  // Test 2: Duplicate in the middle
  int test2[] = {3, 1, 3, 4, 2};
  cout << "Test 2: " << findDuplicate(test2, 5) << endl;
  // Expected: 3

  // Test 3: Duplicate at the end
  int test3[] = {1, 4, 2, 3, 4};
  cout << "Test 3: " << findDuplicate(test3, 5) << endl;
  // Expected: 4

  // Test 4: Smallest number is duplicated
  int test4[] = {1, 1, 2, 3, 4};
  cout << "Test 4: " << findDuplicate(test4, 5) << endl;
  // Expected: 1

  // Test 5: Larger array
  int test5[] = {1, 5, 3, 6, 2, 4, 5};
  cout << "Test 5: " << findDuplicate(test5, 7) << endl;
  // Expected: 5

  // Test 6: Duplicate appears multiple times
  int test6[] = {2, 1, 3, 2, 4, 2};
  cout << "Test 6: " << findDuplicate(test6, 6) << endl;
  // Expected: 2

  return 0;
}
