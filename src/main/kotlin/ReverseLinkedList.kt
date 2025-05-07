//#206

//First intuitive iterative approach
fun reverseListIterateStack(head: ListNode?): ListNode? {
    if (head == null) return null
    if (head.next == null) return head
    val memo = ArrayDeque<ListNode>()
    var current = head
    while (current != null) {
        memo.addFirst(current)
        current = current.next
    }
    val result: ListNode = memo.removeFirst()
    current = result
    while (!memo.isEmpty()) {
        val refined = memo.removeFirst()
        refined.next = null
        current?.next = refined
        current = current?.next
    }
    return result
}

// Iterative approach but smarter
fun reverseListIterateArray(head: ListNode?): ListNode? {
    if (head == null) return null
    if (head.next == null) return head
    var current = head
    val memo = Array<Int?>(5001) {null}
    var p = 0
    while (current != null) {
        memo[p] = current.`val`
        p++
        current = current.next
    }
    val actualArray = memo.sliceArray(0..<p)
    actualArray.reverse()
    val result = ListNode(actualArray[0]!!)
    current = result
    for (i in 1..<p) {
        current?.next = ListNode(actualArray[i]!!)
        current = current?.next
    }
    return result
}

// Final iterative approach with node rotation
fun reverseList(head: ListNode?): ListNode? {
    var prev: ListNode? = null
    var current = head

    while (current != null) {
        val tmpNext = current.next
        current.next = prev
        prev = current
        current = tmpNext
    }

    return prev
}

// Recursive approach - WIP
fun reverseListRecursive(head: ListNode?): ListNode? {
    if (head == null) return null
    if (head.next == null) return head
    val prev = head.next
    println("prev: ${prev?.stringify()}")
    val newTail = ListNode(head.`val`)
    val result = reverseListRecursive(head.next)
    println("${result?.stringify()} | ${newTail.stringify()}")
    prev?.next = newTail
    /*var current = result
    while (current?.next != null) {
        current = current.next
    }
    current?.next = newTail*/
    return result
}

fun main() {
    val head = intArrayOf(1, 2, 3, 4, 5).toLinkedList()
//    val head = intArrayOf(1, 2, 3).toLinkedList()
    println(head?.stringify())
    println("˅")
//    reverseListRecursive(head)
    println(reverseList(head)?.stringify())
}