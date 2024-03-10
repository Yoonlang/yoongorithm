N, K = map(int, input().split())

DP = [[0 for _ in range(N+1)] for _ in range(K+1)]

def solve(n, k):

  if DP[k][n]: return DP[k][n]
  if k == 0: return 0
  if k == 1: return 1
  if n == 0: return 1

  sum = 0
  for i in range(0, k+1):
    sum += solve(n-1, k-i)
    sum %= 1000000000
  
  DP[k][n] = sum
  return DP[k][n]

print(solve(N, K))