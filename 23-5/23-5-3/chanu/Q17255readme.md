### 풀이

문자열 처리 -> 백트래킹 가능한가? 확인

이 문제는 숫자 자리수 자체가 십 단위기 때문에 실제 구현처럼 백트래킹으로 처리해도 충분히 빠른 문제이다

문자를 하나씩 더해가면서 처리하거나 문자를 하나씩 빼면서 (왼 or 오) 처리하거나 하면된다

난 하나씩 뺴는걸로 처리했고, 만약 남은 substring이 모두 똑같은 숫자라면 한개로 처리하고 끝낸다(경우의 수가 중복되기에)