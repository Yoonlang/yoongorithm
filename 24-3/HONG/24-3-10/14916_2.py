N = int(input())

def solve2(N):
  inf = int(1e10)
  DP = [0] * (N+10)
  DP[0] = inf
  DP[1] = inf
  DP[2] = 1
  DP[3] = inf
  DP[4] = 2
  DP[5] = 1

  for i in range(6, N+1):
    DP[i] = inf
    if DP[i-2] != -1:
      DP[i] = DP[i-2] + 1
    if DP[i-5] != -1:
      DP[i] = min(DP[i], DP[i-5]+1)

  return DP[N] if DP[N] != inf else -1

print(solve2(N))