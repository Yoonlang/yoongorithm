### 16202번 풀이

시간 복잡도 O(KMlogM)
가중치 순으로 edge가 주어지므로 sort할 필요가 없고
프림 알고리즘을 돌려주면 된다

제일 작은 가중치 간선을 하나씩 제외하라고 했는데
deleted로 표시해주면 되지만 이미 sort되어 있어 쉽게 처리할 수 있다

크루스칼을 돌리면 mst가 되지않는 조건은 간선이 부족할 때이다. 이때 union 성공 개수 == n - 1 이면 mst 만족이되므로 해당 결과에 따라 처리해준다,

한번 0 이 나온 이후(mst가 완성되지 않아서)엔 계속 0이나온다
해당 부분을 처리하고 싶으면 처리해도되지만 어차피 시간 안에 가능해서 가만 두었다.