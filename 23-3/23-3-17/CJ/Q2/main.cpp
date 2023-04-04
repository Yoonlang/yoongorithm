#include <bits/stdc++.h>
#define MAX_COURSES 1000
using namespace std;

int total_courses, input_lines;

vector<int> prerequisites[MAX_COURSES + 1];
int required_courses[MAX_COURSES + 1];

int get_required_courses(int k) {
  int max_semester = 0;
  vector<int> courses = prerequisites[k];

  for (int course : courses) {
    max_semester = max(max_semester, required_courses[course]);
  }

  return max_semester + 1;
}

int main(void) {
  cin.tie(NULL);
  ios_base::sync_with_stdio(0);

  cin >> total_courses >> input_lines;

  for (int i = 0; i < input_lines; i++) {
    int prerequisite, course_after_prerequisite;
    cin >> prerequisite >> course_after_prerequisite;

    prerequisites[course_after_prerequisite].push_back(prerequisite);
  }

  for (int i = 1; i <= total_courses; i++) {
    required_courses[i] = 1;
  }

  for (int i = 1; i <= total_courses; i++) {
    required_courses[i] = get_required_courses(i);
  }

  for (int i = 1; i <= total_courses; i++) {
    cout << required_courses[i] << " ";
  }

  return 0;
}