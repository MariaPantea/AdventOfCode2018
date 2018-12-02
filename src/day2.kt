fun main(args: Array<String>) {

    val boxIds = readFileToList(path + "input2")

    // First star
    var twoTimes = 0
    var threeTimes = 0

    var sortedBoxIds = boxIds.sorted()
    twoTimes = sortedBoxIds.filter { hasExactly(2, it) }.size
    threeTimes = sortedBoxIds.filter { hasExactly(3, it) }.size
    println(twoTimes * threeTimes)

    // Second star
    for (i: Int in 0 until boxIds[0].length) {
        var ids = boxIds.map { it -> it.removeRange(i, i + 1) }
        var equals = getEqualStrings(ids)
        if (equals.isNotEmpty()) {
            println(equals)
        }
    }
}

fun hasExactly(i: Int, boxId: String): Boolean {
    var sortedID = boxId.toCharArray().sorted()
    return sortedID.groupingBy { it }.eachCount().filter { it.value == i }.isNotEmpty()
}

fun getEqualStrings(strings: List<String>): Set<String> {
    val groupedBoxIDs = strings.groupingBy { it }.eachCount().filter { it.value > 1 }
    return groupedBoxIDs.keys
}


