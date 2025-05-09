//#217
fun containsDuplicate(nums: IntArray): Boolean {
    val memo = mutableMapOf<Int, Boolean>()
    for (num in nums) {
        if (memo[num] != null) {
            return true
        }
        memo[num] = true
    }
    return false
}

fun main() {
    val nums = intArrayOf(1,1,1,3,3,4,3,2,4,2)
    println(containsDuplicate(nums))
}