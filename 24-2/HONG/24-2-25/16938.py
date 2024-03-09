'''
1. 문제 난이도의 합이 [L,R]
2. |max - min| >= X
3. 두개이상 골라야함
'''

N, L, R, X = map(int, input().split())

arr = sorted(list(map(int, input().split())))

def solve():
  answer = 0
  visit = [0] * N

  def dfs(depth, start, sum):

    nonlocal answer
    
    if R < sum:
      return

    if depth >= 2:
      _max = -1
      _min = int(1e10)
      for i, e in enumerate(arr): # 굳이 안해줘도됨. 정렬되어있기 때문에 index 값만 넘겨줘도 되는 경우가 있음.
        if visit[i]:
          _max = max(_max, e)
          _min = min(_min, e)
      if abs(_max - _min) >= X and L <= sum:
        answer += 1

      if depth == N: # 굳이 안해줘도 되는 경우가 있음. (ragne 범위가 초과하는 경우)
        return

    for i in range(start, N):
      visit[i] = 1
      dfs(depth+1, i+1, sum+arr[i])
      visit[i] = 0
  
  dfs(0, 0, 0)

  print(answer)

solve()