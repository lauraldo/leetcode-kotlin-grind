import java.util.LinkedList

//#235

fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (root == null) {
        return null
    }
    val queue = LinkedList<TreeNode>()
    queue.addLast(root)
    while (!queue.isEmpty()) {
        val current = queue.removeFirst()
        println("Processing ${current.`val`}")
        if (p == current) {
            return p
        }
        if (q == current) {
            return q
        }
        if (current.`val` in p!!.`val`..q!!.`val` || current.`val` in q.`val`..p.`val`) {
            //p and q are from different subtrees
            println("Different subtrees!")
            return current
        } else {
            if (p.`val` > current.`val`) {
                // p and q are both in right subtree
                println("Now go right")
                current.right?.let { queue.addLast(it) }
            } else {
                // p and q are both in left subtree
                println("Now go left")
                current.left?.let { queue.addLast(it) }
            }
        }
    }
    return null
}

//Recursive approach
fun lowestCommonAncestorRecursive(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    if (root == null) {
        return null
    }
    if (p == root) {
        return p
    }
    if (q == root) {
        return q
    }
    return if (root.`val` in p!!.`val`..q!!.`val` || root.`val` in q.`val`..p.`val`) {
        //p and q are from different subtrees
        root
    } else {
        if (p.`val` > root.`val`) {
            // p and q are both in right subtree
            lowestCommonAncestorRecursive(root.right, p, q)
        } else {
            // p and q are both in left subtree
            lowestCommonAncestorRecursive(root.left, p, q)
        }
    }
}

fun main() {
//    val root = arrayOf(6,2,8,0,4,7,9,null,null,3,5).plantTree()
    val root = arrayOf(6,2,8,0,4,7,9,null,null,3,5).plantTree()
//    val root = arrayOf<Int?>(2, 1).plantTree()
    val p = root?.left?.right?.left
    val q = root?.left?.right?.right
    println(root.stringify())
    println("\nLCA = ${lowestCommonAncestor(root, p, q)?.`val`}. Welcome to Larnaca :)")
}