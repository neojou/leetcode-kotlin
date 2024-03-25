class Solution {
    fun countOdds(low: Int, high: Int): Int {
        val min_odd = low or 0x1
        return if (high < min_odd) 0
        else (high - min_odd) / 2 + 1        
    }
}

