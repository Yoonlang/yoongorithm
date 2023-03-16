#include <iostream>
#include <vector>

using namespace std;

bool dfs(vector<vector<int>> &city, int here, int prev, int &res) {
    bool flag = false; // flag가 false => 경찰서 설치 X
    for (auto next : city[here]) {
        if (next == prev)
            continue;
        if (!dfs(city, next, here, res)) {
            if (!flag)
                res++;
            flag = true;
        }
    }
    return flag;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int N, a, b;
    cin >> N;

    vector<vector<int>> city(100001);
    for (int i = 0; i < N - 1; i++) {
        cin >> a >> b;
        city[a].push_back(b);
        city[b].push_back(a);
    }
    int res = 0;
    dfs(city, 1, 0, res);
    cout << res;
    return 0;
}
