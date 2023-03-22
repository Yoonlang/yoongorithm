
import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.ArrayDeque

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val deq =ArrayDeque<Int>()
    repeat(readLine().toInt()){
        deq.addLast(it+1)
    }
    while(deq.size>1){
        deq.removeFirst()
        deq.addLast(deq.removeFirst())
    }
    println(deq.removeFirst())
}
