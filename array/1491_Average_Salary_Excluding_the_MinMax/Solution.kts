fun average(salary: IntArray): Double {
    val nums = salary.size;

    var min:Int;
    var max:Int;
    var sum:Int;

    if (salary[0] < salary[1]) {
        min = salary[0]
        max = salary[1]
    } else {
        min = salary[1]
        max = salary[0]
    }

    sum = salary[0] + salary[1]

    for (i in 2 until nums) {
        val value = salary[i]

        sum += value
        if (value < min) {
            min = value
        }
        else if (value > max) {
            max = value
        }
    }

    sum -= min + max

    return ( sum.toDouble() / (nums - 2) )
}

