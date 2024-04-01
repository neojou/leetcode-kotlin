class Solution {

    fun isHappy(n: Int): Boolean {
        fun nextInt(n: Int): Int {
            var n = n
            var cal = 0
            while (n > 0) {
                val digit = n % 10
                cal += digit * digit
                n /= 10
            }
            return cal
        }
        
        fun isHappySingleDigit(n: Int): Boolean {
            return when (n) {
                1, 7 -> true
                else -> false
            }
        }

        var slow = n
        var fast = n
        do {
            slow = nextInt(slow)
            if (slow < 10) return isHappySingleDigit(slow)
            fast = nextInt(nextInt(fast))
            if (fast < 10) return isHappySingleDigit(fast)
        } while (slow != fast)

        return false
    }
}

