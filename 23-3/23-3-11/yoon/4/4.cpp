#include <iostream>
#include <string>
#include <climits>
#include <algorithm>
#include <vector>

using namespace std;

typedef long long ll;

void calc(vector<ll>& nums, vector<char>& opers, int here) {
    ll a = nums[here];
    ll b = nums[here + 1];
    switch(opers[here]) {
        case '+':
            nums[here] = a + b;
            break;
        case '*':
            nums[here] = a * b;
            break;
        case '-':
            nums[here] = a - b;
    }
    nums.erase(nums.begin() + here + 1);
    opers.erase(opers.begin() + here);
}

ll backtracking(vector<ll> nums, vector<char> opers, int here, bool hadBracket) {
    if(here >= opers.size()) return INT_MIN;
    if(here == opers.size() - 1) {
        if(hadBracket) calc(nums, opers, here);
        int operS = opers.size();
        for(int i = 0; i < operS; i++) {
            calc(nums, opers, 0);
        }

        return nums[0];
    }

    if(hadBracket) calc(nums, opers, here);

    ll maxx = INT_MIN;
    for(int i = here; i < opers.size(); i++) {
        maxx = max(maxx, backtracking(nums, opers, hadBracket ? i : i + 1, false));
        if(!hadBracket) maxx = max(maxx, backtracking(nums, opers, i + 1, true));
    }
    return maxx;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    vector<ll> nums;
    vector<char> opers;

    int N;
    cin >> N;

    string s;
    cin >> s;
    if(s.size() == 1) {
        cout << s[0];
        return 0;
    }
    for(auto c : s) {
        if('0' <= c && c <= '9') nums.push_back(c - '0');
        else opers.push_back(c);
    }

    cout << max(backtracking(nums, opers, 0, false), backtracking(nums, opers, 0, true));
    return 0;
}
