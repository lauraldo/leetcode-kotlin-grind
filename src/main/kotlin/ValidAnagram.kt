//#242
fun isAnagram(s: String, t: String): Boolean {
    if (s.length != t.length) {
        return false
    }

    val frequency = mutableMapOf<Char, Int?>()

    s.forEach { letter ->
        frequency[letter] = frequency[letter]?.plus(1) ?: 1
    }

    t.forEach { letter ->
        val temp = frequency[letter]
        if (temp == null || temp <= 0) {
            return false
        } else {
            frequency[letter] = temp - 1
        }
    }

    return true
}


fun isAnagram2(s: String, t: String): Boolean {
    if (s.length != t.length) {
        return false
    }

    val word2copy = t.toMutableList()

    s.forEach { letter ->
        if (!word2copy.contains(letter)) {
            return false
        } else {
            if (!word2copy.remove(letter)) {
                return false
            }
        }
    }

    return word2copy.isEmpty()
}


fun main() {
    println(isAnagram("players", "parsley"))
    println(isAnagram("listen", "silent"))
    println(isAnagram("cheater", "teacher"))
    println(isAnagram("monster", "hamster"))
    println(isAnagram("", ""))

    println("============================================")

    println(isAnagram2("players", "parsley"))
    println(isAnagram2("listen", "silent"))
    println(isAnagram2("cheater", "teacher"))
    println(isAnagram2("monster", "hamster"))
}