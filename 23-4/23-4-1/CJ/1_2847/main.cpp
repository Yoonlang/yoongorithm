#include <bits/stdc++.h>
using namespace std;

int N;
int V[101];

int main(void) {
    cin >> N;
    for (int i = 0; i < N; i++)
        cin >> V[i];

    int res = 0;

    for (int i = N - 1; i >= 1; i--) {
        int later = i;
        int before = i - 1;
        int max_level = V[later] - 1;
        if (V[before] >= V[later]) {
            res += V[before] - max_level;
            V[before] = max_level;
        }
    }
    cout << res << "\n";
    return 0;
}