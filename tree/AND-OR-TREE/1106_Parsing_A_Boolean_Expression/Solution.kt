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

fun makeTreeNode(v : Int, nl : List<TreeNode>?) : TreeNode {
    val node = makeTreeNode(v)
    node.nodeList = nl
    return node
}

fun evaluateTreeWithOrNode(nl: List<TreeNode>?) : Boolean {
    nl ?: return false
    var result:Boolean = false
    nl.forEach { e -> result = result || evaluateTree(e) }
    return result
}

fun evaluateTreeWithAndNode(nl: List<TreeNode>?) : Boolean {
    nl ?: return false
    var result:Boolean = true
    nl.forEach { e -> result = result && evaluateTree(e) }
    return result
}

fun evaluateTreeWithNotNode(nl: List<TreeNode>?) : Boolean {
    nl ?: return false
    return !evaluateTree(nl[0])
}

fun evaluateTree(root: TreeNode?): Boolean {
    root ?: return false
    return when (root.`val`) {
        0 -> false
        1 -> true
        2 -> evaluateTreeWithOrNode(root.nodeList)
        3 -> evaluateTreeWithAndNode(root.nodeList)
        4 -> evaluateTreeWithNotNode(root.nodeList)
        else -> false
    }
}

fun makeTreeNodeFromString(str: String) : TreeNode? {
    return when (str[0]) {
        'f' -> makeTreeNode(0)
        't' -> makeTreeNode(1)
        '|' -> makeTreeNode(2, makeTreeNodeListFromString(str.substring(2, str.length - 1)))
        '&' -> makeTreeNode(3, makeTreeNodeListFromString(str.substring(2, str.length - 1)))
        '!' -> makeTreeNode(4, makeTreeNodeListFromString(str.substring(2, str.length - 1)))
        else -> null
    }
}

fun findbrace(str:String) : Int {
    var count = 1
    for (i in 0 until str.length) {
        when (str[i]) {
            '(' -> count++
            ')' -> count--
        }
        if (count == 0) return i
    }
    return str.length;
}

fun makeTreeNodeListFromString(str: String) : List<TreeNode>? {
    val nodeList = mutableListOf<TreeNode>()
    var i = 0
    while (i < str.length) {
        when (str[i]) {
            'f' -> { nodeList.add(makeTreeNode(0)); i+=2 }
            't' -> { nodeList.add(makeTreeNode(1)); i+=2 }
            '|','&','!' -> {
                val it = findbrace(str.substring(i+2));
                nodeList.add(
                    makeTreeNode(
                        when (str[i]) {
                            '|' -> 2
                            '&' -> 3
                            '!' -> 4
                            else -> {
                                println("str = " + str + " parsed error!" + ", i = " + i)
                                return null
                            }
                        },
                        makeTreeNodeListFromString(str.substring(i+2, i+2+it))
                    )
                )
                i += it + 4
            }
            else -> {
                println("str = " + str + " parsed error!" + ", i = " + i)
                return null
            }
        }
    }
    return nodeList
}

fun parseBoolExpr(expression: String): Boolean {
    val node = makeTreeNodeFromString(expression)
    node ?: println("str = " + expression + " failed to parse");

    node?.showPostOrder()
    return evaluateTree(node)
}


fun main() {
    //val node = makeTreeNode(3, listOf(makeTreeNode(2, listOf(makeTreeNode(0)))));
    //val node = makeTreeNode(2, listOf(makeTreeNode(0), makeTreeNode(0), makeTreeNode(0), makeTreeNode(1)));
    //val node = makeTreeNode(4, listOf(makeTreeNode(3, listOf(makeTreeNode(0), makeTreeNode(1)))));

    //val str = "&(|(f))"
    //val str = "|(f,f,f,t)"
    val str = "!(&(f,t))"
    println("AND-OR tree evaluate: " + parseBoolExpr(str))
}


