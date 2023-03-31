// 참고 https://justicehui.github.io/ps/2019/10/04/BOJ13546/

#include <algorithm>
#include <iostream>
#include <list>
#include <tuple>
#include <vector>

using namespace std;

typedef tuple<int, int, int> ti;

int bucketSize = 300;
int bucketNum = 334;
int nums[100001];
int res[100001];
int cnt[101010];
int bucket[334];

bool compare(const ti &a, const ti &b) {
    auto [a1, a2, a3] = a;
    auto [b1, b2, b3] = b;
    if (a2 / bucketSize == b2 / bucketSize) {
        return a3 < b3;
    }
    return a2 / bucketSize < b2 / bucketSize;
}

int find() {
    for (int i = bucketNum - 1; i >= 0; i--) {
        if (bucket[i] > 0) {
            for (int j = bucketSize - 1; j >= 0; j--) {
                if (cnt[i * bucketSize + j] > 0) {
                    return i * bucketSize + j;
                }
            }
        }
    }
    return 0;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M, K, a, b;
    cin >> N >> K;
    for (int i = 1; i <= N; i++)
        cin >> nums[i];
    cin >> M;
    vector<ti> querys(M);
    for (int i = 0; i < M; i++) {
        cin >> a >> b;
        querys[i] = {i, a, b};
    }

    vector<list<int>> len(K + 1);

    sort(querys.begin(), querys.end(), compare);
    auto [q1, s, e] = querys[0];
    for (int i = s; i <= e; i++) {
        if (!len[nums[i]].empty()) {
            int prev = len[nums[i]].back() - len[nums[i]].front();
            cnt[prev]--;
            bucket[prev / bucketSize]--;
        }
        len[nums[i]].push_back(i);
        int now = len[nums[i]].back() - len[nums[i]].front();
        cnt[now]++;
        bucket[now / bucketSize]++;
    }
    res[q1] = find();

    for (auto &query : querys) {
        int idx = &query - &querys[0];
        if (idx == 0)
            continue;

        auto [q1, ss, ee] = query;
        while (s > ss) {
            s--;
            if (!len[nums[s]].empty()) {
                int prev = len[nums[s]].back() - len[nums[s]].front();
                cnt[prev]--;
                bucket[prev / bucketSize]--;
            }
            len[nums[s]].push_front(s);
            int now = len[nums[s]].back() - len[nums[s]].front();
            cnt[now]++;
            bucket[now / bucketSize]++;
        }
        while (e < ee) {
            e++;
            if (!len[nums[e]].empty()) {
                int prev = len[nums[e]].back() - len[nums[e]].front();
                cnt[prev]--;
                bucket[prev / bucketSize]--;
            }
            len[nums[e]].push_back(e);
            int now = len[nums[e]].back() - len[nums[e]].front();
            cnt[now]++;
            bucket[now / bucketSize]++;
        }
        while (s < ss) {
            if (!len[nums[s]].empty()) {
                int prev = len[nums[s]].back() - len[nums[s]].front();
                cnt[prev]--;
                bucket[prev / bucketSize]--;
            }
            len[nums[s]].pop_front();
            int now = len[nums[s]].empty()
                          ? 0
                          : len[nums[s]].back() - len[nums[s]].front();
            cnt[now]++;
            bucket[now / bucketSize]++;
            s++;
        }
        while (e > ee) {
            if (!len[nums[e]].empty()) {
                int prev = len[nums[e]].back() - len[nums[e]].front();
                cnt[prev]--;
                bucket[prev / bucketSize]--;
            }
            len[nums[e]].pop_back();
            int now;
            if (len[nums[e]].empty())
                now = 0;
            else
                now = len[nums[e]].back() - len[nums[e]].front();
            cnt[now]++;
            bucket[now / bucketSize]++;
            e--;
        }
        res[q1] = find();
    }

    for (int i = 0; i < M; i++) {
        cout << res[i] << '\n';
    }

    return 0;
}
