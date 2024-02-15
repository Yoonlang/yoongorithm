'''
1. 조합 임포트해서 풀기
2. 조합 작성해서 풀기
3. 정렬후 쓰리포인터 해서 풀기
'''

from itertools import combinations

answer = 0
N = int(input())
arr = list(map(int, input().split()))

for comb in list(combinations(range(N), 3)):
  first = comb[0]
  second = comb[1]
  third = comb[2]

  sum = arr[first] + arr[second] + arr[third]
  if sum == 0:
    answer += 1
  
print(answer)