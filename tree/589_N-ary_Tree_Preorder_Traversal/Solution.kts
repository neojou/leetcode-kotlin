package com.neojou

class Node(var `val`: Int) {
    var children: List<Node?> = listOf()
}

class Solution {
    fun preorder(root: Node?): List<Int> {
        val res = mutableListOf<Int>()
        preorderHelper(root, res)
        return res
    }

    fun preorderHelper(root: Node?, res: MutableList<Int>) {
        root ?: return
        res.add(root.`val`)
        root.children.forEach {
            preorderHelper(it, res)
        }
    }
}

fun makeNode(input: List<Int?>): Node? {
    if (input.size < 2) return null
    if (input[0] == null) return null
    if (input[1] != null) return null

    val output = Node(input.get(0)!!)
    val nextLayer = mutableListOf<Node?>()
    nextLayer.add(output)
    makeNodeLayerHelper(nextLayer, input.subList(2, input.size))
    return output
}

fun find_first_null_idx(input: List<Int?>, sp: Int = 0): Int {
    var ret = sp
    while (ret < input.size) {
        if (input.get(ret) == null) break
        ret++
    }
    return ret
}

fun makeNodeLayerHelper(children:List<Node?>, input: List<Int?>) {
    if (input.size == 0) return

    var s_idx = 0
    var e_idx = find_first_null_idx(input)
    val nextLayer = mutableListOf<Node?>()
    for (i in 0..children.size - 1) {
        if (s_idx < e_idx) {
            for (j in s_idx..e_idx - 1) {
                val node = Node(input.get(j)!!)
                val cNode = children.get(i)
                cNode!!.children = cNode.children.plus(node)
                nextLayer.add(node)
            }
        }
        s_idx = e_idx + 1
        if (s_idx >= input.size) return
        e_idx = find_first_null_idx(input, s_idx)
    }
    makeNodeLayerHelper(nextLayer, input.subList(s_idx, input.size))
}

fun main() {
    val input = listOf(1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14)
    val root = makeNode(input)
    val s = Solution()
    println(s.preorder(root))
}


