class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

fun IntArray.toLinkedList(cycleIndex: Int = -1): ListNode? {
    val head = ListNode(this[0])
    var prev: ListNode = head
    var cycledNode: ListNode? = null
    for (i in 1..this.size - 1) {
        val node = ListNode(this[i])
        if (i == cycleIndex) {
            cycledNode = node
        }
        prev.next = node
        prev = node
    }
    cycledNode?.let {
        prev.next = it
    }
    return head
}

fun ListNode.stringify(): String {
    var current: ListNode? = this
    val builder = StringBuilder()
    do {
        builder.append(current?.`val`)
        builder.append(", ")
        current = current?.next
    } while (current != null)
    return builder.toString()
}