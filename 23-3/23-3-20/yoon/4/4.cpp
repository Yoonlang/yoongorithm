#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M, a, b;
    cin >> N >> M;

    vector<int> room(N + 1, 0);
    vector<int> sum(N + 1, 0);
    for (int i = 0; i < M; i++) {
        cin >> a >> b;
        room[a]++;
        room[b]--;
    }

    for (int i = 1; i <= N; i++) {
        sum[i] = sum[i - 1] + room[i];
    }

    int res = 0;
    for (int i = 1; i < sum.size(); i++) {
        if (sum[i] == 0)
            res++;
    }
    cout << res;

    return 0;
}