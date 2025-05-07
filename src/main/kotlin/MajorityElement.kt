//#169
fun majorityElementNaive(nums: IntArray): Int {
    val memo = mutableMapOf<Int, Int>()
    nums.forEach { i ->
        val count = (memo[i] ?: 0) + 1
        if (count > nums.size / 2) {
            return i
        }
        memo[i] = count
    }
    throw Exception("No majority element here")
}

//Boyer-Moore solution
fun majorityElement(nums: IntArray): Int {
    var result: Int = -1
    var count: Int = 0
    for (item in nums) {
        if (count == 0) {
            result = item
        }
        if (item == result) {
            count++
        } else {
            count--
        }
    }
    return result
}

fun main() {
//    val nums = intArrayOf(3, 2, 3)
    val nums = intArrayOf(2,2,1,1,1,2,2)
    println(majorityElement(nums))
}