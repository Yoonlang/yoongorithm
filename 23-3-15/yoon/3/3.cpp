#include <algorithm>
#include <climits>
#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int N, M;
    cin >> N >> M;
    vector<int> wok(M);
    for (int i = 0; i < M; i++)
        cin >> wok[i];
    sort(wok.begin(), wok.end());
    if (wok.size() >= 3)
        for (int i = 0; i < wok.size() - 2; i++) {
            if (wok[i] == wok[i + 2]) {
                wok.erase(wok.begin() + i);
                i--;
            }
        }
    int ws = wok.size();
    for (int i = 0; i < ws; i++) {
        for (int j = i + 1; j < ws; j++) {
            wok.push_back(wok[i] + wok[j]);
        }
    }
    sort(wok.begin(), wok.end());
    for (int i = 0; i < wok.size() - 1; i++) {
        if (wok[i] == wok[i + 1]) {
            wok.erase(wok.begin() + i);
            i--;
        }
    }

    vector<int> dp(N + 1, INT_MAX);
    dp[0] = 0;

    for (int i = 1; i <= N; i++) {
        for (int j = 0; j < wok.size(); j++) {
            if (wok[j] > i)
                break;
            dp[i] =
                min(dp[i - wok[j]] == INT_MAX ? INT_MAX : dp[i - wok[j]] + 1,
                    dp[i]);
        }
    }

    cout << (dp[N] == INT_MAX ? -1 : dp[N]);

    return 0;
}
