#include <iostream>
using namespace std;

/*
STRING Q2 — COUNT VOWELS, CONSONANTS AND DIGITS
------------------------------------------------

Given a string, count:

1. Number of vowels
2. Number of consonants
3. Number of digits

For this question:

- Only English letters (A-Z, a-z) and digits (0-9)
  need to be considered.
- Ignore spaces and special characters.
- Vowels are: a, e, i, o, u
- Both uppercase and lowercase vowels count.

Function:

void countCharacters(string s, int &vowels, int &consonants, int &digits);


Example:

s = "Hello123"

vowels = 2
consonants = 3
digits = 3


Example:

s = "Programming123"

vowels = 3
consonants = 8
digits = 3


Rules:

1. NO vector.
2. NO map.
3. NO unordered_map.
4. Use loops and conditions.
5. Focus on correctness first.
*/

void countCharacters(string s, int &vowels, int &consonants, int &digits) {
    string vowel = "AaEeIiOoUu";

    int isVowel = 0;
    for (int i = 0; i < s.length(); i++) {
        isVowel = 0;
        for (int j = 0; j < 10; j++) {
            if(s[i] == vowel[j]) {
                vowels++;
                isVowel = 1;
                break;
            }
        }
        if(!isVowel){
            if(((int) s[i] >= 48) && ((int) s[i] <= 57)) {
                digits++;
                continue;
            }
            else if(((int) s[i] >= 65) && ((int) s[i] <= 90)){
                consonants++;
                continue;
            }
            else if (((int) s[i] >= 97) && ((int) s[i] <= 122)) {
                consonants++;
                continue;
            }
        }
    }
}

int main() {
  // ================= TEST CASES =================

  // Test 1
  string s1 = "Hello123";
  int v1 = 0, c1 = 0, d1 = 0;

  countCharacters(s1, v1, c1, d1);

  cout << "Test 1: " << v1 << " " << c1 << " " << d1 << endl;
  // Expected: 2 3 3

  // Test 2
  string s2 = "Programming123";
  int v2 = 0, c2 = 0, d2 = 0;

  countCharacters(s2, v2, c2, d2);

  cout << "Test 2: " << v2 << " " << c2 << " " << d2 << endl;
  // Expected: 3 8 3

  // Test 3
  string s3 = "AEIOU";
  int v3 = 0, c3 = 0, d3 = 0;

  countCharacters(s3, v3, c3, d3);

  cout << "Test 3: " << v3 << " " << c3 << " " << d3 << endl;
  // Expected: 5 0 0

  // Test 4
  string s4 = "abc123";
  int v4 = 0, c4 = 0, d4 = 0;

  countCharacters(s4, v4, c4, d4);

  cout << "Test 4: " << v4 << " " << c4 << " " << d4 << endl;
  // Expected: 1 2 3

  // Test 5
  string s5 = "123456";
  int v5 = 0, c5 = 0, d5 = 0;

  countCharacters(s5, v5, c5, d5);

  cout << "Test 5: " << v5 << " " << c5 << " " << d5 << endl;
  // Expected: 0 0 6

  // Test 6
  string s6 = "Hello World!";
  int v6 = 0, c6 = 0, d6 = 0;

  countCharacters(s6, v6, c6, d6);

  cout << "Test 6: " << v6 << " " << c6 << " " << d6 << endl;
  // Expected: 3 7 0
  return 0;
}
