#include <bits/stdc++.h>

using namespace std;

int N, M;
vector<int> before[32001];
bool printed[32001];

void printFirst(int n) {
    if (printed[n])
        return;

    printed[n] = true;

    for (auto k : before[n]) {
        printFirst(k);
    }
    cout << n << " ";
}

int main(void) {
    cin >> N >> M;

    for (int i = 0; i < M; i++) {
        int require, num;
        cin >> require >> num;
        before[num].push_back(require);
    }

    for (int i = 1; i <= N; i++) {
        if (printed[i])
            continue;
        if (before[i].size() == 0) {
            cout << i << " ";
            printed[i] = true;
            continue;
        }
        printFirst(i);
    }

    return 0;
}