import java.util.LinkedList

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

fun invertTree(root: TreeNode?): TreeNode? {
    if (root == null) return null
    val temp = invertTree(root.left)
    root.left = invertTree(root.right)
    root.right = temp

    return root
}

fun main() {
//    val root = arrayOf<Int?>(4,2,7,1,3,6,9).plantTree()
//    val root = arrayOf<Int?>(2, 1, 3, 4, 5, 6, 7).plantTree()
    val root = arrayOf(2, 1, 3, null, null, 4, 5, 6).plantTree()
    println(root?.stringify())
    println("===================>")
    println(invertTree(root).stringify())
}