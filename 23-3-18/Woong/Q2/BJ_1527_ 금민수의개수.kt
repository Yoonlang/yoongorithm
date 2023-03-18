/*
binary search? no 특정값을 찾는게 아님 카운트하는거임

for문 전체 다 돌면 안됨
4와 7만 사용 -> 자리수
오히려 역발상 4와 7로만 이루어진 배열 만들어 놓고 하나씩 돌면서 그게 범위 안에 들어가는지 확인

* */

import java.io.BufferedReader
import java.io.InputStreamReader

var list = mutableListOf<Int>()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val nums = intArrayOf(4,7)
    val (a,b) = readLine().split(" ").map { it.toInt() }

    for(i in 1..9){
        makeNum(nums,"",i)
    }
    var answer = 0
    list.forEach{
        if(it in a..b) answer++
    }
    println(answer)

}

fun makeNum(nums:IntArray , temp : String, n: Int) {       // i자리 4,7로만 이루어진 애들 다 넣기
    if(temp.length == n ){
        list.add(temp.toInt())
    }else{
        nums.forEach {
            makeNum(nums,temp+it,n)
        }
    }

}
