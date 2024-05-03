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

fun isLeaf(node: TreeNode): Boolean {
    if (node.left != null) return false
    if (node.right != null) return false
    return true
}

fun sumOfLeftLeaves1(root: TreeNode?): Int {
    root ?: return 0
    if (isLeaf(root)) return 0

    return sumOfLeftLeavesHelper(root!!)
}

fun sumOfLeftLeavesHelper(node: TreeNode): Int {
    var sum = 0
    if (node.left != null) {
        if (isLeaf(node.left!!))
            sum += node.left!!.`val`
        else
            sum += sumOfLeftLeavesHelper(node.left!!)
    }
    if (node.right != null) {
        if (!isLeaf(node.right!!))
            sum += sumOfLeftLeavesHelper(node.right!!)
    }
    return sum
}

fun sumOfLeftLeaves(root: TreeNode?): Int {
    root ?: return 0

    var res = 0

    fun helper(node: TreeNode, isLeft: Boolean) {
        if (node.left == null && node.right == null && isLeft)
            res += node.`val`

        node.left?.let { helper(it, true) }
        node.right?.let { helper(it, false) }
    }

    helper(root, false)

    return res
}


fun main() {
    //val root : List<Int?> = listOf(3, 9, 20, null, null, 15, 7)
    val root : List<Int?> = listOf(1)
    val head = makeTreeNode(root)
    head?.showInorder()
    println("sum: " + sumOfLeftLeaves(head))
}


