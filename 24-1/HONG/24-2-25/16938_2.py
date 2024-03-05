N, L, R, X = map(int, input().split())
arr = sorted(list(map(int, input().split())))

'''
1. 두문제 이상 - ok
2. sum의 범위는 [L,R] 
3. Max - Min >= X
# 미리 2개를 먼저 뽑아놓고, 나머지를 탐색하는 경우임.
'''

answer = 0

def dfs(sum, low, high):

  if sum > R: return
  
  if arr[high] - arr[low] >= X and L <= sum:
    global answer
    answer += 1
  for i in range(high+1, N):
    dfs(sum + arr[i], low, i)
  

for low in range(0, N-1):
  for high in range(low+1, N):
    dfs(arr[low] + arr[high], low, high)

print(answer)