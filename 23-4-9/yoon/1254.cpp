#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

bool isPalindrome(string s) {
    for (int i = 0; i < s.size() / 2; i++)
        if (s[i] != s[s.size() - 1 - i])
            return false;
    return true;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string s;
    cin >> s;
    int maxPal = 0;
    for (int i = 0; i < s.size(); i++) {
        if (isPalindrome(s.substr(i))) {
            maxPal = max(maxPal, (int)s.size() - i);
        }
    }

    cout << (s.size() - maxPal) * 2 + maxPal;

    return 0;
}
