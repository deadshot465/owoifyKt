package utility

fun <T> interleaveArrays(a: Sequence<T>, b: Sequence<T>): List<T> {
    val arr = mutableListOf<T>()
    var observed = a.toMutableList()
    var other = b.toMutableList()
    var temp = mutableListOf<T>()

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