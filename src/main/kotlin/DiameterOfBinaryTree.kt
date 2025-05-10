import kotlin.math.max

//#543
fun diameterOfBinaryTree(root: TreeNode?): Int {

    var maxHeight = 0

    fun subtreeHeight(node: TreeNode?): Int {
        if (node == null) return 0
        val lh = subtreeHeight(node.left)
        val rh = subtreeHeight(node.right)
        val h = 1 + max(lh, rh)
        maxHeight = max(maxHeight, lh + rh)
        return h
    }

    //We don't need global height result
    subtreeHeight(root)

    return maxHeight
}

fun main() {
    val root = arrayOf<Int?>(1,2,3,4,5).plantTree()
//    val root = arrayOf<Int?>(1,2,3,4,5, null, null, null, null, 7, 8, 9).plantTree()
//    val root = arrayOf<Int?>(1,2,3,4,5, null, null, 10, 11, 7, 8, 9, null, null, null, 12, 13).plantTree()
//    val root = arrayOf<Int?>(1,2).plantTree()
    println(root.stringify())
    println("diameter = ${diameterOfBinaryTree(root)}")
}