package `dp(dynamic programming)`

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(){
    val br = BufferedReader(InputStreamReader(System.`in`))
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    val n = br.readLine()!!.toInt()
    val cache = IntArray(n +1)
    cache[0] = 1
    val prime = getPrimes(n)
    for (coin in prime){
        for (i in coin..n){
            cache[i] = (cache[i] + cache[i-coin]) % 123456789
//            println("coin = $coin,i = $i, i-coin = ${i-coin} cache[$i] = ${cache[i]}")
        }
    }
    bw.write("${cache[n]}")
    bw.flush()
    bw.close()
}

fun getPrimes(n : Int) : List<Int>{
    val isPrime = BooleanArray(n+1){true}
    val primes = mutableListOf<Int>()

    for(i in 2..n){
        if(isPrime[i]){
            primes.add(i)
            var j = i * 2
            while(j <= n){
                isPrime[j] = false
                j +=i
            }
        }
    }
    return primes
}
