package com.neojou

import kotlin.system.measureNanoTime

fun toLowerCase1(s: String): String {
    val ret = StringBuilder()
    for (i in s.indices) {
        if (s[i] in 'A'..'Z')
            ret.append((s[i].code - 'A'.code + 'a'.code).toChar())
        else
            ret.append(s[i])
    }
    return ret.toString()
}

fun toLowerCase(s: String): String {
    return s.lowercase()
}

fun main() {
    val s = "Hello"
    println(toLowerCase(s))
}


