//#278
fun isBadVersion(version: Int): Boolean {
    return version >= 1702766719
}

fun firstBadVersion(n: Int): Int {
    var left = 1L
    var right: Long = n.toLong()
    while (left <= right) {
        val mid: Long = (left + right) / 2
        println("left = $left | mid = $mid | right = $right")
        if (isBadVersion(mid.toInt())) {
            right = mid
            if (!isBadVersion((mid-1).toInt())) {
                return mid.toInt()
            }
        } else {
            left = mid + 1
        }
    }
    return 0
}

fun main() {
    println(firstBadVersion(2126753390))
}