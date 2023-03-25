#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

void dfs1(vector<vector<int>> &tree, vector<int> &size, vector<int> &parent,
          int here) {
    size[here] = 1;
    for (auto &next : tree[here]) {
        parent[next] = here;
        dfs1(tree, size, parent, next);
        size[here] += size[next];
        if (size[next] > size[tree[here][0]])
            swap(next, tree[here][0]);
    }
}

int idx = 1;

void dfs2(vector<vector<int>> &tree, vector<int> &in, vector<int> &out,
          vector<int> &top, int here) {
    in[here] = idx++;
    for (auto next : tree[here]) {
        top[next] = next == tree[here][0] ? top[here] : next;
        dfs2(tree, in, out, top, next);
    }
    out[here] = idx;
}

void update(vector<int> &seg, int value, int left, int right, int root,
            int start, int end) {
    if (right < start || left > end)
        return;
    if (left <= start && end <= right) {
        seg[root] += value;
        return;
    }

    int mid = (start + end) / 2;
    update(seg, value, left, right, root * 2, start, mid);
    update(seg, value, left, right, root * 2 + 1, mid + 1, end);
}

void getRes(vector<int> &seg, int target, int root, int start, int end) {
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

    getRes(seg, target, root * 2, start, mid);
    getRes(seg, target, root * 2 + 1, mid + 1, end);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M, t;
    cin >> N >> M;

    vector<vector<int>> tree(N + 1);
    vector<int> size(N + 1);
    vector<int> parent(N + 1);
    vector<int> top(N + 1, 1);
    vector<int> in(N + 1);
    vector<int> out(N + 1);

    cin >> t;
    for (int i = 2; i <= N; i++) {
        cin >> t;
        tree[t].push_back(i);
    }

    dfs1(tree, size, parent, 1);
    dfs2(tree, in, out, top, 1);

    vector<int> seg(N * 4);

    int a, b, c;
    bool isFlowDown = true;
    for (int i = 0; i < M; i++) {
        cin >> a;
        if (a == 1) {
            cin >> b >> c;
            if (isFlowDown) {
                update(seg, c, in[b], out[b] - 1, 1, 1, N);

            } else {
                while (top[b] != 1) {
                    update(seg, c, in[top[b]], in[b], 1, 1, N);
                    b = parent[top[b]];
                }
                update(seg, c, in[top[b]], in[b], 1, 1, N);
            }
        } else if (a == 2) {
            cin >> b;
            getRes(seg, in[b], 1, 1, N);
        } else {
            isFlowDown = !isFlowDown;
        }
    }

    return 0;
}
