import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val split = readLine().split(" ")
    val n = split[0].toInt()
    val l = split[1].toInt()
    val numArray = IntArray(n) {it+1}
    val visited = BooleanArray(n) {false}

    backtracking(numArray, visited, l, "", 0)
}

fun backtracking(numArray: IntArray, visited: BooleanArray, length: Int, result: String, count: Int) {

    if (count == length) {
        println(result.trim())
        return
    }

    for (i in 0 until numArray.size) {
        if (!visited[i]) {
            visited[i] = true
            backtracking(numArray, visited, length, "$result ${numArray[i]}", count+1)
            visited[i] = false
        }
    }
}