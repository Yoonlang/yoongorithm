#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

typedef long long ll;
typedef pair<ll, ll> pi;

void dfs1(vector<vector<int>> &tree, vector<int> &size, vector<int> &parent,
          vector<int> &depth, int here) {
    size[here] = 1;

    for (auto &next : tree[here]) {
        depth[next] = depth[here] + 1;
        parent[next] = here;

        dfs1(tree, size, parent, depth, next);

        size[here] += size[next];
        if (size[next] > size[tree[here][0]])
            swap(next, tree[here][0]);
    }
}

int idx = 1;

void dfs2(vector<vector<int>> &tree, vector<int> &in, vector<int> &reverseIn,
          vector<int> &out, vector<int> &top, int here) {
    reverseIn[idx] = here;
    in[here] = idx++;

    for (auto &next : tree[here]) {
        int forIdx = &next - &tree[here][0];
        top[next] = forIdx == 0 ? top[here] : next;
        dfs2(tree, in, reverseIn, out, top, next);
    }

    out[here] = idx;
}

ll update(vector<pi> &seg, bool pos, int left, int right, int root, int start,
          int end) {
    if (right < start || left > end)
        return 0;
    if (left <= start && end <= right) {
        pos ? seg[root].second++ : seg[root].second--;
        return seg[root].first + seg[root].second * (end - start + 1);
    }

    seg[root].first +=
        (pos ? 1 : -1) * (min(right, end) - max(left, start) + 1);
    if (seg[root].second != 0) {
        seg[root].first += (end - start + 1) * seg[root].second;
        seg[root * 2].second += seg[root].second;
        seg[root * 2 + 1].second += seg[root].second;
        seg[root].second = 0;
    }

    int mid = (start + end) / 2;
    return update(seg, pos, left, right, root * 2, start, mid) +
           update(seg, pos, left, right, root * 2 + 1, mid + 1, end);
}

ll find(vector<pi> &seg, int target, int root, int start, int end) {
    if (target < start || target > end)
        return 0;
    if (target == start && end == target) {
        return seg[root].first + seg[root].second;
    }

    if (seg[root].second != 0) {
        seg[root].first += (end - start + 1) * seg[root].second;
        seg[root * 2].second += seg[root].second;
        seg[root * 2 + 1].second += seg[root].second;
        seg[root].second = 0;
    }

    int mid = (start + end) / 2;
    return find(seg, target, root * 2, start, mid) +
           find(seg, target, root * 2 + 1, mid + 1, end);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M, t;
    cin >> N >> M;

    vector<bool> list(N + 1); // true : 흰색
    for (int i = 1; i <= N; i++) {
        cin >> t;
        list[i] = t == 1 ? true : false;
    }

    vector<vector<int>> tree(N + 1);
    for (int i = 2; i <= N; i++) {
        cin >> t;
        tree[t].push_back(i);
    }

    vector<int> size(N + 1);
    vector<int> parent(N + 1);
    vector<int> depth(N + 1);
    vector<int> in(N + 1);
    vector<int> reverseIn(N + 1);
    vector<int> out(N + 1);
    vector<int> top(N + 1, 1);

    dfs1(tree, size, parent, depth, 1);
    dfs2(tree, in, reverseIn, out, top, 1);

    ll res = 0, pastSub = 0;
    vector<pi> seg(N * 4);
    for (int i = 1; i <= N; i++) {
        if (list[i]) {
            int ii = i;

            // 첫 노드 업데이트는 따로 하고 싶은데요 !
            // edge case ii == 1일 때. 처리 완료.
            ll inner = update(seg, true, in[ii], in[ii], 1, 1, N);
            pastSub = inner;
            if (true) { // 흰색 추가
                if (inner > 1) {
                    inner--;
                    res += inner * depth[ii];
                }
            } else {
                res -= inner * depth[ii];
            }
            if (ii == 1)
                continue;
            ii = parent[ii];

            while (top[ii] != 1) {
                ll sum = update(seg, true, in[top[ii]], in[ii], 1, 1, N);
                ll left = find(seg, in[top[ii]], 1, 1, N);
                sum += left * (depth[top[ii]] - 1);
                sum += pastSub * -1 * (depth[ii]);
                res += sum;
                ii = parent[top[ii]];
                pastSub = left;
            }
            ll sum = update(seg, true, 1, in[ii], 1, 1, N);
            ll left = find(seg, 1, 1, 1, N);
            sum -= left;
            sum += pastSub * -1 * depth[ii];
            res += sum;
        }
    }

    cout << res << '\n';

    for (int i = 0; i < M; i++) {
        cin >> t;
        list[t] = !list[t];
        int ii = t;

        ll inner = update(seg, list[t], in[ii], in[ii], 1, 1, N);
        pastSub = inner;
        if (list[t]) { // 흰색 추가
            if (inner > 1) {
                inner--;
                res += inner * depth[ii];
            }
        } else {
            res -= inner * depth[ii];
        }
        if (ii == 1) {
            cout << res << '\n';
            continue;
        }
        ii = parent[ii];

        while (top[ii] != 1) {
            ll sum = update(seg, list[t], in[top[ii]], in[ii], 1, 1, N);
            ll left = find(seg, in[top[ii]], 1, 1, N);
            sum += left * (depth[top[ii]] - 1);
            sum += pastSub * -1 * (depth[ii]);
            res += sum * (list[t] ? 1 : -1);
            ii = parent[top[ii]];
            pastSub = left;
        }
        ll sum = update(seg, list[t], 1, in[ii], 1, 1, N);
        ll left = find(seg, 1, 1, 1, N);
        sum -= left;
        sum += pastSub * -1 * depth[ii];
        res += sum * (list[t] ? 1 : -1);

        cout << res << '\n';
    }

    return 0;
}
