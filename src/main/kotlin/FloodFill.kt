//#733
fun floodFill(image: Array<IntArray>, sr: Int, sc: Int, color: Int): Array<IntArray> {
    val startColor = image[sr][sc]
    fun flood(i: Int, j: Int) {
        println("Painted [$i][$j]")
        image[i][j] = color
        if (i - 1 >= 0 && image[i-1][j] == startColor) {
            println("Now up")
            flood(i - 1, j)
        }
        if (i + 1 < image.size && image[i+1][j] == startColor) {
            println("Now down")
            flood(i + 1, j)
        }
        if (j - 1 >= 0 && image[i][j-1] == startColor) {
            println("Now left")
            flood(i, j - 1)
        }
        if (j + 1 < image[i].size && image[i][j+1] == startColor) {
            println("Now right")
            flood(i, j + 1)
        }
    }
    if (startColor != color) {
        flood(sr, sc)
    }
    return image
}

fun Array<IntArray>.stringify(): String {
    val builder = StringBuilder()
    forEach { row ->
        for (i in row) {
            builder.append(" $i")
        }
        builder.append("\n")
    }
    return builder.toString()
}

fun main() {
    /*val image = arrayOf(
        intArrayOf(1, 1, 1),
        intArrayOf(1, 1, 0),
        intArrayOf(1, 0, 1),
    )*/

    val image = arrayOf(
        intArrayOf(0, 0, 1),
        intArrayOf(0, 1, 1),
    )

    val sr = 1
    val sc = 1
    val color = 2
    println(image.stringify())
    println("˅")
    println(floodFill(image, sr, sc, color).stringify())
}