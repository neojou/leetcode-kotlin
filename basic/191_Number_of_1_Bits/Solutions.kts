class Solution {
    fun hammingWeight(n: Int): Int {
        var value = n;
        var digits = 0
        while (value > 0) {
            if ((value % 2) == 1) digits++
            value /= 2
        }
        return digits;
    }
}

