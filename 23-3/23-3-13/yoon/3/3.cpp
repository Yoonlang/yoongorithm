#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int N, kind = 0;
    string s;
    cin >> N >> s;
    vector<int> alp(27, -1);
    int l = 0, r = 0, res = 0;
    while (l < s.size() && r < s.size()) {
        // r 문자 분석
        // 넣으면서 빼야한다면 l 땡기고
        // 아니라면 넣고 r 땡겨
        if (alp[s[r] - 'a'] == -1) {
            if (kind < N) {
                kind++;
                alp[s[r] - 'a'] = r;
                r++;
            } else {
                while (kind == N) { // edge case 조심
                    if (alp[s[l] - 'a'] == l) {
                        alp[s[l] - 'a'] = -1;
                        kind--;
                    }
                    l++;
                }
                kind++;
                alp[s[r] - 'a'] = r;
                r++;
            }

        } else {
            alp[s[r] - 'a'] = r;
            r++;
        }
        res = max(res, r - l);
    }

    cout << res;

    return 0;
}
