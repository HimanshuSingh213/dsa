#include <iostream>
using namespace std;

typedef struct Input{
    char ch;
    int freq;
} Input;

typedef struct Node{
    char ch;    // character 
    int freq;   // frequency
    int left = -1;   // index of left child 
    int right = -1;  // index of right child 
} Node;

void printInput(Input K[], int n){
    cout << " char | freq "  << endl;
    cout << "-------------" << endl;
    for (int i = 0; i < n; i++) {
        cout << "  " << K[i].ch << "  |   " << K[i].freq << endl;
    }
}

void printNodes(Node tree[], int count){
    cout << " char | freq | left Child Index | right Child Index"  << endl;
    cout << "---------------------------------------------------" << endl;
    for (int i = 0; i < count; i++) {
        cout << "  " << tree[i].ch << "  |   " << tree[i].freq << "  |    " << tree[i].left << "     |     " << tree[i].right << endl;
    }
}

void printCodes(int root, string code, Node tree[]){
    if(tree[root].left == -1 && tree[root].right == -1){
        cout << tree[root].ch << " : " << code << endl;
        return;
    }

    printCodes(tree[root].left, code + "0", tree);
    printCodes(tree[root].right, code + "1", tree);
}

int main() {

    Node tree[20];  
    int count = 0 ;   // count for how many nodes we have created 

    Input I[] = {
        {'A', 15},
        {'B', 7},
        {'C', 6},
        {'D', 5},
        {'E', 4}
    };

    // size
    int n = 5;
    printInput(I, n);

    // initializing nodes
    for (int i = 0; i < n; i++) {
        tree[count].ch = I[i].ch;
        tree[count].freq = I[i].freq;
        count++;
    }

    cout << "\n" << endl;
    printNodes(tree, count);

    int active = n;  // active nodes that will be decreased after combining two nodes

    while (active > 1){
        // storing minimum number indexes 
        int min1 = -1, min2 = -1;
        
        // finding first minimum
        for (int i = 0; i < count; i++) {
            if(tree[i].freq != -1){
                if(min1 == -1 || tree[i].freq < tree[min1].freq){
                    min1 = i;
                }
            }
        }
        
        // finding second minimum
        for (int i = 0; i < count; i++) {
            if(tree[i].freq != -1 && i != min1){
                if(min2 == -1 || tree[i].freq < tree[min2].freq){
                    min2 = i;
                }
            }
        }

        // combining and creating a parent node
        tree[count].ch = '#';    // combined node not an actual character
        tree[count].freq = tree[min1].freq + tree[min2].freq;
        tree[count].left = min1;
        tree[count].right = min2;

        // removing both combined from consideration
        tree[min1].freq = -1;
        tree[min2].freq = -1;

        count++;
        active--;

    }

    int root = count - 1;

    cout << "Huffman Codes:\n";
    printCodes(root, "", tree);

    
    return 0;
}