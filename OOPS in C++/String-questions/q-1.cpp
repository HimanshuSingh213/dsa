#include <iostream>
using namespace std;

/*
STRING Q1 — VALID PALINDROME
----------------------------

Given a string, check whether it is a PALINDROME.

A palindrome reads the same from left to right
and right to left.

Return true if it is a palindrome.
Otherwise return false.

For this question:

- Consider uppercase and lowercase as DIFFERENT.
- Ignore spaces.

Examples:

"madam"  -> true
"hello"  -> false
"naman"  -> true
"hello olleh" -> true

Function:

bool isPalindrome(string s);


Rules:

1. NO vector.
2. NO map.
3. NO unordered_map.
4. You can use loops.
5. You can use string indexing: s[i]
6. Focus on correctness first.
*/

bool isPalindrome(string s){
    string newStr = "";

    for (int i = s.length()-1; i > -1 ; i--) {
        newStr += s[i];
    }

    return s == newStr;
}


int main() {

  // ================= TEST CASES =================

  cout << boolalpha;

  // Test 1
  cout << "Test 1: " << isPalindrome("madam") << endl;
  // Expected: true

  // Test 2
  cout << "Test 2: " << isPalindrome("hello") << endl;
  // Expected: false

  // Test 3
  cout << "Test 3: " << isPalindrome("naman") << endl;
  // Expected: true

  // Test 4
  cout << "Test 4: " << isPalindrome("hello olleh") << endl;
  // Expected: true

  // Test 5
  cout << "Test 5: " << isPalindrome("abcba") << endl;
  // Expected: true

  // Test 6
  cout << "Test 6: " << isPalindrome("abca") << endl;
  // Expected: false

  // Test 7
  cout << "Test 7: " << isPalindrome("a") << endl;
  // Expected: true
  return 0;
}
