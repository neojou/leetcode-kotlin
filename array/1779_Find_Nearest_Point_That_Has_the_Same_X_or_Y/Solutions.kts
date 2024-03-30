class Solution {
    fun nearestValidPoint(x: Int, y: Int, points: Array<IntArray>): Int {
        var min_dist = Int.MAX_VALUE
        var result = -1
        for (idx in points.indices) {
            val dist: Int;
            if (x == points[idx][0]) {
                dist = Math.abs(y - points[idx][1])
            } else if (y == points[idx][1]){
                dist = Math.abs(x - points[idx][0])
            } else
                continue
            if (dist < min_dist) {
                min_dist = dist
                result = idx
            }
        }
        return result
    }
}

