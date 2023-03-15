import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()

    val tList = IntArray(n+2)
    val pList = IntArray(n+2)

    repeat(n){ i ->
        val (t,p) = br.readLine().split(" ").map { it.toInt() }
        tList[i+1] = t
        pList[i+1] = p
    }
    val dp = IntArray(n+2)
    // 메모이제이션 사용
    for(i in 1..n+1){
        if(tList[i]==1){                    // t가 1일 경우
            dp[i] += pList[i]
            for(j in i+1..n+1){
                if(dp[j] < dp[i]){
                    dp[j] = dp[i]
                }
            }
        }else{                              // t가 1보다 클 경우
            // 범위 넘어가면 건너뛰기
            if(i+tList[i] > n+1) continue
            // 만약 더해주는 날짜의 dp값이 없거나 dp값 + p값보다 작으면 해당 날짜 이후에 값들 현시점 최대값 넣어주기
            for(j in i+tList[i]..n+1){
                if(dp[i+tList[i]] == 0 || dp[j] < dp[i] + pList[i]){
                    dp[j] = dp[i] + pList[i]
                }
            }
        }
    }
    println(dp[n+1])
}