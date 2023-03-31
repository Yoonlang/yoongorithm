// 참고 https://justicehui.github.io/ps/2019/06/13/BOJ13548/

#include <algorithm>
#include <cmath>
#include <iostream>
#include <tuple>
#include <vector>

using namespace std;

typedef tuple<int, int, int> ti;

int sqrtN, N, M, a, b, K = 100000;

int nums[100001];
int cnt[100001];
int table[100001];
int res[100001];

bool compare(const ti p, const ti q) {
    auto [p1, p2, p3] = p;
    auto [q1, q2, q3] = q;
    if (p2 / sqrtN == q2 / sqrtN)
        return p3 < q3;
    return p2 / sqrtN < q2 / sqrtN;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> N;
    for (int i = 1; i <= N; i++)
        cin >> nums[i];

    sqrtN = sqrt(N);

    cin >> M;
    vector<ti> querys(M);
    for (int i = 0; i < M; i++) {
        cin >> a >> b;
        querys[i] = {i, a, b};
    }

    sort(querys.begin(), querys.end(), compare);

    int r = 1, s = 1, e = 1;
    cnt[nums[s]]++;
    table[cnt[nums[s]]]++;
    for (auto q : querys) {
        auto [qq, ss, ee] = q;
        while (s > ss) {
            s--;
            if (cnt[nums[s]] != 0) {
                table[cnt[nums[s]]]--;
            }
            cnt[nums[s]]++;
            table[cnt[nums[s]]]++;
            r = max(r, cnt[nums[s]]);
        }
        while (e < ee) {
            e++;
            if (cnt[nums[e]] != 0) {
                table[cnt[nums[e]]]--;
            }
            cnt[nums[e]]++;
            table[cnt[nums[e]]]++;
            r = max(r, cnt[nums[e]]);
        }
        while (s < ss) {
            table[cnt[nums[s]]]--;
            if (r == cnt[nums[s]] && table[cnt[nums[s]]] == 0)
                r--;
            cnt[nums[s]]--;
            table[cnt[nums[s]]]++;
            s++;
        }
        while (e > ee) {
            table[cnt[nums[e]]]--;
            if (r == cnt[nums[e]] && table[cnt[nums[e]]] == 0)
                r--;
            cnt[nums[e]]--;
            table[cnt[nums[e]]]++;
            e--;
        }
        res[qq] = r;
    }

    for (int i = 0; i < M; i++)
        cout << res[i] << '\n';
    return 0;
}
