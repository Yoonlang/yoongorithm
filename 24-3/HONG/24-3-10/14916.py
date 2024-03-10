'''
n^2 로도 충분히 가능한 문제.
DP로도 풀 수 있을까?
'''

# N^2 으로 풀기
N = int(input())

def solve(N):

  n = N // 5

  for i in range(n, -1, -1):
    target = N - (i * 5)
    for j in range(0, (target // 2) + 1):
      if j * 2 == target:
        return i + j
      
  return -1

print(solve(N))