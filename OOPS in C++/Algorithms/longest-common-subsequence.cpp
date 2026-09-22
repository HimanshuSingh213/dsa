#include <iostream>
#include "chrono"

using namespace std;

// recursive lcs
int lcs(string a, string b, int i, int j)
{
    if(i >= a.length() || j >= b.length()){
        return 0;
    }

    if(a[i] == b[j]){

        return 1 + lcs(a, b, i + 1, j + 1);
    }
    else{
        return max(lcs(a, b, i + 1, j), lcs(a, b, i, j + 1));
    }
}


// Lcs by Dynamic Programming recursion
int dp[100][100];

int lcsDP(string a, string b, int i, int j)
{
    if(i >= a.length() || j >= b.length()){
        return 0;
    }

    if(dp[i][j] != -1){
        return dp[i][j];
    }

    if(a[i] == b[j]){

        dp[i][j] = 1 + lcs(a, b, i + 1, j + 1);
    }
    else{
        dp[i][j] = max(lcs(a, b, i + 1, j), lcs(a, b, i, j + 1));
    }

    return dp[i][j];
}

int main()
{
    string a = "ABCBDABABCBABCBACBCACABBAC";
    string b = "BDCABAABCBBCBAABCBCBABBCAC";

    auto start1 = chrono::high_resolution_clock::now();
    // Recursive lcs
    cout << "Answer = " << lcs(a, b, 0, 0) << endl;

    auto end1 = chrono::high_resolution_clock::now();

    cout << "Time taken by normal recursion: " << (end1-start1).count() << endl;

    for (int i = 0; i < 100; i++) {
        for (int j = 0; j < 100; j++) {
            dp[i][j] = -1;
        }
    }

    auto start2 = chrono::high_resolution_clock::now();

    // lcs with dynamic programming recursion
    cout << "Answer = " << lcsDP(a, b, 0, 0) << endl;

    auto end2 = chrono::high_resolution_clock::now();

    cout << "Time taken by dp recursion: " << (end2-start2).count() << endl;

    return 0;
}