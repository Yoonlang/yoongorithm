#include <iostream>
#include <vector>

using namespace std;

typedef pair<int, int> pi;

int idx = 1;

void dfs(vector<vector<int>> &tree, vector<int> &in, vector<int> &out,
         int here) {
    in[here] = idx++;

    for (auto next : tree[here]) {
        dfs(tree, in, out, next);
    }

    out[here] = idx;
}

pi makeSeg(vector<pi> &seg, int root, int start, int end) {
    if (start == end)
        return seg[root] = {1, 0};

    int mid = (start + end) / 2;
    auto l = makeSeg(seg, root * 2, start, mid);
    auto r = makeSeg(seg, root * 2 + 1, mid + 1, end);
    return seg[root] = {l.first + r.first, 0};
}

int update(vector<pi> &seg, int value, int left, int right, int root, int start,
           int end) {
    if (right < start || left > end)
        return seg[root].first;
    if (left <= start && end <= right) {
        seg[root].second = value;
        return seg[root].first = value == -1 ? 0 : (end - start + 1);
    }

    int mid = (start + end) / 2;

    if (seg[root].second == 1) {
        seg[root * 2].second = 1;
        seg[root * 2].first = (mid - start + 1);
        seg[root * 2 + 1].second = 1;
        seg[root * 2 + 1].first = end - mid;
    } else if (seg[root].second == -1) {
        seg[root * 2].second = -1;
        seg[root * 2].first = 0;
        seg[root * 2 + 1].second = -1;
        seg[root * 2 + 1].first = 0;
    }
    seg[root].second = 0;

    return seg[root].first =
               update(seg, value, left, right, root * 2, start, mid) +
               update(seg, value, left, right, root * 2 + 1, mid + 1, end);
}

int query3(vector<pi> &seg, int left, int right, int root, int start, int end) {
    if (right < start || left > end)
        return 0;
    if (left <= start && end <= right)
        return seg[root].first;

    int mid = (start + end) / 2;

    if (seg[root].second == 1) {
        seg[root * 2].second = 1;
        seg[root * 2].first = (mid - start + 1);
        seg[root * 2 + 1].second = 1;
        seg[root * 2 + 1].first = end - mid;
    } else if (seg[root].second == -1) {
        seg[root * 2].second = -1;
        seg[root * 2].first = 0;
        seg[root * 2 + 1].second = -1;
        seg[root * 2 + 1].first = 0;
    }
    seg[root].second = 0;

    return query3(seg, left, right, root * 2, start, mid) +
           query3(seg, left, right, root * 2 + 1, mid + 1, end);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M, t;
    cin >> N;

    vector<vector<int>> tree(N + 1);
    cin >> t;
    for (int i = 2; i <= N; i++) {
        cin >> t;
        tree[t].push_back(i);
    }

    vector<int> in(N + 1);
    vector<int> out(N + 1);

    dfs(tree, in, out, 1);

    vector<pi> seg(N * 4);
    makeSeg(seg, 1, 1, N);

    int a, b;
    cin >> M;
    for (int i = 0; i < M; i++) {
        cin >> a >> b;
        if (a == 3) {
            cout << query3(seg, in[b] + 1, out[b] - 1, 1, 1, N) << '\n';
        } else {
            update(seg, a == 1 ? 1 : -1, in[b] + 1, out[b] - 1, 1, 1, N);
        }
    }

    return 0;
}
