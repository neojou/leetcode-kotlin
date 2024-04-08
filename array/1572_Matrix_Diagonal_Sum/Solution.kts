class Solution {
    fun diagonalSum(mat: Array<IntArray>): Int {
        var sum = 0
        val last = mat.size - 1
        for (i in 0..last) {
            sum += mat[i][i]
            sum += mat[i][last - i]
        }
        if (last % 2 == 0) {
            val mid = last / 2
            sum -= mat[mid][mid]
        }
        return sum
    }
}

