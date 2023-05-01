### Q17208 풀이

DP 문제

```java
    dp[i][j][k] = Math.max(dp[i-1][j][k], dp[i-1][j - bag[i][0]][k - bag[i][1]] + 1);

```

이 식만 만들면 끝