//#70
fun climbStairs(n: Int): Int {
    val memo = IntArray(46)
    memo[0] = 1
    memo[1] = 1
    for (i in 2..n) {
        memo[i] = memo[i-1] + memo[i-2]
    }
    return memo[n]
}

fun main() {
    val n = 45
    println(climbStairs(n))
}