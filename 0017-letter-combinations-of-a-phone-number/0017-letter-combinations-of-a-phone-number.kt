class Solution {
    private val answer = ArrayList<String>()

    val letterMap = mapOf(
        Pair('2', "abc"),
        Pair('3', "def"),
        Pair('4', "ghi"),
        Pair('5', "jkl"),
        Pair('6', "mno"),
        Pair('7', "pqrs"),
        Pair('8', "tuv"),
        Pair('9', "wxyz"),
    )

    fun letterCombinations(digits: String): List<String> {
        val charDigits = digits.toCharArray()

        val n = charDigits.size

        if (n == 0) return answer

        backtracking(charDigits, n, 0, "")

        return answer
    }

    fun backtracking(digits: CharArray, n:Int, index:Int, result: String) {

        if (index == n) {
            answer.add(result)
            return
        }

        val letters = letterMap[digits[index]]?.toCharArray()

        for (letter in letters!!) {
            backtracking(digits, n, index+1, result + letter)
        }
    }
}