import java.io.BufferedReader
import java.io.InputStreamReader

val paperCounts = intArrayOf(0, 0, 0)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val paper = Array(n) { IntArray(n) }

    for (i in 0 until n) {
        val row = readLine().split(" ").map { it.toInt() }.toIntArray()
        paper[i] = row
    }

    compress(0, 0, n, paper)
    println(paperCounts[0])
    println(paperCounts[1])
    println(paperCounts[2])
}

fun compress(startX: Int, startY: Int, length: Int, paper: Array<IntArray>) {

    if (isMatched(startX, startY, length, paper)) {
        paperCounts[paper[startX][startY]+1]++
        return
    }

    val third = length / 3

    // 1분면
    compress(startX, startY, third, paper)

    // 2분면
    compress(startX, startY + third, third, paper)

    // 3분면
    compress(startX, startY + third + third, third, paper)

    // 4분면
    compress(startX + third, startY, third, paper)

    // 5분면
    compress(startX + third, startY + third, third, paper)

    // 6분면
    compress(startX + third, startY + third + third, third, paper)

    // 7분면
    compress(startX + third + third, startY, third, paper)

    // 8분면
    compress(startX + third + third, startY + third, third, paper)

    // 9분면
    compress(startX + third + third, startY + third + third, third, paper)
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