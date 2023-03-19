### 풀이

걍 냅색

0-1 냅색

1. 브루트포스로 먼저 접근 시간복잡도 O(2^N)
2. dp로 접근 O(T*N)

dp(time, i) = max(dp(time - 현재과목time, i-1) + 현재과목 점수, dp(time, i-1))

