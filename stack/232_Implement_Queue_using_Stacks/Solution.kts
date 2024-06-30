class MyQueue() {

    private val s1 = Stack<Int>()
    private val s2 = Stack<Int>()

    fun push(x: Int) {
        s1.push(x)
    }

    fun pop(): Int {
        if (s2.isEmpty()) {
            while (s1.isNotEmpty())
                s2.push(s1.pop())
        }
        return s2.pop()
    }

    fun peek(): Int {
        if (s2.isEmpty()) {
            while (s1.isNotEmpty())
                s2.push(s1.pop())
        }
        return s2.peek()
    }

    fun empty(): Boolean {
        return s1.isEmpty() && s2.isEmpty()
    }

}

