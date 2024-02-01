'''
조교 최대 10만명
10만번 * 10만번은 N^2 안됨.

[0, 0, 0, 0, 0]
# 1~3 2씩 더해라
[2, 0, 0, -2, 0] -> [2, 2, 2, 0, 0]
# 2~4 4씩 빼라
[2, -4, 0, -2, 4] -> [2, -2, -2, -4, 0]
# 5~5 6 더해라
[2, -4, 0, -2, 10] -> [2, -2, -2, -4, 6]

=> [left, right] K연산
=> tmp[left] += K & tmp[right+1] -= K 

'''
N, M = map(int, input().split())

heights = list(map(int, input().split()))
heights.insert(0,0)
results = [0] * (N+1)

for i in range(M):
  a, b, k = map(int, input().split())
  results[a] += k
  if b+1 <= N:
    results[b+1] -= k

for i in range(1, N+1):
  results[i] += results[i-1]

for i in range(1, N+1):
  heights[i] += results[i]

print(" ".join(map(str, heights[1:])))