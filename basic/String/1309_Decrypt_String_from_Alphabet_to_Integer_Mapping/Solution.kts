package com.neojou

import kotlin.system.measureNanoTime

val map = mapOf(
    "1" to "a",
    "2" to "b",
    "3" to "c",
    "4" to "d",
    "5" to "e",
    "6" to "f",
    "7" to "g",
    "8" to "h",
    "9" to "i",
    "10#" to "j",
    "11#" to "k",
    "12#" to "l",
    "13#" to "m",
    "14#" to "n",
    "15#" to "o",
    "16#" to "p",
    "17#" to "q",
    "18#" to "r",
    "19#" to "s",
    "20#" to "t",
    "21#" to "u",
    "22#" to "v",
    "23#" to "w",
    "24#" to "x",
    "25#" to "y",
    "26#" to "z",
)

fun freqAlphabets(s: String): String {
    val ret = StringBuilder()
    var pos = s.length - 1
    while (pos >= 0) {
        if (s[pos] == '#') {
            ret.append(map[s.substring(pos - 2, pos + 1)])
            pos -= 3
        } else {
            ret.append(map[s.substring(pos, pos + 1)])
            pos--
        }
    }
    return ret.reverse().toString()
}

fun freqAlphabets1(s: String): String {
    val sc = s.toCharArray()
    val ret = StringBuilder()
    var pos = sc.size - 1
    while (pos >= 0) {
        val mc: Char
        if (sc[pos] == '#') {
            mc = ((sc[pos - 2].code - '1'.code) * 10 + (sc[pos - 1].code - '0'.code) + 'j'.code).toChar()
            pos -= 3
        } else {
            mc = (sc[pos].code - '1'.code + 'a'.code).toChar()
            pos--
        }
        ret.insert(0, mc)
    }
    return ret.toString()
}

fun main() {
    val s = "10#11#12"
    println(freqAlphabets(s))
}



