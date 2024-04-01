class Solution {
    fun arraySign(nums: IntArray): Int {
        var neg_nums = 0
        for (i in nums.indices) {
            when {
                nums[i] == 0 -> return 0
                nums[i] < 0 -> neg_nums++
            }
        }

        return when (neg_nums % 2) {
            0 -> 1
            else -> -1
        }
    }
}

