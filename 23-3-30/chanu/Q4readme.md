### 풀이

두개 선택 + 선택 사이 이분 탐색

선택사이 이분탐색하는 이유 : 그냥 이분 탐색 할 필요도 없을 뿐 더러(중복때문에) 그렇게 하게되면 이분탐색 순회 수가 log(5000) > 10 이상이며 두개 선택이 1250만 이기때문에 1250만 * 10 이상 > 1억의 순회가 발생한다 

그렇기 때문에 최적의 이분탐색 순회가 필요하다 

```java
for i 
    for j
        i와 j 사이 이분탐색
```

참고로 하나 선택 후 투포인터 접근도 가능하다