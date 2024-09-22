import java.io.BufferedReader
import java.io.InputStreamReader

val compression = StringBuilder()
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val screen = Array(n) { IntArray(n) }

    for (i in 0 until n) {
        val row = readLine().map { it.digitToInt() }.toIntArray()
        screen[i] = row
    }

    compress(0, 0, n, screen)

    println(compression)
}

fun compress(startX: Int, startY: Int, length: Int, screen: Array<IntArray>) {

    if (isMatched(startX, startY, length, screen)) {
        compression.append(screen[startX][startY])
        return
    }

    // 전체 범위 검사
    compression.append('(')

    val half = length / 2

    // 1분면
    compress(startX, startY, half, screen)

    // 2분면
    compress(startX, startY + half, half, screen)

    // 3분면
    compress(startX + half, startY, half, screen)

    // 4분면
    compress(startX + half, startY + half, half, screen)

    compression.append(')')
}

fun isMatched(startX: Int,
              startY: Int,
              half: Int,
              paper: Array<IntArray>): Boolean {

    val current = paper[startX][startY]
    for (i in startX until startX + half) {
        for (j in startY until startY + half) {
            if (current != paper[i][j]) return false
        }
    }

    return true
}