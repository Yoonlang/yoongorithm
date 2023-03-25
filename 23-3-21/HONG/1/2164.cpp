// https://www.acmicpc.net/problem/2164
#include <algorithm>
#include <iostream>

using namespace std;

int main() {

  int N;
  int delete_cnt = 0;
  int mark[500001] = {0};

  cin >> N;

  int can_throw = 1;
  int iter = 1;
  while (1) {
    // not visited yet & can throw
    if (mark[iter] == 0 && can_throw == 1) {
      mark[iter] = 1;
      delete_cnt += 1;
      can_throw = 0;
      if (delete_cnt == N) {
        cout << iter;
        return 0;
      }
    }
    // not visited yet & but cannot throw
    else if (mark[iter] == 0 && can_throw == 0) {
      can_throw = 1;
    }
    // visited
    else {
    }
    iter = iter == N ? 1 : iter + 1;
  }

  return 0;
}