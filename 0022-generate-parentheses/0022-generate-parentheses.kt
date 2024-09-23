class Solution {
    val answer = ArrayList<String>()

    fun generateParenthesis(n: Int): List<String> {
        backtracking("", n, 0, 0)
        return answer
    }

    fun backtracking(brackets: String, n: Int, left: Int, right: Int) {
        if (left > n || right > n) return
        if (brackets.length == n * 2) {
            if (isCorrectBracket(brackets)) {
                answer.add(brackets)
            }
            return
        }

        backtracking("$brackets(", n, left + 1, right)
        backtracking("$brackets)", n, left, right + 1)
    }

    fun isCorrectBracket(brackets: String): Boolean {
        val stack = ArrayDeque<Char>()

        for (bracket in brackets) {
            if (bracket == ')') {
                if (stack.isEmpty())
                    return false

                stack.removeLast()
            } else {
                stack.addLast(bracket)
            }
        }

        return stack.isEmpty()
    }
}
