import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))
    val split = readLine().split(" ")
    val n = split[0].toInt()
    val l = split[1].toInt()
    val numArray = IntArray(n) {it+1}
    val visited = BooleanArray(n) {false}
    val result = IntArray(l)

    fun backtracking(numArray: IntArray, visited: BooleanArray, length: Int, result: IntArray, count: Int) {

        if (count == length) {
            result.forEach {
                bw.write("$it ")
            }
            bw.newLine()
            return
        }

        for (i in numArray.indices) {
            if (!visited[i]) {
                visited[i] = true
                result[count] = numArray[i]
                backtracking(numArray, visited, length, result, count+1)
                visited[i] = false
            }
        }
    }

    backtracking(numArray, visited, l, result, 0)
    bw.flush()
    bw.close()
}
