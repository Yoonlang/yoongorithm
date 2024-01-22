#include <iostream>
#include <string>

using namespace std;

int main() {

    int T;
    cin >> T;
    cin.ignore();

    for (int t = 0; t < T; t++) {
        string line;
        int cnt[26] = {0};

        getline(cin, line);
        for (int i = 0; line[i] != 0; i++) {
            if (line[i] == ' ') {
                continue;
            }
            int order = line[i] - 'a';
            cnt[order] += 1;
        }

        int max_i = 0;
        for (int i = 1; i < 26; i++) {
            if (cnt[i] > cnt[max_i]) {
                max_i = i;
            }
        }

        int cnt_same = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == cnt[max_i]) {
                cnt_same += 1;
            }
        }

        if (cnt_same == 1) {
            cout << char('a' + max_i) << "\n";
        } else {
            cout << "?\n";
        }
    }

    return 0;
}