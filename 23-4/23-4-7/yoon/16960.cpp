#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int lamp[2001];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    vector<vector<int>> swit(2001);

    int N, M, t, a;
    cin >> N >> M;
    for (int i = 0; i < N; i++) {
        cin >> t;
        for (int j = 0; j < t; j++) {
            cin >> a;
            lamp[a]++;
            swit[i].push_back(a);
        }
    }

    for (int i = 0; i < N; i++) {
        bool isOK = true;
        for (auto idx : swit[i]) {
            if (lamp[idx] <= 1)
                isOK = false;
        }
        if (isOK) {
            cout << 1;
            return 0;
        }
    }

    cout << 0;

    return 0;
}
