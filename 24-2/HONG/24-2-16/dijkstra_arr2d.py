INF = int(1e10)
graph = [
    [0 , 3,   5, 1,  12],
    [3 , 0,   3, 1,   8],
    [5 , 3,   0, 2, INF],
    [1 , 1,   2, 0,   7],
    [12, 8, INF, 7,   0]
];

def dijkstra(start):
  visited = [0] * 5
  visited[start] = 1
  distances = graph[0][:]

  for j in range(5): # 왜 5번인지는 이해가 잘 안간다.

    # 1. 가까운 노드
    current_node = 0
    current_dist = INF

    for i in range(5):
      if visited[i]: continue
      if distances[i] < current_dist:
        current_dist = distances[i]
        current_node = i
  
    visited[current_node] = 1

    # 2. 비용 갱신
    for i in range(5):
      if visited[i]: continue
      dist = current_dist + graph[current_node][i]
      distances[i] = min(distances[i], dist)
  
  return distances


print(dijkstra(0))