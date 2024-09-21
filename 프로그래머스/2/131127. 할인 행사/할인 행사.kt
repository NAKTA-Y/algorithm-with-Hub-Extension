class Solution {
    fun solution(want: Array<String>, number: IntArray, discount: Array<String>): Int {
        var possibleCount = 0
        val wantMap = mutableMapOf<String, Int>()
        val discountMap = mutableMapOf<String, Int>()

        for (i in want.indices)
            wantMap[want[i]] = number[i]

        for (i in 0 until 10) {
            discountMap[discount[i]] = discountMap.getOrPut(discount[i]) { 0 } + 1
        }

        for (i in 0 until discount.size) {
            if (isBuyable(wantMap, discountMap)) possibleCount++
            discountMap[discount[i]] = discountMap.getValue(discount[i]) - 1
            if (i + 10 < discount.size)
                discountMap[discount[i + 10]] = discountMap.getOrPut(discount[i + 10]) { 0 } + 1
        }

        return possibleCount
    }

    private fun isBuyable(want: Map<String, Int>, discount: Map<String, Int>): Boolean {
        for (stuff in want.keys) {
            if (!discount.containsKey(stuff) || want.getValue(stuff) != discount.getValue(stuff))
                return false
        }

        return true
    }
}
