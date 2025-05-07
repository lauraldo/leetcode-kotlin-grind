import java.util.LinkedList

class TreeNode(val `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

fun Array<Int?>.plantTree(): TreeNode? {
    if (isEmpty() || get(0) == null) return null

    val root = get(0)?.let(::TreeNode)

    val queue = LinkedList<TreeNode>()
    queue.addLast(root!!)

    var p: Int = 0
    var current: TreeNode

    while (!queue.isEmpty()) {
        current = queue.removeFirst()
        if (p < size - 1) {
            p++
            val item = get(p)
            if (item != null) {
                current.left = TreeNode(item)
                queue.addLast(current.left!!)
            }
        }
        if (p < size - 1) {
            p++
            val item = get(p)
            if (item != null) {
                current.right = TreeNode(item)
                queue.addLast(current.right!!)
            }
        }
    }

    return root
}

fun TreeNode?.stringify(indent: Int = 0): String {
    val builder = StringBuilder()
    val current: TreeNode? = this
    if (current != null) {
        builder.append(current.`val`)
    }
    if (current?.left != null) {
        builder.append("→")
        builder.append(current.left?.stringify(indent + 1))
    }
    if (current?.right != null) {
        val indented = " ".repeat(indent + 1)
        builder.append("\n")
        builder.append(indented)
        builder.append("↳")
        builder.append(current.right?.stringify(indent + 1))
    }
    return builder.toString()
}