#include <iostream>
using namespace std;

/*
8. EQUILIBRIUM INDEX
--------------------

An index is called an EQUILIBRIUM INDEX if:

    sum of all elements to the LEFT
    ==
    sum of all elements to the RIGHT

The element at the index itself is NOT included
in either sum.

Return the FIRST equilibrium index you find.

If there is no equilibrium index, return -1.

Example:

arr = [1, 3, 5, 2, 2]

Index 2:
Left  = 1 + 3 = 4
Right = 2 + 2 = 4

So answer = 2


Example:

arr = [1, 2, 3]

No equilibrium index.

Answer = -1


Function:

int equilibriumIndex(int arr[], int n);


Rules:

1. NO vector.
2. NO map.
3. NO unordered_map.
4. NO sort().
5. Nested loops are allowed.
6. Focus on correctness first.
7. Don't worry about O(n) yet.
*/

int equilibriumIndex(int arr[], int n){
    int leftSum, rightsum;
    for (int i = 0; i < n; i++) {
        leftSum = 0, rightsum = 0;
        if(i > 0) 
            for (int j = 0; j < i; j++) {
                leftSum += arr[j];
            }
        if(i < n-1)
            for (int j = i+1; j < n; j++) {
                rightsum += arr[j];
            }

        if(leftSum == rightsum) return i;
    }

    return -1;
}


int main() {

  // ================= TEST CASES =================

  // Test 1
  int test1[] = {1, 3, 5, 2, 2};
  cout << "Test 1: " << equilibriumIndex(test1, 5) << endl;
  // Expected: 2

  // Test 2
  int test2[] = {1, 2, 3};
  cout << "Test 2: " << equilibriumIndex(test2, 3) << endl;
  // Expected: -1

  // Test 3
  int test3[] = {1, 2, 3, 3, 2, 1};
  cout << "Test 3: " << equilibriumIndex(test3, 6) << endl;
  // Expected: -1

  // Test 4
  int test4[] = {5};
  cout << "Test 4: " << equilibriumIndex(test4, 1) << endl;
  // Expected: 0

  // Test 5
  int test5[] = {2, 4, 2};
  cout << "Test 5: " << equilibriumIndex(test5, 3) << endl;
  // Expected: 1

  // Test 6
  int test6[] = {10, -10, 10, -10, 10};
  cout << "Test 6: " << equilibriumIndex(test6, 5) << endl;
  // Expected: 0
  return 0;
}
