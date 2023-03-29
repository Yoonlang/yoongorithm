import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

/*
* 모든 문제의 조합 -> 15C2 ~ 15Cn
* 해당 조합이 조건을 만족하는지 확인
* */

val combList : MutableList<IntArray> =  mutableListOf()
lateinit var ary : IntArray
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val (n,l,r,x) = readLine().split(" ").map { it.toInt() }
    val stk = StringTokenizer(readLine())
    ary = IntArray(n)
    repeat(n){
        ary[it] = stk.nextToken().toInt()
    }
    for( i in 2..n){
        combination(n,i, mutableListOf(),0)
    }
    var answer = 0
    combList.forEach{
        val sum = it.sum()
        if(sum in l..r && it.max() - it.min() >=x){
            answer++
        }
    }
    println(answer)
}

fun combination(n : Int, r: Int,  result : MutableList<Int>, start : Int){
    if (result.size == r){
//        println("result : $result")
        combList.add(result.toIntArray())
        return
    }
    for (i in start until n){
        result.add(ary[i])
        combination(n,r, result,i+1)
        result.removeAt(result.lastIndex)
    }
}