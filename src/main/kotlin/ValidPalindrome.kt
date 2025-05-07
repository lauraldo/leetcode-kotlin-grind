//#125
fun isPalindrome(s: String): Boolean {
    var start = 0
    var end = s.length - 1
    while (start <= end) {
        while (start < end &&  s[start] !in 'A'..'Z' && s[start] !in 'a'..'z' && s[start] !in '0'..'9' )
            start++
        while (end > start && s[end] !in 'A'..'Z' && s[end] !in 'a'..'z' && s[end] !in '0'..'9' )
            end--
        println("${s[start]} = ${s[end]}")
        if (s[start].lowercase() != s[end].lowercase()) return false
        start++
        end--
    }
    return true
}

fun main() {
//    val s = "9#- A man, a plan, a canal: Panama9%^$^%$ "
//    val s = "race a car"
//    val s = "lol"
    val s = "  a"
    println(isPalindrome(s))
}