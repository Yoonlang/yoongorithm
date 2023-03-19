/*
1~100,000 배열 만들고 그 안에 짝이 있으면 +1, 마지막에 /2 해주기
m이 많이 클 경우 outOfIndex 조심
무조건 for문 두 번 해야하나? ㅇㅇ
- 입력 한 번, 탐색 한 번
* */

import java.io.BufferedReader
import java.io.InputStreamReader
fun main() = with (BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val m = readLine().toInt()
    val check = IntArray(100001)
    val input = readLine().split(" ").map{it.toInt()}
    input.forEach{
        check[it] = 1
    }
    var answer = 0
    input.forEach{
        if(m-it in 1..100001 && check[m-it] == 1) answer++
    }
    println(answer/2)
}