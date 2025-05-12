//#53
fun maxSubArray(nums: IntArray): Int {
    var maxSum = nums[0]
    var currentSum = 0
    for (num in nums) {
        currentSum += num
        if (currentSum > maxSum) {
            maxSum = currentSum
        }
        if (currentSum < 0) {
            currentSum = 0
        }
    }
    return maxSum
}

fun main() {
    val nums = intArrayOf(-2,1,-3,4,-1,2,1,-5,4)
//    val nums = intArrayOf(-1)
//    val nums = intArrayOf(-2, -1, -3)
//    val nums = intArrayOf(5,4,-1,7,8)
    println(maxSubArray(nums))
}