# 성공
N = int(input())

DP = [0] * (N+1)
DP[1] = 1
DP[2] = 2

for i in range(3, N+1):
  DP[i] = max(DP[i-2] * 2+1, DP[i-1])

print(DP)