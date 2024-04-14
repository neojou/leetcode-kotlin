fun mergeAlternately(word1: String, word2: String): String {
    val builder = StringBuilder(word1)
    val minLen = Math.min(word1.length, word2.length)
    var j = 0
    while (j < minLen)
        builder.insert(2*j+1, word2[j++])
    if (j < word2.length)
        builder.append(word2, j, word2.length)
    return builder.toString()
}

