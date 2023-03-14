import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.min

fun main() {

    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))


    while(true){
        val a = br.readLine() ?:break
        val b = br.readLine()

        val aList = MutableList(26){0}
        val bList = MutableList(26){0}
        for (c in a.toCharArray()){
            aList[(c-97).code] +=1
        }
        for (c in b.toCharArray()){
            bList[(c-97).code] +=1
        }

        var result = ""
        for(i in 0 until 26){
            result += (i + 97).toChar().toString().repeat(min(aList[i], bList[i]))
        }
        bw.write(result+"\n")
    }
    bw.flush()
}