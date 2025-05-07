import java.util.Stack

//#232
class MyQueueBuffered() {

    private val main = Stack<Int>()
    private val buffer = Stack<Int>()

    fun push(x: Int) {
        while (!main.isEmpty()) {
            buffer.push(main.pop())
        }
        main.push(x)
        while (!buffer.isEmpty()) {
            main.push(buffer.pop())
        }
    }

    fun pop(): Int {
        return main.pop()
    }

    fun peek(): Int {
        return main.peek()
    }

    fun empty(): Boolean {
        return main.isEmpty()
    }
}

// Stack exchange now on pop/peek instead of push
class MyQueue() {

    private val inStack = Stack<Int>()
    private val outStack = Stack<Int>()

    fun push(x: Int) {
        inStack.push(x)
    }

    fun pop(): Int {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop())
            }
        }
        return outStack.pop()
    }

    fun peek(): Int {
        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop())
            }
        }
        return outStack.peek()
    }

    fun empty(): Boolean {
        return inStack.isEmpty() && outStack.isEmpty()
    }
}

fun main() {
    val myQueue = MyQueue()
    myQueue.push(1)
    myQueue.push(2)
    println("queue.peek == ${myQueue.peek()}")
    println("queue.pop == ${myQueue.pop()}")
    println("queue.empty == ${myQueue.empty()}")
}