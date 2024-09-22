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

    if (isNotMatched(0, 0, n, screen))
        compress(0, 0, n, screen)
    else compression.append(screen[0][0])

    println(compression)
}

fun compress(startX: Int, startY: Int, length: Int, screen: Array<IntArray>) {
    // 전체 범위 검사
    compression.append('(')

    if (isNotMatched(startX, startY, length, screen)) {
        // 나눠서 검사
        val half = length / 2

        // 1분면
        if (isNotMatched(startX, startY, half, screen))
            compress(startX, startY, half, screen)
        else compression.append(screen[startX][startY])

        // 2분면
        if (isNotMatched(startX, startY + half, half, screen))
            compress(startX, startY + half, half, screen)
        else compression.append(screen[startX][startY + half])

        // 3분면
        if (isNotMatched(startX + half, startY, half, screen))
            compress(startX + half, startY, half, screen)
        else compression.append(screen[startX + half][startY])

        // 4분면
        if (isNotMatched(startX + half, startY + half, half, screen))
            compress(startX + half, startY + half, half, screen)
        else compression.append(screen[startX + half][startY + half])

    } else {
        compression.append(screen[startX][startY])
    }

    compression.append(')')
}

fun isNotMatched(startX: Int,
                 startY: Int,
                 half: Int,
                 paper: Array<IntArray>): Boolean {

    val current = paper[startX][startY]
    for (i in startX until startX + half) {
        for (j in startY until startY + half) {
            if (current != paper[i][j]) return true
        }
    }

    return false
}