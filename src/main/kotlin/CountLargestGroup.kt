// #1399
fun countLargestGroup(n: Int): Int {
    val digitSums = mutableMapOf<Int, Int>()
    for (i in 1..n) {
        val sum: Int = i % 10 +
                i % 100 / 10 +
                i % 1000 / 100 +
                i % 10000 / 1000 +
                i / 10000
        if (digitSums.contains(sum)) {
            digitSums[sum] = digitSums[sum]!! + 1
        } else {
            digitSums[sum] = 1
        }
    }

    /*val maxGroupSize = digitSums.values.max()
    var maxGroupSizeCount = 0
    digitSums.values.forEach { q ->
        if (q == maxGroupSize) {
            maxGroupSizeCount++
        }
    }*/

    val maxGroupSize = digitSums.values.max()
    return digitSums.values.count { item -> item == maxGroupSize }
}

//Not my code mostly, but I changed IntArray(45) to IntArray(36), because it's bare maximum of sum groups
fun countLargestGroupLikeChad(n: Int): Int {
    val groupsCount = IntArray(36)
    repeat(n){
        var numSum = 0
        var current = it + 1
        while(current > 0){
            numSum += current % 10
            current = current / 10
        }
        groupsCount[numSum - 1]++
    }
    var max = 0
    var maxCount = 0
    groupsCount.forEach {
        if (it > max){
            maxCount = 1
            max = it
        } else if (it == max) {
            maxCount++
        }
    }
    return maxCount
}

fun main() {
    val n = 10000
    println(countLargestGroupLikeChad(n))
}