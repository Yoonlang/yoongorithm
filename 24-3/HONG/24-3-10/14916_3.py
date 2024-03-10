import sys
sys.setrecursionlimit(10**5)
N = int(input())

INF = int(1e10)
DP = [INF] * (10 + N)

def solve(N):

  if DP[N] < INF: return DP[N]
  if N == 1: return INF
  elif N == 2: return 1
  elif N == 3: return INF
  elif N == 4: return 2
  elif N == 5: return 1

  DP[N] = min(solve(N-5)+1, solve(N-2)+1)
  return DP[N]

answer = solve(N)

print(answer if answer < INF else -1)