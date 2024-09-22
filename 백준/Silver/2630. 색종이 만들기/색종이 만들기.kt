import java.io.BufferedReader
import java.io.InputStreamReader

val paperCounts = intArrayOf(0, 0)
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val paper = Array(n) { IntArray(n) }

    for (i in 0 until n) {
        val row = readLine().split(" ").map { it.toInt() }.toIntArray()
        paper[i] = row
    }

    if (isNotMatched(0, 0, n, paper))
        countPaper(0, 0, n, paper)
    else
        paperCounts[paper[0][0]]++

    println(paperCounts[0])
    println(paperCounts[1])
}

fun countPaper(startX: Int, startY: Int, length: Int, paper: Array<IntArray>) {
    // 잘려졌는지 구간 별로 검사
    val half = length / 2

    // 1분면
    if (isNotMatched(startX, startY, half, paper))
        countPaper(startX, startY, half, paper)
    else paperCounts[paper[startX][startY]]++

    // 2분면
    if (isNotMatched(startX, startY + half, half, paper))
        countPaper(startX, startY + half, half, paper)
    else paperCounts[paper[startX][startY + half]]++

    // 3분면
    if (isNotMatched(startX + half, startY, half, paper))
        countPaper(startX + half, startY, half, paper)
    else paperCounts[paper[startX + half][startY]]++

    // 4분면
    if (isNotMatched(startX + half, startY + half, half, paper))
        countPaper(startX + half, startY + half, half, paper)
    else paperCounts[paper[startX + half][startY + half]]++
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