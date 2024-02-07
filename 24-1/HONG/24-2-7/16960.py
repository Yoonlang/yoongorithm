N, M = map(int, input().split())

# 하나만 만들 수 있으면됨
def solve():
  for i in range(1, N+1):
    visited = [0] * (M+1)
    for j in range(1, N+1):
      if i == j: continue
      for node in graph[j]:
        visited[node] = 1
    if sum(visited) == M:
      return 1
  return 0  

graph = [[]]
for i in range(1, N+1):
  row = list(map(int, input().split()))[1:]
  graph.append(row)

print(solve())
