/*
비트마스킹? -> 수를 저장해둬야하기 때문에 무리 -> t/f라면 생각해볼만함
수 탐색 -> 이진탐색
*/
import java.io.StreamTokenizer
import java.lang.StringBuilder

lateinit var aList : IntArray
fun main()= StreamTokenizer(System.`in`.bufferedReader()).run{
    fun input() : Int{
        nextToken()
        return nval.toInt()
    }
    val n = input()
    aList = IntArray(n){input()}
    aList.sort()

    val sb = StringBuilder()
    repeat(input()){
        sb.appendLine(binarySearch(input()))
    }
    println(sb.toString())
}

fun binarySearch( t : Int) : Int {
    var left = 0
    var right = aList.size -1
    while(left <= right){
        val mid = (left+right)/2
        if(t == aList[mid]){
            return 1
        }else if(t < aList[mid]){
            right = mid-1
        }else{
            left = mid +1
        }
    }
    return 0
}
