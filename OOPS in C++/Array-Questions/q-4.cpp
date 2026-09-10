#include <iostream>
using namespace std;

/*
4. COUNT FREQUENCY
------------------

Given an array and a number x, find how many times
x appears in the array.

Example:

arr = [1, 2, 3, 2, 4, 2, 5]
x = 2

Output:
3


Example:

arr = [5, 5, 5, 1, 2]
x = 5

Output:
3


Example:

arr = [1, 2, 3, 4]
x = 9

Output:
0


Function:

int countFrequency(int arr[], int n, int x);


Rules:

1. NO vector.
2. NO map.
3. NO sort().
4. Use a loop.
5. Return the count.

*/

int countFrequency(int arr[], int n, int x){
    int count = 0;
    for (int i = 0; i < n; i++) {
        if(arr[i] == x) count++;
    }

    return count;
}

int main(){

    int arr1[] = {1, 2, 3, 2, 4, 2, 5};
    cout << countFrequency(arr1, 7, 2) << endl;


    int arr2[] = {5, 5, 5, 1, 2};
    cout << countFrequency(arr2, 5, 5) << endl;


    int arr3[] = {1, 2, 3, 4};
    cout << countFrequency(arr3, 4, 9) << endl;

    return 0;
}
