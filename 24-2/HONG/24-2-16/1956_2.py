INF = int(1e9)
V, E = map(int, input().split())

graph = [[INF for _ in range(V+1)] for _ in range(V+1)]

for _ in range(E):
  s, e, c = map(int, input().split())
  graph[s][e] = c

for k in range(1, V+1): # k 를 경유 하는 경로들
  for i in range(1, V+1):
    for j in range(1, V+1):
      graph[i][j] = min(graph[i][j], graph[i][k] + graph[k][j])

# find cycles
def solve():
  answer = int(1e9)
  for i in range(1, V+1):
    for j in range(i+1, V+1):
      if graph[i][j] != INF and graph[j][i] != INF:
        answer = min(answer, graph[i][j] + graph[j][i]) 
  return answer if answer != int(1e9) else -1
print(solve())

# 플로이드 와샬, 플로이드 워셜, 다익스트라 등등