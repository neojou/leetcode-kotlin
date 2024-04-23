package com.neojou

import kotlin.system.measureNanoTime

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun makeListNode(value: Int): ListNode? {
    var value = value
    var ret: ListNode? = null
    do {
        val node = ListNode(value % 2)
        node.next = ret
        ret = node
        value /= 2
    } while (value > 0)
    return ret
}

fun getDecimalValue1(head: ListNode?): Int {
    var ret = 0
    var node = head
    while (node != null) {
        ret *= 2
        ret += node.`val`
        node = node.next
    }
    return ret
}

fun getDecimalValue2(head: ListNode?): Int {
    var node = head
    var bits = 0
    while (node?.next != null) {
        bits++
        node = node?.next
    }

    var ret = 0
    node = head
    while (node != null) {
        ret += node!!.`val` shl bits--
        node = node?.next
    }
    return ret
}

fun getDecimalValue(head: ListNode?): Int {
    var node = head
    var bits = 0
    while (node?.next != null) {
        bits++
        node = node?.next
    }

    var ret = 0
    node = head
    while (node != null) {
        ret += node!!.`val` * Math.pow(2.0, bits--.toDouble()).toInt()
        node = node?.next
    }
    return ret
}

fun main() {
    val head = makeListNode(5)
    println(getDecimalValue(head))
}


