#include <bits/stdc++.h>

using namespace std;

int N, M;
int arr[10];

void print(int n) {
    if (n > M) {
        for (int i = 1; i <= M; i++) {
            cout << arr[i] << " ";
        }
        cout << "\n";
        return;
    }
    for (int i = 1; i <= N; i++) {
        arr[n] = i;
        print(n + 1);
    }
    return;
}
int main(void) {
    cin >> N >> M;

    print(1);
    return 0;
}