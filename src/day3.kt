var fabric = Array(1300) { IntArray(1300) }
var overlappingInches = 0

fun main(args: Array<String>) {

    val fabricPieces = readFileToList(path + "input3")

    fabricPieces.map { it -> cutFabric(it, true) }

    //println(fabric.map { it -> it.map { it } })

    for (row: IntArray in fabric) {
        overlappingInches += row.filter { it == -1 }.size

    }
    println("Overlapping inches: $overlappingInches")

    fabricPieces.map { it -> cutFabric(it, false) }


}


fun cutFabric(pieceOfFabric: String, firstStar: Boolean) {

    val subStrings = pieceOfFabric.split(' ')

    val id = subStrings[0].drop(1).toInt()
    val startWidth = subStrings[2].takeWhile { it != ',' }.toInt()
    val startHeight = subStrings[2].dropWhile { it != ',' }.drop(1).dropLast(1).toInt()
    val width = subStrings[3].takeWhile { it != 'x' }.toInt()
    val height = subStrings[3].dropWhile { it != 'x' }.drop(1).toInt()

    //println("$id, $startHeight, $startWidth, $width, $height")

    if (firstStar) {
        for (row: Int in startWidth until startWidth + width) {
            for (col: Int in startHeight until startHeight + height) {
                fabric[row][col] = if (fabric[row][col] == 0) id else -1
            }
        }
    }else{
        var isOverlapping = false
        for (row: Int in startWidth until startWidth + width) {
            for (col: Int in startHeight until startHeight + height) {
                if (fabric[row][col] == -1) {
                    isOverlapping = true
                    break
                }
            }
        }
        if (!isOverlapping) println("Not overlapping $id")
    }


}
