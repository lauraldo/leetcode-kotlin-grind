//#704
fun searchIterate(nums: IntArray, target: Int): Int {
    var mid: Int
    var left = 0
    var right = nums.size - 1
    while (left <= right) {
        mid = (right + left) / 2
        if (nums[mid] == target) {
            return mid
        }
        if (target > nums[mid]) {
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    return -1
}

fun search(nums: IntArray, target: Int, left: Int = 0, right: Int = nums.size - 1): Int {
    if (left > right) return -1
    val mid = (left + right) / 2
    if (target == nums[mid]) {
        return mid
    }
    println("left = $left, mid = $mid, right = $right")
    return if (target > nums[mid]) {
        search(nums, target, mid + 1, right)
    } else {
        search(nums, target, left, mid - 1)
    }
}

fun main() {
//    val nums = intArrayOf(-1,0,1,3,5,5, 8, 9,12, 14)
//    val nums = intArrayOf(-1,0,3,5,9,12)
//    val nums = intArrayOf(1, 2, 3, 4, 9)
//    val nums = intArrayOf(9, 10, 11)
//    val nums = intArrayOf(8, 9)
    val nums = intArrayOf(1, 2, 3, 4)
//    val nums = intArrayOf()
    println(search(nums, 9))
}