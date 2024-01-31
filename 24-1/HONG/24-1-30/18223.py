import heapq

'''
6 7 4
1 2 1
1 3 1
2 3 10
3 4 1
3 5 2
4 5 1
5 6 1
'''

def dijkstra(start):

  distances = [int(1e10)] * 10001 # V
  distances[start] = 0

  pq = [(0, start)]

  while pq:
    current_dist, current_node = heapq.heappop(pq)
    for neighbor, weight in graph[current_node]: # E
      distance = weight + current_dist

      if distance < distances[neighbor]:
        distances[neighbor] = distance
        heapq.heappush(pq, (distance, neighbor)) # log V

  return distances



graph = [[] for _ in range(10001)]
V, E, P = map(int, input().split())
for e in range(E):
  start, end, weight = map(int, input().split())
  graph[start].append((end, weight))
  graph[end].append((start, weight))



distances1 = dijkstra(1) # 최단경로 뭐있는지 알아보자
route1 = distances1[V] 

distances2 = dijkstra(P)
route2 = distances1[P] + distances2[V]

if route1 >= route2:
  print("SAVE HIM")
else:
  print("GOOD BYE")