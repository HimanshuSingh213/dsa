#include <iostream>
using namespace std;

// Define the struct for the matrix dimensions
typedef struct {
    int rows, cols;
} Input;


long getLowestCost(int startIdx, int endIdx, long O[][20], Input I[]){
    
    if((endIdx - startIdx) + 1 <= 2){
        long cost =  I[startIdx].rows * I[startIdx].cols * I[endIdx].cols;
        return cost;
    }
    
    // startIdx < splitIdx < endIdx
    long min = 999999999999999999;
    
    int splitIdx = startIdx;
    while(splitIdx < endIdx) {
        // A1 * A1 | A2 * A3 for 3 
        // A1 * A2 | A3 * A3 for 3 
        if(min > O[startIdx][splitIdx] + O[splitIdx+1][endIdx] + (I[startIdx].rows * I[splitIdx].cols * I[endIdx].cols))
            min = O[startIdx][splitIdx] + O[splitIdx+1][endIdx] + (I[startIdx].rows * I[splitIdx].cols * I[endIdx].cols);
        splitIdx++;
    }

    return min;
}


int main() {
    // Define the matrices
    Input matrices[] = {
        {40, 15},
        {15, 30},
        {30, 5},
        {5, 60},
        {60, 10},
        {10, 20}
    };

    // startIdx, endIdx and their Cost 
    long matrix[20][20];

    
    // size
    int n = 6; 
    
    // initializing diagonal = 0
    for (int i = 0; i < n; i++) {
        matrix[i][i] = 0;
    }

    // Loop for chain lengths
    for (int i = 1; i < n; i++) {
        // loop for selecting the required matrices
        int matricesToSelect = (i+1);
        int startIdx = 0;
        long min;
        for (int j = 0; j < n-i; j++) {
            min = 999999999999999999;

            // getting lowest cost for the sliced Input array of matrices
            long lowestCost = getLowestCost(startIdx, matricesToSelect+startIdx-1, matrix, matrices);

            if (lowestCost < min){
                min = lowestCost;
                cout << "Minimum cost for matrices " << startIdx << " to " << matricesToSelect+startIdx-1 << " is " << min << endl;
            }
            matrix[startIdx][matricesToSelect+startIdx-1] = min;
            cout << "Matrix " << startIdx << " to " << matricesToSelect+startIdx-1 << " has cost " << min << endl;
            cout << "\n" << endl;
            startIdx++;
        }
    }

    long minimumCost = matrix[0][5];
    cout << "Minimum cost for matrices 1 to 6 is " << minimumCost << endl;  // 10000

    return 0;
}

// 
