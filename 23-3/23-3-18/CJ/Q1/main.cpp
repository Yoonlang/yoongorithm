#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main(void) {
  cin.tie(0);
  ios_base::sync_with_stdio(0);

  int list_length;
  vector<int> number_list;
  cin >> list_length;
  for (int i = 0; i < list_length; i++) {
    int input;
    cin >> input;
    number_list.push_back(input);
  }

  sort(number_list.begin(), number_list.end());

  int query_length;
  cin >> query_length;
  for (int i = 0; i < query_length; i++) {
    int query;
    cin >> query;
    int found = binary_search(number_list.begin(), number_list.end(), query);
    if (found) cout << "1\n";
    else cout << "0\n";
  }

  return 0;
}