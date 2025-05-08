//#876
fun middleNodeIntuitive(head: ListNode?): ListNode? {
    if (head == null) return null
    var current = head
    var middle = head
    var step = 0
    var middleStep = 0
    while (current != null) {
        step++
        if (middleStep < step / 2) {
            middleStep++
            middle = middle?.next
        }
        current = current.next
    }
    return middle
}

//Tortoise and hare algorithm
fun middleNode(head: ListNode?): ListNode? {
    if (head == null) return null
    var slow = head
    var fast = head
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
    }
    return slow
}

fun main() {
    val head = intArrayOf(1, 2, 3, 4, 5, 6).toLinkedList()
    println(middleNode(head)?.`val`)
}