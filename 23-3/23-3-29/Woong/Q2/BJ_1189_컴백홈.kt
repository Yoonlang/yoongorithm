import java.io.BufferedReader
import java.io.InputStreamReader

lateinit var map : Array<CharArray>
lateinit var visited : Array<BooleanArray>
val dx = intArrayOf(1,-1,0,0)
val dy = intArrayOf(0,0,1,-1)
var answer = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (r,c,k) = readLine().split(" ").map{it.toInt()}
    visited = Array(r){BooleanArray(c){false} }
    map = Array(r){CharArray(c)}
    repeat(r){ y->
        map[y] = readLine().toCharArray()
    }
//    map.forEach { println(it.joinToString(","))}
    visited[r-1][0] = true
    dfs(x =0, y= r-1, r,c,k,cnt = 1)
    println(answer)
}
fun dfs(x : Int, y : Int, r: Int, c: Int,k : Int, cnt : Int){
    if(cnt >k) return
    if(x == c-1 && y == 0 && cnt == k){
        answer++
        return
    }
//    println(visited)
    repeat(4){
        val nx = x+dx[it]
        val ny = y+dy[it]
//        println("nx : $nx, ny : $ny")
        if(nx in 0 until c &&  ny in 0 until r && map[ny][nx]=='.'&& !visited[ny][nx]){
            visited[ny][nx] = true
            dfs(nx ,ny,r,c,k, cnt +1)
            visited[ny][nx] = false
        }
    }
}