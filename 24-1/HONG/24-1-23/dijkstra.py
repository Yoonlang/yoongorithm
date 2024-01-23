import heapq

def dijkstra(graph, start):
    distances = {node: float('infinity') for node in graph}
    distances[start] = 0

    priority_queue = [(0, start)]

    while priority_queue:
        current_distance, current_node = heapq.heappop(priority_queue)

        # 업데이트된 최단 거리 출력
        print(f"Update distance to node {current_node}: {current_distance}")

        if current_distance > distances[current_node]:
            continue

        for neighbor, weight in graph[current_node].items():
            distance = current_distance + weight

            if distance < distances[neighbor]:
                distances[neighbor] = distance
                heapq.heappush(priority_queue, (distance, neighbor))

        # 업데이트된 distances 출력
        print("Updated distances:", distances)

    return distances

# 예시 그래프
example_graph = {
    'A': {'B': 1, 'C': 4},
    'B': {'A': 1, 'C': 2, 'D': 5},
    'C': {'A': 4, 'B': 2, 'D': 1},
    'D': {'B': 5, 'C': 1}
}

# 시작 노드 'A'에서 다른 노드까지의 최단 거리 계산
result = dijkstra(example_graph, 'A')

# 결과 출력
print("Final distances:", result)
