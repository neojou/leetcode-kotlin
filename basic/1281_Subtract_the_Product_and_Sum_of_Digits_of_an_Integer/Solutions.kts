class Solution {
    fun subtractProductAndSum(n: Int): Int {
        var value = n
        var product = 1
        var sum = 0

        while (value > 0) {
            product *= (value % 10)
            sum += (value % 10)
            value /= 10
        }

        return product - sum
    }
}

