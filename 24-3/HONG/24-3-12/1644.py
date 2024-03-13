N = int(input())

DP = [0] * (N+10)
DP[0] = 0
DP[1] = 1
DP[2] = 2
DP[3] = 3

for i in range(4, N+1):
  DP[i] = DP[i-2] + DP[i-1]

print(DP[N] % 10007)