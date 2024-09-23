class Solution {
    val answer = ArrayList<String>()

    fun generateParenthesis(n: Int): List<String> {
        val length = n * 2
        backtracking("", length)
        return answer
    }

    fun backtracking(brackets: String, length: Int) {
        if (brackets.length == length) {
            if (isCorrectBracket(brackets)) {
                answer.add(brackets)
            }
            return
        }

        backtracking("$brackets(", length)
        backtracking("$brackets)", length)
    }

    fun isCorrectBracket(brackets: String): Boolean {
        val stack = ArrayDeque<Char>()

        for (bracket in brackets) {
            if (bracket == ')'){
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
