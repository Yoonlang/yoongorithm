#include <algorithm>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

int N;
vector<int> res;

bool isPrime(int num) {
    if (num < 2)
        return false;
    for (int i = 2; i * i <= num; i++) {
        if (num % i == 0)
            return false;
    }
    return true;
}

void backtracking(string &num, int here = 1) {
    if (here > N) {
        if (num[0] != '0')
            res.push_back(stoi(num));
        return;
    }

    if (num[0] == '0')
        return;
    for (int i = 0; i <= 9; i++) {
        num.push_back('0' + i);
        if (isPrime(stoi(num))) {
            backtracking(num, here + 1);
        }
        num.pop_back();
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
#ifndef ONLINE_JUDGE
    freopen("data.txt", "r", stdin);
#endif

    cin >> N;

    string num = "";
    backtracking(num);

    for (auto r : res) {
        cout << r << endl;
    }

    return 0;
}
