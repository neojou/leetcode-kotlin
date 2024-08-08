package com.neojou

import kotlin.system.measureNanoTime

import java.util.Stack
import java.util.EmptyStackException

class ParkingSystem1(big: Int, medium: Int, small: Int) {
    val maxCars = intArrayOf(big, medium, small)
    fun addCar(carType: Int): Boolean {
        if (carType < 1 || carType > 3) return false
        if (maxCars[carType - 1] == 0) return false
        maxCars[carType - 1]--
        return true
    }
}

class ParkingSystem(big: Int, medium: Int, small: Int) {
    var big = big
    var medium = medium
    var small = small
    fun addCar(carType: Int): Boolean {
        return when (carType) {
            1 -> {
                if (big > 0) {
                    big--
                    true
                } else {
                    false
                }
            }
            2 -> {
                if (medium > 0) {
                    medium--
                    true
                } else {
                    false
                }
            }
            3 -> {
                if (small > 0) {
                    small--
                    true
                } else {
                    false
                }
            }
            else -> false
        }
    }
}

fun main() {
    val parkingSystem = ParkingSystem(1, 1, 0)
    println(parkingSystem.addCar(1))
    println(parkingSystem.addCar(2))
    println(parkingSystem.addCar(3))
    println(parkingSystem.addCar(1))
}




