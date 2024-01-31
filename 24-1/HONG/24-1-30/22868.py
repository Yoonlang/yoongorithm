import heapq
'''
S에서 E 가는 도중에 방문한 정점을 제외
1 - 2 - 3 - 4
[2,3]을제외!

거리가 같지만 사전순으로 하지 않았을 때 결과가 달라지는 경우?

4 5
1 2
1 3
2 3
2 4
3 4
1 4 

3 3
1 2
1 3
2 3
1 2
>> 2

2 1
1 2
1 2
>> 2

4 4
1 2
2 3
1 4
4 3
1 3
>> 4
'''

def get_visited(current, end, route):

  if current == end:
    return route
  
  route.append(current)
  return get_visited(paths[current], end, route)
  

def dijkstra(graph, paths, start, visited):
  
  distances = [int(1e10)] * 10001
  distances[start] = 0

  pq = [(0, start)]

  while pq:

    current_dist, current_node = heapq.heappop(pq)

    for neighbor, weight in graph[current_node]:

      distance = weight + current_dist

      if distance < distances[neighbor] and not neighbor in visited:
        distances[neighbor] = distance
        heapq.heappush(pq, (distance, neighbor))
        paths[neighbor] = current_node

  return distances


paths = [0] * 10001
graph = [[] for _ in range(10001)]
N, E = map(int, input().split())

for _ in range(E):
  s, e = map(int, input().split())
  graph[s].append((e,1))
  graph[e].append((s,1))

start, end = map(int, input().split())

distances1 = dijkstra(graph, paths, start, [])

visited = get_visited(paths[end], start, [])
distances2 = dijkstra(graph, paths, end, visited)

dist = distances1[end] + distances2[start]

print(dist)