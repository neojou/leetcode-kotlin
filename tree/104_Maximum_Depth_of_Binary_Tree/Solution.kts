package com.neojou

import kotlin.system.measureNanoTime

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null

    fun showInorder() {
        print("[")
        showInorderHelper(this)
        println("]")
    }

    fun showInorderHelper(h: TreeNode?) {
        h ?: return
        showInorderHelper(h!!.left)
        print(h.`val`.toString() + ", ")
        showInorderHelper(h!!.right)
    }
}

fun makeTreeNode(va: List<Int?>): TreeNode? {
    var nval : Int? = va.getOrNull(0)
    nval ?: return null
    val node = TreeNode(nval!!)
    val layer : List<TreeNode> = listOf(node)

    if (va.size > 1)
        makeTreeLayer(layer, va.subList(1, va.size))

    return node
}

fun makeTreeLayer(layer: List<TreeNode>, va: List<Int?>) {
    var pos = 0
    val nextLayer = mutableListOf<TreeNode>()
    for (e in layer) {
        var value = va.getOrNull(pos++)
        if (value != null) {
            e.left = TreeNode(value)
            nextLayer.add(e.left!!)
        }
        value = va.getOrNull(pos++)
        if (value != null) {
            e.right = TreeNode(value)
            nextLayer.add(e.right!!)
        }
    }
    if (nextLayer.size > 0)
        makeTreeLayer(nextLayer, va.subList(pos, va.size))
}

fun maxDepth(root: TreeNode?): Int {
    root ?: return 0
    val ld = maxDepth(root.left)
    val rd = maxDepth(root.right)
    return 1 + Math.max(ld, rd)
}

fun main() {
    //val root : List<Int?> = listOf(3, 9, 20, null, null, 15, 7)
    val root : List<Int?> = listOf(1, null, 2)
    val head = makeTreeNode(root)
    head?.showInorder()
    println("max depth: " + maxDepth(head))
}


