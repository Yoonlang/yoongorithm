import java.io.BufferedReader
import java.io.InputStreamReader
fun main () = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    val list = readLine().split(" ").map { it.toInt() }

    var max = list[0]
    var temp = 0
    for ( i in 0 until n ){
        temp = if (temp >= 0 || list[i] >= 0 ){
            list[i].coerceAtLeast(temp+list[i])
        }else{
            if(max >=0) 0
            else {
                list[i].coerceAtLeast(temp +list[i])
            }
        }
//        println("temp : $temp, max : $max")
        max = max.coerceAtLeast(temp)
    }
    println(max)
}