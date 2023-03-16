13544번

쿼리에서 a, b, c가 주어지는데 xor을 해야함.
O(1)짜리 행동이니까 딱히 문제는 없나?

Solution

각 쿼리마다 범위에서 K보다 큰 수 개수를 찾아야함.

기존 segment tree 만드는데 O(N)

기존 한 쿼리마다 O(logN)
기존 총 TC O(M log N)

해당 범위 내에서 K보다 큰 개수를 알려면?
현 아이디어
각 seg[root]마다 vector<int>로 배열을 저장해두고
해당 벡터로 upper_bound를 처리하면
각 쿼리마다 logN * logN 걸릴거같은데
공간복잡도는? 4*N + N log N

40만 + 180만 = 220만
4byte \* 220만 => 8.8메가면 충분
