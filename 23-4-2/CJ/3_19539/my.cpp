#include <bits/stdc++.h>

using namespace std;

int tree_num;              // [1, 100_000]
int tree_heights[6] = {0}; // [0, 100_000]

// 10000 % 6 = 4
// 1000  % 6 = 4
// 100   % 6 = 4

// 0 1 1 1 3 5 6 7 7 8
// 0 0 1 1 1 5 6 7 7 8
// 0 0 0 1 1 3 6 7 7 8
// 0 0 0 0 1 1 6 7 7 8
// 0 0 0 0 1 1 0 1 1 8

int left_trees() { return tree_heights[0]; }

void print_trees() {
    for (int i = 0; i < 6; i++)
        cout << tree_heights[i] << " ";
    cout << "\n";
}

bool water_two() {
    int a = -1, b = -1;
    for (int i = 1; i < 6; i++) {
        if (tree_heights[i] > 0) {
            tree_heights[i]--;
            a = i;
            break;
        }
    }
    for (int i = 2; i < 6; i++) {
        if (tree_heights[i] > 0) {
            tree_heights[i]--;
            b = i;
            break;
        }
    }
    if (a != -1 && b != -1) {
        tree_heights[a - 1]++;
        tree_heights[b - 2]++;
        return true;
    }

    if (a != -1)
        tree_heights[a]++;
    if (b != -1)
        tree_heights[b]++;

    return false;
}

bool water_one() {
    int a = -1;
    for (int i = 3; i < 6; i++) {
        if (tree_heights[i] > 0) {
            tree_heights[i]--;
            a = i;
            break;
        }
    }
    if (a != -1) {
        tree_heights[a - 3]++;
        return true;
    }
    if (a != -1)
        tree_heights[a]++;

    return false;
}

int main(void) {
    cin >> tree_num;

    for (int i = 0; i < tree_num; i++) {
        int tree_height;
        cin >> tree_height;
        tree_height %= 6;
        tree_heights[tree_height]++;
    }

    while (1) {
        // print_trees();
        // cout << left_trees() << " " << tree_num << "\n";
        if (left_trees() == tree_num) {
            cout << "YES\n";
            return 0;
        }

        if (water_one())
            continue;
        if (water_two())
            continue;

        cout << "NO\n";
        return 0;
    }
    cout << "YES\n";

    return 0;
}