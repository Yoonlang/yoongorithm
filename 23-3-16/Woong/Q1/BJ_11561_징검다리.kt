import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.pow
import kotlin.math.sqrt

fun main ()  = with(BufferedReader(InputStreamReader(System.`in`))){

    val k = readLine().toInt()
    repeat(k){
        val n = readLine().toLong()
        var left = 0L
        var right = 2 * sqrt(10.0.pow(16.0).toDouble()).toLong()
        while(left <= right){
            val mid = (left +right) / 2
            if(isSmall(n, mid)) left = mid +1
            else right = mid -1
        }
        println(right)
    }

}

fun isSmall (n : Long, k : Long) : Boolean{
    return (k+1) * k/2 <= n
}