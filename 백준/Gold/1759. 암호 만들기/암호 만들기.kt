import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val length = readLine().split(" ")[0].toInt()
    val chars = readLine().split(" ").sorted()

    makeCypher("", chars, 0, length)
}

fun makeCypher(cypher: String ,chars: List<String>, start: Int, length: Int) {
    if (cypher.length == length) {
        if (isCypher(cypher, length))
            println(cypher)
        return
    }

    for (i in start until chars.size) {
        makeCypher(cypher + chars[i], chars, i+1, length)
    }
}

fun isCypher(cypher: String, length: Int): Boolean {
    val vowelCount = cypher.count() { it in setOf('a', 'e', 'i', 'o', 'u') }

    return vowelCount >= 1 && vowelCount <= length-2
}