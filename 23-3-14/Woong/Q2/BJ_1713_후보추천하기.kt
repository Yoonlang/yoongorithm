
import java.io.BufferedReader
import java.io.InputStreamReader

val recommendCnt = IntArray(101)
val pictures = mutableListOf<Int>()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    readLine()


    readLine().split(" ").forEach {
        val k = it.toInt()

        if(k in pictures){                                                          // 사진틀에 이미 있어 +1 따봉
            recommendCnt[k]++

        }else{
            if(pictures.size == n){                                                 // 사진틀에 공간 없어서 하나 빼야함
                var min = findMinRecommendStu()                                     // 추천수 가장 적은 학생 찾기
                if(recommendCnt[k] <= recommendCnt[min] ) {                            // 새로 슛하는 애가 지금 사진틀 최소 추천받은 애와 같다면 밀어 내고 넣어야함
                    // 지금 가장 작은 애 슈우웃
                    recommendCnt[min] = 0
                    pictures.remove(min)
                    // 새로운 애 사진틀로 슛
                    pictures.add(k)
                    recommendCnt[k]++
                }
            }else{
                // 사진틀에 남은 공간 있어서 슛
                pictures.add(k)
                recommendCnt[k]++
            }
        }
    }
    for(i in 1 ..100){
        if(recommendCnt[i]>0) print("$i ")
    }
}

fun findMinRecommendStu(): Int {
    var temp = Int.MAX_VALUE
    var min = 0
    for(p in pictures){
        if(recommendCnt[p] < temp) {
            temp = recommendCnt[p]
            min = p
        }
    }
    return min
}