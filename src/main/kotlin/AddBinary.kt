import kotlin.math.max

//#67
fun addBinary(a: String, b: String): String {
    if (a == "0") return b
    if (b == "0") return a
    val result = CharArray(max(a.length, b.length) + 1)
    val top = "0".repeat(result.size - a.length) + a
    val bottom = "0".repeat(result.size - b.length) + b
    var i = 0
    var overflow = false
    while (i < bottom.length) {
        val bi = bottom.length - 1 - i
        val bval = if (bottom[bi] == '0') 0 else 1
        val tval = if (top[bi] == '0') 0 else 1
        val resval = bval + tval + if (overflow) 1 else 0
        result[bi] = if (resval % 2 == 0) '0' else '1'
        overflow = resval / 2 == 1
        i++
    }
    val res = result.joinToString(separator = "")
    return if (result[0] == '0') res.substring(1) else res
}

fun main() {
    val a = "1111"
    val b = "0"
    println(addBinary(a, b))
}