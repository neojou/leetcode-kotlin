package com.neojou

import kotlin.system.measureNanoTime

class ListNode(var `val`: Int) {
    var next: ListNode? = null

    fun print() {
        print("[" + `val`.toString())
        var p = next
        while (p != null) {
            print( ", " + p!!.`val`.toString())
            p = p.next
        }
        println("]")
    }
}

fun makeListNode(va: IntArray): ListNode? {
    var ret: ListNode? = ListNode(va[0])
    var p = ret
    for (i in 1 until va.size) {
        p!!.next = ListNode(va[i])
        p = p!!.next
    }
    return ret
}

fun middleNode(head: ListNode?): ListNode? {
    var sp = head
    var fp = head?.next
    while (fp != null) {
        sp = sp!!.next
        fp = fp!!.next?.next
    }
    return sp
}

fun main() {
    val vlist = intArrayOf(1, 2, 3, 4, 5, 6)
    val head = makeListNode(vlist)
    middleNode(head)?.print()
}


