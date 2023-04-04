/*
3/16 4: 30

핵심
dp? 그리디? -> 그리디인듯
- 가장 큰 사면체부터 내려가면서 해당 크기만큼 빼기
- 최소 개수라서 이 방식 쓰면 안됨

사면체 단위 잘 조합해서 최소의 수 -> dp였네
bottom-up 풀이법
처음부터 가면서 unit에 있다면 1 넣어주고 없다면 min(이전+1, dp[i])
그 후에 unit 순회하면서 현재 +1과 dp[i]비교
- 이때 들어있는게 없는 경우라면 무조건 현재+1 넣어주기

사면체 단위 구하기
- 일단 두 번에 걸쳐서 구했는데 메모리, 시간적으로 손해보는 코드임

*/

import java.io.BufferedReader
import java.io.InputStreamReader
fun main () = with (BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val triangleList = IntArray(n+1)
    var pyramidUnit = IntArray(n+1)

    var k = 1
    while(triangleList[k-1] + k <= n){
        triangleList[k] = triangleList[k-1] + k
        k++
    }

    k =1
    while(k <=n && pyramidUnit[k-1] + triangleList[k] <= n ){
        pyramidUnit[k] = pyramidUnit[k-1] + triangleList[k]
        k++
    }

    val unit = pyramidUnit.filter { it !=0 }.toMutableList()
    var dp = IntArray(n+1)


    for(i in 1 ..n ){
        if(i in unit) {
            dp[i] = 1
        }else{
            dp[i] = Math.min(dp[i-1] +1, dp[i])
        }
        unit.forEach{
            if(i + it <= n){
                if(dp[i+it] == 0){
                    dp[i+it] = dp[i] +1
                }else{
                    dp[i+it] = Math.min(dp[i] +1,dp[i+it])
                }
            }
        }
    }
    println(dp[n])
}