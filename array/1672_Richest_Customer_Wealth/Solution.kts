class Solution {
    fun maximumWealth(accounts: Array<IntArray>): Int {
        var max = 0
        for (i in accounts.indices) {
            val money = accounts[i].sum()
            if (money > max) max = money
        }
        return max
    }
}

