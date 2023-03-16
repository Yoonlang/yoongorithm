import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

/*
노션 페이지
https://wooooongyee.notion.site/1711-6ea38401b8b54aaf94c7c06e2f884b7c
*/

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = br.readLine().toInt()
    val pairs = Array(n){LongArray(2)}

    for(i in 0 until n){
        val stk = StringTokenizer(br.readLine())
        repeat(2){
            pairs[i][it] = stk.nextToken().toLong()
        }
    }
    var answer = 0
    for(i in 0 until n-2){
        for(j in i+1 until n-1){
            for (k in j+1 until n){
                answer += isRightTriangle(pairs[i],pairs[j],pairs[k])
            }
        }
    }
    println(answer)
}
fun isRightTriangle(p0: LongArray,p1: LongArray,p2: LongArray) : Int{
    return if(
        isRightAngle(p0[0],p0[1],p1[0],p1[1],p2[0],p2[1]) ||
        isRightAngle(p1[0],p1[1],p0[0],p0[1],p2[0],p2[1]) ||
        isRightAngle(p2[0],p2[1],p1[0],p1[1],p0[0],p0[1])
    ) 1 else 0
}

fun isRightAngle(a: Long, b: Long, c: Long, d: Long, e: Long, f: Long): Boolean {
    val x1 = c - a
    val y1 = d - b
    val x2 = e - a
    val y2 = f - b
    return x1 * x2 + y1 * y2 == 0L
}

//참고 https://www.acmicpc.net/source/44449063