#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

typedef long long ll;
typedef pair<int, ll> pi;

pi makeSeg(vector<int> &nums, vector<vector<pi>> &seg, int root, int start,
           int end) {
    if (start == end) {
        seg[root].push_back({0, nums[start]});
        return {0, nums[start]};
    }

    int mid = (start + end) / 2;
    auto l = makeSeg(nums, seg, root * 2, start, mid);
    auto r = makeSeg(nums, seg, root * 2 + 1, mid + 1, end);

    seg[root].push_back({0, l.second + r.second});
    return {0, l.second + r.second};
}

ll changeSeg(vector<vector<pi>> &seg, int target, int toChange, int root,
             int start, int end, int idx) {
    if (target < start || target > end)
        return 0;
    if (target == start && target == end) {
        ll diff = toChange - seg[root].back().second;
        seg[root].push_back({idx, toChange});
        return diff;
    }

    int mid = (start + end) / 2;
    ll l = changeSeg(seg, target, toChange, root * 2, start, mid, idx);
    ll r = changeSeg(seg, target, toChange, root * 2 + 1, mid + 1, end, idx);
    ll lastValue = seg[root].back().second;
    seg[root].push_back({idx, lastValue + l + r});
    return l + r;
}

bool compare(const pi &a, const pi &b) { return a.first < b.first; }

ll getSeg(vector<vector<pi>> &seg, int left, int right, int root, int start,
          int end, int idx) {
    if (right < start || left > end)
        return 0;
    if (left <= start && end <= right) {
        int getIdx = upper_bound(seg[root].begin(), seg[root].end(), pi(idx, 0),
                                 compare) -
                     seg[root].begin();
        getIdx--;
        return seg[root][getIdx].second;
    }

    int mid = (start + end) / 2;
    return getSeg(seg, left, right, root * 2, start, mid, idx) +
           getSeg(seg, left, right, root * 2 + 1, mid + 1, end, idx);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M;
    cin >> N;

    vector<int> nums(N + 1);
    vector<vector<pi>> seg(N * 4);

    for (int i = 1; i <= N; i++)
        cin >> nums[i];

    makeSeg(nums, seg, 1, 1, N);

    int a, b, c, d, idx = 1;
    cin >> M;
    for (int i = 0; i < M; i++) {
        cin >> a >> b >> c;
        if (a == 1) {
            changeSeg(seg, b, c, 1, 1, N, idx);
            idx++;
        } else {
            cin >> d;
            cout << getSeg(seg, c, d, 1, 1, N, b) << '\n';
        }
    }

    return 0;
}
