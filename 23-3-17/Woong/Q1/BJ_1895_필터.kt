/*
* 필터 시작점을 기준으로 계산
* median이 t보다 큰지 확인하는 방식
* - 필터 안에 t보다  큰값이 5개 이상인지 확인
* */


import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

lateinit var I :Array<IntArray>
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){

    val (r,c) = readLine().split(" ").map{ it.toInt()}
    I = Array(r){IntArray(c)}

    repeat(r){i ->
        val stk = StringTokenizer(readLine())
        repeat(c){j ->
            I[i][j] =stk.nextToken().toInt()
        }
    }
    val t = readLine().toInt()

    var answer = 0
    for(y in 0 ..r-3){
        for(x in 0 .. c-3){
            answer += medianIsBiggerThanT(x,y,t)
        }
    }
    println(answer)
}
fun medianIsBiggerThanT(x: Int, y: Int, t :Int): Int {
    var count = 0
    repeat(3){dy->
        repeat(3){dx ->
            if(I[y+dy][x+dx] >= t) count ++
        }
    }
    return if(count>=5) 1 else 0
}

