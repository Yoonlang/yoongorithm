Math.sqrt 로 해결하려 했다가 부동소수점 표기에서 오차가 존재하는 저격 인풋이 있는걸 질문게시판 보고 확인

하나씩 확인하는 걸로 변경 (이분탐색) -> 제곱이 더 작으면 start -> mid, 제곱이 크거나 같으면 end -> mid

오버플로우가 엣지였는데, 문제에서 양수 케이스만 봐서... 그냥 음수인거 체크하고 오버플로우 판단했음

이분 탐색 할 때마다 고민하는건데 또 정리

left <= right 로 하고 mid-1(또는 mid+1) 로 옮기기 (그럼 정답인 모든 순간을 무조건 체크)






