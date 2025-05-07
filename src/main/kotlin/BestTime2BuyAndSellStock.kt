//#121
fun maxProfit(prices: IntArray): Int {
    var minPrice = 10001
    var profit = 0

    for (current in prices) {
        if (current < minPrice) {
            minPrice = current
        } else {
            val diff = current - minPrice
            if (diff > profit) {
                profit = diff
            }
        }
    }

    return profit
}

fun maxProfitBrute(prices: IntArray): Int {
    var profit = 0

    for (i in 0..prices.size - 2) {
        for (j in i + 1..prices.size - 1) {
            val diff = prices[j] - prices[i]
            if (diff > profit) {
                profit = diff
            }
        }
    }
    return profit
}

fun main() {
//    val prices = intArrayOf(7, 1, 5, 3, 6, 4)
    val prices = intArrayOf(300,200,300,100,200)
//    val prices = intArrayOf(7, 1, 5, 3, 6, 4, 8)
//    val prices = intArrayOf(7,6,4,3,1)
//    val prices = intArrayOf(2,7,1,4)
//    val prices = intArrayOf(60, 3, 0, 8, 4, 13, 1, 100)
//    val prices = intArrayOf(3,2,6,5,0,3)
//    val prices = intArrayOf(2,1,2,1,0,1,2)
//    val prices = intArrayOf(2, 1, 2, 1, 0, 0, 1)
    println(maxProfit(prices))
}