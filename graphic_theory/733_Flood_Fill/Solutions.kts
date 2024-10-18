package com.neojou

import kotlin.system.measureNanoTime

import java.util.Stack
import java.util.EmptyStackException

class Solution {
    fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int) : Array<IntArray> {
        val oc = image[sr][sc]
        dfs(image, sr, sc, color, oc)
        return image
    }

    private fun dfs(image: Array<IntArray>, sr: Int, sc: Int, nc: Int, oc: Int) {
        if (sr >= image.size || sc >= image[0].size || sr < 0 || sc < 0 || image[sr][sc] == nc || image[sr][sc] != oc)
            return
        image[sr][sc] = nc
        dfs(image, sr + 1, sc, nc, oc)
        dfs(image, sr - 1, sc, nc, oc)
        dfs(image, sr, sc + 1, nc, oc)
        dfs(image, sr, sc - 1, nc, oc)
    }
}

fun main() {
    val sol = Solution()
    val image = arrayOf(intArrayOf(1,1,1), intArrayOf(1,1,0), intArrayOf(1,0,1))
    val sr = 1
    val sc = 1
    val color = 2
    val newImage = sol.floodFill(image, sr, sc, color)

    for (i in 0 until newImage.size) {
        print("[")
        for (j in 0 until newImage[i].size) {
            print(newImage[i][j])
            print(", ")
        }
        println("]")
    }
}

