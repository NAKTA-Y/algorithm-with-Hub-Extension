import kotlin.math.abs

enum class HAND { LEFT, RIGHT }

class Solution {
    class Position(val x: Int, val y: Int) {
        fun distanceTo(other: Position) = abs(x - other.x) + abs(y - other.y)
    }

    fun solution(numbers: IntArray, hand: String): String {

        val numberPositionMap = mapOf(
            Pair(1, Position(0, 0)), Pair(2, Position(0, 1)), Pair(3, Position(0, 2)),
            Pair(4, Position(1, 0)), Pair(5, Position(1, 1)), Pair(6, Position(1, 2)),
            Pair(7, Position(2, 0)), Pair(8, Position(2, 1)), Pair(9, Position(2, 2)),
            Pair(0, Position(3, 1))
        )

        val defaultHand = if (hand == "left") HAND.LEFT else HAND.RIGHT
        var leftHand = Position(3, 0)
        var rightHand = Position(3, 2)

        return numbers.map { number ->
            val numberPosition = numberPositionMap[number]!!
            when (number) {
                1, 4, 7 -> HAND.LEFT
                3, 6, 9 -> HAND.RIGHT
                else -> determineHand(leftHand, rightHand, numberPosition, defaultHand)
            }.also { selectedHand ->
                when (selectedHand) {
                    HAND.LEFT -> leftHand = Position(numberPosition.x, numberPosition.y)
                    HAND.RIGHT -> rightHand = Position(numberPosition.x, numberPosition.y)
                }
            }
        }.joinToString("") { it.name.first().toString() }
    }

    private fun determineHand(
        left: Position,
        right: Position,
        target: Position,
        defaultHand: HAND
    ): HAND {

        val leftDistance = left.distanceTo(target)
        val rightDistance = right.distanceTo(target)

        return when {
            leftDistance < rightDistance -> HAND.LEFT
            leftDistance > rightDistance -> HAND.RIGHT
            else -> defaultHand
        }
    }
}