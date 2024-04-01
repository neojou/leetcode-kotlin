fun canMakeArithmeticProgression(arr: IntArray): Boolean {
    if (arr.size == 2) return true

    arr.sort()
    val d = arr[1] - arr[0]
    for (i in 2..arr.size - 1)
        if ( arr[i] != arr[i - 1] + d) return false;
    return true;
}

