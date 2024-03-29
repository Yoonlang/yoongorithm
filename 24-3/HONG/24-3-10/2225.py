'''
내가 겪었던 어려움들
1. 이전 상태랑 연결이 안돼
2. 합이 20인 경우는 합이 19인경우 + 합이 1인경우 / 합이 18인 경우 + 합이 2인경우 ... 등을 다 더한거자나. 여기서 순서는 또 어떻게 따져.
- 순서의 개념이 있나?, 순서의 개념을 포함해서 DP 를 만들어 낼 수 있나?
- '모든 경우의 수'를 찾는것이기 때문에, 순서도 자연스럽게 포함이됨.
3. 그래도 점화식 도출 전까진 갔음. 굿!

**문제풀이순서**
DP 개념 : https://hongjw1938.tistory.com/47
합분해 해설 : https://hongjw1938.tistory.com/63
1. 변수 갯수 추정하기
2. 점화식 세우기
3. Top-down / Bottom-up 정하기
4. 기저상태 정하기
'''

N, K = map(int, input().split())

DP = [[0 for _ in range(N+1)] for _ in range(K+1)]

DP[0][0] = 1

for i in range(1, K+1):
  for j in range(0, N+1):
    for k in range(0, j+1):
      DP[i][j] += DP[i-1][j-k]
      DP[i][j] %= 1000000000

print(DP[K][N])