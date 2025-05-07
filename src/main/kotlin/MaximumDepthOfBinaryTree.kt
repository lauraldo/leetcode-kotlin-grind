import kotlin.math.max

//#104
fun maxDepth(root: TreeNode?): Int {
    if (root == null) return 0
    val ldepth = maxDepth(root.left) + 1
    val rdepth = maxDepth(root.right) + 1
    return max(ldepth, rdepth)
}

fun main() {
//    val root = arrayOf(3,9,20,null,null,15,7).plantTree()
//    val root = arrayOf(1,2,2,3,null,null,3,4,null,null,4,5,null).plantTree()
    val root = arrayOf(1, 2, null, 3, 3, null, null, 4, 4, 4 ,4).plantTree()
//    val root = arrayOf(1,null,2).plantTree()
//    val root = arrayOf<Int?>().plantTree()
    println(root.stringify())
    println("Max depth = ${maxDepth(root)}")
}