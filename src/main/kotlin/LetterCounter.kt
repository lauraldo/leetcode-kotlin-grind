/**
 * Count unique letters when all lowercase goes before any uppercase
 * Don't know if it is LeetCode case but encountered it on Codility assessment
 */

fun solution(letters: String): Int {

    val letterMemo = IntArray(26) { 0 }

    var resultCounter = 0
    for (letter in letters) {
        if (letter < 'a') {
            // Uppercase letter
            if (letterMemo[letter - 'A'] == 1) {
                resultCounter++
                letterMemo[letter - 'A'] = 3
            } else {
                letterMemo[letter - 'A'] = 2
            }
            println("Uppercase $letter")
        } else {
            // Lowercase letter
            if (letterMemo[letter - 'a'] < 2) {
                println("Lowercase $letter is still new")
                letterMemo[letter - 'a'] = 1
            } else {
                if (letterMemo[letter - 'a'] == 3) {
                    resultCounter--
                }
                println("Lowercase $letter already had uppercase")
            }
        }
    }
    return resultCounter
}

fun main() {
    println(solution("aaAbcCABBc"))
//    println (solution("xyzXYZabcABC"))
//    println(solution("ABCabcAefG"))
}