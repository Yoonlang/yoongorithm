import java.io.BufferedReader
import java.io.InputStreamReader

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))

    val(n,m) = br.readLine()!!.split(" ").map { it.toInt() }
    val map = HashMap<String,Int>()
    val result = mutableListOf<String>()
    repeat(n){
        map[br.readLine()!!] = 0
    }
    repeat(m){
        br.readLine().run {
            if(map.containsKey(this))
                result.add(this)
        }
    }
    result.sort()
    println(result.size)
    println(result.joinToString("\n"))
}

/*
* HashMap으로 풀었는데 HashSet으로 풀면 더 편했을 것 같음
* */