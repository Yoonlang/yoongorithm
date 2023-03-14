#include <cmath>
#include <iostream>
#include <string>

using namespace std;

void process(string &s, int left, int right) {
    if (right - left == 0)
        return;

    int l = left + (right - left + 1) / 3;
    int r = left + (right - left + 1) / 3 * 2;

    string temp((right - left + 1) / 3, ' ');
    s.replace(l, (right - left + 1) / 3, temp);

    process(s, left, l - 1);
    process(s, r, right);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int N;

    while (1) {
        cin >> N;
        if (cin.eof())
            break;

        string s;
        s.resize(pow(3, N), '-');

        process(s, 0, pow(3, N) - 1);

        cout << s << '\n';
    }

    return 0;
}
