package com.neojou

import kotlin.system.measureNanoTime

class TreeNode(var `val`: Int) {
    var nodeList : List<TreeNode>? = null

    fun showPostOrder() {
        showPostOrderHelper(this)
    }

    fun showPostOrderHelper(h: TreeNode?) {
        h ?: return
        print("[")
        if (h.nodeList != null) {
            h.nodeList!!.forEach { item -> showPostOrderHelper(item) }
            print(", ")
        }
        val str:String = when (h.`val`) {
            0 -> "false"
            1 -> "true"
            2 -> "or"
            3 -> "and"
            4 -> "not"
            else -> h.`val`.toString()
        }
        print(str)
        print("]")
    }
}

fun makeTreeNode(v : Int): TreeNode {
    val node = TreeNode(v)
    return node
}

fun makeTreeNode(v : Int, tl : List<TreeNode>) : TreeNode {
    val node = makeTreeNode(v)
    node.nodeList = tl
    return node
}

/*
fun evaluateTree(root: TreeNode?): Boolean {
    root ?: return false
    return when (root.`val`) {
        0 -> false
        1 -> true
        2 -> evaluateTree(root.left) || evaluateTree(root.right)
        3 -> evaluateTree(root.left) && evaluateTree(root.right)
        else -> false
    }
}
*/

fun main() {
    val node = makeTreeNode(3, listOf(makeTreeNode(2, listOf(makeTreeNode(0)))));

    node.showPostOrder()
    //println("AND-OR tree evaluate: " + evaluateTree(head))
}


