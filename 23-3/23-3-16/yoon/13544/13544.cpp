#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

vector<int> makeSeg(vector<int> &num, vector<vector<int>> &seg, int root,
                    int start, int end) {
    if (start == end) {
        return seg[root] = {num[start]};
    }

    int mid = (start + end) / 2;
    auto l = makeSeg(num, seg, root * 2, start, mid);
    auto r = makeSeg(num, seg, root * 2 + 1, mid + 1, end);
    int i = 0, j = 0;
    while (i < l.size() && j < r.size()) {
        if (l[i] < r[j]) {
            seg[root].push_back(l[i]);
            i++;
        } else {
            seg[root].push_back(r[j]);
            j++;
        }
    }
    for (; i < l.size(); i++) {
        seg[root].push_back(l[i]);
    }
    for (; j < r.size(); j++) {
        seg[root].push_back(r[j]);
    }

    return seg[root];
}

int getQueryResult(vector<vector<int>> &seg, int k, int i, int j, int root,
                   int start, int end) {
    if (start > j || end < i)
        return 0;
    if (i <= start && end <= j) {
        return seg[root].size() -
               (upper_bound(seg[root].begin(), seg[root].end(), k) -
                seg[root].begin());
    }

    int mid = (start + end) / 2;
    return getQueryResult(seg, k, i, j, root * 2, start, mid) +
           getQueryResult(seg, k, i, j, root * 2 + 1, mid + 1, end);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int N, M, a, b, c;
    cin >> N;
    vector<int> num(N + 1);
    for (int i = 1; i <= N; i++)
        cin >> num[i];
    vector<vector<int>> seg(N * 4);
    makeSeg(num, seg, 1, 1, N);

    cin >> M;
    int last_ans = 0;
    for (int i = 0; i < M; i++) {
        cin >> a >> b >> c;
        a ^= last_ans;
        b ^= last_ans;
        c ^= last_ans;
        last_ans = getQueryResult(seg, c, a, b, 1, 1, N);
        cout << last_ans << '\n';
    }

    return 0;
}
