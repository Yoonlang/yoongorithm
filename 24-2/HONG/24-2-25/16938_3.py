'''
완탐으로 풀어보자
'''

from itertools import combinations

N, L, R, X = map(int, input().split())
arr = sorted(list(map(int, input().split())))

answer = 0

for i in range(2, N+1):
  for comb in combinations(arr, i):
    if comb[-1] - comb[0] >= X and L <= sum(comb) <= R:
      answer += 1
print(answer)