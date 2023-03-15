#include <algorithm>
#include <climits>
#include <iostream>
#include <string>
#include <vector>

using namespace std;

void backtracking(vector<int> nums, vector<int> oper, int here, int &minRes,
                  int &maxRes, string operStack) {
    int left = 0;
    for (int i = 0; i < 4; i++)
        left += oper[i];
    if (left == 0) {
        for (int i = 0; i < operStack.size(); i++) {
            if (operStack[i] == '2') {
                operStack.erase(operStack.begin() + i);
                nums[i] *= nums[i + 1];
                nums.erase(nums.begin() + i + 1);
                i--;
            } else if (operStack[i] == '3') {
                operStack.erase(operStack.begin() + i);
                nums[i] /= nums[i + 1];
                nums.erase(nums.begin() + i + 1);
                i--;
            }
        }
        for (int i = 0; i < operStack.size(); i++) {
            if (operStack[i] == '0') {
                operStack.erase(operStack.begin() + i);
                nums[i] += nums[i + 1];
                nums.erase(nums.begin() + i + 1);
                i--;
            } else if (operStack[i] == '1') {
                operStack.erase(operStack.begin() + i);
                nums[i] -= nums[i + 1];
                nums.erase(nums.begin() + i + 1);
                i--;
            }
        }

        minRes = min(minRes, nums[0]);
        maxRes = max(maxRes, nums[0]);
        return;
    }

    for (int i = 0; i < 4; i++) {
        if (oper[i] > 0) {
            oper[i]--;
            backtracking(nums, oper, here, minRes, maxRes,
                         operStack + (char)('0' + i));
            oper[i]++;
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int N;
    cin >> N;

    vector<int> nums(N);
    for (int i = 0; i < N; i++)
        cin >> nums[i];
    vector<int> oper(4);
    for (int i = 0; i < 4; i++)
        cin >> oper[i];

    int minRes = INT_MAX, maxRes = INT_MIN;
    backtracking(nums, oper, 0, minRes, maxRes, "");

    cout << maxRes << endl << minRes;

    return 0;
}
