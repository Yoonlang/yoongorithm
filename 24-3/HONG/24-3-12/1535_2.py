N = int(input())

HP = list(map(int, input().split()))
JOY = list(map(int, input().split()))

DP = [[0] * 101 for _ in range(N)]

def solve(HP, idx):

  if DP[HP][idx] != 0: return DP[HP][idx]
  
  DP[HP][idx] = solve()

answer = solve(100, N)

print(answer)
