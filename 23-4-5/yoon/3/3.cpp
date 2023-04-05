#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int N, W, a, b, res = 0;
vector<vector<int>> tree(500001);

void dfs(int here, int prev) {
    bool isLeaf = true;

    for (auto next : tree[here]) {
        if (next == prev)
            continue;
        isLeaf = false;
        dfs(next, here);
    }

    if (isLeaf)
        res++;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> W;
    for (int i = 0; i < N - 1; i++) {
        cin >> a >> b;
        tree[a].push_back(b);
        tree[b].push_back(a);
    }

    dfs(1, 0);

    cout.precision(6);
    cout << fixed << ((double)W / res) << endl;

    return 0;
}
