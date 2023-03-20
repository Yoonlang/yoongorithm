#include <bits/stdc++.h>

using namespace std;

// elements: [1, 15_000]
// armor: [1, 10_000_000]
// element_numbers: [1, 100_000]

int elements, armor;
vector<int> element_numbers;
bool has_element[10000001];
int cnt = 0;

int main(void) {
  cin.tie(0);
  ios_base::sync_with_stdio(0);

  cin >> elements >> armor;

  for (int i = 0; i < elements; i++) {
    int element;
    cin >> element;
    element_numbers.push_back(element);
    has_element[element] = true;
  }

  sort(element_numbers.begin(), element_numbers.end());

  for (int i = 0; i < elements; i++) {
    int with_this_element = element_numbers[i];
    int needed_pair = armor - with_this_element;
    if (with_this_element >= needed_pair) break;

    bool has_necessary = has_element[needed_pair];
    if (has_necessary) cnt++;
  }

  cout << cnt << "\n";
  return 0;
}