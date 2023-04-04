### 풀이
시간 복잡도 O(N)

n,m,k < 10만임

여기서의 주요 기능
1. 건물 생성
2. 건물 파괴

### 건물생성

기반 시설 모두가 완공되어있어야함. 기반을 부모라고 칭하겠음
부모 노드가 모두 설치되어있으면 지을 수 있음
근데 설치 안되어있는데 짓는다고하면 치트임

그걸 어떻게 판단하느냐?

직접 부모 노드 하나하나 확인한다 -> 부모노드가 9만개면...?
건물 한번 지을 때마다 9만번 확인? 시간 초과남

부모 노드들이 생성 되었다는 것을 ParentsCount 배열로 관리함

TotalParentsCount를 만들어 각 노드의 부모 수를 저장함

부모 노드가 처음 생성될 시 child의 curParentsCount를 +1 함 (첫 생성시)
첫 생성시 +1라고 함은 생성 카운트 관리도 해야함
buildingCount를 건물 생성시마다 +1함

그러므로 생성 가능 조건은 curBuildingCount == totalBuildingCount임(부모 노드가 모두 있다는 뜻)

### 건물 파괴

buildingCount가 0 이하이면 치트

buildingCount -1 하면서 만약 buildingCount가 0이되면, child들의 CurparentsCount -1 함 (건물이 아예 없으므로)


이렇게 되면 생성, 파괴의 시간복잡도는 O(1)이며 순회 수는 K이기 때문에

시간복잡도는 O(N)으로 무난히 통과함