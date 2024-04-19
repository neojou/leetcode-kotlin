package com.neojou

import kotlin.system.measureNanoTime

fun isAlienSorted(words: Array<String>, order: String): Boolean {
    val map = HashMap<Char, Int>()
    for ( (i,c) in order.withIndex() )
        map[c] = i

    fun isSmaller(word1: String, word2: String, map: Map<Char, Int>): Boolean {
        for (i in word1.indices) {
            if (i >= word2.length) return false
            if ( map[word1[i]]!! > map[word2[i]]!! ) return false
            else if ( map[word1[i]]!! < map[word2[i]]!! ) return true
        }
        return true
    }

    for (i in words.size - 1 downTo 1) {
        if ( isSmaller(words[i - 1], words[i], map) == false ) return false
    }
    return true
}

fun main() {
    val words1 = arrayOf("hello","leetcode")
    val order1 = "hlabcdefgijkmnopqrstuvwxyz"
    println(isAlienSorted(words1, order1))

    val words2 = arrayOf("word","world","row")
    val order2 = "worldabcefghijkmnpqstuvxyz"
    println(isAlienSorted(words2, order2))
}


