package com.neojou

import kotlin.system.measureNanoTime

import java.util.Stack
import java.util.EmptyStackException

fun isAnagram1(s: String, t: String): Boolean {
    if (s.length != t.length) return false
    val tb = StringBuilder(t)
    for (si in s) {
        val i = tb.indexOf(si)
        if (i == -1) return false
        tb.deleteAt(i)
    }
    return true
}

fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) return false
    val stat_s = IntArray(26)
    val stat_t = IntArray(26)
    for (i in 0 until s.length) {
        stat_s[s[i] - 'a']++
        stat_t[t[i] - 'a']++
    }
    if (stat_s.contentEquals(stat_t)) return true
    return false
}

fun main() {
    // true
    println(isAnagram("anagram", "nagaram"))
    
    // false
    println(isAnagram("rat", "car"))
    
    // false
    println(isAnagram("a", "ab"))
}




