//#1

/*
 * Bruteforce approach - O(n^2)
 */
fun twoSum(nums: IntArray, target: Int): IntArray {
    nums.forEachIndexed { index, i ->
        val diff = target - i
        for (j in index + 1..nums.size - 1) {
            if (nums[j] == diff) {
                return intArrayOf(index, j)
            }
        }
    }
    return intArrayOf(0, 0)
}

/*
 * Better approach with hashmap - 0(n)
 */
fun twoSum2(nums: IntArray, target: Int): IntArray {
    val processed = mutableMapOf<Int, Int>()
    nums.forEachIndexed { index, i ->
        val diff = target - i
        if (processed.containsKey(diff)) {
            val d = processed[diff]
            d?.let {
                return intArrayOf(d, index)
            }
        } else {
            processed.put(i, index)
        }
    }
    return intArrayOf(0, 0)
}

/*
 * Hashmap + Two Pointers approach - 0(n) but even faster
 */
fun twoSum3(nums: IntArray, target: Int): IntArray {
    val processed = mutableMapOf<Int, Int>()
    var start = 0
    var end: Int = nums.lastIndex
    while (start <= end) {
        if (processed.contains(target - nums[start])) {
            return intArrayOf(start, processed[target - nums[start]]!!)
        } else {
            processed[nums[start]] = start
            start++
        }
        if (processed.contains(target - nums[end])) {
            return intArrayOf(processed[target - nums[end]]!!, end)
        } else {
            processed[nums[end]] = end
            end--
        }
    }
    throw IllegalStateException("This should be unreachable")
}

fun main() {
    val test1 = intArrayOf(3, 2, 4, 1, 7, 0, 6, 5)
    val target1 = 13
    println(twoSum3(test1, target1).toList())
}