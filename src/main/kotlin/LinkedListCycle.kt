//#141
// Pretty straightforward approach, but jumping by 2 nodes at once
fun hasCycleBrute(head: ListNode?): Boolean {
    if (head == null) return false
    val knownNodes = mutableSetOf<ListNode>()
    var current = head
    while (current != null) {
        if (current !in knownNodes) {
            knownNodes += current
        } else {
            return true
        }
        current = current.next?.next
    }
    return false
}

//Now try Floyd "tortoise and hare" algorithm
fun hasCycle(head: ListNode?): Boolean {
    if (head == null) return false
    var slow = head
    var fast = head
    while (fast?.next != null) {
        slow = slow?.next
        fast = fast.next?.next
        if (slow == fast) {
            return true
        }
    }
    return false
}

fun main() {
    val pos = 1
    val head = intArrayOf(3,2,0,-4).toLinkedList(pos)

    println(hasCycle(head))
}