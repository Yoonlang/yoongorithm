#include <bits/stdc++.h>

using namespace std;

int row, column, target, result = 0;
const int GRID_SIZE = 3;
const int OFFSET = GRID_SIZE - 1;
const int MEDIAN_POSITION = 4;

vector<vector<int> > raw_image;
vector<vector<int> > filtered_image;

int get_median(int row, int column) {
  vector<int> grid_to_vector;
  for (int i = 0; i < GRID_SIZE; i++) {
    for (int j = 0; j < GRID_SIZE; j++) {
      grid_to_vector.push_back(raw_image[row + i][column + j]);
    }
  }

  sort(grid_to_vector.begin(), grid_to_vector.end());

  return grid_to_vector[MEDIAN_POSITION];
}

int main(void) {
  cin.tie(NULL);
  ios::sync_with_stdio(false);

  cin >> row >> column;

  int input_buffer = 0;
  for (int i = 0; i < row; i++) {
    vector<int> input_buffer_vector;
    for (int j = 0; j < column; j++) {
      cin >> input_buffer;
      input_buffer_vector.push_back(input_buffer);
    }
    raw_image.push_back(input_buffer_vector);
  }

  cin >> target;

  for (int i = 0; i < row - OFFSET; i++) {
    for (int j = 0; j < column - OFFSET; j++) {
      if (get_median(i, j) >= target) result++;
    }
  }

  cout << result << "\n";

  return 0;
}
