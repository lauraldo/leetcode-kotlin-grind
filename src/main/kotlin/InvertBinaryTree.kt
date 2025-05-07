//#226
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