import sys
sys.setrecursionlimit(10**5)

'''
1. 모든 Edge를 방문해야함 -> 오일러 문제
2. 다시 돌아오지 않아도 됨 -> 오일러 경로 O, 오일러 회로 X
3. 오일러 경로 문제 -> 무향/유향 그래프 중 무향 -> 노드가 가진 간선갯수 -> Start, End가 홀수 / 나머지는 짝수
'''

'''
V 가 1 인경우도 고려 -> Default : YES
'''

def dfs(graph, visited, start):
  visited[start] = 1
  for neighbor in graph[start]:
    if visited[neighbor] == 0:
      dfs(graph, visited, neighbor)


def check_euiler_trail(graph):
  visited = [0] * (N+1)
  dfs(graph, visited, 1)
  if sum(visited) != N:
    return 0

  edges = [len(graph[start]) for start in range(1, N+1)]
  count_odd = sum(1 for x in edges if x % 2 == 1)
  if count_odd == 2 or count_odd == 0:
    return 1
  
  return 0
    


graph = [[] for _ in range(3001)]

N, M = map(int, input().split())

for _ in range(M):
  s, e = map(int, input().split())
  graph[s].append(e)
  graph[e].append(s)

# 모든 시작점을 고려해서 체크하면됨.
result = check_euiler_trail(graph)
print("YES" if result == 1 else "NO")