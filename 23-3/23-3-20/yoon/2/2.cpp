#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int N, S, M;

int process(vector<vector<int>> &dp, vector<int> &song, int here, int volume) {
    if (here >= N)
        return volume;

    if (dp[here][volume] != -2) {
        return dp[here][volume];
    }
    dp[here][volume] = -1;
    int next = here + 1;
    int downVolume = -1, upVolume = -1;
    if (volume - song[here] >= 0) {
        downVolume = process(dp, song, next, volume - song[here]);
    }

    if (volume + song[here] <= M)
        upVolume = process(dp, song, next, volume + song[here]);

    return dp[here][volume] = max(dp[here][volume], max(downVolume, upVolume));
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> S >> M;
    vector<int> song(N);
    vector<vector<int>> dp(N + 1, vector<int>(M + 1, -2));
    for (int i = 0; i < N; i++)
        cin >> song[i];

    int res = process(dp, song, 0, S);
    if (res < 0)
        cout << -1;
    else
        cout << res;

    return 0;
}