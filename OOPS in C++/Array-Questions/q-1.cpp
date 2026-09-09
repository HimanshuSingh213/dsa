#include <iostream>
using namespace std;

// 1. TWO SUM
// -----------
// Given an array and a target, find the indices of two
// different elements whose sum equals the target.

// Example:
// arr = [2, 7, 11, 15], n = 4, target = 9
// Output: 0 1

// Function:
void twoSum(int arr[], int n, int target){
    for(int i = 0; i < n-1; i++){
        for(int j=i+1; j<n; j++){
            if(arr[i] + arr[j] == target) {
                cout << "The output is on index ["<< i <<", "<< j <<"].";
                return;
            }
         }

    }
    cout << "The Target not found!";
}



int main(){
    int arr[] = {2, 7, 11, 15};
    int n = 4, target = 9;
    twoSum(arr, n, target);
    return 0;
}
