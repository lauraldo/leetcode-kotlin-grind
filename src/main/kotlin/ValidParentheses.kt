import java.util.Stack

//#20
fun isValid(s: String): Boolean {
    val opened = Stack<Char>()
    if (s.length % 2 != 0) {
        return false
    }
//    try {
        s.forEach { char ->
            when (char) {
                '(', '[', '{' -> opened.push(char)
                else -> {
                    if (opened.isEmpty()) return false
                    when(char) {
                        ')' -> if (opened.pop() != '(') return false
                        ']' -> if (opened.pop() != '[') return false
                        '}' -> if (opened.pop() != '{') return false
                    }
                }
            }
        }
    /*} catch (_: Exception) {
        return false
    }*/
    return opened.isEmpty()
}

fun main() {
    val s = "({}[]}"
    println(isValid(s))
}