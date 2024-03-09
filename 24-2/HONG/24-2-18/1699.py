N = int(input())

DP = [0] * (N+10)

DP[1] = 1
DP[2] = 2
DP[3] = 3

for i in range(4, N+1):
  DP[i] = i # 5
  for j in range(1, int(i**0.5)+1): 
    squares = j*j # 1, 4, 9, 16, 25,,,
    DP[i] = min(DP[i], DP[i-squares] + 1)

print(DP[N])