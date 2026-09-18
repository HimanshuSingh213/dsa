#include <iostream>
using namespace std;

typedef struct Activity{
    int start;
    int finish;
} Activity;

void printActivity(Activity Bn[], int size){
    cout << "Activities: " << endl;
    for (int i = 0; i < size; i++) {
        cout << "Activity " << i+1 << " -> " << Bn[i].start << " - " << Bn[i].finish << endl;
    }
    cout << endl;
}

int main() {
    Activity An[] = {
        {5, 9},
        {1, 2},
        {8, 11},
        {0, 6},
        {3, 4},
        {5, 7},
        {8, 12},
        {3, 8},
        {6, 10},
        {5, 9},
        {8, 9}
    };

    int n = 11;
    int lastFinish = 0;

    printActivity(An, n);

    // Bubble sort for sorting Activities by finish Time in ascending order
    for (int i = 0; i < n - 1; i++) {
        for (int j = 0; j < n - i - 1; j++) {
            if(An[j].finish > An[j+1].finish){
                Activity temp = An[j];
                An[j] = An[j + 1];
                An[j + 1] = temp;
            }
        }
    }

    printActivity(An, n);

    cout << "Selected Activities:\n" << endl;
    for (int i = 0; i < n; i++) {
        if(An[i].start >= lastFinish){
            cout << "Activity " << i+1 << endl;
            lastFinish = An[i].finish;
        }
    }
    
    return 0;
}