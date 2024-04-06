fun checkStraightLine(coordinates: Array<IntArray>): Boolean {
    if (coordinates.size < 2) return false
    if (coordinates.size == 2) return true
    val bp = coordinates[0]
    val dx = coordinates[1][0] - bp[0]
    val dy = coordinates[1][1] - bp[1]
    for (i in 2 until coordinates.size) {
        val dx1 = coordinates[i][0] - bp[0]
        val dy1 = coordinates[i][1] - bp[1]
        if (dy1 * dx != dx1 * dy) {
            return false
        }
    }
    return true
}


