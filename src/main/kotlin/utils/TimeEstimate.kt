package utils

import java.util.concurrent.TimeUnit

inline fun estimate(block: () -> Unit): Long {
    val start = System.nanoTime()
    block()
    val end = System.nanoTime()
    return TimeUnit.NANOSECONDS.toMillis(end - start)
}