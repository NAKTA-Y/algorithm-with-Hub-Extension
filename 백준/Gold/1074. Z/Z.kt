import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val input = readLine().split(" ")

    println(z(input[0].toInt(), input[1].toInt(), input[2].toInt()))
}

fun z(n:Int, r: Int, c: Int): Int {
    if (n == 0) return 0

    val half = 1.shl(n-1)
    return when {
        r < half && c < half -> z(n-1, r, c)
        r < half && c >= half -> half * half + z(n-1, r, c - half)
        r >= half && c < half -> 2 * half * half + z(n-1, r - half, c)
        else -> 3 * half * half + z(n-1, r - half, c - half)
    }
}