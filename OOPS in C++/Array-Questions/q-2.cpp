#include <iostream>
using namespace std;

/*
2. MOVE ALL ZEROS TO END
------------------------

Given an array, move all 0s to the END of the array.

The order of the NON-ZERO elements must remain the same.

Example:

arr = [0, 1, 0, 3, 12]

Output:

[1, 3, 12, 0, 0]


Example:

arr = [1, 0, 2, 0, 4]

Output:

[1, 2, 4, 0, 0]


Function:

void moveZeros(int arr[], int n);


Rules:

1. NO vector.
2. NO sort().
3. You can use another array if you want.
4. Do not change the order of non-zero elements.

*/

void moveZeros(int arr[], int n){
    int zeroCount = 0;

    cout << "\nBefore:\n";
    for(int i = 0; i < n; i++) cout << arr[i] << " ";  

    for(int i = 0; i < n-1; i++){
        if(arr[i] != 0) continue;

        zeroCount++;
        for(int j = i+1; j < n; j++){
            if(arr[j] != 0){ 
                // swap(arr[i], arr[j])
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                break;
            };
        }
    }

    cout << "\nZero Count: " << zeroCount << endl;

    cout << "\nAfter: \n";
    for(int i = 0; i < n; i++) cout << arr[i] << " "; 
}


int main(){
    int arr1[] = {0, 1, 0, 3, 12};
    int arr2[] = {1, 0, 2, 0, 4};

    moveZeros(arr1, 5);
    moveZeros(arr2, 5);
    return 0;
}
