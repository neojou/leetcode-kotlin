class Solution {
    fun interpret(command: String): String {
        val ret = StringBuilder()
        val len = command.length
        val ca = command.toCharArray()
        var i = 0
        while (i < len) {
            if (ca[i] == '(') {
                if (ca[i + 1] == ')') {
                    ret.append('o')
                    i += 2
                } else {
                    ret.append('a').append('l')
                    i += 4
                }
            } else {
                ret.append(ca[i++])
            }
        }
        return ret.toString()
    }
}

