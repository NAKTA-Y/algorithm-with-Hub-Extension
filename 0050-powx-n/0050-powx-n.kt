class Solution {
    fun myPow(x: Double, n: Int): Double {
        if (n == 0) return 1.0
        if (Int.MIN_VALUE < n && n < 0) {
            return myPow(1 / x, -n)
        }

        if (n % 2 == 0)
            return myPow(x * x, n / 2)
        else
            return x * myPow(x, n - 1)
    }
}