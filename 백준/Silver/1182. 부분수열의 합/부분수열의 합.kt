import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val split = readLine().split(" ")
    val n = split[0].toInt()
    val target = split[1].toInt()
    val numArray = readLine().split(" ").map { it.toInt() }.toIntArray()
    var answer = 0

    fun backtracking(index:Int, result: Int) {
        if (index == n) {
            if (result == target)
                answer++
            return
        }

        backtracking(index+1, result + numArray[index])
        backtracking(index+1, result)
    }

    backtracking(0, 0)
    // target == 0일 때, 1을 빼주는 이유는 공집합일 경우를 제외하기 위해서.
    println(if (target == 0) answer-1 else answer)
}