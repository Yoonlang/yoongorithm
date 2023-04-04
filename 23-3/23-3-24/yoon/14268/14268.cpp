#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

int idx = 1;

int dfs(vector<vector<int>> &tree, unordered_map<int, int> &matching,
        vector<int> &underling, int here, int prev) {
    matching[here] = idx++;

    int under = 0;
    for (auto next : tree[here]) {
        if (prev == next)
            continue;

        under += dfs(tree, matching, underling, next, here);
    }

    underling[matching[here]] = under;
    return under + 1;
}

void query1(vector<int> &seg, int value, int left, int right, int root,
            int start, int end) {
    if (right < start || left > end)
        return;
    if (left <= start && end <= right) {
        seg[root] += value;
        return;
    }

    int mid = (start + end) / 2;
    query1(seg, value, left, right, root * 2, start, mid);
    query1(seg, value, left, right, root * 2 + 1, mid + 1, end);
}

void query2(vector<int> &seg, int target, int root, int start, int end) {
    if (target < start || target > end)
        return;
    if (target == start && target == end) {
        cout << seg[root] << '\n';
        return;
    }

    int mid = (start + end) / 2;
    seg[root * 2] += seg[root];
    seg[root * 2 + 1] += seg[root];
    seg[root] = 0;
    query2(seg, target, root * 2, start, mid);
    query2(seg, target, root * 2 + 1, mid + 1, end);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M, t, a, b, c;
    cin >> N >> M;
    vector<vector<int>> tree(N + 1);
    unordered_map<int, int> matching;
    vector<int> underling(N + 1);

    cin >> t;
    for (int i = 2; i <= N; i++) {
        cin >> t;
        tree[t].push_back(i);
    }

    dfs(tree, matching, underling, 1, -1);

    vector<int> seg(N * 4, 0);

    for (int i = 0; i < M; i++) {
        cin >> a >> b;
        int idx = matching[b];
        if (a == 1) {
            cin >> c;
            query1(seg, c, idx, idx + underling[idx], 1, 1, N);
        } else {
            query2(seg, idx, 1, 1, N);
        }
    }

    return 0;
}
