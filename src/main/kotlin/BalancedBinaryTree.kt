import kotlin.math.abs
import kotlin.math.max

//#110

fun isBalanced(root: TreeNode?/*, depth: Int = 0*/): Boolean {

    fun getSubtreeHeight(node: TreeNode?): Int {
        return if (node == null) {
            0
        } else {
            max(getSubtreeHeight(node.left), getSubtreeHeight(node.right)) + 1
        }
    }

    if (root == null) return true

    if (abs(getSubtreeHeight(root.left) - getSubtreeHeight(root.right)) > 1) {
        return false
    }

    return isBalanced(root.left) && isBalanced(root.right)

    /*return if (root.left != null && root.right != null) {
        isBalanced(root.left) && isBalanced(root.right)
    } else {
        !((root.left == null && root.right?.left != null || root.right?.right != null)
                || (root.right == null && root.left?.left != null || root.left?.right != null))
    }*/
}

fun main() {
    val root = arrayOf<Int?>(3,9,20,null,null,15,7).plantTree()
//    val root = arrayOf<Int?>(1,2,2,3,null,null,3,4,null,null,4).plantTree()
    println(root.stringify())
    println(isBalanced(root))
}