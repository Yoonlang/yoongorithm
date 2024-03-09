N, T = map(int, input().split())
drinks = [tuple(map(int, input().split())) for _ in range(N)]

start = 1
end = 10**6+1

def check(S):

  min_sum = 0
  max_sum =0
  for L, R in drinks:
    if S < L: return False
    min_sum += L
    max_sum += R if S > R else S
  
  if min_sum <= T <= max_sum:
    return True

def solve():
  for S in range(start, end):
    if check(S):
      print(S)
      return
  print(-1)

solve()