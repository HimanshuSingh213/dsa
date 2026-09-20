#include <iostream>
using namespace std;

typedef struct Input{
    int length;
    int price;
} Input;

int main() {

    Input I[] = {
        {1,2},
        {2, 6},
        {3, 7},
        {4, 12},
        {5, 14},
        {6, 17},
        {7, 20},
        {8, 23},
        {9, 25},
        {10, 30}
    };

    int n = 10;
    int dp[11] = {0};

    int max;
    for (int i = 1; i <= n; i++) {
        max = -1;
        for (int j = 0; j < i; j++) {
            cout << "price[" << i-j << "] + dp[" << j << "] = " << I[i-j-1].price << " + " << dp[j] << " = " << (I[i-j-1].price + dp[j]) << endl;
            if(max < (I[i-j-1].price + dp[j])){
                max = I[i-j-1].price + dp[j];
            }
        }
        dp[i] = max;
        cout << "dp[" << i << "] = " << max << endl;
        cout << "\n" << endl;
    }

    cout << "dp[] = ";
    for (int i = 0; i <= n; i++) {
        cout << dp[i] << " ";
    }
    
    return 0;
}