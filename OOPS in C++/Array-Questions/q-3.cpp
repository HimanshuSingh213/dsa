#include <iostream>
using namespace std;

/*
3. SECOND LARGEST DISTINCT ELEMENT
----------------------------------

Given an array of integers, find the SECOND LARGEST
DISTINCT element.

Example:

arr = [10, 5, 8, 10, 3]

Output:
8


Example:

arr = [5, 5, 4, 3]

Output:
4


Example:

arr = [10, 20, 5, 20, 15]

Output:
15


Function:

int secondLargest(int arr[], int n);


Rules:

1. NO vector.
2. NO sort().
3. The largest and second largest must be DISTINCT.
4. You can assume that a second largest distinct element
   always exists.

*/

int secondLargest(int arr[], int n) {
    int largest = -1, secondLargest = -1;

    for (int i = 0; i < n; i++) {
        if (arr[i] > largest)
            largest = arr[i];
    }

    cout << "\nLargest: " << largest << endl;

    for (int i = 0; i < n; i++) {
        if ((arr[i] > secondLargest) && (arr[i] < largest))
            secondLargest = arr[i];
    }

    cout << "Second Largest: " << secondLargest << endl;

    return secondLargest;
}

int main() {
    int arr1[] = {10, 5, 8, 10, 3}, arr2[] = {5, 5, 4, 3},
        arr3[] = {10, 20, 5, 20, 15};

    cout << "Second largest of arr[1]: " << secondLargest(arr1, 5) << endl;
    cout << "Second largest of arr[2]: " << secondLargest(arr2, 4) << endl;
    cout << "Second largest of arr[3]: " << secondLargest(arr3, 5) << endl;

    return 0;
}
