//#383
fun canConstruct(ransomNote: String, magazine: String): Boolean {
    val frequency = mutableMapOf<Char, Int?>()
    for (c in magazine) {
        frequency.put(c, (frequency[c] ?: 0) + 1)
    }
    for (c in ransomNote) {
        if (frequency[c] == null || frequency[c] == 0) {
            return false
        } else {
            frequency[c] = frequency[c]?.minus(1)
        }
    }
    return true
}

fun main() {
    val ransomNote = "defac"
    val magazine = "abcdef"
    println(canConstruct(ransomNote, magazine))
}