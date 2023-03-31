#include <algorithm>
#include <cmath>
#include <iostream>
#include <tuple>
#include <vector>

using namespace std;

typedef tuple<int, int, int> ti;

int sqrtN, N, K, M, a, b, L = 100000;
int nums[100001];
int res[100001];
int seg[400001];

void update(int value, int target, int root, int start, int end) {
    if (target < start || target > end)
        return;
    if (target == start && start == end) {
        seg[root] += value;
        return;
    }

    int mid = (start + end) / 2;
    update(value, target, root * 2, start, mid);
    update(value, target, root * 2 + 1, mid + 1, end);
    seg[root] = seg[root * 2] + seg[root * 2 + 1];
}
int find(int l, int r, int root, int start, int end) {
    if (r < start || l > end)
        return 0;
    if (l <= start && end <= r) {
        return seg[root];
    }

    int mid = (start + end) / 2;
    return find(l, r, root * 2, start, mid) +
           find(l, r, root * 2 + 1, mid + 1, end);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> K;
    for (int i = 1; i <= N; i++)
        cin >> nums[i];

    sqrtN = sqrt(N);

    cin >> M;
    vector<ti> querys(M);
    for (int i = 0; i < M; i++) {
        cin >> a >> b;
        querys[i] = {i, a, b};
    }

    auto [q1, q2, q3] = querys[0];
    int s = q2, e = q3, r = 0;
    for (int i = s; i <= e; i++) {
        update(1, nums[i], 1, 1, L);
        int f = find(nums[i] - K, nums[i] + K, 1, 1, L);
        if (f != 0)
            r += f - 1;
    }
    res[q1] = r;

    for (auto &query : querys) {
        int idx = &query - &querys[0];
        if (idx == 0)
            continue;
        auto [q, ss, ee] = query;

        while (s > ss) {
            s--;
            r += find(nums[s] - K, nums[s] + K, 1, 1, L);
            update(1, nums[s], 1, 1, L);
        }
        while (e < ee) {
            e++;
            r += find(nums[e] - K, nums[e] + K, 1, 1, L);
            update(1, nums[e], 1, 1, L);
        }
        while (s < ss) {
            update(-1, nums[s], 1, 1, L);
            r -= find(nums[s] - K, nums[s] + K, 1, 1, L);
            s++;
        }
        while (e > ee) {
            update(-1, nums[e], 1, 1, L);
            r -= find(nums[e] - K, nums[e] + K, 1, 1, L);
            e--;
        }

        res[q] = r;
    }

    for (int i = 0; i < M; i++) {
        cout << res[i] << '\n';
    }
    return 0;
}
