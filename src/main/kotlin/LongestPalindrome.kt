//#409
fun longestPalindrome(s: String): Int {
    val memo = IntArray(52) {0}
    for (c in s) {
        if (c < 'a') {
            // Uppercase letters
            memo[c -'A'] += 1
        } else {
            //Lowercase letters
            memo[c - 'a' + 26] += 1
        }
    }
    var pairCount = 0
    for (i in memo) {
        if (i > 1) {
            pairCount += i / 2
        }
    }
    val result = pairCount * 2
    return if (result < s.length) result + 1 else result
}

fun main() {
//    val s = "abccccdd"
//    val s = "ABRACADABRA"
    val s = "aBrAcAdAbRa"
//    val s = "a"
    println(longestPalindrome(s))
}