import java.io.BufferedReader
import java.io.InputStreamReader

val sb = StringBuilder()

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    println(1.shl(n) - 1)
    hanoi(1,2,3, n)
    println(sb)
}

fun hanoi(a:Int, b:Int, c:Int, n:Int) {
    if (n == 0) return

    hanoi(a, c, b, n-1)
    sb.append("$a $c\n")
    hanoi(b, a, c, n-1)
}