fun findTheDifference(s: String, t: String): Char {
    var ret = 0
    for (c in s)
        ret = ret xor (c - 'a')
    for (c in t)
        ret = ret xor (c - 'a')
    return 'a' + ret
}

