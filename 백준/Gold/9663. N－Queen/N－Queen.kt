import java.io.BufferedReader
import java.io.InputStreamReader

var answer = 0
fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val rowVisited = BooleanArray(n)
    val rightDiagonalVisited = BooleanArray(n * 2 - 1)
    val leftDiagonalVisited = BooleanArray(n * 2 - 1)

    fun backtracking(count: Int) {

        if (count == n) {
            answer++
            return
        }

        for (i in 0 until n) {
            if (rowVisited[i] || rightDiagonalVisited[count + i] || leftDiagonalVisited[count - i + n - 1])
                continue

            rowVisited[i] = true
            rightDiagonalVisited[count + i] = true
            leftDiagonalVisited[count - i + n - 1] = true

            backtracking(count+1)

            rowVisited[i] = false
            rightDiagonalVisited[count + i] = false
            leftDiagonalVisited[count - i + n - 1] = false
        }
    }

    backtracking(0)
    println(answer)
}