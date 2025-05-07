//#21
// Iterative approach, just brute-force
fun mergeTwoLists2(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null && list2 != null) return list2
    if (list2 == null && list1 != null) return list1
    if (list1 == null) return null
    var current1: ListNode = list1
    var current2: ListNode? = list2!!
    do {
        current1 = current1.orderedInsert(current2!!.`val`)
        current2 = current2.next
    } while (current2 != null)
    return current1
}

fun ListNode.orderedInsert(value: Int): ListNode {
    var current: ListNode? = this
    var prev: ListNode? = null
    var newNode: ListNode? = null
    do {
        if (current!!.`val` >= value) {
            newNode = ListNode(value)
            newNode.next = current
            prev?.let {
                it.next = newNode
                return this
            }
            return newNode
        }
        prev = current
        current = current.next
    } while (current != null)

    if (newNode == null) {
        newNode = ListNode(value)
        prev.next = newNode
    }

    return this
}

// Now recursive
fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    if (list1 == null || list2 == null) {
        return list1 ?: list2
    }
    if (list1.`val` < list2.`val`) {
        list1.next = mergeTwoLists(list1.next, list2)
        return list1
    } else {
        list2.next = mergeTwoLists(list1, list2.next)
        return list2
    }
}

fun main() {
    val list1 = intArrayOf(1, 2, 4).toLinkedList()
    println("list1 = ${list1?.stringify()}")
    val list2 = intArrayOf(-3, -2, 1, 2, 3, 7, 7).toLinkedList()
    println("list2 = ${list2?.stringify()}")
    val merge = mergeTwoLists(list1, list2)
    println("merge = ${merge?.stringify()}")
}