#include <iostream>
using namespace std;

/*
7. FIND THE LEADERS IN AN ARRAY
-------------------------------

An element is called a LEADER if it is greater than
ALL elements to its right.

The last element is always a leader.

Print all the leader elements from left to right.

Example:

arr = [16, 17, 4, 3, 5, 2]

Output:
17 5 2


Example:

arr = [1, 2, 3, 4, 5]

Output:
5


Example:

arr = [5, 4, 3, 2, 1]

Output:
5 4 3 2 1


Function:

void findLeaders(int arr[], int n);


Rules:

1. NO vector.
2. NO map.
3. NO unordered_map.
4. NO sort().
5. You can use nested loops.
6. Focus on getting the correct answer first.
7. Don't worry about O(n) yet.
*/

void findLeaders(int arr[], int n) {
  int isLeader;
  for (int i = 0; i < n; i++) {
    isLeader = 1;
    if (i < n - 1)
      for (int j = i + 1; j < n; j++) {
        if (arr[j] >= arr[i]) {
          isLeader = 0;
          break;
        } else {
          isLeader = 1;
        }
      }
    if (isLeader)
      cout << arr[i] << " ";
  }
  cout << "\n";
}

int main() {

  // ================= TEST CASES =================

  // Test 1
  int test1[] = {16, 17, 4, 3, 5, 2};
  cout << "Test 1: ";
  findLeaders(test1, 6);
  // Expected: 17 5 2

  // Test 2
  int test2[] = {1, 2, 3, 4, 5};
  cout << "Test 2: ";
  findLeaders(test2, 5);
  // Expected: 5

  // Test 3
  int test3[] = {5, 4, 3, 2, 1};
  cout << "Test 3: ";
  findLeaders(test3, 5);
  // Expected: 5 4 3 2 1

  // Test 4
  int test4[] = {7, 10, 4, 10, 6, 5};
  cout << "Test 4: ";
  findLeaders(test4, 6);
  // Expected: 10 6 5

  // Test 5
  int test5[] = {10, 9, 8, 7, 6};
  cout << "Test 5: ";
  findLeaders(test5, 5);
  // Expected: 10 9 8 7 6

  // Test 6
  int test6[] = {5};
  cout << "Test 6: ";
  findLeaders(test6, 1);
  // Expected: 5

  return 0;
}
