#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int N, M;
    cin >> N >> M;

    vector<string> words(N);
    for (int i = 0; i < N; i++) {
        cin >> words[i];
        M -= words[i].length();
    }

    int base = M / (N - 1);
    int additional = M % (N - 1);
    vector<int> underbar(N - 1, base);

    for (int i = 1; i < words.size(); i++) {
        if (additional == 0)
            break;
        if ('a' <= words[i][0] && words[i][0] <= 'z') {
            underbar[i - 1]++;
            additional--;
        } else {
            if (additional == words.size() - i) {
                underbar[i - 1]++;
                additional--;
            }
        }
    }

    string res = "";
    for (int i = 0; i < N - 1; i++) {
        res += words[i];
        res.append(underbar[i], '_');
    }
    res += words[N - 1];
    cout << res;

    return 0;
}
