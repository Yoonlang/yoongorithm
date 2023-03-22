import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var stk = StringTokenizer(readLine())
    val n = stk.nextToken().toInt()
    val m = stk.nextToken().toInt()

    stk = StringTokenizer(readLine())
    val psum = IntArray(n+1)
    var temp = 0
    for (i in 1..n){
        psum[i] += stk.nextToken().toInt() + temp
        temp = psum[i]
    }
//    println(psum.joinToString(","))
    val sb = StringBuilder()

    repeat(m){
        stk = StringTokenizer(readLine())
        val i = stk.nextToken().toInt()
        val j = stk.nextToken().toInt()
        sb.appendLine(psum[j]- psum[i-1])
    }
    println(sb.toString())
}