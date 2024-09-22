import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val abc = readLine().split(" ")
    println(pow(abc[0].toLong(), abc[1].toLong(), abc[2].toLong()))
}

fun pow(a: Long, b: Long, c: Long): Long{
    if (b == 1L) return a % c
    var value = pow(a, b/2, c)
    value = value * value % c
    return if (b % 2 == 0L) value
    else value * a % c
}