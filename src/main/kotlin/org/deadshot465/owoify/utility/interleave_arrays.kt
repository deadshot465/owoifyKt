package org.deadshot465.owoify.utility

/**
 * Helper function to interleave and combine a sequence of strings and a sequence of spaces.
 * @param a The first sequence.
 * @param b The second sequence.
 * @return An interleaved list.
 */
fun <T> interleaveArrays(a: Sequence<T>, b: Sequence<T>): List<T> {
    val arr = mutableListOf<T>()
    var observed = a.toMutableList()
    var other = b.toMutableList()
    var temp: MutableList<T>

    while (observed.isNotEmpty()) {
        arr.add(observed.removeAt(0))
        temp = observed
        observed = other
        other = temp
    }

    if (other.isNotEmpty()) {
        arr.addAll(other)
    }
    return arr
}