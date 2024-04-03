class Solution {
    fun areAlmostEqual(s1: String, s2: String): Boolean {
        if (s1.length != s2.length) return false
        var mistakes = 0
        var d_idx:Int = 0
        for (i in 0..s1.length - 1) {
            if (s1[i] != s2[i]) {
                if (mistakes == 0) {
                    d_idx = i
                    mistakes++
                } else if (mistakes == 1) {
                    if (s1[i] != s2[d_idx]) return false
                    if (s2[i] != s1[d_idx]) return false
                    mistakes++
                } else {
                    return false
                }
            }
        }
        return when (mistakes) {
            0,2 -> true
            else -> false
        }
    }
}

